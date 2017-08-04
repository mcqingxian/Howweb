package com.hoau.wechat.action;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.hoau.wechat.constant.Constant;
import com.hoau.wechat.exception.ContactsExistException;
import com.hoau.wechat.exception.UserNotBindException;
import com.hoau.wechat.service.IContactsManageService;
import com.hoau.wechat.utils.net.WeixinUtil;
import com.hoau.wechat.vo.Contacts;
import com.opensymphony.xwork2.Action;

/** 
* @ClassName  :AddressBookManageAction 
* @Description:联系人管理 Action
* @author     :xujun cometzb@126.com	
* @date       :2014年4月24日 上午10:30:13 
*  
*/
@Controller
@Scope("prototype")
public class AddressBookManageAction implements Action {
	private static final Log log = LogFactory.getLog(AddressBookManageAction.class);

	/**
	 * 微信发送的Code 用来获取access_token 然后获得openid
	 */
	private String code;
	
	private Contacts contacts;
	/**
	 * 联系类型
	 */
	private int type;
	
	private List<Contacts> contactsList;
	
	private List<Contacts> senderContactsList;
	
	private List<Contacts> receivercontactsList;
	
	@Resource
	private IContactsManageService contactsManageService;
	/**
	 * 提示信息
	 */
	private String noticeMsg;
	/**
	 * 联系人ID
	 */
	private String contactsId;
	@Override
	public String execute() throws Exception {
		log.info("weixin auth code:"+code);
		contactsList = contactsManageService.query(WeixinUtil.getOpenIdFromSession());
		senderContactsList = new ArrayList<Contacts>();
		receivercontactsList = new ArrayList<Contacts>();
		for(Contacts c:contactsList){
			if(c.getType() == Constant.CONTACTS_TYPE_SEND){
				senderContactsList.add(c);
			}else{
				receivercontactsList.add(c);
			}
		}
		return SUCCESS;
	}

	public String addContacts() throws Exception {
		String openId = WeixinUtil.getOpenIdFromSession();
		try {
			contactsManageService.add(openId, contacts);
			noticeMsg = "添加成功";
		} catch (ContactsExistException e) {
			noticeMsg = "c_exist";
		} catch (UserNotBindException e){
			noticeMsg = "no_bind";
		}catch(Exception e){
			e.printStackTrace();
		}
		return SUCCESS;
	}
	
	/** 
	* @Title      :updateContacts 
	* @Description:修改联系人
	* @param      :@return
	* @param      :@throws Exception   
	* @return     :String 
	* @date       :2014年5月1日 上午3:59:33   
	* @throws 
	*/
	public String updateContacts() throws Exception {
		contactsManageService.update(WeixinUtil.getOpenIdFromSession(), contacts);
		noticeMsg = "修改成功";
		return SUCCESS;
	}
	
	public String deleteContacts() throws Exception {
		String openId = WeixinUtil.getOpenIdFromSession();
		contactsManageService.delete(openId, contactsId);
		noticeMsg = "删除成功！";
		return SUCCESS;
	}
	
	public String queryContacts() throws Exception {
		contactsList = contactsManageService.query(WeixinUtil.getOpenIdFromSession());
		for(Contacts c:contactsList){
			if(c.getType() == Constant.CONTACTS_TYPE_SEND){
				senderContactsList.add(c);
			}else{
				receivercontactsList.add(c);
			}
		}
		return SUCCESS;
	}
	
	public String toUpdatePage() throws Exception {
		contacts = contactsManageService.queryOne(WeixinUtil.getOpenIdFromSession(), contactsId);
		return SUCCESS;
	}
	
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Contacts getContacts() {
		return contacts;
	}

	public void setContacts(Contacts contacts) {
		this.contacts = contacts;
	}

	public void setContactsManageService(
			IContactsManageService contactsManageService) {
		this.contactsManageService = contactsManageService;
	}
	
	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public List<Contacts> getContactsList() {
		return contactsList;
	}

	public void setContactsList(List<Contacts> contactsList) {
		this.contactsList = contactsList;
	}

	public String getNoticeMsg() {
		return noticeMsg;
	}

	public void setNoticeMsg(String noticeMsg) {
		this.noticeMsg = noticeMsg;
	}

	public String getContactsId() {
		return contactsId;
	}

	public void setContactsId(String contactsId) {
		this.contactsId = contactsId;
	}

	public List<Contacts> getSenderContactsList() {
		return senderContactsList;
	}

	public void setSenderContactsList(List<Contacts> senderContactsList) {
		this.senderContactsList = senderContactsList;
	}

	public List<Contacts> getReceivercontactsList() {
		return receivercontactsList;
	}

	public void setReceivercontactsList(List<Contacts> receivercontactsList) {
		this.receivercontactsList = receivercontactsList;
	}
	
}
