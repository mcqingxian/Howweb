package com.hoau.how.module.bse.server.dao.company;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.hoau.how.module.bse.shared.vo.DepartmentVo;
import com.hoau.how.module.bse.shared.vo.DistrictVo;


/**
 *
 * @author 莫涛
 * @date 2015年6月25日
 */
@Repository
public interface CompanyScreenMapper{
	public List<String> queryPinYin();
	public List<DistrictVo> queryDistrict(String pinYin);
	public List<DepartmentVo> queryDeptList(Map<String, String> map);
	public Integer countDeptList(Map<String, String> map);
	public DepartmentVo queryCompanyDetail(String id);
}