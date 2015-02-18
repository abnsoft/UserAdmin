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
package abc.def.data.service;

import abc.def.data.exception.PersonRegisterException;
import abc.def.data.model.Person;

/**
 * @author annik
 *
 */
public interface PersonService {

    /**
     * Register new {@link Person}.
     * 
     * @param email
     * @param password
     * @return registered new {@link Person}.
     * @throws PersonRegisterException
     */
    Person registerPerson( String email, String password ) throws PersonRegisterException;

    /**
     * Process login user with given parameters.
     * 
     * @param email
     * @param password
     * @return logined {@link Person}.
     */
    Person loginPerson( String email, String password );

}
