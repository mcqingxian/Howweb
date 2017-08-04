package com.hoau.wechat.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import com.hoau.wechat.constant.OMSConstants;
import com.hoau.wechat.entity.OrderEntity;
import com.hoau.wechat.exception.OMSServiceException;
import com.hoau.wechat.service.IOrderManagerService;
import com.hoau.wechat.service.OMSInterfaceService;
import com.hoau.wechat.ws.oms.ArrayOfQueryOrderModel;
import com.hoau.wechat.ws.oms.CancelOrderReqModel;
import com.hoau.wechat.ws.oms.CancelOrderResModel;
import com.hoau.wechat.ws.oms.GetPhoneOrderReqModel;
import com.hoau.wechat.ws.oms.GetPhoneOrderResModel;
import com.hoau.wechat.ws.oms.ModifyOrderReqModel;
import com.hoau.wechat.ws.oms.ModifyOrderResModel;
import com.hoau.wechat.ws.oms.PhoneOrderReqModel;
import com.hoau.wechat.ws.oms.PhoneOrderResModel;
import com.hoau.wechat.ws.oms.QueryOrderModel;
import com.hoau.wechat.ws.oms.QueryOrdersReqModel;
import com.hoau.wechat.ws.oms.QueryOrdersResModel;
import com.sun.org.apache.xerces.internal.jaxp.datatype.XMLGregorianCalendarImpl;

/**
 * 订单管理服务类
 * 
 * @author gaojia
 * 
 */
