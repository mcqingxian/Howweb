package com.hoau.how.module.bse.shared.exception;

import com.hoau.hbdp.framework.exception.BusinessException;

public class GoodsTraceException extends BusinessException {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	
	public static final String TRACE_INFO_NULL = "how.goodstrace.TraceInfoNullException";

	public GoodsTraceException(String code, String msg, Throwable cause) {
		super(code, msg, cause);
	}

	public GoodsTraceException(String code, String msg) {
		super(code, msg);
	}

	public GoodsTraceException(String errCode) {
		super();
		super.errCode = errCode;
	}
}
