package com.hoau.mhow.module.bse.server.action;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.hoau.hbdp.framework.server.web.action.AbstractAction;
import com.hoau.mhow.module.bse.api.server.service.IContactsService;
import com.hoau.mhow.module.bse.api.server.service.IUserService;
import com.hoau.mhow.module.bse.api.shared.domain.ContactsEntity;
import com.hoau.mhow.module.bse.api.shared.domain.CustomerContactEntity;
import com.hoau.mhow.module.bse.api.shared.exception.OBHException;
import com.hoau.wechat.constants.SessionConstants;
import com.hoau.wechat.md5.MD5;
import com.hoau.wechat.util.PermissionCheck;
import com.opensymphony.xwork2.ActionContext;

/**
 * 用户 action
 * @author Dy 
 * 2015年12月8日 
 */
@Controller
@Scope("prototype")
public class UserCenterAction extends AbstractAction {

	private static final long serialVersionUID = -688885034821277691L;

	private Logger logger = Logger.getLogger(UserCenterAction.class);

	@Resource
	IUserService userService;

	@Resource
	IContactsService contactsService;

	/**
	 *错误信息
	 */
	private String errorMsg;

	private CustomerContactEntity entity;
	
	private ContactsEntity contactsEntity;

	private String oldPassword;

	private String newPassword;

	@PermissionCheck
	public String myHoau() {
		return returnSuccess();
	}

	@PermissionCheck
	public String myAccount() {
		return returnSuccess();
	}

	@PermissionCheck
	public String updatePhone() {
		return returnSuccess();
	}

	@PermissionCheck
	public String updatePassword() {
		return returnSuccess();
	}
	
	/**
	 * 修改密码 
	 * 
	 * 2015年12月11日
	 * @author Dy
	 */
	
	public String resetPassword() {
		try {
			if (this.oldPassword == null || this.oldPassword.equals("")) {
				this.errorMsg = "请输入原始密码！";
				return "resetError";
			} else if (this.newPassword == null || this.newPassword.equals("")) {
				this.errorMsg = "请输入新密码！";
				return "resetError";
			} else if (this.newPassword.length() > 16
					|| this.newPassword.length() < 6) {
				// 密码长度为6到16位
				this.errorMsg = "新密码长度应在6-16位！";
				return "resetError";
			}

			CustomerContactEntity userInfo = getCurrentUser();
			String pwd = MD5.encode(this.oldPassword);
			CustomerContactEntity conditionVo = new CustomerContactEntity();
			conditionVo.setEbccMobile(userInfo.getEbccMobile());
			conditionVo.setEbccNetLogin(userInfo.getEbccNetLogin());
			conditionVo.setEbccEmail(userInfo.getEbccEmail());
			conditionVo.setEbccNetPassword(pwd);
			conditionVo.setEbccId(userInfo.getEbccId());
			CustomerContactEntity user = this.userService
					.findCustomer(conditionVo);
			if (user != null && user.getEbccNetPassword().equals(pwd)) {
				CustomerContactEntity vo = new CustomerContactEntity();
				vo.setEbccId(userInfo.getEbccId());
				vo.setEbccNetPassword(MD5.encode(this.newPassword));
				this.userService.modifyCustomerPwdById(vo);
			} else {
				// 密码长度为6到16位
				this.errorMsg = "请输入正确的原始密码！";
				return "resetError";
			}
			this.errorMsg = "修改成功！";
		} catch (Exception ex) {
			logger.error("PersonalDataAction resetPassword error : "
					+ ex.getMessage());
			this.errorMsg = "系统异常：" + ex.getMessage();
			ex.printStackTrace();
		}
		return "resetPassword";
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

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	public CustomerContactEntity getEntity() {
		return entity;
	}

	public void setEntity(CustomerContactEntity entity) {
		this.entity = entity;
	}

	public ContactsEntity getContactsEntity() {
		return contactsEntity;
	}

	public void setContactsEntity(ContactsEntity contactsEntity) {
		this.contactsEntity = contactsEntity;
	}

	public String getOldPassword() {
		return oldPassword;
	}

	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	
}
