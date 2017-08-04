package com.hoau.how.module.bse.api.shared.domain;

import com.hoau.hbdp.framework.entity.BaseEntity;

/**
 * 特许经营城市表
 * @author：张爱萍
 * @create：2015年6月23日 下午2:13:53
 * @description：
 */
public class FranchiseCityEntity extends BaseEntity{
	private int cid;
	private String cname;
	private int pid;
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	
}
