package com.hoau.mhow.module.bse.server.action;

import java.io.IOException;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.hoau.hbdp.framework.server.web.action.AbstractAction;
import com.hoau.mhow.invokews.server.ws.sms.impl.SMS;
import com.hoau.mhow.module.bse.api.server.service.IBseOperationLogService;
import com.hoau.mhow.module.bse.api.server.service.IForgotService;
import com.hoau.mhow.module.bse.api.server.service.IUserService;
import com.hoau.mhow.module.bse.api.shared.domain.CustomerContactEntity;
import com.hoau.mhow.module.bse.api.shared.vo.CheckUserRsVo;
import com.hoau.wechat.constants.SessionConstants;
import com.hoau.wechat.md5.MD5;
import com.hoau.wechat.util.DateUtils;
import com.hoau.wechat.util.Utils;
import com.opensymphony.xwork2.ActionContext;

/**
 *
 * @author 莫涛
 * @date 2015年7月20日
 */
@Controller
@Scope("prototype")
public class RegistAction extends AbstractAction{
	/**
	 *
	 */
	private static final long serialVersionUID = 9125540121651748362L;
	private Logger logger = Logger.getLogger(RegistAction.class);
	private static final Long COUNT_DOWN = 60L;
	@Resource
	IForgotService forgotService;
	@Resource
	IUserService userService;
	@Resource
	IBseOperationLogService iBseOperationLogService;
	private CustomerContactEntity entity;
	private String registVerCode;
	private String loginName;
	private String mobile;
	private String email;
	/**
	 * 倒计时
	 */
	Long countdown;
	private String errorType;
	private String errorMsg;
	private Integer total;
	
	public String regist(){
		String rs = "";
		try{
			this.total = 1;
			if(this.entity != null){
				this.entity.setEbccMobile(mobile);
				this.entity.setEbccNetLogin(loginName);
				this.entity.setEbccEmail(email);
			}
			rs = checkPhoneJson();
			if(rs.equals("registErrorJson")){
				return "registError";
			}
			rs = checkEmailJson();
			if(rs.equals("registErrorJson")){
				return "registError";
			}
			rs = checkUserNameJson();
			if(rs.equals("registErrorJson")){
				return "registError";
			}
			
			if(this.entity.getEbccNetPassword() == null || this.entity.getEbccNetPassword().equals("")){
				this.errorType = "password";
				setThisErrorMsg("密码不能为空！");
				return "registError";
			}else if(this.entity.getEbccNetPassword().length() > 16 || this.entity.getEbccNetPassword().length() < 6){
				this.errorType = "password";
				//密码长度为6到16位
				setThisErrorMsg("密码长度应在6-16位！");
				return "registError";
			}
			
			ActionContext ctx = ActionContext.getContext();
			Object obj = ctx.getSession().get(SessionConstants.SESSION_REGIST_VERCODE_KEYS.PHONE_REGIST_SMS_VERCODE);
			String registSmsVerCode = null;
			if(obj == null){
				this.errorType = "verCode";
				setThisErrorMsg("请先获取短信验证码！ ");
				return "registError";
			}else{
				registSmsVerCode = obj.toString();
			}
			if(this.registVerCode == null || this.registVerCode.equals("")){
				this.errorType = "verCode";
				setThisErrorMsg("短信验证码不能为空！ ");
				return "registError";
			}else if(this.registVerCode.equals(registSmsVerCode)){
				//验证通过，注册
				String pwd = MD5.encode(this.entity.getEbccNetPassword());
				this.entity.setEbccNetPassword(pwd);
				userService.insertCustomer(this.entity);
				this.entity = forgotService.findCustomer(entity);
				ctx.getSession().put(SessionConstants.SESSION_USER_INFO.USER_INFO, this.entity);
				ctx.getSession().put(SessionConstants.SESSION_USER_INFO.LOGIN_TYPE, SessionConstants.SESSION_USER_INFO.PHONE);
			}else{
				this.errorType = "verCode";
				setThisErrorMsg("短信验证码填写错误！");
				return "registError";
			}
		}catch(Exception ex){
			logger.error("RegistAction regist error : " + ex.getMessage());
			ex.printStackTrace();
			return "registError";
		}
		return "index";
	}
	
