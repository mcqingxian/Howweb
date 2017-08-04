
package com.hoau.wechat.ws.oms;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>PhoneOrderReqModel complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="PhoneOrderReqModel">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="cargoName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="cargoNumber" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="cargoVolume" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="cargoWeight" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="collDeliveryAmount" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="consigneeAddress" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="consigneeAreaCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="consigneeCity" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="consigneeCompanyName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="consigneeEbrgNameCn" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="consigneeMethod" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="consigneeMobile" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="consigneeName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="consigneeProv" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="consigneeTel" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="escoSecondCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="escoSecondName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="orderId" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="orderNo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="orderOrign" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="orderVer" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="productType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="remark" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="shipperAddress" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="shipperAreaCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="shipperCity" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="shipperCompanyName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="shipperEbrgNameCn" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="shipperMethod" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="shipperMobile" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="shipperName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="shipperProv" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="shipperTel" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="smsNotify" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="userId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PhoneOrderReqModel", propOrder = {
    "cargoName",
    "cargoNumber",
    "cargoVolume",
    "cargoWeight",
    "collDeliveryAmount",
    "consigneeAddress",
    "consigneeAreaCode",
    "consigneeCity",
    "consigneeCompanyName",
    "consigneeEbrgNameCn",
    "consigneeMethod",
    "consigneeMobile",
    "consigneeName",
    "consigneeProv",
    "consigneeTel",
    "escoSecondCode",
    "escoSecondName",
    "orderId",
    "orderNo",
    "orderOrign",
    "orderVer",
    "productType",
    "remark",
    "shipperAddress",
    "shipperAreaCode",
    "shipperCity",
    "shipperCompanyName",
    "shipperEbrgNameCn",
    "shipperMethod",
    "shipperMobile",
    "shipperName",
    "shipperProv",
    "shipperTel",
    "smsNotify",
    "userId"
})
public class PhoneOrderReqModel {

