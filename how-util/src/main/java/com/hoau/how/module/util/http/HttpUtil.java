package com.hoau.how.module.util.http;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @author 莫涛
 * @date 2015年5月26日
 */
public class HttpUtil {
	private String baseUrl;
	
	public HttpUtil(String baseUrl) {
		this.baseUrl = baseUrl;
	}
	
	public String post(String json,String path) {
		HttpURLConnection conn = null;
		PrintWriter printWriter = null;
		BufferedReader bufferedReader = null;
		StringBuilder resultStr = null;
		try {
			URL url = new URL(baseUrl+path);
			conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("POST");// 提交模式
			conn.setConnectTimeout(10000);//连接超时 单位毫秒
			conn.setReadTimeout(2000);//读取超时 单位毫秒
			conn.setDoOutput(true);// 是否输入参数
			conn.setDoInput(true);
			conn.setRequestProperty("Content-Type", "application/json;charset=UTF-8");
			conn.setRequestProperty("accept", "*/*");
			printWriter = new PrintWriter(conn.getOutputStream());  
            printWriter.write(json);  
            printWriter.flush();  
            int responseCode = conn.getResponseCode();  
            if (responseCode != HttpURLConnection.HTTP_OK) {  
            	System.out.println(" Error===" + responseCode);
            } else {  
            	System.out.println("Post Success!");
            }  
            bufferedReader = new BufferedReader(new InputStreamReader(  
                    conn.getInputStream(),"UTF-8"));  
            String line;  
            resultStr = new StringBuilder();
            while ((line = bufferedReader.readLine()) != null) {  
            	resultStr.append(line);  
            } 
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("请求异常");
		} finally{
			conn.disconnect();  
            try {  
                if (printWriter != null) {  
                    printWriter.close();  
                }  
                if (bufferedReader != null) {  
                    bufferedReader.close();  
                }  
            } catch (IOException ex) {  
                ex.printStackTrace();  
            }  
		}
		return resultStr.toString();
	}
	
	public static String httpGet(String path) throws IOException {
		StringBuilder result = null;
		BufferedReader buffer = null;
		HttpURLConnection connet = null;
		try {
			URL url = new URL(path);
			connet = (HttpURLConnection) url.openConnection();
			connet.setRequestProperty("Content-Type", "application/json;charset=UTF-8");
			connet.setRequestProperty("accept", "*/*");

			connet.connect();
			if (connet.getResponseCode() > 300) {
				System.out.println(connet.getResponseCode()+ " " +connet.getResponseMessage());
				throw new RuntimeException("请求异常");
			}
			buffer = new BufferedReader(new InputStreamReader(connet.getInputStream()));
			result = new StringBuilder();
			String line;

			while ((line = buffer.readLine()) != null) {
				line = new String(line.getBytes(), "utf-8");
				result.append(line);
			}
		} catch (Exception e) {
			throw new RuntimeException("请求异常");
		}finally{
			if(buffer != null){
				buffer.close();
			}
			if(connet != null){
				connet.disconnect();
			}
		}
		return result.toString();
	}
}
