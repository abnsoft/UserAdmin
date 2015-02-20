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
package abc.def.web.beans;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import abc.def.data.model.Person;
import static abc.def.data.Utils.U.*;

/**
 * @author annik
 *
 */
@Component( "frmUserValidator" )
public class FormUserValidator implements Validator {

    /*
     * (non-Javadoc)
     * @see org.springframework.validation.Validator#supports(java.lang.Class)
     */
    @Override
    public boolean supports( Class<?> clazz ) {

//        return FormUser.class.equals( clazz );
        return Person.class.equals( clazz ) || FormUser.class.equals( clazz );
    }

    /*
     * (non-Javadoc)
     * @see org.springframework.validation.Validator#validate(java.lang.Object,
     * org.springframework.validation.Errors)
     */
    @Override
    public void validate( Object target, Errors errors ) {

        FormUser form = (FormUser) target;

        if ( form == null ) {
            errors.rejectValue( "form", "valid.frmUser.form" );

        } else {

            if ( StringUtils.isBlank( form.getEmail() ) || !form.getEmail().matches( EMAIL_PATTERN ) ) {
                errors.rejectValue( "email", "valid.frmUser.email" );
            }

            ValidationUtils.rejectIfEmptyOrWhitespace( errors, "fullName", "valid.frmUser.fullName" );

//            if ( form.getRole().equals( anObject ) ) {
//                
//            }
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

        }

    }

}
