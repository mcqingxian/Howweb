/**
 * 
 */
package com.hoau.wechat.dao.impl;

import java.util.Date;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;

import com.hoau.wechat.constant.OMSConstants;
import com.hoau.wechat.dao.BaseDao;
import com.hoau.wechat.dao.IOrderManagerWechatDao;
import com.hoau.wechat.entity.OrderEntity;
import com.hoau.wechat.service.impl.OrderManagerWechatService;
import com.hoau.wechat.util.BeanUtil;
import com.hoau.wechat.utils.net.WeixinUtil;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;

/**
 * @author gaojia
 * 
 */
@Repository
public class OrderManagerWechatDao extends BaseDao implements
		IOrderManagerWechatDao {
	private static final Log LOG = LogFactory.getLog(OrderManagerWechatService.class);

	@Override
	public void saveOrder(OrderEntity order) {
		DB db = mongo.getDB(DB_NAME);
		try {
			// 慧聪过来订单没有 openid，通过手机号摘要作为openid，保存相关订单信息
			String openId = null;
			try {
				openId = WeixinUtil.getOpenIdFromSession();
			} catch (Exception e) {
				LOG.error("获取OPENID失败，此订单来自慧聪："+e.getMessage());
				openId = DigestUtils.md5Hex(order.getShipperMobile() == null?order.getShipperMobile() :order.getShipperPhone());
			}
			order.setOrderStatus(OMSConstants.ORDER_STATUS.ADD);
			order.setCreateDate(new Date());
			order.setUpdateDate(new Date());
			db.requestStart();
			DBCollection coll = db.getCollection(COLLECTION_USER_INFO);
			
			coll.update(new BasicDBObject("openid", openId), new BasicDBObject(
					"$push", new BasicDBObject("orders", BeanUtil.bean2DBObject(order))));
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			db.requestDone();
		}
	}

	@Override
	public void cancelOrder(String orderNo) {
		DB db = mongo.getDB(DB_NAME);
		try {
			String openId = WeixinUtil.getOpenIdFromSession();
			db.requestStart();
			DBObject ob = new BasicDBObject();
			ob.put("openid", openId);
			ob.put("orders.orderNo", orderNo);
			DBCollection coll = db.getCollection(COLLECTION_USER_INFO);
			coll.update(ob, new BasicDBObject(
					"$set", new BasicDBObject("orders.$.orderStatus", OMSConstants.ORDER_STATUS.VOID)));
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			db.requestDone();
		}

	}

	@Override
	public void modifyOrder(OrderEntity order) {
		DB db = mongo.getDB(DB_NAME);
		try {
			String openId = WeixinUtil.getOpenIdFromSession();

			db.requestStart();
			DBCollection coll = db.getCollection(COLLECTION_USER_INFO);
			coll.update(new BasicDBObject("openid", openId), new BasicDBObject(
					"$pull", new BasicDBObject("orders", new BasicDBObject(
							"orderNo", order.getOrderNo()))));
			coll.update(new BasicDBObject("openid", openId), new BasicDBObject(
					"$push", new BasicDBObject("orders", BeanUtil.bean2DBObject(order))));
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			db.requestDone();
		}

	}

}
