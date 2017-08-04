package com.hoau.wechat.vo;

import org.codehaus.jackson.annotate.JsonProperty;

public class JSTicket {
	@JsonProperty(value="errcode")
	private String errcode;
	@JsonProperty(value="errmsg")
	private String errmsg;
	@JsonProperty(value="ticket")
	private String ticket;
	@JsonProperty(value="expires_in")
	private long expires_in;
	private long currentTime;
	public String getErrcode() {
		return errcode;
	}
	public void setErrcode(String errcode) {
		this.errcode = errcode;
	}
	public String getErrmsg() {
		return errmsg;
	}
	public void setErrmsg(String errmsg) {
		this.errmsg = errmsg;
	}
	public String getTicket() {
		return ticket;
	}
	public void setTicket(String ticket) {
		this.ticket = ticket;
	}
	public long getExpires_in() {
		return expires_in;
	}
	public void setExpires_in(long expires_in) {
		this.expires_in = expires_in;
	}
	public long getCurrentTime() {
		return currentTime;
	}
	public void setCurrentTime(long currentTime) {
		this.currentTime = currentTime;
	}
	
}
