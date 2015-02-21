/**
 * Copyright 2015. ABN Software. All Rights reserved.<br>
 * <br>
 * Homepage .... http://www.ABNsoft.info<br>
 * <br>
 * Project ..... UserAdmin<br>
 * <br>
 * Author ...... AnNik<br>
 * E-Mail ...... ABN.DEV@mail.ru<br>
 * Created ..... 21 февр. 2015 г.<br>
 * <br>
 */
package abc.def.data;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * This class can return any object with result of action (storing, deletion etc).
 * 
 * @author annik
 *
 */
public class ActionResult<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    private boolean error;

    private Map<String, String> errors;

    private T object;

    /**
     * Contructor.
     *
     */
    public ActionResult() {

        this.errors = new HashMap<String, String>();
    }

    /**
     * Getter.
     * 
     * @return the error
     */
    public boolean isError() {

        return error;
    }

    /**
     * Setter.
     * 
     * @param error
     *            the error to set
     */
    public void setError( boolean error ) {

        this.error = error;
    }

    /**
     * Getter.
     * 
     * @return the errors
     */
    public Map<String, String> getErrors() {

        return errors;
    }

    /**
     * Setter.
     * 
     * @param errors
     *            the errors to set
     */
    public void setErrors( Map<String, String> errors ) {

        this.errors = errors;
    }

    public void addErrorItem( String errorCode, String errorMessage ) {

        this.errors.put( errorCode, errorMessage );
    }

    /**
     * Getter.
     * 
     * @return the object
     */
    public T getObject() {

        return object;
    }

    /**
     * Setter.
     * 
     * @param object
     *            the object to set
     */
    public void setObject( T object ) {

        this.object = object;
    }

}
