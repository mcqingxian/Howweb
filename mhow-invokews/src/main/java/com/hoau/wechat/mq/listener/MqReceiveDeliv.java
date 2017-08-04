package com.hoau.wechat.mq.listener;

import javax.annotation.Resource;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.hoau.wechat.service.ITemplateService;
import com.hoau.wechat.vos.templates.msg.DelivMsg;

/**
 * 
 * @ClassName: MqReceiveDeliv 
 * @Description: TODO 提货通知
 * @author mt_king mail:hyssmt@vip.qq.com
 * @date 2014年11月17日 下午4:38:51 
 *
 */
public class MqReceiveDeliv implements MessageListener{
	/**
	 * log日志
	 */
	Log log = LogFactory.getLog(MqReceiveDeliv.class);
	@Resource
	ITemplateService templateService;
	
	public void onMessage(Message message) {
		try {
			if (message instanceof ObjectMessage) {
				ObjectMessage objectMessage = (ObjectMessage) message;
				Object obj = objectMessage.getObject();
				try{
					if(null != obj){
						//发过来的是StatusReq对象
						if(obj instanceof DelivMsg){
							DelivMsg req = (DelivMsg)obj;
							log.error("接收DC数据OpenId ："+req.getOpenId()+"，【提货通知】");
							//处理消息
							templateService.sendDelivTemplate(req);
						}else {
							log.error("接收DC对象,不是所定义的对象"+obj+"，【提货通知】");
						}
					}else{
						log.error("接收DC数据发来空对象，【提货通知】");
					}
				}catch(Exception e){
					e.printStackTrace();
					log.error("接收DC对象失败，【提货通知】");
				}
			}
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}
}
