package com.hoau.how.module.obh.shared.domain;

import java.io.Serializable;

/**
 * @author：张贞献
 * @create：2015年8月20日 上午10:08:24
 * @description：
 */
public class ImageEntity implements Serializable{
	
	/**
	 * 图片编号
	 */
	private String imgNo;
	/**
	 * 图片路径
	 */
	private String imgdir;
	/**
	 * 图片访问路径
	 */
	private String url;
	
	private static final long serialVersionUID = 1L;
	public String getImgNo() {
		return imgNo;
	}
	public void setImgNo(String imgNo) {
		this.imgNo = imgNo;
	}
	public String getImgdir() {
		return imgdir;
	}
	public void setImgdir(String imgdir) {
		this.imgdir = imgdir;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}

	
	

}
