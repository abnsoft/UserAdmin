/**
 * Copyright 2015. <br>
 * <br>
 * Project ..... UserAdmin<br>
 * <br>
 * Author ...... AnNik<br>
 * E-Mail ...... ABN.DEV@mail.ru<br>
 * Created ..... 17 февр. 2015 г.<br>
 * <br>
 */
package abc.def.data.model;

import java.io.Serializable;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * Addresses of person. <br />
 * One person can has many addresses. In that time many persons can live in one address (family).
 * 
 * @author annik
 *
 */
@Entity
@Table( name = "ADDRESS", uniqueConstraints = {@UniqueConstraint( columnNames = {"country", "city", "street",
        "housenum"} )}, indexes = {} )
public class Address implements Serializable {

    private static final long serialVersionUID = 1L;

    /*
     * Address ID.
     */
    @Id
    @GeneratedValue( strategy = GenerationType.AUTO )
    private long id;

    /*
     * Name of country.
     */
    @Column( length = 128 )
    private String country;

    /*
     * Name of city.
     */
    @Column( length = 64 )
    private String city;

    /*
     * Name of street.
     */
    @Column( length = 64 )
    private String street;

    /*
     * Number of house.
     */
    @Column( name = "housenum" )
    private Integer houseNumber;

    /*
     * Users who live at this Address.
     */
    @ManyToMany( fetch = FetchType.LAZY, mappedBy = "addresses" )
    public Set<Person> persons = new HashSet<Person>( 0 );

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
    public Set<Person> getPersons() {

        return Collections.unmodifiableSet( persons );
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
    public void setPersons( Set<Person> personCollection ) {

        this.persons = personCollection;
    }

    /*
     * (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {

        return String.format( "Address [id=%s, country=%s, city=%s, street=%s, houseNumber=%s, {person}]",
                id, country, city, street, houseNumber );
    }

    /**
     * 
     */
    public void addPerson( Person person ) {

        //assumes equals and hashcode implemented: avoid circular calls
        if ( !persons.contains( person ) ) {
            persons.add( person );

            //add method to Product : sets 'other side' of association
            person.addAddress( this );
        }
    }

    /**
     * 
     */
    public void removePerson( Person person ) {

        //assumes equals and hashcode implemented: avoid circular calls
        if ( !persons.contains( person ) ) {
            persons.remove( person );
        }

        //add method to Product : sets 'other side' of association
        person.removeAddress( this );
    }

    /*
     * (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {

        final int prime = 31;
        int result = 1;
        result = prime * result + (int) ( id ^ ( id >>> 32 ) );
        return result;
    }

    /*
     * (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals( Object obj ) {

        if ( this == obj ) return true;
        if ( obj == null ) return false;
        if ( getClass() != obj.getClass() ) return false;
        Address other = (Address) obj;
        if ( id != other.id ) return false;
        return true;
    }

}
