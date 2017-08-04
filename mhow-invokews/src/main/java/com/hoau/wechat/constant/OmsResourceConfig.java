package com.hoau.wechat.constant;

public class OmsResourceConfig {
	private static final String[] fileNames = { "/oms_resource_config.properties" };
	private static PropertyManager propertyManager = PropertyManager.load(fileNames, PropertyConstant.class);
	public static final String BASE_URL = propertyManager.getString("BASE_URL");
	public static final String  QUERY_ORDER_BYNO = propertyManager.getString("QUERY_ORDER_BYNO");
	public static final String  QUERY_ORDERS_BYCUSTOMNO = propertyManager.getString("QUERY_ORDERS_BYCUSTOMNO");	
}
