package com.hoau.how.module.bse.shared.vo;

import java.util.List;

public class NewExcelDataVo {
	/**
	 * @Fields serial: 序号
	 */
	private String serial;
	/**
	 * @Fields startCompany: 起运公司
	 */
	private String startCompany;
	/**
	 * @Fields destinationAddress: 目的地址
	 */
	private String destinationAddress;
	/**
	 * @Fields dispatchCompany: 派送公司代码
	 */
	private String dispatchCompany;
	/**
	 * @Fields dispatchCompany: 派送公司名称
	 */
	private String dispatchCompanyName;
	/**
	 * @Fields dispatchCompany: 派送公司电话
	 */
	private String dispatchPhone;
	/**
	 * @Fields dispatchCompany: 派送公司地址
	 */
	private String dispatchAddress;
//	/**
//	 * @Fields dispatchMsg: 派送地址匹配信息
//	 */
//	private String dispatchMsg;
	/**
	 * @Fields dispatchDistance: 派送距离
	 */
	private String dispatchDistance;
	/**
	 * @Fields takeTheirCompany: 自提公司
	 */
	private List<String> takeTheirCompany;
	private List<String> selfTakeDistance;

	private String stCompanyCode;
	private String stCompanyName;
	private String stCompanyPhone;
	private String stCompanyAddress;
	private String stDistance;
	
	/**
	 * @Fields takeTheirMsg: 自提地址匹配信息
	 */
	private String takeTheirMsg;
	/**
	 * @Fields ErrMsg: 备注
	 */
	private String ErrMsg;
	/**
	 * @author 唐征征
	 * @date 2017/7/19 下午11:22
	 * @description UI修改,两列合并,新创建字段
	 */
	// 服务方式 自提/派送
//	private String serviceType;//自提公司
//	private String dispatchServiceType;//派送公司
	private int rownumber;
	private String companyCode;
	private String companyName;
	private String companyPhone;
	private String companyAddress;
	private String distance;
	private String dispatchMsg;
	private String serviceType;
	private String map;







	
	public static final String [] title =  {"目的地址","派送公司代码","派送公司名称","派送公司电话","派送公司地址","派送公司距离","是否在服务范围内",
												"自提公司代码","自提公司名称","自提公司电话","自提公司地址","自提公司距离",
												"自提公司代码","自提公司名称","自提公司电话","自提公司地址","自提公司距离",
												"自提公司代码","自提公司名称","自提公司电话","自提公司地址","自提公司距离"};
	
	public List<String> getTakeTheirCompany() {
		return takeTheirCompany;
	}
	public void setTakeTheirCompany(List<String> takeTheirCompany) {
		this.takeTheirCompany = takeTheirCompany;
	}
	public String getErrMsg() {
		return ErrMsg;
	}
	public void setErrMsg(String errMsg) {
		ErrMsg = errMsg;
	}
	public String getSerial() {
		return serial;
	}
	public void setSerial(String serial) {
		this.serial = serial;
	}
	public String getStartCompany() {
		return startCompany;
	}
	public void setStartCompany(String startCompany) {
		this.startCompany = startCompany;
	}
	public String getDestinationAddress() {
		return destinationAddress;
	}
	public void setDestinationAddress(String destinationAddress) {
		this.destinationAddress = destinationAddress;
	}
	public String getDispatchCompany() {
		return dispatchCompany;
	}
	public void setDispatchCompany(String dispatchCompany) {
		this.dispatchCompany = dispatchCompany;
	}
	public String getDispatchMsg() {
		return dispatchMsg;
	}
	public void setDispatchMsg(String dispatchMsg) {
		this.dispatchMsg = dispatchMsg;
	}
	public String getTakeTheirMsg() {
		return takeTheirMsg;
	}
	public void setTakeTheirMsg(String takeTheirMsg) {
		this.takeTheirMsg = takeTheirMsg;
	}
	public List<String> getSelfTakeDistance() {
		return selfTakeDistance;
	}
	public void setSelfTakeDistance(List<String> selfTakeDistance) {
		this.selfTakeDistance = selfTakeDistance;
	}
	public String getDispatchDistance() {
		return dispatchDistance;
	}
	public void setDispatchDistance(String dispatchDistance) {
		this.dispatchDistance = dispatchDistance;
	}
	public String getDispatchPhone() {
		return dispatchPhone;
	}
	public void setDispatchPhone(String dispatchPhone) {
		this.dispatchPhone = dispatchPhone;
	}
	public String getDispatchAddress() {
		return dispatchAddress;
	}
	public void setDispatchAddress(String dispatchAddress) {
		this.dispatchAddress = dispatchAddress;
	}
	public String getDispatchCompanyName() {
		return dispatchCompanyName;
	}
	public void setDispatchCompanyName(String dispatchCompanyName) {
		this.dispatchCompanyName = dispatchCompanyName;
	}
	public String getStDistance() {
		return stDistance;
	}
	public void setStDistance(String stDistance) {
		this.stDistance = stDistance;
	}
	public String getStCompanyCode() {
		return stCompanyCode;
	}
	public void setStCompanyCode(String stCompanyCode) {
		this.stCompanyCode = stCompanyCode;
	}
	public String getStCompanyName() {
		return stCompanyName;
	}
	public void setStCompanyName(String stCompanyName) {
		this.stCompanyName = stCompanyName;
	}
	public String getStCompanyPhone() {
		return stCompanyPhone;
	}
	public void setStCompanyPhone(String stCompanyPhone) {
		this.stCompanyPhone = stCompanyPhone;
	}
	public String getStCompanyAddress() {
		return stCompanyAddress;
	}
	public void setStCompanyAddress(String stCompanyAddress) {
		this.stCompanyAddress = stCompanyAddress;
	}
	public String getServiceType() {
		return serviceType;
	}

	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}

	public String getMap() {
		return map;
	}

	public void setMap(String map) {
		this.map = map;
	}

	public String getCompanyCode() {
		return companyCode;
	}

	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getCompanyPhone() {
		return companyPhone;
	}

	public void setCompanyPhone(String companyPhone) {
		this.companyPhone = companyPhone;
	}

	public String getCompanyAddress() {
		return companyAddress;
	}

	public void setCompanyAddress(String companyAddress) {
		this.companyAddress = companyAddress;
	}

	public String getDistance() {
		return distance;
	}

	public void setDistance(String distance) {
		this.distance = distance;
	}

	public int getRownumber() {
		return rownumber;
	}

	public void setRownumber(int rownumber) {
		this.rownumber = rownumber;
	}
}