package com.hoau.miser.module.api.itf.api.shared.vo;

import java.math.BigDecimal;

/**
* @Title: HowAppPriceQueryPriceDetail
* @Package com.hoau.miser.module.api.itf.api.shared.vo 
* @Description: 官方APP价格查询价格明细
* @author 陈宇霖  
* @date 2016/12/22 19:07
* @version V1.0   
*/
public class HowAppPriceQueryPriceDetail {

	/**
	 * 运输类型编码
	 */
	private String transportTypeCode;

	/**
	 * 运输类型名称
	 */
	private String transportTypeName;

	/**
	 * 费用模式：0重量体积单价模式，1首重续重模式
	 */
	private String priceType;

	/**
	 * 重量单价
	 */
	private BigDecimal weightPrice;

	/**
	 * 体积单价
	 */
	private BigDecimal volumePrice;

	/**
	 * 最小运费
	 */
	private BigDecimal minFreightFee;

	/**
	 * 首重重量
	 */
	private BigDecimal firstSectionWeight;

	/**
	 * 首重金额
	 */
	private BigDecimal firstSectionPrice;

	/**
	 * 续重单价
	 */
	private BigDecimal addPrice;
	/**
	 * 自提时间
	 */
	private String pickTime;
	/**
	 * 派送时间
	 */
	private String deliveryTime;
	/**
	 * 备注
	 */
	private String reamrk;

	public String getTransportTypeCode() {
		return transportTypeCode;
	}

	public void setTransportTypeCode(String transportTypeCode) {
		this.transportTypeCode = transportTypeCode;
	}

	public String getTransportTypeName() {
		return transportTypeName;
	}

	public void setTransportTypeName(String transportTypeName) {
		this.transportTypeName = transportTypeName;
	}

	public String getPriceType() {
		return priceType;
	}

	public void setPriceType(String priceType) {
		this.priceType = priceType;
	}

	public BigDecimal getWeightPrice() {
		return weightPrice;
	}

	public void setWeightPrice(BigDecimal weightPrice) {
		this.weightPrice = weightPrice;
	}

	public BigDecimal getVolumePrice() {
		return volumePrice;
	}

	public void setVolumePrice(BigDecimal volumePrice) {
		this.volumePrice = volumePrice;
	}

	public BigDecimal getMinFreightFee() {
		return minFreightFee;
	}

	public void setMinFreightFee(BigDecimal minFreightFee) {
		this.minFreightFee = minFreightFee;
	}

	public BigDecimal getFirstSectionWeight() {
		return firstSectionWeight;
	}

	public void setFirstSectionWeight(BigDecimal firstSectionWeight) {
		this.firstSectionWeight = firstSectionWeight;
	}

	public BigDecimal getFirstSectionPrice() {
		return firstSectionPrice;
	}

	public void setFirstSectionPrice(BigDecimal firstSectionPrice) {
		this.firstSectionPrice = firstSectionPrice;
	}

	public BigDecimal getAddPrice() {
		return addPrice;
	}

	public void setAddPrice(BigDecimal addPrice) {
		this.addPrice = addPrice;
	}

	public String getPickTime() {
		return pickTime;
	}

	public void setPickTime(String pickTime) {
		this.pickTime = pickTime;
	}

	public String getDeliveryTime() {
		return deliveryTime;
	}

	public void setDeliveryTime(String deliveryTime) {
		this.deliveryTime = deliveryTime;
	}

	public String getReamrk() {
		return reamrk;
	}

	public void setReamrk(String reamrk) {
		this.reamrk = reamrk;
	}
}
