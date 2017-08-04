package com.hoau.wechat.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName:   ServiceMapping 
 * @Description: 消息类型与服务的映射
 * @author:      xujun cometzb@126.com
 * @date:        2014年4月3日 下午1:21:25
 */
public class ServiceMapping {
	private static final Map<String, String> map =new HashMap<String, String>();
	
	static{
		map.put(MsgUtils.REQ_MESSAGE_TYPE_TEXT, "textService");
	}
	
	public static String getServiceName(String type){
		return map.get(type);
	}
	
}
