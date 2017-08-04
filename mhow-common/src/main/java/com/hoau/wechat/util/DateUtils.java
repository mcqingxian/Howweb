package com.hoau.wechat.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 时间格式化工具
 *
 * @author 蒋落琛
 * @date 2015-12-9
 */
public class DateUtils {
	
	private static SimpleDateFormat yyyyMMddHHmmss = new SimpleDateFormat(
			"yyyy-MM-dd HH:mm:ss");
	
	private static SimpleDateFormat yearMonthDaySdf = new SimpleDateFormat(
			"yyyy年MM月dd日 HH:mm:ss");
	
	private static SimpleDateFormat ymdhms = new SimpleDateFormat(
			"yyyyMMddHHmmss");

	private static SimpleDateFormat yyyyMMdd = new SimpleDateFormat(
			"yyyy-MM-dd");

	public static String getCurDateTime() {
		return yyyyMMddHHmmss.format(new Date());
	}

	public static String getCurYmdhms() {
		return ymdhms.format(new Date());
	}
	
	public static long getCurTimeMillis(){
		return System.currentTimeMillis();
	}

	public static String formatDateByCn(Date date) {
		return yearMonthDaySdf.format(date);
	}

	public static String formatDateYYYYMMDD(Date date) {
		return yyyyMMdd.format(date);
	}
	public static String formatDateYYYYMMDDHHmmss(Date date) {
		return yyyyMMddHHmmss.format(date);
	}
}