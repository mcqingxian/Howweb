package com.hoau.how.module.bse.shared.vo;

import java.io.Serializable;

public class BaiduMapDriverDistanceResult implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4823052868632566104L;
	
	private String status;
	private String message;
	private DriverDistanceResult result;
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public DriverDistanceResult getResult() {
		return result;
	}
	public void setResult(DriverDistanceResult result) {
		this.result = result;
	}
	

}
