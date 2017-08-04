package com.hoau.how.module.obh.shared.vos;

import java.io.Serializable;

/**
 * @author：龙海仁
 * @create：2015年7月31日 下午10:49:22
 * @description：查询订单Vo
 */
public class QueryOrderVo implements Serializable{

	/**
	 *
	 */
	private static final long serialVersionUID = -6154840544551695745L;
	
	/**
	 * 客户ID
	 */
	private Long customerId;
	/**
	 * 订单号
	 */
	private String orderNo;
	/**
	 * 收货人
	 */
	private String consignee;
	/**
	 * 货物名称
	 */
	private String goodsName;
	/**
	 * 付款方式
	 */
	private String paymentWay;
	/**
	 * 查询时间范围
	 */
	private String startQueryTime;
	private String endQueryTime;
	/**
	 * 物流状态
	 */
	private String logisticsStatus;
	private Integer offset;
	private Integer pageSize;
	
	private String keyWord;
	
	public String getKeyWord() {
		return keyWord;
	}
	public void setKeyWord(String keyWord) {
		this.keyWord = keyWord;
	}
	public Long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
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
	public String getStartQueryTime() {
		return startQueryTime;
	}
	public void setStartQueryTime(String startQueryTime) {
		this.startQueryTime = startQueryTime;
	}

	public String getEndQueryTime() {
		return endQueryTime;
	}
	public void setEndQueryTime(String endQueryTime) {
		this.endQueryTime = endQueryTime;
	}
	public String getLogisticsStatus() {
		return logisticsStatus;
	}
	public void setLogisticsStatus(String logisticsStatus) {
		this.logisticsStatus = logisticsStatus;
	}
	public Integer getOffset() {
		return offset;
	}
	public void setOffset(Integer offset) {
		this.offset = offset;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	

}
