package com.hoau.wechat.service.msgHandler;

import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import com.hoau.wechat.servlet.CoreService;

/** 
* @ClassName  :LinkMsgHandler 
* @Description:链接消息处理
* @author     :xujun cometzb@126.com	
* @date       :2014年5月9日 下午2:52:17 
*  
*/
@Service
public class LinkMsgHandler extends AbstractResponseText {

	@Override
	protected String genContent(Map<String, String> inputParams, ApplicationContext context) {
		return "您好，目前还不能处理链接消息。\r\n"+CoreService.genTip();
	}

}
