package com.hoau.how.module.bse.shared.vo;

import java.util.List;

public class RequestParam {
	/**
	 * （也可以是地址对应编号，目的是方便地址返回值处理）
	 */
	private String o_pcode;
	/**
	 * 版图名称 （根据业务要求确定版图名称，版图名称可以有多个）
	 */
	private List<DictName> ss_dictname;
	/**
	 * 任务所属机构代码（固定值为“100282”）
	 */
	private String t_orgcode;
	/**
	 * 应用编号（天地华宇应用ID） 
	 */
	private String o_string1;
	/**
	 * 组织编码（天地华宇的组织编码） 
	 */
	private String o_string2;
	/**
	 * 任务类型 (1,3) 
	 */
	private int t_tasktype;
	/**
	 * 收货人地址(t_tasktype为3时必填)
	 */
	private String o_consigneeaddr;
	/**
	 * 发货人地址(t_tasktype为1时必填)
	 */
	private String o_shipperaddr;
	
	public List<DictName> getSs_dictname() {
		return ss_dictname;
	}
	public void setSs_dictname(List<DictName> ss_dictname) {
		this.ss_dictname = ss_dictname;
	}
	public String getO_pcode() {
		return o_pcode;
	}
	public void setO_pcode(String o_pcode) {
		this.o_pcode = o_pcode;
	}
	public String getT_orgcode() {
		return t_orgcode;
	}
	public void setT_orgcode(String t_orgcode) {
		this.t_orgcode = t_orgcode;
	}
	public String getO_string1() {
		return o_string1;
	}
	public void setO_string1(String o_string1) {
		this.o_string1 = o_string1;
	}
	public String getO_string2() {
		return o_string2;
	}
	public void setO_string2(String o_string2) {
		this.o_string2 = o_string2;
	}
	public int getT_tasktype() {
		return t_tasktype;
	}
	public void setT_tasktype(int t_tasktype) {
		this.t_tasktype = t_tasktype;
	}
	public String getO_consigneeaddr() {
		return o_consigneeaddr;
	}
	public void setO_consigneeaddr(String o_consigneeaddr) {
		this.o_consigneeaddr = o_consigneeaddr;
	}
	public String getO_shipperaddr() {
		return o_shipperaddr;
	}
	public void setO_shipperaddr(String o_shipperaddr) {
		this.o_shipperaddr = o_shipperaddr;
	}
}
