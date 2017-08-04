package com.hoau.wechat.cxt;

import java.io.IOException;

import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import com.hoau.wechat.constant.OMSConstants;
import com.hoau.wechat.exception.BusinessException;


public class HttpInvoke {
	public static String getMethod(String url){
		String rtn = null;
		CloseableHttpClient client = null;
		try {
			client = HttpClients.createDefault();
			HttpGet httpGet = new HttpGet(url);
			httpGet.setHeader("Accept-Charset", OMSConstants.CHARSET);
			httpGet.setHeader("Accept", OMSConstants.APPLICATION_JSON);
			CloseableHttpResponse response = client.execute(httpGet);
			int statusCode = response.getStatusLine().getStatusCode();
			System.out.println(statusCode);
			if(statusCode != HttpStatus.SC_OK){
				throw new BusinessException("服务调用异常");
			}
			rtn = EntityUtils.toString(response.getEntity());
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally{
			if(client != null){
				try {
					client.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return rtn;
	}
	
	
	public static String postMethod(String url,String string){
		String rtn = null;
		CloseableHttpClient client = null;
		try {
			client = HttpClients.createDefault();
			HttpPost post = new HttpPost(url);
			post.setHeader("Content-Type", "application/json");
			StringEntity entity = new StringEntity(string);
			post.setEntity(entity);
			CloseableHttpResponse response = client.execute(post);
			rtn = EntityUtils.toString(response.getEntity());
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally{
			if(client != null){
				try {
					client.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return rtn;
	}
	
	public static void main(String[] args) {
		String s = postMethod("http://10.39.107.87:8080/WMS/wechatService/modifyOrder","test");
		System.out.println(s);
	}
	
}
