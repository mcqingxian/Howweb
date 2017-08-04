package com.hoau.wechat.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;

import com.hoau.wechat.constant.Constant;
import com.hoau.wechat.dao.IActivitiesDao;
import com.hoau.wechat.dao.ILotteryRecordDao;
import com.hoau.wechat.dao.IVouchersDao;
import com.hoau.wechat.service.ICouponService;
import com.hoau.wechat.util.JsonUtils;
import com.hoau.wechat.utils.MathRandom;
import com.hoau.wechat.vo.LotteryDrawResult;
import com.hoau.wechat.vo.LotteryRecord;
import com.hoau.wechat.vo.Vouchers;

/**
* @ClassName: CouponService
* @Description:优惠券
* @author hairen.long@hoau.net
* @date 2015年5月11日 上午10:13:42
*/
@Service
public class CouponService implements ICouponService{
	
	private Logger logger = Logger.getLogger(CouponService.class);
	
	@Resource
	private ILotteryRecordDao lotteryRecordDao;
	
	@Resource
	private IActivitiesDao activitiesDao;
	
	@Resource
	private IVouchersDao vouchersDao;
	
	/*@Autowired(required=true)  @Qualifier("voucherWS") 
	private OuterVocherServices outerVocherServices;*/
	
	public static void main(String[] args) {
		String str = "10元优惠券";
		System.out.println(str.substring(0, str.length()-4));
	}
	
	
	/**
	 * 二十周年抽奖
	 */
	@Override
	public LotteryDrawResult getLuckDraw(String openid, String type, String wayBill) {
		LotteryDrawResult draw = new LotteryDrawResult();
		draw.setQualification(true);
		Vouchers voucher = null;
		LotteryRecord record = lotteryRecordDao.findLotteryRecord(openid, type, wayBill);
		if(record != null){
			if(record.getVouchersNo() != null){
				voucher = new Vouchers();
				voucher.setStatus(0);
				voucher.setType(record.getType());
				voucher.setVouchersCode(record.getVouchersNo());
				voucher.setVouchersName(record.getDetail().substring(0, record.getDetail().length()-4));
			}else{
				draw.setStatus(0);
				voucher = new Vouchers();
				voucher.setVouchersName("感谢您的参与！");
				voucher.setStatus(1);
			}
		}else if(isLuckWayBill()){//中奖
			draw.setStatus(1);
			voucher = getNewVouchers(openid, type, wayBill);
			voucher.setStatus(0);
		}else{
			draw.setStatus(0);
			voucher = new Vouchers();
			voucher.setVouchersName("感谢您的参与！");
			voucher.setStatus(1);
			
			LotteryRecord rec = new LotteryRecord();
			rec.setLotteryTime(new Date());
			rec.setOpenid(openid.trim());
			rec.setType(type.trim());
			rec.setWaybill(wayBill);
			rec.setDetail("感谢您的参与！");
			//抽过奖 记录
			lotteryRecordDao.saveLotteryRecord(rec);
		}
		draw.setVouchers(voucher);
		logger.info(JsonUtils.toJson(draw));
		return draw;
	}

	//是否有机会抽奖
	private boolean isLuckWayBill() {
		boolean isLuck = false;
		Random ran = new Random();
		if(ran.nextInt(100)<74){
			isLuck = true;
		}
		return isLuck;
	}
	

	@Override
	public boolean hasWayBillLuckdraw(String openid, String type, String wayBill) {
		boolean beenLuck = false;
		LotteryRecord record = lotteryRecordDao.findLotteryRecord(openid, type, wayBill);
		if(record != null){
			beenLuck = true;
		}
		return beenLuck;
	}

	/**
	 * 是否转发过文章
	 */
	@Override
	public boolean hasQualificationsGainCoupons(String openid, String type) {
		boolean hasQualifications = true;
		List<LotteryRecord> records = lotteryRecordDao.getLotteryRecord(openid.trim(), type.trim());
		if(records.size()>0){
			hasQualifications = false;
		}
		return hasQualifications;
	}

