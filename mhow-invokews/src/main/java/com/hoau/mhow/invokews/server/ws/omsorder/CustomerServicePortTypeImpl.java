
/**
 * Please modify this class to meet your needs
 * This class is not complete
 */

package com.hoau.mhow.invokews.server.ws.omsorder;

import java.util.logging.Logger;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 2.7.11
 * 2015-12-18T11:50:06.714+08:00
 * Generated source version: 2.7.11
 * 
 */

@javax.jws.WebService(
                      serviceName = "CustomerService",
                      portName = "CustomerServiceHttpPort",
                      targetNamespace = "http://services.customer.interfaces.sinotrans.com",
                      wsdlLocation = "http://testoms.hoau.net/services/CustomerService?wsdl",
                      endpointInterface = "com.hoau.mhow.invokews.server.ws.omsorder.CustomerServicePortType")
                      
public class CustomerServicePortTypeImpl implements CustomerServicePortType {

    private static final Logger LOG = Logger.getLogger(CustomerServicePortTypeImpl.class.getName());

    /* (non-Javadoc)
     * @see com.hoau.mhow.invokews.server.ws.omsorder.CustomerServicePortType#modifyOrder(com.hoau.mhow.invokews.server.ws.omsorder.CustOrderReqModel  in0 )*
     */
    public com.hoau.mhow.invokews.server.ws.omsorder.CustOrderResModel modifyOrder(com.hoau.mhow.invokews.server.ws.omsorder.CustOrderReqModel in0) { 
        LOG.info("Executing operation modifyOrder");
        System.out.println(in0);
        try {
            com.hoau.mhow.invokews.server.ws.omsorder.CustOrderResModel _return = null;
            return _return;
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

    /* (non-Javadoc)
     * @see com.hoau.mhow.invokews.server.ws.omsorder.CustomerServicePortType#cancelOrder(com.hoau.mhow.invokews.server.ws.omsorder.CancelOrderReqModel  in0 )*
     */
    public com.hoau.mhow.invokews.server.ws.omsorder.CancelOrderResModel cancelOrder(com.hoau.mhow.invokews.server.ws.omsorder.CancelOrderReqModel in0) { 
        LOG.info("Executing operation cancelOrder");
        System.out.println(in0);
        try {
            com.hoau.mhow.invokews.server.ws.omsorder.CancelOrderResModel _return = null;
            return _return;
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

    /* (non-Javadoc)
     * @see com.hoau.mhow.invokews.server.ws.omsorder.CustomerServicePortType#cutomerOrder(com.hoau.mhow.invokews.server.ws.omsorder.CustOrderReqModel  in0 )*
     */
    public com.hoau.mhow.invokews.server.ws.omsorder.CustOrderResModel cutomerOrder(com.hoau.mhow.invokews.server.ws.omsorder.CustOrderReqModel in0) { 
        LOG.info("Executing operation cutomerOrder");
        System.out.println(in0);
        try {
            com.hoau.mhow.invokews.server.ws.omsorder.CustOrderResModel _return = null;
            return _return;
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

    /* (non-Javadoc)
     * @see com.hoau.mhow.invokews.server.ws.omsorder.CustomerServicePortType#saveNetOrder(com.hoau.mhow.invokews.server.ws.omsorder.EiNetOrderReqModel  in0 )*
     */
    public com.hoau.mhow.invokews.server.ws.omsorder.EiNetOrderReqModel saveNetOrder(com.hoau.mhow.invokews.server.ws.omsorder.EiNetOrderReqModel in0) { 
        LOG.info("Executing operation saveNetOrder");
        System.out.println(in0);
        try {
            com.hoau.mhow.invokews.server.ws.omsorder.EiNetOrderReqModel _return = null;
            return _return;
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

    /* (non-Javadoc)
     * @see com.hoau.mhow.invokews.server.ws.omsorder.CustomerServicePortType#updateNetOrder(com.hoau.mhow.invokews.server.ws.omsorder.EiNetOrderReqModel  in0 )*
     */
    public com.hoau.mhow.invokews.server.ws.omsorder.EiNetOrderReq updateNetOrder(com.hoau.mhow.invokews.server.ws.omsorder.EiNetOrderReqModel in0) { 
        LOG.info("Executing operation updateNetOrder");
        System.out.println(in0);
        try {
            com.hoau.mhow.invokews.server.ws.omsorder.EiNetOrderReq _return = null;
            return _return;
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

    /* (non-Javadoc)
     * @see com.hoau.mhow.invokews.server.ws.omsorder.CustomerServicePortType#trackOrder(com.hoau.mhow.invokews.server.ws.omsorder.TrackOrderReqModel  in0 )*
     */
    public com.hoau.mhow.invokews.server.ws.omsorder.TrackOrderResModel trackOrder(com.hoau.mhow.invokews.server.ws.omsorder.TrackOrderReqModel in0) { 
        LOG.info("Executing operation trackOrder");
        System.out.println(in0);
        try {
            com.hoau.mhow.invokews.server.ws.omsorder.TrackOrderResModel _return = null;
            return _return;
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

    /* (non-Javadoc)
     * @see com.hoau.mhow.invokews.server.ws.omsorder.CustomerServicePortType#queryOrder(com.hoau.mhow.invokews.server.ws.omsorder.QueryOrderReqModel  in0 )*
     */
    public com.hoau.mhow.invokews.server.ws.omsorder.QueryOrderResModel queryOrder(com.hoau.mhow.invokews.server.ws.omsorder.QueryOrderReqModel in0) { 
        LOG.info("Executing operation queryOrder");
        System.out.println(in0);
        try {
            com.hoau.mhow.invokews.server.ws.omsorder.QueryOrderResModel _return = null;
            return _return;
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

}
