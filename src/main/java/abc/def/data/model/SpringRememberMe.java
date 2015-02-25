/**
 * Copyright 2015. ABN Software. All Rights reserved.<br>
 * <br>
 * Homepage .... http://www.ABNsoft.info<br>
 * <br>
 * Project ..... UserAdmin<br>
 * <br>
 * Author ...... AnNik<br>
 * E-Mail ...... ABN.DEV@mail.ru<br>
 * Created ..... 25 февр. 2015 г.<br>
 * <br>
 */
package abc.def.data.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

/**
 * @author annik
 *
 */
@Entity
@Table( name = "persistent_logins" )
public class SpringRememberMe {

    @Id
    @Column( length = 64, unique = true, nullable = false )
    private String series;

    @Column( length = 64, nullable = false )
    private String username;

    @Column( length = 64, nullable = false )
    private String token;

    @Column( nullable = false )
    @Type(type="timestamp")
    private Timestamp last_used;

    /**
     * Getter.
     * 
     * @return the series
     */
    public String getSeries() {

        return series;
    }

    /**
     * Setter.
     * 
     * @param series
     *            the series to set
     */
    public void setSeries( String series ) {

        this.series = series;
    }

    /**
     * Getter.
     * 
     * @return the username
     */
    public String getUsername() {

        return username;
    }

    /**
     * Setter.
     * 
     * @param username
     *            the username to set
     */
    public void setUsername( String username ) {

        this.username = username;
    }

    /**
     * Getter.
     * 
     * @return the token
     */
    public String getToken() {

        return token;
    }

    /**
     * Setter.
     * 
     * @param token
     *            the token to set
     */
    public void setToken( String token ) {

        this.token = token;
    }

    /**
     * Getter.
     * 
     * @return the last_used
     */
    public Timestamp getLast_used() {

        return last_used;
    }

    /**
     * Setter.
     * 
     * @param last_used
     *            the last_used to set
     */
    public void setLast_used( Timestamp last_used ) {

        this.last_used = last_used;
    }

}
