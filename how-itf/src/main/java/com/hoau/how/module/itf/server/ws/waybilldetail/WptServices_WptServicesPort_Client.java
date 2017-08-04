
package com.hoau.how.module.itf.server.ws.waybilldetail;

/**
 * Please modify this class to meet your needs
 * This class is not complete
 */

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.xml.namespace.QName;

/**
 * This class was generated by Apache CXF 3.0.1
 * 2015-06-16T18:07:21.204+08:00
 * Generated source version: 3.0.1
 * 
 */
public final class WptServices_WptServicesPort_Client {

    private static final QName SERVICE_NAME = new QName("http://www.szzc.com.cn/services/WptServices", "WptServices");

    private WptServices_WptServicesPort_Client() {
    }

    public static void main(String args[]) throws java.lang.Exception {
        URL wsdlURL = WptServices_Service.WSDL_LOCATION;
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
      
        WptServices_Service ss = new WptServices_Service(wsdlURL, SERVICE_NAME);
        WptServices port = ss.getWptServicesPort();  
        
        {
//        System.out.println("Invoking getWptYdInfo...");
//        java.util.List<java.lang.String> _getWptYdInfo_arg0 = null;
//        java.util.List<com.hoau.how.module.itf.server.ws.waybilldetail.WptYdInfo> _getWptYdInfo__return = port.getWptYdInfo(_getWptYdInfo_arg0);
//        System.out.println("getWptYdInfo.result=" + _getWptYdInfo__return);
//        
        
        System.out.println("Invoking getWptYdInfo...");
//        WaybillInfo _queryOneWaybill__return = port.queryOneWaybill("15876790489", "2013-09-06 01:08:00");
        List<String> yys = new ArrayList<String>();
        yys.add("AB8080597");
        List<WptYdInfo> wys = port.getWptYdInfo(yys);
        System.out.println("getWptYdInfo.result=" + wys.get(0));


        }

        System.exit(0);
    }

}
