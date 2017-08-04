package com.hoau.mhow.module.bse.server.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;

import com.hoau.hbdp.framework.exception.BusinessException;
import com.hoau.hbdp.framework.server.web.action.AbstractAction;
import com.hoau.hbdp.framework.shared.util.string.StringUtil;
import com.hoau.mhow.invokews.server.ws.omsorder.CustomerServicePortType;
import com.hoau.mhow.invokews.server.ws.omsorder.EiNetOrderReqModel;
import com.hoau.mhow.module.bse.api.server.service.ICompanyMatchService;
import com.hoau.mhow.module.bse.api.server.service.IContactsService;
import com.hoau.mhow.module.bse.api.server.service.IGetYdTraceManager;
import com.hoau.mhow.module.bse.api.server.service.IMyOrdersService;
import com.hoau.mhow.module.bse.api.server.service.IOmsOrderService;
import com.hoau.mhow.module.bse.api.server.service.IOrderService;
import com.hoau.mhow.module.bse.api.server.service.IWaybillService;
import com.hoau.mhow.module.bse.api.shared.domain.ContactsEntity;
import com.hoau.mhow.module.bse.api.shared.domain.CustomerContactEntity;
import com.hoau.mhow.module.bse.api.shared.domain.NetOrderEntity;
import com.hoau.mhow.module.bse.api.shared.domain.QueryWaybillEntity;
import com.hoau.mhow.module.bse.api.shared.domain.WaybillResultEntity;
import com.hoau.mhow.module.bse.api.shared.exception.OBHException;
import com.hoau.mhow.module.bse.api.shared.vo.GoodsTraceResultVo;
import com.hoau.mhow.module.bse.api.shared.vo.MyOrdersVo;
import com.hoau.mhow.module.bse.api.shared.vo.QueryOrderVo;
import com.hoau.wechat.constants.ContactsType;
import com.hoau.wechat.constants.SessionConstants;
import com.hoau.wechat.util.PermissionCheck;
import com.opensymphony.xwork2.ActionContext;

/**
 * 我的订单管理
 * @author Dy
 * 2015年12月18日
 */
@Controller
@Scope("prototype")
public class MyOrdersMgtAction extends AbstractAction {
	
		private static final long serialVersionUID = -8169459549798418152L;
		private Logger logger = Logger.getLogger(MyOrdersMgtAction.class);
		
		/*******************调试开始*******************/
		
		@Resource
		private IMyOrdersService myOrderService;
		@Resource
		private IOrderService orderService;
		@Resource
		private IOmsOrderService omsOrderService;
		@Resource
		private IWaybillService waybillService;
		@Resource
		private IContactsService contactsService;
		@Resource
		private ICompanyMatchService companyMatchService;
		@Resource
		private IGetYdTraceManager getYdTraceManager;
		
		private QueryOrderVo queryVo = new QueryOrderVo();
		
		/**
		 *发货联系人
		 */
		private List<ContactsEntity> shipperContacts;
		
		/**
		 *收货联系人
		 */
		private List<ContactsEntity> consigneeContacts;
		/**
		 *未完成订单列表
		 */
		private List<MyOrdersVo> undoneOrders;

		/**
		 *已完成订单列表
		 */
		private List<MyOrdersVo> doneOrders;
		
		/**
		 *订单实体
		 */
		private NetOrderEntity order;
		
		
		/**
		 *订单id
		 */
		private Integer orderId;
		
		/**
		 *订单vo
		 */
		private MyOrdersVo orderVo;
		
		/**
		 *运单查询实体
		 */
		private QueryWaybillEntity queryWaybillEntity = new QueryWaybillEntity();
		
		/**
		 *货物轨迹
		 */
		private GoodsTraceResultVo goodsTraceResult;
		
		/**
		 *运单结果vo
		 */
		List<WaybillResultEntity> waybills;
		
		/**
		 *联系人
		 */
		private String ebsaId;
		
		/**
		 *用于订单管理的加载更多判断
		 */
		private String doneType;
		
		/**
		 *分页
		 */
		private Integer pageNo = 1 ;
		/**
		 * 下单,修改订单
		 * 2015年12月23日
		 * @author Dy
		 */
		@PermissionCheck
		public String order(){
			try {
				//下单界面加载联系人
				CustomerContactEntity customerEntity = getCurrentUser();
				shipperContacts = contactsService.queryMyContacts(customerEntity.getEbccId(), ContactsType.SHIPPER);
				consigneeContacts = contactsService.queryMyContacts(customerEntity.getEbccId(), ContactsType.CONSIGNEE);
				//修改
				if(orderId!= null&&!StringUtils.isEmpty(orderId)){
					order = myOrderService.queryOrderDetail(orderId);
				}else{
					//默认下单
					order = contactsService.setDefaultContacts(customerEntity.getEbccId(), true);
				}
				//联系人界面跳转
				if(ebsaId!=null&&!StringUtil.isEmpty(ebsaId)){
				    ContactsEntity contactsEntity = contactsService.queryContactsById(ebsaId,customerEntity.getEbccId().toString());
                    if (contactsEntity == null) {
                        ActionContext ctx = ActionContext.getContext();
                        ctx.getSession().put(SessionConstants.SESSION_USER_INFO.USER_INFO, null);
                        //设置登陆类型
                        ctx.getSession().put(SessionConstants.SESSION_USER_INFO.LOGIN_TYPE, null);
                        //退出到首页
                        return "exit";
                    }
				    order = myOrderService.createOrderByContact(contactsEntity);
				}
				
			} catch (Exception e) {
				logger.error("查询订单异常"+e.getMessage());
			}
			return returnSuccess();
		}
		
