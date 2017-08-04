/**
 * 
 */
package com.hoau.wechat.dao.impl;

import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.hoau.wechat.dao.IRegisterDao;
import com.hoau.wechat.entity.UserEntity;
import com.hoau.wechat.util.BeanUtil;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.Mongo;

/**
 * @author gaojia
 * 
 */
@Repository
public class RegisterDao implements IRegisterDao {
	private static final String DB_NAME = "wechat";
	private static final String COLLECTION_NAME = "oms_register";
	/*@Resource
	private Mongo mongo;*/

	@Override
	public void register(UserEntity user) {
		DB db = null;//mongo.getDB(DB_NAME);
		try {
			db.requestStart();
			DBCollection coll = db.getCollection(COLLECTION_NAME);
			user.setCreateTime(new Date());
			DBObject object = BeanUtil.bean2DBObject(user);
			coll.save(object);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			db.requestDone();
		}

	}

	@Override
	public boolean checkRegister(String userName) {
		DB db = null;//mongo.getDB(DB_NAME);
		try {
			db.requestStart();
			DBCollection coll = db.getCollection(COLLECTION_NAME);
			DBObject object = new BasicDBObject();
			object.put("name", userName);
			DBObject rtn = coll.findOne(object);
			if (rtn != null) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			db.requestDone();
		}
	}

}
