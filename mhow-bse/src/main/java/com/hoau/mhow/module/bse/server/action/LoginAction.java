package com.hoau.mhow.module.bse.server.action;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.hoau.hbdp.framework.server.web.action.AbstractAction;
import com.hoau.hbdp.framework.shared.util.string.StringUtil;
import com.hoau.mhow.module.bse.api.server.service.IBseOperationLogService;
import com.hoau.mhow.module.bse.api.server.service.IContactsService;
import com.hoau.mhow.module.bse.api.server.service.IForgotService;
import com.hoau.mhow.module.bse.api.server.service.IUserService;
import com.hoau.mhow.module.bse.api.shared.domain.CustomerContactEntity;
import com.hoau.wechat.constants.SessionConstants;
import com.hoau.wechat.md5.MD5;
import com.opensymphony.xwork2.ActionContext;

/**
 * @author Dy
 * 2015年12月8日
 */
@Controller
@Scope("prototype")
public class LoginAction extends AbstractAction {

	private static final long serialVersionUID = 1729069902855129814L;
	
	private Logger logger = Logger.getLogger(LoginAction.class);
	
	public String login(){
		ActionContext ctx = ActionContext.getContext();
		Object userInfoObj = ctx.getSession().get(SessionConstants.SESSION_USER_INFO.USER_INFO);
		if(userInfoObj!=null){
			dest="index.action";
			return "index";
		}
		return returnSuccess();
	}
	
	public String loginAfter(){
		return returnSuccess();
	}
	
	@Resource
	IForgotService forgotService;
	@Resource
	IUserService userService;
	@Resource
	IBseOperationLogService bseOperationLogService;
	@Resource
	IContactsService contactsService;
	
	CustomerContactEntity entity;
	private String loginName;
	private String password;
	private String errorType;
	private String errorMsg;
	/**
	 * 验证码
	 */
	private String verCode;
	
	//登陆成功后 所要跳转的目标页面
	private String dest;
	
	public String userLogin(){
		try{
			// 从Session中获取验证码
			ActionContext ctx = ActionContext.getContext();
			if(loginName == null || loginName.equals("")){
				this.errorType = "loginName";
				this.errorMsg = "登陆账号不能为空！";
			   	return "loginError";
			}else if(password == null || password.equals("")){
				this.errorType = "password";
				this.errorMsg = "登陆密码不能为空！";
				return "loginError";
			}else {
				if(StringUtil.isEmpty(verCode)){
					this.errorType = "password";
					this.errorMsg = "验证码不能为空！";
					return "loginError";
				}
				String sessionCode = (String)ctx.getSession().get(SessionConstants.SESSION_VERCODE_KEYS.LOGIN_VERCODE);
				if(StringUtil.isEmpty(sessionCode)){
					this.errorType = "password";
					this.errorMsg = "请先获取验证码！";
					return "loginError";
				}
				if(!verCode.equals(sessionCode)){
					this.errorType = "password";
					this.errorMsg = "请输入正确的验证码！";
					return "loginError";
				}
				ctx.getSession().put(SessionConstants.SESSION_VERCODE_KEYS.LOGIN_VERCODE, null);
			}
			String pwd = MD5.encode(this.password);
			CustomerContactEntity entity = new CustomerContactEntity();
			entity.setEbccMobile(loginName);
			entity.setEbccNetPassword(pwd);
			CustomerContactEntity po = forgotService.findCustomer(entity);
			String loginType = null;
			if(po == null){
				entity.setEbccEmail(loginName);
				entity.setEbccMobile(null);
				po = forgotService.findCustomer(entity);
				if(po == null){
					entity.setEbccNetLogin(loginName);
					entity.setEbccEmail(null);
					po = forgotService.findCustomer(entity);
					if(po == null){
						this.errorType = "loginName";
						this.errorMsg = "账号或密码错误！";
						//dest = "";
						return "loginError";
					}else{
						loginType = SessionConstants.SESSION_USER_INFO.USERNAME;
					}
				}else{
					loginType = SessionConstants.SESSION_USER_INFO.EMAIL;
				}
			}else{
				loginType = SessionConstants.SESSION_USER_INFO.PHONE;
			}
			ctx.getSession().put(SessionConstants.SESSION_USER_INFO.USER_INFO,po);
			//设置登陆类型
			ctx.getSession().put(SessionConstants.SESSION_USER_INFO.LOGIN_TYPE,loginType);
			bseOperationLogService.insert(po, 1);
			userService.modifyCustomerTimeById(po);
		}catch(Exception ex){
			logger.error("LoginAction login error : " + ex.getMessage());
			this.errorMsg = "登录失败";
			ex.printStackTrace();
			//dest = "";
			return "loginError";
		}
		//dest = (dest == null?"index.action":dest);
		return "index";
	}
	
