
package com.hoau.how.module.itf.server.ws.bank;

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
 * This class was generated by Apache CXF 3.1.6
 * 2016-06-03T16:09:08.888+08:00
 * Generated source version: 3.1.6
 * 
 */
public final class BaseAccountInfoServices_BaseAccountInfoServicesPort_Client {

    private static final QName SERVICE_NAME = new QName("http://10.39.251.150:8080/services/BaseAccountInfoServices", "BaseAccountInfoServices");

    private BaseAccountInfoServices_BaseAccountInfoServicesPort_Client() {
    }

    public static void main(String args[]) throws java.lang.Exception {
        URL wsdlURL = new URL("http://10.39.109.29:8080/services/BaseAccountInfoServices?wsdl");
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
      
        BaseAccountInfoServices_Service ss = new BaseAccountInfoServices_Service(wsdlURL, SERVICE_NAME);
        BaseAccountInfoServices port = ss.getBaseAccountInfoServicesPort();  
        
//        {
//        System.out.println("Invoking getAccountCityList...");
//        java.lang.String _getAccountCityList_arg0 = "成";
//        java.util.List<com.hoau.how.module.itf.server.ws.bank.AccountCity> _getAccountCityList__return = port.getAccountCityList(_getAccountCityList_arg0);
//        System.out.println("getAccountCityList.result=" + _getAccountCityList__return);
//
//
//        }
//        {
//        System.out.println("Invoking getAccountProvinceList...");
//        java.lang.String _getAccountProvinceList_arg0 = "";
//        java.util.List<com.hoau.how.module.itf.server.ws.bank.AccountProvince> _getAccountProvinceList__return = port.getAccountProvinceList(_getAccountProvinceList_arg0);
//        System.out.println("getAccountProvinceList.result=" + _getAccountProvinceList__return);
//
//
//        }
        {
        System.out.println("Invoking getAccountBankInfoList...");
        java.lang.String _getAccountBankInfoList_arg0 = "工商银行成都市高新";
        java.util.List<com.hoau.how.module.itf.server.ws.bank.AccountBankInfo> _getAccountBankInfoList__return = port.getAccountBankInfoList(_getAccountBankInfoList_arg0);
        System.out.println("getAccountBankInfoList.result=" + _getAccountBankInfoList__return);


        }

        System.exit(0);
    }

}
