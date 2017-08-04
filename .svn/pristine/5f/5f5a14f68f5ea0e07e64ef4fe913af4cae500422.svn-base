package com.hoau.wechat.service.msgHandler;

import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.annotation.Resource;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import com.hoau.wechat.constant.Constant;
import com.hoau.wechat.constant.MsgKey;
import com.hoau.wechat.service.IGoodsService;
import com.hoau.wechat.service.impl.ActivitiesService;
import com.hoau.wechat.service.impl.CompusActivityService;
import com.hoau.wechat.service.impl.CouponService;
import com.hoau.wechat.service.impl.GoodsService;
import com.hoau.wechat.servlet.CoreService;
import com.hoau.wechat.util.StringUtil;
import com.hoau.wechat.vo.GoodsTraceInfo;
import com.hoau.wechat.vo.LotteryRecord;
import com.hoau.wechat.vo.TraceInfo;
import com.hoau.wechat.vo.Vouchers;


/** 
* @ClassName  :TextMsgHandler 
* @Description:从用户发送的文本消息中抽取信息，查看是否有运单，如果有，返回运单跟踪记录，没有返回提示信息
* @author     :xujun cometzb@126.com	
* @date       :2014年5月9日 下午2:44:01 
*  
*/
@Service
public class TextMsgHandler extends AbstractResponseText {

	@Resource
	private GoodsService goodsService;
	
	@Resource
	private ActivitiesService activitiesService;
	
	@Resource
	private CompusActivityService compusActivityService;
	
	@Resource
	private CouponService couponService;
	
	@Override
	protected String genContent(Map<String, String> inputParams, ApplicationContext context) {
		String fromUser = inputParams.get(MsgKey.KEY_FROMUSER);
		
		String respContent="";
		String requestMsg = inputParams.get(MsgKey.KEY_CONTENT);
		LOG.info(requestMsg);
		
		if(requestMsg.contains("抵用券") || requestMsg.contains("抵用卷")|| requestMsg.contains("抵用劵")){
			respContent = getVoucher(inputParams,Constant.COUPON_DYQ);
			return respContent;
		}
		
		if(requestMsg.contains("客服电话")){
			respContent = "天地华宇客服热线：400-808-6666/::)";
			return respContent;
		}
		
		if(requestMsg.contains("我要发货") || requestMsg.contains("下单发货")||requestMsg.contains("发货") || requestMsg.contains("下单")){
			respContent = "<a href='https://open.weixin.qq.com/connect/oauth2/authorize?appid=wxc6ab6f92d2623669&redirect_uri=http://wechat.hoau.net/wechat/order.action?response_type=code&scope=snsapi_base&state=1#wechat_redirect'>立刻下单/::)</a>";
			return respContent;
		}
		
		//中奖信息
		if(requestMsg.contains("优惠券") ||requestMsg.contains("优惠卷") ||requestMsg.contains("优惠劵") || requestMsg.contains("中奖信息") || requestMsg.contains("中奖") || requestMsg.contains("奖品") ){
			respContent = lotteryResult(inputParams);
			return respContent;
		}
		
		/*//校园托运活动
		if(requestMsg.contains("天地华宇校园托运")){// || requestMsg.contains("校园托运") || requestMsg.contains("华宇托运")){
			if(TimeUtil.daysBetween(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()), "2015-07-16 00:00:00")<0){
				respContent = "校园托运活动已经结束!/::)";
			}else{
				respContent = compusActivityService.gainCompetitionCode(inputParams);
			}
			return respContent;
		}
		
		if((requestMsg.length()==6) && ("h".equals(requestMsg.substring(0, 1).toLowerCase()))){
			if(TimeUtil.daysBetween(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()), "2015-07-16 00:00:00")<0){
				respContent = "校园托运活动已经结束!/::)";
			}else{
				respContent = compusActivityService.statisticsActivityCode(inputParams);
			}
			return respContent;
		}
		if((requestMsg.length()==12) && ("hoauxyty".equals(requestMsg.substring(0, 8).toLowerCase()))){
			compusActivityService.updateActivityTicket(inputParams);
			respContent = requestMsg+" 已标记使用!/::)";
			return respContent;
		}*/
	
		//如果输入运单，运单查询
		String wayBill = extractWaybill(requestMsg);
		
		if(StringUtil.isEmpty(wayBill)){
			respContent = CoreService.genTip();
			return respContent; 
		}
		try {
			respContent = queryTraceInfo(wayBill, goodsService,fromUser);
		} catch (Exception e) {
			respContent = "跟踪信息不存在，请检查运单号是否输入有误！/::)";
		}
		return respContent;
	}

