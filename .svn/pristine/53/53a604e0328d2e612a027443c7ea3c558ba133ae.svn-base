package com.hoau.wechat.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.StrutsStatics;

import com.hoau.wechat.exception.OpenIdNotNullException;
import com.hoau.wechat.util.StringUtil;
import com.hoau.wechat.utils.net.WeixinUtil;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class ExceptionInterceptor extends AbstractInterceptor {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8343838396341355373L;
	public static final String ERROR = "ERROR";
	private static Log log = LogFactory.getLog(ExceptionInterceptor.class);

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		try {
			log.info("进入ExceptionInterceptor拦截方法");
			/*HttpServletRequest request = (HttpServletRequest) invocation
					.getInvocationContext().get(StrutsStatics.HTTP_REQUEST);
			// 绑定openId至session
			String code = request.getParameter("code");
			log.info("进入ExceptionInterceptor->code:"+code);
			if (!StringUtil.isEmpty(code)) {
				WeixinUtil.setOpenIdToSession(code);
			}*/
			return invocation.invoke();
		} catch (OpenIdNotNullException e) {
			log.info("ExceptionInterceptor->OpenIdNotNullException:"+e.getMessage(), e);
			HttpServletRequest request = (HttpServletRequest) invocation
					.getInvocationContext().get(StrutsStatics.HTTP_REQUEST);
			String clientContentType = getClientContentType();
			if (((clientContentType != null) && ("XMLHttpRequest"
					.equalsIgnoreCase(clientContentType)))) {
				// 增加异常判断
				HttpServletResponse response = ServletActionContext
						.getResponse();
				String contentType = "text/plain;charset=UTF-8";
				response.setContentType(contentType);
				//response.setStatus(500);
				response.getWriter().write("session超时失效");
				response.getWriter().flush();
				response.getWriter().close();
				return "error";
			} else{
				StringBuffer sb = new StringBuffer();
				printStackTraceAsCause(sb, e);
				request.setAttribute("errorMsg", e.getMessage());
				request.setAttribute("stackTrace", sb.toString());
				return "sessioninvalid";
			}
		}catch (Throwable e) {
			log.info("ExceptionInterceptor->Throwable:"+e.getMessage(), e);
			String clientContentType = getClientContentType();
			if (((clientContentType != null) && ("XMLHttpRequest"
					.equalsIgnoreCase(clientContentType)))) {
				// 增加异常判断
				HttpServletResponse response = ServletActionContext
						.getResponse();
				String contentType = "text/plain;charset=UTF-8";
				response.setContentType(contentType);
				response.setStatus(500);
				response.getWriter().write("访问服务器出现异常");
				response.getWriter().flush();
				response.getWriter().close();
				return null;
			} else {
				HttpServletRequest request = (HttpServletRequest) invocation
						.getInvocationContext().get(StrutsStatics.HTTP_REQUEST);
				StringBuffer sb = new StringBuffer();
				printStackTraceAsCause(sb, e);
				request.setAttribute("errorMsg", e.getMessage());
				request.setAttribute("stackTrace", sb.toString());
				return "error";
			}

		}

	}

	private void printStackTraceAsCause(StringBuffer s, Throwable iex) {
		s.append(iex.toString());
		StackTraceElement[] trace = iex.getStackTrace();
		for (int i = 0; i < trace.length; i++) {
			s.append("\tat ").append(trace[i]);
		}
		Throwable ourCause = iex.getCause();
		if (ourCause != null) {
			printStackTraceAsCause(s, ourCause);
		}
	}

	private String getClientContentType() {
		String clientContentType = ServletActionContext.getRequest().getHeader(
				"x-requested-with");
		if (clientContentType != null) {
			int iSemicolonIdx = clientContentType.indexOf(';');
			if (iSemicolonIdx != -1) {
				clientContentType = clientContentType.substring(0,
						iSemicolonIdx);
			}
		}
		return clientContentType;
	}

}
