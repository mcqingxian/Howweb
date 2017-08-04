package com.hoau.mhow.module.bse.server.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.hoau.hbdp.framework.exception.BusinessException;
import com.hoau.hbdp.framework.server.web.action.AbstractAction;
import com.hoau.hbdp.framework.shared.util.string.StringUtil;
import com.hoau.mhow.module.bse.api.server.service.ICompanyMatchService;
import com.hoau.mhow.module.bse.api.shared.vo.DepartmentVo;
import com.hoau.mhow.module.bse.api.shared.vo.DistrictVo;

/**
 *
 * @author 莫涛
 * @date 2015年6月25日
 */
@Controller
@Scope("prototype")
public class CompanyMatchAction extends AbstractAction{
	private static final long serialVersionUID = 1L;
	@Resource
	private ICompanyMatchService companyMatchService;
	
	private String categoryName;
	//街道名称，用于匹配网点时使用
	private String arrivedCityName;
	private List<DistrictVo> districtVos;
	private List<DepartmentVo> departmentVos;
	private List<String> pinYins;
	private String typeName;
	private String typeValue;
	
	/**
	 * 省市区参数
	 */
	private String pro_city_cty;
	
	public String index() throws Exception {
		return "index";
	}
	
	public String queryProvinceCountJson() throws Exception {
		try{
			//pinYins = companyScreenService.queryPinYin();
			districtVos = companyMatchService.queryProvinceCount();
		}catch(BusinessException ex){
			ex.printStackTrace();
			return returnError(ex);
		}
		return "queryProvinceCountJson";
	}
	
	public String queryCityCountJson() throws Exception{
		try{
			Map<String,String> map = new HashMap<String,String>();
			map.put(typeName,typeValue);
			districtVos = companyMatchService.queryCityCount(map);
		}catch(BusinessException ex){
			ex.printStackTrace();
			return returnError(ex);
		}
		return "queryCityCountJson";
	}
	
	public String queryCountyCountJson() throws Exception{
		try{
			//hotCityService.putHotCity(typeValue);
			districtVos = companyMatchService.queryCountyCount(typeValue);
		}catch(BusinessException ex){
			ex.printStackTrace();
			return returnError(ex);
		}
		return "queryCountyCountJson";
	}
	
	public String queryCounty() throws Exception{
		try{
			Map<String,String> map = new HashMap<String,String>();
			map.put(typeName,typeValue);
			departmentVos = companyMatchService.queryCounty(map);
		}catch(BusinessException ex){
			ex.printStackTrace();
			return returnError(ex);
		}
		return "queryCounty";
	}
	
	/**
	 * 根据省市区查询部门信息，并进入结果页
	 * @return
	 * @author 莫涛
	 * @date 2015年7月5日
	 * @update
	 */
	public String queryDeptByDistrictName(){
		try{
			Map<String,String> map = new HashMap<String,String>();
			/*if(!StringUtil.isEmpty(typeValue)){
				String[] params = typeValue.split("-");
				map.put("province", params[0]);
				if(params.length > 1){
					map.put("city",params[1]);
				}
				if(this.arrivedCityName == null || this.arrivedCityName.equals("")){
					if(params.length > 2){
						map.put("county",params[2]);
					}
				}
			}*/
			if(pro_city_cty != null){
				String[] ps = pro_city_cty.split(" ");
				if(ps.length > 2){
					map.put("province", ps[0]);
					map.put("city",ps[1]);
					map.put("county",ps[2]);
					departmentVos = companyMatchService.queryDeptByDistrictName(map);
				}
			}
			if(departmentVos == null){
				departmentVos = new ArrayList<DepartmentVo>(); 
			}
			/*if(departmentVos != null && departmentVos.size() > 0){
				DepartmentVo vo = departmentVos.get(0);
				hotCityService.putHotCity(vo.getCityCode());
			}*/
		}catch(BusinessException ex){
			ex.printStackTrace();
			return returnError(ex);
		}
		return "queryDeptByDistrictName";
	}
	
	/**
	 * 根据省市区查询部门信息，并进入结果页
	 * @return
	 * @author 莫涛
	 * @date 2015年7月5日
	 * @update
	 */
	public String queryDeptByDistrictNameJson(){
		try{
			Map<String,String> map = new HashMap<String,String>();
			/*if(!StringUtil.isEmpty(typeValue)){
				String[] params = typeValue.split("-");
				map.put("province", params[0]);
				if(params.length > 1){
					map.put("city",params[1]);
				}
				if(this.arrivedCityName == null || this.arrivedCityName.equals("")){
					if(params.length > 2){
						map.put("county",params[2]);
					}
				}
			}*/
			if(pro_city_cty != null){
				String[] ps = pro_city_cty.split(" ");
				if(ps.length > 2){
					map.put("province", ps[0]);
					map.put("city",ps[1]);
					map.put("county",ps[2]);
					departmentVos = companyMatchService.queryDeptByDistrictName(map);
				}
			}
			if(departmentVos == null){
				departmentVos = new ArrayList<DepartmentVo>(); 
			}
			/*if(departmentVos != null && departmentVos.size() > 0){
				DepartmentVo vo = departmentVos.get(0);
				hotCityService.putHotCity(vo.getCityCode());
			}*/
		}catch(BusinessException ex){
			ex.printStackTrace();
			return returnError(ex);
		}
		return "queryDeptByDistrictNameJson";
	}
	
	public String queryHotCityJson(){
		try{
			districtVos = companyMatchService.queryHotCity();
		}catch(BusinessException ex){
			ex.printStackTrace();
			return returnError(ex);
		}
		return "queryHotCityJson";
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public String getTypeValue() {
		return typeValue;
	}

	public void setTypeValue(String typeValue) {
		this.typeValue = typeValue;
	}

	public List<DistrictVo> getDistrictVos() {
		return districtVos;
	}

	public List<DepartmentVo> getDepartmentVos() {
		return departmentVos;
	}

	public List<String> getPinYins() {
		return pinYins;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public void setArrivedCityName(String arrivedCityName) {
		this.arrivedCityName = arrivedCityName;
	}

	public String getPro_city_cty() {
		return pro_city_cty;
	}

	public void setPro_city_cty(String pro_city_cty) {
		this.pro_city_cty = pro_city_cty;
	}
}