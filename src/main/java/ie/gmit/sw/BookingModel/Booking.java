//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2018.12.09 at 03:32:53 PM GMT 
//


package ie.gmit.sw.BookingModel;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 * 				Booking Schema
 * 			
 * 
 * <p>Java class for Booking complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Booking">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="customerID" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="bookingStartDate" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="bookingEndDate" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="carRegistration" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Booking", propOrder = {
    "customerID",
    "bookingStartDate",
    "bookingEndDate",
    "carRegistration"
})
public class Booking {

    protected int customerID;
    @XmlElement(required = true)
    protected String bookingStartDate;
    @XmlElement(required = true)
    protected String bookingEndDate;
    protected int carRegistration;

    /**
     * Gets the value of the customerID property.
     * 
     */
    public int getCustomerID() {
        return customerID;
    }

    /**
     * Sets the value of the customerID property.
     * 
     */
    public void setCustomerID(int value) {
        this.customerID = value;
    }

    /**
     * Gets the value of the bookingStartDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBookingStartDate() {
        return bookingStartDate;
    }

    /**
     * Sets the value of the bookingStartDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBookingStartDate(String value) {
        this.bookingStartDate = value;
    }

    /**
     * Gets the value of the bookingEndDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBookingEndDate() {
        return bookingEndDate;
    }

    /**
     * Sets the value of the bookingEndDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBookingEndDate(String value) {
        this.bookingEndDate = value;
    }

    /**
     * Gets the value of the carRegistration property.
     * 
     */
    public int getCarRegistration() {
        return carRegistration;
    }

    /**
     * Sets the value of the carRegistration property.
     * 
     */
    public void setCarRegistration(int value) {
        this.carRegistration = value;
    }

}
