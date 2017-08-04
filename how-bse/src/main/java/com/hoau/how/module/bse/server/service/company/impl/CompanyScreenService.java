package com.hoau.how.module.bse.server.service.company.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hoau.how.module.bse.server.dao.company.CompanyMatchMapper;
import com.hoau.how.module.bse.server.dao.company.CompanyScreenMapper;
import com.hoau.how.module.bse.server.service.company.ICompanyScreenService;
import com.hoau.how.module.bse.shared.vo.DepartmentVo;
import com.hoau.how.module.bse.shared.vo.DistrictVo;

/**
 * @author：莫涛
 * @create：2015年6月25日 下午2:57:51
 * @description：
 */
@Service
public class CompanyScreenService implements ICompanyScreenService{
	@Resource
	private CompanyScreenMapper companyScreenMapper;
	@Resource
	private CompanyMatchMapper companyMatchMapper;
	
	@Override
	public List<String> queryPinYin() {
		List<String> list = companyScreenMapper.queryPinYin();
		list.add(0,"全部");
		return list;
	}

	@Override
	public Map<String,List<DistrictVo>> queryDistrict(String pinYin) {
		if(pinYin == null){
			pinYin = "";
		}
		List<DistrictVo> queryDistrictList = companyScreenMapper.queryDistrict(pinYin);
		List<DistrictVo> hotCityList = companyMatchMapper.queryHotCity();
		Map<String,String> hotCityMap = new HashMap<String,String>();
		for (int i = 0; i < hotCityList.size(); i++) {
			DistrictVo vo = hotCityList.get(i);
			hotCityMap.put(vo.getDistrictCode(), vo.getDistrictName());
		}
		LinkedHashMap<String,List<DistrictVo>> map = new LinkedHashMap<String,List<DistrictVo>>();
		List<DistrictVo> districtList = null;
		for (int i = 0; i < queryDistrictList.size(); i++) {
			DistrictVo entity = queryDistrictList.get(i);
			if(entity.getPinyin() != null && !entity.getPinyin().equals("")){
				String key = entity.getPinyin().substring(0,1);
				if(map.containsKey(key)){
					entity.setHotCity(isHotCity(hotCityMap, entity.getDistrictCode()));
					if(entity.getHotCity().equals("Y")){
						districtList.add(0,entity);
					}else{
						districtList.add(entity);
					}
				}else{
					districtList = new ArrayList<DistrictVo>();
					entity.setHotCity(isHotCity(hotCityMap, entity.getDistrictCode()));
					districtList.add(entity);
					map.put(key, districtList);
				}
			}
		}
		return map;
	}
	
	private String isHotCity(Map<String,String> map,String districtCode){
		String hotCity = "N";
		if(map.containsKey(districtCode)){
			hotCity = "Y";
		}
		return hotCity;
	}
	
	public List<DepartmentVo> queryDeptList(Map<String, String> map){
		List<DepartmentVo> vos = companyScreenMapper.queryDeptList(map);
		for (int i = 0; i < vos.size(); i++) {
			DepartmentVo vo = vos.get(i);
			vo.setServiceName(convertServiceName(vo));
		}
		return vos;
	}
	
	public DepartmentVo queryCompanyDetail(String code){
		DepartmentVo vo = companyScreenMapper.queryCompanyDetail(code);
		String serviceName = convertServiceName(vo);
		vo.setServiceName(serviceName);
		vo.setIsSpecifiedTime(vo.getIsSpecifiedTime().equals("Y") ? "是" : "否");
		return vo;
	}
	
	private String convertServiceName(DepartmentVo vo){
		StringBuffer serviceName = new StringBuffer("");
		if(vo.getIsShipment().equals("Y")){
			serviceName.append("发货").append("、");
		}
		if(vo.getIsPickUp().equals("Y")){
			serviceName.append("自提").append("、");
		}
		if(vo.getIsDelivery().equals("Y")){
			serviceName.append("送货").append("、");
		}
		if(serviceName.length() > 0){
			serviceName.delete(serviceName.length()-1, serviceName.length());
		}
		return serviceName.toString();
	}
	
	public Integer countDeptList(Map<String, String> map){
		return companyScreenMapper.countDeptList(map);
	}
}