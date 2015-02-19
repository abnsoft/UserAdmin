/**
 * Project ..... UserAdmin<br>
 * <br>
 * Author ...... AnNik<br>
 * E-Mail ...... ABN.DEV@mail.ru<br>
 * Created ..... 16 февр. 2015 г.<br>
 * <br>
 */
package abc.def.web.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import abc.def.data.exception.PersonRegisterException;
import abc.def.data.model.Person;
import abc.def.data.service.PersonService;
import abc.def.web.beans.FormRegister;

/**
 * @author annik
 *
 */
@Controller
public class RootController {

    private static final Logger LOG = LoggerFactory.getLogger( RootController.class );

    @Autowired
    private PersonService personService;

    @Autowired
    @Qualifier( "frmRegisterValidator" )
    private Validator validator;

    @Autowired
    private ResourceBundleMessageSource messageSource;

    @InitBinder
    private void initBinder( WebDataBinder binder ) {

        binder.setValidator( validator );
    }

    @RequestMapping( value = "/index.htm" )
    @ResponseBody
    public String rootUrl() {

        return "hello";
    }

    @RequestMapping( value = "/login.htm" )
    public ModelAndView loginUrl( HttpServletRequest request, HttpServletResponse response ) {

        ModelAndView model = new ModelAndView( "login" );
        model.addObject( "msg", "login" );

        return model;
    }

    @RequestMapping( value = "/register.htm", method = RequestMethod.GET )
    public ModelAndView registerShow( Model model, @ModelAttribute FormRegister frmReg, BindingResult result ) {

        model.addAttribute( frmReg );

        LOG.debug( "GET: formReg = {}", frmReg.toString() );

        ModelAndView modelAndView = new ModelAndView();

        modelAndView.setViewName( "register" );

        modelAndView.addObject( "msg", "user" );

        return modelAndView;
    }

    @RequestMapping( value = "/register.htm", method = RequestMethod.POST )
    public ModelAndView registerDo( Model model, @ModelAttribute @Validated FormRegister frmReg,
            BindingResult result ) {

        model.addAttribute( frmReg );

        LOG.debug( "POST: formReg = {}", frmReg.toString() );

        ModelAndView modelAndView = new ModelAndView();

        if ( result.hasErrors() ) {
            //result is BindingResult
            List<ObjectError> allErrors = result.getAllErrors();

            for (ObjectError error : allErrors) {
                String message = messageSource.getMessage( error, Locale.ENGLISH );
                frmReg.addErrorsInMap( error.getCode(), message );

            }
            modelAndView.addObject( "frmReg", frmReg );

            modelAndView.setViewName( "register" );

        } else {

            Person newPerson = null;
            try {
                newPerson = personService.registerPerson( frmReg.getEmail(), frmReg.getPassword() );

            } catch (Exception e) {
                LOG.error( "Registration FAILED!", e );
                // TODO : show to user some information about problem 
            }

            LOG.debug( "Registered new Person : {}, redirect to login.", newPerson );

            model.addAttribute( "form", frmReg );
            modelAndView.setViewName( "redirect:admin/users-list.htm" );
        }

        return modelAndView;
    }

}