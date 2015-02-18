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
package abc.def.data.exception;

/**
 * @author annik
 *
 */
public class PersonRegisterException extends Exception {

    /**
     * Contructor.
     * 
     */
    public PersonRegisterException() {

        super();
    }

    /**
     * Contructor.
     * 
     * @param message
     */
    public PersonRegisterException( String message ) {

        super( message );
    }

    /**
     * Contructor.
     * 
     * @param cause
     */
    public PersonRegisterException( Throwable cause ) {

        super( cause );
    }

    /**
     * Contructor.
     * 
     * @param message
     * @param cause
     */
    public PersonRegisterException( String message, Throwable cause ) {

        super( message, cause );
    }

    /**
     * Contructor.
     * 
     * @param message
     * @param cause
     * @param enableSuppression
     * @param writableStackTrace
     */
    public PersonRegisterException( String message, Throwable cause, boolean enableSuppression,
            boolean writableStackTrace ) {

        super( message, cause, enableSuppression, writableStackTrace );
    }

}
