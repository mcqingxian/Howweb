
package com.hoau.mhow.invokews.server.ws.omsorder;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>TrackInfoDtlModel complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="TrackInfoDtlModel">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="trackDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="trackDesc" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="trackPlace" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TrackInfoDtlModel", propOrder = {
    "trackDate",
    "trackDesc",
    "trackPlace"
})
public class TrackInfoDtlModel {

    @XmlElementRef(name = "trackDate", namespace = "http://model.customer.interfaces.sinotrans.com", type = JAXBElement.class)
    protected JAXBElement<String> trackDate;
    @XmlElementRef(name = "trackDesc", namespace = "http://model.customer.interfaces.sinotrans.com", type = JAXBElement.class)
    protected JAXBElement<String> trackDesc;
    @XmlElementRef(name = "trackPlace", namespace = "http://model.customer.interfaces.sinotrans.com", type = JAXBElement.class)
    protected JAXBElement<String> trackPlace;

    /**
     * 获取trackDate属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getTrackDate() {
        return trackDate;
    }

    /**
     * 设置trackDate属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setTrackDate(JAXBElement<String> value) {
        this.trackDate = value;
    }

    /**
     * 获取trackDesc属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getTrackDesc() {
        return trackDesc;
    }

    /**
     * 设置trackDesc属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setTrackDesc(JAXBElement<String> value) {
        this.trackDesc = value;
    }

    /**
     * 获取trackPlace属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getTrackPlace() {
        return trackPlace;
    }

    /**
     * 设置trackPlace属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setTrackPlace(JAXBElement<String> value) {
        this.trackPlace = value;
    }

}
