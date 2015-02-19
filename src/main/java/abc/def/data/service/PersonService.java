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

import java.util.List;

import org.springframework.data.domain.Page;

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
    Person registerPerson( String email, String password );

    /**
     * Get {@link Page} data of {@link Person}s
     * 
     * @param pageNumber
     * @return {@link Page} of {@code pageNumber}
     */
    public List<Person> pagePersons( int pageNumber );
}
