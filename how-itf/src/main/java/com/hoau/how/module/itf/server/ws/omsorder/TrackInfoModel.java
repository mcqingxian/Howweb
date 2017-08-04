
package com.hoau.how.module.itf.server.ws.omsorder;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>TrackInfoModel complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="TrackInfoModel">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="billNo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="customerOrder" type="{http://model.customer.interfaces.sinotrans.com}CustOrderReqModel" minOccurs="0"/>
 *         &lt;element name="trackDtlList" type="{http://model.customer.interfaces.sinotrans.com}ArrayOfTrackInfoDtlModel" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TrackInfoModel", propOrder = {
    "billNo",
    "customerOrder",
    "trackDtlList"
})
public class TrackInfoModel {

    @XmlElementRef(name = "billNo", namespace = "http://model.customer.interfaces.sinotrans.com", type = JAXBElement.class)
    protected JAXBElement<String> billNo;
    @XmlElementRef(name = "customerOrder", namespace = "http://model.customer.interfaces.sinotrans.com", type = JAXBElement.class)
    protected JAXBElement<CustOrderReqModel> customerOrder;
    @XmlElementRef(name = "trackDtlList", namespace = "http://model.customer.interfaces.sinotrans.com", type = JAXBElement.class)
    protected JAXBElement<ArrayOfTrackInfoDtlModel> trackDtlList;

    /**
     * 获取billNo属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getBillNo() {
        return billNo;
    }

    /**
     * 设置billNo属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setBillNo(JAXBElement<String> value) {
        this.billNo = value;
    }

    /**
     * 获取customerOrder属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link CustOrderReqModel }{@code >}
     *     
     */
    public JAXBElement<CustOrderReqModel> getCustomerOrder() {
        return customerOrder;
    }

    /**
     * 设置customerOrder属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link CustOrderReqModel }{@code >}
     *     
     */
    public void setCustomerOrder(JAXBElement<CustOrderReqModel> value) {
        this.customerOrder = value;
    }

    /**
     * 获取trackDtlList属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfTrackInfoDtlModel }{@code >}
     *     
     */
    public JAXBElement<ArrayOfTrackInfoDtlModel> getTrackDtlList() {
        return trackDtlList;
    }

    /**
     * 设置trackDtlList属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfTrackInfoDtlModel }{@code >}
     *     
     */
    public void setTrackDtlList(JAXBElement<ArrayOfTrackInfoDtlModel> value) {
        this.trackDtlList = value;
    }

}
