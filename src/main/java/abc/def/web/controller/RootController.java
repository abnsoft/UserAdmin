/**
 * Project ..... UserAdmin<br>
 * <br>
 * Author ...... AnNik<br>
 * E-Mail ...... ABN.DEV@mail.ru<br>
 * Created ..... 16 февр. 2015 г.<br>
 * <br>
 */
package abc.def.web.controller;

import java.util.List;
import java.util.Locale;

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

import abc.def.data.ActionResult;
import abc.def.data.model.Address;
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
    @RequestMapping( value = {"index.htm", "/login.htm"} )
    public String loginUrl() {

        LOG.debug( "requested page : index.htm or login.htm" );
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

        ModelAndView modelAndView = new ModelAndView();

        modelAndView.setViewName( "register" );

//        modelAndView.addObject( "msg", "user" );

        return modelAndView;
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

        ModelAndView modelAndView = new ModelAndView();

        if ( result.hasErrors() ) {
            //result is BindingResult
            List<ObjectError> allErrors = result.getAllErrors();

            for (ObjectError error : allErrors) {
                frmReg.addErrorsInMap( error.getCode(), messageSource.getMessage( error, Locale.ENGLISH ) );
            }
            modelAndView.addObject( "frmReg", frmReg );

            modelAndView.setViewName( "register" );

        } else {

            Person newPerson = null;
//            ActionResult<Person> actResult = new ActionResult<Person>();
            try {

//                actResult =
//                        personService.createPerson( frmReg.getEmail(), frmReg.getPassword(),
//                                frmReg.getAddressList() );
                newPerson =
                        personService.registerPerson( frmReg.getEmail(), frmReg.getPassword(),
                                frmReg.getAddressList() );

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