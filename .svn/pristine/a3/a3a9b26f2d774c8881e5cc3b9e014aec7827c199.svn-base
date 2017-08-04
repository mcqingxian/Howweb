package com.hoau.wechat.action;

import java.io.IOException;
import java.net.URLDecoder;
import java.util.List;

import javax.annotation.Resource;

import com.hoau.hbdp.framework.shared.encypt.base64.BASE64Decoder;
import com.hoau.hbdp.framework.shared.encypt.base64.BASE64Encoder;
import org.apache.log4j.Logger;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;

import com.hoau.hbdp.framework.exception.BusinessException;
import com.hoau.hbdp.framework.server.web.action.AbstractAction;
import com.hoau.mhow.module.bse.api.server.service.IContactsService;
import com.hoau.mhow.module.bse.api.server.service.IUserService;
import com.hoau.mhow.module.bse.api.shared.domain.ContactsEntity;
import com.hoau.mhow.module.bse.api.shared.domain.CustomerContactEntity;
import com.hoau.mhow.module.bse.api.shared.exception.OBHException;
import com.hoau.wechat.constants.ContactsType;
import com.hoau.wechat.constants.SessionConstants;
import com.hoau.wechat.util.PermissionCheck;
import com.opensymphony.xwork2.ActionContext;

/**
 * @author Dy 2015年12月16日
 */
@Controller
@Scope("prototype")
public class AddressMgtAction extends AbstractAction {

	private static final long serialVersionUID = 1026034156991728380L;

	private Logger logger = Logger.getLogger(AddressMgtAction.class);
	

	@Resource
	IUserService userService;

	@Resource
	IContactsService contactsService;
	
	
	/**
	 *联系人实体
	 */
	private ContactsEntity contactsEntity;
	
	/**
	 *发货人列表
	 */
	private List<ContactsEntity> senderContactsList;
	
	/**
	 *收货人列表
	 */
	private List<ContactsEntity> receivercontactsList;
	
	
	/**
	 *删除id集合
	 */
	private  List<String> contactIds;

	/**
	 * 地址簿管理
	 * 2015年12月25日
	 * @author Dy
	 */
	@PermissionCheck
	public String addressBookManage() {
		try {
			CustomerContactEntity po = getCurrentUser();
			senderContactsList = contactsService.queryMyContacts(po.getEbccId(), ContactsType.SHIPPER);
			receivercontactsList = contactsService.queryMyContacts(po.getEbccId(), ContactsType.CONSIGNEE);
		} catch (BusinessException e) {
			// TODO Dingyong query exception
			logger.error("AddressMgtAction queryMyContacts error : "
					+ e.getMessage());
		}
		return returnSuccess();
	}
	
	
	/**
	 * 保存  收/发货联系人
	 * 
	 * @author Dy 
	 * 
	 * 2015年12月14日
	 */
	@PermissionCheck
	public String addOrUpdateContacts() {
		try {
			CustomerContactEntity po = getCurrentUser();
			contactsEntity.setEbsaEbcuId(Long.valueOf(po.getEbccId()));
			contactsEntity.setModifier(String.valueOf(po.getEbccId()));
			contactsEntity.setCreator(String.valueOf(po.getEbccId()));
			if(contactsEntity.getEbsaId()!=null&&!StringUtils.isEmpty(contactsEntity.getEbsaId())){
				contactsService.updateContacts(contactsEntity);
			}else{
				contactsService.addContacts(contactsEntity);
			}
		} catch (BusinessException e) {
			// TODO  error
			logger.error("AddressMgtAction addContacts error : "
					+ e.getMessage());
			return returnError(e);
		}
		return returnSuccess("保存成功");
	}
	
	
	/**
	 * 设置默认联系人
	 * 2015年12月25日
	 * @author Dy
	 */
	@PermissionCheck
	public String setDefault(){
		try {
			CustomerContactEntity po = getCurrentUser();
			if(contactIds!=null&&contactIds.size()>0){
				contactsService.setDefault((long)po.getEbccId(), Long.valueOf(contactIds.get(0)), ContactsType.SHIPPER);
			}
		} catch (BusinessException e) {
			logger.error(" setDefaultAction error : "
					+ e.getMessage());
			return returnError(e);
		}
		return returnSuccess("设置默认联系人成功");
	}
	/**
	 * 删除联系人
	 * 2015年12月16日
	 * @author Dy
	 */
	@PermissionCheck
	public String deleteContacts() {
		try {
			CustomerContactEntity po = getCurrentUser();
			contactsService.delete(contactIds,(long) po.getEbccId());
		} catch (BusinessException e) {
			// TODO  error
			logger.error("AddressMgtAction deleteContacts error : "
					+ e.getMessage());
			return returnError(e);
		}
		return  returnSuccess("删除成功!");
	}
	
	/**
	 * 新增或修改界面
	 * 2015年12月25日
	 * @author Dy
	 */
	@PermissionCheck
	public String toContactOperatePage() {
		try {
			if(contactsEntity.getEbsaId()!=null&&!StringUtils.isEmpty(contactsEntity.getEbsaId())) {
                CustomerContactEntity customer = this.getCurrentUser();
                contactsEntity = contactsService.queryContactsById(contactsEntity.getEbsaId().toString(), customer.getEbccId().toString());
            }
            if (contactsEntity == null) {
                ActionContext ctx = ActionContext.getContext();
                ctx.getSession().put(SessionConstants.SESSION_USER_INFO.USER_INFO, null);
                //设置登陆类型
                ctx.getSession().put(SessionConstants.SESSION_USER_INFO.LOGIN_TYPE, null);
                //退出到首页
                return "exit";
            }
		} catch (Exception e) {
            e.printStackTrace();
			logger.error("系统异常");
		}
		return returnSuccess();
	}
	
	// 获取当前用户
	private CustomerContactEntity getCurrentUser() {
		ActionContext ctx = ActionContext.getContext();
		Object o = ctx.getSession().get(
				SessionConstants.SESSION_USER_INFO.USER_INFO);
		if (o == null) {
			throw new OBHException(OBHException.NOT_LOGIN, "notLogin");
		}
		CustomerContactEntity po = (CustomerContactEntity) o;
		return po;
	}
	
	public List<String> getContactIds() {
		return contactIds;
	}

	public void setContactIds(List<String> contactIds) {
		this.contactIds = contactIds;
	}


	public ContactsEntity getContactsEntity() {
		return contactsEntity;
	}

	public void setContactsEntity(ContactsEntity contactsEntity) {
		this.contactsEntity = contactsEntity;
	}


	public List<ContactsEntity> getSenderContactsList() {
		return senderContactsList;
	}


	public void setSenderContactsList(List<ContactsEntity> senderContactsList) {
		this.senderContactsList = senderContactsList;
	}


	public List<ContactsEntity> getReceivercontactsList() {
		return receivercontactsList;
	}

	public void setReceivercontactsList(List<ContactsEntity> receivercontactsList) {
		this.receivercontactsList = receivercontactsList;
	}
}
