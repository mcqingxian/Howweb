package com.hoau.how.module.obh.server.service;

import java.io.InputStream;
import java.util.List;

import com.hoau.how.module.obh.shared.domain.ContactsEntity;
import com.hoau.how.module.obh.shared.domain.NetOrderEntity;
import com.hoau.how.module.obh.shared.domain.UnpayMentEntity;
import com.hoau.how.module.obh.shared.util.Paging;

/**
 *
 * @author 徐俊
 * @date 2015年7月19日
 */
public interface IContactsService {
	/**
	 * 
	 * @param userId
	 * @return
	 * @author 徐俊
	 * @date 2015年7月19日
	 * @update 
	 */
	Paging<ContactsEntity> queryMyContactsPage(ContactsEntity contactsEntity,String type,int pageSize,int pageNo);
	
	List<ContactsEntity> queryMyContacts(long userId,String type);
	
	public void addContacts(ContactsEntity contactsEntity);
	
	public void addContacts(ContactsEntity contactsEntity,List<UnpayMentEntity> unpayMentList);

	void delete(List<String> contactsIds, Long userId);
	
	public InputStream getExcelIs(long userId,String type);

	public ContactsEntity queryContactsById(String contactsIds,Long long1);

	public void setDefault(long valueOf, long contactsIds,String contactsType);
	
	public void updateContacts(ContactsEntity contactsEntity);
	
	public void updateContacts(ContactsEntity contactsEntity,List<UnpayMentEntity> unpayMentList);
	
	public NetOrderEntity setDefaultContacts(Long userId, boolean isBatchOrder);
	
	public ContactsEntity queryContact(ContactsEntity contactsEntity);
}
