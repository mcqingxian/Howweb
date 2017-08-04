/**
 * 
 */
package com.hoau.wechat.service.impl;

import java.util.Date;

import javax.annotation.Resource;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import com.hoau.wechat.constant.Constant;
import com.hoau.wechat.dao.IContactMangeDao;
import com.hoau.wechat.dao.IOrderManagerWechatDao;
import com.hoau.wechat.dao.IUserInfoDao;
import com.hoau.wechat.entity.OrderEntity;
import com.hoau.wechat.service.IOrderManagerWechatService;
import com.hoau.wechat.util.StringUtil;
import com.hoau.wechat.util.UUIDUtil;
import com.hoau.wechat.utils.net.WeixinUtil;
import com.hoau.wechat.vo.Contacts;
import com.hoau.wechat.vo.UserInfo;

/**
 * @author gaojia
 * 
 */
@Service
public class OrderManagerWechatService implements IOrderManagerWechatService {
	
	private static final Log LOG = LogFactory.getLog(OrderManagerWechatService.class);
	@Resource
	private IOrderManagerWechatDao orderManagerWechatDao;
	@Resource
	private IUserInfoDao userInfoDao;
	@Resource
	private IContactMangeDao contactMangeDao;

	@Override
	public void saveOrder(OrderEntity order) {
		String openid = null;
		// 慧聪过来订单没有 openid，通过手机号摘要作为openid，保存相关订单信息
		try {
			openid = WeixinUtil.getOpenIdFromSession();
		} catch (Exception e) {
			LOG.error("获取OPENID失败，此订单来自慧聪："+e.getMessage());
			openid = DigestUtils.md5Hex(order.getShipperMobile() == null?order.getShipperMobile() :order.getShipperPhone());
		}
		UserInfo user = userInfoDao.findOne(openid);
		if (user == null) {
			UserInfo userInfo = new UserInfo();
			userInfo.set_id(UUIDUtil.getUUID());
			userInfo.setOpenid(openid);
			userInfo.setCreate_time(new Date());
			userInfo.setUpdate_time(new Date());
			userInfo.setPhone(order.getShipperMobile());
			userInfoDao.bind(userInfo);
		}else if(!StringUtil.isEmpty(user.getPhone())){
			/**
			 * 20150818 收货人信息非必填
			 * @author 275688
			 */
			if(checkConsigneeInfo(order)){
				Contacts consignee = contactMangeDao.queryContactsByNameAndPhone(
						openid, order.getConsigneeName(), order.getConsigneeMobile(),
						Constant.CONTACTS_TYPE_RECEIVER);
				if (consignee == null) {
					Contacts con = new Contacts();
					con.setDetail_address(order.getConsigneeAddress());
					con.setId(UUIDUtil.getUUID());
					con.setName(order.getConsigneeName());
					con.setPhone(order.getConsigneeMobile());
					con.setType(Constant.CONTACTS_TYPE_RECEIVER);
					//con.setCreate_time(new Date());
					//con.setUpdate_time(new Date());
//					con.setPro_city_cty(order.getConsigneeProv()+" "+order.getConsigneeCity()+" "+order.getConsigneeCity());
					con.setPro_city_cty(order.getConsigneeProv()+" "+order.getConsigneeCity()+" "+order.getConsigneeEbrgNameCn());
					contactMangeDao.addContacts(openid, con);
				} else {
					contactMangeDao.delete(openid, consignee.getId());
					Contacts con = new Contacts();
					con.setDetail_address(order.getConsigneeAddress());
					con.setId(UUIDUtil.getUUID());
					con.setName(order.getConsigneeName());
					con.setPhone(order.getConsigneeMobile());
					con.setType(Constant.CONTACTS_TYPE_RECEIVER);
					//con.setCreate_time(new Date());
					//con.setUpdate_time(new Date());
					con.setPro_city_cty(order.getConsigneeProv()+" "+order.getConsigneeCity()+" "+order.getConsigneeEbrgNameCn());
					contactMangeDao.addContacts(openid, con);
				}
			}
			Contacts shipper = contactMangeDao.queryContactsByNameAndPhone(openid,
					order.getShipperName(), order.getShipperMobile(),
					Constant.CONTACTS_TYPE_SEND);
			if (shipper == null) {
				Contacts con = new Contacts();
				con.setDetail_address(order.getShipperAddress());
				con.setId(UUIDUtil.getUUID());
				con.setName(order.getShipperName());
				con.setPhone(order.getShipperMobile());
				con.setType(Constant.CONTACTS_TYPE_SEND);
				//con.setCreate_time(new Date());
				//con.setUpdate_time(new Date());
				con.setPro_city_cty(order.getShipperProv()+" "+order.getShipperCity()+" "+order.getShipperEbrgNameCn());
				contactMangeDao.addContacts(openid, con);
			} else {
				contactMangeDao.delete(openid, shipper.getId());
				Contacts con = new Contacts();
				con.setDetail_address(order.getShipperAddress());
				con.setId(UUIDUtil.getUUID());
				con.setName(order.getShipperName());
				con.setPhone(order.getShipperMobile());
				con.setType(Constant.CONTACTS_TYPE_SEND);
				//con.setCreate_time(new Date());
				//con.setUpdate_time(new Date());
				con.setPro_city_cty(order.getShipperProv()+" "+order.getShipperCity()+" "+order.getShipperEbrgNameCn());
				contactMangeDao.addContacts(openid, con);
			}
		}
		orderManagerWechatDao.saveOrder(order);

	}
	
