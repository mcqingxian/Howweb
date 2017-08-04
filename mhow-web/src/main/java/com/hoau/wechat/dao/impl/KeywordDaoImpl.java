package com.hoau.wechat.dao.impl;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.hoau.wechat.constant.Constant;
import com.hoau.wechat.dao.BaseDao;
import com.hoau.wechat.dao.IkeywordDao;
import com.hoau.wechat.util.BeanUtil;
import com.hoau.wechat.vo.KeyWord;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.Mongo;

/**
 * @author 作者lanhong zhang E-mail:
 * @version 创建时间：2015年3月26日 上午9:29:10
 * 类说明  ： 关键字说明
 */
@Repository
@Scope("prototype")
public class KeywordDaoImpl extends BaseDao implements IkeywordDao {

/*	@Override
	public List<KeyWord> getKeyword() {
		List<KeyWord> kws = new ArrayList<KeyWord>();
		try {
			Mongo m = new Mongo("10.39.59.153",27017);
			
			DB db = m.getDB(DB_NAME);
			try{
				db.requestStart();
				DBCollection coll = db.getCollection(COLLECTION_KEYWORD);
				DBCursor cursor= coll.find();
				while(cursor.hasNext()){
					DBObject dbObject = cursor.next();
					kws.add(BeanUtil.dbObject2Bean(dbObject, KeyWord.class));
				}
			}catch(Exception e){
				e.printStackTrace();
			}finally{
				db.requestDone();
				m.close();
			}
		} catch (UnknownHostException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return kws;
	}*/
	@Override
	public List<KeyWord> getKeyword() {
		List<KeyWord> kws = new ArrayList<KeyWord>();
		DB db = mongo.getDB(DB_NAME);
		try{
			db.requestStart();
			DBCollection coll = db.getCollection(COLLECTION_KEYWORD);
			DBCursor cursor= coll.find();
			while(cursor.hasNext()){
				DBObject dbObject = cursor.next();
				kws.add(BeanUtil.dbObject2Bean(dbObject, KeyWord.class));
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			db.requestDone();
		}
		return kws;
	}
//	public static void main(String[] args) throws Exception {
//		KeywordDaoImpl kd = new KeywordDaoImpl();
//		System.out.println(JsonUtils.toJson(kd.getKeyword()));
//	}
	
	public static void main(String[] args) {
		try {
			//1 建立连接
//			Mongo m = new Mongo("localhost",27017);
//			DB db = m.getDB("wechat");
			Mongo m = new Mongo("10.39.251.105",27017);
			DB db = m.getDB("wechat");
			//2 取得DBCollection 没有会自动创建
//			DBCollection coll =  db.getCollection("keywordTest");
//			DBCollection coll = db.getCollection("keyword");
			DBCollection coll = db.getCollection("lotterytickets");
			//3 获得Map 对象
			BasicDBObject doc = new BasicDBObject();
			//4 插入数据
			doc.put("id", 888123);
			doc.put("vouchersName", "5.00");
			doc.put("status", 0);
			doc.put("vouchersCode", "YDJ150123");
			doc.put("type", Constant.COUPON_YDJ);
			doc.put("expiry", 20);
//			doc.put("keyword","抵用劵");
			coll.insert(doc);
			System.out.println("插入成功");
		} catch (UnknownHostException e) {
			System.out.println("插入失败！");
			e.printStackTrace();
		}
	}
}
