package com.hoau.mhow.module.bse.api.server.service;

import java.util.List;

import com.hoau.wechat.entity.DistrictEntity;

public interface IDistrictInfoService {
	
	public void loadDistrict();
	
	public List<DistrictEntity> queryProvinces();
	
	public List<DistrictEntity> queryCitys(String province);
	
	public List<DistrictEntity> queryCounty(String city);

	public List<DistrictEntity> queryCountyInfoByProvinceCity(String province, String city);
	
	public List<String> queryProvincesNameList();

	public List<String> queryCitysNameList(String province);

	public List<String> queryCountyNameList(String city);
	
	public List<String> queryCountyNameListByProvinceCity(String province, String city);
	
	public void DistrictInfoInit();
}
