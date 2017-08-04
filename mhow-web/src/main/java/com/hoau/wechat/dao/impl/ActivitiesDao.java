package com.hoau.wechat.dao.impl;


import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;

import com.hoau.wechat.dao.BaseDao;
import com.hoau.wechat.dao.IActivitiesDao;
import com.hoau.wechat.util.BeanUtil;
import com.hoau.wechat.vo.ActiveInfo;
import com.hoau.wechat.vo.LotteryRecord;
import com.hoau.wechat.vo.ShareRecode;
import com.hoau.wechat.vo.Vouchers;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;

@Repository
public class ActivitiesDao extends BaseDao implements IActivitiesDao {

	private static final Log LOG = LogFactory.getLog(ActivitiesDao.class);
	
	@Override
	public Vouchers useLotteryTicket(String type) {
		Vouchers vouchers = null;
		DB db = mongo.getDB(DB_NAME);
		/*Mongo mongo;
		DB db = null;
		try {
			mongo = new Mongo("10.39.59.153",27017);
			db = mongo.getDB(DB_NAME);
		} catch (UnknownHostException e1) {
			e1.printStackTrace();
		}*/
		try {
			db.requestStart();
			DBCollection coll = db.getCollection(COLLECTION_WEICHAT_LOTTERYTICKETS);
			//查询条件
			DBObject object = new BasicDBObject();
			object.put("status", 0);
			if(type != null){
				object.put("type", type);
			}
			DBObject dbObject = coll.findOne(object);
			if(dbObject != null){
				vouchers =  BeanUtil.dbObject2Bean(dbObject, Vouchers.class);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			db.requestDone();
		}
		return vouchers;
	}

	@Override
	public void updateStatus(int vouchersId) {
		DB db = mongo.getDB(DB_NAME);
		try {
			db.requestStart();
			DBCollection coll = db.getCollection(COLLECTION_WEICHAT_LOTTERYTICKETS);
			//查询条件
			DBObject condition = new BasicDBObject();
			condition.put("id", vouchersId);
			//结果返回列过滤
			DBObject update = new BasicDBObject();
			update.put("$set", new BasicDBObject("status", 1));
//			coll.update(condition, update,false,true);
			coll.update(condition, update);
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			db.requestDone();
		}
	}

	@Override
	public void addLotteryRecord(LotteryRecord lotteryRecord) {
		DB db = mongo.getDB(DB_NAME);
		try {
			db.requestStart();
			DBCollection coll = db.getCollection(COLLECTION_WEICHAT_LOTTERYRECORD);
			//查询条件
			DBObject lr = BeanUtil.bean2DBObject(lotteryRecord);
			coll.save(lr);
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			db.requestDone();
		}
	}

	@Override
	public void addShareRecord(ShareRecode shareRecode) {
		DB db = mongo.getDB(DB_NAME);
		try {
			db.requestStart();
			DBCollection coll = db.getCollection(COLLECTION_WEICHAT_SHARERECORD);
			//查询条件
			DBObject lr = BeanUtil.bean2DBObject(shareRecode);
			coll.save(lr);
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			db.requestDone();
		}
	}

	@Override
	public boolean isBind(String openid) {
		boolean isbind = false;
		
		DB db = mongo.getDB(DB_NAME);
		try {
			db.requestStart();
			DBCollection coll = db.getCollection(COLLECTION_USER_INFO);
			//查询条件
			DBObject object = new BasicDBObject();
			object.put("openid", openid);
			object.put("phone", new BasicDBObject("$exists", true));
			
			DBObject rtn = coll.findOne();
			if(rtn != null){
				isbind = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			db.requestDone();
		}
		return isbind;
	}

	@Override
	public List<LotteryRecord> getLotteryRecord(String openid,boolean con) {
		List<LotteryRecord> cts = new ArrayList<LotteryRecord>();
		DB db = mongo.getDB(DB_NAME);
		try {
			db.requestStart();
			DBCollection coll = db.getCollection(COLLECTION_WEICHAT_LOTTERYRECORD);
			//查询条件
			DBObject object = new BasicDBObject();
			object.put("openid", openid);
			
			DBCursor cursor = coll.find(object);
			
			while(cursor.hasNext()){
				DBObject dbObject = cursor.next();
				if(con){
					cts.add(BeanUtil.dbObject2Bean(dbObject, LotteryRecord.class));
				}else{
					if((Integer)dbObject.get("vouchersId") < 2640){
						cts.add(BeanUtil.dbObject2Bean(dbObject, LotteryRecord.class));
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			db.requestDone();
		}
		
		return cts;
	}

	@Override
	public ShareRecode getShareRecord(String openid) {
		ShareRecode shareRecode = null;
		DB db = mongo.getDB(DB_NAME);
		try {
			db.requestStart();
			DBCollection coll = db.getCollection(COLLECTION_WEICHAT_SHARERECORD);
			//查询条件
			DBObject object = new BasicDBObject();
			object.put("openid", openid);
			DBObject dbObject = coll.findOne(object);
			if(dbObject != null){
				shareRecode =  BeanUtil.dbObject2Bean(dbObject, ShareRecode.class);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			db.requestDone();
		}
		return shareRecode;
	}

	@Override
	public List<LotteryRecord> latestLotteryRecord() {
		List<LotteryRecord> cts = new ArrayList<LotteryRecord>();
		DB db = mongo.getDB(DB_NAME);
		try {
			db.requestStart();
			DBCollection coll = db.getCollection(COLLECTION_WEICHAT_LOTTERYRECORD);
			DBObject object = new BasicDBObject("lotteryTime",-1);
			DBCursor cursor = coll.find().sort(object);
			while(cursor.hasNext()){
				DBObject dbObject = cursor.next();
				if((Integer)dbObject.get("vouchersId") < 2640){
					cts.add(BeanUtil.dbObject2Bean(dbObject, LotteryRecord.class));
				}
				if(cts.size() == 5){
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			db.requestDone();
		}
		return cts;
	}

	@Override
	public String getUserPhoneNo(String openId) {
		LOG.info(".getUserPhoneNo openId:"+openId);
		String rtn = null;
		DB db = mongo.getDB(DB_NAME);
		try {
			db.requestStart();
			DBCollection coll = db.getCollection(COLLECTION_USER_INFO);
			//查询条件
			DBObject object = new BasicDBObject();
			object.put("openid", openId);
			DBObject dbObject = coll.findOne(object);
			if(dbObject != null){
				LOG.info(".getUserPhoneNo dbObject:"+dbObject);
				System.out.println("getUserPhoneNo phone:"+dbObject.get("phone"));
				rtn = (String)dbObject.get("phone");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			db.requestDone();
		}
		return rtn;
	}

	@Override
	public List<LotteryRecord> getLotteryRecord(String openid, String type) {
		List<LotteryRecord> cts = new ArrayList<LotteryRecord>();
		DB db = mongo.getDB(DB_NAME);
		try {
			db.requestStart();
			DBCollection coll = db.getCollection(COLLECTION_WEICHAT_LOTTERYRECORD);
			//查询条件
			DBObject object = new BasicDBObject();
			object.put("openid", openid);
			object.put("type", type);
			
			DBCursor cursor = coll.find(object);
			while(cursor.hasNext()){
				DBObject dbObject = cursor.next();
				cts.add(BeanUtil.dbObject2Bean(dbObject, LotteryRecord.class));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			db.requestDone();
		}
		return cts;
	}

	@Override
	public List<ActiveInfo> getActiveInfos() {
		List<ActiveInfo> cts = new ArrayList<ActiveInfo>();
		DB db = mongo.getDB(DB_NAME);
		try {
			db.requestStart();
			DBCollection coll = db.getCollection(COLLECTION_ACTIVE_INFO);
			DBCursor cursor = coll.find();
			while(cursor.hasNext()){
				DBObject dbObject = cursor.next();
				cts.add(BeanUtil.dbObject2Bean(dbObject, ActiveInfo.class));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			db.requestDone();
		}
		return cts;
	}
}
