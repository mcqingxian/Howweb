package com.hoau.wechat.entity;

/**
 * @author：275636
 * @description：
 */
public class DistrictEntity {
	private String districtCode;
	private String districtName;
	private String districtType;
	private String pinyin;
	private String hotCity;
	private Integer total;
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
	public Integer getTotal() {
		return total;
	}
	public void setTotal(Integer total) {
		this.total = total;
	}
	public String getDistrictType() {
		return districtType;
	}
	public void setDistrictType(String districtType) {
		this.districtType = districtType;
	}
	public String getHotCity() {
		return hotCity;
	}
	public void setHotCity(String hotCity) {
		this.hotCity = hotCity;
	}
	public String getPinyin() {
		return pinyin;
	}
	public void setPinyin(String pinyin) {
		this.pinyin = pinyin;
	}
}