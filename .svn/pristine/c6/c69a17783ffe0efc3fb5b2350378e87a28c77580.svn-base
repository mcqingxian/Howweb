package com.hoau.how.module.obh.server.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.annotation.Resource;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.springframework.stereotype.Service;

import com.hoau.hbdp.framework.exception.BusinessException;
import com.hoau.hbdp.framework.shared.util.string.StringUtil;
import com.hoau.how.module.common.constants.OrderConstants;
import com.hoau.how.module.itf.server.ws.omsorder.EiNetOrderReqModel;
import com.hoau.how.module.itf.server.ws.omsorder.ObjectFactory;
import com.hoau.how.module.obh.server.dao.NetOrderDao;
import com.hoau.how.module.obh.server.service.IContactsService;
import com.hoau.how.module.obh.server.service.IMyOrdersService;
import com.hoau.how.module.obh.server.service.IOrderService;
import com.hoau.how.module.obh.shared.constants.Constants;
import com.hoau.how.module.obh.shared.domain.ContactsEntity;
import com.hoau.how.module.obh.shared.domain.NetOrderEntity;
import com.hoau.how.module.obh.shared.domain.QuickOrderEntity;
import com.hoau.how.module.obh.shared.vos.MyOrdersVo;
import com.hoau.how.module.util.UUIDGenerator;

/**
 * @author：莫涛
 * @create：2015年7月27日 上午9:37:50
 * @description：
 */
@Service
public class OrderService implements IOrderService {
	@Resource
	NetOrderDao netOrderDao;
	@Resource
	private IMyOrdersService myOrderService;
	@Resource
	private IContactsService contactsService;
	
	
	@Override
	public void saveContacts(NetOrderEntity entity) {
		try {
			List<ContactsEntity> contacts = handleContacts(entity);
			for(ContactsEntity contact : contacts){
				ContactsEntity con = contactsService.queryContact(contact);
				if(con == null){
					contactsService.addContacts(contact);
				}
			}
		} catch (Exception e) {
		}
	}
	
	private List<ContactsEntity> handleContacts(NetOrderEntity entity){
		List<ContactsEntity> list = new ArrayList<ContactsEntity>();
		
		ContactsEntity contact = new ContactsEntity();
		contact.setCreator(String.valueOf(entity.getEinoEbccId()));
		contact.setModifier(String.valueOf(entity.getEinoEbccId()));
		contact.setEbsaEbcuId(Long.valueOf(entity.getEinoEbccId()));
		contact.setEbsaContact(entity.getEinoShipperEbsaContact());
		contact.setEbsaMobile(entity.getEinoShipperEbsaMobile());
		String tel = entity.getEinoShipperEbsaTel();
		String[] tels = null;
		if(StringUtil.isNotEmpty(tel) && tel.contains("-")){
			tels = tel.split("-");
			if(tels.length>1){
				contact.setEbsaContactAreaCode(tels[0]);
				contact.setEbsaContactTel(tels[1]);
			}
		}else{
			contact.setEbsaContactTel(entity.getEinoShipperEbsaTel());
		}
		
		contact.setEbsaEbpvName(entity.getEinoShipperEbpvName());
		contact.setEbsaEbplName(entity.getEinoShipperEbplNameCn());
		contact.setEbsaEbcoName(entity.getEinoShipperAreaName());
		contact.setEbsaAddress(entity.getEinoShipperEbsaAddress());
		contact.setEbsaType("shipper");
		contact.setEbsaDeptDistrict(entity.getShipperDistrict());
		contact.setEbsaEscoSecondCode(entity.getEinoEscoSecondCode());
		contact.setEbsaEscoSecondName(entity.getEinoEscoSecondName());
		contact.setEbsaCompany(entity.getEinoShipperEbspNameCn());
		list.add(contact);
		
		contact = new ContactsEntity();
		contact.setCreator(String.valueOf(entity.getEinoEbccId()));
		contact.setModifier(String.valueOf(entity.getEinoEbccId()));
		contact.setEbsaEbcuId(Long.valueOf(entity.getEinoEbccId()));
		contact.setEbsaContact(entity.getEinoConsigneeEbsaContact());
		contact.setEbsaMobile(entity.getEinoConsigneeEbsaMobile());
		
		tel = entity.getEinoConsigneeEbsaTel();
		if(StringUtil.isNotEmpty(tel) && tel.contains("-")){
			tels = tel.split("-");
			if(tels.length>1){
				contact.setEbsaContactAreaCode(tels[0]);
				contact.setEbsaContactTel(tels[1]);
			}
		}else{
			contact.setEbsaContactTel(entity.getEinoConsigneeEbsaTel());
		}
		
		contact.setEbsaEbpvName(entity.getEinoConsigneeEbpvName());
		contact.setEbsaEbplName(entity.getEinoConsigneeEbplNameCn());
		contact.setEbsaEbcoName(entity.getEinoConsigneeEbrgNameCn());
		
		contact.setEbsaAddress(entity.getEinoConsigneeEbsaAddress());
		contact.setEbsaType("consignee");
		contact.setEbsaDeptDistrict(entity.getConsigneeDistrict());
		
		list.add(contact);
		return list;
	}

