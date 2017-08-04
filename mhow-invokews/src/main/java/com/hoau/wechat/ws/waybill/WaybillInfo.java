
package com.hoau.wechat.ws.waybill;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>waybillInfo complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="waybillInfo">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.hoau.net/services/QuerySignInfoServices}resBaseVo">
 *       &lt;sequence>
 *         &lt;element name="CYRQZ" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DDQD" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DSHKE" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *         &lt;element name="FKFS" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="HJJE" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *         &lt;element name="HWMC" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="JS" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="KDSJ" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="QTYD" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SHRDZ" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SHRLXDH1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SHRLXR" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SHRMC" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SHRSJ" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SOHFS" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TJ" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *         &lt;element name="TYRDZ" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TYRLXDH1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TYRLXR" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TYRMC" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TYRQ" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TYRSJ" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="YDBH" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="YDZT" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ZL" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "waybillInfo", propOrder = {
    "cyrqz",
    "ddqd",
    "dshke",
    "fkfs",
    "hjje",
    "hwmc",
    "js",
    "kdsj",
    "qtyd",
    "shrdz",
    "shrlxdh1",
    "shrlxr",
    "shrmc",
    "shrsj",
    "sohfs",
    "tj",
    "tyrdz",
    "tyrlxdh1",
    "tyrlxr",
    "tyrmc",
    "tyrq",
    "tyrsj",
    "ydbh",
    "ydzt",
    "zl"
})
public class WaybillInfo
    extends ResBaseVo
{

    @XmlElement(name = "CYRQZ")
    protected String cyrqz;
    @XmlElement(name = "DDQD")
    protected String ddqd;
    @XmlElement(name = "DSHKE")
    protected float dshke;
    @XmlElement(name = "FKFS")
    protected String fkfs;
    @XmlElement(name = "HJJE")
    protected float hjje;
    @XmlElement(name = "HWMC")
    protected String hwmc;
    @XmlElement(name = "JS")
    protected int js;
    @XmlElement(name = "KDSJ")
    protected String kdsj;
    @XmlElement(name = "QTYD")
    protected String qtyd;
    @XmlElement(name = "SHRDZ")
    protected String shrdz;
    @XmlElement(name = "SHRLXDH1")
    protected String shrlxdh1;
    @XmlElement(name = "SHRLXR")
    protected String shrlxr;
    @XmlElement(name = "SHRMC")
    protected String shrmc;
    @XmlElement(name = "SHRSJ")
    protected String shrsj;
    @XmlElement(name = "SOHFS")
    protected String sohfs;
    @XmlElement(name = "TJ")
    protected float tj;
    @XmlElement(name = "TYRDZ")
    protected String tyrdz;
    @XmlElement(name = "TYRLXDH1")
    protected String tyrlxdh1;
    @XmlElement(name = "TYRLXR")
    protected String tyrlxr;
    @XmlElement(name = "TYRMC")
    protected String tyrmc;
    @XmlElement(name = "TYRQ")
    protected String tyrq;
    @XmlElement(name = "TYRSJ")
    protected String tyrsj;
    @XmlElement(name = "YDBH")
    protected String ydbh;
    @XmlElement(name = "YDZT")
    protected String ydzt;
    @XmlElement(name = "ZL")
    protected float zl;

    /**
     * 获取cyrqz属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCYRQZ() {
        return cyrqz;
    }

    /**
     * 设置cyrqz属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCYRQZ(String value) {
        this.cyrqz = value;
    }

    /**
     * 获取ddqd属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDDQD() {
        return ddqd;
    }

    /**
     * 设置ddqd属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDDQD(String value) {
        this.ddqd = value;
    }

    /**
     * 获取dshke属性的值。
     * 
     */
    public float getDSHKE() {
        return dshke;
    }

    /**
     * 设置dshke属性的值。
     * 
     */
    public void setDSHKE(float value) {
        this.dshke = value;
    }

    /**
     * 获取fkfs属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFKFS() {
        return fkfs;
    }

    /**
     * 设置fkfs属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFKFS(String value) {
        this.fkfs = value;
    }

    /**
     * 获取hjje属性的值。
     * 
     */
    public float getHJJE() {
        return hjje;
    }

    /**
     * 设置hjje属性的值。
     * 
     */
    public void setHJJE(float value) {
        this.hjje = value;
    }

    /**
     * 获取hwmc属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHWMC() {
        return hwmc;
    }

    /**
     * 设置hwmc属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHWMC(String value) {
        this.hwmc = value;
    }

    /**
     * 获取js属性的值。
     * 
     */
    public int getJS() {
        return js;
    }

    /**
     * 设置js属性的值。
     * 
     */
    public void setJS(int value) {
        this.js = value;
    }

    /**
     * 获取kdsj属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getKDSJ() {
        return kdsj;
    }

    /**
     * 设置kdsj属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setKDSJ(String value) {
        this.kdsj = value;
    }

    /**
     * 获取qtyd属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getQTYD() {
        return qtyd;
    }

    /**
     * 设置qtyd属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setQTYD(String value) {
        this.qtyd = value;
    }

    /**
     * 获取shrdz属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSHRDZ() {
        return shrdz;
    }

    /**
     * 设置shrdz属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSHRDZ(String value) {
        this.shrdz = value;
    }

    /**
     * 获取shrlxdh1属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSHRLXDH1() {
        return shrlxdh1;
    }

    /**
     * 设置shrlxdh1属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSHRLXDH1(String value) {
        this.shrlxdh1 = value;
    }

    /**
     * 获取shrlxr属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSHRLXR() {
        return shrlxr;
    }

    /**
     * 设置shrlxr属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSHRLXR(String value) {
        this.shrlxr = value;
    }

    /**
     * 获取shrmc属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSHRMC() {
        return shrmc;
    }

    /**
     * 设置shrmc属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSHRMC(String value) {
        this.shrmc = value;
    }

    /**
     * 获取shrsj属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSHRSJ() {
        return shrsj;
    }

    /**
     * 设置shrsj属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSHRSJ(String value) {
        this.shrsj = value;
    }

    /**
     * 获取sohfs属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSOHFS() {
        return sohfs;
    }

    /**
     * 设置sohfs属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSOHFS(String value) {
        this.sohfs = value;
    }

    /**
     * 获取tj属性的值。
     * 
     */
    public float getTJ() {
        return tj;
    }

    /**
     * 设置tj属性的值。
     * 
     */
    public void setTJ(float value) {
        this.tj = value;
    }

    /**
     * 获取tyrdz属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTYRDZ() {
        return tyrdz;
    }

    /**
     * 设置tyrdz属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTYRDZ(String value) {
        this.tyrdz = value;
    }

    /**
     * 获取tyrlxdh1属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTYRLXDH1() {
        return tyrlxdh1;
    }

    /**
     * 设置tyrlxdh1属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTYRLXDH1(String value) {
        this.tyrlxdh1 = value;
    }

    /**
     * 获取tyrlxr属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTYRLXR() {
        return tyrlxr;
    }

    /**
     * 设置tyrlxr属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTYRLXR(String value) {
        this.tyrlxr = value;
    }

    /**
     * 获取tyrmc属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTYRMC() {
        return tyrmc;
    }

    /**
     * 设置tyrmc属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTYRMC(String value) {
        this.tyrmc = value;
    }

    /**
     * 获取tyrq属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTYRQ() {
        return tyrq;
    }

    /**
     * 设置tyrq属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTYRQ(String value) {
        this.tyrq = value;
    }

    /**
     * 获取tyrsj属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTYRSJ() {
        return tyrsj;
    }

    /**
     * 设置tyrsj属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTYRSJ(String value) {
        this.tyrsj = value;
    }

    /**
     * 获取ydbh属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getYDBH() {
        return ydbh;
    }

    /**
     * 设置ydbh属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setYDBH(String value) {
        this.ydbh = value;
    }

    /**
     * 获取ydzt属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getYDZT() {
        return ydzt;
    }

    /**
     * 设置ydzt属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setYDZT(String value) {
        this.ydzt = value;
    }

    /**
     * 获取zl属性的值。
     * 
     */
    public float getZL() {
        return zl;
    }

    /**
     * 设置zl属性的值。
     * 
     */
    public void setZL(float value) {
        this.zl = value;
    }

}