	/** 
	* @Title: getVoucher 
	* @Description: 返回一张10元优惠券 
	* @param inputParams
	* @param @return    设定文件 
	* @return String    返回类型 
	* @throws 
	*/
	private String getVoucher(Map<String, String> inputParams,String type) {
		String respContent;
		String openId = inputParams.get(MsgKey.KEY_FROMUSER);
		Vouchers vouchers = null;
		try {
			//按原来处理 本地数据库  20150605  3411张未使用
//			vouchers  = activitiesService.getVouchers(openId,type);
			//到迪辰获取优惠券 20150526
			vouchers = couponService.gainVouchers(openId, type);
		} catch (Exception e) {
			respContent = e.getMessage();
			return respContent;
		}
		if(vouchers != null){
			respContent = "微信专享抵用券（ΦωΦ）\r\n"+
			"抵用券代码["+vouchers.getVouchersCode()+"]\r\n"+
			"使用说明：\r\n"+
			"1、本优惠券仅适用于天地华宇微信下单业务；\r\n"+
			"2、优惠券仅适用于天地华宇物流服务，并不予兑现。\r\n"+
			"3、在法律允许的范围内，此优惠券使用的最终解释权归天地华宇官方所有。";
		}else{
			respContent = "抵用券已经被抢完啦！！/::'(";
		}
		return respContent;
	}

	/** 
	* @Title: lotteryResult 
	* @Description: 根据用户OPENid 获取中奖记录
	* @param @param inputParams
	* @param @return    设定文件 
	* @return String    返回类型 
	* @throws 
	*/
	private String lotteryResult(Map<String, String> inputParams) {
		String respContent;
		String openId = inputParams.get(MsgKey.KEY_FROMUSER);
		List<LotteryRecord> records = activitiesService.viewLotteryRecord(openId);
		StringBuilder sb = new StringBuilder();
		if(records.size() > 0 && !records.get(0).getDetail().contains("没有中奖记录")){
			sb.append("您获得的奖品：/:handclap").append("\r\n");
			for(LotteryRecord record:records){
				sb.append(record.getDetail()).append("\r\n");
			}
		}else{
			sb.append("本次活动您没有获得奖励!/::'(");
		}
		respContent = sb.toString();
		return respContent;
	}

	/** 
	* @Title: queryTraceInfo 
	* @Description: 查询运单跟踪记录 
	* @param  wayBill
	* @param  goodsTraceService
	* @param  fromUser
	* @param @return    设定文件 
	* @return String    返回类型 
	* @throws 
	*/
	public static String queryTraceInfo(String wayBill,
			IGoodsService goodsTraceService,String fromUser) {
		String respContent;
		GoodsTraceInfo traceInfos = null;//goodsTraceService.queryGoodsTrack(wayBill,fromUser);
		StringBuilder sb = new StringBuilder();
		
		List<TraceInfo> tinfoS = goodsTraceService.trans(traceInfos,true);
		
		for(int i = 0; i <tinfoS.size(); i++ ){
			sb.append(tinfoS.get(i).getTime()+"   \r\n"+tinfoS.get(i).getTraceInfo()).append("\r\n\r\n");
		}
		respContent =  sb.toString();
		return respContent;
	}
	
	
	/** 
	* @Title: extractWaybill 
	* @Description: 从用户传入的字符串中抽取运单信息 
	* @param @param requestMsg
	* @param @return    设定文件 
	* @return String    返回类型 
	* @throws 
	*/
	public static String extractWaybill(String requestMsg) {
		String wayBill = "";
		Pattern p = Pattern.compile("(?<![a-zA-Z])[a-zA-Z]\\d{7}(?!\\d+)|(?<![a-zA-Z\\d])\\d{8,9}(?!\\d+)");
		Matcher m1 = p.matcher(requestMsg);
		if(m1.find()) {
			wayBill = m1.group();
		}
		return wayBill;
	}  
}
