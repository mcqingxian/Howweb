package com.hoau.wechat.service.impl;

import java.util.Date;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import com.hoau.wechat.dao.IUserInfoDao;
import com.hoau.wechat.mq.service.UserInfoMqService;
import com.hoau.wechat.service.IPhoneBindService;
import com.hoau.wechat.util.UUIDUtil;
import com.hoau.wechat.vo.UserInfo;
import com.hoau.wechat.vos.templates.msg.UserInfoMsg;

/** 
* @ClassName  :PhoneBindService 
* @Description:手机绑定服务类
* @author     :xujun cometzb@126.com	
* @date       :2014年4月15日 下午3:14:24 
*  
*/
@Service
public class PhoneBindService implements IPhoneBindService {
	
	@Resource
	private IUserInfoDao userInfoDao;
	
	@Resource
	UserInfoMqService userInfoMqService;
	
	private static final Log LOG = LogFactory.getLog(PhoneBindService.class);

	
	/* 
	 * <p>Title: phoneBind</p> 
	 * <p>Description: 绑定手机</p> 
	 * @param phone
	 * @param openId 
	 * @see com.hoau.wechat.service.IPhoneBindService#phoneBind(java.lang.String, java.lang.String) 
	 */
	public void phoneBind(String phone,String openId) {
		UserInfo u1 = findOneUserInfo(openId);
		//发送至DC的手机绑定信息
		UserInfoMsg userInfoMsg = new UserInfoMsg();
		userInfoMsg.setOpenId(openId);
		userInfoMsg.setPhone(phone);
		
		if(u1 == null){
			UserInfo userInfo = new UserInfo();
			userInfo.set_id(UUIDUtil.getUUID());
			userInfo.setPhone(phone);
			userInfo.setOpenid(openId);
			userInfo.setCreate_time(new Date());
			userInfo.setUpdate_time(new Date());
			//数据库操作
			userInfoDao.bind(userInfo);
		}
		if(u1 != null && u1.getPhone() == null){
			userInfoDao.updatePhone(openId, phone);
		}
		
		//发送用户手机绑定信息至DC
		userInfoMqService.send(userInfoMsg);
		LOG.debug("----------phone:"+phone + "openid:"+openId);
	}

	/* 
	 * <p>Title: changeBind</p> 
	 * <p>Description: 变更绑定</p> 
	 * @param phone
	 * @param openId 
	 * @see com.hoau.wechat.service.IPhoneBindService#changeBind(java.lang.String, java.lang.String) 
	 */
	@Override
	public void changeBind(String phone, String openId) {
		userInfoDao.updatePhone(openId, phone);
		//发送至DC的手机绑定信息
		UserInfoMsg userInfoMsg = new UserInfoMsg();
		userInfoMsg.setOpenId(openId);
		userInfoMsg.setPhone(phone);
		//发送用户手机绑定信息至DC
		userInfoMqService.send(userInfoMsg);
	}

	@Override
	public UserInfo findOneUserInfo(String openId) {
		return userInfoDao.findOne(openId);
	}
	
	public void setUserInfoDao(IUserInfoDao userInfoDao) {
		this.userInfoDao = userInfoDao;
	}

	@Override
	public void saveValidate(String openId, String valCode) {
		
		String valiCode = getValiteCode(openId);
		if(valiCode == null || "".equals(valCode)){
			userInfoDao.saveValidate(openId,valCode);
		}else{
			userInfoDao.updateValiCode(openId,valCode);
		}
		
	}

	@Override
	public String getValiteCode(String openId) {
		return userInfoDao.getValiteCode(openId);
	}


}
