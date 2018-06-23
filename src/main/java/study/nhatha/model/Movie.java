
package study.nhatha.model;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * <p>Java class for anonymous complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="title" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="year" type="{http://www.w3.org/2001/XMLSchema}unsignedShort"/>
 *         &lt;element name="genre" type="{http://www.w3.org/2001/XMLSchema}token"/>
 *         &lt;element name="body" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="country" type="{http://www.w3.org/2001/XMLSchema}token"/>
 *         &lt;element name="duration" type="{http://www.w3.org/2001/XMLSchema}unsignedShort"/>
 *         &lt;element name="director" type="{http://www.w3.org/2001/XMLSchema}token"/>
 *         &lt;element name="rating" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="plot" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="stars" type="{http://www.w3.org/2001/XMLSchema}token"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "id",
    "title",
    "year",
    "genre",
    "body",
    "country",
    "duration",
    "director",
    "rating",
    "plot",
    "stars"
})
@XmlRootElement(name = "movie")
@Entity
@Table(name = "movie", catalog = "moviedb")
public class Movie implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  protected long id;
  @XmlElement(required = true)
  protected String title;
  @XmlSchemaType(name = "unsignedShort")
  protected int year;
  @XmlElement(required = true)
  @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
  @XmlSchemaType(name = "token")
  protected String genre;
  @XmlElement(required = true)
  protected String body;
  @XmlElement(required = true)
  @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
  @XmlSchemaType(name = "token")
  protected String country;
  @XmlSchemaType(name = "unsignedShort")
  protected int duration;
  @XmlElement(required = true)
  @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
  @XmlSchemaType(name = "token")
  protected String director;
  @XmlElement(required = true)
  protected BigDecimal rating;
  @XmlElement(required = true)
  protected String plot;
  @XmlElement(required = true)
  @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
  @XmlSchemaType(name = "token")
  protected String stars;

  /**
   * Gets the value of the id property.
   *
   */
  public long getId() {
    return id;
  }

  /**
   * Sets the value of the id property.
   *
   */
  public void setId(long value) {
    this.id = value;
  }

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
   * Gets the value of the year property.
   *
   */
  public int getYear() {
    return year;
  }

  /**
   * Sets the value of the year property.
   *
   */
  public void setYear(int value) {
    this.year = value;
  }

  /**
   * Gets the value of the genre property.
   *
   * @return
   *     possible object is
   *     {@link String }
   *
   */
  public String getGenre() {
    return genre;
  }

  /**
   * Sets the value of the genre property.
   *
   * @param value
   *     allowed object is
   *     {@link String }
   *
   */
  public void setGenre(String value) {
    this.genre = value;
  }

  /**
   * Gets the value of the body property.
   *
   * @return
   *     possible object is
   *     {@link String }
   *
   */
  public String getBody() {
    return body;
  }

  /**
   * Sets the value of the body property.
   *
   * @param value
   *     allowed object is
   *     {@link String }
   *
   */
  public void setBody(String value) {
    this.body = value;
  }

  /**
   * Gets the value of the country property.
   *
   * @return
   *     possible object is
   *     {@link String }
   *
   */
  public String getCountry() {
    return country;
  }

  /**
   * Sets the value of the country property.
   *
   * @param value
   *     allowed object is
   *     {@link String }
   *
   */
  public void setCountry(String value) {
    this.country = value;
  }

  /**
   * Gets the value of the duration property.
   *
   */
  public int getDuration() {
    return duration;
  }

  /**
   * Sets the value of the duration property.
   *
   */
  public void setDuration(int value) {
    this.duration = value;
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
   * Gets the value of the rating property.
   *
   * @return
   *     possible object is
   *     {@link BigDecimal }
   *
   */
  public BigDecimal getRating() {
    return rating;
  }

  /**
   * Sets the value of the rating property.
   *
   * @param value
   *     allowed object is
   *     {@link BigDecimal }
   *
   */
  public void setRating(BigDecimal value) {
    this.rating = value;
  }

  /**
   * Gets the value of the plot property.
   *
   * @return
   *     possible object is
   *     {@link String }
   *
   */
  public String getPlot() {
    return plot;
  }

  /**
   * Sets the value of the plot property.
   *
   * @param value
   *     allowed object is
   *     {@link String }
   *
   */
  public void setPlot(String value) {
    this.plot = value;
  }

  /**
   * Gets the value of the stars property.
   *
   * @return
   *     possible object is
   *     {@link String }
   *
   */
  public String getStars() {
    return stars;
  }

  /**
   * Sets the value of the stars property.
   *
   * @param value
   *     allowed object is
   *     {@link String }
   *
   */
  public void setStars(String value) {
    this.stars = value;
  }

}
