package com.hoau.mhow.module.bse.server.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Properties;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.hoau.hbdp.framework.shared.util.JsonUtils;
import com.hoau.mhow.invokews.server.ws.dcpricetime.PriceQueryResult;
import com.hoau.mhow.invokews.server.ws.dcpricetime.PriceQueryVo;
import com.hoau.mhow.module.bse.api.server.service.IPriceTimeManager;
import com.hoau.mhow.module.bse.api.server.service.IPriceTimeService;
import com.hoau.mhow.module.bse.api.shared.vo.PriceCalcRespVo;
import com.hoau.miser.module.api.itf.api.shared.vo.HowAppPriceQueryParam;
import com.hoau.miser.module.api.itf.api.shared.vo.HowAppPriceQueryPriceDetail;
import com.hoau.wechat.config.ConfigConstants;
import com.hoau.wechat.config.ConfigUtils;
import com.hoau.wechat.util.StringUtil;

@Service
public class PriceTimeService implements IPriceTimeService{
	private Logger logger = Logger.getLogger(PriceTimeService.class);
	@Resource
	private IPriceTimeManager priceTimeManager;
	@Resource
	private RestTemplate restTemplate;

	@Override
	public List<HowAppPriceQueryPriceDetail> queryPriceTime(PriceQueryVo priceQueryVo) {
		List<HowAppPriceQueryPriceDetail> result = new ArrayList<HowAppPriceQueryPriceDetail>();
		List<PriceQueryResult> priceTimeVos = priceTimeManager.queryPriceTime(priceQueryVo);
		Properties properties = ConfigUtils.getConfig(ConfigConstants.PMS_URL.CONFIG_NAME);
		String pms_url = properties.getProperty(ConfigConstants.PMS_URL.PMS_URL);
		HowAppPriceQueryParam queryParam = new HowAppPriceQueryParam();
		queryParam.setSendCityName(priceQueryVo.getShipperCity());
		queryParam.setSendCountyName(priceQueryVo.getShipperCounty());
		queryParam.setArrivalCityName(priceQueryVo.getConCity());
		queryParam.setArrivalCountyName(priceQueryVo.getConCounty());
		String rsJson = restTemplate.postForObject(pms_url, queryParam, String.class);
		if(rsJson != null && !rsJson.equals("")){
			result = JsonUtils.toList(rsJson, HowAppPriceQueryPriceDetail.class);
			if(result != null && priceTimeVos.size() != 0){
				if(priceTimeVos.size()==0){
					logger.info("查询时效信息为空！！！");
					logger.info(priceQueryVo.getConCity());
					logger.info(priceQueryVo.getConCounty());
					logger.info(priceQueryVo.getShipperCity());
					logger.info(priceQueryVo.getShipperCounty());
				}
				for(int i = 0 ; i < result.size() ; i ++){
					HowAppPriceQueryPriceDetail detail = result.get(i);
					for (int j = 0; j < priceTimeVos.size(); j++) {
						PriceQueryResult vo = priceTimeVos.get(j);
						//如果dc和pms查出来的都是经济快运，则设置时效
						if(vo.getTransportType().equals("ONTIME") && detail.getTransportTypeCode().equals("10000000000000000001")){
							detail.setPickTime(StringUtil.timeMinusOne(vo.getPickTime()));
							detail.setDeliveryTime(StringUtil.timeMinusOne(vo.getDeliveryTime()));
							continue;
						}
						if(vo.getTransportType().equals("LESSLOADED") && detail.getTransportTypeCode().equals("30000000000000000001")){
							detail.setPickTime(StringUtil.timeMinusOne(vo.getPickTime()));
							detail.setDeliveryTime(StringUtil.timeMinusOne(vo.getDeliveryTime()));
							continue;
						}
					}
				}
			}
		}
		return result;
	}
	
	@Override
	public List<PriceCalcRespVo> priceCalc(PriceQueryVo priceQueryVo) {
		List<PriceCalcRespVo> priceCals = null;
		try {
			priceCals = priceTimeManager.priceCalc(priceQueryVo);
			if(priceCals.size()==0){
				logger.info("查询价格信息为空！！！");
				logger.info(priceQueryVo.getConCity());
				logger.info(priceQueryVo.getConCounty());
				logger.info(priceQueryVo.getShipperCity());
				logger.info(priceQueryVo.getShipperCounty());
				logger.info(priceQueryVo.getCollDeliveryAmount());
				logger.info(priceQueryVo.getInsurance());
				logger.info(priceQueryVo.getVolumn());
				logger.info(priceQueryVo.getWeight());
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
			e.printStackTrace();
		}
		return priceCals;
	}
}
