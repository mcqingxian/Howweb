package com.hoau.how.module.bse.api.shared.exception;

import com.hoau.hbdp.framework.exception.BusinessException;

/**
 * @author：张爱萍
 * @create：2015年6月17日 下午3:19:38
 * @description：
 */
public class BigEventException extends BusinessException{
	
	public static final String BIGEVENT_YEARESNULL_EXCEPTION = "how.bse_api_module.bigevent.BIGEVENT_YEARESNULL_EXCEPTION";

	/**
	  * 功能异常类定义
	  * @param errCode
	  * @since
	 */
	public BigEventException(String errCode){
		super();
		super.errCode = errCode;
	}
	public BigEventException(String errCode, Object... para) {
		super(errCode, para);
		super.errCode = errCode;
	}

}