	private boolean checkConsigneeInfo(OrderEntity order){
		return StringUtil.isNotEmpty(order.getConsigneeAddress()) 
				&& StringUtil.isNotEmpty(order.getConsigneeCity())
				&& StringUtil.isNotEmpty(order.getConsigneeMobile())
				&& StringUtil.isNotEmpty(order.getConsigneeName())
				&& StringUtil.isNotEmpty(order.getConsigneeProv());
	}

	@Override
	public void cancelOrder(String orderNo) {
		orderManagerWechatDao.cancelOrder(orderNo);

	}

	@Override
	public void modifyOrder(OrderEntity order) {
		String openid = WeixinUtil.getOpenIdFromSession();
		UserInfo user = userInfoDao.findOne(openid);
		if (user == null) {
			UserInfo userInfo = new UserInfo();
			userInfo.set_id(UUIDUtil.getUUID());
			userInfo.setOpenid(openid);
			userInfo.setCreate_time(new Date());
			userInfo.setUpdate_time(new Date());
			userInfoDao.bind(userInfo);
		}else if(!StringUtil.isEmpty(user.getPhone())){
			Contacts consignee = contactMangeDao.queryContactsByNameAndPhone(
					openid, order.getConsigneeName(), order.getConsigneeMobile(),
					Constant.CONTACTS_TYPE_RECEIVER);
			Contacts shipper = contactMangeDao.queryContactsByNameAndPhone(openid,
					order.getShipperName(), order.getShipperMobile(),
					Constant.CONTACTS_TYPE_SEND);
			if (consignee == null) {
				Contacts con = new Contacts();
				con.setDetail_address(order.getConsigneeAddress());
				con.setId(UUIDUtil.getUUID());
				con.setName(order.getConsigneeName());
				con.setPhone(order.getConsigneeMobile());
				con.setType(Constant.CONTACTS_TYPE_RECEIVER);
				//con.setCreate_time(new Date());
				//con.setUpdate_time(new Date());
				con.setPro_city_cty(order.getConsigneeProv()+" "+order.getConsigneeCity()+" "+order.getConsigneeCity());
				contactMangeDao.addContacts(openid, con);
			} else {
				contactMangeDao.delete(openid, consignee.getId());
				Contacts con = new Contacts();
				con.setDetail_address(order.getConsigneeAddress());
				con.setId(UUIDUtil.getUUID());
				con.setName(order.getConsigneeName());
				con.setPhone(order.getConsigneeMobile());
				con.setType(Constant.CONTACTS_TYPE_RECEIVER);
				//con.setCreate_time(new Date());
				//con.setUpdate_time(new Date());
				con.setPro_city_cty(order.getConsigneeProv()+" "+order.getConsigneeCity()+" "+order.getConsigneeCity());
				contactMangeDao.addContacts(openid, con);
			}
			if (shipper == null) {
				Contacts con = new Contacts();
				con.setDetail_address(order.getShipperAddress());
				con.setId(UUIDUtil.getUUID());
				con.setName(order.getShipperName());
				con.setPhone(order.getShipperMobile());
				con.setType(Constant.CONTACTS_TYPE_SEND);
				//con.setCreate_time(new Date());
				//con.setUpdate_time(new Date());
				con.setPro_city_cty(order.getShipperProv()+" "+order.getShipperCity()+" "+order.getShipperCity());
				contactMangeDao.addContacts(openid, con);
			} else {
				contactMangeDao.delete(openid, shipper.getId());
				Contacts con = new Contacts();
				con.setDetail_address(order.getShipperAddress());
				con.setId(UUIDUtil.getUUID());
				con.setName(order.getShipperName());
				con.setPhone(order.getShipperMobile());
				con.setType(Constant.CONTACTS_TYPE_SEND);
				//con.setCreate_time(new Date());
				//con.setUpdate_time(new Date());
				con.setPro_city_cty(order.getShipperProv()+" "+order.getShipperCity()+" "+order.getShipperCity());
				contactMangeDao.addContacts(openid, con);
			}
		}
		orderManagerWechatDao.modifyOrder(order);

	}

	public IOrderManagerWechatDao getOrderManagerWechatDao() {
		return orderManagerWechatDao;
	}

	public void setOrderManagerWechatDao(
			IOrderManagerWechatDao orderManagerWechatDao) {
		this.orderManagerWechatDao = orderManagerWechatDao;
	}

	public void setUserInfoDao(IUserInfoDao userInfoDao) {
		this.userInfoDao = userInfoDao;
	}

	public void setContactMangeDao(IContactMangeDao contactMangeDao) {
		this.contactMangeDao = contactMangeDao;
	}

}
