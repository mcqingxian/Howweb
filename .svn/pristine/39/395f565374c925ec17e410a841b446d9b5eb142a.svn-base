package com.hoau.wechat.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hoau.wechat.dao.IContactMangeDao;
import com.hoau.wechat.dao.IUserInfoDao;
import com.hoau.wechat.exception.ContactsExistException;
import com.hoau.wechat.exception.UserNotBindException;
import com.hoau.wechat.service.IContactsManageService;
import com.hoau.wechat.util.UUIDUtil;
import com.hoau.wechat.vo.Contacts;
import com.hoau.wechat.vo.UserInfo;

/** 
* @ClassName  :ContactsManageService 
* @Descriptionl
* @author     :xujun cometzb@126.com	
* @date       :2014年4月24日 上午10:26:50 
*  
*/
@Service
public class ContactsManageService implements IContactsManageService{
	@Resource
	private IUserInfoDao userInfoDao;
	
	@Resource
	private IContactMangeDao contactMangeDao;
	
	public static List<UserInfo> userInfos = new ArrayList<UserInfo>();
	
	@Override
	public void add(String openId, Contacts contacts) {
		boolean exist = false;
		
		//查看该用户是否已经绑定手机
		boolean isBind = isBinded(openId);
		if(!isBind){
			throw new UserNotBindException("未进行手机绑定，无法操作此功能");
		}
		
		List<Contacts> contactsList = contactMangeDao.query(openId);
		int size = contactsList.size();
		for(int i = 0; i < size; i++){
			Contacts c = contactsList.get(i);
			//电话相同，就不可再添加
			if(c.getPhone().equals(contacts.getPhone()) && c.getType() == contacts.getType()){
				exist =true;
				break;
			}
		}
		if(exist){
			throw new ContactsExistException("联系人已经存在");
		}else{
			contacts.setId(UUIDUtil.getUUID());
			contactMangeDao.addContacts(openId, contacts);
		}
	}

	@Override
	public void update(String openId, Contacts contacts) {
		delete(openId, contacts.getId());
		add(openId,contacts);
	}
	
	@Override
	public void delete(String openId, String contactsId) {
		contactMangeDao.delete(openId, contactsId);
	}

	@Override
	public List<Contacts> query(String openId) {
		return contactMangeDao.query(openId);
	}

	@Override
	public Contacts queryOne(String openId, String contactsId) {
		return contactMangeDao.queryOne(openId, contactsId);
	}

	@Override
	public boolean isExist(String openId,Contacts contacts) {
		Contacts cts = contactMangeDao.queryOne(openId, contacts.getId());
		if(cts != null){
			return true;
		}
		return false;
	}

	@Override
	public boolean isBinded(String openId) {
		UserInfo info = userInfoDao.findOne(openId);
		if(info != null){
			if (info.getPhone() != null && !"".equals(info.getPhone())) {
				return true;
			}
		}
		return false;
	}

	public void setUserInfoDao(IUserInfoDao userInfoDao) {
		this.userInfoDao = userInfoDao;
	}

	public void setContactMangeDao(IContactMangeDao contactMangeDao) {
		this.contactMangeDao = contactMangeDao;
	}

}

