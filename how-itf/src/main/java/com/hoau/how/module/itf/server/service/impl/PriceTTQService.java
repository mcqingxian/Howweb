package com.hoau.how.module.itf.server.service.impl;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Service;

import com.hoau.hbdp.framework.shared.util.JsonUtils;
import com.hoau.how.module.itf.server.service.IPriceTTQService;
import com.hoau.how.module.itf.server.ws.dcpricetime.PriceQueryResult;
import com.hoau.how.module.itf.shared.vos.pricetime.PriceQueryVo;
import com.hoau.how.module.itf.shared.vos.pricetime.PriceTimeVo;
import com.hoau.how.module.util.StringUtil;
import com.hoau.how.module.util.config.ConfigConstants;
import com.hoau.how.module.util.config.ConfigUtils;
import com.hoau.how.module.util.http.HttpUtil;

/**
 * @author：龙海仁
 * @create：2015年9月14日 上午9:10:39
 * @description：
 */
@Service
public class PriceTTQService implements IPriceTTQService {

	@Override
	public List<PriceQueryResult> getTTQPrice(PriceQueryVo priceVo) {
		Properties properties = ConfigUtils
				.getConfig(ConfigConstants.PRICE.CONFIG_NAME);
		String url = properties
				.getProperty(ConfigConstants.PRICE.TTQ_PRICE_URL);
		List<PriceQueryResult> priceList = new ArrayList<PriceQueryResult>();
		try {
			if (StringUtil.isNotEmpty(priceVo.getConCity())) {

				url = url
						+ "conCity="
						+ URLEncoder.encode(URLEncoder.encode(
								priceVo.getConCity(), "utf-8"), "utf-8");
			}
			if (StringUtil.isNotEmpty(priceVo.getConCounty())) {
				url = url
						+ "&conCounty="
						+ URLEncoder.encode(URLEncoder.encode(
								priceVo.getConCounty(), "utf-8"), "utf-8");
			}
			if (StringUtil.isNotEmpty(priceVo.getShipperCity())) {
				url = url
						+ "&shipperCity="
						+ URLEncoder.encode(URLEncoder.encode(
								priceVo.getShipperCity(), "utf-8"), "utf-8");
			}
			if (StringUtil.isNotEmpty(priceVo.getShipperCounty())) {
				url = url
						+ "&shipperCounty="
						+ URLEncoder.encode(URLEncoder.encode(
								priceVo.getShipperCounty(), "utf-8"), "utf-8");
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		String response;
		List<PriceTimeVo> prices = new ArrayList<PriceTimeVo>();
		try {
			response = HttpUtil.httpGet(url);
			prices = JsonUtils.toList(response, PriceTimeVo.class);
			priceList = toPriceResult(prices);
		} catch (Exception e) {
		}
		return priceList;
	}

	public List<PriceQueryResult> toPriceResult(List<PriceTimeVo> prices) {
		List<PriceQueryResult> results = new ArrayList<PriceQueryResult>();
		for (PriceTimeVo price : prices) {
			PriceQueryResult result = new PriceQueryResult();

			result.setDeliveryTime(getNumbers(price.getEbpdDeliveryHour()));
			result.setPickTime(getNumbers(price.getEbpdSendHour()));

			result.setHeavyPrice(price.getEbpdHeavyCargo());
			result.setHeveryDiscount(price.getEbdiHeavyGoods());
			result.setLightPrice(price.getEbpdLightCargo());
			result.setLightDiscount(price.getEbdiLightGoods());
			if ("定日达".equals(price.getEbptNameCn())) {
				result.setTransportType("ONTIME");
			} else if ("普通零担".equals(price.getEbptNameCn())) {
				result.setTransportType("LESSLOADED");
			} 

			result.setStartPrice(price.getEbpdStartPrice());

			result.setInsuredRate(4D);
			result.setMinInsuredFee(8D);

			result.setIssusingFee(2D);

			result.setMessageFee(1D);

			result.setSurcharge(10D);

			results.add(result);
		}
		return results;
	}

	// 截取数字
	public static String getNumbers(String content) {
		List<String> result = new ArrayList<String>();
		try {
			Pattern pattern = Pattern.compile("\\d+");
			Matcher matcher = pattern.matcher(content);
			while (matcher.find()) {
				if (!"".equals(matcher.group())) {
					result.add(matcher.group());
				}
			}
			String rtn = "";
			for (String str : result) {
				rtn = rtn + str + "-";
			}
			return rtn.substring(0, rtn.length() - 1);
		} catch (Exception e) {
		}
		return null;
	}

}
