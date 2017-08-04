package com.hoau.how.module.bse.api.shared.exception;

import com.hoau.hbdp.framework.exception.BusinessException;

/**
 * @author：张爱萍
 * @create：2015年6月10日 上午10:04:52
 * @description：
 */
public class FranchiseException extends BusinessException{
	

	public static final String FRANCHISE_PIDNULLXCEPTION = "how.bse_api_module.franchise.FRANCHISE_PIDNULLXCEPTION";
	public static final String FRANCHISE_REGISTINFONULLEXCEPTION = "how.bse_api_module.franchise.FRANCHISE_REGISTINFONULLEXCEPTION";
	/**
	  * 功能异常类定义
	  * @param errCode
	  * @since
	 */
	public FranchiseException(String errCode){
		super();
		super.errCode = errCode;
	}
	public FranchiseException(String errCode, Object... para) {
		super(errCode, para);
		super.errCode = errCode;
	}

}
