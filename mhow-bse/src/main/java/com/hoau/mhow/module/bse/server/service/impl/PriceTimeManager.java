package com.hoau.mhow.module.bse.server.service.impl;

import java.net.URL;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.hoau.mhow.invokews.server.ws.dcpricetime.HowPriceAndTimeQueryServices;
import com.hoau.mhow.invokews.server.ws.dcpricetime.HowPriceAndTimeQueryServices_Service;
import com.hoau.mhow.invokews.server.ws.dcpricetime.PriceQueryResult;
import com.hoau.mhow.invokews.server.ws.dcpricetime.PriceQueryVo;
import com.hoau.mhow.module.bse.api.server.service.IPriceTimeManager;
import com.hoau.mhow.module.bse.api.shared.vo.PriceCalcRespVo;
import com.hoau.wechat.constant.PropertyConstant;
import com.hoau.wechat.util.StringUtil;



/**
 * @author：莫涛
 * @create：2015年5月28日 下午4:34:15
 * @description：价格时效查询
 */
@Service
public class PriceTimeManager implements IPriceTimeManager {
	
	Logger logger = Logger.getLogger(PriceTimeManager.class);
	
	@Resource
	private PriceTTQService priceTTQService;
	
	private HowPriceAndTimeQueryServices port;
	public PriceTimeManager(){
        String priceUrl = PropertyConstant.DC_PRICE_URL;
		try {
			logger.info(priceUrl);
			HowPriceAndTimeQueryServices_Service ss = new HowPriceAndTimeQueryServices_Service(new URL(priceUrl));
			port = ss.getHowPriceAndTimeQueryServicesPort();
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	protected static DecimalFormat df =new DecimalFormat("#");  
	
	/**
	 * 查询价格时效
	 */
	@Override
	public List<PriceQueryResult> queryPriceTime(PriceQueryVo vo) {
		List<PriceQueryResult> priceResult = null;
		try {
			if(port != null){
				priceResult = port.queryPriceAndTime(changeTtqQuery(vo));
			}
			if(priceResult == null || priceResult.size()==0){
				priceResult = priceTTQService.getTTQPrice(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return priceResult;
	}

	/**
	 * 价格计算
	 */
	@Override
	public List<PriceCalcRespVo> priceCalc(PriceQueryVo vo) {
		List<PriceCalcRespVo> priceCalcList = new ArrayList<PriceCalcRespVo>();
		List<PriceQueryResult> priceResult = null;
//		普通零担 	LESSLOADED
//		定日达	ONTIME
		try {
			priceResult = port.queryPriceAndTime(changeTtqQuery(vo));
			
			if(priceResult.size()==0){
				priceResult = priceTTQService.getTTQPrice(vo);
			}
			
			for (PriceQueryResult priceTimeVo : priceResult) {
				PriceCalcRespVo priceCalcVo = new PriceCalcRespVo();
				
				//重货
				Double heavy = vo.getWeight() * priceTimeVo.getHeavyPrice();
				//轻货
				Double light = vo.getVolumn() * priceTimeVo.getLightPrice();
				if(heavy > light){
					//设置货物类型
					priceCalcVo.setGoodsType("重货");
				}else{
					priceCalcVo.setGoodsType("轻货");
				}
				
				//起步价
				Double startprice = priceTimeVo.getStartPrice();
				//计算轻货重货
				if (heavy > light && heavy > startprice) {
					startprice = heavy;
				} else if (light > heavy && light > startprice) {
					startprice = light;
					priceCalcVo.setGoodsType("轻货");
				} else if (light == heavy && light > startprice) {
					startprice = light;
				}
				//设置运费
				priceCalcVo.setTransCost(df.format(Math.ceil(startprice)));
				//设置运输时效
				priceCalcVo.setTransAging("第"+StringUtil.timeMinusOne(priceTimeVo.getDeliveryTime())+"天");
				//运输类型
				priceCalcVo.setTransType(priceTimeVo.getTransportType());
				//燃油费
				priceCalcVo.setFuelCost(doubleUpCeilFormat(priceTimeVo.getSurcharge()));
				//信息费
				priceCalcVo.setMessageCost(doubleUpCeilFormat((priceTimeVo.getMessageFee())));
				//工本费
				priceCalcVo.setLaborCost(doubleUpCeilFormat((priceTimeVo.getIssusingFee())));
				
				//保价费
				Double insuredRate = priceTimeVo.getInsuredRate();
				Double minInsuredFee = priceTimeVo.getMinInsuredFee();
				Double insurance = (vo.getInsurance() * insuredRate)/1000;
				if(insurance > 0 && insurance < minInsuredFee){
					insurance = minInsuredFee;
				}
				//设置保价费
				priceCalcVo.setInsuredCost(doubleUpCeilFormat(insurance));
				//代收货款费
				Double charge = vo.getCollDeliveryAmount();
				if (charge > 20000) {
					charge = charge * 0.008;
				} else if (charge > 0 && charge <= 20000) {
					charge = charge * 0.01;
					charge = charge < 20 ? 20 : charge;
				}
				//设置代收货款费,上线100元
				if(charge > 100){
					charge = 100d;
				}
				priceCalcVo.setCollProceCost(doubleUpCeilFormat(charge));
				
				//设置费用合计
				Double chargeTotal = Double.parseDouble(priceCalcVo.getCollProceCost()) + //代收货款费
										Double.parseDouble(priceCalcVo.getFuelCost()) + //燃油
										Double.parseDouble(priceCalcVo.getInsuredCost()) + //保价
										Double.parseDouble(priceCalcVo.getLaborCost()) +  //工本费 
										Double.parseDouble(priceCalcVo.getMessageCost()) + //信息费
										Double.parseDouble(priceCalcVo.getTransCost()) ;  // 交通运输费
				//设置费用合计
				priceCalcVo.setTotalCost(doubleUpCeilFormat(chargeTotal));
				priceCalcList.add(priceCalcVo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return priceCalcList;
	}

	
	private static com.hoau.mhow.invokews.server.ws.dcpricetime.PriceQueryVo changeTtqQuery(PriceQueryVo priceVo){
		com.hoau.mhow.invokews.server.ws.dcpricetime.PriceQueryVo vo = new com.hoau.mhow.invokews.server.ws.dcpricetime.PriceQueryVo();
		vo.setConCity(priceVo.getConCity());
		vo.setConCounty(priceVo.getConCounty());
		vo.setProductTypeId(priceVo.getProductTypeId());
		vo.setShipperCity(priceVo.getShipperCity());
		vo.setShipperCounty(priceVo.getShipperCounty());
		vo.setVolumn(priceVo.getVolumn());
		vo.setWeight(priceVo.getWeight());
		return vo;
	}
	/*
	private static String doubleUpCeilFormat(String data){
		return df.format(Math.ceil(Double.parseDouble(data)));
	}
	*/
	private static String doubleUpCeilFormat(double data){
		return df.format(Math.ceil(data));
	}
	
	
/*	@Override
	public List<PriceTimeVo> queryPriceTime(PriceQueryVo vo) {
		List<PriceTimeVo> priceTimeList = new ArrayList<PriceTimeVo>();
		try {
			String url = ConfigUtils.getConfig(ConfigUtils.PRICE.CONFIG_NAME).getProperty(ConfigUtils.PRICE.PRICE_URL);
			String param = "";
			//产品类型
			if(StringUtil.isNotEmpty(vo.getProductTypeId())){
				param += encode(vo.getProductTypeId());
			}else{
				param += "";
			}
			if (StringUtil.isNotEmpty(vo.getConCity())) {
				param += "&conCity=" + encode(vo.getConCity());
			}
			if (StringUtil.isNotEmpty(vo.getConCounty())) {
				param += "&conCounty=" + encode(vo.getConCounty());
			}
			if (StringUtil.isNotEmpty(vo.getShipperCity())) {
				param += "&shipperCity=" + encode(vo.getShipperCity());
			}
			if (StringUtil.isNotEmpty(vo.getShipperCounty())) {
				param += "&shipperCounty=" + encode(vo.getShipperCounty());
			}
			HttpUtil httpUtil = new HttpUtil(url);
			String json = httpUtil.post("", param);
			priceTimeList = JsonUtils.toList(json, PriceTimeVo.class);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (Exception ex){
			ex.printStackTrace();
		}
		return priceTimeList;
	}
	
	private String encode(String str) throws UnsupportedEncodingException{
		return URLEncoder.encode(URLEncoder.encode(str, "UTF-8"),"UTF-8");
	}
	*/

}
