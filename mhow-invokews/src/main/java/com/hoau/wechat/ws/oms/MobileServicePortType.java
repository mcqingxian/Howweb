package com.hoau.wechat.ws.oms;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 2.7.11
 * 2015-10-27T16:12:51.477+08:00
 * Generated source version: 2.7.11
 * 
 */
@WebService(targetNamespace = "http://services.mobile.interfaces.sinotrans.com", name = "MobileServicePortType")
@XmlSeeAlso({ObjectFactory.class})
public interface MobileServicePortType {

    @WebResult(name = "out", targetNamespace = "http://services.mobile.interfaces.sinotrans.com")
    @RequestWrapper(localName = "queryOrderDetail", targetNamespace = "http://services.mobile.interfaces.sinotrans.com", className = "com.hoau.wechat.ws.oms.QueryOrderDetail")
    @WebMethod
    @ResponseWrapper(localName = "queryOrderDetailResponse", targetNamespace = "http://services.mobile.interfaces.sinotrans.com", className = "com.hoau.wechat.ws.oms.QueryOrderDetailResponse")
    public com.hoau.wechat.ws.oms.GetPhoneOrderResModel queryOrderDetail(
        @WebParam(name = "in0", targetNamespace = "http://services.mobile.interfaces.sinotrans.com")
        com.hoau.wechat.ws.oms.GetPhoneOrderReqModel in0
    );

    @WebResult(name = "out", targetNamespace = "http://services.mobile.interfaces.sinotrans.com")
    @RequestWrapper(localName = "cancelPhoneOrde", targetNamespace = "http://services.mobile.interfaces.sinotrans.com", className = "com.hoau.wechat.ws.oms.CancelPhoneOrde")
    @WebMethod
    @ResponseWrapper(localName = "cancelPhoneOrdeResponse", targetNamespace = "http://services.mobile.interfaces.sinotrans.com", className = "com.hoau.wechat.ws.oms.CancelPhoneOrdeResponse")
    public com.hoau.wechat.ws.oms.CancelOrderResModel cancelPhoneOrde(
        @WebParam(name = "in0", targetNamespace = "http://services.mobile.interfaces.sinotrans.com")
        com.hoau.wechat.ws.oms.CancelOrderReqModel in0
    );

    @WebResult(name = "out", targetNamespace = "http://services.mobile.interfaces.sinotrans.com")
    @RequestWrapper(localName = "resetPwd", targetNamespace = "http://services.mobile.interfaces.sinotrans.com", className = "com.hoau.wechat.ws.oms.ResetPwd")
    @WebMethod
    @ResponseWrapper(localName = "resetPwdResponse", targetNamespace = "http://services.mobile.interfaces.sinotrans.com", className = "com.hoau.wechat.ws.oms.ResetPwdResponse")
    public com.hoau.wechat.ws.oms.ResetPwdResModel resetPwd(
        @WebParam(name = "in0", targetNamespace = "http://services.mobile.interfaces.sinotrans.com")
        com.hoau.wechat.ws.oms.ResetPwdReqModel in0
    );

    @WebResult(name = "out", targetNamespace = "http://services.mobile.interfaces.sinotrans.com")
    @RequestWrapper(localName = "loginByPhone", targetNamespace = "http://services.mobile.interfaces.sinotrans.com", className = "com.hoau.wechat.ws.oms.LoginByPhone")
    @WebMethod
    @ResponseWrapper(localName = "loginByPhoneResponse", targetNamespace = "http://services.mobile.interfaces.sinotrans.com", className = "com.hoau.wechat.ws.oms.LoginByPhoneResponse")
    public com.hoau.wechat.ws.oms.LoginUserResModel loginByPhone(
        @WebParam(name = "in0", targetNamespace = "http://services.mobile.interfaces.sinotrans.com")
        com.hoau.wechat.ws.oms.LoginUserReqModel in0
    );

