
package com.soap.consumer.wsdl;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for calElements complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="calElements">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="firstNumber" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="secondNumber" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "calElements", propOrder = {
    "firstNumber",
    "secondNumber"
})
public class CalElements {

    protected int firstNumber;
    protected int secondNumber;

    /**
     * Gets the value of the firstNumber property.
     * 
     */
    public int getFirstNumber() {
        return firstNumber;
    }

    /**
     * Sets the value of the firstNumber property.
     * 
     */
    public void setFirstNumber(int value) {
        this.firstNumber = value;
    }

    /**
     * Gets the value of the secondNumber property.
     * 
     */
    public int getSecondNumber() {
        return secondNumber;
    }

    /**
     * Sets the value of the secondNumber property.
     * 
     */
    public void setSecondNumber(int value) {
        this.secondNumber = value;
    }

}
