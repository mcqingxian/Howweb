
package com.hoau.wechat.ws.wt;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>ArrayOfDistrictModel complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="ArrayOfDistrictModel">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="DistrictModel" type="{http://model.district.interfaces.sinotrans.com}DistrictModel" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfDistrictModel", namespace = "http://model.district.interfaces.sinotrans.com", propOrder = {
    "districtModel"
})
public class ArrayOfDistrictModel {

    @XmlElement(name = "DistrictModel", nillable = true)
    protected List<DistrictModel> districtModel;

    /**
     * Gets the value of the districtModel property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the districtModel property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDistrictModel().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DistrictModel }
     * 
     * 
     */
    public List<DistrictModel> getDistrictModel() {
        if (districtModel == null) {
            districtModel = new ArrayList<DistrictModel>();
        }
        return this.districtModel;
    }

}
