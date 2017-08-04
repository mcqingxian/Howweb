package com.hoau.how.module.obh.server.service.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hoau.hbdp.framework.exception.BusinessException;
import com.hoau.hbdp.framework.shared.util.string.StringUtil;
import com.hoau.how.module.bse.server.service.company.ICompanyMatchService;
import com.hoau.how.module.bse.shared.vo.DepartmentVo;
import com.hoau.how.module.common.constants.OrderConstants;
import com.hoau.how.module.itf.server.service.IOmsOrderService;
import com.hoau.how.module.itf.server.ws.omsorder.CustomerServicePortType;
import com.hoau.how.module.itf.server.ws.omsorder.EiNetOrderReq;
import com.hoau.how.module.itf.server.ws.omsorder.EiNetOrderReqModel;
import com.hoau.how.module.itf.server.ws.omsorder.ObjectFactory;
import com.hoau.how.module.obh.server.dao.NetOrderDao;
import com.hoau.how.module.obh.server.service.IMyOrdersService;
import com.hoau.how.module.obh.shared.domain.CustomerContactEntity;
import com.hoau.how.module.obh.shared.domain.NetOrderEntity;
import com.hoau.how.module.obh.shared.util.Verhoeff;
import com.hoau.how.module.obh.shared.vos.MyOrdersVo;
import com.hoau.how.module.obh.shared.vos.QueryOrderVo;
import com.hoau.how.module.util.JsonUtils;
import com.hoau.how.module.util.excel.POIExcelUtil;

/**
 * @author：龙海仁
 * @create：2015年8月3日 下午2:47:38
 * @description：
 */
@Service
public class MyOrdersService implements IMyOrdersService {

	private Logger logger = Logger.getLogger(MyOrdersService.class);
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	@Resource
	private NetOrderDao netOrderDao;
	@Resource
	IOmsOrderService omsOrderService;
	@Resource
	private ICompanyMatchService companyMatchService;
	
