package com.hoau.wechat.service.msgHandler;

import java.util.Date;
import java.util.Map;

import javax.xml.bind.JAXBException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationContext;

import com.hoau.wechat.exception.XmlTranslateException;
import com.hoau.wechat.util.JaxbUtil;
import com.hoau.wechat.utils.MsgUtils;
import com.hoau.wechat.weixin.msg.response.ResTextMsg;

/** 
* @ClassName  :AbstractResponseText 
* @Description:大部分响应都是文本，该类对响应的消息做了部分处理 
* @author     :xujun cometzb@126.com	
* @date       :2014年5月9日 下午1:58:33 
* 修改： 添加对易到家响应单图文消息的处理    autor 275704
*/
public abstract class AbstractResponseText implements IMsgHandler {
	protected Log LOG = LogFactory.getLog(getClass());
	
	@Override
	public String handleMsg(Map<String, String> inputParams, ApplicationContext context) {
		String rtn = "";
		ResTextMsg textMessage = new ResTextMsg();
		textMessage.setToUserName(inputParams.get("FromUserName"));  
	    textMessage.setFromUserName(inputParams.get("ToUserName"));  
	    textMessage.setCreateTime(new Date().getTime());  
	    textMessage.setMsgType(MsgUtils.RESP_MESSAGE_TYPE_TEXT);  
	    textMessage.setFuncFlag(0); 
	    textMessage.setContent(genContent(inputParams, context));
	    try {
			rtn = JaxbUtil.marshToXmlBinding(ResTextMsg.class, textMessage);
		} catch (JAXBException e) {
			throw new XmlTranslateException("XML转换异常", e);
		}
		return rtn;
	}  
	
	/** 
	* @Title      :genContent 
	* @Description:生成文本响应的内容
	* @param      :@param inputParas
	* @param      :@return   
	* @return     :String 
	* @date       :2014年5月9日 下午2:07:25   
	* @throws 
	*/
	protected abstract String genContent(Map<String, String> inputParams, ApplicationContext context);
}
