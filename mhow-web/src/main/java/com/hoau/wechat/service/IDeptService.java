package com.hoau.wechat.service;

import java.util.List;

import com.hoau.wechat.vo.AddressInfo;
import com.hoau.wechat.vo.DepartmentListVO;

public interface IDeptService {
	
	public List<DepartmentListVO> getDeptsByAddressInfo(AddressInfo addressInfo);
	
	
	public String getPhoneByCompanyCode(String companyCode);
}
