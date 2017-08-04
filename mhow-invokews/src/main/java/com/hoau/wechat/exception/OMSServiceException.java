package com.hoau.wechat.exception;

public class OMSServiceException extends BusinessException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6060285315764278530L;

	public OMSServiceException() {

	}

	public OMSServiceException(String msg) {
		super(msg);
	}

	public OMSServiceException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public OMSServiceException(String code, String msg) {
		super(code, msg);
	}

	public OMSServiceException(String code, String msg, Throwable cause) {
		super(code, msg, cause);
	}

	public OMSServiceException(String code, String msg, String natvieMsg) {
		super(code, msg, natvieMsg);
	}

	public OMSServiceException(String code, String msg, String natvieMsg,
			Throwable cause) {
		super(code, msg, natvieMsg, cause);
	}

	public OMSServiceException(String code, Object... args) {
		super(code, args);
	}

	public OMSServiceException(String code, String msg, Object... args) {
		super(code, msg, args);
	}

}
