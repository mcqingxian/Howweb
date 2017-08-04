package com.hoau.mhow.module.bse.server.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hoau.mhow.module.bse.api.server.service.IDistrictInfoService;
import com.hoau.mhow.module.bse.api.shared.domain.DistrictEntity;
import com.hoau.mhow.module.bse.server.dao.DistrictMapper;

@Service
public class DistrictInfoService implements IDistrictInfoService{
	
	@Resource
	private DistrictMapper districtMapper;
	
	/**
	 * 省市区数据版本号
	 */
	long verson;
	
	private List<com.hoau.wechat.entity.DistrictEntity> provincesList = null;
	private Map<String, List<com.hoau.wechat.entity.DistrictEntity>> citiesMap = null;
	private Map<String, List<com.hoau.wechat.entity.DistrictEntity>> areasMap = null;
	private Map<String, Map<String, List<com.hoau.wechat.entity.DistrictEntity>>> areasMapByProvince = null;
	private List<String> provincesListString = null;
	private Map<String, List<String>> citiesListString = null;
	private Map<String, List<String>> areasListString = null;
	private Map<String, Map<String, List<String>>> areasMapByProvinceListString = null;
	
	//private static String[] hotCity = {"上海市","深圳市","北京市","广州市","苏州市","成都市","东莞市","宁波市","天津市","佛山市","青岛市","重庆市","武汉市","杭州市","沈阳市","南昌市"};
	
	public void loadDistrict(){
		List<DistrictEntity> provinces = districtMapper.queryAllAreas("PROVINCE");
		// 市
		citiesMap = new HashMap<String, List<com.hoau.wechat.entity.DistrictEntity>>();
		citiesListString = new HashMap<String, List<String>>();
		// 区县
		areasMap = new HashMap<String, List<com.hoau.wechat.entity.DistrictEntity>>();
		areasListString = new HashMap<String, List<String>>();
		areasMapByProvince = new HashMap<String, Map<String,List<com.hoau.wechat.entity.DistrictEntity>>>();
		areasMapByProvinceListString = new HashMap<String, Map<String,List<String>>>();
		for (DistrictEntity e : provinces){
			citiesMap.put(e.getDistrictName(), changDistrict(e.getChildAreaList()));
			citiesListString.put(e.getDistrictName(), changDistrictToJsonString(e.getChildAreaList()));
			Map<String,List<com.hoau.wechat.entity.DistrictEntity>> map = new HashMap<String,List<com.hoau.wechat.entity.DistrictEntity>>();
			Map<String,List<String>> map1 = new HashMap<String,List<String>>();
			for(DistrictEntity e1 : e.getChildAreaList()){
				areasMap.put(e1.getDistrictName(), changDistrict(e1.getChildAreaList()));
				areasListString.put(e1.getDistrictName(), changDistrictToJsonString(e1.getChildAreaList()));
				map.put(e1.getDistrictName(), changDistrict(e1.getChildAreaList()));
				map1.put(e1.getDistrictName(), changDistrictToJsonString(e1.getChildAreaList()));
			}
			areasMapByProvince.put(e.getDistrictName(), map);
			areasMapByProvinceListString.put(e.getDistrictName(), map1);
		}
		// 省
		provincesList = changDistrict(provinces);
		provincesListString = changDistrictToJsonString(provinces);
		// 版本号
		verson = Long.valueOf(districtMapper.maxVersionNo());
		/*// 区
		areasMap = new HashMap<String, List<com.hoau.wechat.entity.DistrictEntity>>();
		for (DistrictEntity e : citys){
			areasMap.put(e.getDistrictName(), changDistrict(e.getChildAreaList()));
		}*/
	}
	
	/**
	 * 查询省信息
	 */
	public List<com.hoau.wechat.entity.DistrictEntity> queryProvinces() {
		if(provincesList == null){
			loadDistrict();
		}
		return provincesList;
	}

