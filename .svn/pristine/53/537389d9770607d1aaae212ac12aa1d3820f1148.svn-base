package com.hoau.how.module.bse.server.action.company;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.hoau.hbdp.framework.exception.BusinessException;
import com.hoau.hbdp.framework.server.web.action.AbstractAction;
import com.hoau.how.module.bse.server.service.company.ICompanyScreenService;
import com.hoau.how.module.bse.server.service.company.IHotCityService;
import com.hoau.how.module.bse.shared.vo.DepartmentVo;
import com.hoau.how.module.bse.shared.vo.DistrictVo;
import com.hoau.how.module.itf.shared.domain.DepartmentEntity;

/**
 *
 * @author 莫涛
 * @date 2015年6月25日
 */
@Controller
@Scope("prototype")
public class CompanyScreenAction extends AbstractAction{
	private static final long serialVersionUID = 1L;
	@Resource
	private ICompanyScreenService companyScreenService;
	@Resource
	private IHotCityService hotCityService;
	private String pinYin;
	private Map<String,List<DistrictVo>> districtMap;
	private List<DepartmentVo> departmentList;
	private DepartmentVo departmentEntity;
	private List<String> pinYins;
	private Integer pageNo;
	private Integer pageSize;
	private long recordCount;
	private String code;
	private String categoryName;
	/**
	 * 查询类型
	 */
	private String typeName;
	/**
	 * 查询值
	 */
	private String typeValue;
	/**
	 * 查询城市
	 */
	private String districtName;
	
	public String queryAll(){
		try{
			pinYins = companyScreenService.queryPinYin();
			districtMap = companyScreenService.queryDistrict(pinYin);
		}catch(BusinessException ex){
			ex.printStackTrace();
			return returnError(ex);
		}
		return "queryAll";
	}
	
	public String queryCompanyDetail(){
		try{
//			code = new String(code.getBytes("ISO-8859-1"),"UTF-8");
			departmentEntity = companyScreenService.queryCompanyDetail(code);
		}catch(BusinessException ex){
			ex.printStackTrace();
			return returnError(ex);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "queryCompanyDetail";
	}
	public String pageQueryScreen(){
		try{
			Map<String,String> map = new HashMap<String,String>();
			if(pageSize == null || pageSize == 0){
				pageSize = 10;
			}
			if(pageNo == null || pageNo == 0){
				pageNo = 1;
			}
			Integer pageStart = (pageNo - 1) * pageSize + 1;
			Integer pageEnd = pageNo * pageSize;
			map.put("pageStart", String.valueOf(pageStart));
			map.put("pageEnd", String.valueOf(pageEnd));
			try {
//				districtName = new String(districtName.getBytes("ISO-8859-1"),"UTF-8");
//				typeValue = new String(typeValue.getBytes("ISO-8859-1"),"UTF-8");
				map.put(typeName, typeValue);
				if(typeName!= null && typeName.equals("districtCode")){
					hotCityService.putHotCity(typeValue);
				}
				if(!districtName.equals("")){
					typeValue = "";
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			departmentList = companyScreenService.queryDeptList(map);
			recordCount = companyScreenService.countDeptList(map);
		}catch(BusinessException ex){
			ex.printStackTrace();
			return returnError(ex);
		}
		return "pageQueryScreen";
	}
	
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public void setTypeValue(String typeValue) {
		this.typeValue = typeValue;
	}
	
	public String getTypeName() {
		return typeName;
	}

	public String getTypeValue() {
		return typeValue;
	}

	public List<DepartmentVo> getDepartmentList() {
		return departmentList;
	}

	public Map<String, List<DistrictVo>> getDistrictMap() {
		return districtMap;
	}

	public void setPinYin(String pinYin) {
		this.pinYin = pinYin;
	}
	
	public String getPinYin() {
		return pinYin;
	}

	public List<String> getPinYins() {
		return pinYins;
	}

	public Integer getPageNo() {
		return pageNo;
	}

	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public long getRecordCount() {
		return recordCount;
	}

	public String getDistrictName() {
		return districtName;
	}

	public void setDistrictName(String districtName) {
		this.districtName = districtName;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public DepartmentVo getDepartmentEntity() {
		return departmentEntity;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	
}