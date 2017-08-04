package com.hoau.wechat.service;

import com.hoau.wechat.vo.Vouchers;

public interface ILotteryService {
	
	public Vouchers gainVouchers(String openid, String type, String phone, String versionNo);
	
	public Vouchers LuckDraw(String openid, String type, String versionNo);
	
}
