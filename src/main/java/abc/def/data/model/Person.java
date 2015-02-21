/**
 * Copyright 2015. ABN Software. All Rights reserved.<br>
 * <br>
 * Homepage .... http://www.ABNsoft.info<br>
 * <br>
 * Project ..... UserAdmin<br>
 * <br>
 * Author ...... AnNik<br>
 * E-Mail ...... ABN.DEV@mail.ru<br>
 * Created ..... 17 ����. 2015 �.<br>
 * <br>
 */
package abc.def.data.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
import org.hibernate.type.TrueFalseType;
import org.hibernate.type.YesNoType;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;

/**
 * @author annik
 *
 */
@Entity
@Table( name = "PERSON" )
public class Person implements Serializable {

    private static final long serialVersionUID = 1L;

    /*
     * ID of person.
     */
    @Id
    @GeneratedValue( strategy = GenerationType.AUTO )
    private long id;

    /*
     * email and used as login of person.
     */
    @Column( name = "email", length = 128, nullable = false, unique = true )
    private String email;
    
    /*
     * Fullname of person.
     */
    @Column( name = "fullname", length = 128, nullable = true )
    private String fullName;

    /*
     * Person`s password. It is stored as encrypted value. Nobody know this value except person. There used
     * Spring encryption mechanism. Look at the
     */
    @Column( name = "password", length = 128, nullable = false )
    private String password;

    /*
     * 
     */
    @Column( name = "role", length = 16, nullable = false )
    private String role;

    @Column( name = "timezone", nullable = false )
    private int timezone;

    @Column( name = "created", nullable = false )
    @Type( type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime" )
    private DateTime created;

    @Column( name = "updated", nullable = false )
    @Type( type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime" )
    private DateTime updated;

    @Column( name = "isenabled", nullable = false )
    @Type( type = "true_false" )
    private boolean enabled;

    /*
     * Addresses of person. One person can has many addresses. In that time many persons can live in one
     * address (family).
     */
    @ManyToMany( fetch = FetchType.LAZY, cascade = CascadeType.ALL )
    @JoinTable( name = "PERSON_ADDRESS", joinColumns = @JoinColumn( name = "personid",
            referencedColumnName = "id" ), inverseJoinColumns = @JoinColumn( name = "addressid",
            referencedColumnName = "id" ) )
    private Set<Address> addresses;

    /**
     * closed Contructor. Need for JPA.
     */
    protected Person() {

    }

    /**
     * Public Contructor.
     * 
     * @param fullName
     * @param email
     * @param role
     * @param timezone
     * @param created
     * @param udated
     */
    public Person( String fullName, String email, String password, String role, int timezone,
            DateTime created, DateTime udated, boolean enabled ) {

        this.fullName = fullName;
        this.email = email;
        this.password = password;
        this.role = role;
        this.timezone = timezone;
        this.created = created;
        updated = udated;
        this.enabled = enabled;
    }

    /**
     * Public Contructor without enabled status field. By default user is DISABLED here.
     * 
     * @param fullName
     * @param email
     * @param role
     * @param timezone
     * @param created
     * @param udated
     */
    public Person( String fullName, String email, String password, String role, int timezone,
            DateTime created, DateTime udated ) {

        this.fullName = fullName;
        this.email = email;
        this.password = password;
        this.role = role;
        this.timezone = timezone;
        this.created = created;
        updated = udated;
        this.enabled = false;
    }

    /*
     * (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {

        return String.format(
                "Person [id=%s, fullName=%s, email=%s, password=%s, role=%s, timezone=%s, created=%s,"
                        + " updated=%s, enabled=%s, {address}]", id, fullName, email, password,
                role, timezone, created, updated, enabled );
    }

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
     * @return the fullName
     */
    public String getFullName() {

        return fullName;
    }

    /**
     * Getter.
     * 
     * @return the email
     */
    public String getEmail() {

        return email;
    }

    /**
     * Getter.
     * 
     * @return the password
     */
    public String getPassword() {

        return password;
    }

    /**
     * Getter.
     * 
     * @return the role
     */
    public String getRole() {

        return role;
    }

    /**
     * Getter.
     * 
     * @return the timezone
     */
    public int getTimezone() {

        return timezone;
    }

    /**
     * Getter.
     * 
     * @return the created
     */
    public DateTime getCreated() {

        return new DateTime( created, DateTimeZone.forOffsetMillis( this.timezone ) );
    }

    /**
     * Getter.
     * 
     * @return the updated
     */
    public DateTime getUpdated() {

        return new DateTime( updated, DateTimeZone.forOffsetMillis( this.timezone ) );
    }

    /**
     * Getter.
     * 
     * @return the enabled
     */
    public boolean isEnabled() {

        return enabled;
    }

    /**
     * Getter.
     * 
     * @return the addressCollection
     */
    public Set<Address> getAddresses() {

        return addresses;
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
     * @param fullName
     *            the fullName to set
     */
    public void setFullName( String fullName ) {

        this.fullName = fullName;
    }

    /**
     * Setter.
     * 
     * @param email
     *            the email to set
     */
    public void setEmail( String email ) {

        this.email = email;
    }

    /**
     * Setter.
     * 
     * @param password
     *            the password to set
     */
    public void setPassword( String password ) {

        this.password = password;
    }

    /**
     * Setter.
     * 
     * @param role
     *            the role to set
     */
    public void setRole( String role ) {

        this.role = role;
    }

    /**
     * Setter.
     * 
     * @param timezone
     *            the timezone to set
     */
    public void setTimezone( int timezone ) {

        this.timezone = timezone;
    }

    /**
     * Setter.
     * 
     * @param created
     *            the created to set
     */
    public void setCreated( DateTime created ) {

        this.created = created;
    }

    /**
     * Setter.
     * 
     * @param updated
     *            the updated to set
     */
    public void setUpdated( DateTime updated ) {

        this.updated = updated;
    }

    /**
     * Setter.
     * 
     * @param enabled
     *            the enabled to set
     */
    public void setEnabled( boolean enabled ) {

        this.enabled = enabled;
    }

    /**
     * Setter.
     * 
     * @param addressCollection
     *            the addressCollection to set
     */
    public void setAddresses( Set<Address> addressCollection ) {

        this.addresses = addressCollection;
    }

}
