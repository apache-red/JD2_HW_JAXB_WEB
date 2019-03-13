
package com.redcompany.red.jaxbcategory.ref.entity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for movie_type complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="movie_type">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="title" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="director" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="date_of_issue" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *         &lt;element name="news_body" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *       &lt;attribute name="id" use="required" type="{http://www.w3.org/2001/XMLSchema}int" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "movie_type", propOrder = {
    "title",
    "director",
    "dateOfIssue",
    "newsBody"
})
public class MovieType {

    @XmlElement(required = true)
    protected String title;
    @XmlElement(required = true)
    protected String director;
    @XmlElement(name = "date_of_issue", required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar dateOfIssue;
    @XmlElement(name = "news_body", required = true)
    protected String newsBody;
    @XmlAttribute(required = true)
    protected int id;

    /**
     * Gets the value of the title property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets the value of the title property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTitle(String value) {
        this.title = value;
    }

    /**
     * Gets the value of the director property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDirector() {
        return director;
    }

    /**
     * Sets the value of the director property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDirector(String value) {
        this.director = value;
    }

    /**
     * Gets the value of the dateOfIssue property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDateOfIssue() {
        return dateOfIssue;
    }

    /**
     * Sets the value of the dateOfIssue property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDateOfIssue(XMLGregorianCalendar value) {
        this.dateOfIssue = value;
    }

    /**
     * Gets the value of the newsBody property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNewsBody() {
        return newsBody;
    }

    /**
     * Sets the value of the newsBody property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNewsBody(String value) {
        this.newsBody = value;
    }

    /**
     * Gets the value of the id property.
     * 
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     */
    public void setId(int value) {
        this.id = value;
    }

}
