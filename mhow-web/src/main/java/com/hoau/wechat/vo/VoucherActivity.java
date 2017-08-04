package com.hoau.wechat.vo;

import java.util.Date;

public class VoucherActivity {
	// 唯一标示
	private int id;
	// 奖券名称
	private String vouchersName;
	// 奖券状态是否被抽中（0 未使用 1已使用）
	private int status;
	// 抵用券编码
	private String vouchersCode;
	// 奖券类型
	private String type;
	// 是否被使用
	private int expiry;
	// 中奖用户
	private String openid;
	//修改时间
	private Date modifyTime;

	public Date getModifyTime() {
		return modifyTime;
	}

	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}

	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getVouchersName() {
		return vouchersName;
	}

	public void setVouchersName(String vouchersName) {
		this.vouchersName = vouchersName;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getVouchersCode() {
		return vouchersCode;
	}

	public void setVouchersCode(String vouchersCode) {
		this.vouchersCode = vouchersCode;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getExpiry() {
		return expiry;
	}

	public void setExpiry(int expiry) {
		this.expiry = expiry;
	}

}
