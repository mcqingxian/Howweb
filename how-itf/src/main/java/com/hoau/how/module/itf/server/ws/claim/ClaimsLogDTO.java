
package com.hoau.how.module.itf.server.ws.claim;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>claimsLogDTO complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="claimsLogDTO"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="oprDay" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="oprPerson" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="oprRemark" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="oprTime" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="oprType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="oprTypeDesc" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "claimsLogDTO", propOrder = {
    "oprDay",
    "oprPerson",
    "oprRemark",
    "oprTime",
    "oprType",
    "oprTypeDesc"
})
public class ClaimsLogDTO {

    protected String oprDay;
    protected String oprPerson;
    protected String oprRemark;
    protected String oprTime;
    protected String oprType;
    protected String oprTypeDesc;

    /**
     * 获取oprDay属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOprDay() {
        return oprDay;
    }

    /**
     * 设置oprDay属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOprDay(String value) {
        this.oprDay = value;
    }

    /**
     * 获取oprPerson属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOprPerson() {
        return oprPerson;
    }

    /**
     * 设置oprPerson属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOprPerson(String value) {
        this.oprPerson = value;
    }

    /**
     * 获取oprRemark属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOprRemark() {
        return oprRemark;
    }

    /**
     * 设置oprRemark属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOprRemark(String value) {
        this.oprRemark = value;
    }

    /**
     * 获取oprTime属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOprTime() {
        return oprTime;
    }

    /**
     * 设置oprTime属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOprTime(String value) {
        this.oprTime = value;
    }

    /**
     * 获取oprType属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOprType() {
        return oprType;
    }

    /**
     * 设置oprType属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOprType(String value) {
        this.oprType = value;
    }

    /**
     * 获取oprTypeDesc属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOprTypeDesc() {
        return oprTypeDesc;
    }

    /**
     * 设置oprTypeDesc属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOprTypeDesc(String value) {
        this.oprTypeDesc = value;
    }

}
