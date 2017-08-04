
package com.hoau.wechat.ws.wt;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>DistrictModel complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="DistrictModel">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="districtCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="districtName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="districtType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="hotCity" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="pinyin" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="total" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DistrictModel", namespace = "http://model.district.interfaces.sinotrans.com", propOrder = {
    "districtCode",
    "districtName",
    "districtType",
    "hotCity",
    "pinyin",
    "total"
})
public class DistrictModel {

    @XmlElementRef(name = "districtCode", namespace = "http://model.district.interfaces.sinotrans.com", type = JAXBElement.class)
    protected JAXBElement<String> districtCode;
    @XmlElementRef(name = "districtName", namespace = "http://model.district.interfaces.sinotrans.com", type = JAXBElement.class)
    protected JAXBElement<String> districtName;
    @XmlElementRef(name = "districtType", namespace = "http://model.district.interfaces.sinotrans.com", type = JAXBElement.class)
    protected JAXBElement<String> districtType;
    @XmlElementRef(name = "hotCity", namespace = "http://model.district.interfaces.sinotrans.com", type = JAXBElement.class)
    protected JAXBElement<String> hotCity;
    @XmlElementRef(name = "pinyin", namespace = "http://model.district.interfaces.sinotrans.com", type = JAXBElement.class)
    protected JAXBElement<String> pinyin;
    @XmlElementRef(name = "total", namespace = "http://model.district.interfaces.sinotrans.com", type = JAXBElement.class)
    protected JAXBElement<Integer> total;

    /**
     * 获取districtCode属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getDistrictCode() {
        return districtCode;
    }

    /**
     * 设置districtCode属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setDistrictCode(JAXBElement<String> value) {
        this.districtCode = value;
    }

    /**
     * 获取districtName属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getDistrictName() {
        return districtName;
    }

    /**
     * 设置districtName属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setDistrictName(JAXBElement<String> value) {
        this.districtName = value;
    }

    /**
     * 获取districtType属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getDistrictType() {
        return districtType;
    }

    /**
     * 设置districtType属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setDistrictType(JAXBElement<String> value) {
        this.districtType = value;
    }

    /**
     * 获取hotCity属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getHotCity() {
        return hotCity;
    }

    /**
     * 设置hotCity属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setHotCity(JAXBElement<String> value) {
        this.hotCity = value;
    }

    /**
     * 获取pinyin属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getPinyin() {
        return pinyin;
    }

    /**
     * 设置pinyin属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setPinyin(JAXBElement<String> value) {
        this.pinyin = value;
    }

    /**
     * 获取total属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Integer }{@code >}
     *     
     */
    public JAXBElement<Integer> getTotal() {
        return total;
    }

    /**
     * 设置total属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Integer }{@code >}
     *     
     */
    public void setTotal(JAXBElement<Integer> value) {
        this.total = value;
    }

}
