package com.hoau.how.module.itf.server.service;

import java.util.List;

import com.hoau.how.module.itf.server.ws.dcpricetime.PriceQueryResult;
import com.hoau.how.module.itf.shared.vos.pricetime.PriceQueryVo;

/**
 * @author：龙海仁
 * @create：2015年9月14日 上午9:07:14
 * @description：
 */
public interface IPriceTTQService {
	public List<PriceQueryResult> getTTQPrice(PriceQueryVo priceVo);
}
