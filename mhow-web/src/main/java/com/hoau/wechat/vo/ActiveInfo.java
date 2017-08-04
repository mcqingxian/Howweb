package com.hoau.wechat.vo;

public class ActiveInfo implements Comparable<ActiveInfo>{
	private String description;
	private String pic_url;
	private String title;
	private String url;
	private String position;
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getPic_url() {
		return pic_url;
	}
	public void setPic_url(String pic_url) {
		this.pic_url = pic_url;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	
	@Override
	public int compareTo(ActiveInfo o) {
		return Integer.valueOf(this.getPosition()) - Integer.valueOf(o.getPosition());
	}

	
}
