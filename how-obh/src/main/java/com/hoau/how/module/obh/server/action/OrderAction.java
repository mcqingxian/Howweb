package com.hoau.how.module.obh.server.action;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.hoau.hbdp.framework.exception.BusinessException;
import com.hoau.hbdp.framework.server.web.action.AbstractAction;
import com.hoau.hbdp.framework.server.web.result.json.annotation.JSON;
import com.hoau.how.module.common.constants.OrderConstants;
import com.hoau.how.module.common.constants.SessionConstants;
import com.hoau.how.module.itf.server.service.IOmsOrderService;
import com.hoau.how.module.itf.server.service.IPriceTimeManager;
import com.hoau.how.module.itf.server.ws.dcpricetime.PriceQueryResultVo;
import com.hoau.how.module.itf.server.ws.omsorder.CustomerServicePortType;
import com.hoau.how.module.itf.server.ws.omsorder.EiNetOrderReq;
import com.hoau.how.module.itf.server.ws.omsorder.EiNetOrderReqModel;
import com.hoau.how.module.itf.shared.vos.pricetime.PriceQueryVo;
import com.hoau.how.module.obh.server.service.IContactsService;
import com.hoau.how.module.obh.server.service.IOrderService;
import com.hoau.how.module.obh.shared.domain.CustomerContactEntity;
import com.hoau.how.module.obh.shared.domain.NetOrderEntity;
import com.hoau.how.module.obh.shared.domain.QuickOrderEntity;
import com.hoau.how.module.obh.shared.util.PermissionCheck;
import com.hoau.how.module.obh.shared.vos.MyOrdersVo;
import com.hoau.how.module.util.EmptyUtils;
import com.hoau.how.module.util.JsonUtils;
import com.opensymphony.xwork2.ActionContext;

/**
 *
 * @author 莫涛
 * @date 2015年7月20日
 */
@Controller
@Scope("prototype")
public class OrderAction extends AbstractAction{
	/**
	 *
	 */
	private static final long serialVersionUID = 9125540121651748362L;
	private Logger logger = Logger.getLogger(OrderAction.class);
	@Resource
	IOrderService orderService;
	@Resource
	IPriceTimeManager priceTimeManager;
	@Resource
	IOmsOrderService omsOrderService;
	@Resource
	private IContactsService contactsService;
	
	private String categoryName;
	private NetOrderEntity entity;
	private List<PriceQueryResultVo> priceList;
	private String errorType;
	private String errorMsg;
	private String fromPage;
	
	private Integer orderId	;
	private Integer pageSize;
	private Integer pageNo = 1;
	private Integer pageCount;
	private String consignee;
	private String consigner;
	private List<MyOrdersVo> quickOrders;
	
	private CustomerContactEntity getCurrentUser(){
		ActionContext ctx = ActionContext.getContext();
		Object obj = ctx.getSession().get(SessionConstants.SESSION_USER_INFO.USER_INFO);
		if(obj == null){
			return null;
		}
		CustomerContactEntity userInfo = (CustomerContactEntity) obj;
		return userInfo;
	}
	
	@PermissionCheck
	public String index(){
		CustomerContactEntity userInfo = getCurrentUser();
		if(userInfo != null){
			entity = contactsService.setDefaultContacts(userInfo.getEbccId(),false);
		}
		return "index";
	}
	
	public String quickOrder(){
		try {
			Long long1 = getCurrentUser().getEbccId();
			entity = orderService.queryOneOrder(orderId,long1);
			this.fromPage = "quick";
		} catch (Exception e) {
			e.printStackTrace();
			return "index";
		}
		return "quickOrder";
	}
	
	@JSON
	@PermissionCheck
	public String queryQuickOrders(){
		try {
			CustomerContactEntity userInfo = getCurrentUser();
			if(userInfo == null){
				return returnError(new BusinessException(""));
			}
			QuickOrderEntity quickEntity = new QuickOrderEntity();
			quickEntity.setEinoEbccId(userInfo.getEbccId());
			quickEntity.setPageNo(pageNo);
			quickEntity.setPageSize(pageSize);
			quickEntity.setConsignee(consignee);
			quickEntity.setConsigner(consigner);
			quickOrders = orderService.queryQuickOrder(quickEntity);
			this.pageCount = orderService.countQuickOrder(quickEntity);
		} catch (BusinessException e) {
			e.printStackTrace();
			return returnError(e);
		}
		return "queryQuickOrders";
	}
	
