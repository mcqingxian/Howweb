package com.hoau.mhow.module.bse.api.shared.exception;

import com.hoau.hbdp.framework.exception.BusinessException;

/**
 * @author：张爱萍
 * @create：2015年6月5日 下午2:42:43
 * @description：
 */
public class NewsException extends BusinessException{
	/**
	 * 分页参数为空
	 */
	public static final String RB_NULL = "how.bse_api_module.news.RbNullException";
	/**
	 * 查询类目参数为空
	 */
	public static final String CATEGORY_NULL = "how.bse_api_module.news.CATEGORY_NULL";

	/**
	 * 新闻id为空
	 */
	public static final String NEWSID_NULL = "how.bse_api_module.news.NEWSID_NULL";
	/**
	  * 功能异常类定义
	  * @param errCode
	  * @since
	 */
	public NewsException(String errCode){
		super();
		super.errCode = errCode;
	}
	public NewsException(String errCode, Object... para) {
		super(errCode, para);
		super.errCode = errCode;
	}

}
