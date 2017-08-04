
package com.hoau.how.module.itf.server.ws.claim;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>findByClaimsPicResponse complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="findByClaimsPicResponse"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="return" type="{http://hoauweb.ws.erry.com/}responseQueryFiles" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "findByClaimsPicResponse", propOrder = {
    "_return"
})
public class FindByClaimsPicResponse {

    @XmlElement(name = "return")
    protected ResponseQueryFiles _return;

    /**
     * 获取return属性的值。
     * 
     * @return
     *     possible object is
     *     {@link ResponseQueryFiles }
     *     
     */
    public ResponseQueryFiles getReturn() {
        return _return;
    }

    /**
     * 设置return属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link ResponseQueryFiles }
     *     
     */
    public void setReturn(ResponseQueryFiles value) {
        this._return = value;
    }

}
