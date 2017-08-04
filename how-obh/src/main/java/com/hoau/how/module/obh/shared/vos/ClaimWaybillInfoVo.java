package com.hoau.how.module.obh.shared.vos;

public class ClaimWaybillInfoVo {
	/**
	 * 运单号
	 */
	private String waybillNo;
	/**
	 * 理赔方
	 */
	private String claimParty;
	/**
	 * 收货理赔公司所在地
	 */
	private String shipperCalimCompany;
	/**
	 * 发货理赔公司所在地
	 */
	private String consigneeCalimCompany;
	/**
	 * 件数
	 */
	private int pieces;
	
	/**
	 * 电话号码
	 */
	private String phoneNo;
	
	
	public String getShipperCalimCompany() {
		return shipperCalimCompany;
	}
	public void setShipperCalimCompany(String shipperCalimCompany) {
		this.shipperCalimCompany = shipperCalimCompany;
	}
	public String getConsigneeCalimCompany() {
		return consigneeCalimCompany;
	}
	public void setConsigneeCalimCompany(String consigneeCalimCompany) {
		this.consigneeCalimCompany = consigneeCalimCompany;
	}
	public int getPieces() {
		return pieces;
	}
	public void setPieces(int pieces) {
		this.pieces = pieces;
	}
	public String getClaimParty() {
		return claimParty;
	}
	public void setClaimParty(String claimParty) {
		this.claimParty = claimParty;
	}
	
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	public String getWaybillNo() {
		return waybillNo;
	}
	public void setWaybillNo(String waybillNo) {
		this.waybillNo = waybillNo;
	}
	
}
