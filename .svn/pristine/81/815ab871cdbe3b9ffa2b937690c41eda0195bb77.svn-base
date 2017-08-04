package com.hoau.how.module.itf.server.service.impl;

import com.hoau.hbdp.framework.shared.util.JsonUtils;
import com.hoau.hbdp.framework.shared.util.classes.BeanUtils;
import com.hoau.how.module.itf.server.service.IPriceTimeManager;
import com.hoau.how.module.itf.server.ws.dcpricetime.HowPriceAndTimeQueryServices;
import com.hoau.how.module.itf.server.ws.dcpricetime.HowPriceAndTimeQueryServices_Service;
import com.hoau.how.module.itf.server.ws.dcpricetime.PriceQueryResult;
import com.hoau.how.module.itf.server.ws.dcpricetime.PriceQueryResultVo;
import com.hoau.how.module.itf.shared.vos.pricetime.PriceCalcRespVo;
import com.hoau.how.module.itf.shared.vos.pricetime.PriceQueryVo;
import com.hoau.how.module.util.StringUtil;
import com.hoau.how.module.util.config.ConfigConstants;
import com.hoau.how.module.util.config.ConfigUtils;
import com.hoau.miser.module.api.itf.api.shared.vo.HowAppPriceQueryParam;
import com.hoau.miser.module.api.itf.api.shared.vo.HowAppPriceQueryPriceDetail;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;



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
	@Resource
	private RestTemplate restTemplate;
	
	private HowPriceAndTimeQueryServices port;
	public PriceTimeManager(){
		Properties properties = ConfigUtils.getConfig(ConfigConstants.PRICE.CONFIG_NAME);
        String priceUrl = properties.getProperty(ConfigConstants.PRICE.DC_PRICE_URL);
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
	public List<PriceQueryResultVo> queryPriceTime(PriceQueryVo vo) {
		List<PriceQueryResult> priceResult = null;
		List<PriceQueryResultVo> priceQueryResultVos = new ArrayList<PriceQueryResultVo>();
		String pickTime = "";
		String deliveryTime = "";
		try {
			priceResult = port.queryPriceAndTime(changeTtqQuery(vo));
			if(priceResult.size()==0){
				priceResult = priceTTQService.getTTQPrice(vo);
				if(priceResult != null && priceResult.size() != 0){
					for (int i = 0; i < priceResult.size(); i++) {
						PriceQueryResult rs = priceResult.get(i);
						//pickTime = rs.getPickTime();
						//deliveryTime = rs.getDeliveryTime();
						rs.setPickTime(rs.getPickTime());
						rs.setDeliveryTime(rs.getDeliveryTime());
					}
				}
			}
			if(priceResult != null){
				for(int i = 0 ;i < priceResult.size() ; i ++){
					PriceQueryResultVo valueVo = new PriceQueryResultVo();
					BeanUtils.copyProperties(priceResult.get(i), valueVo); //拷贝定日达的数据
					priceQueryResultVos.add(valueVo);
				}
			}
			//增加易入户、 易包裹、 易安装的数据（田育林，2016-4-27）
			priceQueryResultVos = addPriceQueryResult(priceQueryResultVos,vo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return priceQueryResultVos;
	}

	/**
	 * 价格计算
	 */
	@Override
	public List<PriceCalcRespVo> priceCalc(PriceQueryVo vo) {
		List<PriceCalcRespVo> priceCalcList = new ArrayList<PriceCalcRespVo>();
		List<PriceQueryResult> priceResult = null;
		List<PriceQueryResultVo> priceQueryResultVos = new ArrayList<PriceQueryResultVo>();
		//普通零担：LESSLOADED，定日达：ONTIME，易入户：INHOME，易安装：INSTALL，易包裹：PACKAGE
		try {
			priceResult = port.queryPriceAndTime(changeTtqQuery(vo));
			
			if(priceResult.size()==0){
				priceResult = priceTTQService.getTTQPrice(vo);
			}
			if(priceResult != null){
				for(int i = 0 ;i < priceResult.size() ; i ++){
					PriceQueryResultVo valueVo = new PriceQueryResultVo();
					BeanUtils.copyProperties(priceResult.get(i), valueVo); //拷贝定日达的数据
					priceQueryResultVos.add(valueVo);
				}
			}
			//增加易入户、 易包裹、 易安装的数据（田育林，2016-4-27）
			priceQueryResultVos = addPriceQueryResult(priceQueryResultVos,vo);
			for (PriceQueryResultVo priceTimeVo : priceQueryResultVos) {
				PriceCalcRespVo priceCalcVo = new PriceCalcRespVo();
				//设置是否显示该项
				priceCalcVo.setExist(priceTimeVo.getExist());
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
				/****************易到家货物按重货计算*********************/
				if(priceTimeVo.getTransportType().equals("PACKAGE") || 
						priceTimeVo.getTransportType().equals("INHOME") || 
						priceTimeVo.getTransportType().equals("INSTALL")){
					//体积折算重量
					Double volumn = vo.getVolumn() * 222.23;
					if(vo.getWeight() > volumn){
						//设置货物类型
						priceCalcVo.setGoodsType("重货");
					}else{
						//如果是轻货则用这算后的重量进行计算
						vo.setWeight(volumn);
						priceCalcVo.setGoodsType("轻货");
					}
				}
				/****************易到家货物计算运费*********************/
				if(priceTimeVo.getTransportType().equals("PACKAGE") || 
						priceTimeVo.getTransportType().equals("INHOME") || 
						priceTimeVo.getTransportType().equals("INSTALL")){
					/**
					 * 重量 <= 首重重量  ，运费 =首重金额
					 * 
					 * 重量 >首重重量，那么 运费 = 首重金额 + （重量-首重重量）*续重单价
					 * 
					 *  因为在addPriceQueryResult方法里面已经把这三个变量的赋值如下，所以请一一对应
					    priceQueryResult.setStartPrice(detail.getFirstSectionWeight().doubleValue());	//首重重量
						priceQueryResult.setHeavyPrice(detail.getFirstSectionPrice().doubleValue());	//首重金额
						priceQueryResult.setLightPrice(detail.getAddPrice().doubleValue());				//续重金额
					 */
					if(vo.getWeight() <= priceTimeVo.getStartPrice()){
						//设置运费
						priceCalcVo.setTransCost(df.format(Math.ceil(priceTimeVo.getHeavyPrice())));
					}else if(vo.getWeight() > priceTimeVo.getStartPrice()){
						Double price = priceTimeVo.getHeavyPrice() + (vo.getWeight() - priceTimeVo.getStartPrice()) * priceTimeVo.getLightPrice();
						//设置运费
						priceCalcVo.setTransCost(df.format(Math.ceil(price)));
					}
				}else{
					/****************经济快运，定日达计算运费*********************/
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
				}
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
				
				//代收货款手续费最大值100，
				if(charge > 100){
					charge = 100D;
				}
				
				//设置代收货款费
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

	
	private static com.hoau.how.module.itf.server.ws.dcpricetime.PriceQueryVo changeTtqQuery(PriceQueryVo priceVo){
		com.hoau.how.module.itf.server.ws.dcpricetime.PriceQueryVo vo = new com.hoau.how.module.itf.server.ws.dcpricetime.PriceQueryVo();
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
	
	//增加易入户、 易包裹、 易安装的数据（田育林，2016-4-27）
	//易入户、 易包裹、 易安装的数据从PMS中获取
	//将PMS数据添加或者覆盖目前TTQ的和DC数据，如果有的话
	//莫涛  2016年12月27日19:52:41
	private List<PriceQueryResultVo> addPriceQueryResult(List<PriceQueryResultVo> priceResult,PriceQueryVo vo){
		List<PriceQueryResultVo> copyPqrs = new ArrayList<PriceQueryResultVo>();
		if(priceResult!=null && priceResult.size()>0){
			for(PriceQueryResultVo pqr : priceResult){
				if("ONTIME".equals(pqr.getTransportType())){ //找到定日达的数据
					for(int j=0; j<3; j++){
						PriceQueryResultVo copyPqr = new PriceQueryResultVo();
						BeanUtils.copyProperties(pqr, copyPqr); //拷贝定日达的数据
						if(j==0){
							copyPqr.setTransportType("INHOME"); //易入户
							//设置为隐藏，因为不确定是否存在易到家数据
							copyPqr.setExist(1);
						}else if(j==1){
							copyPqr.setTransportType("INSTALL"); //易安装
							//设置为隐藏，因为不确定是否存在易到家数据
							copyPqr.setExist(1);
						}else{
							copyPqr.setTransportType("PACKAGE"); //易包裹
							//设置为隐藏，因为不确定是否存在易到家数据
							copyPqr.setExist(1);
						}
						copyPqrs.add(copyPqr);
					}
				}
			}
			priceResult.addAll(copyPqrs);
		}
		/**
		 * 调用PMS查询价格信息
		 */
		Properties properties = ConfigUtils.getConfig(ConfigConstants.PMS_URL.CONFIG_NAME);
		String pms_url = properties.getProperty(ConfigConstants.PMS_URL.PMS_URL);
		HowAppPriceQueryParam queryParam = new HowAppPriceQueryParam();
		queryParam.setSendCityName(vo.getShipperCity());
		queryParam.setSendCountyName(vo.getShipperCounty());
		queryParam.setArrivalCityName(vo.getConCity());
		queryParam.setArrivalCountyName(vo.getConCounty());
		String rsJson = restTemplate.postForObject(pms_url, queryParam, String.class);
		if(rsJson != null && !rsJson.equals("")){
			List<HowAppPriceQueryPriceDetail> result = JsonUtils.toList(rsJson, HowAppPriceQueryPriceDetail.class);
			if(result != null){
				for(int i = 0 ; i < result.size() ; i ++){
					HowAppPriceQueryPriceDetail detail = result.get(i);
					//80000000000000000001  易包裹
					//60000000000000000001  易入户
					//70000000000000000001  易安装
					for(int j = 0 ; j < priceResult.size() ; j ++){
						PriceQueryResultVo priceQueryResult = priceResult.get(j);
						if(priceQueryResult.getTransportType().equals("PACKAGE") && detail.getTransportTypeCode().equals("80000000000000000001")){
							//易包裹
							priceQueryResult.setStartPrice(detail.getFirstSectionWeight().doubleValue());	//首重重量
							priceQueryResult.setHeavyPrice(detail.getFirstSectionPrice().doubleValue());	//首重金额
							priceQueryResult.setLightPrice(detail.getAddPrice().doubleValue());				//续重金额
							priceQueryResult.setReamrk(detail.getReamrk() == null ? "" : detail.getReamrk());
							//设置为显示，表示为有易到家数据
							priceQueryResult.setExist(0);
							continue;
						}else if(priceQueryResult.getTransportType().equals("INHOME") && detail.getTransportTypeCode().equals("60000000000000000001")){
							//易入户
							priceQueryResult.setStartPrice(detail.getFirstSectionWeight().doubleValue());	//首重重量
							priceQueryResult.setHeavyPrice(detail.getFirstSectionPrice().doubleValue());	//首重金额
							priceQueryResult.setLightPrice(detail.getAddPrice().doubleValue());				//续重金额
							priceQueryResult.setReamrk(detail.getReamrk() == null ? "" : detail.getReamrk());
							//设置为显示，表示为有易到家数据
							priceQueryResult.setExist(0);
							continue;
						}else if(priceQueryResult.getTransportType().equals("INSTALL") && detail.getTransportTypeCode().equals("70000000000000000001")){
							//易安装
							priceQueryResult.setStartPrice(detail.getFirstSectionWeight().doubleValue());	//首重重量
							priceQueryResult.setHeavyPrice(detail.getFirstSectionPrice().doubleValue());	//首重金额
							priceQueryResult.setLightPrice(detail.getAddPrice().doubleValue());				//续重金额
							priceQueryResult.setReamrk(detail.getReamrk() == null ? "" : detail.getReamrk());
							//设置为显示，表示为有易到家数据
							priceQueryResult.setExist(0);
							continue;
						}else if(priceQueryResult.getTransportType().equals("LESSLOADED") && detail.getTransportTypeCode().equals("30000000000000000001")){
							//经济快运
							priceQueryResult.setStartPrice(detail.getMinFreightFee().doubleValue());	//起步价
							priceQueryResult.setHeavyPrice(detail.getWeightPrice().doubleValue());		//重货单价
							priceQueryResult.setLightPrice(detail.getVolumePrice().doubleValue());		//轻货单价
							priceQueryResult.setReamrk(detail.getReamrk() == null ? "" : detail.getReamrk());
							continue;
						}else if(priceQueryResult.getTransportType().equals("ONTIME") && detail.getTransportTypeCode().equals("10000000000000000001")){
							//定日达
							priceQueryResult.setStartPrice(detail.getMinFreightFee().doubleValue());	//起步价
							priceQueryResult.setHeavyPrice(detail.getWeightPrice().doubleValue());		//重货单价
							priceQueryResult.setLightPrice(detail.getVolumePrice().doubleValue());		//轻货单价
							priceQueryResult.setReamrk(detail.getReamrk() == null ? "" : detail.getReamrk());
							continue;
						}
					}
				}
			}
		}
		/*
		if(priceResult!=null && priceResult.size()>0){
			for(PriceQueryResult pqr : priceResult){
				if("ONTIME".equals(pqr.getTransportType())){ //找到定日达的数据
					for(int j=0; j<3; j++){
						PriceQueryResult copyPqr = new PriceQueryResult();
						BeanUtils.copyProperties(pqr, copyPqr); //拷贝定日达的数据
						if(j==0){
							copyPqr.setTransportType("INHOME"); //易入户
						}else if(j==1){
							copyPqr.setTransportType("INSTALL"); //易安装
						}else{
							copyPqr.setTransportType("PACKAGE"); //易包裹
						}
						copyPqrs.add(copyPqr);
					}
				}
			}
			priceResult.addAll(copyPqrs);
		}
		*/
		return priceResult;
	}
}
