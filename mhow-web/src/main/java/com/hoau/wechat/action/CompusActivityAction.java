package com.hoau.wechat.action;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.hoau.wechat.service.impl.CompusActivityService;
import com.hoau.wechat.util.JsonUtils;
import com.hoau.wechat.util.UUIDUtil;
import com.hoau.wechat.utils.ChartGraphics;
import com.hoau.wechat.utils.net.WeixinUtil;
import com.hoau.wechat.vo.CompusActivityInfo;
import com.hoau.wechat.vo.LotteryActivityDraw;
import com.hoau.wechat.vo.LotteryDrawResult;
import com.hoau.wechat.vo.VoucherActivity;
import com.hoau.wechat.vo.Vouchers;

/**
* @ClassName: CompusActivityAction
* @Description:校园托运活动
* @author hairen.long@hoau.net
* @date 2015年5月22日 上午8:19:12
*/
@Controller
@Scope("prototype")
public class CompusActivityAction extends BasicAction{
	// 抽奖结果
	private LotteryActivityDraw drawResult;
	//是否有资格抽奖
	private boolean hasQualifications;
	
	private String tipMsg;
	
	private String openid;
	//中奖纪录  只会中一次奖
	private List<VoucherActivity> voucherRecords;
	//最近中奖用户
	private List<CompusActivityInfo> lastRecords;
	
	@Resource
	private CompusActivityService compusActivityService;

	
	public String campusActivity()throws Exception{
		voucherRecords = new ArrayList<VoucherActivity>();
		openid = WeixinUtil.getOpenIdFromSession();
		//查询抽奖资格及次数
		Map<String, Object> resultMap = compusActivityService.hasQualificationsCount(openid);
		int qualificationsCount = (Integer)resultMap.get("count") ;
		//有资格抽奖
		if(qualificationsCount > 0){
			compusActivityService.updateActivityInfoStatus(resultMap.get("competitionCode").toString());
			hasQualifications = true;
			tipMsg = qualificationsCount>1?"您还有次"+(qualificationsCount-1)+"抽奖机会!":null;
			//抽奖
			drawResult = compusActivityService.gainDrawResult(openid,resultMap.get("city").toString());
			
			if(drawResult.getVoucherActivity().getVouchersName().contains("等奖")){
				drawResult = genImage(drawResult,2);
			}else{
				drawResult = genImage(drawResult, 1);
			}
		}else{//没有抽奖资格
			hasQualifications = false;
		}
				
		VoucherActivity voucherRecord = compusActivityService.findActivityInfo(openid);
		voucherRecords.add(voucherRecord);
		lastRecords = compusActivityService.findLastRecord();
		//test
		System.out.println(hasQualifications);
		System.out.println(JsonUtils.toJson(voucherRecords));
		System.out.println(JsonUtils.toJson(lastRecords));
		System.out.println(JsonUtils.toJson(drawResult));
		return "success";
	}
	
	
	private LotteryActivityDraw genImage(LotteryActivityDraw drawResult,int paramNums) throws IOException,
			FileNotFoundException {
		if(paramNums == 2){
			ChartGraphics chartGraphics = new ChartGraphics("恭喜您获得："+drawResult.getVoucherActivity().getVouchersName(),
					"优惠券编码："+drawResult.getVoucherActivity().getVouchersCode());
			String imageName = UUIDUtil.getUUID()+".png";
			String str = request.getSession().getServletContext().getRealPath("/")+"img/"+imageName;
			drawResult.setImageName(imageName);
			chartGraphics.write(new File(str));
		}else{
			ChartGraphics chartGraphics = new ChartGraphics(drawResult.getVoucherActivity().getVouchersName());
			String imageName = UUIDUtil.getUUID()+".png";
			String str = request.getSession().getServletContext().getRealPath("/")+"img/"+imageName;
			drawResult.setImageName(imageName);
			chartGraphics.write(new File(str));
		}
		return drawResult;
	}


	public String getTipMsg() {
		return tipMsg;
	}


	public void setTipMsg(String tipMsg) {
		this.tipMsg = tipMsg;
	}

	public LotteryActivityDraw getDrawResult() {
		return drawResult;
	}


	public void setDrawResult(LotteryActivityDraw drawResult) {
		this.drawResult = drawResult;
	}


	public boolean isHasQualifications() {
		return hasQualifications;
	}


	public void setHasQualifications(boolean hasQualifications) {
		this.hasQualifications = hasQualifications;
	}


	public String getOpenid() {
		return openid;
	}


	public void setOpenid(String openid) {
		this.openid = openid;
	}



	public List<VoucherActivity> getVoucherRecords() {
		return voucherRecords;
	}


	public void setVoucherRecords(List<VoucherActivity> voucherRecords) {
		this.voucherRecords = voucherRecords;
	}


	public List<CompusActivityInfo> getLastRecords() {
		return lastRecords;
	}


	public void setLastRecords(List<CompusActivityInfo> lastRecords) {
		this.lastRecords = lastRecords;
	}

	
}