	public String queryPriceTimeJson(){
		try{
			PriceQueryVo vo = new PriceQueryVo();
			if(this.entity == null){
				return "queryPriceTime";
			}
			if(this.entity.getShipperDistrict() == null || this.entity.getShipperDistrict().equals("")){
				this.errorType = "main";
				this.errorMsg = "发货人省市不能为空！";
				return "queryPriceTime";
			}
			if(this.entity.getConsigneeDistrict() == null || this.entity.getConsigneeDistrict().equals("")){
				this.errorType = "main";
				this.errorMsg = "收货人省市不能为空！";
				return "queryPriceTime";
			}
			String shipperDistrict = this.entity.getShipperDistrict();
			String consigneeDistrict = this.entity.getConsigneeDistrict();
			String[] sd = shipperDistrict.split("-");
			String[] cd = consigneeDistrict.split("-");
			if(sd.length < 3){
				this.errorType = "main";
				this.errorMsg = "发货人区县不能为空，否则无法计算价格时效！";
				return "queryPriceTime";
			}
			if(cd.length < 3){
				this.errorType = "main";
				this.errorMsg = "收货人区县不能为空，否则无法计算价格时效！";
				return "queryPriceTime";
			}
			vo.setConCity(cd[1]);
			vo.setConCounty(cd[2]);
			vo.setShipperCity(sd[1]);
			vo.setShipperCounty(sd[2]);
			if(this.entity.getEinoTotalVolume() != null && this.entity.getEinoTotalWeight() != null){
				vo.setVolumn(this.entity.getEinoTotalVolume().doubleValue());
				vo.setWeight(this.entity.getEinoTotalWeight().doubleValue());
			}
			this.priceList = priceTimeManager.queryPriceTime(vo);
		}catch(Exception ex){
			logger.error("OrderAction queryPriceTimeJson error : " + ex.getMessage());
			this.errorType = "systemError";
			setThisErrorMsg("系统异常："+ex.getMessage());
			ex.printStackTrace();
		}
		return "queryPriceTime";
	}
	
	/**
	 * 存为草稿
	 * @return
	 * @author 莫涛
	 * @date 2015年7月29日
	 * @update
	 */
	@PermissionCheck
	public String saveDraft(){
		try{
			if(this.entity == null){
				setThisErrorMsg("参数为空！");
				this.errorType = "systemError";
				return "saveDraft";
			}
			ActionContext ctx = ActionContext.getContext();
			Object obj = ctx.getSession().get(SessionConstants.SESSION_USER_INFO.USER_INFO);
			CustomerContactEntity userInfo = (CustomerContactEntity) obj;
			//设置用户ID
			this.entity.setEinoEbccId(userInfo.getEbccId().longValue());
			//如果保存过草稿，则修改草稿
			if(this.entity.getEinoId() == null || this.entity.getEinoId().equals("")){
				orderService.saveDraft(this.entity);
			}else{
				orderService.updateDraft(this.entity);
			}
			this.entity = null;
			this.errorType = "saveDraftSuccess";
		}catch(Exception ex){
			logger.error("OrderAction saveDraft error : " + ex.getMessage());
			this.errorType = "systemError";
			setThisErrorMsg("系统异常："+ex.getMessage());
			ex.printStackTrace();
		}
		return "toIndex";
	}
	
	public String createOrder(){
		try{
			if(this.entity == null){
				this.errorMsg = "参数为空!";
				return "createOrder";
			}
			
			ActionContext ctx = ActionContext.getContext();
			Object obj = ctx.getSession().get(SessionConstants.SESSION_USER_INFO.USER_INFO);
			if(obj != null){
				CustomerContactEntity userInfo = (CustomerContactEntity) obj;
				//设置用户ID
				this.entity.setEinoEbccId(userInfo.getEbccId().longValue());
			}
			//验证订单数据
			this.checkEiNetOrder();
			if(this.errorMsg == null){
				//保存订单
				CustomerServicePortType port = omsOrderService.getCustomerService();
				EiNetOrderReqModel netOrder = new EiNetOrderReqModel();
				//下单时间
				this.entity.setEinoOrderDate(new Date());
				orderService.createOrder(this.entity);
				//自动保存收发货人
				orderService.saveContacts(this.entity);
				//值转换
				orderService.copyNetOrderToEiNetOrder(entity, netOrder,omsOrderService.getObjectFactory(),0);
				port.saveNetOrder(netOrder);
				this.errorType = "createOrderSuccess";
				return "toIndex";
			}
		}catch(Exception ex){
			logger.error("OrderAction createOrder error : " + ex.getMessage());
			this.errorType = "systemError";
			setThisErrorMsg("系统异常："+ex.getMessage());
			ex.printStackTrace();
		}
		return "createOrder";
	}
	
