package com.hoau.wechat.util.net;

import org.codehaus.jackson.annotate.JsonProperty;
/**
 * 
 * @ClassName: AccessToken 
 * @Description: TODO 
 * @author mt_king mail:hyssmt@vip.qq.com
 * @date 2014年11月17日 下午4:55:25 
 *
 */
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
