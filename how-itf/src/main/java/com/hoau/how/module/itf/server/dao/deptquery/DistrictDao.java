package com.hoau.how.module.itf.server.dao.deptquery;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.hoau.how.module.itf.shared.domain.DistrictEntity;


/**
 *
 * @author 徐俊
 * @date 2015年6月24日
 */
@Repository
public interface DistrictDao{

	List<DistrictEntity> queryAllDistricts();

	public void addDistricts(DistrictEntity districtEntity);
	
	
	public void deleteAllDistrict();
	
	public long getLastVersionNo();
	
	public void updateDistrict(DistrictEntity districtEntity);
	
	public DistrictEntity queryDistrictByCode(String districtCode);
	
	public void updateHotCityNum(Map<String,Object> map);
	
}

