package com.hoau.how.module.obh.server.action;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.hoau.hbdp.framework.server.web.action.AbstractAction;
import com.hoau.how.module.common.constants.SessionConstants;
import com.hoau.how.module.itf.server.ws.sms.impl.SMS;
import com.hoau.how.module.obh.server.service.IForgotService;
import com.hoau.how.module.obh.server.service.IUserService;
import com.hoau.how.module.obh.shared.domain.CustomerContactEntity;
import com.hoau.how.module.util.Utils;
import com.hoau.how.module.util.date.DateUtils;
import com.hoau.how.module.util.md5.MD5;
import com.hoau.how.module.util.md5.MD5BASE64;
import com.opensymphony.xwork2.ActionContext;

/**
 *
 * @author 莫涛
 * @date 2015年7月15日
 */
@Controller
@Scope("prototype")
public class ForgotAction extends AbstractAction{
	private Logger logger = Logger.getLogger(ForgotAction.class);
	/**
	 *
	 */
	private static final long serialVersionUID = -616128999154882610L;
	@Resource
	IForgotService forgotService;
	@Resource
	IUserService userService;
	CustomerContactEntity entity;
	private static final Long COUNT_DOWN = 60L;
	/**
	 * 用户ID
	 */
	String ebccId;
	/**
	 * 手机
	 */
	String phone;
	/**
	 * 手机新密码
	 */
	String phonePassword;
	/**
	 * 邮箱
	 */
	String email;
	/**
	 * 邮箱新密码
	 */
	String emailPassword;
	/**
	 * 验证结果
	 */
	String errorMsg;
	/**
	 * 验证失败类型
	 */
	String errorType;
	/**
	 * 手机验证码
	 */
	String phoneCode;
	/**
	 * 手机MD5验证码
	 */
	String phoneMd5Code;
	/**
	 * 邮箱验证码
	 */
	String emailCode;
	/**
	 * 邮箱MD5验证码
	 */
	String emailMd5Code;
	/**
	 * 密码找回类型
	 */
	String type;
	/**
	 * 倒计时
	 */
	Long countdown;
	/**
	 * 通过手机找回密码
	 * @return
	 * @author 莫涛
	 * @date 2015年7月15日
	 * @update
	 */
	public String phoneRetrieve(){
		try{
			this.type ="phone";
			// 从Session中获取验证码
			ActionContext ctx = ActionContext.getContext();
			// 先根据session记录的phoneCode检查用户输入的验证码
			String phoneVerCode = (String) ctx.getSession().get(SessionConstants.SESSION_VERCODE_KEYS.PHONE_VERCODE);
			if(phone == null || phone.equals("")){
				errorType = "phone";
				setThisErrorMsg("手机号码为空!");
				return "checkError";
			}else{
				if(phoneVerCode != null && phoneVerCode.equalsIgnoreCase(phoneCode)){
					CustomerContactEntity vo = new CustomerContactEntity();
					vo.setEbccMobile(phone);
					entity = forgotService.findCustomer(vo);
					//如果不存在该用户
					if(entity == null){
						errorType = "phone";
						setThisErrorMsg("该用户不存在！");
						return "checkError";
					}else{
						this.ebccId = entity.getEbccId().toString();
						errorMsg = null;
					}
				}else{
					errorType = "verCode";
					setThisErrorMsg("验证码填写错误!");
					return "checkError";
				}
			}
		}catch(Exception ex){
			logger.error("ForgotAction phoneRetrieve error : " + ex.getMessage());
			ex.printStackTrace();
			return "checkError";
		}
		return "phoneRetrieve";
	}
	
