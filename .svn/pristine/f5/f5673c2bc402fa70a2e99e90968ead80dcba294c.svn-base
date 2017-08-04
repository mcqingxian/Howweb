package com.hoau.wechat.entity;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/** 
* @ClassName: SmsItem 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author xujun jun.xu@hoau.net
* @date 2014年8月5日 下午5:38:30 
*  
*/
@XmlRootElement(name="Item")
public class SmsItem {
	private List<SmsTask> tasks;

	public List<SmsTask> getTasks() {
		return tasks;
	}

	@XmlElement(name="Task")
	public void setTasks(List<SmsTask> tasks) {
		this.tasks = tasks;
	}
	
}
