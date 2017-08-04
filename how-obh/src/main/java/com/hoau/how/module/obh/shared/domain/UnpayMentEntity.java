package com.hoau.how.module.obh.shared.domain;

public class UnpayMentEntity {

	//收款人姓名
	private String payeeName;
	
	//收款人账号
	private String payeeAccount;
	
	//收款人银行
	private String bank;
	
	//支行信息编码
	private String branchMessageCode;
	//支行信息名称
	private String branchMessageName;
		
	//用于存放eb_shipper_address表返回的主键
	private String ebuEbsaId;

	//用于存放eb_shippper_unpay表被修改的数据的主键
	private String oldEsuId;
	
	//省市区
	private String district;
	
	//省份
	private String province;
	//市区
	private String city;
	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getEbuEbsaId() {
		return ebuEbsaId;
	}

	public void setEbuEbsaId(String ebuEbsaId) {
		this.ebuEbsaId = ebuEbsaId;
	}

	public String getPayeeName() {
		return payeeName;
	}

	public void setPayeeName(String payeeName) {
		this.payeeName = payeeName;
	}

	public String getPayeeAccount() {
		return payeeAccount;
	}

	public void setPayeeAccount(String payeeAccount) {
		this.payeeAccount = payeeAccount;
	}

	public String getBank() {
		return bank;
	}

	public void setBank(String bank) {
		this.bank = bank;
	}

	public String getOldEsuId() {
		return oldEsuId;
	}

	public void setOldEsuId(String oldEsuId) {
		this.oldEsuId = oldEsuId;
	}

	public String getBranchMessageCode() {
		return branchMessageCode;
	}

	public void setBranchMessageCode(String branchMessageCode) {
		this.branchMessageCode = branchMessageCode;
	}

	public String getBranchMessageName() {
		return branchMessageName;
	}

	public void setBranchMessageName(String branchMessageName) {
		this.branchMessageName = branchMessageName;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}
}