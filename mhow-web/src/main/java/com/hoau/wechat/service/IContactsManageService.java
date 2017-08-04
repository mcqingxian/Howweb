package com.hoau.wechat.service;

import java.util.List;

import com.hoau.wechat.vo.Contacts;
/**
 * 
* @ClassName  :IContactsService 
* @Description:联系人管理
* @author     :xujun cometzb@126.com	
* @date       :2014年4月24日 上午9:53:55 
*
 */
public interface IContactsManageService {
	void add(String openId,Contacts contacts);
	void update(String openId,Contacts contacts);
	void delete(String openId,String contactsId);
	List<Contacts> query(String openId);
	Contacts queryOne(String openId,String id);
	boolean isExist(String opendId,Contacts contacts);
	boolean isBinded(String openId);
}
