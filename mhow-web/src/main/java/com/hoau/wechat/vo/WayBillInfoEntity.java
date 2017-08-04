package com.hoau.wechat.vo;

import java.util.Date;

public class WayBillInfoEntity {
	private String openid;
	private String wayBill;
	private String transType;
	private double totalCost;
	private String consignorPhone;
	private Date recordTime;
	private String orderSource;
	private int status ;//0 未送  1已送
	
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getOrderSource() {
		return orderSource;
	}
	public void setOrderSource(String orderSource) {
		this.orderSource = orderSource;
	}
	public String getOpenid() {
		return openid;
	}
	public void setOpenid(String openid) {
		this.openid = openid;
	}
	public String getWayBill() {
		return wayBill;
	}
	public void setWayBill(String wayBill) {
		this.wayBill = wayBill;
	}
	public String getTransType() {
		return transType;
	}
	public void setTransType(String transType) {
		this.transType = transType;
	}
	public double getTotalCost() {
		return totalCost;
	}
	public void setTotalCost(double totalCost) {
		this.totalCost = totalCost;
	}
	public String getConsignorPhone() {
		return consignorPhone;
	}
	public void setConsignorPhone(String consignorPhone) {
		this.consignorPhone = consignorPhone;
	}
	public Date getRecordTime() {
		return recordTime;
	}
	public void setRecordTime(Date recordTime) {
		this.recordTime = recordTime;
	}
	
}
