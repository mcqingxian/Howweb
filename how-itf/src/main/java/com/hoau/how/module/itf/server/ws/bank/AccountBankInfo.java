
package com.hoau.how.module.itf.server.ws.bank;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for accountBankInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="accountBankInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="accountBankInfoCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="accountBankInfoName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "accountBankInfo", propOrder = {
    "accountBankInfoCode",
    "accountBankInfoName"
})
public class AccountBankInfo {

    protected String accountBankInfoCode;
    protected String accountBankInfoName;

    /**
     * Gets the value of the accountBankInfoCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAccountBankInfoCode() {
        return accountBankInfoCode;
    }

    /**
     * Sets the value of the accountBankInfoCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAccountBankInfoCode(String value) {
        this.accountBankInfoCode = value;
    }

    /**
     * Gets the value of the accountBankInfoName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAccountBankInfoName() {
        return accountBankInfoName;
    }

    /**
     * Sets the value of the accountBankInfoName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAccountBankInfoName(String value) {
        this.accountBankInfoName = value;
    }

}
