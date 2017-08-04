package com.hoau.how.module.bse.api.server.service;

import java.util.List;

import com.hoau.how.module.bse.api.shared.domain.BankInfoEntity;

/**
 * @author：莫涛
 * @create：2016年3月28日 下午5:40:26
 * @description：
 */
public interface IBankInfoService {
	public List<BankInfoEntity> queryBankInfoList(String bankName);
}