	public String registJson(){
		String rs = "";
		String returnRs = "registJson";
		try{
			this.total = 1;
			rs = checkPhoneJson();
			if(rs.equals("registErrorJson")){
				return returnRs;
			}
			rs = checkEmailJson();
			if(rs.equals("registErrorJson")){
				return returnRs;
			}
			rs = checkUserNameJson();
			if(rs.equals("registErrorJson")){
				return returnRs;
			}
			
			if(this.entity.getEbccNetPassword() == null || this.entity.getEbccNetPassword().equals("")){
				setThisErrorMsg("密码不能为空！");
				return returnRs;
			}else if(this.entity.getEbccNetPassword().length() > 16 || this.entity.getEbccNetPassword().length() < 6){
				//密码长度为6到16位
				setThisErrorMsg("密码长度应在6-16位！");
				return returnRs;
			}
			
			ActionContext ctx = ActionContext.getContext();
			Object obj = ctx.getSession().get(SessionConstants.SESSION_REGIST_VERCODE_KEYS.PHONE_REGIST_SMS_VERCODE);
			String registSmsVerCode = null;
			if(obj == null){
				setThisErrorMsg("请先获取验证码！ ");
				return returnRs;
			}else{
				registSmsVerCode = obj.toString();
			}
			if(this.registVerCode == null || this.registVerCode.equals("")){
				setThisErrorMsg("短信验证码不能为空！ ");
				return returnRs;
			}else if(this.registVerCode.equals(registSmsVerCode)){
				//验证通过，注册
				String pwd = MD5.encode(this.entity.getEbccNetPassword());
				this.entity.setEbccNetPassword(pwd);
				userService.insertCustomer(this.entity);
				this.entity = forgotService.findCustomer(entity);
				ctx.getSession().put(SessionConstants.SESSION_USER_INFO.USER_INFO, this.entity);
				ctx.getSession().put(SessionConstants.SESSION_USER_INFO.LOGIN_TYPE, SessionConstants.SESSION_USER_INFO.PHONE);
				iBseOperationLogService.insert(this.entity, 0);
				this.errorType = "success";
				this.errorMsg = "注册成功！";
			}else{
				setThisErrorMsg("短信验证码填写错误！");
				return returnRs;
			}
		}catch(Exception ex){
			logger.error("RegistAction regist error : " + ex.getMessage());
			ex.printStackTrace();
			return returnRs;
		}
		return returnRs;
	}
	
	/**
	 * 发送手机验证码
	 * @return
	 * @author 莫涛
	 * @date 2015年7月17日
	 * @update
	 */
	public String sendNewPhoneVerCodeJson(){
		try{
			String rs = checkPhoneJson();
			//验证下，该手机是否已经注册过，注册过，则直接不发送了。
			if(rs.equals("registErrorJson")){
				return "sendPhoneVerCodeJson";
			}
			this.errorMsg = "";
			this.errorType = "";
			// 从Session中获取验证码
			ActionContext ctx = ActionContext.getContext();
			Object obj = ctx.getSession().get(SessionConstants.SESSION_REGIST_VERCODE_KEYS.PHONE_REGIST_VERCODE_SEND_TIME);
			boolean sendMsg = false;
			if(obj == null){
				//倒计时为60秒
				this.countdown = COUNT_DOWN;
				//将第一次获取验证码时间保存
				ctx.getSession().put(SessionConstants.SESSION_REGIST_VERCODE_KEYS.PHONE_REGIST_VERCODE_SEND_TIME,DateUtils.getCurTimeMillis());
				sendMsg = true;
			}else{
				//第一次获取验证码时间
				Long phoneVercodeSendTime = Long.parseLong(obj.toString());
				//当前时间
				Long curDate = DateUtils.getCurTimeMillis();
				this.countdown = (curDate - phoneVercodeSendTime) / 1000;
				this.countdown = COUNT_DOWN - this.countdown;
				//超过60秒后，可重新发送,并且清空session
				if(this.countdown <= 0){
					sendMsg = true;
					this.countdown = COUNT_DOWN;
					ctx.getSession().put(SessionConstants.SESSION_REGIST_VERCODE_KEYS.PHONE_REGIST_VERCODE_SEND_TIME,DateUtils.getCurTimeMillis());
				}else{
					this.errorMsg = "请在"+this.countdown+"秒后进行操作！";
				}
			}
			if(sendMsg && this.entity != null && this.entity.getEbccMobile() != null && !this.entity.getEbccMobile().equals("")){
				//前台验证码
				String sessionCode = (String)ctx.getSession().get(SessionConstants.SESSION_VERCODE_KEYS.USER_REGIST_VERCODE);
				if(this.registVerCode == null || this.registVerCode.equals("") || !this.registVerCode.equalsIgnoreCase(sessionCode)){
					this.errorType = "verCodeError";
					this.setThisErrorMsg("请填写正确验证码！");
				}else{
					String phoneSmsVercode = Utils.randomNum(6);
					SMS sms = new SMS(this.entity.getEbccMobile(), "您本次注册验证码为："+phoneSmsVercode+"，请您在30分钟内完成验证，如有疑问请致电：400-808-6666");
					forgotService.sendSms(sms);
					//将手机验证码保存至session
					ctx.getSession().put(SessionConstants.SESSION_REGIST_VERCODE_KEYS.PHONE_REGIST_SMS_VERCODE, phoneSmsVercode);
					ctx.getSession().put(SessionConstants.SESSION_REGIST_VERCODE_KEYS.PHONE_REGIST_PHONE, this.entity.getEbccMobile());
					ctx.getSession().put(SessionConstants.SESSION_VERCODE_KEYS.USER_REGIST_VERCODE, null);
					//this.setThisSuccessMsg("短信已发送，请注意查收！");
				}
			}
		}catch(Exception ex){
			ex.printStackTrace();
			logger.error("RegistAction sendPhoneVerCodeJson error : " + ex.getMessage());
		}
		logger.info("手机号："+this.entity.getEbccMobile() + "，验证码发送结果：" + this.getErrorMsg());
		return "sendPhoneVerCodeJson";
	}
	
