package com.hoau.wechat.vo;

/** 
* @ClassName  :OpenIdReturn 
* @Description:在获取openid时，微信返回值实体 
* @author     :xujun cometzb@126.com	
* @date       :2014年4月25日 上午11:20:15 
*  
*/
public class OpenIdReturn {
	private String access_token;
	private int expires_in;
	private String refresh_token;
	private String openid;
	private String scope;
	public String getAccess_token() {
		return access_token;
	}
	public void setAccess_token(String access_token) {
		this.access_token = access_token;
	}
	public int getExpires_in() {
		return expires_in;
	}
	public void setExpires_in(int expires_in) {
		this.expires_in = expires_in;
	}
	public String getRefresh_token() {
		return refresh_token;
	}
	public void setRefresh_token(String refresh_token) {
		this.refresh_token = refresh_token;
	}
	public String getOpenid() {
		return openid;
	}
	public void setOpenid(String openid) {
		this.openid = openid;
	}
	public String getScope() {
		return scope;
	}
	public void setScope(String scope) {
		this.scope = scope;
	}
}
