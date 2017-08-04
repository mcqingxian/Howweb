package com.hoau.wechat.mq.service.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.jms.JmsException;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import com.hoau.wechat.mq.service.UserInfoMqService;
import com.hoau.wechat.vos.templates.msg.UserInfoMsg;

/**
 * 
 * @ClassName: UserInfoMqServiceImpl 
 * @Description: TODO 
 * @author mt_king mail:hyssmt@vip.qq.com
 * @date 2014年11月17日 下午3:58:41 
 *
 */
@Service
public class UserInfoMqServiceImpl implements UserInfoMqService {
	JmsTemplate jmsTemplate;
	//Log日志
	private static final Log log = LogFactory
	          .getLog(UserInfoMqServiceImpl.class);
	/**
	 * 发送消息
	 */
	public void send(Object object) {
		String openId = "";
		try {
			if(null != object ){
				if(object instanceof UserInfoMsg){
					UserInfoMsg userInfo = (UserInfoMsg)object;
					openId = userInfo.getOpenId();
					jmsTemplate.convertAndSend(object);
					log.info("发送绑定信息为：openId = "+userInfo.getOpenId() + "; phone = "+userInfo.getPhone());
				}else{
					jmsTemplate.convertAndSend(object);
				}
			}
		} catch (JmsException e) {
			log.error("发送绑定信息："+openId+"失败");
			e.printStackTrace();
		} catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	public void setJmsTemplate(JmsTemplate jmsTemplate) {
		this.jmsTemplate = jmsTemplate;
	}
}