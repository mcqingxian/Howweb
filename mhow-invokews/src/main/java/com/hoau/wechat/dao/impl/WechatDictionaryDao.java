/**
 * 
 */
package com.hoau.wechat.dao.impl;

import org.springframework.stereotype.Repository;

import com.hoau.wechat.dao.BaseDao;
import com.hoau.wechat.dao.IWechatDictionaryDao;
import com.hoau.wechat.entity.SmsEntity;
import com.hoau.wechat.util.BeanUtil;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;

/**
 * @author gaojia
 *
 */
@Repository
public class WechatDictionaryDao extends BaseDao implements IWechatDictionaryDao{
	private static final String COLLECTION_NAME = "wechat_dictionary";
	
	@Override
	public String querySMSURL() {
		String url = null;
		DB db = mongo.getDB(DB_NAME);
		try {
			db.requestStart();
			DBCollection coll = db.getCollection(COLLECTION_NAME);
			DBObject object = new BasicDBObject();
			object.put("code", "SMS_URL");
			DBObject cols = new BasicDBObject();
			cols.put("value", 1);
			DBObject rtn = coll.findOne(object, cols);
			if(rtn!=null){
				url = rtn.get("value").toString();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			db.requestDone();
		}
		return url;
	}

	@Override
	public String querySMSTemplate() {
		String url = null;
		DB db = mongo.getDB(DB_NAME);
		try {
			db.requestStart();
			DBCollection coll = db.getCollection(COLLECTION_NAME);
			DBObject object = new BasicDBObject();
			object.put("code", "SMS_TEMPLATE");
			DBObject cols = new BasicDBObject();
			cols.put("value", 1);
			DBObject rtn = coll.findOne(object, cols);
			if(rtn!=null){
				url = rtn.get("value").toString();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			db.requestDone();
		}
		return url;
	}

	@Override
	public String queryServerUrl() {
		String url = null;
		DB db = mongo.getDB(DB_NAME);
		try {
			db.requestStart();
			DBCollection coll = db.getCollection(COLLECTION_NAME);
			DBObject object = new BasicDBObject();
			object.put("code", "SERVER_URL");
			DBObject cols = new BasicDBObject();
			cols.put("value", 1);
			DBObject rtn = coll.findOne(object, cols);
			if(rtn!=null){
				url = rtn.get("value").toString();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			db.requestDone();
		}
		return url;
	}

	@Override
	public void saveMsgSendRecord(SmsEntity smsEntity) {
		DB db = mongo.getDB(DB_NAME);
		try {
			db.requestStart();
			DBCollection coll = db.getCollection(COLLECTION_MSG_SEND_RECORD);
			DBObject dbObject = BeanUtil.bean2DBObject(smsEntity);
			coll.save(dbObject);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			db.requestDone();
		}
	}

}
