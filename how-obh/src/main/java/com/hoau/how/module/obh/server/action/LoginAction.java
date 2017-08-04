package com.hoau.how.module.obh.server.action;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.hoau.hbdp.framework.server.web.action.AbstractAction;
import com.hoau.how.module.common.constants.SessionConstants;
import com.hoau.how.module.obh.server.service.IForgotService;
import com.hoau.how.module.obh.server.service.IUserService;
import com.hoau.how.module.obh.shared.domain.CustomerContactEntity;
import com.hoau.how.module.util.md5.MD5;
import com.opensymphony.xwork2.ActionContext;

/**
 * @author：张爱萍
 * @create：2015年6月8日 上午11:30:07
 * @description：
 */
@Controller
@Scope("prototype")
public class LoginAction extends AbstractAction{
	/**
	 *
	 */
	private static final long serialVersionUID = 1014071648654361553L;
	private Logger logger = Logger.getLogger(ForgotAction.class);
	@Resource
	IForgotService forgotService;
	@Resource
	IUserService userService;
	CustomerContactEntity entity;
	private String loginName;
	private String password;
	private String errorType;
	private String errorMsg;
	
	//登陆成功后 所要跳转的目标页面
	private String dest;
	public String login(){
		try{
			if(loginName == null || loginName.equals("")){
				this.errorType = "loginName";
				this.errorMsg = "<p class='erro'><span class='icon_del'></span>登陆账号不能为空！</p>";
			   	return "loginError";
			}else if(password == null || password.equals("")){
				this.errorType = "password";
				this.errorMsg = "<p class='erro'><span class='icon_del'></span>登陆密码不能为空！</p>";
				return "loginError";
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
						this.errorType = "loginName";
						this.errorMsg = "<p class='erro'><span class='icon_del'></span>账号或密码错误！ </p>";
						dest = "";
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
			userService.modifyCustomerTimeById(po);
		}catch(Exception ex){
			logger.error("LoginAction login error : " + ex.getMessage());
			ex.printStackTrace();
			dest = "";
			return "loginError";
		}
		dest = (dest == null?"index.action":dest);
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
		return "index";
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
}