	/**
	 * 发送手机验证码
	 * @return
	 * @author 莫涛
	 * @date 2015年7月17日
	 * @update
	 */
	public String sendPhoneVerCodeJson(){
		try{
			// 从Session中获取验证码
			ActionContext ctx = ActionContext.getContext();
			Object obj = ctx.getSession().get(SessionConstants.SESSION_VERCODE_KEYS.PHONE_VERCODE_SEND_TIME);
			boolean sendMsg = false;
			if(obj == null){
				//倒计时为60秒
				this.countdown = COUNT_DOWN;
				//将第一次获取验证码时间保存
				ctx.getSession().put(SessionConstants.SESSION_VERCODE_KEYS.PHONE_VERCODE_SEND_TIME,DateUtils.getCurYmdhms());
				sendMsg = true;
			}else{
				//第一次获取验证码时间
				Long phoneVercodeSendTime = Long.parseLong(obj.toString());
				//当前时间
				Long curDate = Long.parseLong(DateUtils.getCurYmdhms());
				this.countdown = curDate - phoneVercodeSendTime;
				this.countdown = COUNT_DOWN - this.countdown;
				//超过60秒后，可重新发送,并且清空session
				if(this.countdown <= 0){
					sendMsg = true;
					ctx.getSession().put(SessionConstants.SESSION_VERCODE_KEYS.PHONE_VERCODE_SEND_TIME,null);
				}else{
					this.errorMsg = "请在"+this.countdown+"秒后进行操作！";
				}
			}
			if(sendMsg && phone != null && !phone.equals("")){
				String phoneSmsVercode = Utils.randomNum(6);
				SMS sms = new SMS(phone, "您本次找回密码验证码为："+phoneSmsVercode+"，请您在30分钟内完成验证，如有疑问请致电：400-808-6666");
				forgotService.sendSms(sms);
				//将手机MD5验证码保存至session
				ctx.getSession().put(SessionConstants.SESSION_VERCODE_KEYS.PHONE_SMS_MD5_VERCODE, MD5BASE64.base64MD5(phone+phoneSmsVercode, "UTF-8"));
				this.errorMsg = "短信已发送，请注意查收！";
			}
		}catch(Exception ex){
			ex.printStackTrace();
			logger.error("ForgotAction sendPhoneVerCodeJson error : " + ex.getMessage());
		}
		return "sendPhoneVerCodeJson";
	}
	
	/**
	 * 检测发送验证码时间是超过指定时间
	 * @return
	 * @author 莫涛
	 * @date 2015年7月17日
	 * @update
	 */
	public String checkCountDownPhoneJson(){
		try{
			// 从Session中获取验证码
			ActionContext ctx = ActionContext.getContext();
			Object obj = ctx.getSession().get(SessionConstants.SESSION_VERCODE_KEYS.PHONE_VERCODE_SEND_TIME);
			if(obj != null){
				//第一次获取验证码时间
				Long phoneVercodeSendTime = Long.parseLong(obj.toString());
				//当前时间
				Long curDate = Long.parseLong(DateUtils.getCurYmdhms());
				this.countdown = curDate - phoneVercodeSendTime;
				this.countdown = COUNT_DOWN - this.countdown;
				//超过60秒后，可重新发送,并且清空session
				if(this.countdown <= 0){
					ctx.getSession().put(SessionConstants.SESSION_VERCODE_KEYS.PHONE_VERCODE_SEND_TIME,null);
				}else{
					this.errorMsg = "请在"+this.countdown+"秒后进行操作！";
				}
			}
		}catch(Exception ex){
			ex.printStackTrace();
			logger.error("ForgotAction checkCountDownPhoneJson error : " + ex.getMessage());
		}
		return "checkCountDownPhoneJson";
	}
	
	/**
	 * 通过邮箱找回密码
	 * @return
	 * @author 莫涛
	 * @date 2015年7月15日
	 * @update
	 */
	public String emailRetrieve(){
		try{
			this.type ="email";
			// 从Session中获取验证码
			ActionContext ctx = ActionContext.getContext();
			// 先根据session记录的emailCode检查用户输入的验证码
			String emailVerCode = (String) ctx.getSession().get(SessionConstants.SESSION_VERCODE_KEYS.EMAIL_VERCODE);
			if(email == null || email.equals("")){
				errorType = "email";
				setThisErrorMsg("邮箱地址为空!");
				return "checkError";
			}else{
				if(emailVerCode != null && emailVerCode.equalsIgnoreCase(emailCode)){
					CustomerContactEntity vo = new CustomerContactEntity();
					vo.setEbccEmail(this.email);
					entity = forgotService.findCustomer(vo);
					//如果不存在该用户
					if(entity == null){
						errorType = "email";
						setThisErrorMsg("该用户不存在！");
						return "checkError";
					}else{
						this.ebccId = entity.getEbccId().toString();
						//发送邮件至邮箱
						errorMsg = null;
					}
				}else{
					errorType = "verCode";
					setThisErrorMsg("验证码填写错误！");
					return "checkError";
				}
			}
		}catch(Exception ex){
			logger.error("ForgotAction emailRetrieve error : " + ex.getMessage());
			ex.printStackTrace();
			return "checkError";
		}
		return "emailRetrieve";
	}
	
