package com.hoau.how.module.common.constants;

import java.util.HashMap;
import java.util.Map;

/**
 * 理赔枚举数据
 * @author 徐俊
 * @date 2015年8月19日
 */
public class ClaimEnum {
	/**
	 * 发货方
	 */
	public static final String SHIPPER_PARTY = "shipper_party";
	/**
	 * 收货方
	 */
	public static final String CONSIGNEE_PARTY = "consignee_party";
	
	
	/**
	 * 理赔信息  删除状态
	 */
	public static final String LOCAL_CLAIM_STATUS_DELETE = "DELETE";
	
	/*******************************************************************/
	
	/**
	 * 身份证
	 */
	public static final String IMAGE_TYPE_ID_CARDS = "01";

	/**
	 * 银行卡
	 */
	public static final String IMAGE_TYPE_BANK_CARDS = "02";
	
	/**
	 * 到货签收凭证
	 */
	public static final String IMAGE_TYPE_ARRIVE_SIGN_VOUCHER = "03";
	/**
	 * 发票复印件
	 */
	public static final String IMAGE_TYPE_INVOICE_COPY = "04";

	/**
	 * 货物破损照片
	 */
	public static final String IMAGE_TYPE_GOODS_DAMAGED = "05";

	/**
	 * 客户委托授权证明
	 */
	public static final String IMAGE_TYPE_AUTHORIZATION_CERTIFICATE  = "06";
	
	/**
	 * 客户委托授权证明标记
	 */
	public static final String AUTHORIZATION_CERTIFICATE  = "AC_";
	
	/**
	 * 客户索赔函
	 */
	public static final String IMAGE_TYPE_CLAIM_LETTER = "07";
	/**
	 * 发货运单图片
	 */
	public static final String IMAGE_TYPE_WAYBILL_IMAGE = "08";
	
	
	/*******************************************************************/
	/**                          理赔提示信息                                                                                                      **/                 
	/*******************************************************************/
	
	public static final String CLAIM_RESULT_REPEAT = "不能重复上传图片";
	
	public static final String CLAIM_RESULT_OVERSIZE = "上传图片不能超过2M";
	
	public static final String CLAIM_RESULT_UPLOAD_FAIL = "上传文件失败，请联系管理员";
	
	public static final String CLAIM_RESULT_VALID_FAIL = "校验失败，请联系管理员";
	
	public static final String CLAIM_RESULT_SUBMIT_SUCCESS = "提交成功";
	
	
	/*******************************************************************/
	/**                          短信理赔 状态    add huyuzhou 2016年1月15日                                                                                              **/                 
	/*******************************************************************/
	public static final String CLAIM_RESULT_SMS_STATUS = "系统出现异常！";
	/**
	 * end
	 */
	
	/*******************************************************************/
	/**                          理赔单 状态                                                                                                  **/                 
	/*******************************************************************/
	/**
	 * 理赔信息  提交状态
	 */
	public static final String LOCAL_CLAIM_STATUS_SUBMIT = "SUBMIT";
	
	/**
	 * 理赔信息  未提交状态
	 */
	public static final String LOCAL_CLAIM_STATUS_UN_SUBMIT = "UN_SUBMIT";
	
//	/**
//	 * 完成
//	 */
//	public static final String CLAIM_STATUS_FINISH = "FINISH";
//	
//	/**
//	 * 待受理
//	 */
//	public static final String CLAIM_STATUS_TO_BE_ACCEPTED = "TO_BE_ACCEPTED";
//	/**
//	 * 
//	 */
//	public static final String CLAIM_STATUS_IN_REVIEW = "IN_REVIEW";
//	/**
//	 * 付款中
//	 */
//	public static final String CLAIM_STATUS_PAYING = "PAYING";
//	 
//	/**
//	 * 待确认
//	 */
//	public static final String CLAIM_STATUS_TO_BE_CONFIRM = "TO_BE_CONFIRM";
	
	public static final Map<String,String> ALLSTATUS = new HashMap<String, String>();
	
	public static final Map<String,String> ALLSTATUSQUERY = new HashMap<String, String>();
	
	/**
	 *  add huyuzhou 2016年4月22日14:07:36
	 */
	//出险类型 
	public static final Map<String,String> ACCIDENT_TYPE = new HashMap<String, String>();
	//货物类型
	public static final Map<String,String> CARGO_TYPE = new HashMap<String, String>();
	/**
	 * end
	 */
	
	/**
	 * 理赔金额待确认
	 */
	public static final String CLAIM_STATUS_UNCONFIRMEDCLAIMSAMOUNT = "-4";
	/**
	 * 理赔金额确认
	 */
	public static final String CLAIM_STATUS_CONFIRMCLAIMSAMOUNT = "-3";
	/**
	 * 退回理赔系统
	 */
	public static final String CLAIM_STATUS_RETURNCLAIMS = "-2";
	/**
	 * 录入
	 */
	public static final String CLAIM_STATUS_ENTRY = "-1";
	/**
	 * 录入确认
	 */
	public static final String CLAIM_STATUS_SUBMIT = "0";
	/**
	 * 上报
	 */
	public static final String CLAIM_STATUS_REPORT = "1";
	/**
	 * 中止
	 */
	public static final String CLAIM_STATUS_ABORT = "2";
	/**
	 * 退回
	 */
	public static final String CLAIM_STATUS_RETURN = "3";
	/**
	 * 受理
	 */
	public static final String  CLAIM_ALLSTATUSQUERY_ADMISSIBILITY= "5";
	/**
	 * 完成
	 */
	public static final String CLAIM_STATUS_OMPLETED = "6";
	/**
	 * 作废
	 */
	public static final String CLAIM_STATUS_CANCEL = "7";
	/**
	 * 财务登记
	 */
	public static final String CLAIM_STATUS_FINANCIALREG = "8";
	
	
	//官网系统状态转换
	//已受理
	//public static final String CLAIM_ALLSTATUSQUERY_DEAL = "0";
	//已退回
	//public static final String CLAIM_ALLSTATUSQUERY_BACK = "-2";
	//理赔金额待确认
	//public static final String CLAIM_ALLSTATUSQUERY_CONFIRM = "-4";
	//汇款中
	//public static final String CLAIM_ALLSTATUSQUERY_REMITTANCE = "-3";
	//已作废
	//public static final String CLAIM_ALLSTATUSQUERY_CANCEL = "7";
	//已完成
	//public static final String CLAIM_ALLSTATUSQUERY_FINISH = "5";
	
