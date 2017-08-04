package com.hoau.wechat.vo;

import org.codehaus.jackson.annotate.JsonProperty;

public class AccessToken {
	/** 
	* @Fields accessToke : token
	*/
	@JsonProperty(value="access_token")
	private String accessToken;
	
	/** 
	* @Fields expiresIn : 过期时间
	*/
	@JsonProperty(value="expires_in")
	private int expiresIn;
	
	private int currentTime;


	public int getCurrentTime() {
		return currentTime;
	}

	public void setCurrentTime(int currentTime) {
		this.currentTime = currentTime;
	}

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	public int getExpiresIn() {
		return expiresIn;
	}

	public void setExpiresIn(int expiresIn) {
		this.expiresIn = expiresIn;
	}
	
	
}
