package com.hoau.how.module.bse.shared.utils;

/**
 * 字符串实用工具集
 * @author hsw
 */
public class StrUtil {
	
	/**
	 * 判断一个字符串是否为空, null 或者 零长度
	 * 但是没有考虑空字符的情况
	 * @param str 待判断的字符串
	 * @return 是否为空串
	 */
	public static boolean isEmpty(String str) {
		return str == null || str.length() == 0;
	}
	
	/**
	 * 判断两个字符串是否相等，null也表示空字符串
	 */
	public static boolean equalsString(String str1, String str2) {
		//如果第一个字符串为空，只有第二个字符串同时为空的情况才认为是相等的！
		if(isEmpty(str1)) {
			return isEmpty(str2);
		}
		return str1.equals(str2);
	}
}
