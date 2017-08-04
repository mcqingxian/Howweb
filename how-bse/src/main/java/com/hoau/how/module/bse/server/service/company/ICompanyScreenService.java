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
public interface ICompanyScreenService {
	public List<String> queryPinYin();
	public Map<String,List<DistrictVo>> queryDistrict(String pinYin);
	public List<DepartmentVo> queryDeptList(Map<String, String> map);
	public Integer countDeptList(Map<String, String> map);
	public DepartmentVo queryCompanyDetail(String id);
}