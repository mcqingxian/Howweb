package com.hoau.wechat.vo;

public class CompusActivityCode {
	private String id;
	private String code;
	private int status;//是否用过0：未用  1：已用
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
}
