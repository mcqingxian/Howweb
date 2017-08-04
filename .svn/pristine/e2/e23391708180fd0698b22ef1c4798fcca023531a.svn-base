package com.hoau.wechat.exception;

import java.io.Serializable;

/**
 * 业务异常类
 * 
 * @author gaojia
 * 
 */
public class BusinessException extends RuntimeException implements IException,
		Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -98857410022907304L;
	protected String errCode;
	private String natvieMsg;
	private Object[] arguments;

	public BusinessException() {
		
	}

	public BusinessException(String msg) {
		super(msg);
	}

	public BusinessException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public BusinessException(String code, String msg) {
		super(msg);
		this.errCode = code;
	}

	public BusinessException(String code, String msg, Throwable cause) {
		super(msg, cause);
		this.errCode = code;
	}

	public BusinessException(String code, String msg, String natvieMsg) {
		super(msg);
		this.errCode = code;
		this.natvieMsg = natvieMsg;
	}

	public BusinessException(String code, String msg, String natvieMsg,
			Throwable cause) {
		super(msg, cause);
		this.errCode = code;
		this.natvieMsg = natvieMsg;
	}

	public BusinessException(String code, Object... args) {
		this.errCode = code;
		this.arguments = args;
	}

	public BusinessException(String code, String msg, Object... args) {
		super(msg);
		this.errCode = code;
		this.arguments = args;
	}

	@Override
	public String getErrorCode() {
		// TODO Auto-generated method stub
		return errCode;
	}

	@Override
	public String getNativeMessage() {
		// TODO Auto-generated method stub
		return natvieMsg;
	}

	@Override
	public void setErrorArguments(Object... paramVarArgs) {
		this.arguments = paramVarArgs;

	}

	@Override
	public Object[] getErrorArguments() {
		// TODO Auto-generated method stub
		return this.arguments;
	}

}