    @XmlElementRef(name = "cargoName", namespace = "http://model.mobile.interfaces.sinotrans.com", type = JAXBElement.class)
    protected JAXBElement<String> cargoName;
    @XmlElementRef(name = "cargoNumber", namespace = "http://model.mobile.interfaces.sinotrans.com", type = JAXBElement.class)
    protected JAXBElement<Double> cargoNumber;
    @XmlElementRef(name = "cargoVolume", namespace = "http://model.mobile.interfaces.sinotrans.com", type = JAXBElement.class)
    protected JAXBElement<Double> cargoVolume;
    @XmlElementRef(name = "cargoWeight", namespace = "http://model.mobile.interfaces.sinotrans.com", type = JAXBElement.class)
    protected JAXBElement<Double> cargoWeight;
    @XmlElementRef(name = "collDeliveryAmount", namespace = "http://model.mobile.interfaces.sinotrans.com", type = JAXBElement.class)
    protected JAXBElement<Double> collDeliveryAmount;
    @XmlElementRef(name = "consigneeAddress", namespace = "http://model.mobile.interfaces.sinotrans.com", type = JAXBElement.class)
    protected JAXBElement<String> consigneeAddress;
    @XmlElementRef(name = "consigneeAreaCode", namespace = "http://model.mobile.interfaces.sinotrans.com", type = JAXBElement.class)
    protected JAXBElement<String> consigneeAreaCode;
    @XmlElementRef(name = "consigneeCity", namespace = "http://model.mobile.interfaces.sinotrans.com", type = JAXBElement.class)
    protected JAXBElement<String> consigneeCity;
    @XmlElementRef(name = "consigneeCompanyName", namespace = "http://model.mobile.interfaces.sinotrans.com", type = JAXBElement.class)
    protected JAXBElement<String> consigneeCompanyName;
    @XmlElementRef(name = "consigneeEbrgNameCn", namespace = "http://model.mobile.interfaces.sinotrans.com", type = JAXBElement.class)
    protected JAXBElement<String> consigneeEbrgNameCn;
    @XmlElementRef(name = "consigneeMethod", namespace = "http://model.mobile.interfaces.sinotrans.com", type = JAXBElement.class)
    protected JAXBElement<String> consigneeMethod;
    @XmlElementRef(name = "consigneeMobile", namespace = "http://model.mobile.interfaces.sinotrans.com", type = JAXBElement.class)
    protected JAXBElement<String> consigneeMobile;
    @XmlElementRef(name = "consigneeName", namespace = "http://model.mobile.interfaces.sinotrans.com", type = JAXBElement.class)
    protected JAXBElement<String> consigneeName;
    @XmlElementRef(name = "consigneeProv", namespace = "http://model.mobile.interfaces.sinotrans.com", type = JAXBElement.class)
    protected JAXBElement<String> consigneeProv;
    @XmlElementRef(name = "consigneeTel", namespace = "http://model.mobile.interfaces.sinotrans.com", type = JAXBElement.class)
    protected JAXBElement<String> consigneeTel;
    @XmlElementRef(name = "escoSecondCode", namespace = "http://model.mobile.interfaces.sinotrans.com", type = JAXBElement.class)
    protected JAXBElement<String> escoSecondCode;
    @XmlElementRef(name = "escoSecondName", namespace = "http://model.mobile.interfaces.sinotrans.com", type = JAXBElement.class)
    protected JAXBElement<String> escoSecondName;
    @XmlElementRef(name = "orderId", namespace = "http://model.mobile.interfaces.sinotrans.com", type = JAXBElement.class)
    protected JAXBElement<Integer> orderId;
    @XmlElementRef(name = "orderNo", namespace = "http://model.mobile.interfaces.sinotrans.com", type = JAXBElement.class)
    protected JAXBElement<String> orderNo;
    @XmlElementRef(name = "orderOrign", namespace = "http://model.mobile.interfaces.sinotrans.com", type = JAXBElement.class)
    protected JAXBElement<String> orderOrign;
    @XmlElementRef(name = "orderVer", namespace = "http://model.mobile.interfaces.sinotrans.com", type = JAXBElement.class)
    protected JAXBElement<Integer> orderVer;
    @XmlElementRef(name = "productType", namespace = "http://model.mobile.interfaces.sinotrans.com", type = JAXBElement.class)
    protected JAXBElement<String> productType;
    @XmlElementRef(name = "remark", namespace = "http://model.mobile.interfaces.sinotrans.com", type = JAXBElement.class)
    protected JAXBElement<String> remark;
    @XmlElementRef(name = "shipperAddress", namespace = "http://model.mobile.interfaces.sinotrans.com", type = JAXBElement.class)
    protected JAXBElement<String> shipperAddress;
    @XmlElementRef(name = "shipperAreaCode", namespace = "http://model.mobile.interfaces.sinotrans.com", type = JAXBElement.class)
    protected JAXBElement<String> shipperAreaCode;
    @XmlElementRef(name = "shipperCity", namespace = "http://model.mobile.interfaces.sinotrans.com", type = JAXBElement.class)
    protected JAXBElement<String> shipperCity;
    @XmlElementRef(name = "shipperCompanyName", namespace = "http://model.mobile.interfaces.sinotrans.com", type = JAXBElement.class)
    protected JAXBElement<String> shipperCompanyName;
    @XmlElementRef(name = "shipperEbrgNameCn", namespace = "http://model.mobile.interfaces.sinotrans.com", type = JAXBElement.class)
    protected JAXBElement<String> shipperEbrgNameCn;
    @XmlElementRef(name = "shipperMethod", namespace = "http://model.mobile.interfaces.sinotrans.com", type = JAXBElement.class)
    protected JAXBElement<String> shipperMethod;
    @XmlElementRef(name = "shipperMobile", namespace = "http://model.mobile.interfaces.sinotrans.com", type = JAXBElement.class)
    protected JAXBElement<String> shipperMobile;
    @XmlElementRef(name = "shipperName", namespace = "http://model.mobile.interfaces.sinotrans.com", type = JAXBElement.class)
    protected JAXBElement<String> shipperName;
    @XmlElementRef(name = "shipperProv", namespace = "http://model.mobile.interfaces.sinotrans.com", type = JAXBElement.class)
    protected JAXBElement<String> shipperProv;
    @XmlElementRef(name = "shipperTel", namespace = "http://model.mobile.interfaces.sinotrans.com", type = JAXBElement.class)
    protected JAXBElement<String> shipperTel;
    @XmlElementRef(name = "smsNotify", namespace = "http://model.mobile.interfaces.sinotrans.com", type = JAXBElement.class)
    protected JAXBElement<String> smsNotify;
    @XmlElementRef(name = "userId", namespace = "http://model.mobile.interfaces.sinotrans.com", type = JAXBElement.class)
    protected JAXBElement<String> userId;

