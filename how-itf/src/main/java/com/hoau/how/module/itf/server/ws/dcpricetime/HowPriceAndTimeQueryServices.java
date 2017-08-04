package com.hoau.how.module.itf.server.ws.dcpricetime;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 3.0.2
 * 2015-09-10T14:21:47.993+08:00
 * Generated source version: 3.0.2
 * 
 */
@WebService(targetNamespace = "http://www.hoau.net/services/HowPriceAndTimeQueryServices", name = "HowPriceAndTimeQueryServices")
@XmlSeeAlso({ObjectFactory.class})
public interface HowPriceAndTimeQueryServices {
    @WebResult(name = "return", targetNamespace = "")
    @Action(input = "http://www.hoau.net/services/HowPriceAndTimeQueryServices/HowPriceAndTimeQueryServices/queryPriceAndTimeRequest", output = "http://www.hoau.net/services/HowPriceAndTimeQueryServices/HowPriceAndTimeQueryServices/queryPriceAndTimeResponse")
    @RequestWrapper(localName = "queryPriceAndTime", targetNamespace = "http://www.hoau.net/services/HowPriceAndTimeQueryServices", className = "com.hoau.how.module.itf.server.ws.dcpricetime.QueryPriceAndTime")
    @WebMethod
    @ResponseWrapper(localName = "queryPriceAndTimeResponse", targetNamespace = "http://www.hoau.net/services/HowPriceAndTimeQueryServices", className = "com.hoau.how.module.itf.server.ws.dcpricetime.QueryPriceAndTimeResponse")
    public java.util.List<com.hoau.how.module.itf.server.ws.dcpricetime.PriceQueryResult> queryPriceAndTime(
        @WebParam(name = "arg0", targetNamespace = "")
        com.hoau.how.module.itf.server.ws.dcpricetime.PriceQueryVo arg0
    );
}