package com.hoau.mhow.module.bse.server.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hoau.mhow.module.bse.api.server.service.IUserService;
import com.hoau.mhow.module.bse.api.shared.domain.CustomerContactEntity;
import com.hoau.mhow.module.bse.api.shared.domain.CustomerEntity;
import com.hoau.mhow.module.bse.api.shared.vo.CheckUserRsVo;
import com.hoau.mhow.module.obh.server.dao.CustomerContactDao;
import com.hoau.mhow.module.obh.server.dao.CustomerDao;
import com.hoau.wechat.util.ValidateUtils;

/**
 * 用户管理SERVICE实现
 *
 * @author 蒋落琛
 * @date 2015-12-9
 */
@Service
public class UserService implements IUserService {

	@Resource
	CustomerDao customerDao;

	@Resource
	CustomerContactDao customerContactDao;

	@Override
	public void insertCustomer(CustomerContactEntity entity) {
		CustomerEntity customer = new CustomerEntity();
		customer.setEbcuCustomerNo(entity.getEbccNetLogin());
		customer.setEbcuNameCn(entity.getEbccMobile());
		customerDao.insertCustomer(customer);
		entity.setEbccEbcuId(customer.getEbcuId());
		customerContactDao.insertCustomerContact(entity);
	}

	@Override
	public void modifyCustomerTimeById(CustomerContactEntity entity) {
		customerContactDao.modifyCustomerTimeById(entity);
	}


	@Override
	public CustomerContactEntity findCustomer(CustomerContactEntity entity) {
		List<CustomerContactEntity> list = customerContactDao
				.findCustomer(entity);
		if (list != null && list.size() > 0) {
			return list.get(0);
		} else {
			return null;
		}
	}

	@Override
	public Integer countCustomer(CustomerContactEntity customerContactEntity) {
		return customerContactDao.countCustomer(customerContactEntity);
	}

	@Override
	public void modifyCustomerInfoById(CustomerContactEntity entity) {
		this.customerContactDao.modifyCustomerInfoById(entity);
	}

	@Override
	public void modifyCustomerPwdById(CustomerContactEntity entity) {
		this.customerContactDao.modifyCustomerPwdById(entity);
	}

	/**
	 * 
	 * @author 莫涛
	 * @date 2015年7月20日
	 * @update
	 */
	@Override
	public CheckUserRsVo checkPhoneJson(String mobile, Integer total)
			throws Exception {
		CheckUserRsVo vo = new CheckUserRsVo();
		vo.setErrorMsg("");
		vo.setResult(true);
		try {
			if (total == null) {
				vo.setErrorMsg(setThisErrorMsg("参数为空！ "));
				vo.setResult(false);
				return vo;
			} else if (mobile == null || mobile.equals("")) {
				vo.setErrorMsg(setThisErrorMsg("请输入手机号码！"));
				vo.setResult(false);
				return vo;
			} else if (!ValidateUtils.isMobile(mobile)) {
				vo.setErrorMsg(setThisErrorMsg("请输入正确手机号码！ "));
				vo.setResult(false);
				return vo;
			}
			CustomerContactEntity entity = new CustomerContactEntity();
			entity.setEbccMobile(mobile);
			Integer number = this.countCustomer(entity);
			if (number >= total) {
				vo.setErrorMsg(setThisErrorMsg("手机号码已存在！"));
				vo.setResult(false);
				return vo;
			}
		} catch (Exception ex) {
			throw ex;
		}
		return vo;
	}

	@Override
	public CheckUserRsVo checkEmailJson(String email, Integer total)
			throws Exception {
		CheckUserRsVo vo = new CheckUserRsVo();
		vo.setErrorMsg("<span class='icon_succ'></span>");
		vo.setResult(true);
		try {
			if (total == null) {
				vo.setErrorMsg(setThisErrorMsg("参数为空！"));
				vo.setResult(false);
				return vo;
			} else if (email == null || email.equals("")) {
				return vo;
			}
			// 如果有填写邮箱地址，则需要验证邮箱地址是否正确。
			if (email != null && !email.equals("")) {
				if (!ValidateUtils.isEmail(email)) {
					vo.setErrorMsg(setThisErrorMsg("请输入正确邮箱地址！"));
					vo.setResult(false);
					return vo;
				}
			}
			CustomerContactEntity entity = new CustomerContactEntity();
			entity.setEbccEmail(email);
			Integer number = this.countCustomer(entity);
			if (number >= total) {
				vo.setErrorMsg(setThisErrorMsg("邮箱已存在！"));
				vo.setResult(false);
				return vo;
			}
		} catch (Exception ex) {
			throw ex;
		}
		return vo;
	}

	@Override
	public CheckUserRsVo checkUserNameJson(String userName, Integer total)
			throws Exception {
		CheckUserRsVo vo = new CheckUserRsVo();
		vo.setErrorMsg("<span class='icon_succ'></span>");
		vo.setResult(true);
		try {
			if (total == null) {
				vo.setErrorMsg(setThisErrorMsg("参数为空！"));
				vo.setResult(false);
				return vo;
			} else if (userName == null || userName.equals("")) {
				return vo;
			}
			if (userName.length() > 50) {
				vo.setErrorMsg(setThisErrorMsg("用户名长度不能超过50位！"));
				vo.setResult(false);
				return vo;
			}
			CustomerContactEntity entity = new CustomerContactEntity();
			entity.setEbccNetLogin(userName);
			Integer number = this.countCustomer(entity);
			if (number >= total) {
				vo.setErrorMsg(setThisErrorMsg("用户名已存在！"));
				vo.setResult(false);
				return vo;
			}
		} catch (Exception ex) {
			throw ex;
		}
		return vo;
	}

	private String setThisErrorMsg(String msg) {
		return msg;
	}

	@Override
	public CustomerContactEntity findCustomerById(Long ebccId) {
		List<CustomerContactEntity> list = customerContactDao.findCustomerById(ebccId);
		if(list != null && list.size() > 0){
			return list.get(0);
		}else{
			return null;
		}
	}
}