package com.hoau.how.module.bse.server.service.pricetime.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Resource;

import org.codehaus.jackson.JsonNode;
import org.springframework.stereotype.Service;

import com.hoau.how.module.bse.server.dao.DistrictMapper;
import com.hoau.how.module.bse.server.service.pricetime.IDistrictService;
import com.hoau.how.module.bse.shared.vo.District;
import com.hoau.how.module.common.constants.SysConfigConstants;
import com.hoau.how.module.util.JsonHelper;
import com.hoau.how.module.util.http.HttpUtil;

@Service
public class DistrictService implements IDistrictService{
	
	@Resource
	private DistrictMapper districtMapper;
	
	private List<District> provinces = null;
	private List<District> cities = null;
	private List<District> areas = null;
	
	private static String[] hotCity = {"上海市","深圳市","北京市","广州市","苏州市","成都市","东莞市","宁波市","天津市","佛山市","青岛市","重庆市","武汉市","杭州市","沈阳市","南昌市"};
	
	public void loadDistrict() throws IOException{
		provinces = queryProvincesFromMDM();
		cities = queryCitysFromMDM();
		areas = queryCountyFromMDM();
	}

	/**
	 * MDM接口获得省的数据
	 */
	public List<District> queryProvincesFromMDM() throws IOException {
		if(provinces == null){
			String returnedJson = HttpUtil.httpGet(SysConfigConstants.MDM_PROVINCE);
			JsonNode jsonNode = JsonHelper.toJsonNode(returnedJson);
			provinces =changDistrictForMDM(JsonHelper.toList(jsonNode.get("districts"), District.class));
			//areas = changDistrict(districtMapper.queryAreas("AREA"));
		}
		return provinces;
	}
	
	/**
	 * MDM接口获得市的数据
	 */
	public List<District> queryCitysFromMDM() throws IOException {
		if(cities == null){
			String returnedJson = HttpUtil.httpGet(SysConfigConstants.MDM_CITY);
			JsonNode jsonNode = JsonHelper.toJsonNode(returnedJson);
			cities =changDistrictForMDM(JsonHelper.toList(jsonNode.get("districts"), District.class));
			//areas = changDistrict(districtMapper.queryAreas("AREA"));
		}
		return cities;
	}
	
	/**
	 * MDM接口获得区县的数据
	 */
	public List<District> queryCountyFromMDM() throws IOException {
		if(areas == null){
			String returnedJson = HttpUtil.httpGet(SysConfigConstants.MDM_AREA);
			JsonNode jsonNode = JsonHelper.toJsonNode(returnedJson);
			areas =changDistrictForMDM(JsonHelper.toList(jsonNode.get("districts"), District.class));
			//areas = changDistrict(districtMapper.queryAreas("AREA"));
		}
		return areas;
	}
	
	
	/**
	 * 添加热门城市到domain中
	 * @param entitys
	 * @return
	 */
	private List<District> changDistrictForMDM(List<District> entitys){
		List<District> diss = new ArrayList<District>();
		for(District entity : entitys){
			District dis = new District();
			dis.setDistrictCode(entity.getDistrictCode());
			dis.setDistrictName(entity.getDistrictName());
			dis.setDistrictType(entity.getDistrictType());
			dis.setId(entity.getId());
			dis.setParentDistrictCode(entity.getParentDistrictCode());
			dis.setPinyin(entity.getPinyin());
			if("CITY".equals(entity.getDistrictType()) && Arrays.asList(hotCity).contains(entity.getDistrictName())){
				dis.setHotCity(true);
			}
			diss.add(dis);
		}
		return diss;
	}
	
	
	
}
