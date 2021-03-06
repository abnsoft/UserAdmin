/**
 * Copyright 2015. ABN Software. All Rights reserved.<br>
 * <br>
 * Homepage .... http://www.ABNsoft.info<br>
 * <br>
 * Project ..... UserAdmin<br>
 * <br>
 * Author ...... AnNik<br>
 * E-Mail ...... ABN.DEV@mail.ru<br>
 * Created ..... 18 ����. 2015 �.<br>
 * <br>
 */
package abc.def.data.service;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.springframework.data.domain.Page;

import abc.def.data.ActionResult;
import abc.def.data.beans.FormRegister;
import abc.def.data.exception.PersonRegisterException;
import abc.def.data.model.Address;
import abc.def.data.model.Person;

/**
 * @author annik
 *
 */
public interface PersonService {

    /**
     * Register new {@link Person}.
     * 
     * @param frmReg
     * @return registered new {@link Person}.
     */
    Person registerPerson( FormRegister frmReg, Set<Address> addrList );

    /**
     * Get {@link Page} data of {@link Person}s
     * 
     * @param pageNumber
     * @return {@link Page} of {@code pageNumber}
     */
    List<Person> pagePersons( int pageNumber );

    /**
     * Get user.id by his email.
     * 
     * @param email
     * @return {@link Person}
     */
    Person getPersonByEmail( String email );

    /**
     * Get {@link Person} by given {@code userId}.
     * 
     * @param userId
     * @return Person
     */
    Person getPersonById( long userId );

    /**
     * Update person with data from request.<br />
     * Data should be already validated.
     * 
     * @return updated {@link Person}
     */
    Person updatePerson( Person person, Map<String, String[]> parameterMap );

    /**
     * Update {@link HttpSession} info for logined {@link Person}
     * 
     * @param session
     * @param name
     */
    void updateSessionForPerson( HttpSession session, String email );

    /**
     * Save or Merge {@link Person}.
     * 
     * @param selectedPerson
     * @return 
     */
    Person save( Person selectedPerson );

}
