
package com.hoau.mhow.invokews.server.ws.omsorder;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>ArrayOfCustCargoModel complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="ArrayOfCustCargoModel">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="CustCargoModel" type="{http://model.customer.interfaces.sinotrans.com}CustCargoModel" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfCustCargoModel", propOrder = {
    "custCargoModel"
})
public class ArrayOfCustCargoModel {

    @XmlElement(name = "CustCargoModel", nillable = true)
    protected List<CustCargoModel> custCargoModel;

    /**
     * Gets the value of the custCargoModel property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the custCargoModel property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCustCargoModel().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CustCargoModel }
     * 
     * 
     */
    public List<CustCargoModel> getCustCargoModel() {
        if (custCargoModel == null) {
            custCargoModel = new ArrayList<CustCargoModel>();
        }
        return this.custCargoModel;
    }

}
