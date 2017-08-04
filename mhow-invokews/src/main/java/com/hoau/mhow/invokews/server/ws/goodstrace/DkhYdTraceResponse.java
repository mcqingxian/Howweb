
package com.hoau.mhow.invokews.server.ws.goodstrace;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>dkhYdTraceResponse complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="dkhYdTraceResponse">
 *   &lt;complexContent>
 *     &lt;extension base="{http://ws.datamanagement.barcode.hoau.com/}response">
 *       &lt;sequence>
 *         &lt;element name="ydTraces" type="{http://ws.datamanagement.barcode.hoau.com/}dkhYdTrace" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "dkhYdTraceResponse", propOrder = {
    "ydTraces"
})
public class DkhYdTraceResponse
    extends Response
{

    @XmlElement(nillable = true)
    protected List<DkhYdTrace> ydTraces;

    /**
     * Gets the value of the ydTraces property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the ydTraces property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getYdTraces().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DkhYdTrace }
     * 
     * 
     */
    public List<DkhYdTrace> getYdTraces() {
        if (ydTraces == null) {
            ydTraces = new ArrayList<DkhYdTrace>();
        }
        return this.ydTraces;
    }

}
