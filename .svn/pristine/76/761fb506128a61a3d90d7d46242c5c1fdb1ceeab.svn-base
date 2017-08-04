package com.hoau.how.module.bse.server.service.company;

import java.util.List;
import java.util.Map;

import com.hoau.how.module.bse.shared.vo.DepartmentVo;
import com.hoau.how.module.bse.shared.vo.DistrictVo;

/**
 * @author：莫涛
 * @create：2015年6月25日 下午2:56:04
 * @description：
 */
public interface ICompanyMatchService {
	public List<DistrictVo> queryProvinceCount();
	public List<DistrictVo> queryCityCount(Map<String,String> map);
	public List<DistrictVo> queryCountyCount(String districtCode);
	public List<DepartmentVo> queryCounty(Map<String,String> map);
	public List<DepartmentVo> queryDeptByDistrictName(Map<String, String> map);
	public List<DistrictVo> queryHotCity();
}
