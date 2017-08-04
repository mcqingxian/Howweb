package com.hoau.wechat.service;

import java.util.List;
import java.util.Map;

import com.hoau.wechat.vo.CompusActivityInfo;
import com.hoau.wechat.vo.LotteryActivityDraw;
import com.hoau.wechat.vo.ShareRecode;
import com.hoau.wechat.vo.VoucherActivity;

/**
* @ClassName: ICompusActivityService
* @Description:
* @author hairen.long@hoau.net
* @date 2015年6月5日 下午3:07:27
*/
public interface ICompusActivityService {
	
	//校园转发文章活动
	public void saveSharedRecord(ShareRecode shareRecode);
	
	//校园托运活动
	
	public String gainCompetitionCode(Map<String, String> inputParams);
	
	public String statisticsActivityCode(Map<String, String> inputParams);
	
	public Map<String, Object> hasQualificationsCount(String openid);
	
	public void updateActivityInfoStatus(String code);
	
	public LotteryActivityDraw gainDrawResult(String openid, String city);
	
	public VoucherActivity findActivityInfo(String openid);
	
	public List<CompusActivityInfo> findLastRecord();
	
	public void updateActivityTicket(Map<String, String> inputParams);
}