	public String loginJson(){
		try{
			if(loginName == null || loginName.equals("")){
				this.errorMsg = "<p class='erro'><span class='icon_del'></span>登陆账号不能为空！</p>";
			   	return "loginJson";
			}else if(password == null || password.equals("")){
				this.errorMsg = "<p class='erro'><span class='icon_del'></span>登陆密码不能为空！</p>";
				return "loginJson";
			}
			ActionContext ctx = ActionContext.getContext();
			String pwd = MD5.encode(this.password);
			CustomerContactEntity entity = new CustomerContactEntity();
			entity.setEbccMobile(loginName);
			entity.setEbccNetPassword(pwd);
			CustomerContactEntity po = forgotService.findCustomer(entity);
			String loginType = null;
			if(po == null){
				entity.setEbccEmail(loginName);
				entity.setEbccMobile(null);
				po = forgotService.findCustomer(entity);
				if(po == null){
					entity.setEbccNetLogin(loginName);
					entity.setEbccEmail(null);
					po = forgotService.findCustomer(entity);
					if(po == null){
						this.errorMsg = "<p class='erro'><span class='icon_del'></span>账号或密码错误！ </p>";
						return "loginJson";
					}else{
						loginType = SessionConstants.SESSION_USER_INFO.USERNAME;
					}
				}else{
					loginType = SessionConstants.SESSION_USER_INFO.EMAIL;
				}
			}else{
				loginType = SessionConstants.SESSION_USER_INFO.PHONE;
			}
			this.errorType = "success";
			ctx.getSession().put(SessionConstants.SESSION_USER_INFO.USER_INFO,po);
			//设置登陆类型
			ctx.getSession().put(SessionConstants.SESSION_USER_INFO.LOGIN_TYPE,loginType);
			this.entity = po;
			userService.modifyCustomerTimeById(po);
		}catch(Exception ex){
			logger.error("LoginAction login error : " + ex.getMessage());
			ex.printStackTrace();
		}
		return "loginJson";
	}
	
	/**
	 * 退出
	 * 2015年12月11日
	 * @author Dy
	 */
	public String exit(){
		try{
			ActionContext ctx = ActionContext.getContext();
			ctx.getSession().put(SessionConstants.SESSION_USER_INFO.USER_INFO,null);
			//设置登陆类型
			ctx.getSession().put(SessionConstants.SESSION_USER_INFO.LOGIN_TYPE,null);
			//退出到首页
			dest = "index.action";
		}catch(Exception ex){
			logger.error("LoginAction login error : " + ex.getMessage());
			ex.printStackTrace();
		}
		return "exit";
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getLoginName() {
		return loginName;
	}

	public String getErrorType() {
		return errorType;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public String getDest() {
		return dest;
	}

	public void setDest(String dest) {
		this.dest = dest;
	}

	public CustomerContactEntity getEntity() {
		return entity;
	}

	public String getVerCode() {
		return verCode;
	}

	public void setVerCode(String verCode) {
		this.verCode = verCode;
	}
}
