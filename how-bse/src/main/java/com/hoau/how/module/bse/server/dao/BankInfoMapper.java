package com.hoau.how.module.bse.server.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.hoau.how.module.bse.api.shared.domain.BankInfoEntity;

/**
 * @author：莫涛
 * @create：2016年3月28日 下午7:27:28
 * @description：
 */
@Repository
public interface BankInfoMapper {
	public List<BankInfoEntity> queryBankInfoList(String bankName);
}