	/**
	 * 发送邮箱验证码
	 * @return
	 * @author 莫涛
	 * @date 2015年7月17日
	 * @update
	 */
	public String sendEmailVerCodeJson(){
		try{
			// 从Session中获取验证码
			ActionContext ctx = ActionContext.getContext();
			Object obj = ctx.getSession().get(SessionConstants.SESSION_VERCODE_KEYS.EMAIL_VERCODE_SEND_TIME);
			boolean sendMsg = false;
			if(obj == null){
				//倒计时为60秒
				this.countdown = COUNT_DOWN;
				//将第一次获取验证码时间保存
				ctx.getSession().put(SessionConstants.SESSION_VERCODE_KEYS.EMAIL_VERCODE_SEND_TIME,DateUtils.getCurYmdhms());
				sendMsg = true;
			}else{
				//第一次获取验证码时间
				Long emailVercodeSendTime = Long.parseLong(obj.toString());
				//当前时间
				Long curDate = Long.parseLong(DateUtils.getCurYmdhms());
				this.countdown = curDate - emailVercodeSendTime;
				this.countdown = COUNT_DOWN - this.countdown;
				//超过60秒后，可重新发送,并且清空session
				if(this.countdown <= 0){
					sendMsg = true;
					ctx.getSession().put(SessionConstants.SESSION_VERCODE_KEYS.EMAIL_VERCODE_SEND_TIME,null);
				}else{
					this.errorMsg = "请在"+this.countdown+"秒后进行操作！";
				}
			}
			if(sendMsg && email != null && !email.equals("")){
				String emailSmsVercode = Utils.randomNum(6);
				this.forgotService.sendMail(emailSmsVercode, email);
				//将邮箱地址MD5验证码保存至session
				ctx.getSession().put(SessionConstants.SESSION_VERCODE_KEYS.EMAIL_SMS_MD5_VERCODE, MD5BASE64.base64MD5(email+emailSmsVercode, "UTF-8"));
				this.errorMsg = "邮件已发送，请注意查收！";
			}
		}catch(Exception ex){
			ex.printStackTrace();
			logger.error("ForgotAction sendEmailVerCodeJson error : " + ex.getMessage());
		}
		return "sendEmailVerCodeJson";
	}
	
	/**
	 * 检测发送验证码时间是超过指定时间
	 * @return
	 * @author 莫涛
	 * @date 2015年7月17日
	 * @update
	 */
	public String checkCountDownEmailJson(){
		try{
			// 从Session中获取验证码
			ActionContext ctx = ActionContext.getContext();
			Object obj = ctx.getSession().get(SessionConstants.SESSION_VERCODE_KEYS.EMAIL_VERCODE_SEND_TIME);
			if(obj != null){
				//第一次获取验证码时间
				Long emailVercodeSendTime = Long.parseLong(obj.toString());
				//当前时间
				Long curDate = Long.parseLong(DateUtils.getCurYmdhms());
				this.countdown = curDate - emailVercodeSendTime;
				this.countdown = COUNT_DOWN - this.countdown;
				//超过60秒后，可重新发送,并且清空session
				if(this.countdown <= 0){
					ctx.getSession().put(SessionConstants.SESSION_VERCODE_KEYS.EMAIL_VERCODE_SEND_TIME,null);
				}else{
					this.errorMsg = "请在"+this.countdown+"秒后进行操作！";
				}
			}
		}catch(Exception ex){
			ex.printStackTrace();
			logger.error("ForgotAction checkCountDownEmailJson error : " + ex.getMessage());
		}
		return "checkCountDownEmailJson";
	}
	
	public String toSetNewPwdByPhone(){
		try{
			this.type = "phone";
			// 从Session中获取验证码
			ActionContext ctx = ActionContext.getContext();
			Object obj = ctx.getSession().get(SessionConstants.SESSION_VERCODE_KEYS.PHONE_SMS_MD5_VERCODE);
			String phoneSmsMd5Vercode = "";
			if(obj != null){
				phoneSmsMd5Vercode = obj.toString();
			}else{
				setThisErrorMsg("验证码信息为空！");
				this.errorType = "verCode";
				return "phoneRetrieve";
			}
			if(this.ebccId == null || this.ebccId.equals("") || this.phone == null || this.phone.equals("")){
				setThisErrorMsg("用户信息获取失败！");
				this.errorType = "phone";
				return "phoneRetrieve";
			}else if(this.phoneCode == null || this.phoneCode.equals("")){
				setThisErrorMsg("验证码不能为空！");
				this.errorType = "verCode";
				return "phoneRetrieve";
			}
			this.phoneMd5Code = MD5BASE64.base64MD5(this.phone+this.phoneCode, "UTF-8");
			//验证码不一致
			if(!this.phoneMd5Code.equals(phoneSmsMd5Vercode)){
				setThisErrorMsg("验证码填写错误！");
				this.errorType = "verCode";
				return "phoneRetrieve";
			}
		}catch(Exception ex){
			logger.error("ForgotAction toSetNewPwdByPhone error : " + ex.getMessage());
			ex.printStackTrace();
			return "checkError";
		}
		return "toSetNewPwdByPhone";
	}
	
