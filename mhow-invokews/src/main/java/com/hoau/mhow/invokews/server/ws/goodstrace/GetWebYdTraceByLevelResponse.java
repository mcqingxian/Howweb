
package com.hoau.mhow.invokews.server.ws.goodstrace;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>getWebYdTraceByLevelResponse complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="getWebYdTraceByLevelResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="return" type="{http://ws.datamanagement.barcode.hoau.com/}ydTraceResponse" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getWebYdTraceByLevelResponse", propOrder = {
    "_return"
})
public class GetWebYdTraceByLevelResponse {

    @XmlElement(name = "return")
    protected YdTraceResponse _return;

    /**
     * 获取return属性的值。
     * 
     * @return
     *     possible object is
     *     {@link YdTraceResponse }
     *     
     */
    public YdTraceResponse getReturn() {
        return _return;
    }

    /**
     * 设置return属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link YdTraceResponse }
     *     
     */
    public void setReturn(YdTraceResponse value) {
        this._return = value;
    }

}