	@Override
	public Vouchers gainVouchers(String openid, String type) {
		List<LotteryRecord> records = activitiesDao.getLotteryRecord(openid, type);
		Vouchers vouchers =null;
		//有过中奖记录
		if(records.size()>0){
			//易到家类型抵用券
			if(Constant.COUPON_YDJ.equals(type)){
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
			vouchers = getNewVouchers(openid,type,"");
		}
		return vouchers;
	}
	
	



	@Override
	public Vouchers getNewVouchers(String openid, String type, String wayBill) {
		logger.info("openid:"+openid+",type:"+type+",waybill:"+wayBill);
//		WebApplicationContext act = WebApplicationContextUtils.getRequiredWebApplicationContext(ServletActionContext.getServletContext());
//		OuterVocherServices outerVocherServices = (OuterVocherServices) act.getBean("voucherWS");
		int value = 0;
		//不同类型中奖额度概率控制
		if(Constant.COUPON_YDJ.equals(type)){//易到家
			value = getYDJVoucherValue();
		}else if(type.contains("article")){//转发文章
			value = 10;
		}else if(Constant.COUPON_DRD_LUCKDRAW.equals(type)){//定日达抽奖
			value = getWayBillVoucherValue();
		}else if(Constant.COUPON_DYQ.equals(type)){//新用户关注
			value = 10;
		}
		/*VoucherInfo info = outerVocherServices.getNewVoucher(Constant.COUPON_DC_APPID, value);
		logger.info(JsonUtils.toJson(info));
		Vouchers vouchers = null;
		try {
			if(info != null){
				vouchers = new Vouchers();
				vouchers.setVouchersCode(info.getVoucherCode());
				vouchers.setVouchersName(info.getValue()+"");
				vouchers.setType(type);
				
				//保存优惠券
				vouchersDao.saveVouchers(vouchers);
				
				LotteryRecord record = new LotteryRecord();
				record.setDetail(info.getValue()+"元优惠券");
				record.setId(UUIDUtil.getUUID());
				record.setLotteryTime(new Date());
				record.setOpenid(openid.trim());
				record.setType(type.trim());
				record.setVouchersNo(info.getVoucherCode().trim());
				if(Constant.COUPON_DRD_LUCKDRAW.equals(type)){
					record.setWaybill(wayBill);
				}
				lotteryRecordDao.saveLotteryRecord(record);
			}else{
				throw new RuntimeException("获取优惠券失败！");
			}
		} catch (Exception e) {
			throw new RuntimeException("获取优惠券失败！");
		}*/
		return null;
	}
	

	@Override
	public Map<String, Object> getCouponsByOpenid(String openid, WebApplicationContext act) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
		Map<String, Object> coupons = new HashMap<String, Object>();
		/*try {
			OuterVocherServices outerVocherServices = (OuterVocherServices) act.getBean("voucherWS");
			//查询中奖纪录
			List<LotteryRecord> records = lotteryRecordDao.getLotteryRecord(openid,null);
			//根据奖券编号 到DC查询奖券
			List<String> vouchersCodes = new ArrayList<String>();
			List<CouponVo> unused = new ArrayList<CouponVo>();
			List<CouponVo> beenUsed = new ArrayList<CouponVo>();
			List<CouponVo> hasExpired = new ArrayList<CouponVo>();
			for(LotteryRecord record : records){
				vouchersCodes.add(record.getVouchersNo());
			}
			GetVoucherStatusRes result = outerVocherServices.getVoucherStatus(Constant.COUPON_DC_APPID, vouchersCodes);
			CouponVo vo = null;
			for(VoucherInfo voucher : result.getVoucherInfos()){
				vo = new CouponVo();
				vo.setCouponCode(voucher.getVoucherCode());
				vo.setValidTime(sdf1.format(sdf.parse(voucher.getDeadline())));
				vo.setPar(voucher.getValue()+"");
				if("已启用".equals(voucher.getStatus())){
					if(TimeUtils.daysBetween(TimeUtils.getFormatToday(), sdf1.format(sdf.parse(voucher.getDeadline())))<0){
						hasExpired.add(vo);
					}else{
						unused.add(vo);
					}
				}else if("已使用".equals(voucher.getStatus())){
					beenUsed.add(vo);
				}
			}
			coupons.put("unused", unused);
			coupons.put("beenUsed", beenUsed);
			coupons.put("hasExpired", hasExpired);
		} catch (BeansException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}*/
		
		return coupons;
	}
	
	private int getYDJVoucherValue(){
		int[] numPool = {5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,10,10,10,10,10,15,15,15,20,25};
		Random ran = new Random();
		return numPool[ran.nextInt(numPool.length)];
	}
	
	private int getWayBillVoucherValue(){
		int[] number = {5,10,20,50,100};
		return number[MathRandom.PercentageRandom()];
	}
	

}
