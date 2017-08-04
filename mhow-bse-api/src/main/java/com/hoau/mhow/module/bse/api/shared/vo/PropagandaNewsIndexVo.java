package com.hoau.mhow.module.bse.api.shared.vo;

import java.io.Serializable;

/**
 * 首页新闻轮播图实体
 * @author：张爱萍
 * @create：2015年6月12日 下午3:47:01
 * @description：
 */
public class PropagandaNewsIndexVo implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8863909350224357552L;
	private int id;
	/**
	 * 标题
	 */
	private String shortTitile;
	/**
	 * 轮播图
	 */
	private String sltSrc;
	
	/**
	 * 类目ID
	 */
	private String categoryId;
	
	/**
	 * 类目名
	 */
	private String categoryName;
	
	private Integer rowNum;
	
	public Integer getRowNum() {
		return rowNum;
	}

	public void setRowNum(Integer rowNum) {
		this.rowNum = rowNum;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSltSrc() {
		return sltSrc;
	}

	public String getShortTitile() {
		return shortTitile;
	}

	public void setShortTitile(String shortTitile) {
		this.shortTitile = shortTitile;
	}

	public void setSltSrc(String sltSrc) {
		this.sltSrc = sltSrc;
	}

	public String getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	
}
