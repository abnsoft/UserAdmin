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
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.AutoPopulatingList;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

import abc.def.data.ActionResult;
import abc.def.data.DefaultConfig;
import abc.def.data.UserRole;
import abc.def.data.Utils.U;
import abc.def.data.model.Address;
import abc.def.data.model.Person;
import abc.def.data.repositories.AddressRepository;
import abc.def.data.repositories.PersonRepository;

/**
 * @author annik
 *
 */
@Service( "personService" )
@Transactional
public class PersonServiceImpl implements PersonService {

    private final Logger LOG = LoggerFactory.getLogger( getClass() );

    public static final String FIELD_EMAIL = "email";

    public static final String FIELD_FULLNAME = "fullName";

    private static final Object FIELD_PASSWORD = "password";

    private static final Object FIELD_ROLE = "role";

    private static final Object FIELD_TIMEZONE = "timezone";

    private static final Object FIELD_CREATED = "created";

    private static final Object FIELD_UPDATED = "updated";

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private AddressRepository addressRepository;

    /*
     * (non-Javadoc)
     * @see abc.def.data.service.PesronService#registerPerson(java.lang.String, java.lang.String)
     */
    @Override
    public Person registerPerson( String email, String password, Set<Address> addrList ) {

        password = new BCryptPasswordEncoder().encode( password );

        String fullName = "";
        String role = UserRole.ROLE_USER.toString();
        int timezone = 0;

        DateTimeZone tz = DateTimeZone.forOffsetMillis( timezone );

        DateTime created = new DateTime( tz );
        DateTime udated = new DateTime( tz );

        Person newPerson = new Person( fullName, email, password, role, timezone, created, udated, true );

        addrList = (Set<Address>) checkAddresses( addrList );

        newPerson.setAddresses( addrList );
        try {
            newPerson = personRepository.save( newPerson );

        } catch (Exception e) {
            // TODO: handle exception
        }
        LOG.debug( "Prepared to creating new person {}", newPerson.toString() );

        return newPerson;
    }

    /*
     * (non-Javadoc)
     * @see abc.def.data.service.PersonService#createPerson(java.lang.String, java.lang.String,
     * java.util.Collection)
     */
    @Override
    public ActionResult<Person> createPerson( String email, String password, Collection<Address> addrList ) {

        ActionResult<Person> actionResult = new ActionResult<Person>();

        password = new BCryptPasswordEncoder().encode( password );

        String fullName = "";
        String role = UserRole.ROLE_USER.toString();
        int timezone = 0;

        DateTimeZone tz = DateTimeZone.forOffsetMillis( timezone );

        DateTime created = new DateTime( tz );
        DateTime udated = new DateTime( tz );

        Person newPerson = new Person( fullName, email, password, role, timezone, created, udated, true );

        newPerson.setAddresses( (Set<Address>) addrList );
        try {
            newPerson = personRepository.save( newPerson );

        } catch (Exception e) {
            actionResult.setError( true );
            actionResult.addErrorItem( "error", e.getMessage() );
        }
        LOG.debug( "Created new person : {}", newPerson.toString() );
        actionResult.setObject( newPerson );

        return actionResult;
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

    /*
     * (non-Javadoc)
     * @see abc.def.data.service.PersonService#getUserId(java.lang.String)
     */
    @Override
    public Person getPersonByEmail( String email ) {

        return personRepository.findByEmail( email );
    }

    /*
     * (non-Javadoc)
     * @see abc.def.data.service.PersonService#getPersonById(long)
     */
    @Override
    public Person getPersonById( long userId ) {

        return personRepository.findById( userId );
    }

    /*
     * (non-Javadoc)
     * @see abc.def.data.service.PersonService#updatePerson(abc.def.data.model.Person, java.util.Map)
     */
    @Override
    public Person updatePerson( Person person, Map<String, String[]> parameterMap ) {

        String fullName = U.getParam0( parameterMap.get( FIELD_FULLNAME ) );

        String email = U.getParam0( parameterMap.get( FIELD_EMAIL ) );

        String role = U.getParam0( parameterMap.get( FIELD_ROLE ) );

        int timezone = Integer.valueOf( U.getParam0( parameterMap.get( FIELD_TIMEZONE ) ) );

        person.setEmail( email );
        person.setFullName( fullName );
        person.setRole( role );
        person.setTimezone( timezone );

        DateTimeZone tz = DateTimeZone.forOffsetMillis( timezone );

        person.setUpdated( new DateTime( tz ) );

        return personRepository.saveAndFlush( person );
    }

    /*
     * (non-Javadoc)
     * @see abc.def.data.service.PersonService#updateSessionForPerson(javax.servlet.http.HttpSession,
     * java.lang.String)
     */
    @Override
    public void updateSessionForPerson( HttpSession session, String email ) {

        Person person = personRepository.findByEmail( email );

        session.setAttribute( DefaultConfig.SESSION_USER_NAME, email );
        session.setAttribute( DefaultConfig.SESSION_USER_ID, person.getId() );
        session.setAttribute( DefaultConfig.SESSION_USER_ROLE, person.getRole() );

    }

    /**
     * Update person.
     * 
     * @param person
     * @return
     */
    public Person updatePerson( Person person ) {

        return personRepository.save( person );

    }

    /*
     * Check given addresses for existing.
     */
    private Collection<Address> checkAddresses( Set<Address> addrList ) {

        Set<Address> newAddresses = new HashSet<Address>();
        Address addr = null;
        for (Address address : addrList) {
            addr =
                    addressRepository.findByCountryAndCityAndStreetAndHouseNumber( address.getCountry(),
                            address.getCity(), address.getStreet(), address.getHouseNumber() );
            addr = addr == null ? address : addr;
            newAddresses.add( addr );
            addressRepository.flush();

            LOG.debug( "checked address {}", addr.toString() );
        }
        return addrList;
    }

}
