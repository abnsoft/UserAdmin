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

import java.util.HashMap;
import java.util.Map;

import org.hibernate.metamodel.source.annotations.attribute.FormulaValue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

import abc.def.data.Utils.U;

/**
 * @author annik
 *
 */
//@Scope( WebApplicationContext.SCOPE_REQUEST )
//@Component( "frmReg" )
public class FormRegister {

    private final Logger LOG = LoggerFactory.getLogger( getClass() );

    private String email;

    private String password;

    private String password2;

    private Map<String, String> errorsMap = new HashMap<String, String>();

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

    /**
     * Getter.
     * 
     * @return the errorsMap
     */
    public Map<String, String> getErrorsMap() {

        return errorsMap;
    }

    /**
     * Setter.
     * 
     * @param errorsMap
     *            the errorsMap to set
     */
    public void setErrorsMap( Map<String, String> errorsMap ) {

        this.errorsMap = errorsMap;
    }

    /**
     * Setter.
     * 
     * @param errorsMap
     *            the errorsMap to set
     */
    public void addErrorsInMap( String key, String errorMessage ) {

        this.errorsMap.put( key, errorMessage );
    }

    /*
     * (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {

        return String.format( "FormRegister [email=%s, password=%s, password2=%s, errorsMap=%s]", email,
                password, password2, errorsMap );
    }

    public boolean isValidPassword() {

        return U.validatePassword( this.password );
    }
}
