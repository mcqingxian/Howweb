package com.hoau.how.module.bse.api.shared.exception;

import com.hoau.hbdp.framework.exception.BusinessException;

/**
* @ClassName: LoginException
* @Description: 登录模块相关异常
* @author HOAU-271755
* @date 2015年4月24日 下午12:45:03
*
*/
public class LoginException extends BusinessException {
	
	private static final long serialVersionUID = -393837315936020112L;
	 public static final String USER_NOT_EXIST = "how.bse_api_module.userNotExist";
	public LoginException(String errCode) {
		super();
		super.errCode = errCode;
	}

	public LoginException(String errCode, Object... para) {
		super(errCode, para);
		super.errCode = errCode;
	}
}
