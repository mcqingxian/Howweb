package com.hoau.wechat.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.hoau.wechat.utils.SignUtil;


/**
 * @ClassName:   WeChatServlet 
 * @Description: 微信消息主入口
 * @author:      xujun cometzb@126.com
 * @date:        2014年4月2日 下午6:02:44
 */
public class WeChatServlet extends HttpServlet {
	public static final Log log = LogFactory.getLog(WeChatServlet.class);
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 微信加密签名  
        String signature = request.getParameter("signature");  
        // 时间戳  
        String timestamp = request.getParameter("timestamp");  
        // 随机数  
        String nonce = request.getParameter("nonce");  
        // 随机字符串  
        String echostr = request.getParameter("echostr");  
        log.info(signature);
        log.info(timestamp);
        log.info(nonce);
        log.info(echostr);
        PrintWriter out = response.getWriter();  
        // 通过检验signature对请求进行校验，若校验成功则原样返回echostr，表示接入成功，否则接入失败  
        if (SignUtil.checkSignature(signature, timestamp, nonce)) {  
            out.print(echostr);  
        }  
        out.close();  
        out = null;  
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		ApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(getServletContext());
		String sessionID = request.getSession().getId();
		log.debug("sessionid:" + sessionID);
		String respMessage = CoreService.processRequest(request,context);
		PrintWriter out = response.getWriter();
		out.print(respMessage);  
        out.close();  
	}

}
