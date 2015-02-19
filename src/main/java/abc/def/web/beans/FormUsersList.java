/**
 * Copyright 2015. ABN Software. All Rights reserved.<br>
 * <br>
 * Homepage .... http://www.ABNsoft.info<br>
 * <br>
 * Project ..... UserAdmin<br>
 * <br>
 * Author ...... AnNik<br>
 * E-Mail ...... ABN.DEV@mail.ru<br>
 * Created ..... 19 февр. 2015 г.<br>
 * <br>
 */
package abc.def.web.beans;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import abc.def.data.model.Person;

/**
 * @author annik
 *
 */
final public class FormUsersList {

    private final Logger LOG = LoggerFactory.getLogger( getClass() );

    private String email;

    private String name;

    private String role;

    /**
     * Contructor.
     * 
     * @param person
     */
    public FormUsersList( Person person ) {

        this.email = person.getEmail();
        this.name = person.getFullName();
        this.role = person.getRole();
    }

    /**
     * Getter.
     * 
     * @return the email
     */
    public final String getEmail() {

        return email;
    }

    /**
     * Getter.
     * 
     * @return the name
     */
    public final String getName() {

        return name;
    }

    /**
     * Getter.
     * 
     * @return the role
     */
    public final String getRole() {

        return role;
    }

    /**
     * Setter.
     * 
     * @param email
     *            the email to set
     */
    public final void setEmail( String email ) {

        this.email = email;
    }

    /**
     * Setter.
     * 
     * @param name
     *            the name to set
     */
    public final void setName( String name ) {

        this.name = name;
    }

    /**
     * Setter.
     * 
     * @param role
     *            the role to set
     */
    public final void setRole( String role ) {

        this.role = role;
    }

    /*
     * (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {

        return String.format( "FormUsersList [email=%s, name=%s, role=%s]", email, name, role );
    }

}