	static{
		ALLSTATUS.put(CLAIM_STATUS_UNCONFIRMEDCLAIMSAMOUNT, "理赔金额待确认");
		ALLSTATUS.put(CLAIM_STATUS_CONFIRMCLAIMSAMOUNT, "汇款中");
		ALLSTATUS.put(CLAIM_STATUS_RETURNCLAIMS, "已退回");
		ALLSTATUS.put(CLAIM_STATUS_ENTRY, "已受理");
		ALLSTATUS.put(CLAIM_STATUS_SUBMIT,"已受理");
		ALLSTATUS.put(CLAIM_STATUS_REPORT,"已受理");
		ALLSTATUS.put(CLAIM_STATUS_ABORT, "已作废");
		ALLSTATUS.put(CLAIM_STATUS_RETURN, "已受理");
		ALLSTATUS.put(CLAIM_STATUS_OMPLETED, "已完成");
		ALLSTATUS.put(CLAIM_STATUS_CANCEL, "已作废");
		ALLSTATUS.put(CLAIM_STATUS_FINANCIALREG, "已完成");
		ALLSTATUS.put(LOCAL_CLAIM_STATUS_UN_SUBMIT, "未提交");
		
		ALLSTATUSQUERY.put(CLAIM_STATUS_SUBMIT, "已受理");
		ALLSTATUSQUERY.put(CLAIM_STATUS_REPORT, "已受理");
		ALLSTATUSQUERY.put(CLAIM_STATUS_RETURN, "已受理");
		ALLSTATUSQUERY.put(CLAIM_ALLSTATUSQUERY_ADMISSIBILITY, "已受理");
		ALLSTATUSQUERY.put(CLAIM_STATUS_RETURNCLAIMS, "已退回");
		ALLSTATUSQUERY.put(CLAIM_STATUS_UNCONFIRMEDCLAIMSAMOUNT, "理赔金额待确认");
		ALLSTATUSQUERY.put(CLAIM_STATUS_CONFIRMCLAIMSAMOUNT, "汇款中");
		ALLSTATUSQUERY.put(CLAIM_STATUS_ABORT, "已作废");
		ALLSTATUSQUERY.put(CLAIM_STATUS_CANCEL, "理赔单作废");
		ALLSTATUSQUERY.put(CLAIM_STATUS_OMPLETED, "已完成");
		ALLSTATUSQUERY.put(CLAIM_STATUS_FINANCIALREG, "已完成");
		ALLSTATUSQUERY.put(LOCAL_CLAIM_STATUS_UN_SUBMIT, "未提交");
		ALLSTATUSQUERY.put(CLAIM_STATUS_ENTRY, "审核中");
		
		//add huyuzhou 2016年4月22日14:07:09
		ACCIDENT_TYPE.put("1", "丢失");
		ACCIDENT_TYPE.put("2", "破损");
		ACCIDENT_TYPE.put("3", "火灾");
		ACCIDENT_TYPE.put("4", "肇事");
		ACCIDENT_TYPE.put("6", "其他");
		
		CARGO_TYPE.put("1", "药品");
		CARGO_TYPE.put("2", "服装");
		CARGO_TYPE.put("3", "电脑");
		CARGO_TYPE.put("4", "厨具");
		CARGO_TYPE.put("5", "工具");
		CARGO_TYPE.put("6", "配件");
		CARGO_TYPE.put("7", "电器");
		CARGO_TYPE.put("8", "家具");
		CARGO_TYPE.put("9", "刀具");
		CARGO_TYPE.put("10", "灯具");
		CARGO_TYPE.put("11", "乐器");
		CARGO_TYPE.put("12", "日用品");
		CARGO_TYPE.put("13", "食品");
		CARGO_TYPE.put("14", "书");
		CARGO_TYPE.put("15", "行李");
		CARGO_TYPE.put("16", "其它");
		//end
	}
	
	 /**
     * 理赔渠道
     * add
     * huyuzhou 2016-01-15
     */
    public static int CLAIM_CHANNEL_OFFICIAL = 1;//官网理赔
    /**
     * end
     */
    
    /**
     * 客户拒绝理赔金额状态（0 未拒绝）
     * add 田育林  2016-05-04
     */
    public static final int CLAIM_REFUSE_AGREE = 0; //未拒绝
    /**
     * 客户拒绝理赔金额状态（1 已拒绝）
     * add 田育林  2016-05-04
     */
    public static final int CLAIM_REFUSE_NOTAGREE = 1; //已拒绝
}
