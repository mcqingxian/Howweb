
package com.hoau.how.module.itf.server.ws.claim;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>uploadClaims complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="uploadClaims"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="claimsInfo" type="{http://hoauweb.ws.erry.com/}claimsInfo" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "uploadClaims", propOrder = {
    "claimsInfo"
})
public class UploadClaims {

    protected ClaimsInfo claimsInfo;

    /**
     * 获取claimsInfo属性的值。
     * 
     * @return
     *     possible object is
     *     {@link ClaimsInfo }
     *     
     */
    public ClaimsInfo getClaimsInfo() {
        return claimsInfo;
    }

    /**
     * 设置claimsInfo属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link ClaimsInfo }
     *     
     */
    public void setClaimsInfo(ClaimsInfo value) {
        this.claimsInfo = value;
    }

}
