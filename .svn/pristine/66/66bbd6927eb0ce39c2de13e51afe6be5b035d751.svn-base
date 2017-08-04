package com.hoau.wechat.service.msgHandler;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.xml.bind.JAXBException;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import com.hoau.wechat.constant.Constant;
import com.hoau.wechat.constant.MsgKey;
import com.hoau.wechat.dao.IConfigureDao;
import com.hoau.wechat.dao.ILotteryRecordDao;
import com.hoau.wechat.dao.IWayBillInfoDao;
import com.hoau.wechat.exception.BusinessException;
import com.hoau.wechat.exception.XmlTranslateException;
import com.hoau.wechat.service.impl.CouponService;
import com.hoau.wechat.service.impl.GoodsService;
import com.hoau.wechat.service.impl.PhoneBindService;
import com.hoau.wechat.util.JaxbUtil;
import com.hoau.wechat.util.StringUtil;
import com.hoau.wechat.utils.MsgUtils;
import com.hoau.wechat.utils.TimeUtils;
import com.hoau.wechat.vo.Configure;
import com.hoau.wechat.vo.UserInfo;
import com.hoau.wechat.vo.WayBillInfoEntity;
import com.hoau.wechat.weixin.msg.response.Article;
import com.hoau.wechat.weixin.msg.response.ArticleList;
import com.hoau.wechat.weixin.msg.response.ResNewsMsg;
import com.hoau.wechat.weixin.msg.response.ResTextMsg;
import com.hoau.wechat.ws.waybill.QuerySignInfoServices;
import com.hoau.wechat.ws.waybill.WaybillInfo;

/**
* @ClassName: WayBillMsgHandler
* @Description: 运单处理
* @author hairen.long@hoau.net
* @date 2015年5月31日 下午7:04:36
*/
@Service
public class WayBillMsgHandler implements IMsgHandler{
	
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	
	@Resource
	private GoodsService goodsService;
	
	@Resource
	private CouponService couponService;
	
	@Resource
	private PhoneBindService phoneBindService;
	
	@Resource
	private ILotteryRecordDao lotteryRecordDao;
	
	@Resource
	private IWayBillInfoDao wayBillInfoDao;
	
	@Resource
	private IConfigureDao configureDao;
	
