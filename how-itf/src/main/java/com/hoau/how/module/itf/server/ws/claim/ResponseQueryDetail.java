
package com.hoau.how.module.itf.server.ws.claim;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>responseQueryDetail complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="responseQueryDetail"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://hoauweb.ws.erry.com/}responseClaimsObject"&gt;
 *       &lt;sequence&gt;
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
@XmlType(name = "responseQueryDetail", propOrder = {
    "queryClaimsInfo"
})
public class ResponseQueryDetail
    extends ResponseClaimsObject
{

    protected QueryClaimsInfo queryClaimsInfo;

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
