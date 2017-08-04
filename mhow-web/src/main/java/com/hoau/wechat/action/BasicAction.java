package com.hoau.wechat.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.opensymphony.xwork2.Action;

/**
 * 
 * @ClassName: BasicAction 
 * @Description: TODO 
 * @author mt_king mail:hyssmt@vip.qq.com
 * @date 2014年7月29日 下午2:33:23 
 *
 */
public class BasicAction implements Action,ServletRequestAware,
ServletResponseAware {
	public HttpServletRequest request;
	public HttpServletResponse response;
	
	@Override
	public void setServletResponse(HttpServletResponse res) {
		this.response = res;
	}

	@Override
	public void setServletRequest(HttpServletRequest req) {
		this.request = req;
	}

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
}
