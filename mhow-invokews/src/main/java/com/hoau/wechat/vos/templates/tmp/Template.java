package com.hoau.wechat.vos.templates.tmp;

import com.hoau.wechat.vos.templates.data.IData;

/**
 * 
 * @ClassName: Template 
 * @Description: TODO 模板消息模板
 * @author mt_king mail:hyssmt@vip.qq.com
 * @date 2014年11月14日 下午4:03:09 
 *
 */
public class Template {
	String touser;
	String template_id;
	String url;
	String topcolor;
	IData data;
	
	public IData getData() {
		return data;
	}
	public void setData(IData data) {
		this.data = data;
	}
	public String getTouser() {
		return touser;
	}
	public void setTouser(String touser) {
		this.touser = touser;
	}
	public String getTemplate_id() {
		return template_id;
	}
	public void setTemplate_id(String template_id) {
		this.template_id = template_id;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getTopcolor() {
		return topcolor;
	}
	public void setTopcolor(String topcolor) {
		this.topcolor = topcolor;
	}
}