		/**
		 * 公用订单id查询
		 * 2015年12月22日
		 * @author Dy
		 */
		@PermissionCheck
		public String queryMyOrderByOrderId(){
			logger.info("queryMyOrderDetail:查询订单信息");
			try {
				order = myOrderService.queryOrderDetail(orderId);
			} catch (BusinessException e) {
				return returnError(e);
			}
			return returnSuccess();
		}
		
		/**
		 * 订单号查询功能
		 * 2015年12月23日
		 * @author Dy
		 */
		@PermissionCheck
		public String queryOrderByOrderNo(){
			CustomerContactEntity currentUser = getCurrentUser();
			queryVo.setCustomerId(currentUser.getEbccId());
			try {
				List<MyOrdersVo> result = myOrderService.selectOrdersList(queryVo);
				if(result!=null&&result.size()>0){
					orderVo = result.get(0);
				}
			} catch (BusinessException e) {
				logger.info("查询的订单号:"+queryVo.getOrderNo());
				return returnError(e);
			}
			return returnSuccess();
		}
		
		/**
		 * 下单
		 * 2015年12月22日
		 * @author Dy
		 */
		@PermissionCheck
		public String createOrModifyMyOrder(){
			logger.info("createMyOrder:创建订单！");
			CustomerContactEntity currentUser = getCurrentUser();
			try {
				this.order.setEinoEbccId(currentUser.getEbccId().longValue());
				//下单时间
				this.order.setEinoOrderDate(new Date());
				//保存订单
				//oms接口信息
				CustomerServicePortType port = omsOrderService.getCustomerService();
				EiNetOrderReqModel netOrder = new EiNetOrderReqModel();
				if(this.order!=null&&StringUtils.isEmpty(this.order.getEinoId())){
					//保存订单
					orderService.createOrder(this.order);
					logger.info("本地创建订单成功,订单号:"+order.getEinoContractNo());
					//自动保存收发货人
					//orderService.saveContacts(this.order);
					orderService.copyNetOrderToEiNetOrder(this.order, netOrder,omsOrderService.getObjectFactory(),0);
					//保存订单到oms
					port.saveNetOrder(netOrder);
					logger.info("下单到oms成功");
				}else{
					//修改本地订单
					orderService.updateOrder(this.order);
					//值转换
					orderService.copyNetOrderToEiNetOrder(this.order, netOrder,omsOrderService.getObjectFactory(),0);
					//更新OMS订单
					port.updateNetOrder(netOrder);
				}
			} catch (BusinessException e) {
				logger.error("系统异常"+e.getMessage());
				return returnError(e);
			}
			return returnSuccess();
		}
		
		/**
		 * 查询订单列表 
		 * 2015年12月18日
		 * @author Dy
		 */
		@PermissionCheck
		public String queryMyOrdersList(){
			logger.info("queryMyOrdersList:进入订单管理界面！");
			CustomerContactEntity currentUser = getCurrentUser();
			queryVo.setCustomerId(currentUser.getEbccId());
			try {
				//首次加载
				if(StringUtil.isEmpty(doneType)) {
					queryVo.setOffset(pageNo);
					//未完成
					queryVo.setDoneType("undone");
					undoneOrders = myOrderService.selectOrdersList(queryVo);
					//已完成
					queryVo.setDoneType("done");
					doneOrders = myOrderService.selectOrdersList(queryVo);
				}else {
					queryVo.setOffset(pageNo);
					if("undone".equals(doneType)) {
						//只加载未完成
						queryVo.setDoneType(doneType);
						undoneOrders = myOrderService.selectOrdersList(queryVo);
						return "more";
					}else if("done".equals(doneType)){
						//只加载已完成
						queryVo.setDoneType(doneType);
						doneOrders = myOrderService.selectOrdersList(queryVo);
						return "more";
					}
				}
			} catch (Exception e) {
				logger.error("queryMyOrdersList:查询订单异常"+e.getMessage());
			}
			return returnSuccess();
		}
		
