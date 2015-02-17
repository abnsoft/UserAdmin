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

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
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

    @Column( name = "role", nullable = false )
    private String role;

    @Column( name = "timezone", length = 128, nullable = false, columnDefinition = "" )
    private String timezone;

    @Column( name = "created", columnDefinition = "DATETIME", nullable = false )
    @Type( type = "org.joda.time.contrib.hibernate.PersistentDateTime" )
    private DateTime created;

    @Column( name = "updated", columnDefinition = "DATETIME", nullable = false )
    @Type( type = "org.joda.time.contrib.hibernate.PersistentDateTime" )
    private DateTime updated;

    protected Person() {

    }

    public Person( String fullName, String email, String role, String timezone, DateTime created,
            DateTime udated ) {

        this.fullName = fullName;
        this.email = email;
        this.role = role;
        this.timezone = timezone;
        this.created = created;
        updated = udated;
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