	public String registCodeCheck() throws IOException {
		ActionContext ctx = ActionContext.getContext();
		String sessionCode = (String)ctx.getSession().get(SessionConstants.SESSION_VERCODE_KEYS.USER_REGIST_VERCODE);
		if(this.registVerCode.equalsIgnoreCase(sessionCode)){
			return returnSuccess();
		}else{
			return returnError("验证码输入有误");
		}
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
			Object obj = ctx.getSession().get(SessionConstants.SESSION_REGIST_VERCODE_KEYS.PHONE_REGIST_VERCODE_SEND_TIME);
			if(obj != null){
				//第一次获取验证码时间
				Long phoneVercodeSendTime = Long.parseLong(obj.toString());
				//当前时间
				Long curDate = DateUtils.getCurTimeMillis();
				this.countdown = (curDate - phoneVercodeSendTime) / 1000;
				this.countdown = COUNT_DOWN - this.countdown;
				//超过60秒后，可重新发送,并且清空session
				if(this.countdown <= 0){
					ctx.getSession().put(SessionConstants.SESSION_REGIST_VERCODE_KEYS.PHONE_REGIST_VERCODE_SEND_TIME,null);
				}else{
					this.errorMsg = "请在"+this.countdown+"秒后进行操作！";
				}
			}
		}catch(Exception ex){
			ex.printStackTrace();
			logger.error("RegistAction checkCountDownPhoneJson error : " + ex.getMessage());
		}
		return "checkCountDownPhoneJson";
	}
	
	/**
	 * 
	 * @author 莫涛
	 * @date 2015年7月20日
	 * @update
	 */
	public String checkPhoneJson(){
		try{
			this.errorType = "phone";
			CheckUserRsVo vo = userService.checkPhoneJson(entity.getEbccMobile(), total);
			this.errorMsg = vo.getErrorMsg();
			if(!vo.isResult()){
				return "registErrorJson";
			}
		}catch(Exception ex){
			logger.error("RegistAction checkPhone error : " + ex.getMessage());
			ex.printStackTrace();
		}
		return "checkPhoneJson";
	}
	
	/**
	 * 
	 * @return
	 * @author 莫涛
	 * @date 2015年7月22日
	 * @update
	 */
	public String checkEmailJson(){
		try{
			this.errorType = "email";
			CheckUserRsVo vo = userService.checkEmailJson(entity.getEbccEmail(), total);
			this.errorMsg = vo.getErrorMsg();
			if(!vo.isResult()){
				return "registErrorJson";
			}
		}catch(Exception ex){
			logger.error("RegistAction checkEmail error : " + ex.getMessage());
			ex.printStackTrace();
		}
		return "checkEmailJson";
	}
	
	/**
	 * 
	 * @return
	 * @author 莫涛
	 * @date 2015年7月22日
	 * @update
	 */
	public String checkUserNameJson(){
		try{
			this.errorType = "userName";
			CheckUserRsVo vo = userService.checkUserNameJson(entity.getEbccNetLogin(), total);
			this.errorMsg = vo.getErrorMsg();
			if(!vo.isResult()){
				return "registErrorJson";
			}
		}catch(Exception ex){
			logger.error("RegistAction checkUserName error : " + ex.getMessage());
			ex.printStackTrace();
		}
		return "checkUserNameJson";
	}
	
	private void setThisErrorMsg(String msg){
		this.errorMsg = "<p class='erro'><span class='icon_del'></span>"+msg+"</p>";
	}
	
	private void setThisSuccessMsg(String msg){
		this.errorMsg = "<p class='succ'><span class='icon_succ'></span>"+msg+"</p>";
	}
	
	public void setRegistVerCode(String registVerCode) {
		this.registVerCode = registVerCode;
	}

	public String getErrorType() {
		return errorType;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setEntity(CustomerContactEntity entity) {
		this.entity = entity;
	}
	
	public Long getCountdown() {
		return countdown;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public CustomerContactEntity getEntity() {
		return entity;
	}
}
