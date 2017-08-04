package com.hoau.mhow.invokews.server.ws.sms.impl;

/**
 * @author：莫涛
 * @create：2015年7月16日 上午10:19:05
 * @description：
 */
public class SMS {
	public SMS(String phone,String content){
		this.sendTotal = 0;
		this.phone = phone;
		this.content = content;
	}
	private int sendTotal;
	private String phone;
	private String content;
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getSendTotal() {
		return sendTotal;
	}
	public void setSendTotal(int sendTotal) {
		this.sendTotal = sendTotal;
	}
}
