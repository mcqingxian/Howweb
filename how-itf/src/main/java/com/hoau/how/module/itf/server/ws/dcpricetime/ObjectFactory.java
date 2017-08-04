
package com.hoau.how.module.itf.server.ws.dcpricetime;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.hoau.how.module.itf.server.ws.dcpricetime package. 
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

    private final static QName _QueryPriceAndTime_QNAME = new QName("http://www.hoau.net/services/HowPriceAndTimeQueryServices", "queryPriceAndTime");
    private final static QName _QueryPriceAndTimeResponse_QNAME = new QName("http://www.hoau.net/services/HowPriceAndTimeQueryServices", "queryPriceAndTimeResponse");
    private final static QName _TranslateTransportTypeResponse_QNAME = new QName("http://www.hoau.net/services/HowPriceAndTimeQueryServices", "translateTransportTypeResponse");
    private final static QName _TranslateTransportType_QNAME = new QName("http://www.hoau.net/services/HowPriceAndTimeQueryServices", "translateTransportType");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.hoau.how.module.itf.server.ws.dcpricetime
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link QueryPriceAndTimeResponse }
     * 
     */
    public QueryPriceAndTimeResponse createQueryPriceAndTimeResponse() {
        return new QueryPriceAndTimeResponse();
    }

    /**
     * Create an instance of {@link TranslateTransportTypeResponse }
     * 
     */
    public TranslateTransportTypeResponse createTranslateTransportTypeResponse() {
        return new TranslateTransportTypeResponse();
    }

    /**
     * Create an instance of {@link QueryPriceAndTime }
     * 
     */
    public QueryPriceAndTime createQueryPriceAndTime() {
        return new QueryPriceAndTime();
    }

    /**
     * Create an instance of {@link TranslateTransportType }
     * 
     */
    public TranslateTransportType createTranslateTransportType() {
        return new TranslateTransportType();
    }

    /**
     * Create an instance of {@link PriceQueryResult }
     * 
     */
    public PriceQueryResult createPriceQueryResult() {
        return new PriceQueryResult();
    }

    /**
     * Create an instance of {@link PriceQueryVo }
     * 
     */
    public PriceQueryVo createPriceQueryVo() {
        return new PriceQueryVo();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link QueryPriceAndTime }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.hoau.net/services/HowPriceAndTimeQueryServices", name = "queryPriceAndTime")
    public JAXBElement<QueryPriceAndTime> createQueryPriceAndTime(QueryPriceAndTime value) {
        return new JAXBElement<QueryPriceAndTime>(_QueryPriceAndTime_QNAME, QueryPriceAndTime.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link QueryPriceAndTimeResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.hoau.net/services/HowPriceAndTimeQueryServices", name = "queryPriceAndTimeResponse")
    public JAXBElement<QueryPriceAndTimeResponse> createQueryPriceAndTimeResponse(QueryPriceAndTimeResponse value) {
        return new JAXBElement<QueryPriceAndTimeResponse>(_QueryPriceAndTimeResponse_QNAME, QueryPriceAndTimeResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TranslateTransportTypeResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.hoau.net/services/HowPriceAndTimeQueryServices", name = "translateTransportTypeResponse")
    public JAXBElement<TranslateTransportTypeResponse> createTranslateTransportTypeResponse(TranslateTransportTypeResponse value) {
        return new JAXBElement<TranslateTransportTypeResponse>(_TranslateTransportTypeResponse_QNAME, TranslateTransportTypeResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TranslateTransportType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.hoau.net/services/HowPriceAndTimeQueryServices", name = "translateTransportType")
    public JAXBElement<TranslateTransportType> createTranslateTransportType(TranslateTransportType value) {
        return new JAXBElement<TranslateTransportType>(_TranslateTransportType_QNAME, TranslateTransportType.class, null, value);
    }

}
