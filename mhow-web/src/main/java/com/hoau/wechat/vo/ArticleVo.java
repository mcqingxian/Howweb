package com.hoau.wechat.vo;
import org.codehaus.jackson.annotate.JsonProperty;


/**
 * @ClassName:   Article 
 * @Description: 新闻消息内容
 * @author:      xujun cometzb@126.com
 * @date:        2014年4月2日 下午5:51:28
 */
public class ArticleVo {
	// 图文消息名称  
	@JsonProperty("Title")
    private String title;  
    // 图文消息描述  
	@JsonProperty("Description")
    private String description;  
    // 图片链接，支持JPG、PNG格式，较好的效果为大图640*320，小图80*80，限制图片链接的域名需要与开发者填写的基本资料中的Url一致
	@JsonProperty("PicUrl")
    private String picUrl;  
    // 点击图文消息跳转链接  
	@JsonProperty("Url")
    private String url;
	//有效日期
	@JsonProperty("EffectiveDate")
	private String effectiveDate;
	//过期时间
	@JsonProperty("ExpiredDate")
	private String expiredDate;
    
    
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getPicUrl() {
		return picUrl;
	}
	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getEffectiveDate() {
		return effectiveDate;
	}
	public void setEffectiveDate(String effectiveDate) {
		this.effectiveDate = effectiveDate;
	}
	public String getExpiredDate() {
		return expiredDate;
	}
	public void setExpiredDate(String expiredDate) {
		this.expiredDate = expiredDate;
	}
}
