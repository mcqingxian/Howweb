
package com.hoau.how.module.itf.server.ws.goodstrace;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.hoau.how.module.itf.server.ws.goodstrace package. 
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

    private final static QName _GetGPSStatus_QNAME = new QName("http://ws.datamanagement.barcode.hoau.com/", "getGPSStatus");
    private final static QName _GetYdTraceResponse_QNAME = new QName("http://ws.datamanagement.barcode.hoau.com/", "getYdTraceResponse");
    private final static QName _GetGPSStatusResponse_QNAME = new QName("http://ws.datamanagement.barcode.hoau.com/", "getGPSStatusResponse");
    private final static QName _GetWebYdTraceResponse_QNAME = new QName("http://ws.datamanagement.barcode.hoau.com/", "getWebYdTraceResponse");
    private final static QName _GetWebYdTraceByLevel_QNAME = new QName("http://ws.datamanagement.barcode.hoau.com/", "getWebYdTraceByLevel");
    private final static QName _GetYdTrace_QNAME = new QName("http://ws.datamanagement.barcode.hoau.com/", "getYdTrace");
    private final static QName _GetWebDkhYdTrace_QNAME = new QName("http://ws.datamanagement.barcode.hoau.com/", "getWebDkhYdTrace");
    private final static QName _GetWebDkhYdTraceResponse_QNAME = new QName("http://ws.datamanagement.barcode.hoau.com/", "getWebDkhYdTraceResponse");
    private final static QName _GetWebYdTrace_QNAME = new QName("http://ws.datamanagement.barcode.hoau.com/", "getWebYdTrace");
    private final static QName _GetWebYdTraceByLevelResponse_QNAME = new QName("http://ws.datamanagement.barcode.hoau.com/", "getWebYdTraceByLevelResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.hoau.how.module.itf.server.ws.goodstrace
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetYdTraceResponse }
     * 
     */
    public GetYdTraceResponse createGetYdTraceResponse() {
        return new GetYdTraceResponse();
    }

    /**
     * Create an instance of {@link GetGPSStatus }
     * 
     */
    public GetGPSStatus createGetGPSStatus() {
        return new GetGPSStatus();
    }

    /**
     * Create an instance of {@link GetWebYdTraceResponse }
     * 
     */
    public GetWebYdTraceResponse createGetWebYdTraceResponse() {
        return new GetWebYdTraceResponse();
    }

    /**
     * Create an instance of {@link GetYdTrace }
     * 
     */
    public GetYdTrace createGetYdTrace() {
        return new GetYdTrace();
    }

    /**
     * Create an instance of {@link GetWebYdTraceByLevel }
     * 
     */
    public GetWebYdTraceByLevel createGetWebYdTraceByLevel() {
        return new GetWebYdTraceByLevel();
    }

    /**
     * Create an instance of {@link GetGPSStatusResponse }
     * 
     */
    public GetGPSStatusResponse createGetGPSStatusResponse() {
        return new GetGPSStatusResponse();
    }

    /**
     * Create an instance of {@link GetWebDkhYdTraceResponse }
     * 
     */
    public GetWebDkhYdTraceResponse createGetWebDkhYdTraceResponse() {
        return new GetWebDkhYdTraceResponse();
    }

    /**
     * Create an instance of {@link GetWebYdTraceByLevelResponse }
     * 
     */
    public GetWebYdTraceByLevelResponse createGetWebYdTraceByLevelResponse() {
        return new GetWebYdTraceByLevelResponse();
    }

    /**
     * Create an instance of {@link GetWebYdTrace }
     * 
     */
    public GetWebYdTrace createGetWebYdTrace() {
        return new GetWebYdTrace();
    }

    /**
     * Create an instance of {@link GetWebDkhYdTrace }
     * 
     */
    public GetWebDkhYdTrace createGetWebDkhYdTrace() {
        return new GetWebDkhYdTrace();
    }

    /**
     * Create an instance of {@link TraceInfo }
     * 
     */
    public TraceInfo createTraceInfo() {
        return new TraceInfo();
    }

    /**
     * Create an instance of {@link YdTraceResponse }
     * 
     */
    public YdTraceResponse createYdTraceResponse() {
        return new YdTraceResponse();
    }

    /**
     * Create an instance of {@link DkhTraceInfo }
     * 
     */
    public DkhTraceInfo createDkhTraceInfo() {
        return new DkhTraceInfo();
    }

    /**
     * Create an instance of {@link DkhYdTrace }
     * 
     */
    public DkhYdTrace createDkhYdTrace() {
        return new DkhYdTrace();
    }

    /**
     * Create an instance of {@link YdTrace }
     * 
     */
    public YdTrace createYdTrace() {
        return new YdTrace();
    }

    /**
     * Create an instance of {@link Response }
     * 
     */
    public Response createResponse() {
        return new Response();
    }

    /**
     * Create an instance of {@link DkhYdTraceResponse }
     * 
     */
    public DkhYdTraceResponse createDkhYdTraceResponse() {
        return new DkhYdTraceResponse();
    }

    /**
     * Create an instance of {@link GpsStatusResponse }
     * 
     */
    public GpsStatusResponse createGpsStatusResponse() {
        return new GpsStatusResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetGPSStatus }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.datamanagement.barcode.hoau.com/", name = "getGPSStatus")
    public JAXBElement<GetGPSStatus> createGetGPSStatus(GetGPSStatus value) {
        return new JAXBElement<GetGPSStatus>(_GetGPSStatus_QNAME, GetGPSStatus.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetYdTraceResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.datamanagement.barcode.hoau.com/", name = "getYdTraceResponse")
    public JAXBElement<GetYdTraceResponse> createGetYdTraceResponse(GetYdTraceResponse value) {
        return new JAXBElement<GetYdTraceResponse>(_GetYdTraceResponse_QNAME, GetYdTraceResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetGPSStatusResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.datamanagement.barcode.hoau.com/", name = "getGPSStatusResponse")
    public JAXBElement<GetGPSStatusResponse> createGetGPSStatusResponse(GetGPSStatusResponse value) {
        return new JAXBElement<GetGPSStatusResponse>(_GetGPSStatusResponse_QNAME, GetGPSStatusResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetWebYdTraceResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.datamanagement.barcode.hoau.com/", name = "getWebYdTraceResponse")
    public JAXBElement<GetWebYdTraceResponse> createGetWebYdTraceResponse(GetWebYdTraceResponse value) {
        return new JAXBElement<GetWebYdTraceResponse>(_GetWebYdTraceResponse_QNAME, GetWebYdTraceResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetWebYdTraceByLevel }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.datamanagement.barcode.hoau.com/", name = "getWebYdTraceByLevel")
    public JAXBElement<GetWebYdTraceByLevel> createGetWebYdTraceByLevel(GetWebYdTraceByLevel value) {
        return new JAXBElement<GetWebYdTraceByLevel>(_GetWebYdTraceByLevel_QNAME, GetWebYdTraceByLevel.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetYdTrace }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.datamanagement.barcode.hoau.com/", name = "getYdTrace")
    public JAXBElement<GetYdTrace> createGetYdTrace(GetYdTrace value) {
        return new JAXBElement<GetYdTrace>(_GetYdTrace_QNAME, GetYdTrace.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetWebDkhYdTrace }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.datamanagement.barcode.hoau.com/", name = "getWebDkhYdTrace")
    public JAXBElement<GetWebDkhYdTrace> createGetWebDkhYdTrace(GetWebDkhYdTrace value) {
        return new JAXBElement<GetWebDkhYdTrace>(_GetWebDkhYdTrace_QNAME, GetWebDkhYdTrace.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetWebDkhYdTraceResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.datamanagement.barcode.hoau.com/", name = "getWebDkhYdTraceResponse")
    public JAXBElement<GetWebDkhYdTraceResponse> createGetWebDkhYdTraceResponse(GetWebDkhYdTraceResponse value) {
        return new JAXBElement<GetWebDkhYdTraceResponse>(_GetWebDkhYdTraceResponse_QNAME, GetWebDkhYdTraceResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetWebYdTrace }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.datamanagement.barcode.hoau.com/", name = "getWebYdTrace")
    public JAXBElement<GetWebYdTrace> createGetWebYdTrace(GetWebYdTrace value) {
        return new JAXBElement<GetWebYdTrace>(_GetWebYdTrace_QNAME, GetWebYdTrace.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetWebYdTraceByLevelResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.datamanagement.barcode.hoau.com/", name = "getWebYdTraceByLevelResponse")
    public JAXBElement<GetWebYdTraceByLevelResponse> createGetWebYdTraceByLevelResponse(GetWebYdTraceByLevelResponse value) {
        return new JAXBElement<GetWebYdTraceByLevelResponse>(_GetWebYdTraceByLevelResponse_QNAME, GetWebYdTraceByLevelResponse.class, null, value);
    }

}
