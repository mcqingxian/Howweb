package com.hoau.wechat.vo;

import java.util.Date;

public class Configure {
	//订单来源编号
	private String key;
	//订单来源渠道
	private String value;
	//订单来源类型
	private String type;
	//是否进行中 Y N
	private String active;
	//优惠券张数
	private int vouchersCount;
	//优惠券面值
	private int parValue;
	//活动开始时间
	private Date startTime;
	//活动结束时间
	private Date endTime;
	
	
	public int getVouchersCount() {
		return vouchersCount;
	}
	public void setVouchersCount(int vouchersCount) {
		this.vouchersCount = vouchersCount;
	}
	public int getParValue() {
		return parValue;
	}
	public void setParValue(int parValue) {
		this.parValue = parValue;
	}
	public Date getStartTime() {
		return startTime;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getActive() {
		return active;
	}
	public void setActive(String active) {
		this.active = active;
	}
	
	
}
