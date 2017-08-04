package com.hoau.wechat.weixin.msg.response;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @ClassName:   TextMsg 
 * @Description: 文本响应消息
 * @author:      xujun cometzb@126.com
 * @date:        2014年4月2日 下午5:49:19
 */
@XmlRootElement(name="xml")
public class ResTextMsg extends ResBaseMsg {
	// 回复的消息内容  
    private String content;

    // 位0x0001被标志时，星标刚收到的消息  
    private int funcFlag;

    @XmlElement(name="Content")
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@XmlElement(name="FuncFlag")
	public int getFuncFlag() {
		return funcFlag;
	}

	public void setFuncFlag(int funcFlag) {
		this.funcFlag = funcFlag;
	}
   
}
