package com.hoau.wechat.utils;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.codehaus.jackson.JsonEncoding;
import org.codehaus.jackson.map.ObjectMapper;

import com.hoau.wechat.exception.BusinessException;

/**
* @ClassName: HttpUtil
* @Description:
* @author hairen.long@hoau.net
* @date 2015年5月23日 下午5:50:49
*/
public class HttpUtil {

	public static String sendPost(String path, String json)
			throws IOException, BusinessException {
		HttpURLConnection conn = null;
		PrintWriter printWriter = null;
		BufferedReader bufferedReader = null;
		StringBuilder resultStr = null;
		try {
			URL url = new URL(path);
			System.out.println("request URL:"+url.toString());
			conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("POST");// 提交模式
			conn.setConnectTimeout(10000);//连接超时 单位毫秒
			conn.setReadTimeout(10000);//读取超时 单位毫秒
			
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

			connet.connect();
			if (connet.getResponseCode() > 300) {
				System.out.println(connet.getResponseCode()+ " " +connet.getResponseMessage());
			}
			buffer = new BufferedReader(new InputStreamReader(connet.getInputStream()));
			result = new StringBuilder();
			String line;

			while ((line = buffer.readLine()) != null) {
				line = new String(line.getBytes(), "utf-8");
				result.append(line);
			}
		} catch (Exception e) {
			e.printStackTrace();
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
