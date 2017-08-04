package com.hoau.how.module.util;

import java.util.UUID;
/**
 *
 * @author 莫涛
 * @date 2015年5月26日
 */
public class UUIDUtil {
	public static String getUUID() {
		return UUID.randomUUID().toString();
	}

	public static long getVersion() {
		return System.currentTimeMillis();
	}
}