    @WebResult(name = "out", targetNamespace = "http://services.mobile.interfaces.sinotrans.com")
    @RequestWrapper(localName = "updateCache", targetNamespace = "http://services.mobile.interfaces.sinotrans.com", className = "com.hoau.wechat.ws.oms.UpdateCache")
    @WebMethod
    @ResponseWrapper(localName = "updateCacheResponse", targetNamespace = "http://services.mobile.interfaces.sinotrans.com", className = "com.hoau.wechat.ws.oms.UpdateCacheResponse")
    public com.hoau.wechat.ws.oms.UpdateCacheResModel updateCache(
        @WebParam(name = "in0", targetNamespace = "http://services.mobile.interfaces.sinotrans.com")
        com.hoau.wechat.ws.oms.UpdateCacheReqModel in0
    );

    @WebResult(name = "out", targetNamespace = "http://services.mobile.interfaces.sinotrans.com")
    @RequestWrapper(localName = "queryOrder", targetNamespace = "http://services.mobile.interfaces.sinotrans.com", className = "com.hoau.wechat.ws.oms.QueryOrder")
    @WebMethod
    @ResponseWrapper(localName = "queryOrderResponse", targetNamespace = "http://services.mobile.interfaces.sinotrans.com", className = "com.hoau.wechat.ws.oms.QueryOrderResponse")
    public com.hoau.wechat.ws.oms.QueryOrdersResModel queryOrder(
        @WebParam(name = "in0", targetNamespace = "http://services.mobile.interfaces.sinotrans.com")
        com.hoau.wechat.ws.oms.QueryOrdersReqModel in0
    );

    @WebResult(name = "out", targetNamespace = "http://services.mobile.interfaces.sinotrans.com")
    @RequestWrapper(localName = "modifyOrder", targetNamespace = "http://services.mobile.interfaces.sinotrans.com", className = "com.hoau.wechat.ws.oms.ModifyOrder")
    @WebMethod
    @ResponseWrapper(localName = "modifyOrderResponse", targetNamespace = "http://services.mobile.interfaces.sinotrans.com", className = "com.hoau.wechat.ws.oms.ModifyOrderResponse")
    public com.hoau.wechat.ws.oms.ModifyOrderResModel modifyOrder(
        @WebParam(name = "in0", targetNamespace = "http://services.mobile.interfaces.sinotrans.com")
        com.hoau.wechat.ws.oms.ModifyOrderReqModel in0
    );

    @WebResult(name = "out", targetNamespace = "http://services.mobile.interfaces.sinotrans.com")
    @RequestWrapper(localName = "createOrder", targetNamespace = "http://services.mobile.interfaces.sinotrans.com", className = "com.hoau.wechat.ws.oms.CreateOrder")
    @WebMethod
    @ResponseWrapper(localName = "createOrderResponse", targetNamespace = "http://services.mobile.interfaces.sinotrans.com", className = "com.hoau.wechat.ws.oms.CreateOrderResponse")
    public com.hoau.wechat.ws.oms.PhoneOrderResModel createOrder(
        @WebParam(name = "in0", targetNamespace = "http://services.mobile.interfaces.sinotrans.com")
        com.hoau.wechat.ws.oms.PhoneOrderReqModel in0
    );

    @WebResult(name = "out", targetNamespace = "http://services.mobile.interfaces.sinotrans.com")
    @RequestWrapper(localName = "registerUser", targetNamespace = "http://services.mobile.interfaces.sinotrans.com", className = "com.hoau.wechat.ws.oms.RegisterUser")
    @WebMethod
    @ResponseWrapper(localName = "registerUserResponse", targetNamespace = "http://services.mobile.interfaces.sinotrans.com", className = "com.hoau.wechat.ws.oms.RegisterUserResponse")
    public com.hoau.wechat.ws.oms.RegisterUserResModel registerUser(
        @WebParam(name = "in0", targetNamespace = "http://services.mobile.interfaces.sinotrans.com")
        com.hoau.wechat.ws.oms.RegisterUserReqModel in0
    );
}