package com.hoau.how.module.bse.shared.vo;

/**
 * @author 唐征征
 * @date 2017/7/27 上午8:24
 * @description GIS异常信息dto
 */
public class GisExceptionMsgDto {
	private String pcode;
	private String message;
	private String resultcode;
	public String getPcode() {
		return pcode;
	}
	public void setPcode(String pcode) {
		this.pcode = pcode;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getResultcode() {
		return resultcode;
	}
	public void setResultcode(String resultcode) {
		this.resultcode = resultcode;
	}
}
