package com.hoau.mhow.module.bse.api.server.service;



import java.util.List;

import com.hoau.mhow.module.bse.api.shared.vo.GoodsTraceResultVo;

/**
 * 获取TNTService接口数据
 *
 * @author 蒋落琛
 * @date 2015-12-10
 */
public interface IGetYdTraceManager {
	public GoodsTraceResultVo getYdTraceList(List<String> transNos);
}
