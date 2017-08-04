package com.hoau.wechat.action;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.hoau.wechat.service.ICouponService;
import com.hoau.wechat.utils.net.WeixinUtil;
import com.hoau.wechat.vo.CouponVo;

/**
* @ClassName: CouponManageAction
* @Description: 优惠券管理
* @author hairen.long@hoau.net
* @date 2015年5月17日 上午10:45:39
*/
@Controller
@Scope("prototype")
public class CouponManageAction extends BasicAction{
	
	@Resource
	private ICouponService couponService;
	
	private List<CouponVo> unused;
	private List<CouponVo> beenUsed;
	private List<CouponVo> hasExpired;

	
	@SuppressWarnings("unchecked")
	public String execute() throws Exception{
		String openid = WeixinUtil.getOpenIdFromSession();
		WebApplicationContext act = WebApplicationContextUtils.getRequiredWebApplicationContext(ServletActionContext.getServletContext());
		Map<String, Object> coupons = couponService.getCouponsByOpenid(openid,act);
		unused = (List<CouponVo>) coupons.get("unused");
		beenUsed = (List<CouponVo>) coupons.get("beenUsed");
		hasExpired = (List<CouponVo>) coupons.get("hasExpired");
		
		return SUCCESS;
	}
	
	
	public List<CouponVo> getBeenUsed() {
		return beenUsed;
	}


	public void setBeenUsed(List<CouponVo> beenUsed) {
		this.beenUsed = beenUsed;
	}


	public List<CouponVo> getHasExpired() {
		return hasExpired;
	}


	public void setHasExpired(List<CouponVo> hasExpired) {
		this.hasExpired = hasExpired;
	}


	public void setUnused(List<CouponVo> unused) {
		this.unused = unused;
	}


	public List<CouponVo> getUnused() {
		return unused;
	}


}
