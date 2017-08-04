package com.hoau.wechat.util.net;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ConnectException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.hoau.wechat.constants.Constant;
import com.hoau.wechat.util.JsonUtils;

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
	
	private static AccessToken queryAT(){
		String str = httpRequest("https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid="+Constant.APPID+"&secret="+Constant.APPSECRET,"GET",null);
		AccessToken accessToken = JsonUtils.toObject(str, AccessToken.class);
		return accessToken;
	}
}

