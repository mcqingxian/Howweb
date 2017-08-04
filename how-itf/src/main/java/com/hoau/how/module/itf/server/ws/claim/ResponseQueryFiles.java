
package com.hoau.how.module.itf.server.ws.claim;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>responseQueryFiles complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="responseQueryFiles"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://hoauweb.ws.erry.com/}responseClaimsObject"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="queryClaimsDetail" type="{http://hoauweb.ws.erry.com/}queryClaimsDetail" minOccurs="0"/&gt;
 *         &lt;element name="queryClaimsInfo" type="{http://hoauweb.ws.erry.com/}queryClaimsInfo" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "responseQueryFiles", propOrder = {
    "queryClaimsDetail",
    "queryClaimsInfo"
})
public class ResponseQueryFiles
    extends ResponseClaimsObject
{

    protected QueryClaimsDetail queryClaimsDetail;
    protected QueryClaimsInfo queryClaimsInfo;

    /**
     * 获取queryClaimsDetail属性的值。
     * 
     * @return
     *     possible object is
     *     {@link QueryClaimsDetail }
     *     
     */
    public QueryClaimsDetail getQueryClaimsDetail() {
        return queryClaimsDetail;
    }

    /**
     * 设置queryClaimsDetail属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link QueryClaimsDetail }
     *     
     */
    public void setQueryClaimsDetail(QueryClaimsDetail value) {
        this.queryClaimsDetail = value;
    }

    /**
     * 获取queryClaimsInfo属性的值。
     * 
     * @return
     *     possible object is
     *     {@link QueryClaimsInfo }
     *     
     */
    public QueryClaimsInfo getQueryClaimsInfo() {
        return queryClaimsInfo;
    }

    /**
     * 设置queryClaimsInfo属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link QueryClaimsInfo }
     *     
     */
    public void setQueryClaimsInfo(QueryClaimsInfo value) {
        this.queryClaimsInfo = value;
    }

}
