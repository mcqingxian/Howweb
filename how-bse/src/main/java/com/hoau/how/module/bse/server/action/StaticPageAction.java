package com.hoau.how.module.bse.server.action;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.hoau.hbdp.framework.server.web.action.AbstractAction;

/**
 * @author：张爱萍
 * @create：2015年6月16日 下午2:55:39
 * @description：
 */
@Controller
@Scope("prototype")
public class StaticPageAction extends AbstractAction{
	/**
	 *
	 */
	private static final long serialVersionUID = -457670456458662306L;
	private String categoryName;
	/**
	 * 跳对应转到静态页面
	 * 
	 * @return
	 * @author 张爱萍
	 * @date 2015年6月16日
	 * @update
	 */
	public String toPage(){
		return returnSuccess();
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	
}
