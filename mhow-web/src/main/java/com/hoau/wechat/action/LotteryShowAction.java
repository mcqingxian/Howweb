package com.hoau.wechat.action;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.hoau.wechat.constant.Constant;
import com.hoau.wechat.service.IActivitiesService;
import com.hoau.wechat.service.ICouponService;
import com.hoau.wechat.utils.net.WeixinUtil;
import com.hoau.wechat.vo.Vouchers;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author 作者 lanhong zhang E-mail:
 * @version 创建时间：2015年4月9日 上午11:37:06
 * 类说明
 */
@Controller
@Scope("prototype")
public class LotteryShowAction extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
//	@Autowired
	private Vouchers voucher;
	@Resource
	private IActivitiesService  activitiesService;
	@Resource
	private ICouponService couponService;
	
	private String openid;
	
	//test
	public String execute(){
		openid = WeixinUtil.getOpenIdFromSession();
		//按原来的取 本地数据库
//		voucher = activitiesService.getVouchers(openid, Constant.COUPON_YDJ);
		//20150526  到迪辰获取优惠券
		voucher = couponService.gainVouchers(openid, Constant.COUPON_YDJ);
		return SUCCESS;
	}
	public Vouchers getVoucher() {
		return voucher;
	}
	public void setVoucher(Vouchers voucher) {
		this.voucher = voucher;
	}
	public String getOpenid() {
		return openid;
	}
	public void setOpenid(String openid) {
		this.openid = openid;
	}
	
}
