package com.hoau.wechat.service.msgHandler;

import java.util.Map;

import org.springframework.context.ApplicationContext;

import com.hoau.wechat.exception.BusinessException;
/** 
* @ClassName  :IMsgHandler 
* @Description:TODO 
* @author     :xujun cometzb@126.com	
* @date       :2014年5月9日 下午1:47:30 
* 
* @param <O> 
*/
public interface IMsgHandler {
	
	public String handleMsg(Map<String, String> inputParams, ApplicationContext context) throws BusinessException;
	
}