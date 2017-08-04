package com.hoau.wechat.dao;

import java.util.List;

import com.hoau.wechat.vo.CompusActivityCode;
import com.hoau.wechat.vo.CompusActivityInfo;
import com.hoau.wechat.vo.LotteryRecord;
import com.hoau.wechat.vo.ShareRecode;
import com.hoau.wechat.vo.VoucherActivity;

public interface ILotteryRecordDao {
	//校园托运转发文章
	public void saveSharedRecord(ShareRecode shareRecode);
	
	//京东家装节活动
	public List<LotteryRecord> queryLotteryRecord(String openid, String type, String phone);
	
	public LotteryRecord findLotterByVersonNo(String openid, String type, String versionNo);
	
	//优惠券
	public List<LotteryRecord> getLotteryRecord(String openid,String type);
	
	public void saveLotteryRecord(LotteryRecord lotteryRecord);
	
	public void updateLotteryRecord(LotteryRecord lotteryRecord);
	
	//二十周年抽奖活动
	public LotteryRecord findLotteryRecord(String openid, String type, String wayBill);
	
	//校园托运活动
	/**
	 * @Title: hasQualificationsToday
	 * @Description:当天是否还有获取幸运号的机会
	 * @param openid
	 * @return
	 */
	public boolean hasQualificationsToday(String openid);
	
	/**
	 * @Title: gainCompetitionCode
	 * @Description:获得幸运号
	 * @return
	 */
	public CompusActivityCode gainCompetitionCode();
	
	/**
	 * @Title: saveActivityInfo
	 * @Description:保存获取幸运号记录
	 * @param info
	 */
	public void saveActivityInfo(CompusActivityInfo info);
	
	/**
	 * @Title: updateActivityCodeStatus
	 * @Description:更新幸运号状态
	 * @param code
	 */
	public void updateActivityCodeStatus(CompusActivityCode code);
	
	/**
	 * @Title: findActivityInfo
	 * @Description:查找幸运号记录
	 * @param code
	 * @return
	 */
	public CompusActivityInfo findActivityInfo(String code, String openid);
	
	/**
	 * @Title: updateActivityInfo
	 * @Description:更新幸运号记录转发个数及状态
	 * @param competitionCode
	 * @param forwardCount
	 * @param status
	 * @param friendOpenid
	 */
	public void updateActivityInfo(String competitionCode, Integer forwardCount, Integer status, String friendOpenid);
	
	/**
	 * @Title: findActivityinfos
	 * @Description:统计抽奖资格及次数
	 * @param openid
	 * @return
	 */
	public List<CompusActivityInfo> findActivityinfos(String openid);
	
	/**
	 * @Title: hasLotteryOfOpenId
	 * @Description:是否中过奖
	 * @param openid
	 * @return
	 */
	public boolean hasLotteryOfOpenId(String openid	);
	
	/**
	 * @Title: remainderLotteryTicketCount
	 * @Description:剩余奖券个数
	 * @return
	 */
	public int remainderLotteryTicketCount();
	
	/**
	 * @Title: winningCountInDay
	 * @Description:当天中奖个数
	 * @return
	 */
	public int winningCountInDay();
	
	/**
	 * @Title: findVoucher
	 * @Description:获取奖券
	 * @param id
	 * @return
	 */
	public VoucherActivity findVoucher(Integer id, String openid);
	
	/**
	 * @Title: updateVoucher
	 * @Description:更新奖券状态
	 * @param id
	 * @param openid
	 */
	public void updateVoucher(Integer id, String openid,String ticketCode, Integer expiry);
	
	/**
	 * @Title: findLastLotteryRecord
	 * @Description:最近五条中奖纪录
	 * @return
	 */
	public List<VoucherActivity> findLastLotteryRecord();
}
