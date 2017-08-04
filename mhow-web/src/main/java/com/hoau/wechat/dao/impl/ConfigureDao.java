package com.hoau.wechat.dao.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.hoau.wechat.dao.BaseDao;
import com.hoau.wechat.dao.IConfigureDao;
import com.hoau.wechat.util.BeanUtil;
import com.hoau.wechat.util.JsonUtils;
import com.hoau.wechat.vo.Configure;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.Mongo;
@Repository
public class ConfigureDao extends BaseDao implements IConfigureDao{
	
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	
	public static void main(String[] args) {
		ConfigureDao dao = new ConfigureDao();
//		dao.init(null);
		Configure configure = dao.findConfigureTest("APP", "orderSource");
		System.out.println(JsonUtils.toJson(configure));
	}
	
	public Configure findConfigureTest(String source,String type) {
		Configure configre = null;
		DB db = null;
		try {
			Mongo mongo = new Mongo("10.39.59.153", 27017);
			db = mongo.getDB("wechat");
			db.requestStart();
			DBCollection con = db.getCollection(CONFIGURE_CONSTANT);
			
			DBObject query = new BasicDBObject();
			
			query.put("type", type);
			query.put("key", source);
			
			DBObject cursor = con.findOne(query);
			if(cursor != null){
				configre = BeanUtil.dbObject2Bean(cursor, Configure.class);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			db.requestDone();
		}
		return configre;
	}
	
	public List<Configure> findConfigureTest(String type) {
		List<Configure> configres = new ArrayList<Configure>();
		DB db = null;
		try {
			Mongo mongo = new Mongo("10.39.59.153", 27017);
			db = mongo.getDB("wechat");
			db.requestStart();
			DBCollection con = db.getCollection(CONFIGURE_CONSTANT);
			
			DBObject query = new BasicDBObject();
			query.put("type", type);
			
			DBCursor cursor = con.find(query);
			while(cursor.hasNext()){
				configres.add(BeanUtil.dbObject2Bean(cursor.next(), Configure.class));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			db.requestDone();
		}
		return configres;
	}

	public void init(Configure configure) {
		String[][] str = {{"400", "400订单"}, {"BRANCH", "网点订单"}, {"TNTMAIL", "TNT订单"}, {"BIG_CUSTOMER", "大客户订单"},
				{"TAOBAO", "淘宝订单"}, {"ALIBABA", "阿里巴巴订单"}, {"NET_ORDER", "华宇网站订单"}, {"MBL_ORDER", "手机订单"},
				{"KINGDEE", "金蝶友商订单"}, {"QQSD", "QQ速递订单"}, {"CLBUS_VIP", "哥伦布付费会员订单"}, {"CLBUS_MEM", "哥伦布普通会员订单"},
				{"DESK_ORDER", "桌面华宇订单"}, {"SUNING", "苏宁"}, {"HQP", "华强宝"}, {"TM", "天猫"},{"HCW","慧聪网"},{"ALIPAY","支付宝服务窗订单"},
				{"APP","APP订单"},{"IMPORT_ORDER","订单导入"},{"OPEN","开放平台订单"},{"WECHAT","微信公众号订单"}};

		
		DB db = null;
		try {
			Mongo mongo = new Mongo("10.39.59.153", 27017);
			db = mongo.getDB("wechat");
			DBCollection collection = db.getCollection(CONFIGURE_CONSTANT);
			
			for(int i=0;i<str.length;i++){
				Configure con = new Configure();
				con.setActive("N");
				if("HCW".equals(str[i][0])){
					con.setActive("Y");
					con.setVouchersCount(3);
					con.setParValue(10);
					con.setStartTime(sdf.parse("2015/07/01 00:00:00"));
					con.setEndTime(sdf.parse("2015/09/30 23:59:59"));
				}
				if("MBL_ORDER".equals(str[i][0])){
					con.setActive("Y");
					con.setVouchersCount(3);
					con.setParValue(10);
					con.setStartTime(sdf.parse("2015/07/01 00:00:00"));
					con.setEndTime(sdf.parse("2015/09/30 23:59:59"));
				}
				if("ALIBABA".equals(str[i][0])){
					con.setActive("Y");
					con.setVouchersCount(1);
					con.setParValue(10);
					con.setStartTime(sdf.parse("2015/08/01 00:00:00"));
					con.setEndTime(sdf.parse("2015/09/30 23:59:59"));
				}
				if("WECHAT".equals(str[i][0])){
					con.setActive("Y");
					con.setVouchersCount(3);
					con.setParValue(10);
					con.setStartTime(sdf.parse("2015/07/01 00:00:00"));
					con.setEndTime(sdf.parse("2015/09/30 23:59:59"));
				}
				if("APP".equals(str[i][0])){
					con.setActive("Y");
					con.setVouchersCount(3);
					con.setParValue(10);
					con.setStartTime(sdf.parse("2015/07/01 00:00:00"));
					con.setEndTime(sdf.parse("2015/09/30 23:59:59"));
				}
				if("NET_ORDER".equals(str[i][0])){
					con.setActive("Y");
					con.setVouchersCount(3);
					con.setParValue(10);
					con.setStartTime(sdf.parse("2015/07/01 00:00:00"));
					con.setEndTime(sdf.parse("2015/09/30 23:59:59"));
				}
				con.setKey(str[i][0]);
				con.setValue(str[i][1]);
				con.setType("orderSource");
				System.out.println(JsonUtils.toJson(con));
				
				collection.save(BeanUtil.bean2DBObject(con));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (db != null) {
				db.requestDone();
			}
		}
	}
	
	@Override
	public void save(Configure configure) {
		DB db = mongo.getDB(DB_NAME);
		try {
			db.requestStart();
			DBCollection coll = db.getCollection(CONFIGURE_CONSTANT);
			//查询条件
			DBObject lr = BeanUtil.bean2DBObject(configure);
			coll.save(lr);
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			db.requestDone();
		}
	}

	@Override
	public List<Configure> findConfigureByType(String type) {
		List<Configure> configres = new ArrayList<Configure>();
		DB db = mongo.getDB(DB_NAME);
		try {
			db.requestStart();
			DBCollection con = db.getCollection(CONFIGURE_CONSTANT);
			
			DBObject query = new BasicDBObject();
			query.put("type", type);
			
			DBCursor cursor = con.find(query);
			while(cursor.hasNext()){
				configres.add(BeanUtil.dbObject2Bean(cursor.next(), Configure.class));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			db.requestDone();
		}
		return configres;
	}

	@Override
	public List<Configure> findConfigureActive(String type) {
		List<Configure> configres = new ArrayList<Configure>();
		DB db = mongo.getDB(DB_NAME);
		try {
			db.requestStart();
			DBCollection con = db.getCollection(CONFIGURE_CONSTANT);
			
			DBObject query = new BasicDBObject();
			query.put("active", "Y");
			query.put("type", type);
			
			DBCursor cursor = con.find(query);
			while(cursor.hasNext()){
				configres.add(BeanUtil.dbObject2Bean(cursor.next(), Configure.class));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			db.requestDone();
		}
		return configres;
	}

	@Override
	public Configure findConfigure(String key, String type) {
		Configure configure = null;
		DB db = mongo.getDB(DB_NAME);
		try {
			db.requestStart();
			DBCollection con = db.getCollection(CONFIGURE_CONSTANT);
			
			DBObject query = new BasicDBObject();
			query.put("key", key);
			query.put("type", type);
			
			DBObject obj = con.findOne(query);
			if(obj != null){
				configure = BeanUtil.dbObject2Bean(obj, Configure.class);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			db.requestDone();
		}
		return configure;
	}

}
