package com.hoau.mhow.invokews.server.ws.omsorder;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 2.7.11
 * 2015-12-18T11:50:06.728+08:00
 * Generated source version: 2.7.11
 * 
 */
@WebService(targetNamespace = "http://services.customer.interfaces.sinotrans.com", name = "CustomerServicePortType")
@XmlSeeAlso({ObjectFactory.class})
public interface CustomerServicePortType {

    @WebResult(name = "out", targetNamespace = "http://services.customer.interfaces.sinotrans.com")
    @RequestWrapper(localName = "modifyOrder", targetNamespace = "http://services.customer.interfaces.sinotrans.com", className = "com.hoau.mhow.invokews.server.ws.omsorder.ModifyOrder")
    @WebMethod
    @ResponseWrapper(localName = "modifyOrderResponse", targetNamespace = "http://services.customer.interfaces.sinotrans.com", className = "com.hoau.mhow.invokews.server.ws.omsorder.ModifyOrderResponse")
    public com.hoau.mhow.invokews.server.ws.omsorder.CustOrderResModel modifyOrder(
        @WebParam(name = "in0", targetNamespace = "http://services.customer.interfaces.sinotrans.com")
        com.hoau.mhow.invokews.server.ws.omsorder.CustOrderReqModel in0
    );

    @WebResult(name = "out", targetNamespace = "http://services.customer.interfaces.sinotrans.com")
    @RequestWrapper(localName = "cancelOrder", targetNamespace = "http://services.customer.interfaces.sinotrans.com", className = "com.hoau.mhow.invokews.server.ws.omsorder.CancelOrder")
    @WebMethod
    @ResponseWrapper(localName = "cancelOrderResponse", targetNamespace = "http://services.customer.interfaces.sinotrans.com", className = "com.hoau.mhow.invokews.server.ws.omsorder.CancelOrderResponse")
    public com.hoau.mhow.invokews.server.ws.omsorder.CancelOrderResModel cancelOrder(
        @WebParam(name = "in0", targetNamespace = "http://services.customer.interfaces.sinotrans.com")
        com.hoau.mhow.invokews.server.ws.omsorder.CancelOrderReqModel in0
    );

    @WebResult(name = "out", targetNamespace = "http://services.customer.interfaces.sinotrans.com")
    @RequestWrapper(localName = "cutomerOrder", targetNamespace = "http://services.customer.interfaces.sinotrans.com", className = "com.hoau.mhow.invokews.server.ws.omsorder.CutomerOrder")
    @WebMethod
    @ResponseWrapper(localName = "cutomerOrderResponse", targetNamespace = "http://services.customer.interfaces.sinotrans.com", className = "com.hoau.mhow.invokews.server.ws.omsorder.CutomerOrderResponse")
    public com.hoau.mhow.invokews.server.ws.omsorder.CustOrderResModel cutomerOrder(
        @WebParam(name = "in0", targetNamespace = "http://services.customer.interfaces.sinotrans.com")
        com.hoau.mhow.invokews.server.ws.omsorder.CustOrderReqModel in0
    );

    @WebResult(name = "out", targetNamespace = "http://services.customer.interfaces.sinotrans.com")
    @RequestWrapper(localName = "saveNetOrder", targetNamespace = "http://services.customer.interfaces.sinotrans.com", className = "com.hoau.mhow.invokews.server.ws.omsorder.SaveNetOrder")
    @WebMethod
    @ResponseWrapper(localName = "saveNetOrderResponse", targetNamespace = "http://services.customer.interfaces.sinotrans.com", className = "com.hoau.mhow.invokews.server.ws.omsorder.SaveNetOrderResponse")
    public com.hoau.mhow.invokews.server.ws.omsorder.EiNetOrderReqModel saveNetOrder(
        @WebParam(name = "in0", targetNamespace = "http://services.customer.interfaces.sinotrans.com")
        com.hoau.mhow.invokews.server.ws.omsorder.EiNetOrderReqModel in0
    );

    @WebResult(name = "out", targetNamespace = "http://services.customer.interfaces.sinotrans.com")
    @RequestWrapper(localName = "updateNetOrder", targetNamespace = "http://services.customer.interfaces.sinotrans.com", className = "com.hoau.mhow.invokews.server.ws.omsorder.UpdateNetOrder")
    @WebMethod
    @ResponseWrapper(localName = "updateNetOrderResponse", targetNamespace = "http://services.customer.interfaces.sinotrans.com", className = "com.hoau.mhow.invokews.server.ws.omsorder.UpdateNetOrderResponse")
    public com.hoau.mhow.invokews.server.ws.omsorder.EiNetOrderReq updateNetOrder(
        @WebParam(name = "in0", targetNamespace = "http://services.customer.interfaces.sinotrans.com")
        com.hoau.mhow.invokews.server.ws.omsorder.EiNetOrderReqModel in0
    );

    @WebResult(name = "out", targetNamespace = "http://services.customer.interfaces.sinotrans.com")
    @RequestWrapper(localName = "trackOrder", targetNamespace = "http://services.customer.interfaces.sinotrans.com", className = "com.hoau.mhow.invokews.server.ws.omsorder.TrackOrder")
    @WebMethod
    @ResponseWrapper(localName = "trackOrderResponse", targetNamespace = "http://services.customer.interfaces.sinotrans.com", className = "com.hoau.mhow.invokews.server.ws.omsorder.TrackOrderResponse")
    public com.hoau.mhow.invokews.server.ws.omsorder.TrackOrderResModel trackOrder(
        @WebParam(name = "in0", targetNamespace = "http://services.customer.interfaces.sinotrans.com")
        com.hoau.mhow.invokews.server.ws.omsorder.TrackOrderReqModel in0
    );

    @WebResult(name = "out", targetNamespace = "http://services.customer.interfaces.sinotrans.com")
    @RequestWrapper(localName = "queryOrder", targetNamespace = "http://services.customer.interfaces.sinotrans.com", className = "com.hoau.mhow.invokews.server.ws.omsorder.QueryOrder")
    @WebMethod
    @ResponseWrapper(localName = "queryOrderResponse", targetNamespace = "http://services.customer.interfaces.sinotrans.com", className = "com.hoau.mhow.invokews.server.ws.omsorder.QueryOrderResponse")
    public com.hoau.mhow.invokews.server.ws.omsorder.QueryOrderResModel queryOrder(
        @WebParam(name = "in0", targetNamespace = "http://services.customer.interfaces.sinotrans.com")
        com.hoau.mhow.invokews.server.ws.omsorder.QueryOrderReqModel in0
    );
}
