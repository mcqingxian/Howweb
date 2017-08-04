package com.hoau.wechat.action;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.hoau.wechat.service.IActivitiesService;
import com.hoau.wechat.util.UUIDUtil;
import com.hoau.wechat.utils.ChartGraphics;
import com.hoau.wechat.utils.net.WeixinUtil;
import com.hoau.wechat.vo.LotteryDrawResult;
import com.hoau.wechat.vo.LotteryRecord;
import com.hoau.wechat.vo.LotteryRecordVo;
import com.hoau.wechat.vo.ShareRecode;
import com.hoau.wechat.vo.Vouchers;

/** 
* @ClassName: ActivitiesAction 
* @Description: 活动action 
* @author xujun jun.xu@hoau.net
* @date 2014年7月30日 下午7:35:09 
*  
*/

@Controller
@Scope("prototype")
public class ActivitiesAction extends BasicAction{
	
	@Resource
	private IActivitiesService activitiesService;
	// 抽奖结果
	private LotteryDrawResult drawResult;
	private String openId;
	private int shareStatus;
	// 中奖记录
	private List<LotteryRecord> records;
	
	//最新中奖记录
	private List<LotteryRecordVo> lotteryRecordVos;
	
	@Override
	public String execute() throws Exception {
		openId = WeixinUtil.getOpenIdFromSession();
		// 最新5条中奖纪录
		lotteryRecordVos = activitiesService.getLotteryRecord();
		// 当前用户中奖纪录
		records = activitiesService.viewLotteryRecord(openId);
		
		drawResult = activitiesService.getLottery(openId);
		// 生成中奖图片 -是否有资格
		if(drawResult.isQualification()){
			Vouchers vouchers = drawResult.getVouchers();
			// 优惠券  （2行显示）
			if(vouchers.getVouchersCode() != null){
				genImage(vouchers,2);
			}else{// 实物奖品  和 谢谢惠顾等（1行显示）
				genImage(vouchers,1);
			}

		}
		return SUCCESS;
	}

	/** 
	* @Title: genImage 
	* @Description: 根据奖券信息生成图片 
	* @param vouchers
	* @param paramNums
	* @throws IOException
	* @throws FileNotFoundException    设定文件 
	* @return void    返回类型 
	* @throws 
	*/
	private void genImage(Vouchers vouchers,int paramNums) throws IOException,
			FileNotFoundException {
		if(paramNums == 2){
			ChartGraphics chartGraphics = new ChartGraphics("恭喜您获得"+vouchers.getVouchersName(),"优惠券编码为："+vouchers.getVouchersCode());
			String imageName = UUIDUtil.getUUID()+".png";
			String str = request.getSession().getServletContext().getRealPath("/")+"img/"+imageName;
			drawResult.setImageName(imageName);
			chartGraphics.write(new File(str));
		}else{
			ChartGraphics chartGraphics = new ChartGraphics(drawResult.getVouchers().getVouchersName());
			String imageName = UUIDUtil.getUUID()+".png";
			String str = request.getSession().getServletContext().getRealPath("/")+"img/"+imageName;
			drawResult.setImageName(imageName);
			chartGraphics.write(new File(str));
		}
	}

	/** 
	* @Title: shareRecord 
	* @Description:保存分享记录 
	* @param @return
	* @param @throws Exception    设定文件 
	* @return String    返回类型 
	* @throws 
	*/
	public String shareRecord() throws Exception {
		openId = WeixinUtil.getOpenIdFromSession();
		ShareRecode shareRecode = new ShareRecode();
		shareRecode.setId(UUIDUtil.getUUID());
		shareRecode.setOpenid(openId);
		shareRecode.setShareTime(new Date());
		boolean isShare = activitiesService.getShareRecord(openId);
		if(isShare){
			shareStatus = 0;
		}else{
			activitiesService.saveShareRecord(shareRecode);
			shareStatus = 1;
		}
		return SUCCESS;
	}
	
	
	public LotteryDrawResult getDrawResult() {
		return drawResult;
	}
	public void setDrawResult(LotteryDrawResult drawResult) {
		this.drawResult = drawResult;
	}

	public String getOpenId() {
		return openId;
	}

	public void setOpenId(String openId) {
		this.openId = openId;
	}

	public int getShareStatus() {
		return shareStatus;
	}

	public void setShareStatus(int shareStatus) {
		this.shareStatus = shareStatus;
	}

	public List<LotteryRecordVo> getLotteryRecordVos() {
		return lotteryRecordVos;
	}

	public void setLotteryRecordVos(List<LotteryRecordVo> lotteryRecordVos) {
		this.lotteryRecordVos = lotteryRecordVos;
	}

	public List<LotteryRecord> getRecords() {
		return records;
	}

	public void setRecords(List<LotteryRecord> records) {
		this.records = records;
	}
	
}
