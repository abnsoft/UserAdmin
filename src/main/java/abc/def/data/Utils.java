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
package abc.def.data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;
import java.util.TreeMap;

/**
 * @author annik
 *
 */
public class Utils {

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

        String supportedPattern = "^(Africa|America|Asia|Atlantic|Australia|" + "Europe|Indian|Pacific)/.*";
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
            double offset = (double) timeZone.getRawOffset() / 1000 / 60 / 60;
            String minute =
                    ( ( offset - (int) offset ) * 60 ) > 0 ? ( (int) ( ( offset - (int) offset ) * 60 ) + "" )
                            : "00";
            String str = zoneId + " " + (int) offset + ":" + minute;
            tz.put( timeZone.getRawOffset(), str );

            System.out.println( str );
        }
        return tz;
    }
}
