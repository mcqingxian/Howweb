
/**
 * Please modify this class to meet your needs
 * This class is not complete
 */

package com.hoau.mhow.invokews.server.ws.dcpricetime;

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
 * 2015-12-18T11:50:38.802+08:00
 * Generated source version: 2.7.11
 * 
 */

@javax.jws.WebService(
                      serviceName = "HowPriceAndTimeQueryServices",
                      portName = "HowPriceAndTimeQueryServicesPort",
                      targetNamespace = "http://www.hoau.net/services/HowPriceAndTimeQueryServices",
                      wsdlLocation = "http://10.39.109.29:8080/services/HowPriceAndTimeQueryServices?wsdl",
                      endpointInterface = "com.hoau.mhow.invokews.server.ws.dcpricetime.HowPriceAndTimeQueryServices")
                      
public class HowPriceAndTimeQueryServicesImpl implements HowPriceAndTimeQueryServices {

    private static final Logger LOG = Logger.getLogger(HowPriceAndTimeQueryServicesImpl.class.getName());

    /* (non-Javadoc)
     * @see com.hoau.mhow.invokews.server.ws.dcpricetime.HowPriceAndTimeQueryServices#queryPriceAndTime(com.hoau.mhow.invokews.server.ws.dcpricetime.PriceQueryVo  arg0 )*
     */
    public java.util.List<com.hoau.mhow.invokews.server.ws.dcpricetime.PriceQueryResult> queryPriceAndTime(com.hoau.mhow.invokews.server.ws.dcpricetime.PriceQueryVo arg0) { 
        LOG.info("Executing operation queryPriceAndTime");
        System.out.println(arg0);
        try {
            java.util.List<com.hoau.mhow.invokews.server.ws.dcpricetime.PriceQueryResult> _return = null;
            return _return;
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

}
