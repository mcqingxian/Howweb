package com.hoau.wechat.service;
/**
 * 时效价格查询
 * @author gaojia
 *
 */
public interface IEffectivePriceService {
	String queryProvince();
	String queryCityByProvince(String province);
	String queryCountyByCity(String province,String city);
	String queryPricingByCity(String departCity, String destCity);
}
