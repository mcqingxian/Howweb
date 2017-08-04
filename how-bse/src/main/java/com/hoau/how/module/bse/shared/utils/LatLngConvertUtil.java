package com.hoau.how.module.bse.shared.utils;
/**
 * @author 唐征征
 * @date 2017/7/26 下午2:05
 * @description 经纬度转换工具
 */

public class LatLngConvertUtil {
	
	/**
	 * @author 唐征征
	 * @date 2017/7/26 下午2:08
	 * @description 谷歌纬度转换成百度纬度
	 */
	public static double latG2B(double lat){
		double i = (Math.round((lat+0.0060) * 10000000));
		double j = 10000000d;
		double res = i/ j;
		return res;
	}
	/**
	 * @author 唐征征
	 * @date 2017/7/26 下午2:08
	 * @description 谷歌地图经度转换为百度地图经度
	 */
	public static double lngG2B(double lng){
		double i = (Math.round((lng+0.0065) * 10000000));
		double j = 10000000d;
		double res = i/ j;
		return res;
	}
	
}
