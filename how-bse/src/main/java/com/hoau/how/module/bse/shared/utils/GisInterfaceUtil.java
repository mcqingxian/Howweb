package com.hoau.how.module.bse.shared.utils;

//import com.hoau.butterfly.module.body.common.shared.define.GisConstants;
//import com.hoau.butterfly.module.body.common.shared.domain.AddressComponent;
//import com.hoau.butterfly.module.body.common.shared.domain.GisInfo;
//import com.hoau.butterfly.module.body.common.shared.domain.ResponseMsg;
//import com.hoau.butterfly.module.body.common.shared.domain.ReverseGeocodingJson;
//import com.hoau.butterfly.module.body.common.shared.dto.BaiduMapDriverDistanceResult;
//import com.hoau.butterfly.module.body.common.shared.exception.GisQueryException;
//import com.hoau.butterfly.module.util.CollectionUtils;
//import com.hoau.butterfly.module.util.LatLngConvertUtil;
import com.hoau.hbdp.framework.exception.BusinessException;
import com.hoau.hbdp.framework.shared.util.JsonUtils;
import com.hoau.hbdp.framework.shared.util.string.StringUtil;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author 唐征征
 * @date 2017/7/26 下午2:05
 * @description Gis接口工具类
 */

public class GisInterfaceUtil {
	public static String url = "http://api.map.baidu.com/direction/v1/routematrix?";

	// 计算行车距离接口每个ak每天只能调用10万次
	public static String[] aks = new String[] {
			"1l9RMdXlnOgdywm7yhlDBgx5", "xVS31eF6Tj519THH1AGfiE5a",
			"7GBLDUarrZ4wqiALak8PCZsA", "8C4AsvLfBRVHwGTajztTM0SG",
			"44x5bagxY2lMgUKyHmlFGo9a", "I7ZOnLOXsW2xfnnDgn8f5zAU",
			"TF33O9pDfy2l1nemw1QEPEWB", "y81mpbAVBjsrWjP8NdsV63AN",
			"iCk4sGrdqmIc26Idha45wsbK", "aN9GltOqtBaGO1ziSnTUnnDf" };

	/**
	 * 根据参数与秘钥生成签名
	 * 
	 * @param params
	 *            参数map
	 * @param secret
	 *            秘钥
	 * @return
	 * @author 唐征征
	 * @date 2015年8月3日
	 * @update
	 */
	public static String sign(Map<String, Object> params, String secret) {
		String result = null;
		if (params == null)
			return result;

		// 将参数按key排序
		Set<String> keys = params.keySet();
		String[] ps = new String[keys.size()];
		int i = 0;
		for (String key : keys) {
			Object value = params.get(key);
			if (value != null) {
				ps[i++] = key + value.toString();
			}
		}
		if (i == 0)
			return result;
		String[] ss = new String[i];
		System.arraycopy(ps, 0, ss, 0, i);
		Arrays.sort(ss);

		// 将secret同时放在头尾，拼成字符串
		StringBuilder orgin = new StringBuilder(secret);
		for (int j = 0; j < ss.length; j++) {
			orgin.append(ss[j]);
		}
		orgin.append(secret);

		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			result = byte2hex(md.digest(orgin.toString().getBytes("utf-8")));
		} catch (Exception ex) {
			throw new RuntimeException("sign error !");
		}
		return result;
	}

	/**
	 * 组装请求参数，返回值为key1=value1&key2=value2形式
	 * 
	 * @param map
	 *            参数map
	 * @return
	 * @author 唐征征
	 * @date 2015年8月3日
	 * @update
	 */
	public static String createGisRequestParam(Map<String, Object> map) {
		StringBuilder param = new StringBuilder();

		for (Iterator<Map.Entry<String, Object>> it = map.entrySet().iterator(); it
				.hasNext();) {
			Map.Entry<String, Object> e = it.next();
			Object value = e.getValue();
			if (value != null) {
				try {
					value = URLEncoder.encode(value.toString(), "UTF-8");
				} catch (UnsupportedEncodingException ex) {
				}
				param.append("&").append(e.getKey()).append("=").append(value);
			}
		}
		return param.toString().substring(1);
	}

	/**
	 * 二进制转字符串
	 * 
	 * @param b
	 * @return
	 * @author 唐征征
	 * @date 2015年8月3日
	 * @update
	 */
	public static String byte2hex(byte[] b) {
		StringBuffer hs = new StringBuffer();
		String stmp = "";
		for (int n = 0; n < b.length; n++) {
			stmp = (Integer.toHexString(b[n] & 0XFF));
			if (stmp.length() == 1)
				hs.append("0").append(stmp);
			else
				hs.append(stmp);
		}
		return hs.toString().toUpperCase();
	}

	public static String httpRequest(String uri, String params) {
		java.net.URL url = null;
		HttpURLConnection connection = null;
		try {
			url = new URL(uri);
			connection = (HttpURLConnection) url.openConnection();
			connection.setDoOutput(true);
			connection.setDoInput(true);
			connection.setRequestMethod("POST");
			connection.setUseCaches(false);
			connection.connect();

			DataOutputStream out = new DataOutputStream(
					connection.getOutputStream());
			out.writeBytes(params);
			out.flush();
			out.close();
			BufferedReader reader = new BufferedReader(new InputStreamReader(
					connection.getInputStream(), "utf-8"));
			StringBuffer buffer = new StringBuffer();
			String line = "";
			while ((line = reader.readLine()) != null) {
				buffer.append(line);
			}
			reader.close();
			return buffer.toString();
		} catch (IOException e) {
			e.printStackTrace();
			throw new BusinessException("GIS系统调用失败");
		} finally {
			if (connection != null) {
				connection.disconnect();
			}
		}
	}

	/**
	 * get请求
	 * 
	 * @param urlStr
	 * @return
	 * @author 唐征征
	 * @date 2015年10月9日
	 * @update
	 */
	public static String httpGet(String urlStr) {
		java.net.URL url = null;
		HttpURLConnection connection = null;
		try {
			url = new URL(urlStr);
			connection = (HttpURLConnection) url.openConnection();
			connection.setDoOutput(true);
			connection.setDoInput(true);
			connection.setRequestMethod("GET");
			connection.setUseCaches(false);
			connection.connect();
			BufferedReader reader = new BufferedReader(new InputStreamReader(
					connection.getInputStream(), "utf-8"));
			StringBuffer buffer = new StringBuffer();
			String line = "";
			while ((line = reader.readLine()) != null) {
				buffer.append(line);
			}
			reader.close();
			return buffer.toString();
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException("网络异常");
		} finally {
			if (connection != null) {
				connection.disconnect();
			}
		}
	}

	/**
	 * 计算行车距离
	 * 
	 * @param startLat
	 *            起始纬度
	 * @param startLng
	 *            起始经度
	 * @param endLat
	 *            结束纬度
	 * @param endLng
	 *            结束经度
	 * @return
	 * @author 唐征征
	 * @date 2015年10月9日
	 * @update
	 */
