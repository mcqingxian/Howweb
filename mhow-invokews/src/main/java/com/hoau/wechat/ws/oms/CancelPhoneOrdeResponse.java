
package com.hoau.wechat.ws.oms;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>anonymous complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="out" type="{http://model.mobile.interfaces.sinotrans.com}CancelOrderResModel"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "out"
})
@XmlRootElement(name = "cancelPhoneOrdeResponse", namespace = "http://services.mobile.interfaces.sinotrans.com")
public class CancelPhoneOrdeResponse {

    @XmlElement(namespace = "http://services.mobile.interfaces.sinotrans.com", required = true, nillable = true)
    protected CancelOrderResModel out;

    /**
     * 获取out属性的值。
     * 
     * @return
     *     possible object is
     *     {@link CancelOrderResModel }
     *     
     */
    public CancelOrderResModel getOut() {
        return out;
    }

    /**
     * 设置out属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link CancelOrderResModel }
     *     
     */
    public void setOut(CancelOrderResModel value) {
        this.out = value;
    }

}