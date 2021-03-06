/**
 * Copyright 2015. ABN Software. All Rights reserved.<br>
 * <br>
 * Homepage .... http://www.ABNsoft.info<br>
 * <br>
 * Project ..... UserAdmin<br>
 * <br>
 * Author ...... AnNik<br>
 * E-Mail ...... ABN.DEV@mail.ru<br>
 * Created ..... 19 ����. 2015 �.<br>
 * <br>
 */
package abc.def.data.beans;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 * @author annik
 *
 */
@Component( "frmAddressValidator" )
public class FormAddressValidator implements Validator {

    private static final Logger LOG = LoggerFactory.getLogger( FormAddressValidator.class );

    /*
     * (non-Javadoc)
     * @see org.springframework.validation.Validator#supports(java.lang.Class)
     */
    @Override
    public boolean supports( Class<?> clazz ) {

        return FormAddress.class.equals( clazz );
    }

    /*
     * (non-Javadoc)
     * @see org.springframework.validation.Validator#validate(java.lang.Object,
     * org.springframework.validation.Errors)
     */
    @Override
    public void validate( Object target, Errors errors ) {

        FormAddress form = (FormAddress) target;

        if ( form == null ) {
            errors.rejectValue( "form", "valid.frmReg.form" );
        } else {

            // TODO : IMPLEMENT ADDRESS VALIDATION ! 
            
//            if ( StringUtils.isBlank( form.getEmail() ) || !form.getEmail().matches( EMAIL_PATTERN ) ) {
//                errors.rejectValue( "email", "valid.frmReg.email" );
//            }
//
//            ValidationUtils.rejectIfEmptyOrWhitespace( errors, "password", "valid.frmReg.password" );
//
//            ValidationUtils.rejectIfEmptyOrWhitespace( errors, "password2", "valid.frmReg.passwordConf" );
//
//            if ( !form.isValidPassword() ) {
//                errors.rejectValue( "password", "valid.frmReg.passwordInvalid" );
//            }
//
//            // compare passwords
//            if ( !form.getPassword().equals( form.getPassword2() ) ) {
//                errors.rejectValue( "password2", "valid.frmReg.passwordConfDiff" );
//            }
//
//            ValidationUtils.rejectIfEmptyOrWhitespace( errors, "fullName", "valid.frmReg.fullName" );
//
//            if ( form.getTimezone() == null ) {
//                errors.rejectValue( "timezone", "valid.frmReg.timezone" );
//            }
            
            // check Addresses not null 
            
            
        }
    }

}
