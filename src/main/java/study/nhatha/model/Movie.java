
package study.nhatha.model;

import javax.persistence.*;
import javax.xml.bind.annotation.*;
import java.io.Serializable;
import java.math.BigDecimal;


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
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="title" type="{}NonEmptyString"/>
 *         &lt;element name="year" type="{http://www.w3.org/2001/XMLSchema}unsignedShort"/>
 *         &lt;element name="genre" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="country" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="duration" type="{http://www.w3.org/2001/XMLSchema}unsignedShort"/>
 *         &lt;element name="director" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="rating" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="plot" type="{}NonEmptyString"/>
 *         &lt;element name="stars" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="image" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="url" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
    "country",
    "duration",
    "director",
    "rating",
    "plot",
    "stars",
    "image",
    "url"
})
@XmlRootElement(name = "movie")
@Entity
@Table(name = "movie", catalog = "moviedb")
public class Movie implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  protected Long id;

  @XmlElement(required = true)
  @Column(columnDefinition = "text")
  protected String title;

  @XmlSchemaType(name = "unsignedShort")
  protected int year;

  @XmlElement(required = true)
  @Column(columnDefinition = "text")
  protected String genre;

  @XmlElement(required = true)
  @Column(columnDefinition = "text")
  protected String country;

  @XmlElement(required = true, type = Integer.class, nillable = true)
  @XmlSchemaType(name = "unsignedShort")
  protected Integer duration;

  @XmlElement(required = true)
  @Column(columnDefinition = "text")
  protected String director;

  @XmlElement(required = true, nillable = true)
  protected BigDecimal rating;

  @XmlElement(required = true)
  @Column(columnDefinition = "text")
  protected String plot;

  @XmlElement(required = true)
  @Column(columnDefinition = "text")
  protected String stars;

  @XmlElement(required = true)
  @Column(columnDefinition = "text")
  protected String image;

  @Column(columnDefinition = "text")
  @XmlElement(required = true, nillable = true)
  protected String url;

  /**
   * Gets the value of the id property.
   *
   * @return
   *     possible object is
   *     {@link Long }
   *
   */
  public Long getId() {
    return id;
  }

  /**
   * Sets the value of the id property.
   *
   * @param value
   *     allowed object is
   *     {@link Long }
   *
   */
  public void setId(Long value) {
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
   * @return
   *     possible object is
   *     {@link Integer }
   *
   */
  public Integer getDuration() {
    return duration;
  }

  /**
   * Sets the value of the duration property.
   *
   * @param value
   *     allowed object is
   *     {@link Integer }
   *
   */
  public void setDuration(Integer value) {
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

  /**
   * Gets the value of the image property.
   *
   * @return
   *     possible object is
   *     {@link String }
   *
   */
  public String getImage() {
    return image;
  }

  /**
   * Sets the value of the image property.
   *
   * @param value
   *     allowed object is
   *     {@link String }
   *
   */
  public void setImage(String value) {
    this.image = value;
  }

  /**
   * Gets the value of the url property.
   *
   * @return
   *     possible object is
   *     {@link String }
   *
   */
  public String getUrl() {
    return url;
  }

  /**
   * Sets the value of the url property.
   *
   * @param value
   *     allowed object is
   *     {@link String }
   *
   */
  public void setUrl(String value) {
    this.url = value;
  }

}
