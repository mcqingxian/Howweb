package com.hoau.how.module.util.net;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

import com.hoau.how.module.common.constants.ItfConifgConstant;

public class NetUtil {
	private static final String URLSTR = ItfConifgConstant.CLAIM_COMPANY;

	/**
	 * 给服务端发送一个对象返回服务端返回的对象.
	 * 
	 * @param servletConn
	 * @param _obj
	 *            客户端发送出去的对象
	 * @return 服务端返回的对象
	 * @throws Exception
	 */
	public static Object sendObjToServer(Object _obj) throws Exception {
		URL servletURL = new URL(URLSTR);
		URLConnection servletConn = servletURL.openConnection();
		servletConn.setDoInput(true);
		servletConn.setDoOutput(true);
		servletConn.setUseCaches(false);
		servletConn.setDefaultUseCaches(false);
		servletConn.setRequestProperty("Content-type",
				"application/octet-stream");
		// 发送对象
		ObjectOutputStream objOut = new ObjectOutputStream(
				servletConn.getOutputStream());
		objOut.writeObject(_obj);
		objOut.flush();
		objOut.close();
		System.out.println("请求已发出！(" + servletConn.getURL() + ",_obj=" + _obj);
		// 接收对象
		Object objIn = null;
		InputStream instr = servletConn.getInputStream();
		ObjectInputStream inputFromServlet = new ObjectInputStream(instr);
		objIn = inputFromServlet.readObject();
		System.out.println("得到反馈是：" + objIn);
		inputFromServlet.close();
		instr.close();
		return objIn;
	}

	public static final String httpUrl = "http://apis.baidu.com/datatiny/cardinfo/cardinfo";
	/**
	 * 调用百度API获取银行卡所在地
	 * @param urlAll
	 *            :请求接口
	 * @param httpArg
	 *            :参数
	 * @return 返回结果
	 */
	public static String requestBaiDuApi(String httpArg) {
	    BufferedReader reader = null;
	    String result = null;
	    StringBuffer sbf = new StringBuffer();
	    try {
	        URL url = new URL(httpUrl + "?" + httpArg);
	        HttpURLConnection connection = (HttpURLConnection) url
	                .openConnection();
	        connection.setRequestMethod("GET");
	        // 填入apikey到HTTP header
	        connection.setRequestProperty("apikey",  "6a5a9afaf48bd6badcca5891f3df476b");
	        connection.connect();
	        InputStream is = connection.getInputStream();
	        reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
	        String strRead = null;
	        while ((strRead = reader.readLine()) != null) {
	            sbf.append(strRead);
	            sbf.append("\r\n");
	        }
	        reader.close();
	        result = sbf.toString();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return result;
	}
}
