package com.hoau.how.module.bse.server.xss;

import org.apache.struts2.dispatcher.StrutsRequestWrapper;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * @auther MC
 * @create 2017/7/6
 */
public class MStrutsRequestWrapper extends StrutsRequestWrapper
{

    public MStrutsRequestWrapper(HttpServletRequest req) {
        super(req);
    }

    public MStrutsRequestWrapper(HttpServletRequest req, boolean bool) {
        super(req, bool);
    }

    @Override
    public String getParameter(String name) {
        name = XssShieldUtil.stripXss(name);
        // 返回值之前 先进行过滤
        return XssShieldUtil.stripXss(super.getParameter(name));
    }

    @Override
    public String[] getParameterValues(String name) {
        name = XssShieldUtil.stripXss(name);
        // 返回值之前 先进行过滤
        String[] values = super.getParameterValues(name);
        if(values != null){
            for (int i = 0; i < values.length; i++) {
                values[i] = XssShieldUtil.stripXss(values[i]);
            }
        }
        return values;
    }

    @Override
    public Enumeration<String> getParameterNames() {
        return super.getParameterNames();
    }

    @Override
    public Map getParameterMap(){
        Map newParams = new HashMap();
        Map paramMap = super.getParameterMap();
        Set keySet = paramMap.keySet();
        for (Iterator iterator = keySet.iterator(); iterator.hasNext();) {
            String key = (String) iterator.next();
            String[] str = (String[]) paramMap.get(key);

            if(str != null){
                for(int i = 0; i < str.length; i++){
                    str[i] = XssShieldUtil.stripXss(str[i]);
                }
            }
                newParams.put(key, str);
        }
        return newParams ;
    }

}
