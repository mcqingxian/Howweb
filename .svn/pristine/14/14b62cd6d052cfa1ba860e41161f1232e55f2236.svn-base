package com.hoau.wechat.utils.net;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ConnectException;
import java.net.URL;
import java.net.URLEncoder;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.ServletActionContext;

import com.hoau.wechat.constant.Constant;
import com.hoau.wechat.exception.OpenIdNotNullException;
import com.hoau.wechat.util.JsonUtils;
import com.hoau.wechat.util.StringUtil;
import com.hoau.wechat.utils.AuthUtil;
import com.hoau.wechat.vo.AccessToken;
import com.hoau.wechat.vo.OpenIdReturn;
import com.hoau.wechat.vo.Tickect;
import com.hoau.wechat.vos.templates.Field;
import com.hoau.wechat.vos.templates.data.DelivData;
import com.hoau.wechat.vos.templates.tmp.Template;

/** 
* @ClassName  :WeixinUtil 
* @Description:微信接口相关网络类
* @author     :xujun cometzb@126.com	
* @date       :2014年4月24日 上午10:29:43 
*  
*/
public class WeixinUtil {
	private static final Log log = LogFactory.getLog(WeixinUtil.class);
	private static String ACCESS_TOKEN = null;

	public static void genQrCode(int scene_id){
		String str = httpRequest("https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid="+Constant.APPID+"&secret="+Constant.APPSECRET,"GET",null);
		AccessToken accessToken = JsonUtils.toObject(str, AccessToken.class);
		System.out.println("access_token -> "+accessToken.getAccessToken());
		System.out.println("expires_in -> "+accessToken.getExpiresIn());
		
		// 创建二维码ticket接口
		String createUrl = "https://api.weixin.qq.com/cgi-bin/qrcode/create?access_token="+accessToken.getAccessToken();
		String postParam = "{\"action_name\": \"QR_LIMIT_SCENE\", \"action_info\": {\"scene\": {\"scene_id\": "+scene_id+"}}}";
		String createResult = httpRequest(createUrl, "POST", postParam);
		System.out.println(createResult);
		
		Tickect tickect = JsonUtils.toObject(createResult, Tickect.class);
		String tickectStr = tickect.getTicket();
		// 用  （tickectStr）换取二维码
		System.out.println("tickectStr:"+tickectStr);
		
		String encode = URLEncoder.encode(tickectStr);
		System.out.println(encode);
	}
	
