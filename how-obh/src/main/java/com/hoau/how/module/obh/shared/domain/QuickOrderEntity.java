package com.hoau.how.module.obh.shared.domain;

/**
 * @author：龙海仁
 * @create：2015年8月16日 下午3:06:38
 * @description：
 */
public class QuickOrderEntity {
	private Long einoEbccId;
	private Integer pageNo;
	private Integer pageSize;
	private Integer offset;
	private String consignee;
	private String consigner;
	
	public Integer getOffset() {
		return offset;
	}
	public void setOffset(Integer offset) {
		this.offset = offset;
	}
	public Long getEinoEbccId() {
		return einoEbccId;
	}
	public void setEinoEbccId(Long einoEbccId) {
		this.einoEbccId = einoEbccId;
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
	public String getConsignee() {
		return consignee;
	}
	public void setConsignee(String consignee) {
		this.consignee = consignee;
	}
	public String getConsigner() {
		return consigner;
	}
	public void setConsigner(String consigner) {
		this.consigner = consigner;
	}
	
}
