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

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import abc.def.data.model.DefaultConfig;
import abc.def.data.model.Person;
import abc.def.data.model.UserRole;
import abc.def.data.repositories.PersonRepository;

/**
 * @author annik
 *
 */
@Service( "personService" )
public class PersonServiceImpl implements PersonService {

    private final Logger LOG = LoggerFactory.getLogger( getClass() );

    @Autowired
    private PersonRepository personRepository;

    /*
     * (non-Javadoc)
     * @see abc.def.data.service.PesronService#registerPerson(java.lang.String, java.lang.String)
     */
    @Override
    public Person registerPerson( String email, String password ) {

        password = new BCryptPasswordEncoder().encode( password );

        String fullName = "";
        String role = UserRole.ROLE_USER.toString();
        String timezone = "0";
        DateTime created = new DateTime();
        DateTime udated = new DateTime();

        Person newPerson = new Person( fullName, email, password, role, timezone, created, udated, true );
        LOG.debug( "Prepared to creating new person {}", newPerson.toString() );

        return personRepository.save( newPerson );
    }

    /*
     * (non-Javadoc)
     * @see abc.def.data.service.PersonService#pagePersons(int)
     */
    public List<Person> pagePersons( int pageNumber ) {

        PageRequest pageRequest =
                new PageRequest( pageNumber - 1, DefaultConfig.PAGE_SIZE, Sort.Direction.ASC, "email" );
        Page<Person> pages = personRepository.findAll( pageRequest );

        List<Person> personList = new ArrayList<Person>();
        if ( pages != null ) {
            for (Person person : pages.getContent()) {
                personList.add( person );
            }
        }
        return personList;

    }

}
