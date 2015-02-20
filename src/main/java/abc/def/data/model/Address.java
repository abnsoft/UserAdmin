/**
 * Copyright 2015. ABN Software. All Rights reserved.<br>
 * <br>
 * Homepage .... http://www.ABNsoft.info<br>
 * <br>
 * Project ..... UserAdmin<br>
 * <br>
 * Author ...... AnNik<br>
 * E-Mail ...... ABN.DEV@mail.ru<br>
 * Created ..... 17 февр. 2015 г.<br>
 * <br>
 */
package abc.def.data.model;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * @author annik
 *
 */
@Entity
@Table( name = "ADDRESS" )
public class Address {

    @Id
    @GeneratedValue( strategy = GenerationType.AUTO )
    private long id;

    @Column( length = 128 )
    private String country;

    @Column( length = 64 )
    private String city;

    @Column( length = 64 )
    private String street;

    @Column( name = "housenum" )
    private Integer houseNumber;

    @ManyToMany( mappedBy = "addressCollection" )
    public Collection<Person> personCollection;

    /**
     * Getter.
     * 
     * @return the id
     */
    public long getId() {

        return id;
    }

    /**
     * Getter.
     * 
     * @return the country
     */
    public String getCountry() {

        return country;
    }

    /**
     * Getter.
     * 
     * @return the city
     */
    public String getCity() {

        return city;
    }

    /**
     * Getter.
     * 
     * @return the street
     */
    public String getStreet() {

        return street;
    }

    /**
     * Getter.
     * 
     * @return the houseNumber
     */
    public Integer getHouseNumber() {

        return houseNumber;
    }

    /**
     * Getter.
     * 
     * @return the personCollection
     */
    public Collection<Person> getPersonCollection() {

        return personCollection;
    }

    /**
     * Setter.
     * 
     * @param id
     *            the id to set
     */
    public void setId( long id ) {

        this.id = id;
    }

    /**
     * Setter.
     * 
     * @param country
     *            the country to set
     */
    public void setCountry( String country ) {

        this.country = country;
    }

    /**
     * Setter.
     * 
     * @param city
     *            the city to set
     */
    public void setCity( String city ) {

        this.city = city;
    }

    /**
     * Setter.
     * 
     * @param street
     *            the street to set
     */
    public void setStreet( String street ) {

        this.street = street;
    }

    /**
     * Setter.
     * 
     * @param houseNumber
     *            the houseNumber to set
     */
    public void setHouseNumber( Integer houseNumber ) {

        this.houseNumber = houseNumber;
    }

    /**
     * Setter.
     * 
     * @param personCollection
     *            the personCollection to set
     */
    public void setPersonCollection( Collection<Person> personCollection ) {

        this.personCollection = personCollection;
    }

}
