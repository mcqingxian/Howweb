package com.hoau.wechat.dao.impl;


import org.springframework.stereotype.Repository;

import com.hoau.wechat.dao.BaseDao;
import com.hoau.wechat.dao.IUserInfoDao;
import com.hoau.wechat.util.BeanUtil;
import com.hoau.wechat.vo.UserInfo;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;

/** 
* @ClassName  :UserInfoDao 
* @Description:TODO 
* @author     :xujun cometzb@126.com	
* @date       :2014年4月29日 上午9:18:07 
*  
*/
@Repository
public class UserInfoDao extends BaseDao implements IUserInfoDao {
	@Override
	public void bind(UserInfo userInfo) {
		DB db = mongo.getDB(DB_NAME);
		try {
			db.requestStart();
			DBCollection coll = db.getCollection(COLLECTION_USER_INFO);
			DBObject object = BeanUtil.bean2DBObject(userInfo);
			coll.save(object);
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			db.requestDone();
		}
		
	}

	@Override
	public UserInfo findOne(String openId) {
		UserInfo userInfo = null;
		DB db = mongo.getDB(DB_NAME);
		try {
			db.requestStart();
			DBCollection coll = db.getCollection(COLLECTION_USER_INFO);
			//查询条件
			DBObject object = new BasicDBObject();
			object.put("openid", openId);
			//结果返回列过滤
			DBObject cols = new BasicDBObject();
			cols.put("_id", 1);
			cols.put("openid", 1);
			cols.put("phone", 1);
			cols.put("create_time", 1);
			cols.put("update_time", 1);
			
			DBObject rtn = coll.findOne(object, cols);
			if(rtn != null){
				userInfo = BeanUtil.dbObject2Bean(rtn, UserInfo.class);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			db.requestDone();
		}
		return userInfo;
	}

	@Override
	public void updatePhone(String openId,String phone) {
		DB db = mongo.getDB(DB_NAME);
		try {
			db.requestStart();
			DBCollection coll = db.getCollection(COLLECTION_USER_INFO);
			//查询条件
			DBObject object = new BasicDBObject();
			object.put("openid", openId);
			//结果返回列过滤
			DBObject u1 = new BasicDBObject();
			u1.put("phone", phone);
			DBObject u2 = new BasicDBObject();
			
			u2.put("$set", u1);
			coll.update(object, u2);
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			db.requestDone();
		}
	}

	@Override
	public void saveValidate(String openId, String valCode) {
		DB db = mongo.getDB(DB_NAME);
		try {
			db.requestStart();
			DBCollection coll = db.getCollection(COLLECTION_VALIDATE_INFO);
			DBObject object = new BasicDBObject();
			object.put("openId", openId);
			object.put("valicode", valCode);
			coll.save(object);
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			db.requestDone();
		}
	}

	@Override
	public String getValiteCode(String openId) {
		String rtn = null;
		DB db = mongo.getDB(DB_NAME);
		try {
			db.requestStart();
			DBCollection coll = db.getCollection(COLLECTION_VALIDATE_INFO);
			//查询条件
			DBObject object = new BasicDBObject();
			object.put("openId", openId);
			
			DBObject dbObject = coll.findOne(object);
			if(dbObject != null){
				rtn = (String)dbObject.get("valicode");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			db.requestDone();
		}
		return rtn;
	}

	@Override
	public void updateValiCode(String openId, String valCode) {
		DB db = mongo.getDB(DB_NAME);
		try {
			db.requestStart();
			DBCollection coll = db.getCollection(COLLECTION_VALIDATE_INFO);
			//查询条件
			DBObject object = new BasicDBObject();
			object.put("openId", openId);
			// 更新验证码
			DBObject u2 = new BasicDBObject();
			u2.put("$set",  new BasicDBObject("valicode", valCode));
			
			coll.update(object, u2);
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			db.requestDone();
		}
	}
}
