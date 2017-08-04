package com.hoau.wechat.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.hoau.wechat.dao.BaseDao;
import com.hoau.wechat.dao.IGoodsTraceDao;
import com.hoau.wechat.util.JsonUtils;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;

@Repository
@Scope("prototype")
public class GoodsTraceDao extends BaseDao implements IGoodsTraceDao {

	@Override
	public void addWayBillToLatest(String openId,String waybill) {
		DB db = mongo.getDB(DB_NAME);
		try {
			db.requestStart();
			DBCollection coll = db.getCollection(COLLECTION_USER_INFO);
			//查询条件
			DBObject object = new BasicDBObject();
			object.put("openid", openId);
			
			
			DBObject carry = new BasicDBObject();
			carry.put("frequently_waybills", waybill);
			
			DBObject cadd = new BasicDBObject();
			cadd.put("$push", carry);
			List<String> waybills = queryLatest(openId);
			if(waybills.size() > 10){
				// 弹出数组中最早的运单
				DBObject condition = new BasicDBObject();
				condition.put("frequently_waybills", -1);
				DBObject pop = new BasicDBObject();
				pop.put("$pop", condition);
				coll.update(object, pop);
			}
			if(!waybills.contains(waybill)){
				coll.update(object, cadd);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			db.requestDone();
		}
	}

	@Override
	public List<String> queryLatest(String openId) {
		
		List<String> cts = new ArrayList<String>();
		DB db = mongo.getDB(DB_NAME);
		try {
			db.requestStart();
			DBCollection coll = db.getCollection(COLLECTION_USER_INFO);
			//查询条件
			DBObject object = new BasicDBObject();
			object.put("openid", openId);
			
			DBObject cols = new BasicDBObject();
			cols.put("_id", 1);
			cols.put("openid", 1);
			cols.put("frequently_waybills", 1);
			
			DBObject rtn = coll.findOne(object, cols);
			if(rtn != null && rtn.get("frequently_waybills") != null){
				cts = JsonUtils.toList(rtn.get("frequently_waybills").toString(), String.class);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			db.requestDone();
		}
		return cts;
	}

}
