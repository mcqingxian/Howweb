package com.hoau.wechat.service.impl;

import java.util.Date;
import java.util.Random;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.hoau.wechat.dao.ILotteryRecordDao;
import com.hoau.wechat.dao.IVouchersDao;
import com.hoau.wechat.service.ILotteryService;
import com.hoau.wechat.util.JsonUtils;
import com.hoau.wechat.util.StringUtil;
import com.hoau.wechat.vo.LotteryRecord;
import com.hoau.wechat.vo.UserInfo;
import com.hoau.wechat.vo.Vouchers;

@Service
public class LotteryService implements ILotteryService{
	
	private Logger logger = Logger.getLogger(LotteryService.class);
	
	@Resource
	private ILotteryRecordDao lotteryRecordDao;
	@Resource
	private IVouchersDao vouchersDao;
	@Resource
	private PhoneBindService phoneBindService;
	
	/*@Autowired(required=true)  @Qualifier("voucherWS") 
	private OuterVocherServices outerVocherServices;*/
	
	

	@Override
	public Vouchers LuckDraw(String openid, String type, String versionNo) {
		Vouchers vouchers = null;
		//验证是否已经领取三次优惠券
		UserInfo userInfo = phoneBindService.findOneUserInfo(openid);
		if(userInfo == null || StringUtil.isEmpty(userInfo.getPhone())){
			throw new RuntimeException();
		}
		//versonNo 
		LotteryRecord record = lotteryRecordDao.findLotterByVersonNo(openid, type, versionNo);
		if(record != null ){
			vouchers = new Vouchers();
			vouchers.setStatus(0);
			vouchers.setType(type);
			vouchers.setVouchersCode(record.getVouchersNo());
			vouchers.setVouchersName(record.getDetail().substring(0, record.getDetail().length()-4));
		}else{
			vouchers = gainVouchers(openid, type, userInfo.getPhone(), versionNo);
		}
		
		return vouchers;
	}

	@Override
	public Vouchers gainVouchers(String openid, String type, String phone, String versionNo) {
//		WebApplicationContext act = WebApplicationContextUtils.getRequiredWebApplicationContext(ServletActionContext.getServletContext());
//		OuterVocherServices outerVocherServices = (OuterVocherServices) act.getBean("voucherWS");
		
		/*VoucherInfo info = null;//outerVocherServices.getNewVoucher(Constant.COUPON_DC_APPID, getVouchersValue());
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
//				record.setId(UUIDUtil.getUUID());
				record.setLotteryTime(new Date());
				record.setOpenid(openid.trim());
				record.setType(type.trim());
				record.setVouchersNo(info.getVoucherCode().trim());
				record.setPhone(phone);
				record.setId(versionNo);
				
				lotteryRecordDao.saveLotteryRecord(record);
			}else{
				throw new RuntimeException("获取优惠券失败！");
			}
		} catch (Exception e) {
			throw new RuntimeException("获取优惠券失败！");
		}*/
		return null;
	}
	
	private static int getVouchersValue(){
		int[] arr = {5,10,20,50};
		Random ran = new Random();
		return arr[ran.nextInt(arr.length)];
	}
	
}
