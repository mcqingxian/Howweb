
package com.hoau.wechat.ws.oms;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>ModifyOrderReqModel complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="ModifyOrderReqModel">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="modifyOrder" type="{http://model.mobile.interfaces.sinotrans.com}PhoneOrderReqModel" minOccurs="0"/>
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
@XmlType(name = "ModifyOrderReqModel", propOrder = {
    "modifyOrder",
    "userid"
})
public class ModifyOrderReqModel {

    @XmlElementRef(name = "modifyOrder", namespace = "http://model.mobile.interfaces.sinotrans.com", type = JAXBElement.class)
    protected JAXBElement<PhoneOrderReqModel> modifyOrder;
    @XmlElementRef(name = "userid", namespace = "http://model.mobile.interfaces.sinotrans.com", type = JAXBElement.class)
    protected JAXBElement<String> userid;

    /**
     * 获取modifyOrder属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link PhoneOrderReqModel }{@code >}
     *     
     */
    public JAXBElement<PhoneOrderReqModel> getModifyOrder() {
        return modifyOrder;
    }

    /**
     * 设置modifyOrder属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link PhoneOrderReqModel }{@code >}
     *     
     */
    public void setModifyOrder(JAXBElement<PhoneOrderReqModel> value) {
        this.modifyOrder = value;
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
