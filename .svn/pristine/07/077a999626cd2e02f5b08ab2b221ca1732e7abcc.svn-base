package com.hoau.how.module.obh.server.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.hoau.how.module.obh.shared.domain.CustomerContactEntity;

/**
 * 
 * @author 莫涛
 * @date 2015年7月16日
 */
@Repository
public interface CustomerContactDao{
	/**
	 * 查询用户信息
	 * @param entity
	 * @return
	 * @author 莫涛
	 * @date 2015年7月21日
	 * @update
	 */
	public List<CustomerContactEntity> findCustomer(CustomerContactEntity entity);
	/**
	 * 统计用户总数
	 * @param entity
	 * @return
	 * @author 莫涛
	 * @date 2015年7月22日
	 * @update
	 */
	public Integer countCustomer(CustomerContactEntity entity);
	/**
	 * 通过ID查询用户信息
	 * @param ebccId
	 * @return
	 * @author 莫涛
	 * @date 2015年7月22日
	 * @update
	 */
	public List<CustomerContactEntity> findCustomerById(Long ebccId);
	/**
	 * 通过主键修改密码
	 * @param entity
	 * @author 莫涛
	 * @date 2015年7月21日
	 * @update
	 */
	public void modifyCustomerPwdById(CustomerContactEntity entity);
	/**
	 * 通过ID修改用户信息
	 * @param entity
	 * @author 莫涛
	 * @date 2015年7月22日
	 * @update
	 */
	public void modifyCustomerInfoById(CustomerContactEntity entity);
	/**
	 * 修改用户最后修改时间，作为用户最后登录时间使用
	 * @param entity
	 * @author 莫涛
	 * @date 2015年7月21日
	 * @update
	 */
	public void modifyCustomerTimeById(CustomerContactEntity entity);
	/**
	 * 用户注册
	 * @param entity
	 * @author 莫涛
	 * @date 2015年7月21日
	 * @update
	 */
	public void insertCustomerContact(CustomerContactEntity entity);
}