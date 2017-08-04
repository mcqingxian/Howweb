package com.hoau.how.module.bse.shared.vo;

public class OldExcelDataVo {
	/**
	 * @Fields destinationAddress: 目的地地址
	 */
	private String destinationAddress;
	/**
	 * @Fields pcode: 目的地地址唯一标识
	 */
	private String pcode;
	
	public String getPcode() {
		return pcode;
	}
	public void setPcode(String pcode) {
		this.pcode = pcode;
	}
	public String getDestinationAddress() {
		return destinationAddress;
	}
	public void setDestinationAddress(String destinationAddress) {
		this.destinationAddress = destinationAddress;
	}
}
