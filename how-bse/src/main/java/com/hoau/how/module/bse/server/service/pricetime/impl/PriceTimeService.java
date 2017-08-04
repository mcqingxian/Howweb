package com.hoau.how.module.bse.server.service.pricetime.impl;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hoau.hbdp.framework.exception.BusinessException;
import com.hoau.how.module.bse.server.service.pricetime.IPriceTimeService;
import com.hoau.how.module.bse.shared.exception.MessageType;
import com.hoau.how.module.itf.server.service.IPriceTimeManager;
import com.hoau.how.module.itf.server.ws.dcpricetime.PriceQueryResultVo;
import com.hoau.how.module.itf.shared.vos.pricetime.PriceCalcRespVo;
import com.hoau.how.module.itf.shared.vos.pricetime.PriceQueryVo;
import com.hoau.how.module.util.StringUtil;

@Service
public class PriceTimeService implements IPriceTimeService{

	@Resource
	private IPriceTimeManager priceTimeManager;

	@Override
	public List<PriceQueryResultVo> queryPriceTime(PriceQueryVo priceQueryVo) {
		List<PriceQueryResultVo> priceTimeVos = priceTimeManager.queryPriceTime(priceQueryVo); 
		if(priceTimeVos.size()==0){
			throw new BusinessException(MessageType.QUERY_PRICE_NO_RESULT,"");
		}
		for (int i = 0; i < priceTimeVos.size(); i++) {
			PriceQueryResultVo vo = priceTimeVos.get(i);
			vo.setPickTime(StringUtil.timeMinusOne(vo.getPickTime()));
			vo.setDeliveryTime(StringUtil.timeMinusOne(vo.getDeliveryTime()));
		}
		return priceTimeVos;
	}
	
	@Override
	public List<PriceCalcRespVo> priceCalc(PriceQueryVo priceQueryVo) {
		List<PriceCalcRespVo> priceCals = null;
		try {
			priceCals = priceTimeManager.priceCalc(priceQueryVo);
			if(priceCals.size()==0){
				throw new BusinessException(MessageType.QUERY_PRICE_NO_RESULT,"");
			}
			//排序
			Collections.sort(priceCals, new Comparator<PriceCalcRespVo>(){  
	            public int compare(PriceCalcRespVo o1, PriceCalcRespVo o2) {  
	                if(o1.getTransType().length() > o2.getTransType().length()){  
	                    return 1;  
	                }  
	                if(o1.getTransType().length() == o2.getTransType().length()){  
	                    return 0;  
	                }  
	                return -1;  
	            }  
	        });
		} catch (Exception e) {
			throw new BusinessException(MessageType.QUERY_PRICE_NO_RESULT,"");
		}
		return priceCals;
	}
}