	/** 修改订单
	 * @return
	 * @author 龙海仁
	 * @date 2015年8月11日
	 * @update 
	 */
	@PermissionCheck
	public String updateOrder(){
		try{
			if("modify".equals(fromPage) && OrderConstants.ORDER_STATUS_KEYS.DRAFT.equals(this.entity.getEinoStatus())){
				this.entity.setEinoStatus(OrderConstants.ORDER_STATUS_KEYS.ADD);
				this.entity.setEinoOrderDate(new Date());
			}
			//验证订单数据
			this.checkEiNetOrder();
			if(this.errorMsg == null){
				//保存订单
				CustomerServicePortType port = omsOrderService.getCustomerService();
				EiNetOrderReqModel netOrder = new EiNetOrderReqModel();
				//修改本地订单
				orderService.updateOrder(this.entity);
				//值转换
				orderService.copyNetOrderToEiNetOrder(entity, netOrder,omsOrderService.getObjectFactory(),0);
				//更新OMS订单
				EiNetOrderReq resp = port.updateNetOrder(netOrder);
				logger.info(JsonUtils.toJson(resp));
				return "updateOrder";
			}else{
				return "createOrder";
			}
		}catch(Exception ex){
			logger.error("OrderAction createOrder error : " + ex.getMessage());
			this.errorType = "systemError";
			setThisErrorMsg("系统异常："+ex.getMessage());
			ex.printStackTrace();
			return "createOrder";
		}
		
	}
	
	public String createQuickOrder(){
		try{
			if(this.entity == null){
				this.errorMsg = "参数为空!";
				return "createQuickOrder";
			}
			
			ActionContext ctx = ActionContext.getContext();
			Object obj = ctx.getSession().get(SessionConstants.SESSION_USER_INFO.USER_INFO);
			if(obj != null){
				CustomerContactEntity userInfo = (CustomerContactEntity) obj;
				//设置用户ID
				this.entity.setEinoEbccId(userInfo.getEbccId().longValue());
			}
			//验证订单数据
			this.checkQuickEiNetOrder();
			if(this.errorMsg == null){
				//保存订单
				CustomerServicePortType port = omsOrderService.getCustomerService();
				EiNetOrderReqModel netOrder = new EiNetOrderReqModel();
				//下单时间
				this.entity.setEinoOrderDate(new Date());
				orderService.createOrder(this.entity);
				//自动保存收发货人
				orderService.saveContacts(this.entity);
				//值转换
				orderService.copyNetOrderToEiNetOrder(entity, netOrder,omsOrderService.getObjectFactory(),0);
				port.saveNetOrder(netOrder);
				this.errorType = "createOrderSuccess";
			}
		}catch(Exception ex){
			logger.error("OrderAction createOrder error : " + ex.getMessage());
			this.errorType = "systemError";
			setThisErrorMsg("系统异常："+ex.getMessage());
			ex.printStackTrace();
		}
		return "createQuickOrder";
	}
	
	/**
	 * 校验快速下单网上订单信息
	 * @param model
	 * @return
	 */
	private void checkQuickEiNetOrder(){
		this.errorType = "systemError";
		if(EmptyUtils.isEmpty(entity.getEinoShipperEbsaContact()) || 
				"".equals(entity.getEinoShipperEbsaContact())){  //发货人为null 或 “”时
			setThisErrorMsg("发货人不能为空！");
		} else if((EmptyUtils.isEmpty(entity.getEinoShipperEbsaMobile()) || 
				"".equals(entity.getEinoShipperEbsaMobile())) && 
				(EmptyUtils.isEmpty(entity.getEinoShipperEbsaTel()) || 
						"".equals(entity.getEinoShipperEbsaTel()))){ //收货人手机为null 或 “”时
			setThisErrorMsg("发货人手机和座机不能同时为空！");
		}else if(EmptyUtils.isEmpty(entity.getShipperDistrict()) || 
				"".equals(entity.getShipperDistrict())){
			setThisErrorMsg("发货人省市区不能为空！");
		} else if(EmptyUtils.isEmpty(entity.getEinoShipperEbsaAddress()) || 
				"".equals(entity.getEinoShipperEbsaAddress())){ //发货地址为null 或 “”时
			setThisErrorMsg("发货地址不能为空！");
		}
	}
	
