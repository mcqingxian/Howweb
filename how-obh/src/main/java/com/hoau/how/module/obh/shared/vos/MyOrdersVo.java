package com.hoau.how.module.obh.shared.vos;

import java.util.List;

/**
 * @author：龙海仁
 * @create：2015年8月3日 下午1:30:07
 * @description：
 */
public class MyOrdersVo {
	private Integer number;
	/**
	 * 订单ID
	 */
	private Integer orderId;
	/**
	 * 订单号
	 */
	private String orderNo;
	/**
	 * 运单号
	 */
	private String wayBill;
	/**
	 * 下单时间
	 */
	private String orderDate;
	/**
	 * 收货人
	 */
	private String consigneeName;
	/**
	 * 
	 */
	private String consignerName;
	/**
	 * 收货人手机
	 */
	private String consigneePhone;
	/**
	 * 付款方式
	 */
	private String paymentWay;
	/**
	 * 货物名称
	 */
	private String goodsName;
	/**
	 * 货物数量
	 */
	private Integer goodsCount;
	/**
	 * 总费用
	 */
	private Double chargeTotal;
	/**
	 * 订单状态
	 */
	private String orderStatus;
	
	/**
	 * 起运地
	 */
	private String departure;
	/**
	 * 目的地
	 */
	private String destination;
	/**
	 * 收货人电话
	 */
	private String consigneeTel;
	/**
	 * 收货人地址
	 */
	private String consigneeAddess;
	/**
	 * 送货方式
	 */
	private String deliveryWay;
	/**
	 * 运输类型
	 */
	private String productType;
	/**
	 * 网厅订单号
	 */
	private String contractNo;
	/**
	 * 标签
	 */
	private List<String> labels;
	
	/**
	 * 收货省
	 */
	private String consigneeProvince;
	
	/**
	 * 收货城市
	 */
	private String consigneeCity;
	
	public String getConsigneeProvince() {
		return consigneeProvince;
	}
	public void setConsigneeProvince(String consigneeProvince) {
		this.consigneeProvince = consigneeProvince;
	}
	public String getConsigneeCity() {
		return consigneeCity;
	}
	public void setConsigneeCity(String consigneeCity) {
		this.consigneeCity = consigneeCity;
	}
	public Integer getNumber() {
		return number;
	}
	public void setNumber(Integer number) {
		this.number = number;
	}
	public String getProductType() {
		return productType;
	}
	public void setProductType(String productType) {
		this.productType = productType;
	}
	public String getPaymentWay() {
		return paymentWay;
	}
	public void setPaymentWay(String paymentWay) {
		this.paymentWay = paymentWay;
	}
	public Integer getOrderId() {
		return orderId;
	}
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
	public String getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	public String getWayBill() {
		return wayBill;
	}
	public void setWayBill(String wayBill) {
		this.wayBill = wayBill;
	}
	public String getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}
	public String getConsigneeName() {
		return consigneeName;
	}
	public void setConsigneeName(String consigneeName) {
		this.consigneeName = consigneeName;
	}
	public String getConsigneePhone() {
		return consigneePhone;
	}
	public void setConsigneePhone(String consigneePhone) {
		this.consigneePhone = consigneePhone;
	}
	public String getGoodsName() {
		return goodsName;
	}
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	public Integer getGoodsCount() {
		return goodsCount;
	}
	public void setGoodsCount(Integer goodsCount) {
		this.goodsCount = goodsCount;
	}
	public Double getChargeTotal() {
		return chargeTotal;
	}
	public void setChargeTotal(Double chargeTotal) {
		this.chargeTotal = chargeTotal;
	}
	public String getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
	public List<String> getLabels() {
		return labels;
	}
	public void setLabels(List<String> labels) {
		this.labels = labels;
	}
	public String getDeparture() {
		return departure;
	}
	public void setDeparture(String departure) {
		this.departure = departure;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public String getConsigneeTel() {
		return consigneeTel;
	}
	public void setConsigneeTel(String consigneeTel) {
		this.consigneeTel = consigneeTel;
	}
	public String getConsigneeAddess() {
		return consigneeAddess;
	}
	public void setConsigneeAddess(String consigneeAddess) {
		this.consigneeAddess = consigneeAddess;
	}
	public String getDeliveryWay() {
		return deliveryWay;
	}
	public void setDeliveryWay(String deliveryWay) {
		this.deliveryWay = deliveryWay;
	}
	public String getContractNo() {
		return contractNo;
	}
	public void setContractNo(String contractNo) {
		this.contractNo = contractNo;
	}
	public String getConsignerName() {
		return consignerName;
	}
	public void setConsignerName(String consignerName) {
		this.consignerName = consignerName;
	}
	
}
