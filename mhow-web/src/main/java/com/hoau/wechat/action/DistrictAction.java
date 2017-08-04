/**
 * 
 */
package com.hoau.wechat.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.hoau.wechat.entity.DistrictEntity;
import com.hoau.wechat.service.IDistrictService;
import com.hoau.wechat.util.JsonUtils;
import com.hoau.wechat.ws.wt.DistrictModel;
import com.opensymphony.xwork2.Action;

/**
 * @author gaojia
 *
 */
@Controller
@Scope("prototype")
public class DistrictAction implements Action{
	@Resource
	private IDistrictService districtService;
	/**
	 * 省份列表
	 */
//	private List<String> provinces;
	private List<DistrictEntity> provinces;
	private List<DistrictEntity> citys;
	private List<DistrictEntity> countys;
	public List<DistrictEntity> getCountys() {
		return countys;
	}

	public void setCountys(List<DistrictEntity> countys) {
		this.countys = countys;
	}

	public List<DistrictEntity> getProvinces() {
		return provinces;
	}

	public void setProvinces(List<DistrictEntity> provinces) {
		this.provinces = provinces;
	}
	
	public List<DistrictEntity> getCitys() {
		return citys;
	}

	public void setCitys(List<DistrictEntity> citys) {
		this.citys = citys;
	}


//	private List<String> citys;
//	
//	private List<String> countys;
	
	/**
	 * 省份参数
	 */
	private String province;
	
	/**
	 * 城市参数
	 */
	private String city;
	@Override
	public String execute() throws Exception {
		
		return SUCCESS;
	}
	
	public String queryProvince(){
//		provinces = JsonUtils.toList(districtService.queryProvince(),
//				String.class);
		provinces = districtService.queryProvince();
		return SUCCESS;
	}
	
	public String queryCity(){
//		citys = JsonUtils.toList(districtService.queryCityByProvince(province),
//				String.class);
		citys = districtService.queryCityByProvince(province);
		return SUCCESS;
	}
	
	public String queryCounty(){
//		countys = JsonUtils.toList(districtService.queryCountyByCity(province, city),
//				String.class);
		countys= districtService.queryCountyByCity(city);
		return SUCCESS;
	}
//	public List<String> getProvinces() {
//		return provinces;
//	}
//
//	public void setProvinces(List<String> provinces) {
//		this.provinces = provinces;
//	}

//	public List<String> getCitys() {
//		return citys;
//	}
//
//	public void setCitys(List<String> citys) {
//		this.citys = citys;
//	}
//
//	public List<String> getCountys() {
//		return countys;
//	}
//
//	public void setCountys(List<String> countys) {
//		this.countys = countys;
//	}

	public void setDistrictService(IDistrictService districtService) {
		this.districtService = districtService;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
	
}
