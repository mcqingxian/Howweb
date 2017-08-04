package com.hoau.mhow.module.bse.server.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.hoau.mhow.module.bse.api.shared.vo.DepartmentVo;
import com.hoau.mhow.module.bse.api.shared.vo.DistrictVo;

/**
 * 
 *
 * @author 莫涛
 * @date 2015年6月25日
 */
@Repository
public interface CompanyMatchMapper {
	public List<DistrictVo> queryProvinceCount();
	public List<DistrictVo> queryCityCount(Map<String,String> map);
	public List<DistrictVo> queryCountyCount(String districtCode);
	public List<DepartmentVo> queryCounty(Map<String,String> map);
	public List<DepartmentVo> queryDeptByDistrictName(Map<String, String> map);
	public List<DistrictVo> queryHotCity();
}
