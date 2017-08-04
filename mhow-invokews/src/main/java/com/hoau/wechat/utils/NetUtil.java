package com.hoau.wechat.utils;

import java.io.IOException;
import java.net.SocketTimeoutException;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.conn.HttpHostConnectException;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.CoreConnectionPNames;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import com.hoau.wechat.constant.PropertyConstant;
import com.hoau.wechat.dao.IWechatDictionaryDao;
import com.hoau.wechat.exception.BusinessException;

/**
 * @ClassName: NetUtil
 * @Description: 网络请求工具类
 * @author: gaojia
 */
@Component
public class NetUtil /*implements ApplicationContextAware*/ {
	private static Log log = LogFactory.getLog(NetUtil.class);
	/**
	 * 连接超时时间
	 */
	private static final int CONNECTION_TIME_OUT = 1000 * 30;
	/**
	 * 返回超时时间
	 */
	private static final int RESPONSE_TIME_OUT = 1000 * 60;
	/**
	 * 外部系统接口ip
	 */
	public static String BASE_URL = "http://10.39.59.157/";
	@Resource
	private IWechatDictionaryDao wechatDictionaryDao;

	/**
	 * 网络get请求
	 * 
	 * @param url
	 *            请求路径
	 * @return 返回json字符串
	 */

	public static String getData(String url){
		String result = null;
		HttpGet httpGet = new HttpGet(BASE_URL + url);
		log.info(BASE_URL + url);
		HttpClient httpClient = new DefaultHttpClient();
		// 设置连接超时时间
		httpClient.getParams().setParameter(
				CoreConnectionPNames.CONNECTION_TIMEOUT, CONNECTION_TIME_OUT);
		// 设置返回超时时间
		httpClient.getParams().setParameter(CoreConnectionPNames.SO_TIMEOUT,
				RESPONSE_TIME_OUT);
		HttpResponse httpResponse = null;
		try {
			httpResponse = httpClient.execute(httpGet);
			int statusCode = httpResponse.getStatusLine().getStatusCode();
			if (statusCode == HttpStatus.SC_OK) {
			result = EntityUtils
						.toString(httpResponse.getEntity(), "UTF-8");
				log.info(result);
				return result;
			} else {
				log.error("请求错误" + statusCode);
				throw new BusinessException("请求错误" + statusCode,
						new Throwable());
			}
		} catch (ConnectTimeoutException e) {
			e.printStackTrace();
			throw new BusinessException("服务器连接超时", e.getCause());
		} catch (SocketTimeoutException e) {
			e.printStackTrace();
			throw new BusinessException("服务器响应超时", e.getCause());
		} catch (HttpHostConnectException e) {
			e.printStackTrace();
			throw new BusinessException(e.getMessage(), e.getCause());
		} catch (IOException e) {
			e.printStackTrace();
			throw new BusinessException(e.getMessage(), e.getCause());
		}
	}

	/*@Override
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		BASE_URL = PropertyConstant.SERVER_URL;
		log.info(BASE_URL);
	}*/

	public void setWechatDictionaryDao(IWechatDictionaryDao wechatDictionaryDao) {
		this.wechatDictionaryDao = wechatDictionaryDao;
	}
	
	/*public static void main(String[] args) {
	//	https://api.map.baidu.com/geocoder/v2/?ak=GKpF5kBmwGGcVRGgBzUe5AvE&location=39.983424,116.322987&output=json&pois=0
//		NetUtil.BASE_URL = "https://api.map.baidu.com/direction/v1/routematrix?";
//		String rs = getData("output=json&origins=天安门&destinations=北京邮电大学&ak=E4805d16520de693a3fe707cdc962045");
//		System.out.println(rs);
		NetUtil.BASE_URL = "https://api.map.baidu.com/geocoder/v2/?";
		String rs = getData("ak=GKpF5kBmwGGcVRGgBzUe5AvE&location=39.983424,116.322987&output=json&pois=0");
		System.out.println(rs);
	}*/
}