@Service
public class OrderManagerService extends OMSInterfaceService implements
		IOrderManagerService {
	private static Log log = LogFactory.getLog(OrderManagerService.class);

	@Override
	public OrderEntity submitOrder(OrderEntity order, String userId) {
		PhoneOrderReqModel orderReq = new PhoneOrderReqModel();
		orderReq.setConsigneeAddress(objectFactory
				.createPhoneOrderReqModelConsigneeAddress(order
						.getConsigneeAddress()));
		orderReq.setConsigneeCity(objectFactory
				.createPhoneOrderReqModelConsigneeCity(order.getConsigneeCity()));
		orderReq.setConsigneeMobile(objectFactory
				.createPhoneOrderReqModelConsigneeMobile(order
						.getConsigneeMobile()));
		orderReq.setConsigneeName(objectFactory
				.createPhoneOrderReqModelConsigneeName(order.getConsigneeName()));
		orderReq.setConsigneeProv(objectFactory
				.createPhoneOrderReqModelConsigneeProv(order.getConsigneeProv()));

		orderReq.setProductType(objectFactory
				.createPhoneOrderReqModelProductType(OMSConstants.DEFAULT_PRODUCT_TYPE_CODE));

		orderReq.setShipperAddress(objectFactory
				.createPhoneOrderReqModelShipperAddress(order
						.getShipperAddress()));
		orderReq.setShipperCity(objectFactory
				.createPhoneOrderReqModelShipperCity(order.getShipperCity()));
		orderReq.setShipperMethod(objectFactory
				.createPhoneOrderReqModelShipperMethod(order.getShipperMethod()));
		orderReq.setShipperMobile(objectFactory
				.createPhoneOrderReqModelShipperMobile(order.getShipperMobile()));
		orderReq.setShipperName(objectFactory
				.createPhoneOrderReqModelShipperName(order.getShipperName()));
		orderReq.setShipperProv(objectFactory
				.createPhoneOrderReqModelShipperProv(order.getShipperProv()));
		orderReq.setSmsNotify(objectFactory
				.createPhoneOrderReqModelSmsNotify("Y"));

		orderReq.setUserId(objectFactory.createPhoneOrderReqModelUserId(userId));

		orderReq.setCargoNumber(objectFactory
				.createPhoneOrderReqModelCargoNumber(1.0));
		orderReq.setCargoVolume(objectFactory
				.createPhoneOrderReqModelCargoVolume(1.0));
		orderReq.setCargoWeight(objectFactory
				.createPhoneOrderReqModelCargoWeight(1.0));
		/* 货物 */
		orderReq.setCargoName(objectFactory
				.createPhoneOrderReqModelCargoName("货物"));
		orderReq.setShipperMethod(objectFactory
				.createPhoneOrderReqModelShipperMethod(order.getShipperMethod()));
		orderReq.setConsigneeMethod(objectFactory
				.createPhoneOrderReqModelConsigneeMethod("Y"));
		orderReq.setConsigneeMethod(objectFactory
				.createPhoneOrderReqModelConsigneeMethod("Y"));
		/**
		 * 增加订单来源
		 * @update
		 * @author 275688
		 */
		orderReq.setOrderOrign(objectFactory
				.createPhoneOrderReqModelOrderOrign("WECHAT"));
		/**
		 * 添加区县和受理网点
		 * @date 2015-10-27
		 * @author 275636 275636
		 * */
		orderReq.setShipperEbrgNameCn(objectFactory.createPhoneOrderReqModelShipperEbrgNameCn(order.getShipperEbrgNameCn()));
		orderReq.setConsigneeEbrgNameCn(objectFactory.createPhoneOrderReqModelConsigneeEbrgNameCn(order.getConsigneeEbrgNameCn()));
		orderReq.setEscoSecondCode(objectFactory.createPhoneOrderReqModelEscoSecondCode(order.getEscoSecondCode()));
		orderReq.setEscoSecondName(objectFactory.createPhoneOrderReqModelEscoSecondName(order.getEscoSecondName()));
		
		PhoneOrderResModel res = portType.createOrder(orderReq);
		if (res.getResult().getValue()) {
			String orderNo = res.getPhoneOrderReqModel().getValue().getOrderNo()
					.getValue();
			order.setOrderNo(orderNo);
			return order;
		} else {
			throw new OMSServiceException(res.getResultCode().getValue(), res
					.getResultInfo().getValue());
		}
	}

	@Override
	public OrderEntity queryOrderDetail(String orderNo, String userId) {
		OrderEntity orderEntity = new OrderEntity();
		GetPhoneOrderReqModel req = new GetPhoneOrderReqModel();
		req.setOrderNo(objectFactory
				.createGetPhoneOrderReqModelOrderNo(orderNo));
		req.setUserid(objectFactory.createGetPhoneOrderReqModelUserid(userId));
		GetPhoneOrderResModel res = portType.queryOrderDetail(req);
		if (res.getResult().getValue()) {
			PhoneOrderReqModel resOrder = res.getQueryOrder().getValue();
			orderEntity.setConsigneeAddress(resOrder.getConsigneeAddress()
					.getValue());
			orderEntity
					.setConsigneeCity(resOrder.getConsigneeCity().getValue());
			orderEntity
					.setConsigneeName(resOrder.getConsigneeName().getValue());
			orderEntity
					.setConsigneeProv(resOrder.getConsigneeProv().getValue());
			orderEntity.setConsigneeMobile(resOrder.getConsigneeMobile()
					.getValue());

			orderEntity.setShipperAddress(resOrder.getShipperAddress()
					.getValue());
			orderEntity.setShipperCity(resOrder.getShipperCity().getValue());
			orderEntity
					.setShipperMethod(resOrder.getShipperMethod().getValue());
			orderEntity
					.setShipperMobile(resOrder.getShipperMobile().getValue());
			orderEntity.setShipperName(resOrder.getShipperName().getValue());
			orderEntity.setShipperProv(resOrder.getShipperProv().getValue());
			
			/**
			 * 添加区县和受理网点
			 * @date 2015-10-27
			 * @author 275636 275636
			 * */
			orderEntity.setShipperEbrgNameCn(resOrder.getShipperEbrgNameCn().getValue());
			orderEntity.setConsigneeEbrgNameCn(resOrder.getConsigneeEbrgNameCn().getValue());
			orderEntity.setEscoSecondCode(resOrder.getEscoSecondCode().getValue());
			orderEntity.setEscoSecondName(resOrder.getEscoSecondName().getValue());
			return orderEntity;
		} else {
			throw new OMSServiceException(res.getResultCode().getValue(), res
					.getResultInfo().getValue());
		}

	}

	@Override
	public void cancelOrder(String orderNo, String userId) {
		CancelOrderReqModel order = new CancelOrderReqModel();
		order.setOrderNo(objectFactory
				.createCancelOrderReqModelOrderNo(orderNo));
		order.setUserid(objectFactory.createCancelOrderReqModelUserid(userId));
		CancelOrderResModel res = portType.cancelPhoneOrde(order);
		if (!res.getResult().getValue()) {
			log.error(res.getResultCode().getValue()+":"+res
					.getResultInfo().getValue());
			throw new OMSServiceException(res.getResultCode().getValue(), res
					.getResultInfo().getValue());
		}

	}

	@Override
	public void modifyOrder(OrderEntity order, String userId) {
		ModifyOrderReqModel req = new ModifyOrderReqModel();
		PhoneOrderReqModel orderReq = new PhoneOrderReqModel();
		orderReq.setOrderNo(objectFactory.createPhoneOrderReqModelOrderNo(order
				.getOrderNo()));
		orderReq.setConsigneeAddress(objectFactory
				.createPhoneOrderReqModelConsigneeAddress(order
						.getConsigneeAddress()));
		orderReq.setConsigneeCity(objectFactory
				.createPhoneOrderReqModelConsigneeCity(order.getConsigneeCity()));
		orderReq.setConsigneeMobile(objectFactory
				.createPhoneOrderReqModelConsigneeMobile(order
						.getConsigneeMobile()));
		orderReq.setConsigneeName(objectFactory
				.createPhoneOrderReqModelConsigneeName(order.getConsigneeName()));
		orderReq.setConsigneeProv(objectFactory
				.createPhoneOrderReqModelConsigneeProv(order.getConsigneeProv()));

		orderReq.setProductType(objectFactory
				.createPhoneOrderReqModelProductType(OMSConstants.DEFAULT_PRODUCT_TYPE_CODE));

		orderReq.setShipperAddress(objectFactory
				.createPhoneOrderReqModelShipperAddress(order
						.getShipperAddress()));
		orderReq.setShipperCity(objectFactory
				.createPhoneOrderReqModelShipperCity(order.getShipperCity()));
		orderReq.setShipperMethod(objectFactory
				.createPhoneOrderReqModelShipperMethod(order.getShipperMethod()));
		orderReq.setShipperMobile(objectFactory
				.createPhoneOrderReqModelShipperMobile(order.getShipperMobile()));
		orderReq.setShipperName(objectFactory
				.createPhoneOrderReqModelShipperName(order.getShipperName()));
		orderReq.setShipperProv(objectFactory
				.createPhoneOrderReqModelShipperProv(order.getShipperProv()));
		orderReq.setSmsNotify(objectFactory
				.createPhoneOrderReqModelSmsNotify("Y"));

		orderReq.setUserId(objectFactory.createPhoneOrderReqModelUserId(userId));

		orderReq.setCargoNumber(objectFactory
				.createPhoneOrderReqModelCargoNumber(1.0));
		orderReq.setCargoVolume(objectFactory
				.createPhoneOrderReqModelCargoVolume(1.0));
		orderReq.setCargoWeight(objectFactory
				.createPhoneOrderReqModelCargoWeight(1.0));
		/* 货物 */
		orderReq.setCargoName(objectFactory
				.createPhoneOrderReqModelCargoName("货物"));
		orderReq.setShipperMethod(objectFactory
				.createPhoneOrderReqModelShipperMethod(order.getShipperMethod()));
		orderReq.setConsigneeMethod(objectFactory
				.createPhoneOrderReqModelConsigneeMethod("Y"));
		req.setModifyOrder(objectFactory
				.createModifyOrderReqModelModifyOrder(orderReq));
		/**
		 * 添加区县和受理网点
		 * @date 2015-10-27
		 * @author 275636 275636
		 * */
		orderReq.setShipperEbrgNameCn(objectFactory.createPhoneOrderReqModelShipperEbrgNameCn(order.getShipperEbrgNameCn()));
		orderReq.setConsigneeEbrgNameCn(objectFactory.createPhoneOrderReqModelConsigneeEbrgNameCn(order.getConsigneeEbrgNameCn()));
		orderReq.setEscoSecondCode(objectFactory.createPhoneOrderReqModelEscoSecondCode(order.getEscoSecondCode()));
		orderReq.setEscoSecondName(objectFactory.createPhoneOrderReqModelEscoSecondName(order.getEscoSecondName()));
		
		ModifyOrderResModel res = portType.modifyOrder(req);
		if (!res.getResult().getValue()) {
			throw new OMSServiceException(res.getResultCode().getValue(), res
					.getResultInfo().getValue());
		}
	}

	@Override
	public List<OrderEntity> queryOrder(String userId,int days) {
		List<OrderEntity> orders = new ArrayList<OrderEntity>();
		QueryOrdersReqModel req = new QueryOrdersReqModel();
		req.setCustomerID(objectFactory
				.createQueryOrdersReqModelCustomerID(userId));
		req.setRecordStart(objectFactory.createQueryOrdersReqModelRecordStart(0));
		req.setRecordEnd(objectFactory.createQueryOrdersReqModelRecordEnd(100));
		GregorianCalendar calendar = new GregorianCalendar();
		req.setEndTime(new XMLGregorianCalendarImpl(calendar));
		calendar.add(Calendar.DATE, -days);
		req.setStartTime(new XMLGregorianCalendarImpl(calendar));
		QueryOrdersResModel res = portType.queryOrder(req);
		if (res.getResult().getValue() && res.getQueryOrderModel() != null) {
			ArrayOfQueryOrderModel mo = res.getQueryOrderModel().getValue();
			if (mo != null) {
				List<QueryOrderModel> list = mo.getQueryOrderModel();
				for (QueryOrderModel queryOrderModel : list) {
					OrderEntity order = new OrderEntity();
					order.setOrderNo(queryOrderModel.getOrderNo().getValue());
					order.setOrderTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(queryOrderModel.getOrderDate().toGregorianCalendar().getTime()));
					order.setConsigneeAddress(queryOrderModel.getConsigneeAddress().getValue());
					order.setConsigneeName(queryOrderModel.getConsigneeName().getValue());
					order.setOrderStatus(queryOrderModel.getStatus().getValue());
					order.setWaybillNo(queryOrderModel.getTransNo().getValue());
					orders.add(order);
				}
			}
			return orders;

		} else {
			throw new OMSServiceException(res.getResultCode().getValue(), res
					.getResultInfo().getValue());
		}

	}

	@Override
	public OrderEntity queryOrderByNo(String orderNo, String userId) {
		OrderEntity order = new OrderEntity();
		QueryOrdersReqModel req = new QueryOrdersReqModel();
		req.setCustomerID(objectFactory
				.createQueryOrdersReqModelCustomerID(userId));
		req.setOrderNo(objectFactory.createQueryOrderModelOrderNo(orderNo));
		QueryOrdersResModel res = portType.queryOrder(req);
		if (res.getResult().getValue() && res.getQueryOrderModel() != null) {
			ArrayOfQueryOrderModel mo = res.getQueryOrderModel().getValue();
			if (mo != null) {
				List<QueryOrderModel> list = mo.getQueryOrderModel();
				if(list!=null&&!list.isEmpty()){
					QueryOrderModel queryOrderModel = list.get(0);
					order.setOrderNo(queryOrderModel.getOrderNo().getValue());
					order.setOrderTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(queryOrderModel.getOrderDate().toGregorianCalendar().getTime()));
					order.setConsigneeAddress(queryOrderModel.getConsigneeAddress().getValue());
					order.setConsigneeName(queryOrderModel.getConsigneeName().getValue());
					order.setOrderStatus(queryOrderModel.getStatus().getValue());
					order.setWaybillNo(queryOrderModel.getTransNo().getValue());
				}
			}else{
				throw new OMSServiceException(res.getResultCode().getValue(), res
						.getResultInfo().getValue());
			}

		} else {
			throw new OMSServiceException(res.getResultCode().getValue(), res
					.getResultInfo().getValue());
		}
		return order;
	}

	@Override
	public OrderEntity hcSubmitOrder(OrderEntity order, String userId) {
		PhoneOrderReqModel orderReq = new PhoneOrderReqModel();
		orderReq.setConsigneeAddress(objectFactory
				.createPhoneOrderReqModelConsigneeAddress(order
						.getConsigneeAddress()));
		orderReq.setConsigneeCity(objectFactory
				.createPhoneOrderReqModelConsigneeCity(order.getConsigneeCity()));
		orderReq.setConsigneeMobile(objectFactory
				.createPhoneOrderReqModelConsigneeMobile(order
						.getConsigneeMobile()));
		
		orderReq.setConsigneeTel(objectFactory.createPhoneOrderReqModelConsigneeTel(order.getConsigneePhone()));
		
		orderReq.setConsigneeName(objectFactory
				.createPhoneOrderReqModelConsigneeName(order.getConsigneeName()));
		orderReq.setConsigneeProv(objectFactory
				.createPhoneOrderReqModelConsigneeProv(order.getConsigneeProv()));

		orderReq.setProductType(objectFactory
				.createPhoneOrderReqModelProductType(OMSConstants.DEFAULT_PRODUCT_TYPE_CODE));

		orderReq.setShipperAddress(objectFactory
				.createPhoneOrderReqModelShipperAddress(order
						.getShipperAddress()));
		orderReq.setShipperCity(objectFactory
				.createPhoneOrderReqModelShipperCity(order.getShipperCity()));
		orderReq.setShipperMethod(objectFactory
				.createPhoneOrderReqModelShipperMethod(order.getShipperMethod()));
		orderReq.setShipperMobile(objectFactory
				.createPhoneOrderReqModelShipperMobile(order.getShipperMobile()));
		
		orderReq.setShipperTel(objectFactory.createPhoneOrderReqModelShipperTel(order.getShipperPhone()));
		
		orderReq.setShipperName(objectFactory
				.createPhoneOrderReqModelShipperName(order.getShipperName()));
		orderReq.setShipperProv(objectFactory
				.createPhoneOrderReqModelShipperProv(order.getShipperProv()));
		orderReq.setSmsNotify(objectFactory
				.createPhoneOrderReqModelSmsNotify("Y"));

		orderReq.setUserId(objectFactory.createPhoneOrderReqModelUserId(userId));

		/* 货物 */
		orderReq.setCargoName(objectFactory
				.createPhoneOrderReqModelCargoName(order.getGoods_name()));
		orderReq.setShipperMethod(objectFactory
				.createPhoneOrderReqModelShipperMethod(order.getShipperMethod()));
		orderReq.setConsigneeMethod(objectFactory
				.createPhoneOrderReqModelConsigneeMethod("Y"));
		
		orderReq.setRemark(objectFactory.createPhoneOrderReqModelRemark(order.getRemark()));
		// 件数
		orderReq.setCargoNumber(order.getGoods_pieces() == null? 
				objectFactory.createPhoneOrderReqModelCargoNumber(1.0):
					objectFactory.createPhoneOrderReqModelCargoNumber(order.getGoods_pieces()));
		// 体积
		orderReq.setCargoVolume(order.getGoods_volumn() == null? 
				objectFactory.createPhoneOrderReqModelCargoVolume(1.0):
					objectFactory.createPhoneOrderReqModelCargoVolume(order.getGoods_volumn()));
		
		// 重量
		orderReq.setCargoWeight(order.getGoods_weight() == null? 
				objectFactory.createPhoneOrderReqModelCargoWeight(1.0):
					objectFactory.createPhoneOrderReqModelCargoWeight(order.getGoods_weight()));
		
		PhoneOrderResModel res = portType.createOrder(orderReq);
		if (res.getResult().getValue()) {
			String orderNo = res.getPhoneOrderReqModel().getValue().getOrderNo()
					.getValue();
			order.setOrderNo(orderNo);
			return order;
		} else {
			throw new OMSServiceException(res.getResultCode().getValue(), res
					.getResultInfo().getValue());
		}
	}

	
	
}
