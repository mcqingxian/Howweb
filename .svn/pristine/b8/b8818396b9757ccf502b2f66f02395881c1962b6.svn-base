package com.hoau.mhow.module.bse.server.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hoau.mhow.module.bse.api.server.service.IWaybillService;
import com.hoau.mhow.module.bse.api.shared.domain.QueryWaybillEntity;
import com.hoau.mhow.module.bse.api.shared.domain.WaybillResultEntity;
import com.hoau.mhow.module.obh.server.dao.NetWaybillDao;

/**
 *
 * @author 张贞献
 * @date 2015年8月5日
 */
@Service
public class WaybillService implements IWaybillService {
	protected List<byte[]> bankCardPicFiles;
	
	@Resource
	NetWaybillDao netWaybillDao;

	@Override
	public List<WaybillResultEntity> queryWaybillResult(
			QueryWaybillEntity queryWaybillEntity) {
		return netWaybillDao.queryWaybillResult(queryWaybillEntity);
	}

	@Override
	public long queryWaybillCount(QueryWaybillEntity queryWaybillEntity) {
		return netWaybillDao.queryWaybillCount(queryWaybillEntity);
	}

}