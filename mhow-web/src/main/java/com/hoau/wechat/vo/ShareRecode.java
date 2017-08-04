package com.hoau.wechat.vo;

import java.util.Date;

/** 
* @ClassName: ShareRecode 
* @Description: 分享记录
* @author xujun jun.xu@hoau.net
* @date 2014年7月30日 下午7:25:14 
*  
*/
public class ShareRecode {
	private String id;
	// 微信id
	private String openid;
	// 分享时间
	private Date shareTime;
	// 分享的文章
	private String articleid;
	//文章来自
	private String state;
		
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getArticleid() {
		return articleid;
	}
	public void setArticleid(String articleid) {
		this.articleid = articleid;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getOpenid() {
		return openid;
	}
	public void setOpenid(String openid) {
		this.openid = openid;
	}
	public Date getShareTime() {
		return shareTime;
	}
	public void setShareTime(Date shareTime) {
		this.shareTime = shareTime;
	}
	
	
}
