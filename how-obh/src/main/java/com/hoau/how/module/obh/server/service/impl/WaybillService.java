package com.hoau.how.module.obh.server.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hoau.how.module.obh.server.dao.NetWaybillDao;
import com.hoau.how.module.obh.server.service.IWaybillService;
import com.hoau.how.module.obh.shared.domain.QueryWaybillEntity;
import com.hoau.how.module.obh.shared.domain.WaybillResultEntity;

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