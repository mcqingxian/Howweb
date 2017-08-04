
package com.hoau.wechat.ws.waybill;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.hoau.wechat.ws.waybill package. 
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

    private final static QName _QuerySignInfoServicesResponse_QNAME = new QName("http://www.hoau.net/services/QuerySignInfoServices", "querySignInfoServicesResponse");
    private final static QName _QuerySignInfoServices_QNAME = new QName("http://www.hoau.net/services/QuerySignInfoServices", "querySignInfoServices");
    private final static QName _QueryWaybillResponse_QNAME = new QName("http://www.hoau.net/services/QuerySignInfoServices", "queryWaybillResponse");
    private final static QName _QueryWaybill_QNAME = new QName("http://www.hoau.net/services/QuerySignInfoServices", "queryWaybill");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.hoau.wechat.ws.waybill
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link QueryWaybillResponse }
     * 
     */
    public QueryWaybillResponse createQueryWaybillResponse() {
        return new QueryWaybillResponse();
    }

    /**
     * Create an instance of {@link QueryWaybill }
     * 
     */
    public QueryWaybill createQueryWaybill() {
        return new QueryWaybill();
    }

    /**
     * Create an instance of {@link QuerySignInfoServicesResponse }
     * 
     */
    public QuerySignInfoServicesResponse createQuerySignInfoServicesResponse() {
        return new QuerySignInfoServicesResponse();
    }

    /**
     * Create an instance of {@link QuerySignInfoServices_Type }
     * 
     */
    public QuerySignInfoServices_Type createQuerySignInfoServices_Type() {
        return new QuerySignInfoServices_Type();
    }

    /**
     * Create an instance of {@link WaybillInfo }
     * 
     */
    public WaybillInfo createWaybillInfo() {
        return new WaybillInfo();
    }

    /**
     * Create an instance of {@link SignInfoEntity }
     * 
     */
    public SignInfoEntity createSignInfoEntity() {
        return new SignInfoEntity();
    }

    /**
     * Create an instance of {@link ResBaseVo }
     * 
     */
    public ResBaseVo createResBaseVo() {
        return new ResBaseVo();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link QuerySignInfoServicesResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.hoau.net/services/QuerySignInfoServices", name = "querySignInfoServicesResponse")
    public JAXBElement<QuerySignInfoServicesResponse> createQuerySignInfoServicesResponse(QuerySignInfoServicesResponse value) {
        return new JAXBElement<QuerySignInfoServicesResponse>(_QuerySignInfoServicesResponse_QNAME, QuerySignInfoServicesResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link QuerySignInfoServices_Type }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.hoau.net/services/QuerySignInfoServices", name = "querySignInfoServices")
    public JAXBElement<QuerySignInfoServices_Type> createQuerySignInfoServices(QuerySignInfoServices_Type value) {
        return new JAXBElement<QuerySignInfoServices_Type>(_QuerySignInfoServices_QNAME, QuerySignInfoServices_Type.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link QueryWaybillResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.hoau.net/services/QuerySignInfoServices", name = "queryWaybillResponse")
    public JAXBElement<QueryWaybillResponse> createQueryWaybillResponse(QueryWaybillResponse value) {
        return new JAXBElement<QueryWaybillResponse>(_QueryWaybillResponse_QNAME, QueryWaybillResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link QueryWaybill }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.hoau.net/services/QuerySignInfoServices", name = "queryWaybill")
    public JAXBElement<QueryWaybill> createQueryWaybill(QueryWaybill value) {
        return new JAXBElement<QueryWaybill>(_QueryWaybill_QNAME, QueryWaybill.class, null, value);
    }

}
