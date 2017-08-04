
package com.hoau.how.module.itf.server.ws.claim;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>responseQueryClaims complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="responseQueryClaims"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://hoauweb.ws.erry.com/}responseClaimsObject"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="queryClaimsInfos" type="{http://hoauweb.ws.erry.com/}queryClaimsInfo" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "responseQueryClaims", propOrder = {
    "queryClaimsInfos"
})
public class ResponseQueryClaims
    extends ResponseClaimsObject
{

    @XmlElement(nillable = true)
    protected List<QueryClaimsInfo> queryClaimsInfos;

    /**
     * Gets the value of the queryClaimsInfos property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the queryClaimsInfos property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getQueryClaimsInfos().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link QueryClaimsInfo }
     * 
     * 
     */
    public List<QueryClaimsInfo> getQueryClaimsInfos() {
        if (queryClaimsInfos == null) {
            queryClaimsInfos = new ArrayList<QueryClaimsInfo>();
        }
        return this.queryClaimsInfos;
    }

}