	/* 
	 * 修改未处理订单状态
	 * (non-Javadoc)
	 * @see com.hoau.how.module.obh.server.service.IMyOrdersService#updateOrderStatus(java.lang.Integer)
	 */
	@Transactional
	@Override
	public void updateOrderStatus(Integer orderId,Long long1) {
		try {
			NetOrderEntity netOrder = netOrderDao.queryOrderDetail(orderId,long1);
			//订单状态设为取消
			netOrder.setEinoStatus(OrderConstants.ORDER_STATUS_KEYS.VOID);
			//update oms status
			CustomerServicePortType port = omsOrderService.getCustomerService();
			EiNetOrderReqModel netReqOrder = new EiNetOrderReqModel();
			//值转换
			copyNetOrderToEiNetOrder(netOrder, netReqOrder, omsOrderService.getObjectFactory());
			//修改OMS订单状态
			EiNetOrderReq resp = port.updateNetOrder(netReqOrder);
			logger.info(JsonUtils.toJson(resp));
			//TODO
//			if(resp != null && !resp.getResult().getValue()){
//				logger.info(resp.getResultInfo());
//			}else{
				//修改本地订单状态
				netOrderDao.updateOrder(netOrder);
//			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
	}

	/* 
	 * 删除草稿订单
	 * (non-Javadoc)
	 * @see com.hoau.how.module.obh.server.service.IMyOrdersService#deleteOrder(java.lang.Integer)
	 */
	@Transactional
	@Override
	public void deleteOrder(Integer orderId,Long long1) {
		try {
			netOrderDao.deleteOrder(orderId,long1);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<MyOrdersVo> getPrintOrders(String orderIdList,Long long1) {
		List<MyOrdersVo> orders = new ArrayList<MyOrdersVo>();
		List<NetOrderEntity> netOrderEntitys = new ArrayList<NetOrderEntity>();
		try {
			String[] orderIdArr = orderIdList.split(",");
			//查询订单信息
			for(String orderId : orderIdArr){
				NetOrderEntity entity = netOrderDao.queryOrderDetail(Integer.parseInt(orderId),long1);
				netOrderEntitys.add(entity);
			}
			//生成条码
			orders = generateBarCode(toMyOrderVo(netOrderEntitys));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return orders;
	}
	
	private List<MyOrdersVo> generateBarCode(List<MyOrdersVo> orders){
		List<MyOrdersVo> list = new ArrayList<MyOrdersVo>();
		for(MyOrdersVo order : orders){
			String temp = "";
			List<String> barCodes = new ArrayList<String>();
			for(int i=1;i<=order.getGoodsCount();i++){
				if(OrderConstants.ORDER_PRODUCTTYPE_KEYS.LESSLOADED.equals(order.getProductType())){
					temp = "101" + order.getWayBill() + String.format("%04d", i);
				}else if(OrderConstants.ORDER_PRODUCTTYPE_KEYS.ONTIME.equals(order.getProductType())){
					temp = "111" + order.getWayBill() + String.format("%04d", i);
				}
				barCodes.add(temp + Verhoeff.generateVerhoeff(temp));
			}
			order.setLabels(barCodes);
			list.add(order);
		}
		return list;
	}

	@Override
	public InputStream getExcel(CustomerContactEntity customer,	QueryOrderVo queryVo) {
		if(queryVo == null){
			queryVo = new QueryOrderVo();
		}
		queryVo.setCustomerId(customer.getEbccId());
		
		String path = genFile(queryVo);

		InputStream is = null;
		try {
			is = new FileInputStream(path);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return is;
	}

	private String genFile(QueryOrderVo queryVo) {
		String rtn = null;
		
		Map<String, String> maps = new LinkedHashMap<String, String>();
		//订单信息
		maps.put("einoId", "编号");
//		maps.put("einoOrderNo", "OMS订单号");
		maps.put("einoContractNo", "网厅订单号");
		maps.put("einoEbccName", "客户名称");
		maps.put("einoOrderDate", "下单日期");
		//发货人信息
		maps.put("einoShipperEbsaContact", "发货人");
		maps.put("einoShipperEbsaMobile", "发货人手机");
		maps.put("einoShipperEbsaTel", "发货人电话");
		
		maps.put("einoShipperEbpvName", "发货人省");
		maps.put("einoShipperEbplNameCn", "发货人市");
		maps.put("einoShipperAreaName", "发货人区/县");
		
		maps.put("einoShipperEbsaAddress", "发货人地址");
		maps.put("einoEscoSecondCode", "发货网点代码");
		maps.put("einoEscoSecondName", "发货网点");
		//收货人信息
		maps.put("einoConsigneeEbsaContact", "收货人");
		maps.put("einoConsigneeEbsaMobile", "收货人手机");
		maps.put("einoConsigneeEbsaTel", "收货人电话");
		
		maps.put("einoConsigneeEbpvName", "收货人省");
		maps.put("einoConsigneeEbplNameCn", "收货人市");
		maps.put("einoConsigneeEbrgNameCn", "收货人区/县");
		
		maps.put("einoConsigneeEbsaAddress", "收货人地址");
//		maps.put("einoConsigneeBranchesName", "收货网点代码");
//		maps.put("einoConsigneeBranchesName", "收货网点");
		//货物信息
		maps.put("einoCargoName", "货物名称");
		maps.put("einoInsurance", "保价声明");
		maps.put("einoPackage", "货物包装");
		maps.put("einoNumber", "货物件数");
		maps.put("einoTotalWeight", "货物重量");
		maps.put("einoTotalVolume", "货物体积");
		//服务信息
		maps.put("einoTransNo", "运单号");
		maps.put("einoProductTypeName", "运输方式");
		maps.put("einoShipperMethod", "送货方式");
		maps.put("einoPaymentMethod", "付款方式");
		maps.put("einoCollDeliveryAmount", "代收货款");
		maps.put("einoSmsNotif", "短信通知");
		maps.put("einoStatus", "当前状态");
		maps.put("einoSignBack", "签单返回");
		maps.put("einoRemark", "备注");
		
		Properties props = System.getProperties();
		String USER_HOME = props.getProperty("user.home");
		
		rtn = USER_HOME + "/excelExport.xlsx";
		File file = new File(rtn);

		List<NetOrderEntity> list = netOrderDao.queryOrderList(queryVo);

		POIExcelUtil.excelExport(maps, handlerNetOrders(list), file);
		
		return rtn;
	}


	@Override
	public NetOrderEntity queryOrderDetail(Integer orderId,Long long1) {
		NetOrderEntity entity = netOrderDao.queryOrderDetail(orderId,long1);
		//处理收发货人省市区
		String shipperDistrict = "";
		if(StringUtil.isNotEmpty(entity.getEinoShipperEbpvName())){
			shipperDistrict = entity.getEinoShipperEbpvName();
		}
		if(StringUtil.isNotEmpty(entity.getEinoShipperEbplNameCn())){
			shipperDistrict += "-" + entity.getEinoShipperEbplNameCn();
		}
		if(StringUtil.isNotEmpty(entity.getEinoShipperAreaName())){
			shipperDistrict += "-" + entity.getEinoShipperAreaName();
		}
		entity.setShipperDistrict(shipperDistrict);
		
		String consigneeDistrict = "";
		if(StringUtil.isNotEmpty(entity.getEinoConsigneeEbpvName())){
			consigneeDistrict = entity.getEinoConsigneeEbpvName();
		}
		if(StringUtil.isNotEmpty(entity.getEinoConsigneeEbplNameCn())){
			consigneeDistrict += "-" + entity.getEinoConsigneeEbplNameCn();
		}
		if(StringUtil.isNotEmpty(entity.getEinoConsigneeEbrgNameCn())){
			consigneeDistrict += "-" + entity.getEinoConsigneeEbrgNameCn();
		}
		entity.setConsigneeDistrict(consigneeDistrict);
		
		entity.setEinoInsurance(entity.getEinoInsurance()==null?0:entity.getEinoInsurance());
		entity.setEinoNumber(entity.getEinoNumber()==null?0:entity.getEinoNumber());
		entity.setEinoTotalWeight(entity.getEinoTotalWeight()==null?0:entity.getEinoTotalWeight());
		entity.setEinoTotalVolume(entity.getEinoTotalVolume()==null?0:entity.getEinoTotalVolume());
		entity.setEinoCollDeliveryAmount(entity.getEinoCollDeliveryAmount()==null?new BigDecimal("0"):entity.getEinoCollDeliveryAmount());
		entity.setEinoShipperEbpvName(entity.getEinoShipperEbpvName()==null?"":entity.getEinoShipperEbpvName());
		entity.setEinoShipperEbplNameCn(entity.getEinoShipperEbplNameCn()==null?"":entity.getEinoShipperEbplNameCn());
		entity.setEinoShipperAreaName(entity.getEinoShipperAreaName()==null?"":entity.getEinoShipperAreaName());
		entity.setEinoShipperEbsaAddress(entity.getEinoShipperEbsaAddress()==null?"":entity.getEinoShipperEbsaAddress());
		entity.setEinoConsigneeEbpvName(entity.getEinoConsigneeEbpvName()==null?"":entity.getEinoConsigneeEbpvName());
		entity.setEinoConsigneeEbplNameCn(entity.getEinoConsigneeEbplNameCn()==null?"":entity.getEinoConsigneeEbplNameCn());
		entity.setEinoConsigneeEbrgNameCn(entity.getEinoConsigneeEbrgNameCn()==null?"":entity.getEinoConsigneeEbrgNameCn());
		entity.setEinoConsigneeEbsaAddress(entity.getEinoConsigneeEbsaAddress()==null?"":entity.getEinoConsigneeEbsaAddress());
		
		String secondDistrict = entity.getEinoSecondDistrict();
		if(secondDistrict != null && secondDistrict != ""){
			Map<String,String> map = new HashMap<String,String>();
			if(!StringUtil.isEmpty(secondDistrict)){
				String[] params = secondDistrict.split("-");
				if(params.length>1){
					map.put("province", params[0]);
					map.put("city",params[1]);
					if(params.length > 2){
						map.put("county",params[2]);
					}
					List<DepartmentVo> departmentVos = companyMatchService.queryDeptByDistrictName(map);
					for(DepartmentVo vo : departmentVos){
						if(vo.getLogistCode().equals(entity.getEinoEscoSecondCode())){
							entity.setCompanyMsg(vo.getAddressDetail() + "|" + vo.getPhone());
							break;
						}
					}
				}
			}
		}else{
			entity.setCompanyMsg("");
		}
		
		return entity;
	}

	@Override
	public List<MyOrdersVo> queryMyOrders(CustomerContactEntity customer, QueryOrderVo queryVo, Integer pageNo,
			Integer pageSize) {
		// 判断分页参数是否为空
		if (pageNo == null || pageSize == null) {
			throw new BusinessException();
		}
		if(queryVo == null){
			queryVo = new QueryOrderVo();
		}
		queryVo.setCustomerId(customer.getEbccId());
		queryVo.setPageSize(pageSize);
		queryVo.setOffset((pageNo-1) * pageSize);
		System.out.println(JsonUtils.toJson(queryVo));
		List<NetOrderEntity> list = netOrderDao.queryOrderList(queryVo);
		return toMyOrderVo(list);
	}
	
	

	@Override
	public Long queryMyOrdersCount(CustomerContactEntity customer,
			QueryOrderVo queryVo) {
		if(queryVo == null){
			queryVo = new QueryOrderVo();
		}
		queryVo.setCustomerId(customer.getEbccId());
		return netOrderDao.queryOrderCount(queryVo);
	}
	
	private List<NetOrderEntity> handlerNetOrders(List<NetOrderEntity> orders){
		List<NetOrderEntity> list = new ArrayList<NetOrderEntity>();
		for(NetOrderEntity order : orders){
			if(OrderConstants.ORDER_STATUS_KEYS.ADD.equals(order.getEinoStatus())){
				order.setEinoStatus("待受理");
			}else if(OrderConstants.ORDER_STATUS_KEYS.SUBMIT.equals(order.getEinoStatus())){
				order.setEinoStatus("已受理");
			}else if(OrderConstants.ORDER_STATUS_KEYS.ACCEPT.equals(order.getEinoStatus())){
				order.setEinoStatus("已接收");
			}else if(OrderConstants.ORDER_STATUS_KEYS.CANVASSING.equals(order.getEinoStatus())){
				order.setEinoStatus("已开单");
			}else if(OrderConstants.ORDER_STATUS_KEYS.DELIVER.equals(order.getEinoStatus())){
				order.setEinoStatus("已签收");
			}else if(OrderConstants.ORDER_STATUS_KEYS.VOID.equals(order.getEinoStatus())){
				order.setEinoStatus("已撤销");
			}else if(OrderConstants.ORDER_STATUS_KEYS.DRAFT.equals(order.getEinoStatus())){
				order.setEinoStatus("草稿");
			}else{
				order.setEinoStatus("其他");
			}
			
			if(OrderConstants.ORDER_PAYMENTWAY_KEYS.ARRIVE_PAYMENT.equals(order.getEinoPaymentMethod())){
				order.setEinoPaymentMethod("到付");
			}else if(OrderConstants.ORDER_PAYMENTWAY_KEYS.CASH.equals(order.getEinoPaymentMethod())){
				order.setEinoPaymentMethod("现付");
			}else if(OrderConstants.ORDER_PAYMENTWAY_KEYS.MONTHLY_STATEMENT.equals(order.getEinoPaymentMethod())){
				order.setEinoPaymentMethod("月结");
			}else{
				order.setEinoPaymentMethod("其他");
			}
			
			if(OrderConstants.ORDER_DELIVERYWAY_KEYS.SELF_TAKE.equals(order.getEinoShipperMethod())){
				order.setEinoShipperMethod("客户自提");
			}else if(OrderConstants.ORDER_DELIVERYWAY_KEYS.DOORSTEP.equals(order.getEinoShipperMethod())){
				order.setEinoShipperMethod("送货上门");
			}else if(OrderConstants.ORDER_DELIVERYWAY_KEYS.UPSTAIR.equals(order.getEinoShipperMethod())){
				order.setEinoShipperMethod("送货上楼");
			}else{
				order.setEinoShipperMethod("其他");
			}
			
			if("NOBACK".equals(order.getEinoSignBack())){
				order.setEinoSignBack("无需返单");
			}else if("CUSTORIGINAL".equals(order.getEinoSignBack())){
				order.setEinoSignBack("客户出库单原件返回");
			}else if("CUSTCOPY".equals(order.getEinoSignBack())){
				order.setEinoSignBack("客户出库单传真返回");
			}else if("SIGNCOPY".equals(order.getEinoSignBack())){
				order.setEinoSignBack("到货签收单传真返回");
			}else if("SIGNORIGINAL".equals(order.getEinoSignBack())){
				order.setEinoSignBack("到货签收单原件返回");
			}
			
			list.add(order);
		}
		return list;
	}
	
	/**
	 * 值转换
	 * @param entity
	 * @param reqModel
	 * @param objectFactory
	 * @author 龙海仁
	 * @date 2015年8月10日
	 * @update 
	 */
	public void copyNetOrderToEiNetOrder(NetOrderEntity entity, EiNetOrderReqModel reqModel,ObjectFactory objectFactory) {
		reqModel.setEinoEbccName(objectFactory.createEiNetOrderReqModelEinoEbccName(entity.getEinoEbccName()));
		reqModel.setEinoShipperEbsaMobile(objectFactory.createEiNetOrderReqModelEinoShipperEbsaMobile(entity.getEinoShipperEbsaMobile()));
		reqModel.setEinoConsigneeEbsaTel(objectFactory.createEiNetOrderReqModelEinoConsigneeEbsaTel(entity.getEinoConsigneeEbsaTel()));
		reqModel.setEinoShipperEbpvName(objectFactory.createEiNetOrderReqModelEinoShipperEbpvName(entity.getEinoShipperEbpvName()));
		reqModel.setEinoShipperEbplNameCn(objectFactory.createEiNetOrderReqModelEinoShipperEbplNameCn(entity.getEinoShipperEbplNameCn()));
		reqModel.setEinoShipperAreaName(objectFactory.createEiNetOrderReqModelEinoShipperAreaName(entity.getEinoShipperAreaName()));
		reqModel.setEinoEscoSecondCode(objectFactory.createEiNetOrderReqModelEinoEscoSecondCode(entity.getEinoEscoSecondCode()));
		reqModel.setEinoEscoSecondName(objectFactory.createEiNetOrderReqModelEinoEscoSecondName(entity.getEinoEscoSecondName()));
		reqModel.setEinoConsigneeEbsaContact(objectFactory.createEiNetOrderReqModelEinoConsigneeEbsaContact(entity.getEinoConsigneeEbsaContact()));
		reqModel.setEinoConsigneeEbsaMobile(objectFactory.createEiNetOrderReqModelEinoConsigneeEbsaMobile(entity.getEinoConsigneeEbsaMobile()));
		reqModel.setEinoConsigneeEbsaTel(objectFactory.createEiNetOrderReqModelEinoConsigneeEbsaTel(entity.getEinoConsigneeEbsaTel()));
		reqModel.setEinoConsigneeEbpvName(objectFactory.createEiNetOrderReqModelEinoConsigneeEbpvName(entity.getEinoConsigneeEbpvName()));
		reqModel.setEinoConsigneeEbplNameCn(objectFactory.createEiNetOrderReqModelEinoConsigneeEbplNameCn(entity.getEinoConsigneeEbplNameCn()));
		reqModel.setEinoConsigneeEbrgNameCn(objectFactory.createEiNetOrderReqModelEinoConsigneeEbrgNameCn(entity.getEinoConsigneeEbrgNameCn()));
		reqModel.setEinoConsigneeEbsaAddress(objectFactory.createEiNetOrderReqModelEinoConsigneeEbsaAddress(entity.getEinoConsigneeEbsaAddress()));
		reqModel.setEinoProductTypeName(objectFactory.createEiNetOrderReqModelEinoProductTypeName(entity.getEinoProductTypeName()));
		reqModel.setEinoDoorCanvass(objectFactory.createEiNetOrderReqModelEinoDoorCanvass(entity.getEinoDoorCanvass()));
		reqModel.setEinoShipperMethod(objectFactory.createEiNetOrderReqModelEinoShipperMethod(entity.getEinoShipperMethod()));
		reqModel.setEinoPaymentMethod(objectFactory.createEiNetOrderReqModelEinoPaymentMethod(entity.getEinoPaymentMethod()));
		reqModel.setEinoInsurance(objectFactory.createEiNetOrderReqModelEinoInsurance(entity.getEinoInsurance() == null ? 0 : entity.getEinoInsurance().doubleValue()));
		reqModel.setEinoCargoName(objectFactory.createEiNetOrderReqModelEinoCargoName(entity.getEinoCargoName()));
		reqModel.setEinoNumber(objectFactory.createEiNetOrderReqModelEinoNumber(entity.getEinoNumber() == null ? 0 : entity.getEinoNumber().intValue()));
		reqModel.setEinoTotalWeight(objectFactory.createEiNetOrderReqModelEinoTotalWeight(entity.getEinoTotalWeight() == null ? 0 : entity.getEinoTotalWeight().doubleValue()));
		reqModel.setEinoTotalVolume(objectFactory.createEiNetOrderReqModelEinoTotalVolume(entity.getEinoTotalVolume() == null ? 0 : entity.getEinoTotalVolume().doubleValue()));
		reqModel.setEinoPackage(objectFactory.createEiNetOrderReqModelEinoPackage(entity.getEinoPackage()));
		reqModel.setEinoCollDeliveryAmount(objectFactory.createEiNetOrderReqModelEinoCollDeliveryAmount(entity.getEinoCollDeliveryAmount() == null ? 0 : entity.getEinoCollDeliveryAmount().doubleValue()));
		reqModel.setEinoRemark(objectFactory.createEiNetOrderReqModelEinoRemark(entity.getEinoRemark()));
		reqModel.setEinoContractNo(objectFactory.createEiNetOrderReqModelEinoContractNo(entity.getEinoContractNo()));
		reqModel.setEinoCustomerCode(objectFactory.createEiNetOrderReqModelEinoCustomerCode(entity.getEinoCustomerCode()));
		reqModel.setEinoStatus(objectFactory.createEiNetOrderReqModelEinoStatus(entity.getEinoStatus()));
	}

	public List<MyOrdersVo> toMyOrderVo(List<NetOrderEntity> netOrders) {
		List<MyOrdersVo> myOrders = new ArrayList<MyOrdersVo>();
		for (NetOrderEntity entity : netOrders) {
			MyOrdersVo order = new MyOrdersVo();
			order.setChargeTotal(entity.getEinoChargeTotal()==null?0:entity.getEinoChargeTotal().doubleValue());
			//发货人姓名
			order.setConsignerName(entity.getEinoShipperEbsaContact());
			//收货人姓名
			order.setConsigneeName(entity.getEinoConsigneeEbsaContact());
			//收货人手机
			order.setConsigneePhone(entity.getEinoConsigneeEbsaMobile());
			order.setGoodsCount(Integer.valueOf(entity.getEinoNumber()==null?"0":entity.getEinoNumber().toString()));
			order.setGoodsName(entity.getEinoCargoName());
			order.setOrderDate(entity.getEinoOrderDate()==null?"":sdf.format(entity.getEinoOrderDate()));
			order.setOrderId(Integer.valueOf(entity.getEinoId()==null?"":entity.getEinoId().toString()));
			order.setOrderNo(entity.getEinoOrderNo());
			order.setOrderStatus(entity.getEinoStatus());
			order.setPaymentWay(entity.getEinoPaymentMethod());
			order.setWayBill(entity.getEinoTransNo());
			//起运地
			order.setDeparture(entity.getEinoEscoSecondName());
			//目的地
			order.setDestination(entity.getEinoConsigneeBranchesName());
			//收货人地址
			order.setConsigneeAddess(entity.getEinoConsigneeEbsaAddress());
			order.setConsigneeTel(entity.getEinoConsigneeEbsaTel());
			order.setDeliveryWay(entity.getEinoShipperMethod());
			order.setProductType(entity.getEinoProductTypeName());
			order.setContractNo(entity.getEinoContractNo());
			order.setNumber(entity.getNumber());
			
			order.setConsigneeProvince(entity.getEinoConsigneeEbpvName());
			order.setConsigneeCity(entity.getEinoConsigneeEbplNameCn());
			
			myOrders.add(order);
		}
		return myOrders;
	}

}
