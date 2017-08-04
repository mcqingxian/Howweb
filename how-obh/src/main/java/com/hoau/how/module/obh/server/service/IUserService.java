package com.hoau.how.module.obh.server.service;

import com.hoau.how.module.obh.shared.domain.CustomerContactEntity;
import com.hoau.how.module.obh.shared.vos.CheckUserRsVo;

/**
 * @author：莫涛
 * @create：2015年7月20日 上午10:51:18
 * @description：
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
	 * @param entity
	 * @param total
	 * @return
	 * @throws Exception
	 * @author 莫涛
	 * @date 2015年7月22日
	 * @update
	 */
	public CheckUserRsVo checkPhoneJson(String mobile,Integer total) throws Exception;
	/**
	 * 验证用户邮箱
	 * @param entity
	 * @param total
	 * @return
	 * @throws Exception
	 * @author 莫涛
	 * @date 2015年7月22日
	 * @update
	 */
	public CheckUserRsVo checkEmailJson(String email,Integer total) throws Exception;
	/**
	 * 验证用户账号
	 * @param entity
	 * @param total
	 * @return
	 * @throws Exception
	 * @author 莫涛
	 * @date 2015年7月22日
	 * @update
	 */
	public CheckUserRsVo checkUserNameJson(String userName,Integer total) throws Exception;
}
