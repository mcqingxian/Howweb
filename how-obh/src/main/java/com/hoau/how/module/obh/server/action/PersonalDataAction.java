package com.hoau.how.module.obh.server.action;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.hoau.hbdp.framework.server.web.action.AbstractAction;
import com.hoau.how.module.common.constants.ControllConstants;
import com.hoau.how.module.common.constants.SessionConstants;
import com.hoau.how.module.obh.server.service.IUserService;
import com.hoau.how.module.obh.shared.domain.CustomerContactEntity;
import com.hoau.how.module.obh.shared.util.PermissionCheck;
import com.hoau.how.module.obh.shared.vos.CheckUserRsVo;
import com.hoau.how.module.util.md5.MD5;
import com.hoau.how.module.util.webcheck.ValidateUtils;
import com.opensymphony.xwork2.ActionContext;

/**
 *
 * @author 莫涛
 * @date 2015年7月21日
 */
@Controller
@Scope("prototype")
public class PersonalDataAction extends AbstractAction{
	/**
	 *
	 */
	private static final long serialVersionUID = 3069404720447035001L;
	private Logger logger = Logger.getLogger(ForgotAction.class);
	@Resource
	IUserService userService;
	private String controllType;
	private String errorType;
	private String errorMsg;
	private CustomerContactEntity entity;
	private String oldPassword;
	private String newPassword;
	private String phoneVerCode;
	private String categoryName;
	
	@PermissionCheck
	public String index(){
		try{
			ActionContext ctx = ActionContext.getContext();
			Object obj = ctx.getSession().get(SessionConstants.SESSION_USER_INFO.USER_INFO);
			CustomerContactEntity userInfo = (CustomerContactEntity) obj;
			Long ebccId = userInfo.getEbccId();
			this.entity = this.userService.findCustomerById(ebccId);
			ctx.getSession().put(SessionConstants.SESSION_USER_INFO.USER_INFO,this.entity);
			this.controllType = ControllConstants.CONTROLL_MY_HOAU.PERSONAL_DATA;
		}catch(Exception ex){
			logger.error("PersonalDataAction index error : " + ex.getMessage());
			ex.printStackTrace();
			return "checkError";
		}
		return "index";
	}
	
	@PermissionCheck
	public String modifyPersonalData(){
		String index = "index";
		this.controllType = ControllConstants.CONTROLL_MY_HOAU.PERSONAL_DATA;
		CheckUserRsVo vo = null;
		try{
			if(this.entity == null){
				setThisErrorMsg("参数为空！");
				return index;
			}
			ActionContext ctx = ActionContext.getContext();
			Object userInfoObj = ctx.getSession().get(SessionConstants.SESSION_USER_INFO.USER_INFO);
			//验证用户名
			vo = userService.checkUserNameJson(entity.getEbccNetLogin(), 2);
			if(!vo.isResult()){
				this.errorType = "userName";
				this.errorMsg = vo.getErrorMsg();
				return index;
			}else if(this.entity.getEbccContactName() == null || this.entity.getEbccContactName().equals("")){
				this.errorType = "contactName";
				setThisErrorMsg("请输入姓名！");
				return index;
			}else if(this.entity.getEbccContactName().length() > 50){
				this.errorType = "contactName";
				setThisErrorMsg("姓名长度不能大于50位！");
				return index;
			}else if(this.entity.getEbccSex() == null || this.entity.getEbccSex().equals("")){
				this.errorType = "sex";
				setThisErrorMsg("请选择性别！");
				return index;
			}else if(this.entity.getEbccCompany() != null && this.entity.getEbccCompany().length() > 50){
				this.errorType = "company";
				setThisErrorMsg("公司全称长度不能大于50位！");
				return index;
			}else if(this.entity.getEbccTel() != null && !this.entity.getEbccTel().equals("")){
				if(!ValidateUtils.isTel(this.entity.getEbccTel())){
					this.errorType = "tel";
					setThisErrorMsg("请输入正确座机号！");
					return index;
				}
			}
			CustomerContactEntity userInfo = (CustomerContactEntity) userInfoObj;
			this.entity.setEbccId(userInfo.getEbccId());
			this.errorType = "mobile";
			//如果当前手机号与数据库中记录不一致
			if(!userInfo.getEbccMobile().equals(this.entity.getEbccMobile())){
				vo = this.userService.checkPhoneJson(userInfo.getEbccMobile(), 2);
				//验证手机号格式
				if(!vo.isResult()){
					setThisErrorMsg(vo.getErrorMsg());
					return index;
				}
				if(this.phoneVerCode == null || this.phoneVerCode.equals("")){
					setThisErrorMsg("请输入验证码！");
					return index;
				}
				//判断验证码是否输入正确
				Object obj = ctx.getSession().get(SessionConstants.SESSION_REGIST_VERCODE_KEYS.PHONE_REGIST_SMS_VERCODE);
				if(obj == null){
					setThisErrorMsg("验证码信息为空，请先获取验证码！");
					return index;
				}
				String verCode = obj.toString();
				if(!verCode.equals(this.phoneVerCode)){
					setThisErrorMsg("验证码填写错误！");
					return index;
				}
			}
			//验证邮箱
			vo = this.userService.checkEmailJson(entity.getEbccEmail(), 2);
			if(!vo.isResult()){
				this.errorType = "email";
				setThisErrorMsg(vo.getErrorMsg());
				return index;
			}
			if(this.entity.getEbccDistrict() == null || this.entity.getEbccDistrict().equals("")){
				this.errorType = "district";
				setThisErrorMsg("请选择所在省市！");
				return index;
			}else if(this.entity.getEbccAddress() != null && 
					this.entity.getEbccAddress().length() > 200){
				this.errorType = "district";
				setThisErrorMsg("详细地址长度不能大于200位！");
				return index;
			}else if(this.entity.getEbccRemark() != null && 
					this.entity.getEbccRemark().length() > 200){
				this.errorType = "remark";
				setThisErrorMsg("备注长度不能大于200位！");
				return index;
			}
			this.userService.modifyCustomerInfoById(this.entity);
			this.errorType = "success";
			index = "updatePersonalData";
			setThisSuccessMsg("修改成功！");
		}catch(Exception ex){
			logger.error("PersonalDataAction modifyPersonalData error : " + ex.getMessage());
			this.errorType = "systemError";
			setThisErrorMsg("系统异常："+ex.getMessage());
			ex.printStackTrace();
			return index;
		}
		return index;
	}
	
