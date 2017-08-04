package com.hoau.wechat.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import com.hoau.wechat.service.IDepartmentService;
import com.hoau.wechat.service.IDeptService;
import com.hoau.wechat.service.IDistrictService;
import com.hoau.wechat.util.JsonUtils;
import com.hoau.wechat.vo.AddressInfo;
import com.hoau.wechat.vo.DepartmentListVO;

@Service
public class DeptService implements IDeptService {
	private static final Log LOG = LogFactory.getLog(DeptService.class);
	@Resource
	private IDistrictService districtService;

	@Resource
	private IDepartmentService departmentService;
	
	@Override
	public List<DepartmentListVO> getDeptsByAddressInfo(AddressInfo addressInfo) {
		String jsonStr = districtService.queryStation(addressInfo.getProvince(), addressInfo.getCity(), addressInfo.getDistrict());
		return JsonUtils.toList(jsonStr, DepartmentListVO.class);
	}

	@Override
	public String getPhoneByCompanyCode(String companyCode) {
		String tel = "";
		try {
			String jsonStr = departmentService.queryDepartmentPhone(companyCode);
			DepartmentListVO vo = JsonUtils.toObject(jsonStr, DepartmentListVO.class);
			tel = vo.getTelephone();
		} catch (Exception e) {
			LOG.error("获取部门编码异常");
			e.printStackTrace();
		}
		return tel;
	}
	
}
