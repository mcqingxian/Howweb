package com.hoau.mhow.module.bse.api.server.service;

import com.hoau.mhow.module.bse.api.shared.domain.CustomerContactEntity;
import com.hoau.mhow.module.bse.api.shared.vo.CheckUserRsVo;

/**
 * 用户SERVICE
 * 
 * @author 蒋落琛
 * @date 2015-12-9
 */
public interface IUserService {
	public void insertCustomer(CustomerContactEntity entity);

	public void modifyCustomerTimeById(CustomerContactEntity entity);

	public void modifyCustomerPwdById(CustomerContactEntity entity);

	public void modifyCustomerInfoById(CustomerContactEntity entity);

	public Integer countCustomer(CustomerContactEntity customerContactEntity);

	public CustomerContactEntity findCustomerById(Long ebccId);

	public CustomerContactEntity findCustomer(CustomerContactEntity entity);

	/**
	 * 验证用户手机
	 * 
	 * @param entity
	 * @param total
	 * @return
	 * @throws Exception
	 * @author 莫涛
	 * @date 2015年7月22日
	 * @update
	 */
	public CheckUserRsVo checkPhoneJson(String mobile, Integer total)
			throws Exception;

	/**
	 * 验证用户邮箱
	 * 
	 * @param entity
	 * @param total
	 * @return
	 * @throws Exception
	 * @author 莫涛
	 * @date 2015年7月22日
	 * @update
	 */
	public CheckUserRsVo checkEmailJson(String email, Integer total)
			throws Exception;

	/**
	 * 验证用户账号
	 * 
	 * @param entity
	 * @param total
	 * @return
	 * @throws Exception
	 * @author 莫涛
	 * @date 2015年7月22日
	 * @update
	 */
	public CheckUserRsVo checkUserNameJson(String userName, Integer total)
			throws Exception;
}
