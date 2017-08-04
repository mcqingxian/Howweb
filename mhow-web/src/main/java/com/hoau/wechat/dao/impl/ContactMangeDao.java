package com.hoau.wechat.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.hoau.wechat.dao.BaseDao;
import com.hoau.wechat.dao.IContactMangeDao;
import com.hoau.wechat.util.BeanUtil;
import com.hoau.wechat.util.JsonUtils;
import com.hoau.wechat.vo.Contacts;
import com.hoau.wechat.vo.UserInfo;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;

@Repository
public class ContactMangeDao extends BaseDao implements IContactMangeDao {

	@Override
	public boolean isExist(String openId, Contacts contacts) {
		boolean isExists = false;
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
			cols.put("contacts_list", 1);
			DBObject rtn = coll.findOne(object, cols);
			if(rtn == null){
				return isExists;
			}
			userInfo = BeanUtil.dbObject2Bean(rtn, UserInfo.class);
			if(rtn != null && rtn.get("contacts_list") != null){
				userInfo.setContacts_list(JsonUtils.toList(rtn.get("contacts_list").toString(), Contacts.class));
			}
			List<Contacts> cList = userInfo.getContacts_list();
			if(cList != null){
				for(Contacts c : cList){
					if(c.getPhone().equals(contacts.getPhone())){
						isExists = true;
						break;
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			db.requestDone();
		}
		return isExists;
	}

	@Override
	public void addContacts(String openId, Contacts contacts) {
		DB db = mongo.getDB(DB_NAME);
		try {
			db.requestStart();
			DBCollection coll = db.getCollection(COLLECTION_USER_INFO);
			//查询条件
			DBObject object = new BasicDBObject();
			object.put("openid", openId);
			
			DBObject ctacts = BeanUtil.bean2DBObject(contacts);
			
			DBObject carry = new BasicDBObject();
			carry.put("contacts_list", ctacts);
			
			DBObject cadd = new BasicDBObject();
			cadd.put("$push", carry);
			
			coll.update(object, cadd);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			db.requestDone();
		}
	}

	@Override
	public List<Contacts> query(String openId) {
		List<Contacts> cts = new ArrayList<Contacts>();
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
			cols.put("contacts_list", 1);
			
			DBObject rtn = coll.findOne(object, cols);
			if(rtn != null && rtn.get("contacts_list") != null){
				cts = JsonUtils.toList(rtn.get("contacts_list").toString(), Contacts.class);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			db.requestDone();
		}
		return cts;
	}

	@Override
	public Contacts queryOne(String openId, String id) {
		List<Contacts> cts = new ArrayList<Contacts>();
		Contacts contacts = null;
		DB db = mongo.getDB(DB_NAME);
		try {
			db.requestStart();
			DBCollection coll = db.getCollection(COLLECTION_USER_INFO);
			//查询条件
			DBObject object = new BasicDBObject();
			object.put("openid", openId);
			//结果返回列过滤
			DBObject cols = new BasicDBObject();
			cols.put("contacts_list", 1);
			DBObject rtn = coll.findOne(object, cols);
			if(rtn != null && rtn.get("contacts_list") != null){
				cts = JsonUtils.toList(rtn.get("contacts_list").toString(), Contacts.class);
			}
			for(Contacts c : cts){
				if(c.getId().equals(id)){
					contacts = c;
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			db.requestDone();
		}
		return contacts;
	}

	@Override
	public void delete(String openId, String contactsId) {
		DB db = mongo.getDB(DB_NAME);
		try {
			db.requestStart();
			DBCollection coll = db.getCollection(COLLECTION_USER_INFO);
			//查询条件
			DBObject condition = new BasicDBObject();
			condition.put("openid", openId);
			//结果返回列过滤
			DBObject pull = new BasicDBObject();
			pull.put("$pull", new BasicDBObject("contacts_list", new BasicDBObject("id", contactsId)));
			
			coll.update(condition, pull);
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			db.requestDone();
		}
	}

	@Override
	public Contacts queryContactsByNameAndPhone(String openId, String name,
			String phone,int type) {
		List<Contacts> cts = new ArrayList<Contacts>();
		Contacts contacts = null;
		DB db = mongo.getDB(DB_NAME);
		try {
			db.requestStart();
			DBCollection coll = db.getCollection(COLLECTION_USER_INFO);
			//查询条件
			DBObject object = new BasicDBObject();
			object.put("openid", openId);
			//结果返回列过滤
			DBObject cols = new BasicDBObject();
			cols.put("contacts_list", 1);
			DBObject rtn = coll.findOne(object, cols);
			if(rtn != null && rtn.get("contacts_list") != null){
				cts = JsonUtils.toList(rtn.get("contacts_list").toString(), Contacts.class);
			}
			if(cts!=null&&!cts.isEmpty()){
				for (Contacts con : cts) {
					if(name.equals(con.getName())&&phone.equals(con.getPhone())&&type== con.getType()){
						contacts = con;
						break;
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			db.requestDone();
		}
		return contacts;
	}
	
}
