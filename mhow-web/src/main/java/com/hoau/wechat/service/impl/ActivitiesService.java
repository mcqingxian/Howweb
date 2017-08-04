package com.hoau.wechat.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hoau.wechat.constant.Constant;
import com.hoau.wechat.dao.IActivitiesDao;
import com.hoau.wechat.service.IActivitiesService;
import com.hoau.wechat.util.UUIDUtil;
import com.hoau.wechat.vo.ActiveInfo;
import com.hoau.wechat.vo.LotteryDrawResult;
import com.hoau.wechat.vo.LotteryRecord;
import com.hoau.wechat.vo.LotteryRecordVo;
import com.hoau.wechat.vo.ShareRecode;
import com.hoau.wechat.vo.Vouchers;

@Service
public class ActivitiesService implements IActivitiesService {

	private static SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	@Resource
	private IActivitiesDao activitiesDao;
	
/*	@Resource
	private IkeywordDao keywordDao;*/
	
	@Override
	public LotteryDrawResult getLottery(String openid) {
		LotteryDrawResult result = new LotteryDrawResult();
		Vouchers vouchers = null;
		//有抽奖资格
		if(hasQualification(openid)){
			result.setQualification(true);
			//抽奖
			vouchers = lotteryDraw(openid);
		}else{// 无抽奖资格
			result.setQualification(false);
		}
		result.setVouchers(vouchers);
		return result;
	}

	/** 
	* @Title: lotteryDraw 
	* @Description: 通过一定的规则获取一张奖券 
	* @param openid
	* @return    设定文件 
	* @return Vouchers    返回类型 
	* @throws 
	*/
	private Vouchers lotteryDraw(String openid) {
		Vouchers vouchers = null;
		
		int randomNumber =  getRandomNumber(100);
		if(randomNumber < 40){
			// 获取奖券
			vouchers = getLotteryTicket(null);
			if(vouchers == null){
				// 未中奖，谢谢惠顾的等字样
				vouchers = new Vouchers();
				vouchers.setVouchersName("感谢您的参与！");
				vouchers.setId(5000);
			}
		}else{
			// 未中奖，谢谢惠顾的等字样
			vouchers = new Vouchers();
			vouchers.setVouchersName("感谢您的参与！");
			vouchers.setId(5000);	
		}
		
		// 新增中奖记录
		LotteryRecord lotteryRecord = new LotteryRecord();
		lotteryRecord.setId(UUIDUtil.getUUID());
		lotteryRecord.setLotteryTime(new Date());
		lotteryRecord.setOpenid(openid);
		lotteryRecord.setVouchersNo(vouchers.getVouchersCode());
		lotteryRecord.setVouchersId(vouchers.getId());
		lotteryRecord.setDetail(vouchers.getVouchersName());
		activitiesDao.addLotteryRecord(lotteryRecord);
		return vouchers;
	}

	//获取奖券入口
	private synchronized Vouchers getLotteryTicket(String type) {
		//获取奖券
		Vouchers vouchers = activitiesDao.useLotteryTicket(type);
		//修改奖券状态
		if(vouchers != null){
			activitiesDao.updateStatus(vouchers.getId());
		}
		return vouchers;
	}

	/** 
	* @Title: getRandomNumber 
	* @Description: 获取 0 到 i的伪随机数
	* @param i
	* @return int    返回类型 
	* @throws 
	*/
	private static int getRandomNumber(int i) {
		Random random = new Random();
		return random.nextInt(i);
	}

	/** 
	* @Title: hasQualification 
	* @Description: 用户绑定手机号有一次抽奖记录，分享之后获得一次抽奖记录，最多两次
	* @param openid
	* @return    设定文件 
	* @return boolean    返回类型 
	* @throws 
	*/
	private boolean hasQualification(String openid) {
		boolean hasQualification = false;
		//是否绑定手机
		boolean isBind = activitiesDao.isBind(openid);
		if(isBind){
			// 获取抽奖记录
			List<LotteryRecord> lotteryRecords = activitiesDao.getLotteryRecord(openid,true);
			switch (lotteryRecords.size()) {
			case 0:// 绑定未抽奖
				hasQualification = true;
				break;
			case 1:
				ShareRecode shareRecode  = activitiesDao.getShareRecord(openid);	
				if(shareRecode != null){
					hasQualification = true;
				}
				break;
			default:
				break;
			}
		}
		return hasQualification;
	}

