package com.hoau.wechat.dao.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Repository;

import com.hoau.wechat.dao.BaseDao;
import com.hoau.wechat.dao.ILotteryRecordDao;
import com.hoau.wechat.util.BeanUtil;
import com.hoau.wechat.util.UUIDUtil;
import com.hoau.wechat.vo.CompusActivityCode;
import com.hoau.wechat.vo.CompusActivityInfo;
import com.hoau.wechat.vo.LotteryRecord;
import com.hoau.wechat.vo.ShareRecode;
import com.hoau.wechat.vo.VoucherActivity;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;

@Repository
public class LotteryRecordDao extends BaseDao implements ILotteryRecordDao{

	@Override
	public LotteryRecord findLotterByVersonNo(String openid, String type, String versionNo) {
		LotteryRecord record = null;
		DB db = mongo.getDB(DB_NAME);
		try {
			db.requestStart();
			DBCollection collection = db.getCollection(COLLECTION_WEICHAT_LOTTERYRECORD);
			//查询条件
			DBObject object = new BasicDBObject();
			object.put("openid",openid);
			object.put("type",type);
			object.put("id",versionNo);
			
			DBObject obj = collection.findOne(object);
			
			if(obj != null){
				record = BeanUtil.dbObject2Bean(obj, LotteryRecord.class);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			db.requestDone();
		}
		return record;
	}

	@Override
	public List<LotteryRecord> queryLotteryRecord(String openid, String type, String phone) {
		List<LotteryRecord> records = new ArrayList<LotteryRecord>();
		DB db = mongo.getDB(DB_NAME);
		try {
			db.requestStart();
			DBCollection collection = db.getCollection(COLLECTION_WEICHAT_LOTTERYRECORD);
			//查询条件
			DBObject query = new BasicDBObject();
			query.put("openid",openid);
			query.put("type",type);
			query.put("phone",phone);
			
			DBCursor cursor = collection.find(query).sort(new BasicDBObject("lotteryTime",-1));
			
			while(cursor.hasNext()){
				records.add(BeanUtil.dbObject2Bean(cursor.next(), LotteryRecord.class));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			db.requestDone();
		}
		return records;
	}

	@Override
	public void saveSharedRecord(ShareRecode shareRecode) {
		DB db = mongo.getDB(DB_NAME);
		try {
			db.requestStart();
			DBCollection collection = db.getCollection(COLLECTION_WEICHAT_SHARERECORD);
			DBObject obj = BeanUtil.bean2DBObject(shareRecode);
			collection.save(obj);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			db.requestDone();
		}
	}

	@Override
	public void updateLotteryRecord(LotteryRecord lotteryRecord) {
		DB db = mongo.getDB(DB_NAME);
		try {
			db.requestStart();
			DBCollection collection = db.getCollection(COLLECTION_WEICHAT_LOTTERYRECORD);
			//查询条件
			DBObject query = new BasicDBObject();
			query.put("openid",lotteryRecord.getOpenid());
			query.put("type",lotteryRecord.getType());
			query.put("waybill",lotteryRecord.getWaybill());
			
			//更新内容
			DBObject update = new BasicDBObject();
			update.put("$set", new BasicDBObject("lotteryTime",new Date())
			.append("vouchersNo", lotteryRecord.getVouchersNo()).append("detail", lotteryRecord.getDetail()));
			collection.update(query, update);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			db.requestDone();
		}
	}

	@Override
	public LotteryRecord findLotteryRecord(String openid, String type, String wayBill) {
		LotteryRecord record = null;
		DB db = mongo.getDB(DB_NAME);
		try {
			db.requestStart();
			DBCollection collection = db.getCollection(COLLECTION_WEICHAT_LOTTERYRECORD);
			//查询条件
			DBObject object = new BasicDBObject();
			object.put("openid",openid);
			object.put("type",type);
			object.put("waybill",wayBill);
			
			DBObject obj = collection.findOne(object);
			
			if(obj != null){
				record = BeanUtil.dbObject2Bean(obj, LotteryRecord.class);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			db.requestDone();
		}
		return record;
	}

	@Override
	public List<VoucherActivity> findLastLotteryRecord() {
		List<VoucherActivity> records = new ArrayList<VoucherActivity>();
		DB db = mongo.getDB(DB_NAME);
		try {
			db.requestStart();
			DBCollection coll = db.getCollection(COMPUS_ACTIVITY_TICKET);
			DBObject query = new BasicDBObject("status",1);
			DBObject sort = new BasicDBObject("modifyTime",-1);
			DBCursor cursor = coll.find(query).sort(sort);
			while(cursor.hasNext()){
				records.add(BeanUtil.dbObject2Bean(cursor.next(), VoucherActivity.class));
				if(records.size() == 5){
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			db.requestDone();
		}
		return records;
	}

	@Override
	public void updateVoucher(Integer id, String openid, String ticketCode, Integer expiry) {
		DB db = mongo.getDB(DB_NAME);
		try {
			DBCollection conn = db.getCollection(COMPUS_ACTIVITY_TICKET);
			
			if(expiry == null){
				//查询
				DBObject query = new BasicDBObject();
				query.put("id", id);
				//更新内容
				DBObject update = new BasicDBObject();
				update.put("$set", new BasicDBObject("status",1).append("openid", openid).append("modifyTime", new Date()));
				conn.update(query, update);
			}else{
				//查询
				DBObject query = new BasicDBObject();
				query.put("vouchersCode", ticketCode);
				//更新内容
				DBObject update = new BasicDBObject();
				update.put("$set", new BasicDBObject("expiry",expiry));
				conn.update(query, update);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			db.requestDone();
		}
	}

	@Override
	public VoucherActivity findVoucher(Integer id, String openid) {
		VoucherActivity voucher = null;
		DB db = mongo.getDB(DB_NAME);
		try {
			db.requestStart();
			DBCollection conn = db.getCollection(COMPUS_ACTIVITY_TICKET);
			
			//查询条件
			BasicDBObject condition=new BasicDBObject(); 
			if(id != null){
				condition.put("id", id);
			}else{
				condition.put("openid", openid);
			}
			
			DBObject obj = conn.findOne(condition);
			if(obj != null){
				voucher = BeanUtil.dbObject2Bean(obj, VoucherActivity.class);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			db.requestDone();
		}
		return voucher;
	}

	@Override
	public int winningCountInDay() {
		int count = 0;
		DB db = mongo.getDB(DB_NAME);
		try {
			db.requestStart();
			DBCollection conn = db.getCollection(COMPUS_ACTIVITY_TICKET);
			
			//查询条件
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
			BasicDBObject condition=new BasicDBObject(); 
			condition.put("status", 1);
			condition.put("modifyTime", new BasicDBObject().append("$gte",sdf.parse(sdf.format(new Date()).split(" ")[0] + " 00:00:00")));
		    count = (int) conn.getCount(condition);
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			db.requestDone();
		}
		return count;
	}

	@Override
	public int remainderLotteryTicketCount() {
		int count = 0;
		DB db = mongo.getDB(DB_NAME);
		try {
			db.requestStart();
			DBCollection conn = db.getCollection(COMPUS_ACTIVITY_TICKET);
			
			DBObject query = new BasicDBObject();
			query.put("status", 0);
			
			count = (int) conn.getCount(query);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			db.requestDone();
		}
		return count;
	}



	@Override
	public boolean hasLotteryOfOpenId(String openid) {
		boolean hasLottery = false;
		DB db = mongo.getDB(DB_NAME);
		try {
			db.requestStart();
			DBCollection conn = db.getCollection(COMPUS_ACTIVITY_TICKET);
			
			DBObject query = new BasicDBObject();
			query.put("openid", openid);
			
			int count = (int) conn.getCount(query);
			if(count > 0){
				hasLottery = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			db.requestDone();
		}
		return hasLottery;
	}



	@Override
	public List<CompusActivityInfo> findActivityinfos(String openid) {
		List<CompusActivityInfo> infos = new ArrayList<CompusActivityInfo>();
		DB db = mongo.getDB(DB_NAME);
		try {
			db.requestStart();
			DBCollection conn = db.getCollection(COMPUS_ACTIVITY_INFO);
			
			DBObject query = new BasicDBObject();
			query.put("openid", openid);
			query.put("status", 0);
			
			DBCursor cursor = conn.find(query);
			while(cursor.hasNext()){
				infos.add(BeanUtil.dbObject2Bean(cursor.next(), CompusActivityInfo.class));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			db.requestDone();
		}
		return infos;
	}



	@Override
	public void updateActivityInfo(String competitionCode, Integer forwardCount, Integer status, String friendOpenid) {
		DB db = mongo.getDB(DB_NAME);
		try {
			db.requestStart();
			DBCollection conn = db.getCollection(COMPUS_ACTIVITY_INFO);
			//查询
			DBObject query = new BasicDBObject();
			query.put("competitionCode", competitionCode);
			
			//更新内容
			DBObject update = new BasicDBObject();
			if(status != null){
				update.put("$set", new BasicDBObject("status",1));
			}else if(forwardCount != null){
				update.put("$set", new BasicDBObject("forwardCount",forwardCount).append("friendOpenid", friendOpenid));
			}
			conn.update(query, update);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			db.requestDone();
		}
	}



	@Override
	public CompusActivityInfo findActivityInfo(String code, String openid) {
		CompusActivityInfo info = null;
		DB db = mongo.getDB(DB_NAME);
		try {
			db.requestStart();
			DBCollection conn = db.getCollection(COMPUS_ACTIVITY_INFO);
			
			DBObject query = new BasicDBObject();
			if(!StringUtils.isEmpty(code)){
				query.put("competitionCode", code);
			}else{
				query.put("openid", openid);
			}
			
			DBObject obj = conn.findOne(query);
			if(obj != null){
				info = BeanUtil.dbObject2Bean(obj, CompusActivityInfo.class);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			db.requestDone();
		}
		return info;
	}



	@Override
	public void saveActivityInfo(CompusActivityInfo info) {
		DB db = mongo.getDB(DB_NAME);
		try {
			db.requestStart();
			DBCollection conn = db.getCollection(COMPUS_ACTIVITY_INFO);
			DBObject obj = BeanUtil.bean2DBObject(info);
			conn.save(obj);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			db.requestDone();
		}
	}



	@Override
	public void updateActivityCodeStatus(CompusActivityCode code) {
		DB db = mongo.getDB(DB_NAME);
		try {
			db.requestStart();
			DBCollection con = db.getCollection(COMPUS_ACTIVITY_CODE);
			//查询条件
			DBObject query = new BasicDBObject();
			query.put("id", code.getId());
			
			//更新内容
			DBObject update = new BasicDBObject();
			update.put("$set", new BasicDBObject("status",1));
			con.update(query, update);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			db.requestDone();
		}
	}



	@Override
	public boolean hasQualificationsToday(String openid){
		boolean hasQualification = false;
		DB db = mongo.getDB(DB_NAME);
		try {
			db.requestStart();
			DBCollection con = db.getCollection(COMPUS_ACTIVITY_INFO);
			
			//查询条件
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
			BasicDBObject condition=new BasicDBObject(); 
			condition.put("openid", openid);
			condition.put("createTime", new BasicDBObject().append("$gte",sdf.parse(sdf.format(new Date()).split(" ")[0] + " 00:00:00")));
		    int count = (int) con.getCount(condition);
		    if(count >= 2){
		    	hasQualification = false;
		    }else{
		    	hasQualification = true;
		    }
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			db.requestDone();
		}
		return hasQualification;
	}

	

	@Override
	public CompusActivityCode gainCompetitionCode() {
		CompusActivityCode code = null;
		Random ran = new Random();
		DB db = mongo.getDB(DB_NAME);
		try {
			db.requestStart();
			DBCollection con = db.getCollection(COMPUS_ACTIVITY_CODE);
			DBObject res = null;
			do{
				DBObject obj = new BasicDBObject();
				obj.put("id", ran.nextInt(100000));
				res = con.findOne(obj);
				if(res != null){
					code = BeanUtil.dbObject2Bean(res, CompusActivityCode.class);
				}
			}while(res == null && code.getStatus() != 0);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			db.requestDone();
		}
		return code;
	}



	@Override
	public List<LotteryRecord> getLotteryRecord(String openid, String type) {
		List<LotteryRecord> records = new ArrayList<LotteryRecord>();
		DB db = mongo.getDB(DB_NAME);
		try {
			db.requestStart();
			DBCollection collection = db.getCollection(COLLECTION_WEICHAT_LOTTERYRECORD);
			//查询条件
			DBObject object = new BasicDBObject();
			object.put("openid",openid);
			if(!StringUtils.isEmpty(type)){
				object.put("type",type);
			}
			
			DBCursor cursor = collection.find(object);
			
			while(cursor.hasNext()){
				records.add(BeanUtil.dbObject2Bean(cursor.next(), LotteryRecord.class));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			db.requestDone();
		}
		return records;
	}

	@Override
	public void saveLotteryRecord(LotteryRecord lotteryRecord) {
		DB db = mongo.getDB(DB_NAME);
		try {
			db.requestStart();
			DBCollection collection = db.getCollection(COLLECTION_WEICHAT_LOTTERYRECORD);
			
			DBObject obj = BeanUtil.bean2DBObject(lotteryRecord);
			collection.save(obj);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			db.requestDone();
		}
	}
	
	
	public static void main(String[] args)throws Exception {
		
		
		
		LotteryRecordDao dao = new LotteryRecordDao();
//		System.out.println(JsonUtils.toJson(dao.findActivityinfos("oz4uxjig_7wG45QzJP00oeCFl7Aa")));
//		dao.updateVoucher(1, "oz4uxjig_7wG45QzJP00oeCFl7Ao", null,null);
		
//		System.out.println(dao.winningCountInDay());
		ShareRecode record = new ShareRecode();
		record.setId(UUIDUtil.getUUID());
		record.setShareTime(new Date());
		record.setArticleid("article20150609");
		record.setOpenid("oz4uxjig_7wG45QzJP00oeCFl7Ao");
		record.setState("article20150609");
		dao.saveSharedRecord(record);
		
//		DB db = null;
//		try {
//			Mongo mongo = new Mongo("localhost", 27017);
//			db = mongo.getDB("wechat");
//			db.requestStart();
//			DBCollection con = db.getCollection(COMPUS_ACTIVITY_INFO);
//			
//			//查询条件
//			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
//			BasicDBObject condition=new BasicDBObject(); 
//			System.out.println(sdf.format(new Date()).split(" ")[0] + " 00:00:00");
//			condition.put("createTime", new BasicDBObject("$gte",sdf.parse(sdf.format(new Date()).split(" ")[0] + " 00:00:00")));
////			condition.put("createTime", new BasicDBObject("$lte",new Date()));
//			condition.put("openid", "oz4uxjig_7wG45QzJP00oeCFl7Ao");
//		    int count = (int) con.getCount(condition);
//		    System.out.println(count);
//			
//		} catch (UnknownHostException e) {
//			e.printStackTrace();
//		}finally{
//			db.requestDone();
//		}
	}

}
