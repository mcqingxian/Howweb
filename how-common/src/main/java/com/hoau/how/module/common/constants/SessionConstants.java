package com.hoau.how.module.common.constants;

/**
 * @author：莫涛
 * @create：2015年7月14日 下午2:47:35
 * @description：
 */
public interface SessionConstants {
	/**
	 * 验证码接口
	 * @author 莫涛
	 * @date 2015年7月14日
	 */
	public interface SESSION_VERCODE_KEYS{
		//验证码
		public static String VERCODE = "imgCode";
		//手机找回密码,验证码
		public static String PHONE_VERCODE = "PHONE_VERCODE";
		//邮箱找回密码,验证码
		public static String EMAIL_VERCODE = "EMAIL_VERCODE";
		
		//手机验证码下发时间
		public static String PHONE_VERCODE_SEND_TIME = "PHONE_VERCODE_SEND_TIME";
		//邮箱验证码下发时间
		public static String EMAIL_VERCODE_SEND_TIME = "EMAIL_VERCODE_SEND_TIME";
		//手机短信MD5验证码，加密为：手机号+验证码
		public static String PHONE_SMS_MD5_VERCODE = "PHONE_SMS_MD5_VERCODE";
		//邮箱验证码MD5验证码，加密为：邮箱地址+验证码
		public static String EMAIL_SMS_MD5_VERCODE = "EMAIL_SMS_MD5_VERCODE";
		//邮箱MD5验证码
		public static String EMAIL_MD5_VERCODE = "EMAIL_MD5_VERCODE";
		//注册的时候，获取短信验证码的时候，需要先填写验证码，防止用户频繁获取用户注册码
		public static String USER_REGIST_VERCODE = "USER_REGIST_VERCODE";
	}
	
	/**
	 * 
	 *
	 * @author 莫涛
	 * @date 2015年7月20日
	 */
	public interface SESSION_REGIST_VERCODE_KEYS{
		//手机验证码下发时间
		public static String PHONE_REGIST_VERCODE_SEND_TIME = "PHONE_REGIST_VERCODE_SEND_TIME";
		//手机MD5验证码
		public static String PHONE_REGIST_SMS_VERCODE = "PHONE_REGIST_SMS_VERCODE";
	}
	
	/**
	 * 用户信息接口
	 * @author 莫涛
	 * @date 2015年7月17日
	 */
	public interface SESSION_USER_INFO{
		//用户信息
		public static String USER_INFO = "USER_INFO";
		//登陆类型
		public static String LOGIN_TYPE = "LOGIN_TYPE";
		//手机
		public static String PHONE = "PHONE";
		//邮箱
		public static String EMAIL = "EMAIL";
		//账号
		public static String USERNAME = "USERNAME";
	}
	
	/**
	 * 批量下单订单数据
	 * @author 莫涛
	 * @date 2015年8月6日
	 */
	public interface SESSION_BATCH_ORDER_INFO{
		//用户批量下单订单数据
		public static String BATCH_ORDER_INFO = "BATCH_ORDER_INFO";
		//用户发货人订单数据
		public static String BATCH_SHIPPER_ORDER_INFO = "BATCH_SHIPPER_ORDER_INFO";
	}
	
	/**
	 * 批量目的站匹配下载控制
	 * @author 莫涛
	 * @date 2015年10月28日
	 */
	public interface SESSION_BATCH_DOWNLOAD_INFO{
		public static String BATCH_ERROR_MSG = "BATCH_ERROR_MSG";
		public static String BATCH_ERROR_TYPE = "BATCH_ERROR_TYPE";
	}
}
