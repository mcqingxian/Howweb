package com.hoau.wechat.constant;


public class PropertyConstant
{
  private static final String[] fileNames = { "/config.properties" };
  private static PropertyManager propertyManager = PropertyManager.load(fileNames, PropertyConstant.class);
  public static final String OMS_URL = propertyManager.getString("OMS_URL");
  public static final String OMS_ORDER_URL = propertyManager.getString("OMS_ORDER_URL");
  public static final String SMS_URL = propertyManager.getString("SMS_URL");
  public static final String SERVER_URL = propertyManager.getString("SERVER_URL");
  public static final String DC_PRICE_URL = propertyManager.getString("DC_PRICE_URL");
  public static final String TTQ_PRICE_URL = propertyManager.getString("TTQ_PRICE_URL");
  public static final String TTQ_URL = propertyManager.getString("TTQ_URL");
  public static final String SMS_TEMPLATE = propertyManager.getString("SMS_TEMPLATE");
  public static final String HC_URL = propertyManager.getString("HC_URL");
  public static final String WT_URL = propertyManager.getString("WT_URL");
  public static final String NEWS_IMG_SRC = propertyManager.getString("NEWS_IMG_SRC");
  public static final String DC_WAYBILL_INFO_URL = propertyManager.getString("DC_WAYBILL_INFO_URL");
}
