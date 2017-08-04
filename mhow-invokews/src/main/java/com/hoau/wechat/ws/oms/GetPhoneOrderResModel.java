
package com.hoau.wechat.ws.oms;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>GetPhoneOrderResModel complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="GetPhoneOrderResModel">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="queryOrder" type="{http://model.mobile.interfaces.sinotrans.com}PhoneOrderReqModel" minOccurs="0"/>
 *         &lt;element name="result" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="resultCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="resultInfo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="userid" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetPhoneOrderResModel", propOrder = {
    "queryOrder",
    "result",
    "resultCode",
    "resultInfo",
    "userid"
})
public class GetPhoneOrderResModel {

    @XmlElementRef(name = "queryOrder", namespace = "http://model.mobile.interfaces.sinotrans.com", type = JAXBElement.class)
    protected JAXBElement<PhoneOrderReqModel> queryOrder;
    @XmlElementRef(name = "result", namespace = "http://model.mobile.interfaces.sinotrans.com", type = JAXBElement.class)
    protected JAXBElement<Boolean> result;
    @XmlElementRef(name = "resultCode", namespace = "http://model.mobile.interfaces.sinotrans.com", type = JAXBElement.class)
    protected JAXBElement<String> resultCode;
    @XmlElementRef(name = "resultInfo", namespace = "http://model.mobile.interfaces.sinotrans.com", type = JAXBElement.class)
    protected JAXBElement<String> resultInfo;
    @XmlElementRef(name = "userid", namespace = "http://model.mobile.interfaces.sinotrans.com", type = JAXBElement.class)
    protected JAXBElement<String> userid;

    /**
     * 获取queryOrder属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link PhoneOrderReqModel }{@code >}
     *     
     */
    public JAXBElement<PhoneOrderReqModel> getQueryOrder() {
        return queryOrder;
    }

    /**
     * 设置queryOrder属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link PhoneOrderReqModel }{@code >}
     *     
     */
    public void setQueryOrder(JAXBElement<PhoneOrderReqModel> value) {
        this.queryOrder = value;
    }

    /**
     * 获取result属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     *     
     */
    public JAXBElement<Boolean> getResult() {
        return result;
    }

    /**
     * 设置result属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     *     
     */
    public void setResult(JAXBElement<Boolean> value) {
        this.result = value;
    }

    /**
     * 获取resultCode属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getResultCode() {
        return resultCode;
    }

    /**
     * 设置resultCode属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setResultCode(JAXBElement<String> value) {
        this.resultCode = value;
    }

    /**
     * 获取resultInfo属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getResultInfo() {
        return resultInfo;
    }

    /**
     * 设置resultInfo属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setResultInfo(JAXBElement<String> value) {
        this.resultInfo = value;
    }

    /**
     * 获取userid属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getUserid() {
        return userid;
    }

    /**
     * 设置userid属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setUserid(JAXBElement<String> value) {
        this.userid = value;
    }

}
