package com.hoau.wechat.service;

import java.util.Map;

import org.springframework.web.context.WebApplicationContext;

import com.hoau.wechat.vo.LotteryDrawResult;
import com.hoau.wechat.vo.Vouchers;

public interface ICouponService {
	public Map<String, Object> getCouponsByOpenid(String openid, WebApplicationContext act);
	
	public Vouchers gainVouchers(String openid, String type);
	
	public Vouchers getNewVouchers(String openid, String type, String wayBill);
	
	public boolean hasQualificationsGainCoupons(String openid, String type);
	
	public boolean hasWayBillLuckdraw(String openid, String type, String wayBill);
	
	public LotteryDrawResult getLuckDraw(String openid, String type, String wayBill);
}