	@Override
	public List<MyOrdersVo> queryQuickOrder(QuickOrderEntity entity) {
		List<NetOrderEntity> netOrders = new ArrayList<NetOrderEntity>();
		if(entity == null || entity.getPageNo() == null || entity.getPageSize() == null){
			throw new BusinessException();
		}
		entity.setOffset((entity.getPageNo()-1)*entity.getPageSize());
		netOrders = netOrderDao.queryQuickOrder(entity);
		return myOrderService.toMyOrderVo(netOrders);
	}

	@Override
	public Integer countQuickOrder(QuickOrderEntity entity) {
		if(entity == null || entity.getPageNo() == null || entity.getPageSize() == null){
			throw new BusinessException();
		}
		Integer totalCount = netOrderDao.countQuickOrder(entity);
		if(totalCount%entity.getPageSize()==0){
			return totalCount/entity.getPageSize();
		}else{
			return totalCount/entity.getPageSize()+1;
		}
	}


	@Override
	public NetOrderEntity queryOneOrder(Integer cbccId,Long long1) {
		NetOrderEntity entity = netOrderDao.queryOrderDetail(cbccId,long1);
		entity.setEinoEbccId(null);
		entity.setEinoId(null);
		entity.setEinoStatus(null);
		// 处理收发货人省市区
		String shipperDistrict = "";
		if (StringUtil.isNotEmpty(entity.getEinoShipperEbpvName())) {
			shipperDistrict = entity.getEinoShipperEbpvName();
		}
		if (StringUtil.isNotEmpty(entity.getEinoShipperEbplNameCn())) {
			shipperDistrict += "-" + entity.getEinoShipperEbplNameCn();
		}
		if (StringUtil.isNotEmpty(entity.getEinoShipperAreaName())) {
			shipperDistrict += "-" + entity.getEinoShipperAreaName();
		}
		entity.setShipperDistrict(shipperDistrict);

		String consigneeDistrict = "";
		if (StringUtil.isNotEmpty(entity.getEinoConsigneeEbpvName())) {
			consigneeDistrict = entity.getEinoConsigneeEbpvName();
		}
		if (StringUtil.isNotEmpty(entity.getEinoConsigneeEbplNameCn())) {
			consigneeDistrict += "-" + entity.getEinoConsigneeEbplNameCn();
		}
		if (StringUtil.isNotEmpty(entity.getEinoConsigneeEbrgNameCn())) {
			consigneeDistrict += "-" + entity.getEinoConsigneeEbrgNameCn();
		}
		entity.setConsigneeDistrict(consigneeDistrict);
		return entity;
	}

	@Override
	public void saveDraft(NetOrderEntity entity) {
		//处理收发货人省市
		handleDistrict(entity);
		String orderUuid = UUIDGenerator.getOrderIdByUUId();
		entity.setEinoContractNo("NO"+orderUuid);
		entity.setEinoCustomEbcuNameCn(orderUuid);
		entity.setEinoStatus(OrderConstants.ORDER_STATUS_KEYS.DRAFT);
		this.netOrderDao.saveOrder(entity);
	}
	
	@Override
	public void updateDraft(NetOrderEntity entity) {
		//处理收发货人省市
		handleDistrict(entity);
		this.netOrderDao.updateOrder(entity);
	}
	
