package com.hoau.miser.module.api.itf.api.shared.vo;

import java.util.List;

/**
* @Title: HowAppPriceQueryResult 
* @Package com.hoau.miser.module.api.itf.api.shared.vo 
* @Description: 官方App价格查询接口出参
* @author 陈宇霖  
* @date 2016/12/22 19:05
* @version V1.0   
*/
public class HowAppPriceQueryResult {

	/**
	 * 费用明细
	 */
	private List<HowAppPriceQueryPriceDetail> prices;

	public List<HowAppPriceQueryPriceDetail> getPrices() {
		return prices;
	}

	public void setPrices(List<HowAppPriceQueryPriceDetail> prices) {
		this.prices = prices;
	}
}
