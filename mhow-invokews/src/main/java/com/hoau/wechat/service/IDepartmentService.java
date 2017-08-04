package com.hoau.wechat.service;
/**
 * 
 * @author gaojia
 *
 */
public interface IDepartmentService {
	String queryDepartmentByTude(String province, String city, String county,String longitude,String latitude,String cond,String count);
	
	String queryDepartmentPhone(String department);
}
