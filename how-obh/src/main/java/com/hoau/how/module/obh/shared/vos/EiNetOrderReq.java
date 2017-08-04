package com.hoau.how.module.obh.shared.vos;

import java.io.Serializable;

public class EiNetOrderReq implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 返回是否正确
	 */
	private Boolean result;
	/**
	 * 错误码目前为空
	 */
	private String resultCode;
	/**
	 * 返回结果，成功为空
	 */
	private String resultInfo;
	
	public Boolean getResult() {
		return result;
	}
	public void setResult(Boolean result) {
		this.result = result;
	}
	public String getResultCode() {
		return resultCode;
	}
	public void setResultCode(String resultCode) {
		this.resultCode = resultCode;
	}
	public String getResultInfo() {
		return resultInfo;
	}
	public void setResultInfo(String resultInfo) {
		this.resultInfo = resultInfo;
	}

}
