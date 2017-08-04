package com.hoau.mhow.module.bse.api.shared.vo;

import com.hoau.mhow.module.bse.api.shared.domain.DepartmentEntity;

/**
 * @author：高佳
 * @create：2015年5月27日 上午8:37:05
 * @description：部门实体
 */
public class DepartmentVo extends DepartmentEntity{
	private static final long serialVersionUID = -2961740853842591194L;
	private String rownumber;
	private String serviceName;
	public String getServiceName() {
		return serviceName;
	}
	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}
	public String getRownumber() {
		return rownumber;
	}
	public void setRownumber(String rownumber) {
		this.rownumber = rownumber;
	}
}
