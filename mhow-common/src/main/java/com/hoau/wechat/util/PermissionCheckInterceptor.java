package com.hoau.wechat.util;

import java.lang.reflect.Method;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.springframework.util.ReflectionUtils;

import com.hoau.wechat.constants.SessionConstants;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

/**
 * 检查是否登陆
 * @author 徐俊
 * @date 2015年7月31日
 */
public class PermissionCheckInterceptor extends AbstractInterceptor{

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		Object target = invocation.getAction();
		String methodName = invocation.getProxy().getMethod();
		Method method = ReflectionUtils.findMethod(target.getClass(), methodName);
		if (method.isAnnotationPresent(PermissionCheck.class)) {
			PermissionCheck check = method.getAnnotation(PermissionCheck.class);
			boolean isExport = check.isExport();
			//判断是否登陆
			ActionContext ctx = ActionContext.getContext();
			Object o = ctx.getSession().get(SessionConstants.SESSION_USER_INFO.USER_INFO);
			if(o == null){
				//登陆成功之后要跳转的界面
				HttpServletRequest request = ServletActionContext.getRequest();
				String actionName;
				if(isExport){
					actionName = "index";
				}else{
					String uri = request.getRequestURI();
					int p = uri.lastIndexOf("/");
					actionName = uri.substring(p+1);
				}
				//request.setAttribute("dest", "?dest="+actionName);
				request.setAttribute("dest", actionName);
				//返回登陆页面
				return "login";//全局resutl
			}else{
				return invocation.invoke();
			}
		}
		//没有权限标签
		return invocation.invoke();
	}
	
}
