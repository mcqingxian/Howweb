package com.hoau.wechat.action;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.hoau.wechat.service.ICouponService;
import com.hoau.wechat.utils.net.WeixinUtil;
import com.hoau.wechat.vo.Vouchers;

@Controller
@Scope("prototype")
public class ArticleForwardAction extends BasicAction{

	@Resource
	private ICouponService couponService;
	
	//in
	private String openid;
	private String type;
	//out
	private String resMsg;
	
	public String execute(){
		//跳转至转发文章时获取到openid
		openid = WeixinUtil.getOpenIdFromSession();
		return "success";
	}
	
	public String sendCoupons(){
		if(couponService.hasQualificationsGainCoupons(openid, type)){
			Vouchers vouchers = couponService.getNewVouchers(openid, type,"");
			resMsg = "恭喜您获得:"+vouchers.getVouchersName()+",编号:"+vouchers.getVouchersCode();
		}else{
			resMsg = "您已获得过优惠券!";
		}
		return SUCCESS;
	}

	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getResMsg() {
		return resMsg;
	}

	public void setResMsg(String resMsg) {
		this.resMsg = resMsg;
	}
	
	
	
}