	/**
	 * 根据省名称查询市信息
	 */
	public List<com.hoau.wechat.entity.DistrictEntity> queryCitys(String province) {
		if(citiesMap == null){
			loadDistrict();
		}
		return citiesMap.get(province);
	}

	/**
	 * 根据市名称查询区域信息
	 */
	public List<com.hoau.wechat.entity.DistrictEntity> queryCounty(String city) {
		if(areasMap == null){
			loadDistrict();
		}
		return areasMap.get(city);
	}
	
	/**
	 * 根据省市名称查询区域信息
	 */
	public List<com.hoau.wechat.entity.DistrictEntity> queryCountyInfoByProvinceCity(String province, String city) {
		if(areasMapByProvince == null){
			loadDistrict();
		}
		if(areasMapByProvince.get(province) != null){
			return areasMapByProvince.get(province).get(city);
		} else {
			return new ArrayList<com.hoau.wechat.entity.DistrictEntity>();
		}
	}
	
	/**
	 * 查询省信息的名称
	 */
	public List<String> queryProvincesNameList() {
		if(provincesListString == null){
			loadDistrict();
		}
		return provincesListString;
	}

	/**
	 * 根据省名称查询市信息的名称
	 */
	public List<String> queryCitysNameList(String province) {
		if(citiesListString == null){
			loadDistrict();
		}
		return citiesListString.get(province);
	}

	/**
	 * 根据市名称查询区域信息的名称
	 */
	public List<String> queryCountyNameList(String city) {
		if(areasListString == null){
			loadDistrict();
		}
		return areasListString.get(city);
	}
	
	/**
	 * 根据省市名称查询区域信息的名称
	 */
	public List<String> queryCountyNameListByProvinceCity(String province, String city) {
		if(areasMapByProvinceListString == null){
			loadDistrict();
		}
		if(areasMapByProvinceListString.get(province) != null){
			return areasMapByProvinceListString.get(province).get(city);
		} else {
			return new ArrayList<String>();
		}
	}
	
	/**
	 * 省市区信息是否需要初始化
	 * 
	 * @author 蒋落琛
	 * @date 2015-12-16
	 * @update
	 */
	public void DistrictInfoInit(){
		if(provincesList != null){
			if(Long.valueOf(districtMapper.maxVersionNo()) > this.verson){
				loadDistrict();
			}
		} else {
			loadDistrict();
		}
	}
	
	/**
	 * 省市区信息转换
	 * 
	 * @param entitys
	 * @return
	 * @author 蒋落琛
	 * @date 2015-12-16
	 * @update
	 */
	private List<com.hoau.wechat.entity.DistrictEntity> changDistrict(List<DistrictEntity> entitys){
		List<com.hoau.wechat.entity.DistrictEntity> diss = new ArrayList<com.hoau.wechat.entity.DistrictEntity>();
		for(DistrictEntity entity : entitys){
			com.hoau.wechat.entity.DistrictEntity dis = new com.hoau.wechat.entity.DistrictEntity();
			dis.setDistrictCode(entity.getDistrictCode());
			dis.setDistrictName(entity.getDistrictName());
			dis.setDistrictType(entity.getDistrictType());
			//dis.setId(entity.getId());
			//dis.setParentDistrictCode(entity.getParentDistrictCode());
			dis.setPinyin(entity.getPinyin());
			/*if("CITY".equals(entity.getDistrictType()) && Arrays.asList(hotCity).contains(entity.getDistrictName())){
				dis.setHotCity(true);
			}*/
			diss.add(dis);
		}
		return diss;
	}
	
	/**
	 * 省市区信息转换
	 * 
	 * @param entitys
	 * @return
	 * @author 蒋落琛
	 * @date 2015-12-16
	 * @update
	 */
	private List<String> changDistrictToJsonString(List<DistrictEntity> entitys){
		List<String> list = new ArrayList<String>();
		for(DistrictEntity entity : entitys){
			list.add(entity.getDistrictName());
		}
		return list;
	}
	
}