	@PermissionCheck
	public String resetPassword(){
		try{
			this.controllType = ControllConstants.CONTROLL_MY_HOAU.PERSONAL_DATA;
			ActionContext ctx = ActionContext.getContext();
			Object userInfoObj = ctx.getSession().get(SessionConstants.SESSION_USER_INFO.USER_INFO);
			if(this.oldPassword == null || this.oldPassword.equals("")){
				this.errorType = "oldPassword";
				setThisErrorMsg("请输入原始密码！");
				return "resetPassword";
			}else if(this.newPassword == null || this.newPassword.equals("")){
				this.errorType = "newPassword";
				setThisErrorMsg("请输入新密码！");
				return "resetPassword";
			}else if(this.newPassword.length() > 16 || this.newPassword.length() < 6){
				this.errorType = "newPassword";
				//密码长度为6到16位
				setThisErrorMsg("新密码长度应在6-16位！");
				return "resetPassword";
			}
			
			CustomerContactEntity userInfo = (CustomerContactEntity) userInfoObj;
			String pwd = MD5.encode(this.oldPassword);
			CustomerContactEntity conditionVo = new CustomerContactEntity();
			conditionVo.setEbccMobile(userInfo.getEbccMobile());
			conditionVo.setEbccNetLogin(userInfo.getEbccNetLogin());
			conditionVo.setEbccEmail(userInfo.getEbccEmail());
			conditionVo.setEbccNetPassword(pwd);
			conditionVo.setEbccId(userInfo.getEbccId());
			CustomerContactEntity user = this.userService.findCustomer(conditionVo);
			if(user != null && user.getEbccNetPassword().equals(pwd)){
				CustomerContactEntity vo = new CustomerContactEntity();
				vo.setEbccId(userInfo.getEbccId());
				vo.setEbccNetPassword(MD5.encode(this.newPassword));
				this.userService.modifyCustomerPwdById(vo);
			}else{
				this.errorType = "oldPassword";
				//密码长度为6到16位
				setThisErrorMsg("请输入正确的原始密码！");
				return "resetPassword";
			}
			this.errorType = "success";
			setThisSuccessMsg("修改成功！");
		}catch(Exception ex){
			logger.error("PersonalDataAction resetPassword error : " + ex.getMessage());
			this.errorType = "systemError";
			setThisErrorMsg("系统异常："+ex.getMessage());
			ex.printStackTrace();
		}
		return "resetPassword";
	}
	
	private void setThisErrorMsg(String msg){
		this.errorMsg = "<p class='erro'><span class='icon_del'></span>"+msg+"</p>";
	}
	
	private void setThisSuccessMsg(String msg){
		this.errorMsg = "<p class='succ'><span class='icon_succ'></span>"+msg+"</p>";
	}
	
	public String getErrorType() {
		return errorType;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public String getControllType() {
		return controllType;
	}

	public CustomerContactEntity getEntity() {
		return entity;
	}

	public void setEntity(CustomerContactEntity entity) {
		this.entity = entity;
	}

	public void setPhoneVerCode(String phoneVerCode) {
		this.phoneVerCode = phoneVerCode;
	}

	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	
}
