/**
 * 
 */
package com.hoau.wechat.action;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.hoau.wechat.service.IEffectivePriceService;
import com.hoau.wechat.util.JsonUtils;
import com.hoau.wechat.util.StringUtil;
import com.hoau.wechat.vo.CountFreightResult;
import com.hoau.wechat.vo.County;
import com.hoau.wechat.vo.PricingResult;
import com.opensymphony.xwork2.Action;

/**
 * @author gaojia
 * 
 */
@Controller
@Scope("prototype")
public class EffectivePriceAction implements Action {
	@Resource
	private IEffectivePriceService effectivePriceService;
	/**
	 * 省份列表
	 */
	private List<String> provinces;
	/**
	 * 省份参数
	 */
	private String province;
	/**
	 * 城市列表
	 */
	private List<String> citys;
	/**
	 * 城市参数
	 */
	private String city;
	/**
	 * 区域列表
	 */
	private List<County> countys;
	/**
	 * 出发城市
	 */
	private String departCity;
	/**
	 * 到达城市
	 */
	private String destCity;
	/**
	 * 重量
	 */
	private double weight;
	/**
	 * 体积
	 */
	private double volume;
	/**
	 * 时效查询结果
	 */
	private List<PricingResult> pricings;

	private List<CountFreightResult> countFreights;

	@Override
	public String execute() throws Exception {
		// provinces = JsonUtils.toList(effectivePriceService.queryProvince(),
		// String.class);
		return SUCCESS;
	}

	/**
	 * 查询省份
	 * 
	 * @return
	 * @throws Exception 
	 */
	public String queryProvince()  {
		provinces = JsonUtils.toList(effectivePriceService.queryProvince(),
				String.class);
		return SUCCESS;
	}

	/**
	 * 查询城市
	 * 
	 * @return
	 */
	public String queryCity() {
		citys = JsonUtils.toList(
				effectivePriceService.queryCityByProvince(province),
				String.class);
		return SUCCESS;
	}

	/**
	 * 查询区域
	 * 
	 * @return
	 */
	public String queryCounty() {
		countys = JsonUtils.toList(
				effectivePriceService.queryCountyByCity(province, city),
				County.class);
		return SUCCESS;
	}

	/**
	 * 查询时效
	 * 
	 * @return
	 */
	public String queryPricingByCity() {
		if(StringUtil.isNotEmpty(departCity)&&StringUtil.isNotEmpty(destCity)){
			pricings = JsonUtils.toList(
					effectivePriceService.queryPricingByCity(departCity, destCity),
					PricingResult.class);
		}
		return SUCCESS;
	}

	public String countFreight() {
		if(StringUtil.isNotEmpty(departCity)&&StringUtil.isNotEmpty(destCity)){
			pricings = JsonUtils.toList(
					effectivePriceService.queryPricingByCity(departCity, destCity),
					PricingResult.class);
			countFreights = new ArrayList<CountFreightResult>();
			for (PricingResult pricing : pricings) {
				
				CountFreightResult re = new CountFreightResult();
				if ("ONTIME".equals(pricing.getServiceType())) {
					re.setProduct("定日达");
				} else if ("LESSLOADED".equals(pricing.getServiceType())) {
					re.setProduct("经济快运");
				}
				re.setDeliveryTime(pricing.getDeliveryTime());
				re.setPickupTime(pricing.getPickupTime());
				double weightFreight = weight
						* (Double.parseDouble(pricing.getHeavyWeightPrice()));
				double volumeFreight = volume
						* (Double.parseDouble(pricing.getLightWeightPrice()));
				DecimalFormat df = new DecimalFormat("#.00");
				if (weightFreight > volumeFreight) {
					re.setFreight(df.format(weightFreight > Double.parseDouble(pricing
							.getBasePrice()) ? weightFreight : Double
							.parseDouble(pricing.getBasePrice())));
				} else {
					re.setFreight(df.format(volumeFreight > Double.parseDouble(pricing
							.getBasePrice()) ? volumeFreight : Double
							.parseDouble(pricing.getBasePrice())));
				}
				countFreights.add(re);
			}
		}
		return SUCCESS;
	}

	public List<String> getProvinces() {
		return provinces;
	}

	public void setEffectivePriceService(
			IEffectivePriceService effectivePriceService) {
		this.effectivePriceService = effectivePriceService;
	}

	public void setProvinces(List<String> provinces) {
		this.provinces = provinces;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public List<String> getCitys() {
		return citys;
	}

	public void setCitys(List<String> citys) {
		this.citys = citys;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public List<County> getCountys() {
		return countys;
	}

	public void setCountys(List<County> countys) {
		this.countys = countys;
	}

	public String getDepartCity() {
		return departCity;
	}

	public void setDepartCity(String departCity) {
		this.departCity = departCity;
	}

	public String getDestCity() {
		return destCity;
	}

	public void setDestCity(String destCity) {
		this.destCity = destCity;
	}

	public List<PricingResult> getPricings() {
		return pricings;
	}

	public void setPricings(List<PricingResult> pricings) {
		this.pricings = pricings;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public double getVolume() {
		return volume;
	}

	public void setVolume(double volume) {
		this.volume = volume;
	}

	public List<CountFreightResult> getCountFreights() {
		return countFreights;
	}

	public void setCountFreights(List<CountFreightResult> countFreights) {
		this.countFreights = countFreights;
	}

}
