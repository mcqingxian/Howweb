/**
 * 
 */
package com.hoau.wechat.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.hoau.wechat.constant.Constant;
import com.hoau.wechat.constant.OMSConstants;
import com.hoau.wechat.constant.PropertyConstant;
import com.hoau.wechat.entity.OrderEntity;
import com.hoau.wechat.exception.OMSServiceException;
import com.hoau.wechat.service.IContactsManageService;
import com.hoau.wechat.service.ILoginOmsService;
import com.hoau.wechat.service.IOrderManagerService;
import com.hoau.wechat.service.IOrderManagerWechatService;
import com.hoau.wechat.service.IPhoneBindService;
import com.hoau.wechat.util.JsonUtils;
import com.hoau.wechat.util.PermissionCheck;
import com.hoau.wechat.util.StringUtil;
import com.hoau.wechat.utils.net.WeixinUtil;
import com.hoau.wechat.vo.Contacts;
import com.hoau.wechat.vo.OrderResult;
import com.hoau.wechat.vo.UserInfo;
import com.opensymphony.xwork2.Action;

/**
 * @author gaojia
 * 
 */
@Controller
@Scope("prototype")
public class OrderManagerAction implements Action {
	private static Log log = LogFactory.getLog(OrderManagerAction.class);
	@Resource
	private IOrderManagerService orderManagerService;
	@Resource
	private ILoginOmsService loginOmsService;
	@Resource
	private IContactsManageService contactsManageService;
	@Resource
	private IOrderManagerWechatService orderManagerWechatService;
	@Resource
	private IPhoneBindService phoneBindService;
	/**
	 * 订单信息
	 */
	private OrderEntity order;

	private Map<String, String> shipperMethodMap;

	private OrderResult orderResult;

	private List<OrderEntity> undoneOrders;

	private List<OrderEntity> doneOrders;
	/**
	 * 发货人列表
	 */
	private List<Contacts> shipperContacts;
	/**
	 * 收货人列表
	 */
	private List<Contacts> consigneeContacts;
	/**
	 * 发货人
	 */
	private Contacts shipperContact;
	/**
	 * 收货人
	 */
	private Contacts consigneeContact;

	private String contactsId;

	private String date;
	private String getUserId(){
		log.info("getUserId:进入用户登录查询！");
		String openId = WeixinUtil.getOpenIdFromSession();
		return loginOmsService.login(openId);
	}
	
	@PermissionCheck
	@Override
	public String execute() throws Exception {
		String openId = WeixinUtil.getOpenIdFromSession();
		List<Contacts> contacts =  contactsManageService.query(openId);
		shipperContacts = new ArrayList<Contacts>();
		consigneeContacts = new ArrayList<Contacts>();
		for (Contacts contact : contacts) {
//			contact.setPro_city_cty(contact.getPro_city_cty().substring(0,contact.getPro_city_cty().lastIndexOf(" ")));
			if(contact.getType()==Constant.CONTACTS_TYPE_SEND){
				shipperContacts.add(contact);
			}else if(contact.getType()==Constant.CONTACTS_TYPE_RECEIVER){
				consigneeContacts.add(contact);
			}
		}
		//是否从联系人管理界面跳转过来
		if(!StringUtil.isEmpty(contactsId)){
			Contacts con = contactsManageService.queryOne(openId, contactsId);
//			con.setPro_city_cty(con.getPro_city_cty().substring(0,con.getPro_city_cty().lastIndexOf(" ")));
			if(con!=null&& Constant.CONTACTS_TYPE_SEND==con.getType()){
				shipperContact = con;
			}else if(con!=null&& Constant.CONTACTS_TYPE_RECEIVER==con.getType()){
				consigneeContact = con;
			}
		}else if(shipperContact==null){
			//如果已经绑定过手机号，则进入下订单界面带出手机号
			UserInfo userinfo = phoneBindService.findOneUserInfo(openId);
			if(userinfo!=null&&!StringUtil.isEmpty(userinfo.getPhone())){
				shipperContact = new Contacts();
				shipperContact.setPhone(userinfo.getPhone());
			};
		}
		
		return SUCCESS;
	}

	/**
	 * 提交订单
	 * 
	 * @return
	 */
	public String submitOrder() {
		
		orderResult = new OrderResult();
		//根据openid获取用户userId
		String userId = this.getUserId();
		try {
			//test
			System.out.println(JsonUtils.toJson(order));
			order = orderManagerService.submitOrder(order, userId);
			orderManagerWechatService.saveOrder(order);
			orderResult.setException(false);
			orderResult.setValue(order.getOrderNo());
			log.info("下单成功订单号：" + order.getOrderNo());
		} catch (OMSServiceException e) {
			log.error(e.getMessage());
			orderResult.setException(true);
			orderResult.setErrMsg(e.getMessage());
		}
		return SUCCESS;
	}

