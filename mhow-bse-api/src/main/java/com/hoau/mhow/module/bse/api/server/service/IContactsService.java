package com.hoau.mhow.module.bse.api.server.service;

import java.util.List;

import com.hoau.mhow.module.bse.api.shared.domain.ContactsEntity;
import com.hoau.mhow.module.bse.api.shared.domain.NetOrderEntity;

/**
 * 发货人信息管理SERVICE
 *
 * @author 蒋落琛
 * @date 2015-12-14
 */
public interface IContactsService {
	
	//Paging<ContactsEntity> queryMyContactsPage(ContactsEntity contactsEntity,String type,int pageSize,int pageNo);
	
	List<ContactsEntity> queryMyContacts(long userId,String type);
	
	public void addContacts(ContactsEntity contactsEntity);

	void delete(List<String> contactsIds, Long userId);
	
	//public InputStream getExcelIs(long userId,String type);

	public ContactsEntity queryContactsById(String contactsIds,String customerId);

	public void setDefault(long valueOf, long contactsIds,String contactsType);
	
	public void updateContacts(ContactsEntity contactsEntity);
	
	public NetOrderEntity setDefaultContacts(Long userId, boolean isBatchOrder);
	
	public ContactsEntity queryContact(ContactsEntity contactsEntity);
	
	/**
	 * 地址簿联系人总数
	 * 2015年12月17日
	 * @author Dy
	 */
	int countContact(long userId);
}
