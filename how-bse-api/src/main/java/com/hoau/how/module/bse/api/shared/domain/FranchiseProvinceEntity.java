package com.hoau.how.module.bse.api.shared.domain;

import com.hoau.hbdp.framework.entity.BaseEntity;

/**
 * 特许经营省份表
 * @author：张爱萍
 * @create：2015年6月23日 下午2:11:59
 * @description：
 */
public class FranchiseProvinceEntity extends BaseEntity{
	private int pid;
	private String pname;
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	
}