		/**
		 * 撤销订单
		 * 2015年12月22日
		 * @author Dy
		 */
		@PermissionCheck
		public String cancelOrder(){
			try {
				myOrderService.updateOrderStatus(orderId);
			} catch (BusinessException e) {
				logger.error("cancelOrder:撤销订单异常"+e.getMessage());
			}
			return returnSuccess();
		}
		
		/**
		 * 
		 * 2015年12月23日
		 * 运单列表
		 * @author Dy
		 */
		@PermissionCheck
		public String queryMyWaybills(){
			CustomerContactEntity customerEntity = getCurrentUser();
			try {
				queryWaybillEntity.setCustomerId(customerEntity.getEbccId());
				queryWaybillEntity.setPageSize(10);
				queryWaybillEntity.setOffset((pageNo-1)*queryWaybillEntity.getPageSize());
				waybills = waybillService.queryWaybillResult(queryWaybillEntity);
				if(pageNo>1)
				return "more";
			} catch (BusinessException e) {
				logger.error("queryMyWaybills:查询运单异常"+e.getMessage());
			}
			return returnSuccess();
		}
		
		/**
		 * 
		 * 2015年12月29日
		 * @author Dy
		 */
		@PermissionCheck
		public String getWayBillDetail(){
			List<String> transNos = new ArrayList<String>();
			try {
				if(StringUtil.isNotEmpty(queryWaybillEntity.getTransNo())){
					transNos.add(queryWaybillEntity.getTransNo());
					goodsTraceResult =  getYdTraceManager.getYdTraceList(transNos);
				}
			} catch (Exception e) {
				logger.error("getWayBillDetail:运单详情异常"+e.getMessage());
			}
			return returnSuccess();
		}
		/**
		 *获取登录信息 
		 * 2015年12月23日
		 * @author Dy
		 */
		private CustomerContactEntity getCurrentUser(){
			CustomerContactEntity po  = (CustomerContactEntity) ActionContext.getContext().getSession().get(SessionConstants.SESSION_USER_INFO.USER_INFO);
			if (po == null) {
				throw new OBHException(OBHException.NOT_LOGIN, "未登录");
			}
			return po;
		}

		public QueryOrderVo getQueryVo() {
			return queryVo;
		}

		public void setQueryVo(QueryOrderVo queryVo) {
			this.queryVo = queryVo;
		}

		public List<ContactsEntity> getShipperContacts() {
			return shipperContacts;
		}

		public void setShipperContacts(List<ContactsEntity> shipperContacts) {
			this.shipperContacts = shipperContacts;
		}

		public List<ContactsEntity> getConsigneeContacts() {
			return consigneeContacts;
		}

		public void setConsigneeContacts(List<ContactsEntity> consigneeContacts) {
			this.consigneeContacts = consigneeContacts;
		}

		public List<MyOrdersVo> getUndoneOrders() {
			return undoneOrders;
		}

		public void setUndoneOrders(List<MyOrdersVo> undoneOrders) {
			this.undoneOrders = undoneOrders;
		}

		public List<MyOrdersVo> getDoneOrders() {
			return doneOrders;
		}

		public void setDoneOrders(List<MyOrdersVo> doneOrders) {
			this.doneOrders = doneOrders;
		}

		public NetOrderEntity getOrder() {
			return order;
		}

		public void setOrder(NetOrderEntity order) {
			this.order = order;
		}

		public Integer getOrderId() {
			return orderId;
		}

		public void setOrderId(Integer orderId) {
			this.orderId = orderId;
		}

		public MyOrdersVo getOrderVo() {
			return orderVo;
		}

		public void setOrderVo(MyOrdersVo orderVo) {
			this.orderVo = orderVo;
		}

		public QueryWaybillEntity getQueryWaybillEntity() {
			return queryWaybillEntity;
		}

		public void setQueryWaybillEntity(QueryWaybillEntity queryWaybillEntity) {
			this.queryWaybillEntity = queryWaybillEntity;
		}

		public GoodsTraceResultVo getGoodsTraceResult() {
			return goodsTraceResult;
		}

		public void setGoodsTraceResult(GoodsTraceResultVo goodsTraceResult) {
			this.goodsTraceResult = goodsTraceResult;
		}

		public List<WaybillResultEntity> getWaybills() {
			return waybills;
		}

		public void setWaybills(List<WaybillResultEntity> waybills) {
			this.waybills = waybills;
		}

		public String getEbsaId() {
			return ebsaId;
		}

		public void setEbsaId(String ebsaId) {
			this.ebsaId = ebsaId;
		}

		public String getDoneType() {
			return doneType;
		}

		public void setDoneType(String doneType) {
			this.doneType = doneType;
		}

		public Integer getPageNo() {
			return pageNo;
		}

		public void setPageNo(Integer pageNo) {
			this.pageNo = pageNo;
		}
		/*******************调试结束*******************/
}
