
package com.hoau.how.module.itf.server.ws.omsorder;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>TrackOrderReqModel complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="TrackOrderReqModel">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="billNoList" type="{http://services.customer.interfaces.sinotrans.com}ArrayOfString" minOccurs="0"/>
 *         &lt;element name="customerCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="orign" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TrackOrderReqModel", propOrder = {
    "billNoList",
    "customerCode",
    "orign"
})
public class TrackOrderReqModel {

    @XmlElementRef(name = "billNoList", namespace = "http://model.customer.interfaces.sinotrans.com", type = JAXBElement.class)
    protected JAXBElement<ArrayOfString> billNoList;
    @XmlElementRef(name = "customerCode", namespace = "http://model.customer.interfaces.sinotrans.com", type = JAXBElement.class)
    protected JAXBElement<String> customerCode;
    @XmlElementRef(name = "orign", namespace = "http://model.customer.interfaces.sinotrans.com", type = JAXBElement.class)
    protected JAXBElement<String> orign;

    /**
     * 获取billNoList属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfString }{@code >}
     *     
     */
    public JAXBElement<ArrayOfString> getBillNoList() {
        return billNoList;
    }

    /**
     * 设置billNoList属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfString }{@code >}
     *     
     */
    public void setBillNoList(JAXBElement<ArrayOfString> value) {
        this.billNoList = value;
    }

    /**
     * 获取customerCode属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getCustomerCode() {
        return customerCode;
    }

    /**
     * 设置customerCode属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setCustomerCode(JAXBElement<String> value) {
        this.customerCode = value;
    }

    /**
     * 获取orign属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getOrign() {
        return orign;
    }

    /**
     * 设置orign属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setOrign(JAXBElement<String> value) {
        this.orign = value;
    }

}
