package com.hoau.how.module.util;

import com.hoau.how.module.util.UUIDUtil;

/**
 *	生成唯一订单号
 * @author 莫涛
 * @date 2015年7月29日
 */
public class UUIDGenerator {
	public static String getOrderIdByUUId(){
		int machineId=1;
		int hashCodeV = UUIDUtil.getUUID().toString().hashCode();
		if(hashCodeV < 0){
			hashCodeV = - hashCodeV;
		}
		return machineId + String.format("%012d",hashCodeV);
	}
}