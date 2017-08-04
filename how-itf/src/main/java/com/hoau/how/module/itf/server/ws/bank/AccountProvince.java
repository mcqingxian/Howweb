
package com.hoau.how.module.itf.server.ws.bank;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for accountProvince complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="accountProvince">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="accountProvinceCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="accountProvinceName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "accountProvince", propOrder = {
    "accountProvinceCode",
    "accountProvinceName"
})
public class AccountProvince {

    protected String accountProvinceCode;
    protected String accountProvinceName;

    /**
     * Gets the value of the accountProvinceCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAccountProvinceCode() {
        return accountProvinceCode;
    }

    /**
     * Sets the value of the accountProvinceCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAccountProvinceCode(String value) {
        this.accountProvinceCode = value;
    }

    /**
     * Gets the value of the accountProvinceName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAccountProvinceName() {
        return accountProvinceName;
    }

    /**
     * Sets the value of the accountProvinceName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAccountProvinceName(String value) {
        this.accountProvinceName = value;
    }

}
