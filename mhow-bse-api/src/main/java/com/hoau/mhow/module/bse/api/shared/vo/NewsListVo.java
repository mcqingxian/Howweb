package com.hoau.mhow.module.bse.api.shared.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * 新闻列表实体
 * @author：张爱萍
 * @create：2015年6月12日 上午9:05:37
 * @description：
 */
public class NewsListVo implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1377304315064950085L;
	private int id;
	/**
	 * 首页显示标题
	 */
	private String title;
	/**
	 * 类目ID
	 */
	private String categoryId;
	/**
	 * 类目名
	 */
	private String categoryName;
	
	/**
	 * 创建时间
	 */
	private Date createAt;
	
	/**
	 * 排序
	 */
	private Integer rowNum;
	
	/**
	 * title属性
	 */
	private String tipTitle;

	

	public String getTipTitle() {
		return tipTitle;
	}

	public void setTipTitle(String tipTitle) {
		this.tipTitle = tipTitle;
	}

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

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}

	public Date getCreateAt() {
		return createAt;
	}

	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	
}