	@Override
	public String handleMsg(Map<String, String> inputParams, ApplicationContext context)
			throws BusinessException {
		String respContent = "";
		//请求消息信息
		String fromUser = inputParams.get(MsgKey.KEY_FROMUSER);
		String requestMsg = inputParams.get(MsgKey.KEY_CONTENT);
		String wayBill = TextMsgHandler.extractWaybill(requestMsg);
		String traceInfo = "";
		try {
			traceInfo = TextMsgHandler.queryTraceInfo(wayBill, goodsService,fromUser);
		} catch (Exception e) {
			traceInfo = "跟踪信息不存在，请检查运单号是否输入有误！/::)";
		}
		//验证是否有抽奖资格
		int result = hasQualification(fromUser,wayBill,context);
		
		//1 没有绑定手机号  2 满足定日达抽奖  3 不满足定日达抽奖或已抽过奖
		if(2==result){//定日达
			//返回消息信息
			ResNewsMsg newsMsg = new ResNewsMsg();
			newsMsg.setToUserName(inputParams.get(MsgKey.KEY_FROMUSER));  
			newsMsg.setFromUserName(inputParams.get(MsgKey.KEY_TOUSER));  
			newsMsg.setCreateTime(new Date().getTime());  
			newsMsg.setMsgType(MsgUtils.RESP_MESSAGE_TYPE_NEWS);  
			List<Article> articles = new ArrayList<Article>();
			//定日达抽奖
			Article inc = new Article();
			inc.setTitle("定日达运单抽奖");
			inc.setDescription("天地华宇微信公众号支持定日达运单抽奖,优惠券可到【华宇助手】->【我的优惠券】查看");
			
			inc.setPicUrl("https://mmbiz.qlogo.cn/mmbiz/Blr7KsGiaAsh7Y6kaASXGmrhHtt9O4laicR8W61mzEtdXcc3QC8J8MOWvpUPlZNptMH7N9XickibMG2ZM4nhucefXg/0?wxfmt=png");
			inc.setUrl("https://open.weixin.qq.com/connect/oauth2/authorize?appid=wxc6ab6f92d2623669&redirect_uri=http://wechat.hoau.net/wechat/anniversaryActivityAction.action?waybill="+wayBill+"&response_type=code&scope=snsapi_base&state=1#wechat_redirect");
			
			//test
//			inc.setUrl("https://open.weixin.qq.com/connect/oauth2/authorize?appid=wxc6ab6f92d2623669&redirect_uri=http://testoms.hoau.net/wechat/anniversaryActivityAction.action?waybill="+wayBill+"&response_type=code&scope=snsapi_base&state=1#wechat_redirect");
		
			articles.add(inc);
			ArticleList articleList = new ArticleList();
			articleList.setItem(articles);
			newsMsg.setArticleCount(articles.size());
			newsMsg.setArticle(articleList);
			
			try {
				respContent = JaxbUtil.marshToXmlBinding(ResNewsMsg.class, newsMsg);
			} catch (JAXBException e) {
				throw new  XmlTranslateException("XML转换异常",e);
			}
		}else{
			ResTextMsg textMessage = new ResTextMsg();
			textMessage.setToUserName(inputParams.get("FromUserName"));  
		    textMessage.setFromUserName(inputParams.get("ToUserName"));  
		    textMessage.setCreateTime(new Date().getTime());  
		    textMessage.setMsgType(MsgUtils.RESP_MESSAGE_TYPE_TEXT);  
		    textMessage.setFuncFlag(0); 
		    if(result==0){//不满足抽奖条件
		    	 textMessage.setContent(traceInfo);
		    }else if(result==1){
		    	textMessage.setContent(traceInfo+"\r\n\r\n"+"回复数字 1 有机会获得运费抵用劵/::)");
		    }
		    try {
		    	respContent = JaxbUtil.marshToXmlBinding(ResTextMsg.class, textMessage);
			} catch (JAXBException e) {
				throw new XmlTranslateException("XML转换异常", e);
			}
			
		}
		
		return respContent;
	}
	
