package com.hoau.mhow.module.bse.api.shared.domain;

import java.io.Serializable;
import java.util.Date;

/**
 *  联系人实体
 * @author Dy
 * 2015年12月18日
 */
public class ContactsEntity implements Serializable {

	private static final long serialVersionUID = 3301606717737849460L;

	/**
	 *主键
	 */
	private Long ebsaId;

	/**
	 *联系地址
	 */
	private String ebsaAddress;

	/**
	 *联系人姓名
	 */
	private String ebsaContact;

	/**
	 *固定电话
	 */
	private String ebsaContactTel;

	/**
	 *是否设置默认
	 */
	private String ebsaIsDefault;

	/**
	 *修改时间
	 */
	private Date modifyTime;
	
	/**
	 *修改人
	 */
	private String modifier;

	/**
	 *创建时间
	 */
	private Date createTime;

	/**
	 *创建人
	 */
	private String creator;

	/**
	 *省 直辖市名称
	 */
	private String ebsaEbpvName;

	/**
	 *市名称
	 */
	private String ebsaEbplName;

	/**
	 *区县名称
	 */
	private String ebsaEbcoName;
	
	/**
	 *公司名称
	 */
	private String ebsaCompany;

	/**
	 *地区编码
	 */
	private String ebsaContactAreaCode;

	/**
	 *二级公司账号
	 */
	private String ebsaEscoSecondCode;

	/**
	 *二级公司名称
	 */
	private String ebsaEscoSecondName;

	/**
	 *客户id
	 */
	private Long ebsaEbcuId;

	/**
	 *联系人类型
	 */
	private String ebsaType;

	/**
	 *联系人手机
	 */
	private String ebsaMobile;

	/**
	 *备注
	 */
	private String ebsaRemark;

	/**
	 *部门所在路 ,街道
	 */
	private String ebsaDeptDistrict;

	public Long getEbsaId() {
		return ebsaId;
	}

	public void setEbsaId(Long ebsaId) {
		this.ebsaId = ebsaId;
	}

	public String getEbsaAddress() {
		return ebsaAddress;
	}

	public void setEbsaAddress(String ebsaAddress) {
		this.ebsaAddress = ebsaAddress;
	}

	public String getEbsaContact() {
		return ebsaContact;
	}

	public void setEbsaContact(String ebsaContact) {
		this.ebsaContact = ebsaContact;
	}

	public String getEbsaContactTel() {
		return ebsaContactTel;
	}

	public void setEbsaContactTel(String ebsaContactTel) {
		this.ebsaContactTel = ebsaContactTel;
	}

	public String getEbsaIsDefault() {
		return ebsaIsDefault;
	}

	public void setEbsaIsDefault(String ebsaIsDefault) {
		this.ebsaIsDefault = ebsaIsDefault;
	}

	public Date getModifyTime() {
		return modifyTime;
	}

	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}

	public String getModifier() {
		return modifier;
	}

	public void setModifier(String modifier) {
		this.modifier = modifier;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	public String getEbsaEbpvName() {
		return ebsaEbpvName;
	}

	public void setEbsaEbpvName(String ebsaEbpvName) {
		this.ebsaEbpvName = ebsaEbpvName;
	}

	public String getEbsaEbplName() {
		return ebsaEbplName;
	}

	public void setEbsaEbplName(String ebsaEbplName) {
		this.ebsaEbplName = ebsaEbplName;
	}

	public String getEbsaEbcoName() {
		return ebsaEbcoName;
	}

	public void setEbsaEbcoName(String ebsaEbcoName) {
		this.ebsaEbcoName = ebsaEbcoName;
	}

	public String getEbsaCompany() {
		return ebsaCompany;
	}

	public void setEbsaCompany(String ebsaCompany) {
		this.ebsaCompany = ebsaCompany;
	}

	public String getEbsaContactAreaCode() {
		return ebsaContactAreaCode;
	}

	public void setEbsaContactAreaCode(String ebsaContactAreaCode) {
		this.ebsaContactAreaCode = ebsaContactAreaCode;
	}

	public String getEbsaEscoSecondCode() {
		return ebsaEscoSecondCode;
	}

	public void setEbsaEscoSecondCode(String ebsaEscoSecondCode) {
		this.ebsaEscoSecondCode = ebsaEscoSecondCode;
	}

	public String getEbsaEscoSecondName() {
		return ebsaEscoSecondName;
	}

	public void setEbsaEscoSecondName(String ebsaEscoSecondName) {
		this.ebsaEscoSecondName = ebsaEscoSecondName;
	}

	public Long getEbsaEbcuId() {
		return ebsaEbcuId;
	}

	public void setEbsaEbcuId(Long ebsaEbcuId) {
		this.ebsaEbcuId = ebsaEbcuId;
	}

	public String getEbsaType() {
		return ebsaType;
	}

	public void setEbsaType(String ebsaType) {
		this.ebsaType = ebsaType;
	}

	public String getEbsaMobile() {
		return ebsaMobile;
	}

	public void setEbsaMobile(String ebsaMobile) {
		this.ebsaMobile = ebsaMobile;
	}

	public String getEbsaRemark() {
		return ebsaRemark;
	}

	public void setEbsaRemark(String ebsaRemark) {
		this.ebsaRemark = ebsaRemark;
	}

	public String getEbsaDeptDistrict() {
		return ebsaDeptDistrict;
	}

	public void setEbsaDeptDistrict(String ebsaDeptDistrict) {
		this.ebsaDeptDistrict = ebsaDeptDistrict;
	}
	
	
}