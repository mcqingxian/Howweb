package com.hoau.mhow.module.bse.api.shared.vo;


/**
 * @author：莫涛
 * @create：2015年5月28日 下午4:48:26
 * @description：
 */
public class PriceQueryVo {
	/**
	 * 目的城市
	 */
	private String conCity;
	/**
	 * 目的区县
	 */
	private String conCounty;
	/**
	 * 发货城市
	 */
	private String shipperCity;
	/**
	 * 发货区县
	 */
	private String shipperCounty;
	/**
	 *  产品类型： 这里直接是ID
		普通零担
		100001
		定日达
		100000
	 */
	private String productTypeId;
	/**
	 * 重量
	 */
	private Double weight;
	/**
	 * 体积
	 */
	private Double volumn;
	/**
	 * 保价
	 */
	private Double insurance;
	/**
	 * 代收货款
	 */
	private Double collDeliveryAmount;
	public String getConCity() {
		return conCity;
	}
	public void setConCity(String conCity) {
		this.conCity = conCity;
	}
	public String getConCounty() {
		return conCounty;
	}
	public void setConCounty(String conCounty) {
		this.conCounty = conCounty;
	}
	public String getShipperCity() {
		return shipperCity;
	}
	public void setShipperCity(String shipperCity) {
		this.shipperCity = shipperCity;
	}
	public String getShipperCounty() {
		return shipperCounty;
	}
	public void setShipperCounty(String shipperCounty) {
		this.shipperCounty = shipperCounty;
	}
	public String getProductTypeId() {
		return productTypeId;
	}
	public void setProductTypeId(String productTypeId) {
		this.productTypeId = productTypeId;
	}
	public Double getWeight() {
		return weight;
	}
	public void setWeight(Double weight) {
		this.weight = weight;
	}
	public Double getVolumn() {
		return volumn;
	}
	public void setVolumn(Double volumn) {
		this.volumn = volumn;
	}
	public Double getInsurance() {
		return insurance;
	}
	public void setInsurance(Double insurance) {
		this.insurance = insurance;
	}
	public Double getCollDeliveryAmount() {
		return collDeliveryAmount;
	}
	public void setCollDeliveryAmount(Double collDeliveryAmount) {
		this.collDeliveryAmount = collDeliveryAmount;
	}
}