//	public static Map<String, Object> calculateDriverDistance(Double startLat,
//															  Double startLng, Double endLat, Double endLng) {
//		Map<String, Object> driverDistanceMap = new HashMap<String, Object>();
//		try {
//			Random r = new Random(System.currentTimeMillis());
//			String ak = aks[r.nextInt(aks.length-1)];
//			String origins = startLat + "," + startLng;
//			String destinations = endLat + "," + endLng;
//			// 不走高速
//			String param = "output=json&origins=" + origins + "&destinations="
//					+ destinations + "&ak=" + ak + "&tactics=10";
//			String res = httpGet(url + param);
//			BaiduMapDriverDistanceResult noTopSpeedResult = JsonUtils.toObject(res,
//					BaiduMapDriverDistanceResult.class);
//			// 最少时间
//			String lessTimeParam = "output=json&origins=" + origins
//					+ "&destinations=" + destinations + "&ak=" + ak + "&tactics=11";
//			String lessTimeRes = httpGet(url + lessTimeParam);
//			BaiduMapDriverDistanceResult lessTimeResult = JsonUtils.toObject(
//					lessTimeRes, BaiduMapDriverDistanceResult.class);
//			if (StringUtil.equals("0", noTopSpeedResult.getStatus())
//					&& StringUtil.equals("0", lessTimeResult.getStatus())) {
//				Double noTopSpeed = noTopSpeedResult.getResult().getElements()
//						.get(0).getDistance().getValue();
//				String noTopSpeedText = noTopSpeedResult.getResult().getElements()
//						.get(0).getDistance().getText();
//				Double lesstTime = lessTimeResult.getResult().getElements().get(0)
//						.getDistance().getValue();
//				String lesstTimeText = lessTimeResult.getResult().getElements()
//						.get(0).getDistance().getText();
//				if (noTopSpeed > lesstTime) {
//					driverDistanceMap.put("driverDistance", noTopSpeed);
//					driverDistanceMap.put("driverDistanceText", noTopSpeedText);
//				} else {
//					driverDistanceMap.put("driverDistance", lesstTime);
//					driverDistanceMap.put("driverDistanceText", lesstTimeText);
//				}
//				return driverDistanceMap;
//			}
//			// 如果网络出现问题,以有结果的为准
//			if (StringUtil.equals("0", noTopSpeedResult.getStatus())) {
//				Double noTopSpeed = noTopSpeedResult.getResult().getElements()
//						.get(0).getDistance().getValue();
//				String noTopSpeedText = noTopSpeedResult.getResult().getElements()
//						.get(0).getDistance().getText();
//				driverDistanceMap.put("driverDistance", noTopSpeed);
//				driverDistanceMap.put("driverDistanceText", noTopSpeedText);
//				return driverDistanceMap;
//			}
//			if (StringUtil.equals("0", lessTimeResult.getStatus())) {
//				Double lesstTime = lessTimeResult.getResult().getElements().get(0)
//						.getDistance().getValue();
//				String lesstTimeText = lessTimeResult.getResult().getElements()
//						.get(0).getDistance().getText();
//				driverDistanceMap.put("driverDistance", lesstTime);
//				driverDistanceMap.put("driverDistanceText", lesstTimeText);
//				return driverDistanceMap;
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return driverDistanceMap;
//	}
//
//
//	private static String[] LEVEL_AS = { "省|市|(自治区)", 	"(地区)|(自治州)|(市)|(州^市)|(盟^市)", "区" };
//	private static String[] LEVEL = { "省\\自治区\\(直辖)市", "地区\\盟\\自治州\\(地级)市", "区县" };
//	private static String[] MUNICIPALITY = { "上海市", "北京市", "重庆市", "天津市" };
//
//	private static String URL = "http://api.map.baidu.com/geocoder/v2/?ak=KEY&location=LOACTION&output=json&pois=0";
//	public static boolean checkCrossCity(String lat, String lng, String address ){
//		try {
//			StringBuffer LOACTION = new StringBuffer(String.valueOf(LatLngConvertUtil.latG2B(Double.valueOf(lat)))).append(",").append(String.valueOf(LatLngConvertUtil.lngG2B(Double.valueOf(lng))));
//			Random r = new Random(System.currentTimeMillis());
//			String url = URL.replace("KEY", aks[r.nextInt(10)]).replace("LOACTION", LOACTION);
//			String reStr = httpGet(url);
//			ReverseGeocodingJson result = JsonUtils.toObject(reStr, ReverseGeocodingJson.class);
//			if (result.getStatus() == 0)
//			{
//				return defalutCheck(address, result.getResult().getAddressComponent());
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return false;
//	}
	
