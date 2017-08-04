package com.hoau.how.module.bse.server.action.company;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.hoau.hbdp.framework.exception.BusinessException;
import com.hoau.hbdp.framework.server.web.action.AbstractAction;
import com.hoau.how.module.bse.server.service.company.ICompanyMatchService;
import com.hoau.how.module.bse.server.service.company.ICompanyScreenService;
import com.hoau.how.module.bse.server.service.company.IHotCityService;
import com.hoau.how.module.bse.shared.vo.DepartmentVo;
import com.hoau.how.module.bse.shared.vo.DistrictVo;
import com.hoau.how.module.util.StringUtil;

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
	@Resource
	private ICompanyScreenService companyScreenService;
	
	@Resource
	private IHotCityService hotCityService;
	
	private String categoryName;
	//街道名称，用于匹配网点时使用
	private String arrivedCityName;
	private List<DistrictVo> districtVos;
	private List<DepartmentVo> departmentVos;
	private List<String> pinYins;
	private String typeName;
	private String typeValue;
	public String index() throws Exception {
		return "index";
	}
	
	public String queryProvinceCountJson() throws Exception {
		try{
			pinYins = companyScreenService.queryPinYin();
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
			hotCityService.putHotCity(typeValue);
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
	 * 根据省市区查询部门信息
	 * @return
	 * @author 莫涛
	 * @date 2015年7月5日
	 * @update
	 */
	public String queryDeptByDistrictNameJson(){
		try{
			Map<String,String> map = new HashMap<String,String>();
			if(!StringUtil.isEmpty(typeValue)){
				String[] params = typeValue.split("-");
				map.put("province", params[0]);
				if(params.length > 1){
					map.put("city",params[1]);
				}
				if(params.length > 2){
					map.put("county",params[2]);
				}

				if (this.arrivedCityName != null && this.arrivedCityName!="") {
					map.put("addressDetail", this.arrivedCityName);
				}
			}
			departmentVos = companyMatchService.queryDeptByDistrictName(map);
			if(departmentVos != null && departmentVos.size() > 0){
				DepartmentVo vo = departmentVos.get(0);
				hotCityService.putHotCity(vo.getCityCode());
			}
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
}