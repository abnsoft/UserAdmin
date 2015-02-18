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

import org.apache.commons.lang.StringUtils;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import abc.def.data.Utils;
import abc.def.data.exception.PersonRegisterException;
import abc.def.data.model.Person;
import abc.def.data.repositories.PersonRepository;

/**
 * @author annik
 *
 */
@Service("personService")
public class PersonServiceImpl implements PersonService {

    private final Logger LOG = LoggerFactory.getLogger( getClass() );

    @Autowired
    private PersonRepository personRepository;

    /*
     * (non-Javadoc)
     * @see abc.def.data.service.PesronService#registerPerson(java.lang.String, java.lang.String)
     */
    @Override
    public Person registerPerson( String email, String password ) throws PersonRegisterException {

        if ( StringUtils.isBlank( email ) ) {
            throw new PersonRegisterException( "Email cannot be blank." );
        }
        if ( StringUtils.isBlank( password ) ) {
            throw new PersonRegisterException( "Password cannot be blank." );
        }
        if ( Utils.validatePassword( password ) ) {
            throw new PersonRegisterException( "Password have to contains: length 6+ characters, "
                    + "1 digit and 1 upper case letter." );
        }

        password = new BCryptPasswordEncoder().encode( password );

        String fullName = "";
        String role = "role_user";
        String timezone = "0";
        DateTime created = new DateTime();
        DateTime udated = new DateTime();

        Person newPerson = new Person( fullName, email, password, role, timezone, created, udated );
        LOG.debug( "Prepared to creat new person {}", newPerson.toString() );

        return personRepository.save( newPerson );
    }

    /*
     * (non-Javadoc)
     * @see abc.def.data.service.PesronService#loginPerson(java.lang.String, java.lang.String)
     */
    @Override
    public Person loginPerson( String email, String password ) {

        // TODO Auto-generated method stub
        return null;
    }

}
