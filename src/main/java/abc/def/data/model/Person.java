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
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
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

/**
 * @author annik
 *
 */
@Entity
@Table( name = "PERSON" )
public class Person {

    @Id
    @GeneratedValue( strategy = GenerationType.AUTO )
    private long id;

    @Column( name = "fullname", length = 128, nullable = false )
    private String fullName;

    @Column( name = "email", length = 128, nullable = false, unique = true )
    private String email;

    @Column( name = "password", length = 128, nullable = false )
    private String password;

    @Column( name = "role", length = 16, nullable = false )
    private String role;

    @Column( name = "timezone", length = 128, nullable = false, columnDefinition = "" )
    private String timezone;

    @Column( name = "created", columnDefinition = "DATETIME", nullable = false )
    @Type( type = "org.joda.time.contrib.hibernate.PersistentDateTime" )
    private DateTime created;

    @Column( name = "updated", columnDefinition = "DATETIME", nullable = false )
    @Type( type = "org.joda.time.contrib.hibernate.PersistentDateTime" )
    private DateTime updated;

    @Column( name = "isenabled", nullable = false )
    @Type( type = "true_false" )
    private boolean enabled;

    @ManyToMany
    @JoinTable( name = "PERSON_ADDRESS", joinColumns = @JoinColumn( name = "addressid",
            referencedColumnName = "id" ), inverseJoinColumns = @JoinColumn( name = "personid",
            referencedColumnName = "id" ) )
    private Collection<Address> addressCollection;

    /**
     * closed Contructor.
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
    public Person( String fullName, String email, String role, String timezone, DateTime created,
            DateTime udated, boolean enabled ) {

        this.fullName = fullName;
        this.email = email;
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
    public Person( String fullName, String email, String role, String timezone, DateTime created,
            DateTime udated ) {

        this.fullName = fullName;
        this.email = email;
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
                "Person [id=%s, fullName=%s, email=%s, role=%s, timezone=%s, created=%s, updated=%s]", id,
                fullName, email, role, timezone, created, updated );
    }

}
