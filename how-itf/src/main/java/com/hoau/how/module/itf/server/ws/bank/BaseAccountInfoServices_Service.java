
package com.hoau.how.module.itf.server.ws.bank;

import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.1.6 in JDK 6
 * Generated source version: 2.1
 * 
 */
@WebServiceClient(name = "BaseAccountInfoServices", targetNamespace = "http://10.39.251.150:8080/services/BaseAccountInfoServices", wsdlLocation = "http://10.39.109.29:8080/services/BaseAccountInfoServices?wsdl")
public class BaseAccountInfoServices_Service
    extends Service
{

    public BaseAccountInfoServices_Service(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public BaseAccountInfoServices_Service(URL wsdlLocation) {
        super(wsdlLocation, new QName("http://10.39.251.150:8080/services/BaseAccountInfoServices", "BaseAccountInfoServices"));
    }

    /**
     * 
     * @return
     *     returns BaseAccountInfoServices
     */
    @WebEndpoint(name = "BaseAccountInfoServicesPort")
    public BaseAccountInfoServices getBaseAccountInfoServicesPort() {
        return super.getPort(new QName("http://10.39.251.150:8080/services/BaseAccountInfoServices", "BaseAccountInfoServicesPort"), BaseAccountInfoServices.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns BaseAccountInfoServices
     */
    @WebEndpoint(name = "BaseAccountInfoServicesPort")
    public BaseAccountInfoServices getBaseAccountInfoServicesPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://10.39.251.150:8080/services/BaseAccountInfoServices", "BaseAccountInfoServicesPort"), BaseAccountInfoServices.class, features);
    }

}