	@Override
	public void createOrder(NetOrderEntity entity){
		entity.setEinoStatus(OrderConstants.ORDER_STATUS_KEYS.ADD);
//		entity.setEinoOrderDate(new Date());
		if(entity.getEinoOrign() == null || entity.getEinoOrign().equals("")){
			entity.setEinoOrign("NET_ORDER");
		}
		//处理收发货人省市
		handleDistrict(entity);
		//如果该订单非草稿，则需要生成订单号，并且保存订单，否则更新订单信息
		if(entity.getEinoId() == null || entity.getEinoId().equals("")){
			if(entity.getEinoContractNo() == null || entity.getEinoContractNo().equals("")){
				entity.setEinoContractNo("NO"+UUIDGenerator.getOrderIdByUUId());
			}
			this.netOrderDao.saveOrder(entity);
		}else{
			this.netOrderDao.updateOrder(entity);
		}
	}
	
	@Override
	public void createBatchOrder(NetOrderEntity entity){
		entity.setEinoStatus(OrderConstants.ORDER_STATUS_KEYS.ADD);
		entity.setEinoOrderDate(new Date());
		if(entity.getEinoOrign() == null || entity.getEinoOrign().equals("")){
			entity.setEinoOrign("NET_ORDER");
		}
		//处理收发货人省市
		handleDistrict(entity);
		if(entity.getEinoContractNo() == null || entity.getEinoContractNo().equals("")){
			entity.setEinoContractNo("NO"+UUIDGenerator.getOrderIdByUUId());
		}
		this.netOrderDao.saveOrder(entity);
	}
	
	@Override
	public void updateOrder(NetOrderEntity entity) {
		entity.setModifyTime(new Date());
		// 处理收发货人省市
		handleDistrict(entity);
		//修改本地订单
		this.netOrderDao.updateOrder(entity);
	}

	/**
	 * 处理收发货人所在省市
	 * @param entity
	 * @author 莫涛
	 * @date 2015年7月30日
	 * @update
	 */
	private void handleDistrict(NetOrderEntity entity){
		String shipperDistrict = entity.getShipperDistrict();
		String consigneeDistrict = entity.getConsigneeDistrict();
		if(shipperDistrict != null && !shipperDistrict.equals("") && !shipperDistrict.equals("请选择所在省市")){
			String[] sd = shipperDistrict.split("-");
			if(sd.length < 3){
				entity.setEinoShipperEbpvName(sd[0]);
				entity.setEinoShipperEbplNameCn(sd[1]);
			}else if(sd.length == 3){
				entity.setEinoShipperEbpvName(sd[0]);
				entity.setEinoShipperEbplNameCn(sd[1]);
				entity.setEinoShipperAreaName(sd[2]);
			}
		}
		if(consigneeDistrict != null && !consigneeDistrict.equals("") && !shipperDistrict.equals("请选择所在省市")){
			String[] cd = consigneeDistrict.split("-");
			if(cd.length < 3){
				entity.setEinoConsigneeEbpvName(cd[0]);
				entity.setEinoConsigneeEbplNameCn(cd[1]);
			}else if(cd.length == 3){
				entity.setEinoConsigneeEbpvName(cd[0]);
				entity.setEinoConsigneeEbplNameCn(cd[1]);
				entity.setEinoConsigneeEbrgNameCn(cd[2]);
			}
		}
	}

