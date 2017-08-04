package com.hoau.wechat.constant;

import java.util.HashMap;
import java.util.Map;

import com.hoau.wechat.utils.MsgUtils;

/** 
* @ClassName  :Constant 
* @Description:常量类
* @author     :xujun cometzb@126.com	
* @date       :2014年4月24日 上午10:29:21 
*  
*/
public class Constant {
	public static final String APPID = "wxc6ab6f92d2623669";
	public static final String APPSECRET = "099d9b44f88ed4697fa589c3c2e02218";
	
	public static final String APPID_TEST = "wxdaefb25fc5cb75a3";
	public static final String APPSECRET_TEST = "f46550b09246feaff14cd02044650a50";
	
	public static final String URL = "http://wechat.hoau.net/wechat/WeChatServlet";
	public static final String TOKEN = "2OQ60NHWFGy3cvRI2WJlhUlx9y9QXQv0";
	
	public static final String OPEN_ID_KEY = "openId";
	
	public static final String URL_INC_INTRODUCE = "http://wechat.hoau.net/wechat/pages/inc_introduce.jsp";
	
	public static final String URL_ACTIVE_INFO = "http://wechat.hoau.net/wechat/pages/active_info.jsp";
	
	public static final String URL_DRD_INTRODUCE = "http://wechat.hoau.net/wechat/pages/drd_introduce.jsp";
	
	public static final String URL_LD_INTRODUCE = "http://wechat.hoau.net/wechat/pages/ld_introduce.jsp";
	
	/**
	 * 关键词
	 */
	/**  易到家  */
	public static final String YDJ="易到家";
	
	/**  京东家装节活动  */
	public static final String JD_JZJ_ACTIVE = "京东家装节";
	/** 推送屏保信息 */
	public static final String SEND_SCREENSAVER_MPNEW =  "推送屏保";
	
	
	
	// 从慧聪页面上的链接跳转到下单界面，需要对reffer 进行判断。
	public static final String HC_REFFER_URL = "";
	
	// 通过经纬度查询附近网点的数量
	public static final int QUERY_DEPARTMENT_NUM = 5;
	// 表示按照距离范围过滤
	public static final String DIS = "dis";
	// 表示按照返回结果数量过滤
	public static final String LIM = "lim";
	// 链接类型  电话
	public static final int LINK_TYPE_TEL = 0;
	// 链接类型  网站
	public static final int LINK_TYPE_URL = 1;
	// 官网地址
	public static final String OFFICIAL_NET_ADDRESS = "http://hoau.net/";
	//优惠券  对应DC APPID 
	public static final String COUPON_DC_APPID = "HOAUWECHAT";
	
	/**
	 * 微信订单来源 代码
	 */
	public static final String ORDERORIGN = "WECHAT";
	
	//优惠券类型
	/**  新用户关注 发送“抵用券”送优惠券  */
	public static final String COUPON_DYQ = "HDLX140813";
	
	/**  易到家 优惠券  */
	public static final String COUPON_YDJ = "YDJ150328";
	
	/**  定日达抽奖  */
	public static final String COUPON_DRD_LUCKDRAW = "WBLD20150625";
	
	/**  整车送优惠券  */
	public static final String COUPON_ZC = "WBSVZC150707";
	
	/**  其他类型送优惠券  */
	public static final String COUPON_OTHER = "WBSVOT150707";
	
	/**  京东家装节优惠券  */
	public static final String JD_JZJ_ACTIVE_TYPE = "JD_JZJ";
	
	// 官网地址
	public static final String HOTLINE = "4008086666";
	// 
	public static final String NOTICE_MSG = "更多网点信息请登陆天地华宇官网"+
			MsgUtils.toHyperlink(OFFICIAL_NET_ADDRESS,OFFICIAL_NET_ADDRESS, LINK_TYPE_URL)+
			"或垂询客服热线"+HOTLINE+"。";
	
	// 联系人类型 发货人
	public static final int CONTACTS_TYPE_SEND = 0;
	// 联系人类型 收货人
	public static final int CONTACTS_TYPE_RECEIVER = 1;
	// 公司介绍 
	public static final String EVENT_KEY_INC_INTRODUCTION = "KEY_INC_INTRODUCTION";
	// 历史运单查询
	public static final String EVENT_KEY_HIS_WAYBILL_QUERY = "KEY_HIS_WAYBILL_QUERY";
	// 产品服务
	public static final String EVENT_KEY_PRODUCT_SERVICE= "KEY_PRODUCT_SERVICE";
	// 公司及产品
	public static final String EVENT_KEY_INC_PRODUCT= "KEY_INC_PRODUCT";
	
	
	public static final String SUBSCRIBE= "subscribe";
	
	public static final String UNSUBSCRIBE= "unsubscribe";
	// 活动信息
	public static final String EVENT_KEY_ACTIVE_INFO = "KEY_ACTIVE_INFO";
	//查询订单日期天数
	public static final Map<String,Integer> QUERY_ORDER_DAYS = new 	HashMap<String, Integer>(){
		private static final long serialVersionUID = -6116478682538351212L;
		{
			put("oneWeek",7);
			put("oneMonth",30);
			put("threeMonth",90);
		}
	};
	
	public static final Map<String, String> msgTemplate = new HashMap<String, String>();
	static{
		msgTemplate.put("A01", "在[{0}]进行收件扫描");
		msgTemplate.put("A02", "在[{0}]进行录单");
		msgTemplate.put("A03", "在[{0}]办理托运");
		msgTemplate.put("A04", "撤销运单");
		msgTemplate.put("B04", "到达[{0}]分拨中心，完成卸车扫描");
		msgTemplate.put("C01", "完成装车扫描，离开[{0}]分拨中心，前往[{1}]");
		msgTemplate.put("C02", "完成装车扫描，离开[{0}]分拨中心，前往[{1}]中转");
		msgTemplate.put("C03", "离开[{0}]，前往[{1}]");
		msgTemplate.put("C04", "离开[{0}]，前往[{1}]中转");
		msgTemplate.put("D01", "运输车辆抵达[{0}]");
		msgTemplate.put("D02", "运输车辆抵达[{0}]");
		msgTemplate.put("D03", "到达[{0}]");
		msgTemplate.put("D04", "到达[{0}]分拨中心，完成卸车扫描");
		msgTemplate.put("E04", "到达[{0}]");
		msgTemplate.put("D05", "取消发车");
		msgTemplate.put("F03", "在[{0}]办理提货，收货人已签收");
		msgTemplate.put("F04", "在[{0}]进行派送，收货人已签收");
	}
	
	public static final Map<String, Integer> paramNum = new HashMap<String, Integer>();
	static{
		paramNum.put("A01", 1);
		paramNum.put("A02", 1);
		paramNum.put("A03", 1);
		paramNum.put("A04", 0);
		paramNum.put("B04", 1);
		paramNum.put("C01", 2);
		paramNum.put("C02", 2);
		paramNum.put("C03", 2);
		paramNum.put("C04", 2);
		paramNum.put("D01", 1);
		paramNum.put("D02", 1);
		paramNum.put("D03", 1);
		paramNum.put("D04", 1);
		paramNum.put("E04", 1);
		paramNum.put("D05", 0);
		paramNum.put("F03", 1);
		paramNum.put("F04", 1);
	}
	
	public static final String[] NOTWINNINGTIPS = new String[]{"谢谢您！","祝您好运！"};
	
}


