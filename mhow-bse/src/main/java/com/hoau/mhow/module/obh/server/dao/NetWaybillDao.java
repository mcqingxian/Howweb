package com.hoau.mhow.module.obh.server.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.hoau.mhow.module.bse.api.shared.domain.QueryWaybillEntity;
import com.hoau.mhow.module.bse.api.shared.domain.WaybillResultEntity;


/**
 *
 * @author 张贞献
 * @date 2015年8月5日
 */
@Repository
public interface NetWaybillDao{

	/**
	 * 查询运单明细
	 * @param queryWaybillEntity
	 * @return
	 * @author 张贞献
	 * @date 2015年8月6日
	 * @update 
	 */
	List<WaybillResultEntity> queryWaybillResult(QueryWaybillEntity queryWaybillEntity);
	
	/**
	 * 查询运单总量
	 * @param queryWaybillEntity
	 * @return
	 * @author 张贞献
	 * @date 2015年8月6日
	 * @update 
	 */
	long queryWaybillCount(QueryWaybillEntity queryWaybillEntity);
}