	public String toSetNewPwdByEmail(){
		try{
			this.type = "email";
			// 从Session中获取验证码
			ActionContext ctx = ActionContext.getContext();
			Object obj = ctx.getSession().get(SessionConstants.SESSION_VERCODE_KEYS.EMAIL_SMS_MD5_VERCODE);
			String emailSmsMd5Vercode = "";
			if(obj != null){
				emailSmsMd5Vercode = obj.toString();
			}else{
				setThisErrorMsg("验证码信息为空！");
				this.errorType = "verCode";
				return "emailRetrieve";
			}
			if(this.ebccId == null || this.ebccId.equals("") || this.email == null || this.email.equals("")){
				setThisErrorMsg("用户信息获取失败！");
				this.errorType = "phone";
				return "emailRetrieve";
			}else if(this.emailCode == null || this.emailCode.equals("")){
				setThisErrorMsg("验证码不能为空！");
				this.errorType = "verCode";
				return "emailRetrieve";
			}
			this.emailMd5Code = MD5BASE64.base64MD5(this.email+this.emailCode, "UTF-8");
			//验证码不一致
			if(!this.emailMd5Code.equals(emailSmsMd5Vercode)){
				setThisErrorMsg("验证码填写错误！");
				this.errorType = "verCode";
				return "emailRetrieve";
			}
		}catch(Exception ex){
			logger.error("ForgotAction toSetNewPwdByEmail error : " + ex.getMessage());
			ex.printStackTrace();
			return "checkError";
		}
		return "toSetNewPwdByEmail";
	}
	
	/**
	 * 通过用户ID进行修改用户密码
	 * @return
	 * @author 莫涛
	 * @date 2015年7月17日
	 * @update
	 */
	public String modifyUserPwdByPhone(){
		try{
			this.type = "phone";
			// 从Session中获取验证码
			ActionContext ctx = ActionContext.getContext();
			Object obj = ctx.getSession().get(SessionConstants.SESSION_VERCODE_KEYS.PHONE_SMS_MD5_VERCODE);
			String phoneSmsMd5Vercode = "";
			if(obj != null){
				phoneSmsMd5Vercode = obj.toString();
			}else{
				this.errorType = "verCode";
				setThisErrorMsg("验证码信息为空！");
				return "checkError";
			}
			if(this.ebccId == null || this.ebccId.equals("")){
				this.errorType = "phone";
				setThisErrorMsg("用户信息为空！");
				return "checkError";
			}else if(this.phonePassword == null || this.phonePassword.equals("")){
				setThisErrorMsg("密码不能为空！");
				return "toSetNewPwdByPhone";
			}else if(this.phonePassword.length() > 16 || this.phonePassword.length() < 6){
				//密码长度为6到16位
				setThisErrorMsg("密码长度应在6-16位！");
				return "toSetNewPwdByPhone";
			}
			
			//验证码一致,则进行密码修改
			if(this.phoneMd5Code.equals(phoneSmsMd5Vercode)){
				CustomerContactEntity vo = new CustomerContactEntity();
				vo.setEbccId(Long.parseLong(this.ebccId));
				//密码MD5加密
				vo.setEbccNetPassword(MD5.encode(this.phonePassword));
				//修改密码
				forgotService.modifyCustomerPwdById(vo);
				//查找密码信息，将密码放至session，进行登陆使用
				CustomerContactEntity entity = forgotService.findCustomer(vo);
				ctx.getSession().put(SessionConstants.SESSION_USER_INFO.USER_INFO,entity);
				//设置登陆类型
				ctx.getSession().put(SessionConstants.SESSION_USER_INFO.LOGIN_TYPE,SessionConstants.SESSION_USER_INFO.PHONE);
				//登录后，修改最后一次登录时间
				userService.modifyCustomerTimeById(entity);
			}else{
				this.errorType = "phone";
				setThisErrorMsg("身份验证失败！");
				return "checkError";
			}
		}catch(Exception ex){
			logger.error("ForgotAction modifyUserPwdByPhone error : " + ex.getMessage());
			ex.printStackTrace();
			return "checkError";
		}
		return "index";
	}
	
