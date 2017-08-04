package com.hoau.how.module.bse.shared.vo;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

/**
 * 
* <p>Title: Route</p>
* <p>Description: </p>
* <p>Company: HOAU</p> 
* @author lanhong zhang
* @date 2015年12月20日
 */
@XmlType
public class Route {
	/**
	 * 路由节点发生的时间，格式：YYYY-MM-DD HH24:MM:SS，
	 * 示例：2012-7-30 09:30:00。
	 */
	private String acceptTime;
	/**
	 * 路由节点发生的地点
	 */
	private String acceptAddress;
	/**
	 * 路由节点具体描述
	 */
	private String remark; 
	/**
	 * 路由节点操作码
	 */
	private String opcode;
	
	@XmlAttribute(name="accept_time")
	public String getAcceptTime() {
		return acceptTime;
	}
	public void setAcceptTime(String acceptTime) {
		this.acceptTime = acceptTime;
	}
	@XmlAttribute(name="accept_address")
	public String getAcceptAddress() {
		return acceptAddress;
	}
	public void setAcceptAddress(String acceptAddress) {
		this.acceptAddress = acceptAddress;
	}
	@XmlAttribute(name="remark")
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	@XmlAttribute(name="opcode")
	public String getOpcode() {
		return opcode;
	}
	public void setOpcode(String opcode) {
		this.opcode = opcode;
	}
	
}
