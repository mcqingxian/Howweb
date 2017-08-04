package com.hoau.wechat.vo;

import java.util.Date;
import java.util.List;

import com.hoau.wechat.entity.OrderEntity;

public class UserInfo {

	private String _id;
	private String openid;
	private String phone;
	private List<Contacts> contacts_list;
	private List<OrderEntity> orders;
	private List<String> frequently_waybills;
	private Date create_time;
	private Date update_time;
	
	public String getOpenid() {
		return openid;
	}
	public void setOpenid(String openid) {
		this.openid = openid;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public List<Contacts> getContacts_list() {
		return contacts_list;
	}
	public void setContacts_list(List<Contacts> contacts_list) {
		this.contacts_list = contacts_list;
	}
	public List<OrderEntity> getOrders() {
		return orders;
	}
	public void setOrders(List<OrderEntity> orders) {
		this.orders = orders;
	}
	public List<String> getFrequently_waybills() {
		return frequently_waybills;
	}
	public void setFrequently_waybills(List<String> frequently_waybills) {
		this.frequently_waybills = frequently_waybills;
	}
	public Date getCreate_time() {
		return create_time;
	}
	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}
	public Date getUpdate_time() {
		return update_time;
	}
	public void setUpdate_time(Date update_time) {
		this.update_time = update_time;
	}
	public String get_id() {
		return _id;
	}
	public void set_id(String _id) {
		this._id = _id;
	}
	
	
}
