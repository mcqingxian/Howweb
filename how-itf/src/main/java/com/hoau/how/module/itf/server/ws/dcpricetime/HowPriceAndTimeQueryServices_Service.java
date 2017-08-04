package com.hoau.how.module.itf.server.ws.dcpricetime;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;
import javax.xml.ws.Service;

/**
 * This class was generated by Apache CXF 3.0.2
 * 2015-09-10T14:21:48.003+08:00
 * Generated source version: 3.0.2
 * 
 */
@WebServiceClient(name = "HowPriceAndTimeQueryServices", 
                  wsdlLocation = "http://10.39.109.29:8080/services/HowPriceAndTimeQueryServices?wsdl",
                  targetNamespace = "http://www.hoau.net/services/HowPriceAndTimeQueryServices") 
public class HowPriceAndTimeQueryServices_Service extends Service {

    public final static URL WSDL_LOCATION;

    public final static QName SERVICE = new QName("http://www.hoau.net/services/HowPriceAndTimeQueryServices", "HowPriceAndTimeQueryServices");
    public final static QName HowPriceAndTimeQueryServicesPort = new QName("http://www.hoau.net/services/HowPriceAndTimeQueryServices", "HowPriceAndTimeQueryServicesPort");
    static {
        URL url = null;
        try {
            url = new URL("http://10.39.251.3:8080/hoaunew/services/HowPriceAndTimeQueryServices?wsdl");
        } catch (MalformedURLException e) {
            java.util.logging.Logger.getLogger(HowPriceAndTimeQueryServices_Service.class.getName())
                .log(java.util.logging.Level.INFO, 
                     "Can not initialize the default wsdl from {0}", "http://10.39.109.29:8080/services/HowPriceAndTimeQueryServices?wsdl");
        }
        WSDL_LOCATION = url;
    }

    public HowPriceAndTimeQueryServices_Service(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public HowPriceAndTimeQueryServices_Service(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public HowPriceAndTimeQueryServices_Service() {
        super(WSDL_LOCATION, SERVICE);
    }
    

    /**
     *
     * @return
     *     returns HowPriceAndTimeQueryServices
     */
    @WebEndpoint(name = "HowPriceAndTimeQueryServicesPort")
    public HowPriceAndTimeQueryServices getHowPriceAndTimeQueryServicesPort() {
        return super.getPort(HowPriceAndTimeQueryServicesPort, HowPriceAndTimeQueryServices.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns HowPriceAndTimeQueryServices
     */
    @WebEndpoint(name = "HowPriceAndTimeQueryServicesPort")
    public HowPriceAndTimeQueryServices getHowPriceAndTimeQueryServicesPort(WebServiceFeature... features) {
        return super.getPort(HowPriceAndTimeQueryServicesPort, HowPriceAndTimeQueryServices.class, features);
    }

}