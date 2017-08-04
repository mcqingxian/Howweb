
package com.hoau.how.module.itf.server.ws.claim;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>queryClaimsDetail complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="queryClaimsDetail">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="bankCardFiles" type="{http://www.w3.org/2001/XMLSchema}base64Binary" minOccurs="0"/>
 *         &lt;element name="bankCardPicFiles" type="{http://www.w3.org/2001/XMLSchema}base64Binary" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="billNo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="cargoReceiptFiles" type="{http://www.w3.org/2001/XMLSchema}base64Binary" minOccurs="0"/>
 *         &lt;element name="cargoReceiptPicFiles" type="{http://www.w3.org/2001/XMLSchema}base64Binary" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="claimOrderFiles" type="{http://www.w3.org/2001/XMLSchema}base64Binary" minOccurs="0"/>
 *         &lt;element name="claimOrderPicFiles" type="{http://www.w3.org/2001/XMLSchema}base64Binary" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="claimsNo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="damageFiles" type="{http://www.w3.org/2001/XMLSchema}base64Binary" minOccurs="0"/>
 *         &lt;element name="damagePicFiles" type="{http://www.w3.org/2001/XMLSchema}base64Binary" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="identificationCardFiles" type="{http://www.w3.org/2001/XMLSchema}base64Binary" minOccurs="0"/>
 *         &lt;element name="identificationCardPicFiles" type="{http://www.w3.org/2001/XMLSchema}base64Binary" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="invoiceFiles" type="{http://www.w3.org/2001/XMLSchema}base64Binary" minOccurs="0"/>
 *         &lt;element name="invoicePicFiles" type="{http://www.w3.org/2001/XMLSchema}base64Binary" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="payeeName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="shippingOrderFiles" type="{http://www.w3.org/2001/XMLSchema}base64Binary" minOccurs="0"/>
 *         &lt;element name="shippingOrderPicFiles" type="{http://www.w3.org/2001/XMLSchema}base64Binary" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "queryClaimsDetail", propOrder = {
    "bankCardFiles",
    "bankCardPicFiles",
    "billNo",
    "cargoReceiptFiles",
    "cargoReceiptPicFiles",
    "claimOrderFiles",
    "claimOrderPicFiles",
    "claimsNo",
    "damageFiles",
    "damagePicFiles",
    "identificationCardFiles",
    "identificationCardPicFiles",
    "invoiceFiles",
    "invoicePicFiles",
    "payeeName",
    "shippingOrderFiles",
    "shippingOrderPicFiles"
})
public class QueryClaimsDetail {

    protected byte[] bankCardFiles;
    @XmlElement(nillable = true)
    protected List<byte[]> bankCardPicFiles;
    protected String billNo;
    protected byte[] cargoReceiptFiles;
    @XmlElement(nillable = true)
    protected List<byte[]> cargoReceiptPicFiles;
    protected byte[] claimOrderFiles;
    @XmlElement(nillable = true)
    protected List<byte[]> claimOrderPicFiles;
    protected String claimsNo;
    protected byte[] damageFiles;
    @XmlElement(nillable = true)
    protected List<byte[]> damagePicFiles;
    protected byte[] identificationCardFiles;
    @XmlElement(nillable = true)
    protected List<byte[]> identificationCardPicFiles;
    protected byte[] invoiceFiles;
    @XmlElement(nillable = true)
    protected List<byte[]> invoicePicFiles;
    protected String payeeName;
    protected byte[] shippingOrderFiles;
    @XmlElement(nillable = true)
    protected List<byte[]> shippingOrderPicFiles;

    /**
     * 获取bankCardFiles属性的值。
     * 
     * @return
     *     possible object is
     *     byte[]
     */
    public byte[] getBankCardFiles() {
        return bankCardFiles;
    }

    /**
     * 设置bankCardFiles属性的值。
     * 
     * @param value
     *     allowed object is
     *     byte[]
     */
    public void setBankCardFiles(byte[] value) {
        this.bankCardFiles = value;
    }

    /**
     * Gets the value of the bankCardPicFiles property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the bankCardPicFiles property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBankCardPicFiles().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * byte[]
     * 
     */
    public List<byte[]> getBankCardPicFiles() {
        if (bankCardPicFiles == null) {
            bankCardPicFiles = new ArrayList<byte[]>();
        }
        return this.bankCardPicFiles;
    }

    /**
     * 获取billNo属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBillNo() {
        return billNo;
    }

    /**
     * 设置billNo属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBillNo(String value) {
        this.billNo = value;
    }

    /**
     * 获取cargoReceiptFiles属性的值。
     * 
     * @return
     *     possible object is
     *     byte[]
     */
    public byte[] getCargoReceiptFiles() {
        return cargoReceiptFiles;
    }

    /**
     * 设置cargoReceiptFiles属性的值。
     * 
     * @param value
     *     allowed object is
     *     byte[]
     */
    public void setCargoReceiptFiles(byte[] value) {
        this.cargoReceiptFiles = value;
    }

    /**
     * Gets the value of the cargoReceiptPicFiles property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the cargoReceiptPicFiles property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCargoReceiptPicFiles().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * byte[]
     * 
     */
    public List<byte[]> getCargoReceiptPicFiles() {
        if (cargoReceiptPicFiles == null) {
            cargoReceiptPicFiles = new ArrayList<byte[]>();
        }
        return this.cargoReceiptPicFiles;
    }

    /**
     * 获取claimOrderFiles属性的值。
     * 
     * @return
     *     possible object is
     *     byte[]
     */
    public byte[] getClaimOrderFiles() {
        return claimOrderFiles;
    }

    /**
     * 设置claimOrderFiles属性的值。
     * 
     * @param value
     *     allowed object is
     *     byte[]
     */
    public void setClaimOrderFiles(byte[] value) {
        this.claimOrderFiles = value;
    }

    /**
     * Gets the value of the claimOrderPicFiles property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the claimOrderPicFiles property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getClaimOrderPicFiles().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * byte[]
     * 
     */
    public List<byte[]> getClaimOrderPicFiles() {
        if (claimOrderPicFiles == null) {
            claimOrderPicFiles = new ArrayList<byte[]>();
        }
        return this.claimOrderPicFiles;
    }

    /**
     * 获取claimsNo属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getClaimsNo() {
        return claimsNo;
    }

    /**
     * 设置claimsNo属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setClaimsNo(String value) {
        this.claimsNo = value;
    }

    /**
     * 获取damageFiles属性的值。
     * 
     * @return
     *     possible object is
     *     byte[]
     */
    public byte[] getDamageFiles() {
        return damageFiles;
    }

    /**
     * 设置damageFiles属性的值。
     * 
     * @param value
     *     allowed object is
     *     byte[]
     */
    public void setDamageFiles(byte[] value) {
        this.damageFiles = value;
    }

    /**
     * Gets the value of the damagePicFiles property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the damagePicFiles property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDamagePicFiles().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * byte[]
     * 
     */
    public List<byte[]> getDamagePicFiles() {
        if (damagePicFiles == null) {
            damagePicFiles = new ArrayList<byte[]>();
        }
        return this.damagePicFiles;
    }

    /**
     * 获取identificationCardFiles属性的值。
     * 
     * @return
     *     possible object is
     *     byte[]
     */
    public byte[] getIdentificationCardFiles() {
        return identificationCardFiles;
    }

    /**
     * 设置identificationCardFiles属性的值。
     * 
     * @param value
     *     allowed object is
     *     byte[]
     */
    public void setIdentificationCardFiles(byte[] value) {
        this.identificationCardFiles = value;
    }

    /**
     * Gets the value of the identificationCardPicFiles property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the identificationCardPicFiles property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getIdentificationCardPicFiles().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * byte[]
     * 
     */
    public List<byte[]> getIdentificationCardPicFiles() {
        if (identificationCardPicFiles == null) {
            identificationCardPicFiles = new ArrayList<byte[]>();
        }
        return this.identificationCardPicFiles;
    }

    /**
     * 获取invoiceFiles属性的值。
     * 
     * @return
     *     possible object is
     *     byte[]
     */
    public byte[] getInvoiceFiles() {
        return invoiceFiles;
    }

    /**
     * 设置invoiceFiles属性的值。
     * 
     * @param value
     *     allowed object is
     *     byte[]
     */
    public void setInvoiceFiles(byte[] value) {
        this.invoiceFiles = value;
    }

    /**
     * Gets the value of the invoicePicFiles property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the invoicePicFiles property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getInvoicePicFiles().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * byte[]
     * 
     */
    public List<byte[]> getInvoicePicFiles() {
        if (invoicePicFiles == null) {
            invoicePicFiles = new ArrayList<byte[]>();
        }
        return this.invoicePicFiles;
    }

    /**
     * 获取payeeName属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPayeeName() {
        return payeeName;
    }

    /**
     * 设置payeeName属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPayeeName(String value) {
        this.payeeName = value;
    }

    /**
     * 获取shippingOrderFiles属性的值。
     * 
     * @return
     *     possible object is
     *     byte[]
     */
    public byte[] getShippingOrderFiles() {
        return shippingOrderFiles;
    }

    /**
     * 设置shippingOrderFiles属性的值。
     * 
     * @param value
     *     allowed object is
     *     byte[]
     */
    public void setShippingOrderFiles(byte[] value) {
        this.shippingOrderFiles = value;
    }

    /**
     * Gets the value of the shippingOrderPicFiles property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the shippingOrderPicFiles property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getShippingOrderPicFiles().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * byte[]
     * 
     */
    public List<byte[]> getShippingOrderPicFiles() {
        if (shippingOrderPicFiles == null) {
            shippingOrderPicFiles = new ArrayList<byte[]>();
        }
        return this.shippingOrderPicFiles;
    }

}
