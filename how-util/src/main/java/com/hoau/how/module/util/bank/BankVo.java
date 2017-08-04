package com.hoau.how.module.util.bank;

/**
 * 借记卡VO
 * @author：莫涛
 * @create：2016年2月25日 下午3:33:52
 * @description：
 */
public class BankVo {
	String status;
	BankDataVo data;
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public BankDataVo getData() {
		return data;
	}
	public void setData(BankDataVo data) {
		this.data = data;
	}
}
