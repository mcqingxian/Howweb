package com.hoau.wechat.dao;

import javax.annotation.Resource;

import com.mongodb.Mongo;

public class BaseDao {
	protected static final String DB_NAME="wechat";
	protected static final String COLLECTION_USER_INFO = "user_info";
	
	/** 
	* @Fields COLLECTION_USER_INFO : 短信发送记录
	*/
	protected static final String COLLECTION_MSG_SEND_RECORD = "msg_send_record";
	
	protected static final String COLLECTION_VALIDATE_INFO = "validate_info";
	
	protected static final String COLLECTION_WEICHAT_MSG = "msg";
	
	protected static final String SURVEY_INFO = "survey_info";
	// 奖券文档
	protected static final String COLLECTION_WEICHAT_LOTTERYTICKETS = "lotterytickets";
	// 中奖记录文档
	protected static final String COLLECTION_WEICHAT_LOTTERYRECORD = "lotteryrecord";
	// 分享记录
	protected static final String COLLECTION_WEICHAT_SHARERECORD = "sharerecord";
	// 活动信息
	protected static final String COLLECTION_ACTIVE_INFO = "active_info";
	//关键字
	protected static final String COLLECTION_KEYWORD = "keyword";
	//校园托运活动信息
	protected static final String COMPUS_ACTIVITY_INFO = "compus_activity_info";
	//校园托运活动参赛编号
	protected static final String COMPUS_ACTIVITY_CODE = "compus_activity_code";
	//校园托运奖券
	protected static final String COMPUS_ACTIVITY_TICKET = "compus_activity_ticket";
	//运单信息
	protected static final String WAYBILLINFO = "waybillinfo";
	
	protected static final String CONFIGURE_CONSTANT = "constant_configure";
	
	//@Resource
	protected Mongo mongo;
	
	/*public void setMongo(Mongo mongo) {
		this.mongo = mongo;
	}*/
}
