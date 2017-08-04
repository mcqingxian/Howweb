package com.hoau.wechat.service.msgHandler;

import java.io.IOException;
import java.net.SocketTimeoutException;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import net.sf.json.JSONObject;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.conn.HttpHostConnectException;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.CoreConnectionPNames;
import org.apache.http.util.EntityUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import com.hoau.wechat.constant.Constant;
import com.hoau.wechat.exception.BusinessException;
import com.hoau.wechat.service.IDepartmentService;
import com.hoau.wechat.util.JsonUtils;
import com.hoau.wechat.vo.DepartmentListVO;

/** 
* @ClassName  :LocationMsgHandler 
* @Description:处理客户发送上来的位置信息，返回该位置附近的网点列表
* @author     :xujun cometzb@126.com	
* @date       :2014年5月9日 下午2:15:37 
*  
*/
@Service
public class LocationMsgHandler extends AbstractResponseText {

	@Resource
	private IDepartmentService departmentService;
	
	/**
	 * 百度接口
	 */
	public static String BASE_URL = "https://api.map.baidu.com/geocoder/v2/?";
	/**
	 * 连接超时时间
	 */
	private static final int CONNECTION_TIME_OUT = 1000 * 30;
	/**
	 * 返回超时时间
	 */
	private static final int RESPONSE_TIME_OUT = 1000 * 60;
	
	@Override
	public String genContent(Map<String, String> inputParams, ApplicationContext context) {
		String respContent;
		//经度
		String lon = inputParams.get("Location_Y");
		//纬度
		String lat = inputParams.get("Location_X");
		
		LOG.info("lon:"+lon);
		LOG.info("lon:"+lat);
		String[] p = getPCCData(lon,lat);
		if(p == null)
			return "您好！当前位置没有网点信息。\n"+Constant.NOTICE_MSG;
//		String jsonStr = departmentService.queryDepartmentByTude(lon, lat, Constant.LIM, String.valueOf(Constant.QUERY_DEPARTMENT_NUM));
		String jsonStr = departmentService.queryDepartmentByTude(p[0],p[1],p[2],lon, lat, Constant.LIM, String.valueOf(Constant.QUERY_DEPARTMENT_NUM));
		
		List<DepartmentListVO> departmentListActions = JsonUtils.toList(jsonStr, DepartmentListVO.class);
		
		StringBuilder sb = new StringBuilder();
		for(DepartmentListVO departmentListVO : departmentListActions){
			String name = departmentListVO.getName();
			String distance = departmentListVO.getDirectDistance();
			String subDistance  = distance.substring(0, distance.indexOf('.')+3);
			String address = departmentListVO.getAddress();
			String phoneStr = departmentListVO.getTelephone();
			String phone = "";
			if(phoneStr.length() > 0){
				phone = phoneStr.charAt(0) == '-'?phoneStr.substring(1):phoneStr;
			}
			String businessType = departmentListVO.isDDAvailable()?"定日达、零担":"零担";
			sb.append(name).append("\r\n")
			.append("直线距离：").append(subDistance).append("千米").append("\r\n")
			.append("地址：").append(address).append("\r\n")
			.append("电话：").append(phone).append("\r\n")
			.append("业务范围：").append(businessType).append("\r\n\r\n");
			
		}
		sb.append(Constant.NOTICE_MSG);
		respContent = sb.toString();
		return respContent;
	}
	
	private String[] getPCCData(String lon,String lat){
		String rs = getData("ak=GKpF5kBmwGGcVRGgBzUe5AvE&location="+lat+","+lon+"&output=json&pois=0");
		if (rs != null) {
			JSONObject jsonObject = JSONObject.fromObject(rs);
			//0表示正常
		   if(jsonObject.get("status").toString().equals("0")){
	        	String province = jsonObject.getJSONObject("result").getJSONObject("addressComponent").get("province").toString();
	        	String city = jsonObject.getJSONObject("result").getJSONObject("addressComponent").get("city").toString();
	        	String district = jsonObject.getJSONObject("result").getJSONObject("addressComponent").get("district").toString();
	        	return new String[]{province,city,district};
	        }
		}
		return null;
	}
	
	public String getData(String url){
		String result = null;
		HttpGet httpGet = new HttpGet(BASE_URL + url);
		LOG.info(BASE_URL + url);
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
				LOG.info(result);
				return result;
			} else {
				LOG.error("请求错误" + statusCode);
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
}
