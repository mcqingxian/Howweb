package com.hoau.wechat.constant;

import java.util.HashMap;
import java.util.Map;

public interface OMSConstants {
	/**
	 * 初始密码
	 */
	public static final String PASSWORD = "wechat888888";
	/**
	 * 默认产品编码
	 */
	public static final String DEFAULT_PRODUCT_TYPE_CODE = "10000000000000000001";
	
	public static final String CHARSET = "UTF-8";
	public static final String APPLICATION_JSON = "application/json";
	public static final String APPLICATION_XML = "application/xml";
	
	public static final Map<String,String> SHIPPER_METHEOD = new HashMap<String,String>(){
		private static final long serialVersionUID = -176164704031111445L;

		{
			/*put("asdad","上门提货");
			put("12313","客户自送");*/
		}
	};
	
	public static abstract interface  ORDER_STATUS{
		/**
		 * 未受理
		 */
		public static final String ADD = "ADD";
		/**
		 * 已取消
		 */
		public static final String VOID = "VOID";
		/**
		 * 已揽收
		 */
		public static final String CANVASSING = "CANVASSING";
		/**
		 * 已签收
		 */
		public static final String DELIVER = "DELIVER";
		
		
		
		
	}
}
