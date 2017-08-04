package com.hoau.how.module.bse.api.shared.domain;

import java.util.Date;

import com.hoau.hbdp.framework.entity.BaseEntity;

/**
 * 客户留言实体
 * @author：张爱萍
 * @create：2015年5月30日 下午4:08:38
 * @description：
 */
public class CommentEntity extends BaseEntity{
	/**
	 * 主键
	 */
	private String id;
	/**
	 * 主题
	 */
	private String topic;
	/**
	 * 运单号
	 */
	private String wbnum;
	private String name;   
	private String tel;
	private String message;
	private String reply;
	private String userId;
	/**
	 * 状态 1.0未处理  2.0已处理  3.0处理中
	 */
	private double status;
	private Date time;
	/**
	 * 类型 1.0咨询  2.0建议  3.0投诉
	 */
	private double type;
	private Date replytime;
	private String email;
	/**
	 * 是否有效
	 */
	private int is_adopt;
	private String ip;
	private double businesstype;
	private String company;
	private String subcompany;
	private String did;
	private String sid;
	private String feedback;
	private String note;
	
	/**
	 * 投诉人类型
	 * 1:发货人  2：收货人 3：第三方
	 */
	private int customerType;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTopic() {
		return topic;
	}
	public void setTopic(String topic) {
		this.topic = topic;
	}
	public String getWbnum() {
		return wbnum;
	}
	public void setWbnum(String wbnum) {
		this.wbnum = wbnum;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getReply() {
		return reply;
	}
	public void setReply(String reply) {
		this.reply = reply;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public Double getStatus() {
		return status;
	}
	public void setStatus(Double status) {
		this.status = status;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public double getType() {
		return type;
	}
	public void setType(double type) {
		this.type = type;
	}
	public Date getReplytime() {
		return replytime;
	}
	public void setReplytime(Date replytime) {
		this.replytime = replytime;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getIs_adopt() {
		return is_adopt;
	}
	public void setIs_adopt(int is_adopt) {
		this.is_adopt = is_adopt;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public double getBusinesstype() {
		return businesstype;
	}
	public void setBusinesstype(double businesstype) {
		this.businesstype = businesstype;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getSubcompany() {
		return subcompany;
	}
	public void setSubcompany(String subcompany) {
		this.subcompany = subcompany;
	}
	public String getDid() {
		return did;
	}
	public void setDid(String did) {
		this.did = did;
	}
	public String getSid() {
		return sid;
	}
	public void setSid(String sid) {
		this.sid = sid;
	}
	public String getFeedback() {
		return feedback;
	}
	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public void setStatus(double status) {
		this.status = status;
	}
	public int getCustomerType() {
		return customerType;
	}
	public void setCustomerType(int customerType) {
		this.customerType = customerType;
	}
	
	
}