	public String hcOrder() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String refer = request.getHeader("Referer");
		if(refer != null && refer.contains(PropertyConstant.HC_URL)){
			log.info(refer);
			return SUCCESS;
		}else{
			return ERROR;
		}
	}
	
	public String hcSubmitOrder() {
		orderResult = new OrderResult();
		//根据openid获取用户userId
		String userId = loginOmsService.login(order.getShipperMobile() == null?order.getShipperMobile():order.getShipperPhone());
		try {
			order = orderManagerService.hcSubmitOrder(order, userId);
			orderManagerWechatService.saveOrder(order);
			orderResult.setException(false);
			orderResult.setValue(order.getOrderNo());
			log.info("下单成功订单号：" + order.getOrderNo());
		} catch (OMSServiceException e) {
			log.error(e.getMessage());
			orderResult.setException(true);
			orderResult.setErrMsg(e.getMessage());
		}
		return SUCCESS;
	}
	
	public String queryOrder() {
		log.info("queryOrder:进入订单查询！");
		String userId = this.getUserId();
		doneOrders = new ArrayList<OrderEntity>();
		undoneOrders = new ArrayList<OrderEntity>();
		int days = 30;
		if(!StringUtil.isEmpty(date)){
			days = Constant.QUERY_ORDER_DAYS.get(date);
		}
		List<OrderEntity> orderList = orderManagerService.queryOrder(userId,days);
		for (OrderEntity orderEntity : orderList) {
			if (OMSConstants.ORDER_STATUS.VOID.equals(orderEntity
					.getOrderStatus())
					|| OMSConstants.ORDER_STATUS.DELIVER.equals(orderEntity
							.getOrderStatus())) {
				doneOrders.add(orderEntity);
			}else{
				undoneOrders.add(orderEntity);
			}
		}
		return SUCCESS;

	}
	
	public String cancelOrder(){
		String userId = this.getUserId();
		orderResult = new OrderResult();
		try {
			orderManagerService.cancelOrder(order.getOrderNo(), userId);
			orderManagerWechatService.cancelOrder(order.getOrderNo());
			orderResult.setValue(order.getOrderNo());
			orderResult.setException(false);
		} catch (OMSServiceException e) {
			String errMsg;
			log.error(e.getMessage());
			if(StringUtil.isEmpty(e.getMessage())){
				errMsg = "处理失败，请稍后再试";
			}else{
				errMsg = e.getMessage();
			}
			orderResult.setException(true);
			orderResult.setErrMsg(errMsg);
		}
		
		return SUCCESS;
	}

	public String modifyOrder(){
		String userId = this.getUserId();
		String openId = WeixinUtil.getOpenIdFromSession();
		String orderNo = order.getOrderNo();
		order = orderManagerService.queryOrderDetail(orderNo, userId);
		order.setOrderNo(orderNo);
		List<Contacts> contacts =  contactsManageService.query(openId);
		shipperContacts = new ArrayList<Contacts>();
		consigneeContacts = new ArrayList<Contacts>();
		for (Contacts contact : contacts) {
//			contact.setPro_city_cty(contact.getPro_city_cty().substring(0,contact.getPro_city_cty().lastIndexOf(" ")));
			contact.setPro_city_cty(contact.getPro_city_cty());
			if(contact.getType()==Constant.CONTACTS_TYPE_SEND){
				shipperContacts.add(contact);
			}else if(contact.getType()==Constant.CONTACTS_TYPE_RECEIVER){
				consigneeContacts.add(contact);
			}
		}
		return SUCCESS;
	}
	
	public String modifyOrderDetail(){
		orderResult = new OrderResult();
		//根据openid获取用户userId
		String userId = this.getUserId();
		try {
			orderManagerService.modifyOrder(order, userId);
			orderManagerWechatService.modifyOrder(order);
			orderResult.setException(false);
			orderResult.setValue(order.getOrderNo());
			log.info("修改订单成功订单号：" + order.getOrderNo());
		} catch (OMSServiceException e) {
			String errMsg;
			log.error(e.getMessage());
			if(StringUtil.isEmpty(e.getMessage())){
				errMsg = "处理失败，请稍后再试";
			}else{
				errMsg = e.getMessage();
			}
			orderResult.setException(true);
			orderResult.setErrMsg(errMsg);
		}
		return SUCCESS;
	}
	
	public String queryOrderByNo(){
		orderResult = new OrderResult();
		//根据openid获取用户userId
		String userId = this.getUserId();
		try {
			order = orderManagerService.queryOrderByNo(order.getOrderNo(), userId);
			orderResult.setException(false);
			orderResult.setOrder(order);
		} catch (OMSServiceException e) {
			String errMsg;
			log.error(e.getMessage());
			if(StringUtil.isEmpty(e.getMessage())){
				errMsg = "处理失败，请稍后再试";
			}else{
				errMsg = e.getMessage();
			}
			orderResult.setException(true);
			orderResult.setErrMsg(errMsg);
		}
		return SUCCESS;
	}
	public String queryOrderDetail() {
		String userId = this.getUserId();
		String openId = WeixinUtil.getOpenIdFromSession();
		String orderNo = order.getOrderNo();
		//查询订单详细信息
		order = orderManagerService.queryOrderDetail(orderNo, userId);
		order.setOrderNo(orderNo);
		//查询订单状态
		String orderStatus = orderManagerService.queryOrderByNo(order.getOrderNo(), userId).getOrderStatus();
		order.setOrderStatus(orderStatus);
		//查询联系人
		List<Contacts> contacts =  contactsManageService.query(openId);
		shipperContacts = new ArrayList<Contacts>();
		consigneeContacts = new ArrayList<Contacts>();
		for (Contacts contact : contacts) {
//			contact.setPro_city_cty(contact.getPro_city_cty().substring(0,contact.getPro_city_cty().lastIndexOf(" ")));
			contact.setPro_city_cty(contact.getPro_city_cty());
			if(contact.getType()==Constant.CONTACTS_TYPE_SEND){
				shipperContacts.add(contact);
			}else if(contact.getType()==Constant.CONTACTS_TYPE_RECEIVER){
				consigneeContacts.add(contact);
			}
		}
		return SUCCESS;
	}

	public IOrderManagerService getOrderManagerService() {
		return orderManagerService;
	}

	public void setOrderManagerService(IOrderManagerService orderManagerService) {
		this.orderManagerService = orderManagerService;
	}

	public OrderEntity getOrder() {
		return order;
	}

	public void setOrder(OrderEntity order) {
		this.order = order;
	}

	public ILoginOmsService getLoginOmsService() {
		return loginOmsService;
	}

	public void setLoginOmsService(ILoginOmsService loginOmsService) {
		this.loginOmsService = loginOmsService;
	}


	public Map<String, String> getShipperMethodMap() {
		return shipperMethodMap;
	}

	public void setShipperMethodMap(Map<String, String> shipperMethodMap) {
		this.shipperMethodMap = shipperMethodMap;
	}

	public OrderResult getOrderResult() {
		return orderResult;
	}

	public void setOrderResult(OrderResult orderResult) {
		this.orderResult = orderResult;
	}

	public List<OrderEntity> getUndoneOrders() {
		return undoneOrders;
	}

	public void setUndoneOrders(List<OrderEntity> undoneOrders) {
		this.undoneOrders = undoneOrders;
	}

	public List<OrderEntity> getDoneOrders() {
		return doneOrders;
	}

	public void setDoneOrders(List<OrderEntity> doneOrders) {
		this.doneOrders = doneOrders;
	}
	public IContactsManageService getContactsManageService() {
		return contactsManageService;
	}
	public void setContactsManageService(
			IContactsManageService contactsManageService) {
		this.contactsManageService = contactsManageService;
	}
	public List<Contacts> getShipperContacts() {
		return shipperContacts;
	}
	public void setShipperContacts(List<Contacts> shipperContacts) {
		this.shipperContacts = shipperContacts;
	}
	public List<Contacts> getConsigneeContacts() {
		return consigneeContacts;
	}
	public void setConsigneeContacts(List<Contacts> consigneeContacts) {
		this.consigneeContacts = consigneeContacts;
	}
	public Contacts getShipperContact() {
		return shipperContact;
	}
	public void setShipperContact(Contacts shipperContact) {
		this.shipperContact = shipperContact;
	}
	public Contacts getConsigneeContact() {
		return consigneeContact;
	}
	public void setConsigneeContact(Contacts consigneeContact) {
		this.consigneeContact = consigneeContact;
	}
	public String getContactsId() {
		return contactsId;
	}
	public void setContactsId(String contactsId) {
		this.contactsId = contactsId;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public void setOrderManagerWechatService(
			IOrderManagerWechatService orderManagerWechatService) {
		this.orderManagerWechatService = orderManagerWechatService;
	}
	public void setPhoneBindService(IPhoneBindService phoneBindService) {
		this.phoneBindService = phoneBindService;
	}
}
