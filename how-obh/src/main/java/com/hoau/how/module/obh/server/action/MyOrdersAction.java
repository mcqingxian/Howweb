package com.hoau.how.module.obh.server.action;

import java.io.InputStream;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.hoau.hbdp.framework.exception.BusinessException;
import com.hoau.hbdp.framework.server.web.action.AbstractAction;
import com.hoau.hbdp.framework.server.web.result.json.annotation.JSON;
import com.hoau.how.module.common.constants.ControllConstants;
import com.hoau.how.module.common.constants.SessionConstants;
import com.hoau.how.module.obh.server.service.IMyOrdersService;
import com.hoau.how.module.obh.shared.domain.CustomerContactEntity;
import com.hoau.how.module.obh.shared.domain.NetOrderEntity;
import com.hoau.how.module.obh.shared.util.PermissionCheck;
import com.hoau.how.module.obh.shared.vos.MyOrdersVo;
import com.hoau.how.module.obh.shared.vos.QueryOrderVo;
import com.hoau.how.module.util.JsonUtils;
import com.hoau.how.module.util.date.DateUtils;
import com.opensymphony.xwork2.ActionContext;

/**
 * @author：龙海仁
 * @create：2015年7月31日 上午10:29:37
 * @description：
 */
@Controller
@Scope("prototype")
public class MyOrdersAction extends AbstractAction{

	/**
	 *
	 */
	private static final long serialVersionUID = -8169459549798418152L;
//	private Logger logger = Logger.getLogger(MyOrdersAction.class);
	
	@Resource
	private IMyOrdersService myOrderService;
	
	//in
	private QueryOrderVo queryVo;
	private Integer pageSize;
	private Integer pageNo = 1;
	private Integer orderId;
	private String orderIdList;
	
	private String orderNo;
	private String consignee;
	private String goodsName;
	private String paymentWay;
	private String createTimeFrom;
	private String createTimeTo;
	private String orderStatus;
	
	//out
	private String controllType;
	private List<MyOrdersVo> orders;
	private NetOrderEntity entity;
	private InputStream excelStream;
	private String fromPage;
	private String categoryName;
	private String fileName;
	
	@PermissionCheck
	public String modifyOrder(){
		try {
			HttpServletRequest request = ServletActionContext.getRequest();
			Long long1 = getCurrentUser().getEbccId();
			entity = myOrderService.queryOrderDetail(orderId,long1);
			request.setAttribute("entity",entity);
			fromPage = "modify";
			return "modify";
		} catch (Exception e) {
			return "error";
		}
		
	}
	
	@JSON
	@PermissionCheck
	/**取消订单*/
	public String cancelOrder(){
		try {
			Long long1 = getCurrentUser().getEbccId();
			myOrderService.updateOrderStatus(orderId,long1);
			return "cancelOrderJson";
		} catch (BusinessException e) {
			return returnError(e.getErrorCode());
		}
	}
	
	@PermissionCheck
	@JSON
	public String deleteOrder(){
		try {
			Long long1 = getCurrentUser().getEbccId();
			myOrderService.deleteOrder(orderId,long1);
			return "deleteOrderJson";
		} catch (BusinessException e) {
			return returnError(e.getErrorCode());
		}
	}
	
	@PermissionCheck
	@JSON
	public String printOrders(){
		try {
			Long long1 = getCurrentUser().getEbccId();
			orders = myOrderService.getPrintOrders(orderIdList,long1);
			return "printOrderJson";
		} catch (BusinessException e) {
			return returnError(e.getErrorCode());
		}
	}
	
	@PermissionCheck(isExport=true)
	public String export() throws Exception {
		CustomerContactEntity currentUser = getCurrentUser();
		try {
			String dateStr = DateUtils.formatDateYYYYMMDD(new Date());
			fileName = "我的订单"+dateStr+".xlsx";
			fileName = new String(fileName.getBytes(), "ISO8859-1");
			QueryOrderVo vo = packageQueryVo();
			excelStream = myOrderService.getExcel(currentUser, vo);
			return returnSuccess();
		} catch (BusinessException e) {
			return returnError(e.getErrorCode());
		}
	}
	
	@JSON
	@PermissionCheck
	public String qeuryOrderDetail(){
		try {
			Long long1 = getCurrentUser().getEbccId();
			entity = myOrderService.queryOrderDetail(orderId,long1);
			return "detailOrderJson";
		} catch (BusinessException e) {
			return returnError(e.getErrorCode());
		}
	}
	
	@PermissionCheck
	public String queryMyOrders(){
		try {
			this.controllType = ControllConstants.CONTROLL_MY_HOAU.ALL_ORDERS;
			CustomerContactEntity customer = getCurrentUser();
			orders = myOrderService.queryMyOrders(customer, queryVo, pageNo, pageSize);
			this.totalCount = myOrderService.queryMyOrdersCount(customer, queryVo);
			System.out.println(JsonUtils.toJson(queryVo));
		} catch (Exception e) {
			this.controllType = ControllConstants.CONTROLL_MY_HOAU.ALL_ORDERS;
			return "error";
		}
		return SUCCESS;
	}
	
	private CustomerContactEntity getCurrentUser(){
		ActionContext ctx = ActionContext.getContext();
		CustomerContactEntity po = (CustomerContactEntity)ctx.getSession().get(SessionConstants.SESSION_USER_INFO.USER_INFO);
		return po;
	}
	
	private QueryOrderVo packageQueryVo(){
		QueryOrderVo vo = new QueryOrderVo();
		vo.setConsignee(this.consignee);
		vo.setEndQueryTime(this.createTimeTo);
		vo.setStartQueryTime(this.createTimeFrom);
		vo.setGoodsName(this.goodsName);
		vo.setLogisticsStatus(this.orderStatus);
		vo.setOrderNo(this.orderNo);
		vo.setPaymentWay(this.paymentWay);
		return vo;
	}

	public String getFromPage() {
		return fromPage;
	}

	public void setFromPage(String fromPage) {
		this.fromPage = fromPage;
	}

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public String getControllType() {
		return controllType;
	}
	public void setControllType(String controllType) {
		this.controllType = controllType;
	}
	public QueryOrderVo getQueryVo() {
		return queryVo;
	}
	public void setQueryVo(QueryOrderVo queryVo) {
		this.queryVo = queryVo;
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

	public List<MyOrdersVo> getOrders() {
		return orders;
	}

	public void setOrders(List<MyOrdersVo> orders) {
		this.orders = orders;
	}

	public InputStream getExcelStream() {
		return excelStream;
	}

	public void setExcelStream(InputStream excelStream) {
		this.excelStream = excelStream;
	}

	public NetOrderEntity getEntity() {
		return entity;
	}

	public void setEntity(NetOrderEntity entity) {
		this.entity = entity;
	}

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public String getConsignee() {
		return consignee;
	}

	public void setConsignee(String consignee) {
		this.consignee = consignee;
	}

	public String getGoodsName() {
		return goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	public String getPaymentWay() {
		return paymentWay;
	}

	public void setPaymentWay(String paymentWay) {
		this.paymentWay = paymentWay;
	}

	public String getCreateTimeFrom() {
		return createTimeFrom;
	}

	public void setCreateTimeFrom(String createTimeFrom) {
		this.createTimeFrom = createTimeFrom;
	}

	public String getCreateTimeTo() {
		return createTimeTo;
	}

	public void setCreateTimeTo(String createTimeTo) {
		this.createTimeTo = createTimeTo;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public String getOrderIdList() {
		return orderIdList;
	}

	public void setOrderIdList(String orderIdList) {
		this.orderIdList = orderIdList;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
}
