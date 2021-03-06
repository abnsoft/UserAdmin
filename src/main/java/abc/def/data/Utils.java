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
package abc.def.data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.TreeMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;

import abc.def.data.model.Person;

/**
 * @author annik
 *
 */
public class Utils {

    private static final Logger LOG = LoggerFactory.getLogger( Utils.class );

    /**
     * Use this constant to add redirection in MVC. "redirect:/myPage.htm"
     */
    public static final String MVC_REDIRECT = "redirect:";

    /**
     * Email regex pattern.
     */
    public static final String EMAIL_PATTERN =
            "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

    /**
     * Short name for useful using.
     * 
     * @author annik
     *
     */
    public static class U extends Utils {

    }

    /**
     * Check given password for followin conditions : <br />
     * - at least 1 digit <br />
     * - at least 1 upper case letter <br />
     * - password`s length 6+ characters. <br />
     * 
     * @param passwString
     * @return result of validating.
     */
    public static boolean validatePassword( String passwString ) {

        boolean result = true;

        result = result ? passwString.matches( ".*\\d+.*" ) : false;
        result = result ? passwString.matches( ".*[A-Z]+.*" ) : false;
        result = result ? passwString.matches( ".{6,}" ) : false;

        return result;
    }

    /**
     * Check given String`s array. Assumption is it contains only 1 item.
     * 
     * @param parameter
     * @return
     */
    public static String getParam0( String[] parameter ) {

        return parameter == null ? "" : ( parameter[0] == null ? "" : parameter[0] );
    }

    /**
     * Prepare {@link Map} of TimeZones. Key is rawOffset in milliseconds, value is description of time zone.
     * 
     * @return Time Zone {@link Map}.
     */
    public static Map<Integer, String> TimeZoneArray() {

//        String supportedPattern = "^(Africa|America|Asia|Atlantic|Australia|" + "Europe|Indian|Pacific)/.*";
        String supportedPattern = "^(America|Asia|Atlantic|Australia|" + "Europe|Pacific)/.*";
        String[] timeZoneIdList = TimeZone.getAvailableIDs();
        List<TimeZone> timeZoneList = new ArrayList<TimeZone>();

        for (String id : timeZoneIdList) {
            if ( id.matches( supportedPattern ) ) {
                timeZoneList.add( TimeZone.getTimeZone( id ) );
            }
        }
        Collections.sort( timeZoneList, new Comparator<TimeZone>() {

            public int compare( final TimeZone a, final TimeZone b ) {

                return a.getID().compareTo( b.getID() );
            }
        } );
        Map<Integer, String> tz = new TreeMap<Integer, String>();

        for (TimeZone timeZone : timeZoneList) {
            String zoneId = timeZone.getID();
//            String displayName = timeZone.getDisplayName();
//            double offset = (double) timeZone.getRawOffset() / 1000 / 60 / 60;
            int offset = timeZone.getRawOffset() / 1000 / 60 / 60;
            String minute =
                    ( ( offset - (int) offset ) * 60 ) > 0 ? ( (int) ( ( offset - (int) offset ) * 60 ) + "" )
                            : "00";
            String str = String.format( "[GMT%1$+03d:%2$s] %3$s", offset, minute, zoneId );

            tz.put( timeZone.getRawOffset(), str );
        }
        return tz;
    }

    /**
     * Try to resolve the message.
     * 
     * @param msgKey
     *            - the code to lookup up, such as 'calculator.noRateSet'. Users of this class are encouraged
     *            to base message names on the relevant fully qualified class name, thus avoiding conflict and
     *            ensuring maximum clarity.
     * @param messageSource
     * @param objects
     *            - array of arguments that will be filled in for params within the message (params look like
     *            "{0}", "{1,date}", "{2,time}" within a message), or null if none.
     * @param request
     * @return message
     */
    public static String getMsg( String msgKey, ResourceBundleMessageSource messageSource, Object[] objects,
            HttpServletRequest request ) {

        return messageSource.getMessage( msgKey, objects,
                (Locale) request.getSession().getAttribute( "curLocale" ) );
    }

    /**
     * Find in SPRING User details. Used with spring-SECURITY.
     * 
     * @param request
     * @return User.username
     */
    public static final User findSpringUser( HttpServletRequest request ) {

        User foundUser = null;

        if ( request != null && request.getSession() != null ) {
            SecurityContext ctx =
                    (SecurityContext) request.getSession().getAttribute( "SPRING_SECURITY_CONTEXT" );

            if ( ctx != null ) {
                Authentication auth = ctx.getAuthentication();
                if ( auth != null && auth.getPrincipal() != null ) {
                    foundUser = ( (User) auth.getPrincipal() );

                } else {
                    LOG.error( "SPRING Authentication or Principal is NULL!" );
                }

            } else {
                LOG.error( "SPRING SecurotyContext is NULL!" );
            }

        } else {
            LOG.error( "HttpServletRequest or Session is NULL!" );
        }

        return foundUser;

    }
}
