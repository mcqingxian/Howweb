
package com.hoau.how.module.itf.server.ws.bank;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for accountCity complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="accountCity">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="accountCityCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="accountCityName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "accountCity", propOrder = {
    "accountCityCode",
    "accountCityName"
})
public class AccountCity {

    protected String accountCityCode;
    protected String accountCityName;

    /**
     * Gets the value of the accountCityCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAccountCityCode() {
        return accountCityCode;
    }

    /**
     * Sets the value of the accountCityCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAccountCityCode(String value) {
        this.accountCityCode = value;
    }

    /**
     * Gets the value of the accountCityName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAccountCityName() {
        return accountCityName;
    }

    /**
     * Sets the value of the accountCityName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAccountCityName(String value) {
        this.accountCityName = value;
    }

}
