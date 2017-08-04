package com.hoau.wechat.service.msgHandler;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import com.hoau.wechat.constant.MsgKey;
import com.hoau.wechat.dao.IConfigureDao;
import com.hoau.wechat.dao.ILotteryRecordDao;
import com.hoau.wechat.dao.IVouchersDao;
import com.hoau.wechat.dao.IWayBillInfoDao;
import com.hoau.wechat.vo.Vouchers;
import com.hoau.wechat.vo.WayBillInfoEntity;

@Service
public class SendVouchersHandler extends AbstractResponseText{
	
	@Resource
	private IWayBillInfoDao wayBillInfoDao;
	@Resource
	private ILotteryRecordDao lotteryRecordDao;
	@Resource
	private IVouchersDao vouchersDao;
	@Resource
	private IConfigureDao configureDao;
	
	@Override
	protected String genContent(Map<String, String> inputParams, ApplicationContext context) {
		//获取DC抵用券接口
		String respMsg = "";
		List<Vouchers> vouchers = new ArrayList<Vouchers>();
		List<Integer> voucherValues = new ArrayList<Integer>();
		
		String openid = inputParams.get(MsgKey.KEY_FROMUSER);
		
		try {
			//OuterVocherServices outerVocherServices = (OuterVocherServices) context.getBean("voucherWS");
			List<WayBillInfoEntity> infos = wayBillInfoDao.findWayBillInfos(openid);
			
			Vouchers voucher = null;
			/*for(WayBillInfoEntity info : infos){
				//整车
				if("整车".equals(info.getTransType())){
					voucherValues = calculationVouchers(info.getTotalCost());
					VoucherInfo voucherInfo = null;
					//获取抵用券
					for(Integer value : voucherValues){
						voucherInfo = null;//outerVocherServices.getNewVoucher(Constant.COUPON_DC_APPID, value);
						voucher = new Vouchers();
						voucher.setType(Constant.COUPON_ZC);
						voucher.setVouchersCode(voucherInfo.getVoucherCode());
						voucher.setVouchersName(voucherInfo.getValue()+"元优惠券");
						
						vouchersDao.saveVouchers(voucher);
						
						vouchers.add(voucher);
						//记录抵用券
						saveLotteryRecord(voucherInfo,voucher.getType(), openid, info.getWayBill());
					}
				}else{
					//获取抵用券
					VoucherInfo voucherInfo = null;
					Configure configure = configureDao.findConfigure(info.getOrderSource(), "orderSource");
					if(configure != null){
						for (int i = 0; i < configure.getVouchersCount(); i++) {
							voucherInfo = null;//outerVocherServices.getNewVoucher(Constant.COUPON_DC_APPID, configure.getParValue());
							voucher = new Vouchers();
							voucher.setType(Constant.COUPON_OTHER);
							voucher.setVouchersCode(voucherInfo.getVoucherCode());
							voucher.setVouchersName(voucherInfo.getValue()+"元优惠券");
							
							vouchersDao.saveVouchers(voucher);
							
							vouchers.add(voucher);
							//记录抵用券
							saveLotteryRecord(voucherInfo, voucher.getType(), openid, info.getWayBill());
						}
					}
				}
				//更新
				info.setStatus(1);
				wayBillInfoDao.updateWayBill(info);
			}*/
			if(infos.size()>0){
				String text = "";
				for(Vouchers vo : vouchers){
					text += vo.getVouchersCode() + ",";
				}
				respMsg = "恭喜您获得抵用券（ΦωΦ）\n抵用券代码["+ text.substring(0,text.length()-1) +"]\r\n使用说明：\n1、优惠券仅适用于天地华宇物流服务，并不予兑现。\n2、在法律允许的范围内，此优惠券使用的最终解释权归天地华宇官方所有。";
			}else{
				respMsg = "您好，该运单没有获得运费抵用劵";
			}
		} catch (Exception e) {
			respMsg = "您好，该运单没有获得运费抵用劵";
		}
		return respMsg;
	}
	
	/**
	 * @Title: saveLotteryRecord
	 * @Description:记录抵用券
	 * @param info
	 * @param openid
	 * @param wayBill
	 */
	/*private void saveLotteryRecord(VoucherInfo info, String type, String openid, String wayBill){
		LotteryRecord record = new LotteryRecord();
		record.setDetail(info.getValue()+"元优惠券");
		record.setId(UUIDUtil.getUUID());
		record.setLotteryTime(new Date());
		record.setOpenid(openid.trim());
		record.setType(type);
		record.setVouchersNo(info.getVoucherCode().trim());
		record.setWaybill(wayBill);
		lotteryRecordDao.saveLotteryRecord(record);
	}*/
	
	/**
	 * @Title: calculationVouchers
	 * @Description:计算抵用券
	 * @param cost
	 * @return
	 */
	private static List<Integer> calculationVouchers(double cost){
		List<Integer> voucherValues = new ArrayList<Integer>();
		double shouldValue = cost*0.01;
		do{
			if(shouldValue >= 50){
				voucherValues.add(50);
				shouldValue = shouldValue - 50;
			}else if(shouldValue >= 20){
				voucherValues.add(20);
				shouldValue = shouldValue - 20;
			}else if(shouldValue >= 10){
				voucherValues.add(10);
				shouldValue = shouldValue - 10;
			}else{
				break;
			}
		}while(shouldValue > 0);
		return voucherValues;
	}
	
}
