package com.hoau.wechat.dao.impl;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.hoau.wechat.dao.BaseDao;
import com.hoau.wechat.dao.IVouchersDao;
import com.hoau.wechat.util.BeanUtil;
import com.hoau.wechat.vo.Vouchers;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
@Repository
@Scope("prototype")
public class VouchersDao extends BaseDao implements IVouchersDao{

	@Override
	public void saveVouchers(Vouchers vouchers) {
		DB db = mongo.getDB(DB_NAME);
		try {
			db.requestStart();
			DBCollection coll = db.getCollection(COLLECTION_WEICHAT_LOTTERYTICKETS);
			//查询条件
			DBObject lr = BeanUtil.bean2DBObject(vouchers);
			coll.save(lr);
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			db.requestDone();
		}
	}

}