	@Override
	public void copyNetOrderToEiNetOrder(NetOrderEntity entity, EiNetOrderReqModel reqModel,ObjectFactory objectFactory,int batchOrder) {
		String tel =  entity.getEinoShipperEbsaTel();
		String[] tels = null;
		if(tel != null){
			if(StringUtil.isNotEmpty(tel) && tel.contains("-")){
				tels = tel.split("-");
				if(tels.length>1){
					entity.setEinoShipperEbsaAreaCode(tels[0]);
					entity.setEinoShipperEbsaTel(tels[1]);
				}
			}else if(tel.length() > 0 && tel.length() < 10){
				entity.setEinoShipperEbsaTel(tel);
			}else{
				entity.setEinoShipperEbsaTel("");
			}
		}
		tel =  entity.getEinoConsigneeEbsaTel();
		if(tel != null){
			if(StringUtil.isNotEmpty(tel) && tel.contains("-")){
				tels = tel.split("-");
				if(tels.length>1){
					entity.setEinoConsigneeEbsaAreaCode(tels[0]);
					entity.setEinoConsigneeEbsaTel(tels[1]);
				}
			}else if(tel.length() > 0 && tel.length() < 10){
				entity.setEinoConsigneeEbsaTel(tel);
			}else{
				entity.setEinoConsigneeEbsaTel("");
			}
		}
		if(entity.getEinoEbccId() != null){
			reqModel.setEinoEbccId(objectFactory.createEiNetOrderReqModelEinoEbccId(entity.getEinoEbccId().intValue()));
		}
		reqModel.setEinoShipperEbspNameCn(objectFactory.createEiNetOrderReqModelEinoShipperEbspNameCn(entity.getEinoShipperEbspNameCn()));
		reqModel.setEinoShipperEbsaAreaCode(objectFactory.createEiNetOrderReqModelEinoShipperEbsaAreaCode(entity.getEinoShipperEbsaAreaCode()));
		reqModel.setEinoShipperEbsaTel(objectFactory.createEiNetOrderReqModelEinoShipperEbsaTel(entity.getEinoShipperEbsaTel()));
		reqModel.setEinoConsigneeEbsaAreaCode(objectFactory.createEiNetOrderReqModelEinoConsigneeEbsaAreaCode(entity.getEinoConsigneeEbsaAreaCode()));
		reqModel.setEinoConsigneeEbsaTel(objectFactory.createEiNetOrderReqModelEinoConsigneeEbsaTel(entity.getEinoConsigneeEbsaTel()));
		
		reqModel.setEinoEbccName(objectFactory.createEiNetOrderReqModelEinoEbccName(entity.getEinoEbccName()));
		reqModel.setEinoShipperEbsaMobile(objectFactory.createEiNetOrderReqModelEinoShipperEbsaMobile(entity.getEinoShipperEbsaMobile()));
		reqModel.setEinoShipperEbpvName(objectFactory.createEiNetOrderReqModelEinoShipperEbpvName(entity.getEinoShipperEbpvName()));
		reqModel.setEinoShipperMethod(objectFactory.createEiNetOrderReqModelEinoShipperMethod(entity.getEinoShipperMethod()));
		reqModel.setEinoShipperEbplNameCn(objectFactory.createEiNetOrderReqModelEinoShipperEbplNameCn(entity.getEinoShipperEbplNameCn()));
		reqModel.setEinoShipperAreaName(objectFactory.createEiNetOrderReqModelEinoShipperAreaName(entity.getEinoShipperAreaName()));
		reqModel.setEinoShipperEbsaAddress(objectFactory.createEiNetOrderReqModelEinoShipperEbsaAddress(entity.getEinoShipperEbsaAddress()));
		reqModel.setEinoShipperEbsaContact(objectFactory.createEiNetOrderReqModelEinoShipperEbsaContact(entity.getEinoShipperEbsaContact()));
		reqModel.setEinoShipperEbsaTel(objectFactory.createEiNetOrderReqModelEinoShipperEbsaTel(entity.getEinoShipperEbsaTel()));
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
		XMLGregorianCalendar xgcal = null;
		try {
			xgcal = DatatypeFactory.newInstance().newXMLGregorianCalendar(new GregorianCalendar());
		} catch (DatatypeConfigurationException e) {
			e.printStackTrace();
		}
		reqModel.setEinoOrderDate(xgcal);
		
		//订单来源
		reqModel.setEinoOrign(objectFactory.createEiNetOrderReqModelEinoOrign(entity.getEinoOrign()));
		//异常类型
		reqModel.setEinoExceptionType(objectFactory.createEiNetOrderReqModelEinoExceptionType("NORMAL"));
		reqModel.setEinoSignBack(objectFactory.createEiNetOrderReqModelEinoSignBack(entity.getEinoSignBack()));
		reqModel.setEinoBatchOrder(objectFactory.createEiNetOrderReqModelEinoBatchOrder(batchOrder));
	}

	@Override
	public void saveNetOrder() {
		
	}
	
}