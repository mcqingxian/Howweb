package com.hoau.mhow.module.bse.api.shared.vo;

public class District {
	private String id;
	private String districtCode;
	private String districtName;
	private String districtType;
	private String parentDistrictCode;
	private String pinyin;
	private boolean hotCity;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDistrictCode() {
		return districtCode;
	}
	public void setDistrictCode(String districtCode) {
		this.districtCode = districtCode;
	}
	public String getDistrictName() {
		return districtName;
	}
	public void setDistrictName(String districtName) {
		this.districtName = districtName;
	}
	public String getDistrictType() {
		return districtType;
	}
	public void setDistrictType(String districtType) {
		this.districtType = districtType;
	}
	public String getParentDistrictCode() {
		return parentDistrictCode;
	}
	public void setParentDistrictCode(String parentDistrictCode) {
		this.parentDistrictCode = parentDistrictCode;
	}
	public String getPinyin() {
		return pinyin;
	}
	public void setPinyin(String pinyin) {
		this.pinyin = pinyin;
	}
	public boolean isHotCity() {
		return hotCity;
	}
	public void setHotCity(boolean hotCity) {
		this.hotCity = hotCity;
	}
	
}
