package com.hoau.how.module.obh.shared.exception;

import com.hoau.hbdp.framework.exception.BusinessException;

/**
 *
 * @author 徐俊
 * @date 2015年7月22日
 */
public class OBHException extends BusinessException {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 联系人实体为空
	 */
	public static final String ADD_CONTACTS_NULL = "obh.contacts.addContactsNullException";
	
	/**
	 * 未登陆
	 */
	public static final String NOT_LOGIN = "obh.contacts.notLoginException";
	
	public OBHException(String code, String msg, Throwable cause) {
    	super(code, msg, cause);
    }

    public OBHException(String code, String msg) {
    	super(code, msg);
    }

    public OBHException(String errCode) {
		super();
		super.errCode = errCode;
	}
}