//	/**
//	 * @Description 省市区县匹配
//	 * @Author guixing.lv@hoau.net
//	 * @param address
//	 * @param ac void
//	 * @Time 2015年7月6日 上午11:38:41
//	 */
//	private static boolean defalutCheck(String address, AddressComponent ac)
//	{
//		StringBuffer inAddress = new StringBuffer(address);
//		StringBuffer fromBaiduAddress = new StringBuffer();
//		Pattern pattern = null;
//		Matcher matcher = null;
//		String[] equalsObject = {ac.getProvince(), ac.getCity(), ac.getDistrict()};
//		for (int i = 0; i < 2; i++)
//		{
//			pattern = Pattern.compile(LEVEL_AS[i], Pattern.UNICODE_CASE);
//			matcher = pattern.matcher(inAddress.toString());
//			if (matcher.find())
//			{
//				int level_as_start = matcher.end();
//				String level_as = inAddress.substring(0, level_as_start);
//				fromBaiduAddress.append(equalsObject[i]);
//				if (!StringUtil.equals(level_as, equalsObject[i]))
//				{
//					return true;
//				}
//				inAddress.delete(0, level_as_start);
//				// gx.lv 2015-10-10 如果是直辖市，直接跳过
//				if (i == 0 && municipalityCheck(level_as, inAddress.toString(), equalsObject[2]))
//				{
//					return false;
//				}
//			}
//		}
//		return false;
//	}
//
//	private static boolean municipalityCheck(String first_level_as, String address, String level)
//	{
//		for (int i = 0; i < MUNICIPALITY.length; i++)
//		{
//			// 如果为直辖市，则匹配直辖市下面的区
//			if (StringUtil.equals(first_level_as, MUNICIPALITY[i]))
//			{
//				return true;
//			}
//		}
//		return false;
//	}
//
//	public static GisInfo addressResolution(String address){
//		String json = null;
//		try {
//			json = httpGet(GisConstants.GIS_ADDRESS+ URLEncoder.encode(address,"utf-8"));
//		} catch (UnsupportedEncodingException e) {
//			e.printStackTrace();
//		}
//		ResponseMsg result = JsonUtils.toObject(json, ResponseMsg.class);
//		if(StringUtil.equals("0", result.getErrcode()) && !CollectionUtils.isEmpty(result.getGisInfo())){
//			return result.getGisInfo().get(0);
//		}else{
//			throw new GisQueryException("地址不能解析"+",请检查地址是否录错!");
//		}
//	}
//
//
//	public static void main(String[] args) {
//		calculateDriverDistance(31.2102736, 121.3096857, 31.210531, 121.309628);
//	}
}