    /**
     * 获取cargoName属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getCargoName() {
        return cargoName;
    }

    /**
     * 设置cargoName属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setCargoName(JAXBElement<String> value) {
        this.cargoName = value;
    }

    /**
     * 获取cargoNumber属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Double }{@code >}
     *     
     */
    public JAXBElement<Double> getCargoNumber() {
        return cargoNumber;
    }

    /**
     * 设置cargoNumber属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Double }{@code >}
     *     
     */
    public void setCargoNumber(JAXBElement<Double> value) {
        this.cargoNumber = value;
    }

    /**
     * 获取cargoVolume属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Double }{@code >}
     *     
     */
    public JAXBElement<Double> getCargoVolume() {
        return cargoVolume;
    }

    /**
     * 设置cargoVolume属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Double }{@code >}
     *     
     */
    public void setCargoVolume(JAXBElement<Double> value) {
        this.cargoVolume = value;
    }

    /**
     * 获取cargoWeight属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Double }{@code >}
     *     
     */
    public JAXBElement<Double> getCargoWeight() {
        return cargoWeight;
    }

    /**
     * 设置cargoWeight属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Double }{@code >}
     *     
     */
    public void setCargoWeight(JAXBElement<Double> value) {
        this.cargoWeight = value;
    }

    /**
     * 获取collDeliveryAmount属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Double }{@code >}
     *     
     */
    public JAXBElement<Double> getCollDeliveryAmount() {
        return collDeliveryAmount;
    }

    /**
     * 设置collDeliveryAmount属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Double }{@code >}
     *     
     */
    public void setCollDeliveryAmount(JAXBElement<Double> value) {
        this.collDeliveryAmount = value;
    }

    /**
     * 获取consigneeAddress属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getConsigneeAddress() {
        return consigneeAddress;
    }

    /**
     * 设置consigneeAddress属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setConsigneeAddress(JAXBElement<String> value) {
        this.consigneeAddress = value;
    }

    /**
     * 获取consigneeAreaCode属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getConsigneeAreaCode() {
        return consigneeAreaCode;
    }

    /**
     * 设置consigneeAreaCode属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setConsigneeAreaCode(JAXBElement<String> value) {
        this.consigneeAreaCode = value;
    }

    /**
     * 获取consigneeCity属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getConsigneeCity() {
        return consigneeCity;
    }

    /**
     * 设置consigneeCity属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setConsigneeCity(JAXBElement<String> value) {
        this.consigneeCity = value;
    }

    /**
     * 获取consigneeCompanyName属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getConsigneeCompanyName() {
        return consigneeCompanyName;
    }

    /**
     * 设置consigneeCompanyName属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setConsigneeCompanyName(JAXBElement<String> value) {
        this.consigneeCompanyName = value;
    }

    /**
     * 获取consigneeEbrgNameCn属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getConsigneeEbrgNameCn() {
        return consigneeEbrgNameCn;
    }

    /**
     * 设置consigneeEbrgNameCn属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setConsigneeEbrgNameCn(JAXBElement<String> value) {
        this.consigneeEbrgNameCn = value;
    }

    /**
     * 获取consigneeMethod属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getConsigneeMethod() {
        return consigneeMethod;
    }

    /**
     * 设置consigneeMethod属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setConsigneeMethod(JAXBElement<String> value) {
        this.consigneeMethod = value;
    }

    /**
     * 获取consigneeMobile属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getConsigneeMobile() {
        return consigneeMobile;
    }

    /**
     * 设置consigneeMobile属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setConsigneeMobile(JAXBElement<String> value) {
        this.consigneeMobile = value;
    }

    /**
     * 获取consigneeName属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getConsigneeName() {
        return consigneeName;
    }

    /**
     * 设置consigneeName属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setConsigneeName(JAXBElement<String> value) {
        this.consigneeName = value;
    }

    /**
     * 获取consigneeProv属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getConsigneeProv() {
        return consigneeProv;
    }

    /**
     * 设置consigneeProv属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setConsigneeProv(JAXBElement<String> value) {
        this.consigneeProv = value;
    }

    /**
     * 获取consigneeTel属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getConsigneeTel() {
        return consigneeTel;
    }

    /**
     * 设置consigneeTel属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setConsigneeTel(JAXBElement<String> value) {
        this.consigneeTel = value;
    }

    /**
     * 获取escoSecondCode属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getEscoSecondCode() {
        return escoSecondCode;
    }

    /**
     * 设置escoSecondCode属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setEscoSecondCode(JAXBElement<String> value) {
        this.escoSecondCode = value;
    }

    /**
     * 获取escoSecondName属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getEscoSecondName() {
        return escoSecondName;
    }

    /**
     * 设置escoSecondName属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setEscoSecondName(JAXBElement<String> value) {
        this.escoSecondName = value;
    }

    /**
     * 获取orderId属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Integer }{@code >}
     *     
     */
    public JAXBElement<Integer> getOrderId() {
        return orderId;
    }

