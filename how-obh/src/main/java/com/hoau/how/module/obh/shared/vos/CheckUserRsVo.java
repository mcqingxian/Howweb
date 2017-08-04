package com.hoau.how.module.obh.shared.vos;

/**
 * @author：莫涛
 * @create：2015年7月22日 下午4:29:52
 * @description：
 */
public class CheckUserRsVo {
	/**
	 * 异常消息
	 */
	private String errorMsg;
	/**
	 * 验证结果
	 */
	private boolean result;
	public boolean isResult() {
		return result;
	}
	public void setResult(boolean result) {
		this.result = result;
	}
	public String getErrorMsg() {
		return errorMsg;
	}
	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}
}
