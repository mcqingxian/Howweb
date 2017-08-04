package com.hoau.wechat.dao;

import java.util.List;

import com.hoau.wechat.vo.Contacts;

public interface IContactMangeDao {
	boolean isExist(String opendId,Contacts contacts);
	
	void addContacts(String openId,Contacts contacts);
	
	List<Contacts> query(String openId);
	
	
	Contacts queryOne(String openId,String id);
	
	public void delete(String openId, String contactsId);
	
	Contacts queryContactsByNameAndPhone(String openId,String name,String phone,int type);
	
}