    /**
     * 设置orderId属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Integer }{@code >}
     *     
     */
    public void setOrderId(JAXBElement<Integer> value) {
        this.orderId = value;
    }

    /**
     * 获取orderNo属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getOrderNo() {
        return orderNo;
    }

    /**
     * 设置orderNo属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setOrderNo(JAXBElement<String> value) {
        this.orderNo = value;
    }

    /**
     * 获取orderOrign属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getOrderOrign() {
        return orderOrign;
    }

    /**
     * 设置orderOrign属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setOrderOrign(JAXBElement<String> value) {
        this.orderOrign = value;
    }

    /**
     * 获取orderVer属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Integer }{@code >}
     *     
     */
    public JAXBElement<Integer> getOrderVer() {
        return orderVer;
    }

    /**
     * 设置orderVer属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Integer }{@code >}
     *     
     */
    public void setOrderVer(JAXBElement<Integer> value) {
        this.orderVer = value;
    }

    /**
     * 获取productType属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getProductType() {
        return productType;
    }

    /**
     * 设置productType属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setProductType(JAXBElement<String> value) {
        this.productType = value;
    }

    /**
     * 获取remark属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getRemark() {
        return remark;
    }

    /**
     * 设置remark属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setRemark(JAXBElement<String> value) {
        this.remark = value;
    }

    /**
     * 获取shipperAddress属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getShipperAddress() {
        return shipperAddress;
    }

    /**
     * 设置shipperAddress属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setShipperAddress(JAXBElement<String> value) {
        this.shipperAddress = value;
    }

    /**
     * 获取shipperAreaCode属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getShipperAreaCode() {
        return shipperAreaCode;
    }

    /**
     * 设置shipperAreaCode属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setShipperAreaCode(JAXBElement<String> value) {
        this.shipperAreaCode = value;
    }

    /**
     * 获取shipperCity属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getShipperCity() {
        return shipperCity;
    }

    /**
     * 设置shipperCity属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setShipperCity(JAXBElement<String> value) {
        this.shipperCity = value;
    }

    /**
     * 获取shipperCompanyName属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getShipperCompanyName() {
        return shipperCompanyName;
    }

    /**
     * 设置shipperCompanyName属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setShipperCompanyName(JAXBElement<String> value) {
        this.shipperCompanyName = value;
    }

    /**
     * 获取shipperEbrgNameCn属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getShipperEbrgNameCn() {
        return shipperEbrgNameCn;
    }

    /**
     * 设置shipperEbrgNameCn属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setShipperEbrgNameCn(JAXBElement<String> value) {
        this.shipperEbrgNameCn = value;
    }

    /**
     * 获取shipperMethod属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getShipperMethod() {
        return shipperMethod;
    }

    /**
     * 设置shipperMethod属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setShipperMethod(JAXBElement<String> value) {
        this.shipperMethod = value;
    }

    /**
     * 获取shipperMobile属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getShipperMobile() {
        return shipperMobile;
    }

    /**
     * 设置shipperMobile属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setShipperMobile(JAXBElement<String> value) {
        this.shipperMobile = value;
    }

    /**
     * 获取shipperName属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getShipperName() {
        return shipperName;
    }

    /**
     * 设置shipperName属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setShipperName(JAXBElement<String> value) {
        this.shipperName = value;
    }

    /**
     * 获取shipperProv属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getShipperProv() {
        return shipperProv;
    }

    /**
     * 设置shipperProv属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setShipperProv(JAXBElement<String> value) {
        this.shipperProv = value;
    }

    /**
     * 获取shipperTel属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getShipperTel() {
        return shipperTel;
    }

    /**
     * 设置shipperTel属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setShipperTel(JAXBElement<String> value) {
        this.shipperTel = value;
    }

    /**
     * 获取smsNotify属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getSmsNotify() {
        return smsNotify;
    }

    /**
     * 设置smsNotify属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setSmsNotify(JAXBElement<String> value) {
        this.smsNotify = value;
    }

    /**
     * 获取userId属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getUserId() {
        return userId;
    }

    /**
     * 设置userId属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setUserId(JAXBElement<String> value) {
        this.userId = value;
    }

}
