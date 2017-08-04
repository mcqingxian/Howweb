
package com.hoau.mhow.invokews.server.ws.omsorder;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>ArrayOfCustOrderReqModel complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="ArrayOfCustOrderReqModel">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="CustOrderReqModel" type="{http://model.customer.interfaces.sinotrans.com}CustOrderReqModel" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfCustOrderReqModel", propOrder = {
    "custOrderReqModel"
})
public class ArrayOfCustOrderReqModel {

    @XmlElement(name = "CustOrderReqModel", nillable = true)
    protected List<CustOrderReqModel> custOrderReqModel;

    /**
     * Gets the value of the custOrderReqModel property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the custOrderReqModel property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCustOrderReqModel().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CustOrderReqModel }
     * 
     * 
     */
    public List<CustOrderReqModel> getCustOrderReqModel() {
        if (custOrderReqModel == null) {
            custOrderReqModel = new ArrayList<CustOrderReqModel>();
        }
        return this.custOrderReqModel;
    }

}
