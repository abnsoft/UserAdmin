/**
 * Copyright 2015. ABN Software. All Rights reserved.<br>
 * <br>
 * Homepage .... http://www.ABNsoft.info<br>
 * <br>
 * Project ..... UserAdmin<br>
 * <br>
 * Author ...... AnNik<br>
 * E-Mail ...... ABN.DEV@mail.ru<br>
 * Created ..... 20 февр. 2015 г.<br>
 * <br>
 */
package abc.def.data.beans;

import java.util.Map;

import org.joda.time.DateTime;

import abc.def.data.Utils.U;
import abc.def.data.model.Person;

/**
 * @author annik
 *
 */
public class FormUser extends Person {

    public static final String FIELD_EMAIL = "email";

    public static final String FIELD_FULLNAME = "fullname";

    private static final Object FIELD_PASSWORD = "password";

    private static final Object FIELD_ROLE = "role";

    private static final Object FIELD_TIMEZONE = "timezone";

    private static final Object FIELD_CREATED = "created";

    private static final Object FIELD_UPDATED = "updated";

    /**
     * Contructor.
     *
     */
    public FormUser() {

    }

    /**
     * Contructor.
     * 
     * @param person
     */
    public FormUser( Person person ) {

        super( person.getFullName(), person.getEmail(), person.getPassword(), person.getRole(), person
                .getTimezone(), person.getCreated(), person.getUpdated(), person.isEnabled() );
    }

    /**
     * 
     * @param parameterMap
     * @return
     */
    public static Person getPerson( Map<String, String[]> parameterMap ) {

        String fullName = U.getParam0( parameterMap.get( FIELD_FULLNAME ) );

        String email = U.getParam0( parameterMap.get( FIELD_EMAIL ) );

        String password = U.getParam0( parameterMap.get( FIELD_PASSWORD ) );

        String role = U.getParam0( parameterMap.get( FIELD_PASSWORD ) );

        int timezone = Integer.valueOf( U.getParam0( parameterMap.get( FIELD_TIMEZONE ) ) );

        String created = U.getParam0( parameterMap.get( FIELD_CREATED ) );

        String updated = U.getParam0( parameterMap.get( FIELD_UPDATED ) );

        return new Person( fullName, email, password, role, timezone, DateTime.parse( created ),
                DateTime.parse( updated ) );
    }

    /**
     * 
     * @param updated
     */
    public void setUpdated( String updated ) {

        setUpdated( DateTime.parse( updated ) );
    }

    /**
     * 
     * @param created
     */
    public void setCreated( String created ) {

        setCreated( DateTime.parse( created ) );
    }

}
