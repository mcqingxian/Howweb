/**
 * 
 */
package com.hoau.wechat.service.impl;


import javax.annotation.Resource;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import com.hoau.wechat.constant.OMSConstants;
import com.hoau.wechat.dao.IRegisterDao;
import com.hoau.wechat.entity.UserEntity;
import com.hoau.wechat.exception.OMSServiceException;
import com.hoau.wechat.service.ILoginOmsService;
import com.hoau.wechat.service.OMSInterfaceService;
import com.hoau.wechat.util.UUIDUtil;
import com.hoau.wechat.ws.oms.LoginUserReqModel;
import com.hoau.wechat.ws.oms.LoginUserResModel;
import com.hoau.wechat.ws.oms.RegisterUserReqModel;
import com.hoau.wechat.ws.oms.RegisterUserResModel;

/**
 * @author gaojia
 * 
 */
@Service
public class LoginOmsService extends OMSInterfaceService implements
		ILoginOmsService {
	private static Log log = LogFactory.getLog(LoginOmsService.class);
	@Resource
	private IRegisterDao registerDao;

	/**
	 * 登陆oms接口
	 * 
	 * @param userId
	 *            登陆校验原则:1.在微信系统中校验是否做过注册操作； 2.如果做过注册操作，调用OMS登陆接口； 登陆成功 返回userid
	 *            登陆失败 根据返回信息判断是否未进行注册，未进行注册则进行注册操作，反之抛出异常 3.如果未做过注册，进行注册并登陆；
	 *            注册成功 进行登陆 登陆成功 返回userid 登陆失败
	 *            根据返回细心判断是否未进行注册，未进行注册则进行注册操作，反之抛出异常 注册失败 抛出异常
	 */
	public String login(String userName) {
		log.info("openid:"+userName);
		userName = DigestUtils.md5Hex(userName);
		log.info("userName:"+userName);
		// 做过注册则登陆OMS
		LoginUserResModel loginRes = this.loginByPhone(userName);
		if (loginRes.getResult().getValue()) {
			// 登陆成功返回userId
			return loginRes.getUserId().getValue();
		} else if (!loginRes.getResult().getValue()
				&& "1003".equals(loginRes.getResultCode().getValue())) {
			// 登陆失败并且返回未注册则进行注册操作
			RegisterUserResModel res = this.registerUser(userName);
			if (res.getResult().getValue()) {
				this.registerInWechat(res.getUserId().getValue(), userName,
						userName, OMSConstants.PASSWORD);
				// 注册成功进行登陆
				LoginUserResModel lres = this.loginByPhone(userName);
				if (lres.getResult().getValue()) {
					// 登陆成功返回userId
					return lres.getUserId().getValue();
				} else {
					// 登陆失败抛出异常
					throw new OMSServiceException(res.getResultCode()
							.getValue(), "OMS登陆异常"
							+ res.getResultInfo().getValue());
				}
			} else {
				// 注册失败抛出异常
				throw new OMSServiceException(res.getResultCode().getValue(),
						"OMS注册异常" + res.getResultInfo().getValue());
			}
		} else {
			// 登陆失败并且进行过注册抛出异常
			throw new OMSServiceException(loginRes.getResultCode().getValue(),
					"OMS登陆异常" + loginRes.getResultInfo().getValue());
		}
		/*
		 * // 判断是否在微信系统中做过注册 if (this.checkRegister(userName)) {
		 * 
		 * } else { // 未在微信系统中做过注册则在OMS中注册 RegisterUserResModel res =
		 * this.registerUser(userName); if (res.getResult().getValue()) {
		 * this.registerInWechat(res.getUserId().getValue(), userName, userName,
		 * OMSConstants.PASSWORD); // 注册成功则登陆OMS LoginUserResModel loginRes =
		 * this.loginByPhone(userName); if (loginRes.getResult().getValue()) {
		 * // 登陆成功返回userId return loginRes.getUserId().getValue(); } else { //
		 * 登陆失败抛出异常 throw new OMSServiceException(res.getResultCode()
		 * .getValue(), "OMS登陆异常" + res.getResultInfo().getValue()); } } else {
		 * // 注册失败抛出异常 throw new
		 * OMSServiceException(res.getResultCode().getValue(), "OMS注册异常" +
		 * res.getResultInfo().getValue()); } }
		 */
	}

	/**
	 * 微信系统中校验是否已注册
	 * 
	 * @param userId
	 * @return
	 */
	private boolean checkRegister(String userName) {
		// TODO Auto-generated method stub
		return registerDao.checkRegister(userName);
	}

	/**
	 * 调用OMS接口注册
	 * 
	 * @param userId
	 * @return
	 */
	private RegisterUserResModel registerUser(String userName) {
		RegisterUserReqModel req = new RegisterUserReqModel();
		req.setName(objectFactory.createRegisterUserReqModelName(userName));
		req.setPassword(objectFactory
				.createRegisterUserReqModelPassword("wechat888888"));
		return portType.registerUser(req);
	}

	/**
	 * 调用OMS接口登陆
	 * 
	 * @param userId
	 * @return
	 */
	private LoginUserResModel loginByPhone(String userName) {
		LoginUserReqModel loginReq = new LoginUserReqModel();
		loginReq.setLoginName(objectFactory
				.createLoginUserReqModelLoginName(userName));
		loginReq.setPassword(objectFactory
				.createLoginUserReqModelPassword("wechat888888"));
		return portType.loginByPhone(loginReq);
	}

	private void registerInWechat(String userId, String openId, String name,
			String password) {
		UserEntity user = new UserEntity();
		user.set_id(UUIDUtil.getUUID());
		user.setName(name);
		user.setOmsUserId(userId);
		user.setOpenId(openId);
		user.setPassword(password);
		registerDao.register(user);
	}

	public IRegisterDao getRegisterDao() {
		return registerDao;
	}

	public void setRegisterDao(IRegisterDao registerDao) {
		this.registerDao = registerDao;
	}

}
