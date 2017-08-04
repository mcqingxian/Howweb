package com.hoau.how.module.obh.shared.constants;

/**
 * @author：莫涛
 * @create：2015年10月20日 上午10:09:48
 * @description：
 */
public interface Constants {
	//批量下单，天猫上传模板字段
	public interface BATCH_ORDER_TMALL_FIELD{
		//收货人
		public String CONSIGNEE_EBSA_CONTACT = "CONSIGNEE_EBSA_CONTACT";
		//详细地址
		public String CONSIGNEE_EBSA_ADDRESS = "CONSIGNEE_EBSA_ADDRESS";
		//收货人座机
		public String CONSIGNEE_EBSA_TEL = "CONSIGNEE_EBSA_TEL";
		//收货人手机
		public String CONSIGNEE_EBSA_MOBILE = "CONSIGNEE_EBSA_MOBILE";
		//货物名称
		public String CARGO_NAME = "CARGO_NAME";
		//运输方式
		public String PRODUCT_TYPE_NAME = "PRODUCT_TYPE_NAME";
		//送货方式
		public String SHIPPER_METHOD = "SHIPPER_METHOD";
		//付款方式
		public String PAYMENT_METHOD = "PAYMENT_METHOD";
		//货物件数
		public String NUMBER = "NUMBER";
		//重量
		public String TOTAL_WEIGHT = "TOTAL_WEIGHT";
		//体积
		public String TOTAL_VOLUME = "TOTAL_VOLUME";
		//包装类型
		public String PACKAGE = "PACKAGE";
		//保价声明
		public String INSURANCE = "INSURANCE";
		//签收回单
		public String SIGN_BACK = "SIGN_BACK";
		//备注
		public String REMARK = "REMARK";
	}
}
