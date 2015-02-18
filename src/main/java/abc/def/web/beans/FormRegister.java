/**
 * Copyright 2015. ABN Software. All Rights reserved.<br>
 * <br>
 * Homepage .... http://www.ABNsoft.info<br>
 * <br>
 * Project ..... UserAdmin<br>
 * <br>
 * Author ...... AnNik<br>
 * E-Mail ...... ABN.DEV@mail.ru<br>
 * Created ..... 18 февр. 2015 г.<br>
 * <br>
 */
package abc.def.web.beans;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

/**
 * @author annik
 *
 */
//@Scope( WebApplicationContext.SCOPE_REQUEST )
//@Component( "frmReg" )
public class FormRegister {

    private String email;

    private String password;

    private String password2;

    /**
     * Getter.
     * 
     * @return the email
     */
    public String getEmail() {

        return email;
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
     * Getter.
     * 
     * @return the password
     */
    public String getPassword() {

        return password;
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
     * Getter.
     * 
     * @return the password2
     */
    public String getPassword2() {

        return password2;
    }

    /**
     * Setter.
     * 
     * @param password2
     *            the password2 to set
     */
    public void setPassword2( String password2 ) {

        this.password2 = password2;
    }

    /*
     * (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {

        return String.format( "FormRegister [email=%s, password=%s, password2=%s]", email, password,
                password2 );
    }

}
