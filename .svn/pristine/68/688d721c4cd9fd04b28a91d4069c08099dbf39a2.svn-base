package com.hoau.wechat.service.impl;

import org.springframework.stereotype.Service;

import com.hoau.wechat.constant.NetRequestConstant;
import com.hoau.wechat.service.IEffectivePriceService;
import com.hoau.wechat.utils.NetUtil;
/**
 * 时效价格查询
 * @author gaojia
 *
 */
@Service
public class EffectivePriceService implements IEffectivePriceService{
	/**
	 * 查询省级区域
	 * @param 
	 */
	@Override
	public String queryProvince() {
		
		return NetUtil.getData(NetRequestConstant.PROVINCE_REQ);
	}
	/**
	 * 根据省查找市级
	 * @param province 省份
	 */
	@Override
	public String queryCityByProvince(String province) {
		// TODO Auto-generated method stub
		return NetUtil.getData(NetRequestConstant.PROVINCE_REQ+"/"+province+"/"+NetRequestConstant.CITY_REQ);
	}
	/**
	 * 根据市查找区县级
	 * @param city 城市
	 */
	@Override
	public String queryCountyByCity(String province,String city) {
		// TODO Auto-generated method stub
		return NetUtil.getData(NetRequestConstant.PROVINCE_REQ+"/"+province+"/"+NetRequestConstant.CITY_REQ+"/"+city+"/"+NetRequestConstant.COUNTY_REQ);
	}
	@Override
	public String queryPricingByCity(String departCity, String destCity) {
		// TODO Auto-generated method stub
		return NetUtil.getData(NetRequestConstant.PRICING_REQ+"/"+departCity+"/"+destCity);
	}

}
