package com.hoau.wechat.mq.converter;

import java.io.Serializable;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.ObjectMessage;
import javax.jms.Session;

import net.sf.json.JSONObject;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.jms.support.converter.MessageConversionException;
import org.springframework.jms.support.converter.MessageConverter;

/**
 * 
 * @ClassName: MessageConvertForSys 
 * @Description: TODO 
 * @author mt_king mail:hyssmt@vip.qq.com
 * @date 2014年11月17日 下午3:17:15 
 *
 */
public class MessageConvertForSys implements MessageConverter {
	private static final Log log = LogFactory.getLog(MessageConvertForSys.class);
	
	public Message toMessage(Object object, Session session)
			throws JMSException, MessageConversionException {
		ObjectMessage objectMessage = session.createObjectMessage();
		objectMessage.setJMSExpiration(1000);
		System.out.println("[ObjectMessage]:"+ object.getClass().getName());
		objectMessage.setObject((Serializable) object);
		JSONObject jsonObject = null;
		jsonObject = JSONObject.fromObject(object);
		log.error("MQ发送的OBJECT信息："+jsonObject.toString());
		return objectMessage;
	}
	
	public Object fromMessage(Message message) throws JMSException,
			MessageConversionException {
		ObjectMessage objectMessage = (ObjectMessage) message;
		return objectMessage.getObject();
	}
}