package com.hoau.wechat.dao.impl;

import java.util.Date;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.stereotype.Repository;

import com.hoau.wechat.dao.BaseDao;
import com.hoau.wechat.dao.IMsgManageDao;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;

@Repository
public class MsgManageDao extends BaseDao implements IMsgManageDao {

	@Override
	public void insertMsg(Map<String, String> msgMap) {
		DBObject dbObject = map2DBobject(msgMap);
		DB db = mongo.getDB(DB_NAME);
		try {
			db.requestStart();
			DBCollection coll = db.getCollection(COLLECTION_WEICHAT_MSG);
			coll.save(dbObject);
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			db.requestDone();
		}
	}

	private DBObject map2DBobject(Map<String, String> msgMap) {
		DBObject dbObject = new BasicDBObject();
		for(Entry<String, String> entry : msgMap.entrySet()){
			if("CreateTime".equalsIgnoreCase(entry.getKey())){
				dbObject.put(entry.getKey(), new Date());
			}else{
				dbObject.put(entry.getKey(), entry.getValue());
			}
		}
		return dbObject;
	}

}
