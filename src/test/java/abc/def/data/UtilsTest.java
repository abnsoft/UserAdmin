package abc.def.data;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

public class UtilsTest {

    @AfterClass
    public static void tearDownAfterClass() throws Exception {

    }

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testValidatePassword() {

        // VALID password 
        String pwd = "a1B!@#";
        assertTrue( "Password `" + pwd + "` should be validated.", Utils.validatePassword( pwd ) );

        // false - NO Upper latter.
        pwd = "a1a!@#";
        assertFalse( "Password `" + pwd + "` chould be NOT validated. NO UPPER LETTERS",
                Utils.validatePassword( pwd ) );

        // false - NO Upper latter & any digits.
        pwd = "acca!@#";
        assertFalse( "Password `" + pwd + "` chould be NOT validated. No upper letters and any digits.",
                Utils.validatePassword( pwd ) );

        // false - only 4 characters.
        pwd = "1V2D";
        assertFalse( "Password `" + pwd + "` chould be NOT validated. Only 4 digits. Minimum 6.",
                Utils.validatePassword( pwd ) );

        // TRUE - 6+ chars, 1+ digits, 1+ Upper chars.
        pwd = "1V2D654";
        assertTrue( "Password `" + pwd + "` chould be NOT validated.", Utils.validatePassword( pwd ) );
    }

}
