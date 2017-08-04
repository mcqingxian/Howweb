package com.hoau.wechat.servlet;

import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;

import com.hoau.wechat.service.IMsgManageService;
import com.hoau.wechat.service.msgHandler.MsgDispatcher;
import com.hoau.wechat.utils.MsgUtils;
import com.hoau.wechat.weixin.msg.response.ResTextMsg;


/** 
* @ClassName  :CoreService 
* @Description:核心消息处理类
* @author     :xujun cometzb@126.com	
* @date       :2014年5月9日 下午3:43:02 
*  
*/
public class CoreService {
	private static final Log LOG = LogFactory.getLog(CoreService.class);
	
	public static String processRequest(HttpServletRequest request,ApplicationContext context) {  
		String respMessage = null;  
		Map<String, String> requestMap = null;
        try {
			// xml请求解析  
			requestMap = MsgUtils.parseXml(request);  
			//保存消息记录
			saveRequestMsg(requestMap,context);
			//处理消息
			respMessage = MsgDispatcher.dispatch(requestMap,context);
		} catch (Exception e) {
			respMessage = exception(requestMap,"服务器目前无法处理您的请求！");
			LOG.error("消息处理异常");
			e.printStackTrace();
		}
        LOG.info(respMessage);
        return respMessage;
    }
	

	public static String exception(Map<String, String> requestMap,String exceptionContent) {
		ResTextMsg textMessage = new ResTextMsg();
		textMessage.setToUserName(requestMap.get("FromUserName"));  
	    textMessage.setFromUserName(requestMap.get("ToUserName"));  
	    textMessage.setCreateTime(new Date().getTime());  
	    textMessage.setMsgType(MsgUtils.RESP_MESSAGE_TYPE_TEXT);  
	    textMessage.setFuncFlag(0); 
	    textMessage.setContent(exceptionContent);
	    return MsgUtils.textMessageToXml(textMessage);
	}


	private static void saveRequestMsg(Map<String, String> requestMap,
			ApplicationContext context) {
		try {
			LOG.info("保存请求消息！");
			IMsgManageService msgManageService = (IMsgManageService)context.getBean("msgManageService");
			msgManageService.insertMsg(requestMap);
		} catch (BeansException e) {
			LOG.error("保存请求消息异常！");
			e.printStackTrace();
		}
	}

	public static String genTip() {
		String respContent;
		StringBuilder sb = new StringBuilder();
		sb.append("天地华宇小贴士/:heart:\r\n");
		sb.append("\r\n");
		sb.append("1)在对话框中输入运单号可查询运单状态/::)。\r\n");
		sb.append("2)点击屏幕右下角的㈩，发送当前位置可获取附近网点列表/::)。\r\n");
		sb.append("3)通过屏幕下方菜单，可以进行联系人管理以及订单管理/::)。\r\n");
		respContent = sb.toString();
		return respContent;
	}
}  
	
