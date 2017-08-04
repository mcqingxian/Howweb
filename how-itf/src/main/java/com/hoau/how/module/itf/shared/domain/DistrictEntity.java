package com.hoau.how.module.itf.shared.domain;

import com.hoau.hbdp.framework.entity.BaseEntity;

/**
 * @author：高佳
 * @create：2015年5月26日 下午3:40:09
 * @description：行政区域实体
 */
public class DistrictEntity extends BaseEntity{

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * 行政区域编码
	 */
	private String districtCode;
	
	/**
	 * 行政区域名称
	 */
	private String districtName;
	
	/**
	 * 行政区域类型
	 * COUNTRY(国家)
	 * PROVINCE(省份)
	 * CITY(城市)
	 * AREA(区县)
	 */
	private String districtType;
	
	/**
	 * 上级行政区域编码
	 */
	private String parentDistrictCode;
	
	
	/**
	 * 拼音
	 */
	private String pinyin;
	
	/**
	 * 版本号
	 */
	private long versionNo;
	
	/**
	 * 热门城市点击数
	 */
	private Long hotCityNum;

	public Long getHotCityNum() {
		return hotCityNum;
	}

	public void setHotCityNum(Long hotCityNum) {
		this.hotCityNum = hotCityNum;
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


	public long getVersionNo() {
		return versionNo;
	}


	public void setVersionNo(long versionNo) {
		this.versionNo = versionNo;
	}
	
	
}