	public static String httpRequest(String requestUrl, String requestMethod,
			String outputStr) {
		// JSONObject jsonObject = null;
		StringBuffer buffer = new StringBuffer();
		try {
			// 创建SSLContext对象，并使用我们指定的信任管理器初始化
			TrustManager[] tm = { new MyX509TrustManager() };
			SSLContext sslContext = SSLContext.getInstance("SSL", "SunJSSE");
			sslContext.init(null, tm, new java.security.SecureRandom());
			// 从上述SSLContext对象中得到SSLSocketFactory对象
			SSLSocketFactory ssf = sslContext.getSocketFactory();
			URL url = new URL(requestUrl);
			HttpsURLConnection httpUrlConn = (HttpsURLConnection) url
					.openConnection();
			httpUrlConn.setSSLSocketFactory(ssf);
			httpUrlConn.setDoOutput(true);
			httpUrlConn.setDoInput(true);
			httpUrlConn.setUseCaches(false);
			// 设置请求方式（GET/POST）
			httpUrlConn.setRequestMethod(requestMethod);
			if ("GET".equalsIgnoreCase(requestMethod))
				httpUrlConn.connect();
			// 当有数据需要提交时
			if (null != outputStr) {
				OutputStream outputStream = httpUrlConn.getOutputStream();
				// 注意编码格式，防止中文乱码
				outputStream.write(outputStr.getBytes("UTF-8"));
				outputStream.close();
			}
			// 将返回的输入流转换成字符串
			InputStream inputStream = httpUrlConn.getInputStream();
			InputStreamReader inputStreamReader = new InputStreamReader(
					inputStream, "utf-8");
			BufferedReader bufferedReader = new BufferedReader(
					inputStreamReader);
			String str = null;
			while ((str = bufferedReader.readLine()) != null) {
				buffer.append(str);
			}
			bufferedReader.close();
			inputStreamReader.close();
			// 释放资源
			inputStream.close();
			inputStream = null;
			httpUrlConn.disconnect();
			// jsonObject = JSONObject.fromObject(buffer.toString());
		} catch (ConnectException ce) {
			log.error("Weixin server connection timed out.");
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e);
		}
		return buffer.toString();
	}
	public static void main(String[] args) {
		genMenu();
//		genQrCode(4);
//		sendTemplate();
	}
	
	/**
	 * 
	 * @Title: templateTest 
	 * @Description: TODO 模板消息测试类 
	 * @param     设定文件 
	 * @return void    返回类型 
	 * @throws
	 */
	private static void sendTemplate(){
		String wayBill = "F0713054";
		String openId = "oz4uxjsjLmvQwkdY5kYhNwILhTGE";
		String accessToken = WeixinUtil.queryAccessToken(false);
		Field keyword1 = new Field();
		keyword1.setValue(wayBill);
		keyword1.setColor("#F15A22");
		
		Field keyword2 = new Field();
		keyword2.setValue("172.21元");
		keyword2.setColor("#F15A22");
		
		Field keyword3 = new Field();
		keyword3.setValue("上海市闵行区华翔路2239号");
		keyword3.setColor("#F15A22");
		
		Field remark = new Field();
		keyword3.setValue("请凭证件提货，联系电话：4008086666");
		keyword3.setColor("#B72F26");
		
		Field first = new Field();
		first.setValue("尊敬的客户: \n 您好，您的运单物品已抵达目的地。");
		first.setColor("#000000");
		
		DelivData data = new DelivData(first,keyword1,keyword2,keyword3,remark);
		Template template1Vo = new Template();
		template1Vo.setData(data);
		template1Vo.setTemplate_id("PYLCYw2iLLYKlYLUstzVDvo9qA8Jc5eAWnur9TwSfAw");
		template1Vo.setTopcolor("#FF0000");
		template1Vo.setTouser(openId);
		
		template1Vo.setUrl("http://wechat.hoau.net/wechat/waybillTrace.action?waybill="+ wayBill+"&openId="+openId);
		String json = JsonUtils.toJson(template1Vo);
		System.out.println(json);
		String msg = WeixinUtil.httpRequest("https://api.weixin.qq.com/cgi-bin/message/template/send?access_token="+accessToken, "POST", json);
		System.out.println("------------------");
		System.out.println("------------------");
		System.out.println(msg);
	}
	
	/**
	 * 
	 * @Title: queryAccessToken 
	 * @Description: TODO 
	 * @param @param con 为true则直接重新获取accessToken，否则用之前获取的
	 * @param @return    设定文件 
	 * @return String    返回类型 
	 * @throws
	 */
	public static String queryAccessToken(boolean con){
		String accessToken = "";
		if(ACCESS_TOKEN == null || con){
			accessToken = queryAT().getAccessToken();
			ACCESS_TOKEN = accessToken;
		}else{
			accessToken = ACCESS_TOKEN;
		}
		return accessToken;
	}
	
	public static AccessToken queryAT(){
		String str = httpRequest("https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid="+Constant.APPID+"&secret="+Constant.APPSECRET,"GET",null);
		AccessToken accessToken = JsonUtils.toObject(str, AccessToken.class);
		return accessToken;
	}

	private static void genMenu() {
		String baseUrl = "http://wechat.hoau.net/wechat/";
		//货物追踪  权限
		String goodsTraceUrl = baseUrl+"toGoodsTracePage.action";
		//门店查询 
		String toDepartMentPage = baseUrl+"toDpartQueryPage.action";
		//价格时效  
		String priceTimeUrl = baseUrl+"priceTime.action";
		//我要发货  权限
		String orderUrl = baseUrl+"order.action";
		//地址簿     权限
		String addressBookManageActionUrl = baseUrl+"addressBookManageAction.action";
		//订单管理  权限
		String queryOrder = baseUrl+"queryOrder.action";
		//手机绑定  权限
		String toMobileBindPage = baseUrl+"toMobileBindPage.action";
		//我的优惠券
		String myCouponsManager = baseUrl+"couponManage.action";
		//抽奖活动  权限
//		String lottery = baseUrl+"getLotteryInfo.action";
		//校园托运活动
//		String compusActivity = baseUrl+"campusActivity.action";
		//操作指南
		String guid = "http://mp.weixin.qq.com/s?__biz=MjM5NDAwMDMzNQ==&mid=200220230&idx=1&sn=d049b7705af96469b30b986145a0625c#rd";
		//公司介绍
		//产品服务 
		//活动信息  
		String menuStr = "{\"button\":["
					+ "{\"name\":\"信息查询\",\"sub_button\":["
						+ "{\"type\":\"view\",\"name\":\"运单状态\",\"url\":\""+AuthUtil.genAuthUrl(Constant.APPID, goodsTraceUrl)+"\"},"
						+ "{\"type\":\"click\",\"name\":\"历史查询\",\"key\":\""+Constant.EVENT_KEY_HIS_WAYBILL_QUERY+"\"},"
						+ "{\"type\":\"view\",\"name\":\"门店信息\",\"url\":\""+AuthUtil.genAuthUrl(Constant.APPID, toDepartMentPage)+"\"},"
						+ "{\"type\":\"view\",\"name\":\"价格时效\",\"url\":\""+AuthUtil.genAuthUrl(Constant.APPID, priceTimeUrl)+"\"}"
					+ "]},"
					+ "{\"name\":\"下单发货\",\"sub_button\":["
						+ "{\"type\":\"view\",\"name\":\"我要发货\",\"url\":\""+AuthUtil.genAuthUrl(Constant.APPID, orderUrl)+"\"},"
						+ "{\"type\":\"view\",\"name\":\"地址簿\",\"url\":\""+AuthUtil.genAuthUrl(Constant.APPID, addressBookManageActionUrl)+"\"},"
						+ "{\"type\":\"view\",\"name\":\"订单管理\",\"url\":\""+AuthUtil.genAuthUrl(Constant.APPID, queryOrder)+"\"}"
					+ "]},"
					+ "{\"name\":\"华宇助手\",\"sub_button\":["
						+ "{\"type\":\"view\",\"name\":\"我的优惠券\",\"url\":\""+AuthUtil.genAuthUrl(Constant.APPID, myCouponsManager)+"\"},"
						+ "{\"type\":\"click\",\"name\":\"业务介绍\",\"key\":\""+Constant.EVENT_KEY_INC_PRODUCT+"\"},"
						+ "{\"type\":\"click\",\"name\":\"最新活动\",\"key\":\""+Constant.EVENT_KEY_ACTIVE_INFO+"\"},"
						+ "{\"type\":\"view\",\"name\":\"手机绑定\",\"url\":\""+AuthUtil.genAuthUrl(Constant.APPID, toMobileBindPage)+"\"},"
						//+ "{\"type\":\"view\",\"name\":\"抽奖活动\",\"url\":\""+AuthUtil.genAuthUrl(Constant.APPID, lottery)+"\"},"
//						+ "{\"type\":\"view\",\"name\":\"抽奖活动\",\"url\":\""+AuthUtil.genAuthUrl(Constant.APPID, compusActivity)+"\"},"   //校园托运抽奖活动
						+ "{\"type\":\"view\",\"name\":\"操作指南\",\"url\":\""+guid+"\"}"
					+ "]}"
				+ "]}";		
//		String str = httpRequest("https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid="+Constant.APPID+"&secret="+Constant.APPSECRET,"GET",null);
//		System.out.println("------");
//		System.out.println(str);
//		System.out.println("------");
		//{"access_token":"aTmea8PKL8GvwBu2yE7T6IRsOvbqXfELqIOCbYb49N8gpc8jkme2NE4De31nbXqg","expires_in":7200}
		
		
//		
//		String menuResult = httpRequest("https://api.weixin.qq.com/cgi-bin/menu/create?access_token="+queryAT().getAccessToken(),
//				"POST",
//				menuStr);
//		System.out.println(menuResult);
		System.out.println(menuStr);
	}
	
	public static String getOpenId(String code) {
		String openid = "";
		log.info("code:"+code);
		String url = "https://api.weixin.qq.com/sns/oauth2/access_token?appid="+Constant.APPID+"&secret="+Constant.APPSECRET+"&code="+code+"&grant_type=authorization_code";
		String jsonStr = httpRequest(url, "GET", null);
		log.info("get openid request url:"+url);
		log.info("get openid return json Str:"+jsonStr);
		OpenIdReturn rtn = JsonUtils.toObject(jsonStr, OpenIdReturn.class);
		log.info("openid:"+rtn.getOpenid());
		openid = rtn.getOpenid();
		return openid;
//		return "1234";
	}
	
	public static String getAccessToken() {
		String url = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";
		String jsonStr = httpRequest(url, "GET", null);
		log.info("get openid request url:"+url);
		log.info("get openid return json Str:"+jsonStr);
		OpenIdReturn rtn = JsonUtils.toObject(jsonStr, OpenIdReturn.class);
		log.info("openid:"+rtn.getOpenid());
		return rtn.getOpenid();
//		return "123";
	}
	
	
	public static void setOpenIdToSession(String code) {
		try {
			getOpenIdFromSession();
		} catch (OpenIdNotNullException e) {
			String openId = WeixinUtil.getOpenId(code);
			ServletActionContext.getRequest().getSession().setAttribute(
					Constant.OPEN_ID_KEY, openId);
		}
	}
	
	public static String getOpenIdFromSession(){
		String sessionId = ServletActionContext.getRequest().getSession().getId();
		//log.info("sessionId:"+sessionId);
//		String openId = (String)ServletActionContext.getRequest().getSession().getAttribute(Constant.OPEN_ID_KEY);
		//test
		String openId = "oz4uxjig_7wG45QzJP00oeCFl7Ao";
		//log.info("openId from session:"+openId);
		if(StringUtil.isEmpty(openId)){
			throw new OpenIdNotNullException("openid is null",new Throwable());
		}
		return openId;
	}
}

