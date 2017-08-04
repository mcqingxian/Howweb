package com.hoau.how.module.util.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author：莫涛
 * @create：2015年7月16日 上午10:56:42
 * @description：
 */
public class DateUtils {
	private static SimpleDateFormat yyyyMMddHHmmss = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	private static SimpleDateFormat yearMonthDaySdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
	private static SimpleDateFormat ymdhms = new SimpleDateFormat("yyyyMMddHHmmss");
	/**
	 * @type:add
	 * @user:huyuzhou
	 * @date:2016年1月21日
	 * @auth:格式化yyyy/MM/dd格式的时间
	 */
	private static SimpleDateFormat ymdhmsSdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	/**
	 * end
	 */
	
	private static SimpleDateFormat yyyyMMdd = new SimpleDateFormat("yyyy-MM-dd");
	public static String getCurDateTime(){
		return yyyyMMddHHmmss.format(new Date());
	}
	
	public static String getCurYmdhms(){
		return ymdhms.format(new Date());
	}
	
	public static String formatDateByCn(Date date){
		return yearMonthDaySdf.format(date);
	}
	
	public static Date parseDate(String date) throws ParseException{
		return yyyyMMddHHmmss.parse(date);
	}
	/**
	 * @type:add
	 * @user:huyuzhou
	 * @date:2016年1月21日
	 * @auth:格式化yyyy/MM/dd格式的时间
	 */
	public static Date parseDateYmdshms(String date) throws ParseException{
		return ymdhmsSdf.parse(date);
	}
	/**
	 * end
	 */
	
	public static String formatDateByEn(Date date){
		return yyyyMMddHHmmss.format(date);
	}
	
	public static String formatDateYYYYMMDD(Date date){
		return yyyyMMdd.format(date);
	}
}