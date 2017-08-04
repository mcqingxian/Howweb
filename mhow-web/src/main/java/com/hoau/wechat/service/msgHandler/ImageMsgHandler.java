package com.hoau.wechat.service.msgHandler;

import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import com.hoau.wechat.servlet.CoreService;

/** 
* @ClassName  :ImageMsgHandler 
* @Description:图片信息处理 
* @author     :xujun cometzb@126.com	
* @date       :2014年5月9日 下午2:53:00 
*  
*/
@Service
public class ImageMsgHandler extends AbstractResponseText {

	@Override
	protected String genContent(Map<String, String> inputParams, ApplicationContext context) {
		return "您好！您的图片已收到,我们会快马加鞭回复您的！/::)"; 
	}

}
