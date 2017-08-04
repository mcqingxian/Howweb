
package com.hoau.mhow.invokews.server.ws.dcpricetime;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>priceQueryVo complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="priceQueryVo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="collDeliveryAmount" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="conCity" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="conCounty" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="insurance" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="productTypeId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="shipperCity" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="shipperCounty" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="volumn" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="weight" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "priceQueryVo", propOrder = {
    "collDeliveryAmount",
    "conCity",
    "conCounty",
    "insurance",
    "productTypeId",
    "shipperCity",
    "shipperCounty",
    "volumn",
    "weight"
})
public class PriceQueryVo {

    protected Double collDeliveryAmount;
    protected String conCity;
    protected String conCounty;
    protected Double insurance;
    protected String productTypeId;
    protected String shipperCity;
    protected String shipperCounty;
    protected Double volumn;
    protected Double weight;

    /**
     * 获取collDeliveryAmount属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getCollDeliveryAmount() {
        return collDeliveryAmount;
    }

    /**
     * 设置collDeliveryAmount属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setCollDeliveryAmount(Double value) {
        this.collDeliveryAmount = value;
    }

    /**
     * 获取conCity属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getConCity() {
        return conCity;
    }

    /**
     * 设置conCity属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setConCity(String value) {
        this.conCity = value;
    }

    /**
     * 获取conCounty属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getConCounty() {
        return conCounty;
    }

    /**
     * 设置conCounty属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setConCounty(String value) {
        this.conCounty = value;
    }

    /**
     * 获取insurance属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getInsurance() {
        return insurance;
    }

    /**
     * 设置insurance属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setInsurance(Double value) {
        this.insurance = value;
    }

    /**
     * 获取productTypeId属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProductTypeId() {
        return productTypeId;
    }

    /**
     * 设置productTypeId属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProductTypeId(String value) {
        this.productTypeId = value;
    }

    /**
     * 获取shipperCity属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getShipperCity() {
        return shipperCity;
    }

    /**
     * 设置shipperCity属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setShipperCity(String value) {
        this.shipperCity = value;
    }

    /**
     * 获取shipperCounty属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getShipperCounty() {
        return shipperCounty;
    }

    /**
     * 设置shipperCounty属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setShipperCounty(String value) {
        this.shipperCounty = value;
    }

    /**
     * 获取volumn属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getVolumn() {
        return volumn;
    }

    /**
     * 设置volumn属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setVolumn(Double value) {
        this.volumn = value;
    }

    /**
     * 获取weight属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getWeight() {
        return weight;
    }

    /**
     * 设置weight属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setWeight(Double value) {
        this.weight = value;
    }

}
