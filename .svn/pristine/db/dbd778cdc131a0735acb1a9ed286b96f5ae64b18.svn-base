package com.hoau.wechat.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
	private static final DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	public static String format(long date){
		return dateFormat.format(new Date(date));
	}
	
	public static Date parse(String dateStr){
		Date date  = null;
		try {
			date = dateFormat.parse(dateStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}
	
	
	public static void main(String[] args) {
		System.out.println(format(1348831860l));
		System.out.println(parse("2014-10-02 12:00:00"));
	}
}
