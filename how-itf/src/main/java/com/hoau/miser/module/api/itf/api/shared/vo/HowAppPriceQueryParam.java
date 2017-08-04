package com.hoau.miser.module.api.itf.api.shared.vo;
/**   
* @Title: HowAppPriceQueryParam
* @Package com.hoau.miser.module.api.itf.api.shared.vo 
* @Description: 官方APP价格查询接口入参
* @author 陈宇霖  
* @date 2016/12/22 17:35
* @version V1.0   
*/
public class HowAppPriceQueryParam {

	/**
	 * 出发省份名称
	 */
	private String sendProvinceName;

	/**
	 * 出发城市名称
	 */
	private String sendCityName;

	/**
	 * 出发区县名称
	 */
	private String sendCountyName;

	/**
	 * 到达省份名称
	 */
	private String arrivalProvinceName;

	/**
	 * 到达城市名称
	 */
	private String arrivalCityName;

	/**
	 * 到达区县名称
	 */
	private String arrivalCountyName;

	public String getSendProvinceName() {
		return sendProvinceName;
	}

	public void setSendProvinceName(String sendProvinceName) {
		this.sendProvinceName = sendProvinceName;
	}

	public String getSendCityName() {
		return sendCityName;
	}

	public void setSendCityName(String sendCityName) {
		this.sendCityName = sendCityName;
	}

	public String getSendCountyName() {
		return sendCountyName;
	}

	public void setSendCountyName(String sendCountyName) {
		this.sendCountyName = sendCountyName;
	}

	public String getArrivalProvinceName() {
		return arrivalProvinceName;
	}

	public void setArrivalProvinceName(String arrivalProvinceName) {
		this.arrivalProvinceName = arrivalProvinceName;
	}

	public String getArrivalCityName() {
		return arrivalCityName;
	}

	public void setArrivalCityName(String arrivalCityName) {
		this.arrivalCityName = arrivalCityName;
	}

	public String getArrivalCountyName() {
		return arrivalCountyName;
	}

	public void setArrivalCountyName(String arrivalCountyName) {
		this.arrivalCountyName = arrivalCountyName;
	}
}
