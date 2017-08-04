package com.hoau.wechat.service;

import java.util.List;

import com.hoau.wechat.vo.ActiveInfo;
import com.hoau.wechat.vo.LotteryDrawResult;
import com.hoau.wechat.vo.LotteryRecord;
import com.hoau.wechat.vo.LotteryRecordVo;
import com.hoau.wechat.vo.ShareRecode;
import com.hoau.wechat.vo.Vouchers;


public interface IActivitiesService {
	public LotteryDrawResult getLottery(String openid);
	
	public void saveShareRecord(ShareRecode shareRecode);
	
	public List<LotteryRecordVo> getLotteryRecord();

	public boolean getShareRecord(String openid);

	public List<LotteryRecord> viewLotteryRecord(String openid);
	
	Vouchers getVouchers(String openid,String type);
	
	List<ActiveInfo> getActiveInfos();
	
/*	//关键字匹配
	public List<KeyWord> getKeywords();*/
}
