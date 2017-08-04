package com.hoau.mhow.module.bse.api.shared.vo;



/**
* @ClassName: PriceCalcRespVo
* @Description:
* @author hairen.long@hoau.net
* @date 2015年6月17日 下午5:41:15
*/
public class PriceCalcRespVo {
	//运输类型
	private String transType;
	//货物类型
	private String goodsType;
	//运输时效
	private String transAging;
	//交通运输费
	private String transCost;
	//保价费
	private String insuredCost;
	//燃油费
	private String fuelCost;
	//工本费
	private String laborCost;
	//信息费
	private String messageCost;
	//代收货款手续费
	private String collProceCost;
	//总价
	private String totalCost;
	
	public String getTransType() {
		return transType;
	}
	public void setTransType(String transType) {
		this.transType = transType;
	}
	public String getGoodsType() {
		return goodsType;
	}
	public void setGoodsType(String goodsType) {
		this.goodsType = goodsType;
	}
	public String getTransAging() {
		return transAging;
	}
	public void setTransAging(String transAging) {
		this.transAging = transAging;
	}
	public String getTransCost() {
		return transCost;
	}
	public void setTransCost(String transCost) {
		this.transCost = transCost;
	}
	public String getInsuredCost() {
		return insuredCost;
	}
	public void setInsuredCost(String insuredCost) {
		this.insuredCost = insuredCost;
	}
	public String getFuelCost() {
		return fuelCost;
	}
	public void setFuelCost(String fuelCost) {
		this.fuelCost = fuelCost;
	}
	public String getLaborCost() {
		return laborCost;
	}
	public void setLaborCost(String laborCost) {
		this.laborCost = laborCost;
	}
	public String getMessageCost() {
		return messageCost;
	}
	public void setMessageCost(String messageCost) {
		this.messageCost = messageCost;
	}
	public String getCollProceCost() {
		return collProceCost;
	}
	public void setCollProceCost(String collProceCost) {
		this.collProceCost = collProceCost;
	}
	public String getTotalCost() {
		return totalCost;
	}
	public void setTotalCost(String totalCost) {
		this.totalCost = totalCost;
	}
}
