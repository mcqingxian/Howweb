package com.hoau.how.module.obh.shared.domain;

import java.util.List;

//传给Dc的数据类
public class ContactsDcEntity {

	//发货人手机号
	private String ebsaMobile;
	
	//待收货款信息
	private List<UnpayMentEntity> unpayMentList;

	public String getEbsaMobile() {
		return ebsaMobile;
	}

	public void setEbsaMobile(String ebsaMobile) {
		this.ebsaMobile = ebsaMobile;
	}

	public List<UnpayMentEntity> getUnpayMentList() {
		return unpayMentList;
	}

	public void setUnpayMentList(List<UnpayMentEntity> unpayMentList) {
		this.unpayMentList = unpayMentList;
	}
	
}
