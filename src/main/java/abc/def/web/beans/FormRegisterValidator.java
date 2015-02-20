/**
 * Copyright 2015. ABN Software. All Rights reserved.<br>
 * <br>
 * Homepage .... http://www.ABNsoft.info<br>
 * <br>
 * Project ..... UserAdmin<br>
 * <br>
 * Author ...... AnNik<br>
 * E-Mail ...... ABN.DEV@mail.ru<br>
 * Created ..... 19 февр. 2015 г.<br>
 * <br>
 */
package abc.def.web.beans;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import static abc.def.data.Utils.U.*;

/**
 * @author annik
 *
 */
@Component( "frmRegisterValidator" )
public class FormRegisterValidator implements Validator {

    private static final Logger LOG = LoggerFactory.getLogger( FormRegisterValidator.class );

    /*
     * (non-Javadoc)
     * @see org.springframework.validation.Validator#supports(java.lang.Class)
     */
    @Override
    public boolean supports( Class<?> clazz ) {

        return FormRegister.class.equals( clazz );
    }

    /*
     * (non-Javadoc)
     * @see org.springframework.validation.Validator#validate(java.lang.Object,
     * org.springframework.validation.Errors)
     */
    @Override
    public void validate( Object target, Errors errors ) {

        FormRegister form = (FormRegister) target;

        if ( form == null ) {
            errors.rejectValue( "form", "valid.frmReg.form" );
        } else {

            if ( StringUtils.isBlank( form.getEmail() ) || !form.getEmail().matches( EMAIL_PATTERN ) ) {
                errors.rejectValue( "email", "valid.frmReg.email" );
            }

            ValidationUtils.rejectIfEmptyOrWhitespace( errors, "password", "valid.frmReg.password" );

            ValidationUtils.rejectIfEmptyOrWhitespace( errors, "password2", "valid.frmReg.passwordConf" );

            if ( !form.isValidPassword() ) {
                errors.rejectValue( "password", "valid.frmReg.passwordInvalid" );
            }

            // compare passwords
            if ( !form.getPassword().equals( form.getPassword2() ) ) {
                errors.rejectValue( "password2", "valid.frmReg.passwordConfDiff" );
            }

        }
    }

}
