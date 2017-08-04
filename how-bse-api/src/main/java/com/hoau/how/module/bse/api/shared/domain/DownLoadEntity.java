package com.hoau.how.module.bse.api.shared.domain;

import java.util.Date;

import com.hoau.hbdp.framework.entity.BaseEntity;

/**
 * @author：张爱萍
 * @create：2015年6月18日 上午10:24:44
 * @description：
 */
public class DownLoadEntity extends BaseEntity{
	private int infoId;
	private String name;
	private String url;
	private Date createdAt;
	private int click_count;
	public int getInfoId() {
		return infoId;
	}
	public void setInfoId(int infoId) {
		this.infoId = infoId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public int getClick_count() {
		return click_count;
	}
	public void setClick_count(int click_count) {
		this.click_count = click_count;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	
	
}
