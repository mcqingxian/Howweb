package com.hoau.how.module.bse.server.action.pricetime;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.hoau.hbdp.framework.exception.BusinessException;
import com.hoau.hbdp.framework.server.web.action.AbstractAction;
import com.hoau.hbdp.framework.server.web.result.json.annotation.JSON;
import com.hoau.how.module.bse.server.service.pricetime.IPriceTimeService;
import com.hoau.how.module.bse.shared.exception.MessageType;
import com.hoau.how.module.itf.server.ws.dcpricetime.PriceQueryResultVo;
import com.hoau.how.module.itf.shared.vos.pricetime.PriceCalcRespVo;
import com.hoau.how.module.itf.shared.vos.pricetime.PriceQueryVo;
import com.hoau.how.module.util.JsonUtils;

@Controller
@Scope("prototype")
public class QueryPriceTimeAction extends AbstractAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4938630304600261544L;
	
	private Logger logger = Logger.getLogger(QueryPriceTimeAction.class);
	
	private String categoryName;
	private String leavedCityName;
	private String arrivedCityName;
	
	@Resource
	private IPriceTimeService priceTimeService;
	
	//查询
	private PriceQueryVo priceQueryVo;
	//价格时效
	private List<PriceQueryResultVo> priceTimeVos;
	//计算价格
	private List<PriceCalcRespVo> priceCalcVos;
	
	
	@JSON
	public String queryPriceTime(){
		try {
			logger.info(JsonUtils.toJson(priceQueryVo));
			priceTimeVos = priceTimeService.queryPriceTime(priceQueryVo);
			logger.info(JsonUtils.toJson(priceTimeVos));
			return returnSuccess(MessageType.QUERY_SUCCESS);
		} catch (BusinessException e) {
			return returnError(e);
		}
	}
	
	public String priceCalc(){
		try {
			logger.info(priceQueryVo);
			priceCalcVos = priceTimeService.priceCalc(priceQueryVo);
			logger.info(priceCalcVos);
			return returnSuccess(MessageType.QUERY_SUCCESS);
		} catch (BusinessException e) {
			e.printStackTrace();
			return returnError(e);
		}
	}

	public String getLeavedCityName() {
		return leavedCityName;
	}

	public void setLeavedCityName(String leavedCityName) {
		this.leavedCityName = leavedCityName;
	}

	public String getArrivedCityName() {
		return arrivedCityName;
	}

	public void setArrivedCityName(String arrivedCityName) {
		this.arrivedCityName = arrivedCityName;
	}

	public PriceQueryVo getPriceQueryVo() {
		return priceQueryVo;
	}


	public void setPriceQueryVo(PriceQueryVo priceQueryVo) {
		this.priceQueryVo = priceQueryVo;
	}


	public List<PriceQueryResultVo> getPriceTimeVos() {
		return priceTimeVos;
	}

	public void setPriceTimeVos(List<PriceQueryResultVo> priceTimeVos) {
		this.priceTimeVos = priceTimeVos;
	}

	public List<PriceCalcRespVo> getPriceCalcVos() {
		return priceCalcVos;
	}

	public void setPriceCalcVos(List<PriceCalcRespVo> priceCalcVos) {
		this.priceCalcVos = priceCalcVos;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	
	

}
