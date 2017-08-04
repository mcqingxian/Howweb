package com.hoau.wechat.action;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.hoau.wechat.constant.Constant;
import com.hoau.wechat.service.impl.CouponService;
import com.hoau.wechat.util.JsonUtils;
import com.hoau.wechat.utils.net.WeixinUtil;
import com.hoau.wechat.vo.Vouchers;

/**
 * @ClassName: AnniversaryActivityAction
 * @Description: 二十周年庆活动
 * @author hairen.long@hoau.net
 * @date 2015年5月31日 下午7:40:58
 */
@Controller
@Scope("prototype")
public class AnniversaryActivityAction extends BasicAction {
	private Logger logger = Logger.getLogger(AnniversaryActivityAction.class);
	
	@Resource
	private CouponService couponService;

	// 抽奖结果
//	private LotteryDrawResult drawResult;
	private String wayBill;
	private String openid;
	private Vouchers vouchers;
	
	@Override
	public String execute(){
		try {
			openid = WeixinUtil.getOpenIdFromSession();
			wayBill = request.getParameter("waybill");
			logger.info("openId"+openid+",waybill:"+wayBill);
			vouchers = couponService.getLuckDraw(openid, Constant.COUPON_DRD_LUCKDRAW, wayBill).getVouchers();
			logger.info(JsonUtils.toJson(vouchers));
			if(vouchers == null){
				vouchers = new Vouchers();
				vouchers.setStatus(1);
				vouchers.setVouchersName("感谢您的参与!");
			}
		} catch (Exception e) {
			vouchers = new Vouchers();
			vouchers.setStatus(1);
			vouchers.setVouchersName("感谢您的参与!");
		}	
		return SUCCESS;
	}

	public String getWayBill() {
		return wayBill;
	}

	public void setWayBill(String wayBill) {
		this.wayBill = wayBill;
	}


	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}

	public Vouchers getVouchers() {
		return vouchers;
	}

	public void setVouchers(Vouchers vouchers) {
		this.vouchers = vouchers;
	}
	
	

}