	/**
	 * 校验网上订单信息
	 * @param model
	 * @return
	 */
	private void checkEiNetOrder(){
		this.errorType = "systemError";
		if(EmptyUtils.isEmpty(entity.getEinoShipperEbsaContact()) || 
				"".equals(entity.getEinoShipperEbsaContact())){  //发货人为null 或 “”时
			setThisErrorMsg("发货人不能为空！");
		} else if((EmptyUtils.isEmpty(entity.getEinoShipperEbsaMobile()) || 
				"".equals(entity.getEinoShipperEbsaMobile())) && 
				(EmptyUtils.isEmpty(entity.getEinoShipperEbsaTel()) || 
						"".equals(entity.getEinoShipperEbsaTel()))){ //收货人手机为null 或 “”时
			setThisErrorMsg("发货人手机和座机不能同时为空！");
		}else if(EmptyUtils.isEmpty(entity.getShipperDistrict()) || 
				"".equals(entity.getShipperDistrict())){
			setThisErrorMsg("发货人省市区不能为空！");
		} else if(EmptyUtils.isEmpty(entity.getEinoShipperEbsaAddress()) || 
				"".equals(entity.getEinoShipperEbsaAddress())){ //发货地址为null 或 “”时
			setThisErrorMsg("发货地址不能为空！");
		} else if(EmptyUtils.isEmpty(entity.getEinoShipperEbsaContact()) || 
				"".equals(entity.getEinoShipperEbsaContact())){  //收货人为null 或 “”时
			setThisErrorMsg("收货人不能为空！");
		} else if((EmptyUtils.isEmpty(entity.getEinoConsigneeEbsaMobile()) || 
				"".equals(entity.getEinoConsigneeEbsaMobile())) && 
				(EmptyUtils.isEmpty(entity.getEinoConsigneeEbsaTel()) || 
						"".equals(entity.getEinoConsigneeEbsaTel()))){ //收货人手机为null 或 “”时
			setThisErrorMsg("收货人手机和座机不能同时为空！");
		} else if(EmptyUtils.isEmpty(entity.getConsigneeDistrict()) || 
				"".equals(entity.getConsigneeDistrict())){
			setThisErrorMsg("收货人省市区不能为空！");
		} else if(EmptyUtils.isEmpty(entity.getEinoConsigneeEbsaAddress()) ||
				"".equals(entity.getEinoConsigneeEbsaAddress())){ //收货地址为null 或 “”时
			setThisErrorMsg("收货地址不能为空！");
		} else if(EmptyUtils.isEmpty(entity.getEinoCargoName()) || 
				"".equals(entity.getEinoCargoName())){ //货物名称为null 或 “”时
			setThisErrorMsg("货物名称不能为空！");
		} else if(EmptyUtils.isEmpty(entity.getEinoNumber().toString()) || 
				"".equals(entity.getEinoNumber()) || entity.getEinoNumber() <=0 ){ //货物件数为null 或 “”时或为零
			setThisErrorMsg("货物件数不能为空/不能小于等于零！");
		} else if(EmptyUtils.isEmpty(entity.getEinoProductTypeName()) || 
				"".equals(entity.getEinoProductTypeName())){ //运输方式为null 或 “”时
			setThisErrorMsg("运输方式不能为空！");
		} else if(EmptyUtils.isEmpty(entity.getEinoShipperMethod()) || 
				"".equals(entity.getEinoShipperMethod())){ //送货方式为null 或 “”时
			setThisErrorMsg("送货方式不能为空！");
		} else if(EmptyUtils.isEmpty(entity.getEinoPaymentMethod()) || 
				"".equals(entity.getEinoPaymentMethod())){ //付款方式为null 或 “”时
			setThisErrorMsg("付款方式不能为空！");
		}
	}
	
	private void setThisErrorMsg(String msg){
		this.errorMsg = "<p class='erro'><span class='icon_del'></span>"+msg+"</p>";
	}
	
	public NetOrderEntity getEntity() {
		return entity;
	}
	
	public void setEntity(NetOrderEntity entity) {
		this.entity = entity;
	}

	public String getErrorType() {
		return errorType;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public List<PriceQueryResultVo> getPriceList() {
		return priceList;
	}
	public String getFromPage() {
		return fromPage;
	}

	public void setFromPage(String fromPage) {
		this.fromPage = fromPage;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Integer getPageNo() {
		return pageNo;
	}

	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
	}

	public Integer getPageCount() {
		return pageCount;
	}

	public void setPageCount(Integer pageCount) {
		this.pageCount = pageCount;
	}

	public String getConsignee() {
		return consignee;
	}

	public void setConsignee(String consignee) {
		this.consignee = consignee;
	}

	public String getConsigner() {
		return consigner;
	}

	public void setConsigner(String consigner) {
		this.consigner = consigner;
	}

	public List<MyOrdersVo> getQuickOrders() {
		return quickOrders;
	}

	public void setQuickOrders(List<MyOrdersVo> quickOrders) {
		this.quickOrders = quickOrders;
	}

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
	
}