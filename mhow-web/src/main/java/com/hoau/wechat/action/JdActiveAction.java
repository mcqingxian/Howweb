package com.hoau.wechat.action;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.hoau.wechat.constant.Constant;
import com.hoau.wechat.service.ILotteryService;
import com.hoau.wechat.util.JsonUtils;
import com.hoau.wechat.util.PermissionCheck;
import com.hoau.wechat.utils.net.WeixinUtil;
import com.hoau.wechat.vo.Vouchers;

/**
* @ClassName: JdActiveAction
* @Description:京东家装节活动
* @author hairen.long@hoau.net
* @date 2015年7月18日 上午11:13:22
*/
@Controller
@Scope("prototype")
public class JdActiveAction extends BasicAction{
	private Logger logger = Logger.getLogger(JdActiveAction.class);
	
	@Resource
	private ILotteryService lotteryService;
	
	//in
	private String openid;
	//点击没有连接获取相同的优惠券
	private String versionNo;
	//out
	private Vouchers vouchers;
	
	@Override
	@PermissionCheck
	public String execute(){
		try {
			openid = WeixinUtil.getOpenIdFromSession();
			versionNo = request.getParameter("versionNo");
			vouchers = lotteryService.LuckDraw(openid, Constant.JD_JZJ_ACTIVE_TYPE,versionNo);
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

	public String getVersionNo() {
		return versionNo;
	}

	public void setVersionNo(String versionNo) {
		this.versionNo = versionNo;
	}


	
	
}
