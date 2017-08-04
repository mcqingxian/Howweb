package com.hoau.mhow.module.obh.server.dao;

import org.springframework.stereotype.Repository;

import com.hoau.mhow.module.bse.api.shared.domain.CustomerEntity;

/**
 * 客户信息DAO
 *
 * @author 蒋落琛
 * @date 2015-12-9
 */
@Repository
public interface CustomerDao{
	public void insertCustomer(CustomerEntity entity);
}