	@Override
	public void saveShareRecord(ShareRecode shareRecode) {
		activitiesDao.addShareRecord(shareRecode);
	}

	@Override
	public List<LotteryRecordVo> getLotteryRecord() {
		List<LotteryRecordVo> list = new ArrayList<LotteryRecordVo>();
		
		List<LotteryRecord> lotteryRecords = activitiesDao.latestLotteryRecord();
		for(LotteryRecord record:lotteryRecords){
			String openId = record.getOpenid();
			String phone = activitiesDao.getUserPhoneNo(openId);
			LotteryRecordVo recordVo = new LotteryRecordVo();
			if(phone != null){
				String sub1 = phone.substring(0, 3);
				String sub2 = phone.substring(7);
				phone = sub1 +"****"+sub2;
				recordVo.setPhone(phone);
				recordVo.setTime(df.format(record.getLotteryTime()));
				recordVo.setDetail(record.getDetail());
				list.add(recordVo);
			}
		}
		if(list.size() == 0){
			LotteryRecordVo recordVo = new LotteryRecordVo();
			recordVo.setDetail("暂无中奖纪录！");
			recordVo.setPhone("");
			list.add(recordVo);
		}
		return list;
	}
	@Override
	public boolean getShareRecord(String openid) {
		boolean rtn = false;
		ShareRecode recode = activitiesDao.getShareRecord(openid);
		if(recode != null){
			rtn = true;
		}
		return rtn;
	}

	@Override
	public List<LotteryRecord> viewLotteryRecord(String openid) {
		
		List<LotteryRecord> records = activitiesDao.getLotteryRecord(openid,false);
		if(records.size() == 0){
			LotteryRecord vo = new LotteryRecord();
			vo.setDetail("没有中奖记录！");
			records.add(vo);
		}else{
			for (int i = 0; i < records.size(); i++) {
				LotteryRecord record = records.get(i);
				StringBuffer sb = new StringBuffer();
				sb.append(record.getDetail());
				if(record.getVouchersNo() != null){
					sb.append("   奖券编号为：").append(record.getVouchersNo());
				}
				record.setDetail(sb.toString());
			}
		}
		return records;
	}
	
	@Override
	public Vouchers getVouchers(String openid,String type) {
		List<LotteryRecord> records = activitiesDao.getLotteryRecord(openid, type);
		Vouchers vouchers =null;
		//有过中奖记录
		if(records.size()>0){
			//易到家类型抵用券
			if(Constant.COUPON_YDJ.equals(type)){
//				throw new RuntimeException("华宇易到家给您派送红包："+records.get(0).getVouchersNo());
				vouchers = new Vouchers();
				vouchers.setVouchersCode(records.get(0).getVouchersNo());
				vouchers.setVouchersName(records.get(0).getDetail());
				vouchers.setStatus(1);//1 已经获得过红包
				return vouchers;
			}else{
				//已经领过其他优惠券的返回领取过的优惠券
				throw new RuntimeException("本次活动您已获得一张优惠券："+records.get(0).getVouchersNo());
			}
		}else{//新用户
			//1 易到家的
			if(Constant.COUPON_YDJ.equals(type)){
				vouchers = getLotteryTicket(type);
			}else{
				//新用户领取的其他类型的优惠券
				vouchers = getLotteryTicket(type);
			}
			if(vouchers != null){
				// 新增中奖记录
				LotteryRecord lotteryRecord = new LotteryRecord();
				lotteryRecord.setId(UUIDUtil.getUUID());
				lotteryRecord.setLotteryTime(new Date());
				lotteryRecord.setOpenid(openid);
				lotteryRecord.setVouchersNo(vouchers.getVouchersCode());
				lotteryRecord.setVouchersId(vouchers.getId());
				lotteryRecord.setDetail(vouchers.getVouchersName());
				lotteryRecord.setType(type);
				activitiesDao.addLotteryRecord(lotteryRecord);
			}
			return vouchers;
		}
	
	}

	@Override
	public List<ActiveInfo> getActiveInfos() {
		return activitiesDao.getActiveInfos();
	}

	/*@Override
	public List<KeyWord> getKeywords() {
		return keywordDao.getKeyword();
	}*/
}
