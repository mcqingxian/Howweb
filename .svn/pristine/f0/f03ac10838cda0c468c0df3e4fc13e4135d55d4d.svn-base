package com.hoau.wechat.dao;

import java.util.List;

import com.hoau.wechat.vo.ActiveInfo;
import com.hoau.wechat.vo.LotteryRecord;
import com.hoau.wechat.vo.ShareRecode;
import com.hoau.wechat.vo.Vouchers;

public interface IActivitiesDao {

	public Vouchers useLotteryTicket(String type); 
	
	public void updateStatus(int vouchersId);
	
	public void addLotteryRecord(LotteryRecord lotteryRecord);
	
	public void addShareRecord(ShareRecode shareRecode);
	
	public boolean isBind(String openid);

	public List<LotteryRecord> getLotteryRecord(String openid,boolean con);

	public ShareRecode getShareRecord(String openid);

	public List<LotteryRecord> latestLotteryRecord();

	public String getUserPhoneNo(String openId);
	
	public List<LotteryRecord> getLotteryRecord(String openid,String type);
	
	public List<ActiveInfo> getActiveInfos();
}
