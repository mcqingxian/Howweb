package com.hoau.wechat.utils.net;

import java.util.UUID;

import com.hoau.wechat.util.JsonUtils;
import com.hoau.wechat.vo.AccessToken;
import com.hoau.wechat.vo.JSTicket;

public class TokenCache {
	//缓存Access_token
	private static AccessToken ACCESSTOKEN = null;
	//缓存JS_TICKET
	private static JSTicket JS_TICKET = null;
	
	public static String genTicket(){
		String ticket = "";
		if(JS_TICKET == null || checkJSTicketTimeOut(JS_TICKET)){
			JS_TICKET = getJSTicket();
			ticket = JS_TICKET.getTicket();
		}else{
			ticket = JS_TICKET.getTicket();
		}
		return ticket;
	}
	
	private static boolean checkJSTicketTimeOut(JSTicket ticket){
		boolean isOk = true;
		long currentTime = System.currentTimeMillis()/1000;
		long differece = currentTime - ticket.getCurrentTime();
		if(differece > ticket.getExpires_in()){
			isOk = true;
		}else{
			isOk = false;
		}
		return isOk;
	}
	
	private static JSTicket getJSTicket(){
		String GET_JS_TICKET_URL = "https://api.weixin.qq.com/cgi-bin/ticket/getticket?access_token="+genToken()+"&type=jsapi";
		String res = WeixinUtil.httpRequest(GET_JS_TICKET_URL,"GET",null);
		JSTicket ticket = JsonUtils.toObject(res, JSTicket.class);
		ticket.setCurrentTime(System.currentTimeMillis()/1000);
		return ticket;
	}
	
	public static String genToken(){
		String accessToken = "";
		if(ACCESSTOKEN == null || checkAccessTokenTimeOut(ACCESSTOKEN)){
			ACCESSTOKEN = getAccessToken();
			accessToken = ACCESSTOKEN.getAccessToken();
		}else{
			accessToken = ACCESSTOKEN.getAccessToken();
		}
		return accessToken;
	}
	
	/**
	 * @Title: checkAccessTokenTimeOut 
	 * @Description:检测AccessToken是否过期
	 * @param accessToken
	 * @return
	 */
	private static boolean checkAccessTokenTimeOut(AccessToken accessToken){
		boolean isOk = true;
		int currentTime = (int)System.currentTimeMillis()/1000;
		int differece = currentTime - accessToken.getCurrentTime();
		if(differece > accessToken.getExpiresIn()){
			isOk = true;
		}else{
			isOk = false;
		}
		return isOk;
	}

	/**
	 * @Title: getAccessToken 
	 * @Description:请求微信接口获取Access_token
	 * @param secrect
	 * @return
	 */
	private static AccessToken getAccessToken() {
		AccessToken accessToken = WeixinUtil.queryAT();
		accessToken.setCurrentTime((int)System.currentTimeMillis()/1000);
		return accessToken;
	}
	
	public static String create_nonce_str() {
		return UUID.randomUUID().toString();
	}

	public static String create_timestamp() {
		return Long.toString(System.currentTimeMillis() / 1000);
	}
}
