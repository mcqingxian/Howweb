package com.hoau.mhow.module.bse.server.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.hoau.hbdp.framework.exception.BusinessException;
import com.hoau.hbdp.framework.server.web.action.AbstractAction;
import com.hoau.mhow.invokews.server.ws.dcpricetime.PriceQueryVo;
import com.hoau.mhow.module.bse.api.server.service.IDistrictInfoService;
import com.hoau.mhow.module.bse.api.server.service.IPriceTimeService;
import com.hoau.mhow.module.bse.api.shared.vo.PriceCalcRespVo;
import com.hoau.miser.module.api.itf.api.shared.vo.HowAppPriceQueryPriceDetail;

@Controller
@Scope("prototype")
public class DistrictInfoAction extends AbstractAction{

	private static final long serialVersionUID = -323660018747657054L;
	
	@Resource
	private IDistrictInfoService iDistrictInfoService;
	
	@Resource
	private IPriceTimeService priceTimeService;
	
	/**
	 * 省份列表
	 */
	private List<String> provinces;
	private List<String> citys;
	private List<String> countys;
	
	/**
	 * 省份参数
	 */
	private String province;
	
	/**
	 * 城市参数
	 */
	private String city;
	
	/**
	 * 价格查询VO
	 */
	private PriceQueryVo priceQueryVo;
	
	/**
	 * 价格时效
	 */
	private List<HowAppPriceQueryPriceDetail> priceTimeVos;
	
	/**
	 * 计算价格
	 */
	private List<PriceCalcRespVo> priceCalcVos;
	
	@Override
	public String execute() throws Exception {
		
		return SUCCESS;
	}
	
	/**
	 * 查询省的信息
	 * 
	 * @return
	 * @author 蒋落琛
	 * @date 2015-12-15
	 * @update
	 */
	public String queryProvinceInfo(){
		provinces = iDistrictInfoService.queryProvincesNameList();
		return SUCCESS;
	}
	
	/**
	 * 查询城市信息
	 * 
	 * @return
	 * @author 蒋落琛
	 * @date 2015-12-15
	 * @update
	 */
	public String queryCityInfo(){
		citys = iDistrictInfoService.queryCitysNameList(province);
		return SUCCESS;
	}
	
	/**
	 * 查询区县信息
	 * 
	 * @return
	 * @author 蒋落琛
	 * @date 2015-12-15
	 * @update
	 */
	public String queryCountyInfo(){
		countys= iDistrictInfoService.queryCountyNameList(city);
		return SUCCESS;
	}
	
	/**
	 * 查询区县信息
	 * 
	 * @return
	 * @author 蒋落琛
	 * @date 2015-12-15
	 * @update
	 */
	public String queryCountyInfoByProvinceCity(){
		countys= iDistrictInfoService.queryCountyNameListByProvinceCity(province, city);
		return SUCCESS;
	}
	
	/**
	 * 查询时效
	 * 
	 * @return
	 */
	public String queryPriceTime(){
		try {
			priceTimeVos = priceTimeService.queryPriceTime(priceQueryVo);
			return returnSuccess();
		} catch (BusinessException e) {
			return returnError(e);
		}
	}
	
	/**
	 * 查询价格
	 * 
	 * @return
	 * @author 蒋落琛
	 * @date 2015-12-16
	 * @update
	 */
	public String priceCalc(){
		try {
			priceCalcVos = priceTimeService.priceCalc(priceQueryVo);
			return returnSuccess();
		} catch (BusinessException e) {
			e.printStackTrace();
			return returnError(e);
		}
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public List<String> getProvinces() {
		return provinces;
	}

	public void setProvinces(List<String> provinces) {
		this.provinces = provinces;
	}

	public List<String> getCitys() {
		return citys;
	}

	public void setCitys(List<String> citys) {
		this.citys = citys;
	}

	public List<String> getCountys() {
		return countys;
	}

	public void setCountys(List<String> countys) {
		this.countys = countys;
	}

	public PriceQueryVo getPriceQueryVo() {
		return priceQueryVo;
	}

	public void setPriceQueryVo(PriceQueryVo priceQueryVo) {
		this.priceQueryVo = priceQueryVo;
	}

	public List<HowAppPriceQueryPriceDetail> getPriceTimeVos() {
		return priceTimeVos;
	}

	public void setPriceTimeVos(List<HowAppPriceQueryPriceDetail> priceTimeVos) {
		this.priceTimeVos = priceTimeVos;
	}

	public List<PriceCalcRespVo> getPriceCalcVos() {
		return priceCalcVos;
	}

	public void setPriceCalcVos(List<PriceCalcRespVo> priceCalcVos) {
		this.priceCalcVos = priceCalcVos;
	}
}