	/**
	 * @Title: hasQualification
	 * @Description:
	 * @param wayBill
	 * @return
	 */
	private int hasQualification(String openid,	String wayBill, ApplicationContext context){
		try {
			//是否绑定手机号
			UserInfo userInfo = phoneBindService.findOneUserInfo(openid);
			if(userInfo == null || StringUtil.isEmpty(userInfo.getPhone())){
				return 0;
			}
			
			//查运单  
			QuerySignInfoServices service = (QuerySignInfoServices) context.getBean("wayBillQuery");
			WaybillInfo info = service.queryWaybill(wayBill, userInfo.getPhone());
			//手机号不一致
			if(info.getErrcode() != null){
				return 0;
			}

			if (info != null) {
				//记录
				WayBillInfoEntity wayBillInfo = new WayBillInfoEntity();
				wayBillInfo.setConsignorPhone(info.getTYRSJ());
				wayBillInfo.setOpenid(openid);
				wayBillInfo.setRecordTime(new Date());
				wayBillInfo.setTotalCost(info.getHJJE());
				wayBillInfo.setTransType(info.getCYRQZ());
				wayBillInfo.setWayBill(wayBill);
				wayBillInfo.setOrderSource(info.getDDQD());
				//订单来源
				/**
				 * 1、用户微信绑定手机号跟运单发货人手机号一致； 
				 * 2、运单开单的合计金额大于等于5000，返还抵用劵金额为运费*1%；
				 * 3、运单运输类型：整车
				 */
				if ("整车".equals(info.getCYRQZ()) && info.getHJJE() > 5000.0
						&& TimeUtils.daysBetween(TimeUtils.getFirstDay(), formatDate(info.getTYRQ().split(" ")[0])) > 0  
						&& (wayBillInfoDao.findWayBillInfo(openid, wayBill) == null)) {
					wayBillInfoDao.saveWayBill(wayBillInfo);
					return 1;
				}
				
				/**
				 * 送抵用券
				 * DC验证条件：1、用户微信绑定手机号跟运单发货人手机号一致；
				 * 2、运单开单的合计金额大于等于300；
				 * 3、订单来源为电商订单
				 * {{"400", "400订单"}, {"BRANCH", "网点订单"}, {"TNTMAIL", "TNT订单"}, {"BIG_CUSTOMER", "大客户订单"},
					{"TAOBAO", "淘宝订单"}, {"ALIBABA", "阿里巴巴订单"}, {"NET_ORDER", "华宇网站订单"}, {"MBL_ORDER", "手机订单"},
					{"KINGDEE", "金蝶友商订单"}, {"QQSD", "QQ速递订单"}, {"CLBUS_VIP", "哥伦布付费会员"}, {"CLBUS_MEM", "哥伦布普通会员"},
					{"DESK_ORDER", "桌面华宇订单"}, {"SUNING", "苏宁"}, {"HQP", "华强宝"}, {"TM", "天猫"},{"HCW","慧聪网"}};
				 */
				if(StringUtil.isNotEmpty(info.getDDQD())){
					//判断是否在活动时间
					Configure configure = configureDao.findConfigure(info.getDDQD(), "orderSource");
					//结束时间大于当前时间
					if(configure != null &&	sdf.parse(sdf.format(configure.getEndTime())).getTime() > TimeUtils.getCurrentTimeMillis()){
						
						if(info.getHJJE() > 300.0 
								&& TimeUtils.daysBetween(TimeUtils.getFirstDay(), formatDate(info.getTYRQ().split(" ")[0])) > 0  
								&& "Y".equals(configure.getActive())
								&& (wayBillInfoDao.findWayBillInfo(openid, wayBill) == null)){
							wayBillInfoDao.saveWayBill(wayBillInfo);
							return 1;
						}
					}
				}
				
				/**
				 * 验证定日达 抽奖
				 * DC验证条件：1、该运单为定日达运单；2、运单开单日期为抽奖当月；3、运单开单的合计金额大于等于300
				 * 			    每个运单仅有一次抽奖机会，抽奖手机号和发货人手机号一致
				 */
				String tyrqStr = info.getTYRQ().split(" ")[0];
				int month = getMonth(tyrqStr);
				if("定日达".equals(info.getCYRQZ()) //定日达
//						&& TimeUtils.daysBetween(TimeUtils.getFirstDay(),  (info.getTYRQ().split(" ")[0])) > 0  //开单日期为当月
						&& (month >= 6 && month <= 9)
						&& info.getHJJE() > 300.0 //合计金额大于300
						&& !couponService.hasWayBillLuckdraw(openid, Constant.COUPON_DRD_LUCKDRAW, wayBill)){  //没有抽过奖
					wayBillInfoDao.saveWayBill(wayBillInfo);
					return 2;
				}
			}
			
			return 0;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	private static int getMonth(String dateStr) {
		int month = 0;
		try{
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
			Date date = sdf.parse(dateStr);
			month = date.getMonth() + 1;
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return month;
	}
	
	private static String formatDate(String date){
		String result = null;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
			SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
			result = sdf1.format(sdf.parse(date));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public static void main(String[] args) throws Exception{
		SimpleDateFormat ff = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		System.out.println(ff.parse("2015/07/28 22:12:21"));
		System.out.println(ff.parse("2015/07/28 22:12:21").getTime());
		System.out.println(ff.parse("2015/07/28 02:12:21").getTime()>TimeUtils.getCurrentTimeMillis());
	}
}
