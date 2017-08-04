/**
 * 
 */
package com.hoau.wechat.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

/**
 * GET请求编码
 * @author 123
 *
 */
public class EncodingFilter implements Filter{

	private String encoding;  
	 
    public void init(FilterConfig fConfig) throws ServletException  
    {  
        encoding = fConfig.getInitParameter("encoding");  
    }  
 
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException  
    {  
        HttpServletRequest httprequest = (HttpServletRequest) request;  
        if ("GET".equals(httprequest.getMethod()))  
        {  
            // 将httpRequest进行包装  
            EncodingHttpServletRequest wrapper = new EncodingHttpServletRequest(httprequest, encoding);   
            chain.doFilter(wrapper, response);  
        }  
        else 
        {  
            request.setCharacterEncoding(encoding);  
            response.setContentType("text/html;charset=" + encoding);  
            chain.doFilter(request, response);  
        }  
    }  
 
    public void destroy()  
    {  
 
    }  

}
