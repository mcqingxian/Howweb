package com.hoau.wechat.service.impl;

import org.springframework.stereotype.Service;

import com.hoau.wechat.constant.NetRequestConstant;
import com.hoau.wechat.service.IGoodsTraceService;
import com.hoau.wechat.utils.NetUtil;
/**
 * 
 * @author gaojia
 *
 */
@Service
public class GoodsTraceService implements IGoodsTraceService{
	/**
	 * 根据运单号查询货物轨迹
	 * @param waybillCode 运单号
	 */
	@Override
	public String queryGoodsTrack(String waybillCode) {
		return NetUtil.getData(NetRequestConstant.GOODS_TRACE_REQ+"/"+waybillCode);
	}

}
