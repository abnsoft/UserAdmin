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

/**
 * @author annik
 *
 */
public class Utils {

    /**
     * Short name for useful using.
     * 
     * @author annik
     *
     */
    public static class U extends Utils {

    }

    /**
     * Check given password as parameters
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
}
