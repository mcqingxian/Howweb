package com.hoau.how.module.obh.shared.vos;

import java.math.BigDecimal;

import com.hoau.hbdp.framework.entity.BaseEntity;

/**
 * 安装明细实体
 *
 * @author 莫涛
 * @date 2016年5月4日下午8:03:38
 */
public class InstallDetailEntity extends BaseEntity{
	/**
	 *
	 */
	private static final long serialVersionUID = -4965718174963097708L;
	//主键
	String id;
	//订单ID
	String orderId;
	//编码
	String code;
	//名称
	String name;
	//件数
	BigDecimal number;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public BigDecimal getNumber() {
		return number;
	}
	public void setNumber(BigDecimal number) {
		this.number = number;
	}
}
