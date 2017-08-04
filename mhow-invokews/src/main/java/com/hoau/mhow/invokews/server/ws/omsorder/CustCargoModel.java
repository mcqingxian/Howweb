
package com.hoau.mhow.invokews.server.ws.omsorder;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>CustCargoModel complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="CustCargoModel">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="cargoGrossWeight" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="cargoName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="cargoNo" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="cargoNumber" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="cargoVolume" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CustCargoModel", propOrder = {
    "cargoGrossWeight",
    "cargoName",
    "cargoNo",
    "cargoNumber",
    "cargoVolume"
})
public class CustCargoModel {

    @XmlElementRef(name = "cargoGrossWeight", namespace = "http://model.customer.interfaces.sinotrans.com", type = JAXBElement.class)
    protected JAXBElement<Double> cargoGrossWeight;
    @XmlElementRef(name = "cargoName", namespace = "http://model.customer.interfaces.sinotrans.com", type = JAXBElement.class)
    protected JAXBElement<String> cargoName;
    @XmlElementRef(name = "cargoNo", namespace = "http://model.customer.interfaces.sinotrans.com", type = JAXBElement.class)
    protected JAXBElement<Integer> cargoNo;
    @XmlElementRef(name = "cargoNumber", namespace = "http://model.customer.interfaces.sinotrans.com", type = JAXBElement.class)
    protected JAXBElement<Integer> cargoNumber;
    @XmlElementRef(name = "cargoVolume", namespace = "http://model.customer.interfaces.sinotrans.com", type = JAXBElement.class)
    protected JAXBElement<Double> cargoVolume;

    /**
     * 获取cargoGrossWeight属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Double }{@code >}
     *     
     */
    public JAXBElement<Double> getCargoGrossWeight() {
        return cargoGrossWeight;
    }

    /**
     * 设置cargoGrossWeight属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Double }{@code >}
     *     
     */
    public void setCargoGrossWeight(JAXBElement<Double> value) {
        this.cargoGrossWeight = value;
    }

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
     * 获取cargoNo属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Integer }{@code >}
     *     
     */
    public JAXBElement<Integer> getCargoNo() {
        return cargoNo;
    }

    /**
     * 设置cargoNo属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Integer }{@code >}
     *     
     */
    public void setCargoNo(JAXBElement<Integer> value) {
        this.cargoNo = value;
    }

    /**
     * 获取cargoNumber属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Integer }{@code >}
     *     
     */
    public JAXBElement<Integer> getCargoNumber() {
        return cargoNumber;
    }

    /**
     * 设置cargoNumber属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Integer }{@code >}
     *     
     */
    public void setCargoNumber(JAXBElement<Integer> value) {
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

}
