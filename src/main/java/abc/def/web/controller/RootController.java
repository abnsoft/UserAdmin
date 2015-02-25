/**
 * Project ..... UserAdmin<br>
 * <br>
 * Author ...... AnNik<br>
 * E-Mail ...... ABN.DEV@mail.ru<br>
 * Created ..... 16 февр. 2015 г.<br>
 * <br>
 */
package abc.def.web.controller;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.TreeMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.Validator;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import abc.def.data.Utils;
import abc.def.data.beans.FormRegister;
import abc.def.data.model.Address;
import abc.def.data.model.Person;
import abc.def.data.service.PersonService;

/**
 * @author annik
 *
 */
@Controller
public class RootController {

    public static final String ROOT_LOGIN_HTM = "/login.htm";

    private static final Logger LOG = LoggerFactory.getLogger( RootController.class );

    @Autowired
    private PersonService personService;

    @Autowired
    private ResourceBundleMessageSource messageSource;

    @Autowired
    @Qualifier( "frmRegisterValidator" )
    private Validator validator;

    @InitBinder
    private void initBinder( WebDataBinder binder ) {

        binder.setValidator( validator );
    }

    /**
     * 
     * @param request
     * @param response
     * @return
     */
    @RequestMapping( value = {"/index.htm", ROOT_LOGIN_HTM}, method = RequestMethod.GET )
    public String login( HttpServletRequest request ) {

        LOG.debug( "requested page : index.htm or login.htm" );
        return "login";
    }

    @RequestMapping( value = {"loginFailed.htm"}, method = RequestMethod.GET )
    public String loginFailed( Model model, HttpServletRequest request ) {

        LOG.debug( "Login failed!" );

        model.addAttribute( "loginError", "true" );
        
        return "login";
    }

    /**
     * 
     * @param model
     * @param frmReg
     * @param result
     * @return
     */
    @RequestMapping( value = "/register.htm", method = RequestMethod.GET )
    public ModelAndView registerShow( Model model, @ModelAttribute FormRegister frmReg, BindingResult result ) {

        model.addAttribute( frmReg );

        LOG.debug( "GET: formReg = {}", frmReg.toString() );

        ModelAndView mav = new ModelAndView();

        mav.setViewName( "register" );

        mav.addObject( "timezonesList", (TreeMap<Integer, String>) Utils.TimeZoneArray() );

        return mav;
    }

    /**
     * 
     * @param model
     * @param frmReg
     * @param result
     * @return
     */
    @RequestMapping( value = "/register.htm", method = RequestMethod.POST )
    public ModelAndView registerDo( Model model, @ModelAttribute @Validated FormRegister frmReg,
            BindingResult result, HttpServletRequest request ) {

        model.addAttribute( frmReg );

        LOG.debug( "POST: formReg = {}", frmReg.toString() );

        ModelAndView mav = new ModelAndView();

        if ( result.hasErrors() ) {
            //result is BindingResult
            List<ObjectError> allErrors = result.getAllErrors();

            for (ObjectError error : allErrors) {
                frmReg.addErrorsInMap( error.getCode(), messageSource.getMessage( error, Locale.ENGLISH ) );
            }
            mav.addObject( "frmReg", frmReg );

            mav.addObject( "timezonesList", (TreeMap<Integer, String>) Utils.TimeZoneArray() );

            mav.setViewName( "register" );

        } else {

            // convert list from FORM to Set
            Set<Address> addrSet = new LinkedHashSet<Address>();
            for (Address addr : frmReg.getAddressList()) {
                addrSet.add( addr );
            }
            try {
                Person newPerson = personService.registerPerson( frmReg, addrSet );

                LOG.debug( "Registered new Person : {}, redirect to login.", newPerson );

            } catch (Exception e) {
                LOG.error( "Registration FAILED!", e );
                // TODO : show to user some information about problem 
            }

            model.addAttribute( "form", frmReg );

            // Authenticate registered person 
            try {
                request.login( frmReg.getEmail(), frmReg.getPassword() );
                mav.setViewName( "redirect:admin/users-list.htm" );

            } catch (ServletException e) {
                LOG.debug( "Login FAILED!" );
                mav.setViewName( "redirect:login-failed.htm" );
            }

        }

        return mav;
    }

}