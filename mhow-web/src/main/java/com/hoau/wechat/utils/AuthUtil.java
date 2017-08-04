package com.hoau.wechat.utils;

/** 
* @ClassName  :AuthUtil 
* @Description:从微信的view 类型的菜单跳转到自己的应用一些授权操作
* @author     :xujun cometzb@126.com	
* @date       :2014年4月25日 上午9:39:26 
*  
*/
public class AuthUtil {
	
	public static String genAuthUrl(String appid,String redirectUrl){
		StringBuilder sb = new StringBuilder();
		sb.append("https://open.weixin.qq.com/connect/oauth2/authorize?appid=");
		sb.append(appid);
		sb.append("&redirect_uri=");
		sb.append(redirectUrl);
		sb.append("?").append("response_type=code&scope=snsapi_base");
		sb.append("&state=1#wechat_redirect");
		return sb.toString();
	}
	
	public static void main(String[] args) {
		String s = genAuthUrl("wxc6ab6f92d2623669","http://wechat.hoau.net/wechat/queryOrder.action");
		System.out.println(s);
	}
	
}
