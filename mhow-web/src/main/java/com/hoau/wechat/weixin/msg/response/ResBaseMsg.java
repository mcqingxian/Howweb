package com.hoau.wechat.weixin.msg.response;

import javax.xml.bind.annotation.XmlElement;

/**
 * @ClassName:   ResBaseMsg 
 * @Description: 响应消息基类
 * @author:      xujun cometzb@126.com
 * @date:        2014年4月2日 下午5:47:43
 */
public class ResBaseMsg {
	// 接收方帐号（收到的OpenID）  
    private String toUserName;  
    // 开发者微信号  
    private String fromUserName;  
    // 消息创建时间 （整型）  
    private long createTime;  
    // 消息类型（text/music/news）  
    private String msgType;
    
	@XmlElement(name="ToUserName")
	public String getToUserName() {
		return toUserName;
	}
	public void setToUserName(String toUserName) {
		this.toUserName = toUserName;
	}
	@XmlElement(name="FromUserName")
	public String getFromUserName() {
		return fromUserName;
	}
	public void setFromUserName(String fromUserName) {
		this.fromUserName = fromUserName;
	}
	@XmlElement(name="CreateTime")
	public long getCreateTime() {
		return createTime;
	}
	public void setCreateTime(long createTime) {
		this.createTime = createTime;
	}
	@XmlElement(name="MsgType")
	public String getMsgType() {
		return msgType;
	}
	public void setMsgType(String msgType) {
		this.msgType = msgType;
	}  
}
