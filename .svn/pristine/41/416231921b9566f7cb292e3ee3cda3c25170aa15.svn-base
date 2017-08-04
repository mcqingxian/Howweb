package com.hoau.wechat.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.hoau.wechat.dao.BaseDao;
import com.hoau.wechat.dao.IWayBillInfoDao;
import com.hoau.wechat.util.BeanUtil;
import com.hoau.wechat.vo.WayBillInfoEntity;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;

@Repository
@Scope("prototype")
public class WayBillInfoDao extends BaseDao implements IWayBillInfoDao{

	@Override
	public void updateWayBill(WayBillInfoEntity info) {
		DB db = mongo.getDB(DB_NAME);
		try {
			db.requestStart();
			DBCollection collection = db.getCollection(WAYBILLINFO);
			//查询条件
			DBObject query = new BasicDBObject();
			query.put("openid", info.getOpenid());
			query.put("wayBill", info.getWayBill());
			
			//更新内容
			DBObject update = new BasicDBObject();
			update.put("$set", new BasicDBObject("status",1));
			collection.update(query, update);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			db.requestDone();
		}
	}

	@Override
	public List<WayBillInfoEntity> findWayBillInfos(String openid) {
		List<WayBillInfoEntity> infos = new ArrayList<WayBillInfoEntity>();
		DB db = mongo.getDB(DB_NAME);
		try {
			db.requestStart();
			DBCollection coll = db.getCollection(WAYBILLINFO);
			//查询条件
			DBObject query = new BasicDBObject();
			query.put("openid", openid);
			query.put("status", 0);
			
			DBCursor cursor = coll.find(query);
			
			while(cursor.hasNext()){
				infos.add(BeanUtil.dbObject2Bean(cursor.next(), WayBillInfoEntity.class));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			db.requestDone();
		}
		return infos;
	}

	@Override
	public WayBillInfoEntity findWayBillInfo(String openid, String wayBill) {
		WayBillInfoEntity info = null;
		DB db = mongo.getDB(DB_NAME);
		try {
			db.requestStart();
			DBCollection coll = db.getCollection(WAYBILLINFO);
			//查询条件
			DBObject query = new BasicDBObject();
			query.put("openid", openid);
			query.put("wayBill", wayBill);
			
			DBObject result = coll.findOne(query);
			if(result != null){
				info =  BeanUtil.dbObject2Bean(result, WayBillInfoEntity.class);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			db.requestDone();
		}
		return info;
	}

	@Override
	public void saveWayBill(WayBillInfoEntity wayill) {
		DB db = mongo.getDB(DB_NAME);
		try {
			db.requestStart();
			DBCollection coll = db.getCollection(WAYBILLINFO);
			//查询条件
			DBObject lr = BeanUtil.bean2DBObject(wayill);
			coll.save(lr);
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			db.requestDone();
		}
	}

}
