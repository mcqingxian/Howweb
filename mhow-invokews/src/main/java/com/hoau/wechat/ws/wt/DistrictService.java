package com.hoau.wechat.ws.wt;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;
import javax.xml.ws.Service;

/**
 * This class was generated by Apache CXF 2.7.11
 * 2015-10-26T17:18:20.239+08:00
 * Generated source version: 2.7.11
 * 
 */
@WebServiceClient(name = "DistrictService", 
                  wsdlLocation = "http://10.39.117.117:8081/HOAU_OL/services/DistrictService?wsdl",
                  targetNamespace = "http://services.district.interfaces.sinotrans.com") 
public class DistrictService extends Service {

    public final static URL WSDL_LOCATION;

    public final static QName SERVICE = new QName("http://services.district.interfaces.sinotrans.com", "DistrictService");
    public final static QName DistrictServiceHttpPort = new QName("http://services.district.interfaces.sinotrans.com", "DistrictServiceHttpPort");
    static {
        URL url = null;
        try {
            url = new URL("http://10.39.117.117:8081/HOAU_OL/services/DistrictService?wsdl");
        } catch (MalformedURLException e) {
            java.util.logging.Logger.getLogger(DistrictService.class.getName())
                .log(java.util.logging.Level.INFO, 
                     "Can not initialize the default wsdl from {0}", "http://10.39.117.117:8081/HOAU_OL/services/DistrictService?wsdl");
        }
        WSDL_LOCATION = url;
    }

    public DistrictService(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public DistrictService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public DistrictService() {
        super(WSDL_LOCATION, SERVICE);
    }
    

    /**
     *
     * @return
     *     returns DistrictServicePortType
     */
    @WebEndpoint(name = "DistrictServiceHttpPort")
    public DistrictServicePortType getDistrictServiceHttpPort() {
        return super.getPort(DistrictServiceHttpPort, DistrictServicePortType.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns DistrictServicePortType
     */
    @WebEndpoint(name = "DistrictServiceHttpPort")
    public DistrictServicePortType getDistrictServiceHttpPort(WebServiceFeature... features) {
        return super.getPort(DistrictServiceHttpPort, DistrictServicePortType.class, features);
    }

}