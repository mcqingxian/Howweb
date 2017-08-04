package com.hoau.wechat.action;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.hoau.wechat.service.IDepartmentService;
import com.hoau.wechat.service.IDeptService;
import com.hoau.wechat.util.JsonUtils;
import com.hoau.wechat.vo.AddressInfo;
import com.hoau.wechat.vo.DepartmentListVO;
import com.opensymphony.xwork2.Action;

@Controller
@Scope("prototype")
public class DepartmentListAction implements Action{
	private static final Log LOG = LogFactory.getLog(DepartmentListAction.class);
	/**
	 * 经度
	 */
	private String lon;
	/**
	 * 纬度
	 */
	private String lat;
	/**
	 * 该经度，纬度，附近网点个数
	 */
	private int number;
	/**
	 * cond：查询过滤办法，枚举类型，取值如下：
	 * "dis"：表示按照距离范围过滤
	 * "lim"：表示按照返回结果数量过滤
	 */
	private String cond;
	
	private String code;
	
//	private AddressInfo addressInfo;
	
	private List<DepartmentListVO> departmentListActions;

	private String pro_city_cty;
	
	private String llon;
	private String llat;
	private String status;
	
	@Resource
	private IDepartmentService departmentService;
	
	@Resource
	private IDeptService deptService;
	
	@Override
	public String execute() throws Exception {
		getDepartmentsList();
		return SUCCESS;
	}
	
	public String getListByAddress() throws Exception {
		if(llat != null && llon != null && "1".equals(status)){
			getDepartmentsList();
			return SUCCESS;
		}
		AddressInfo addressInfo= new AddressInfo();
//		if(!StringUtil.isEmpty(pro_city_cty)){
//			pro_city_cty = new String(pro_city_cty.getBytes("ISO8859-1"), "UTF-8");
//		}
		if(pro_city_cty != null){
			String[] ps = pro_city_cty.split(" ");
			addressInfo.setProvince(ps[0]);
			addressInfo.setCity(ps[1]);
			addressInfo.setDistrict(ps[2]);
		}
		departmentListActions = deptService.getDeptsByAddressInfo(addressInfo);
		return SUCCESS;
	}
	
	public String toDpartQueryPage() throws Exception {
		return SUCCESS;
	}

	public String toDepartMentPage() throws Exception {
		return SUCCESS;
	}
	
	public String getDepartments() throws Exception {
		getDepartmentsList();
		return SUCCESS;
	}

	private void getDepartmentsList() {
		LOG.info("getDepartmentsList");
		String[] ps = {};
		if(pro_city_cty != null){
			ps = pro_city_cty.split(" ");
		}
		String jsonStr = departmentService.queryDepartmentByTude(ps[0],ps[1],ps[2],lon, lat, "lim",String.valueOf(30));
		departmentListActions = JsonUtils.toList(jsonStr, DepartmentListVO.class);
		for(DepartmentListVO departmentListVO : departmentListActions){
			String distance = departmentListVO.getDirectDistance();
			String subDistance = distance;
			if(distance.length()>=5){
				subDistance  = distance.substring(0, distance.indexOf('.')+3);
			}
			departmentListVO.setDirectDistance(subDistance);
		}
	}
	
	public List<DepartmentListVO> getDepartmentListActions() {
		return departmentListActions;
	}

	public void setDepartmentListActions(
			List<DepartmentListVO> departmentListActions) {
		this.departmentListActions = departmentListActions;
	}

	public void setDepartmentService(IDepartmentService departmentService) {
		this.departmentService = departmentService;
	}

	public String getLon() {
		return lon;
	}

	public void setLon(String lon) {
		this.lon = lon;
	}

	public String getLat() {
		return lat;
	}

	public void setLat(String lat) {
		this.lat = lat;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getCond() {
		return cond;
	}

	public void setCond(String cond) {
		this.cond = cond;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

//	public AddressInfo getAddressInfo() {
//		return addressInfo;
//	}
//
//	public void setAddressInfo(AddressInfo addressInfo) {
//		this.addressInfo = addressInfo;
//	}

	public void setDeptService(IDeptService deptService) {
		this.deptService = deptService;
	}

	public String getPro_city_cty() {
		return pro_city_cty;
	}

	public void setPro_city_cty(String pro_city_cty) {
		this.pro_city_cty = pro_city_cty;
	}

	public String getLlon() {
		return llon;
	}

	public void setLlon(String llon) {
		this.llon = llon;
	}

	public String getLlat() {
		return llat;
	}

	public void setLlat(String llat) {
		this.llat = llat;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
}
