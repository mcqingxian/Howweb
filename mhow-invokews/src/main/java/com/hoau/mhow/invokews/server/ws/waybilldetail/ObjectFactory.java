
package com.hoau.mhow.invokews.server.ws.waybilldetail;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.hoau.how.module.itf.server.ws.waybilldetail package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _GetWptYdInfo_QNAME = new QName("http://www.szzc.com.cn/services/WptServices", "getWptYdInfo");
    private final static QName _GetWptYdInfoResponse_QNAME = new QName("http://www.szzc.com.cn/services/WptServices", "getWptYdInfoResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.hoau.how.module.itf.server.ws.waybilldetail
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetWptYdInfoResponse }
     * 
     */
    public GetWptYdInfoResponse createGetWptYdInfoResponse() {
        return new GetWptYdInfoResponse();
    }

    /**
     * Create an instance of {@link GetWptYdInfo }
     * 
     */
    public GetWptYdInfo createGetWptYdInfo() {
        return new GetWptYdInfo();
    }

    /**
     * Create an instance of {@link WptYdInfo }
     * 
     */
    public WptYdInfo createWptYdInfo() {
        return new WptYdInfo();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetWptYdInfo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.szzc.com.cn/services/WptServices", name = "getWptYdInfo")
    public JAXBElement<GetWptYdInfo> createGetWptYdInfo(GetWptYdInfo value) {
        return new JAXBElement<GetWptYdInfo>(_GetWptYdInfo_QNAME, GetWptYdInfo.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetWptYdInfoResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.szzc.com.cn/services/WptServices", name = "getWptYdInfoResponse")
    public JAXBElement<GetWptYdInfoResponse> createGetWptYdInfoResponse(GetWptYdInfoResponse value) {
        return new JAXBElement<GetWptYdInfoResponse>(_GetWptYdInfoResponse_QNAME, GetWptYdInfoResponse.class, null, value);
    }

}