	/**
	 * 通过用户ID进行修改用户密码
	 * @return
	 * @author 莫涛
	 * @date 2015年7月17日
	 * @update
	 */
	public String modifyUserPwdByEmail(){
		try{
			this.type = "email";
			// 从Session中获取验证码
			ActionContext ctx = ActionContext.getContext();
			Object obj = ctx.getSession().get(SessionConstants.SESSION_VERCODE_KEYS.EMAIL_SMS_MD5_VERCODE);
			String phoneSmsMd5Vercode = "";
			if(obj != null){
				phoneSmsMd5Vercode = obj.toString();
			}else{
				this.errorType = "verCode";
				setThisErrorMsg("验证码信息为空！");
				return "checkError";
			}
			if(this.ebccId == null || this.ebccId.equals("")){
				this.errorType = "email";
				setThisErrorMsg("用户信息为空！");
				return "checkError";
			}else if(this.emailPassword == null || this.emailPassword.equals("")){
				setThisErrorMsg("密码不能为空！");
				return "modifyUserPwdByEmail";
			}else if(this.emailPassword.length() > 16 || this.emailPassword.length() < 6){
				//密码长度为6到16位
				setThisErrorMsg("密码长度应在6-16位！");
				return "modifyUserPwdByEmail";
			}
			
			//验证码一致,则进行密码修改
			if(this.emailMd5Code.equals(phoneSmsMd5Vercode)){
				CustomerContactEntity vo = new CustomerContactEntity();
				vo.setEbccId(Long.parseLong(this.ebccId));
				//密码MD5加密
				vo.setEbccNetPassword(MD5.encode(this.emailPassword));
				//修改密码
				forgotService.modifyCustomerPwdById(vo);
				//查找密码信息，将密码放至session，进行登陆使用
				CustomerContactEntity entity = forgotService.findCustomer(vo);
				ctx.getSession().put(SessionConstants.SESSION_USER_INFO.USER_INFO,entity);
				//设置登陆类型
				ctx.getSession().put(SessionConstants.SESSION_USER_INFO.LOGIN_TYPE,SessionConstants.SESSION_USER_INFO.EMAIL);
				//登录后，修改最后一次登录时间
				userService.modifyCustomerTimeById(entity);
			}else{
				this.errorType = "email";
				setThisErrorMsg("身份验证失败！");
				return "checkError";
			}
		}catch(Exception ex){
			logger.error("ForgotAction modifyUserPwdByEmail error : " + ex.getMessage());
			ex.printStackTrace();
		}
		return "index";
	}
	
	private void setThisErrorMsg(String msg){
		this.errorMsg = "<p class='erro'><span class='icon_del'></span>"+msg+"</p>";
	}
	
	public void setPhone(String phone) {
		this.phone = phone;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPhone() {
		return phone;
	}

	public String getEmail() {
		return email;
	}

	public String getErrorMsg() {
		return errorMsg;
	}
	
	public String getErrorType() {
		return errorType;
	}

	public String getType() {
		return type;
	}

	public void setPhoneCode(String phoneCode) {
		this.phoneCode = phoneCode;
	}

	public void setEmailCode(String emailCode) {
		this.emailCode = emailCode;
	}

	public CustomerContactEntity getEntity() {
		return entity;
	}

	public Long getCountdown() {
		return countdown;
	}

	public void setEbccId(String ebccId) {
		this.ebccId = ebccId;
	}

	public String getEbccId() {
		return ebccId;
	}

	public void setPhonePassword(String phonePassword) {
		this.phonePassword = phonePassword;
	}

	public void setEmailPassword(String emailPassword) {
		this.emailPassword = emailPassword;
	}

	public String getPhoneMd5Code() {
		return phoneMd5Code;
	}

	public String getEmailMd5Code() {
		return emailMd5Code;
	}

	public void setPhoneMd5Code(String phoneMd5Code) {
		this.phoneMd5Code = phoneMd5Code;
	}

	public void setEmailMd5Code(String emailMd5Code) {
		this.emailMd5Code = emailMd5Code;
	}
}