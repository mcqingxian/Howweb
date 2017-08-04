package com.hoau.how.module.itf.shared.vos.pricetime;

import java.math.BigDecimal;

/**
 * @author：莫涛
 * @create：2015年5月29日 上午9:10:40
 * @description：
 */
public class PriceCalcVo {
	//运输类型
	String tranType;
	//运费
	String transCharge;
	//保价费
	String insuranceCharge;
	//代收货款费
	String collDeliveryCharge;
	//费用合计
	String chargeTotal;
	public String getTranType() {
		return tranType;
	}
	public void setTranType(String tranType) {
		this.tranType = tranType;
	}
	public String getTransCharge() {
		return transCharge;
	}
	public void setTransCharge(String transCharge) {
		this.transCharge = transCharge;
	}
	public String getInsuranceCharge() {
		return insuranceCharge;
	}
	public void setInsuranceCharge(String insuranceCharge) {
		this.insuranceCharge = insuranceCharge;
	}
	public String getCollDeliveryCharge() {
		return collDeliveryCharge;
	}
	public void setCollDeliveryCharge(String collDeliveryCharge) {
		this.collDeliveryCharge = collDeliveryCharge;
	}
	public String getChargeTotal() {
		return chargeTotal;
	}
	public void setChargeTotal(String chargeTotal) {
		this.chargeTotal = chargeTotal;
	}
}
