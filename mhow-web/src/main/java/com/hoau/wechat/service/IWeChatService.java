package com.hoau.wechat.service;

/**
 * @ClassName:   IWeChatService 
 * @Description: 自定义菜单，OAuth鉴权
 * @author:      xujun cometzb@126.com
 * @date:        2014年4月3日 上午11:46:58
 */
public interface IWeChatService {
	public String customMenu(String menuJson); 
	
	public String oAuth(String url);
}