
package com.hoau.mhow.invokews.server.ws.dcpricetime;

/**
 * Please modify this class to meet your needs
 * This class is not complete
 */

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 2.7.11
 * 2015-12-18T11:50:38.775+08:00
 * Generated source version: 2.7.11
 * 
 */
public final class HowPriceAndTimeQueryServices_HowPriceAndTimeQueryServicesPort_Client {

    private static final QName SERVICE_NAME = new QName("http://www.hoau.net/services/HowPriceAndTimeQueryServices", "HowPriceAndTimeQueryServices");

    private HowPriceAndTimeQueryServices_HowPriceAndTimeQueryServicesPort_Client() {
    }

    public static void main(String args[]) throws java.lang.Exception {
        URL wsdlURL = HowPriceAndTimeQueryServices_Service.WSDL_LOCATION;
        if (args.length > 0 && args[0] != null && !"".equals(args[0])) { 
            File wsdlFile = new File(args[0]);
            try {
                if (wsdlFile.exists()) {
                    wsdlURL = wsdlFile.toURI().toURL();
                } else {
                    wsdlURL = new URL(args[0]);
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }
      
        HowPriceAndTimeQueryServices_Service ss = new HowPriceAndTimeQueryServices_Service(wsdlURL, SERVICE_NAME);
        HowPriceAndTimeQueryServices port = ss.getHowPriceAndTimeQueryServicesPort();  
        
        {
        System.out.println("Invoking queryPriceAndTime...");
        com.hoau.mhow.invokews.server.ws.dcpricetime.PriceQueryVo _queryPriceAndTime_arg0 = null;
        java.util.List<com.hoau.mhow.invokews.server.ws.dcpricetime.PriceQueryResult> _queryPriceAndTime__return = port.queryPriceAndTime(_queryPriceAndTime_arg0);
        System.out.println("queryPriceAndTime.result=" + _queryPriceAndTime__return);


        }

        System.exit(0);
    }

}
