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
package abc.def.web.controller;

import java.security.Principal;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.Validator;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import abc.def.data.DefaultConfig;
import abc.def.data.UserRole;
import abc.def.data.Utils;
import abc.def.data.Utils.U;
import abc.def.data.beans.FormUser;
import abc.def.data.model.Address;
import abc.def.data.model.Person;
import abc.def.data.repositories.PersonRepository;
import abc.def.data.service.PersonService;

/**
 * @author annik
 *
 */
@Controller
@RequestMapping( value = "/admin/su" )
public class AdminSuController {

    private final Logger LOG = LoggerFactory.getLogger( getClass() );

    public static final String PATH_ADMIN_SU = "/admin/su";

    @Autowired
    private PersonService personService;

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private ResourceBundleMessageSource messageSource;

    @Autowired
    @Qualifier( "frmUserValidator" )
    private Validator validator;

    @InitBinder
    private void initBinder( WebDataBinder binder ) {

        binder.setValidator( validator );
    }

    /**
     * Show users list.
     * 
     * @param request
     * @param response
     * @return
     */
    @RequestMapping( value = "/user.htm", method = RequestMethod.GET )
    public ModelAndView userShowCard( @RequestParam( value = "userId", required = false ) Long userId,
            HttpServletRequest request ) {

        LOG.debug( "UserInfo GET" );

        ModelAndView mav = new ModelAndView();
        if ( userId == null || userId == 0 ) {
            LOG.warn( "Invalid request!" );
            mav.setViewName( U.MVC_REDIRECT + AdminController.PATH_ADMIN + "/users-list"
                    + DefaultConfig.WEB_PAGE_EXTENSTION );

        } else {
            // userId is not empty 
            mav.setViewName( PATH_ADMIN_SU + "/user" );

            Person person = personRepository.findById( userId );

            mav.addObject( "frmUser", person );

            mav.addObject( "frmUserJsOnlyOneNewAddress",
                    U.getMsg( "frmUser.js.onlyOneNewAddress", messageSource, null, request ) );

            frmUserCommon( request, mav );

            // Addresses
            List<Address> addressList = (List<Address>) person.getAddresses();
            mav.addObject( "addrList", addressList );

            // set in form count of addresses 
            mav.addObject( "savedAddressesNumber", addressList.size() );

        }

        return mav;
    }

    /**
     * Update user info.
     * 
     * @param frmUser
     * @param result
     * @param request
     * @return {@link ModelAndView}
     */
    @RequestMapping( value = "/user.htm", method = RequestMethod.POST )
    public @ResponseBody ModelAndView editUserSave( @ModelAttribute @Validated FormUser frmUser,
            BindingResult result, HttpServletRequest request, Principal principal ) {

        LOG.debug( "UserInfo POST" );

        ModelAndView mav = new ModelAndView();
        // get real date to replace not updated date 
        Person person = personRepository.findById( frmUser.getId() );

        // check form errors 
        if ( result.hasErrors() ) {

            // errors found - will be redirect to back 
            mav.setViewName( PATH_ADMIN_SU + "/user" );

            // check Errors, add them into model to show on the page 
            List<ObjectError> allErrors = result.getAllErrors();
            Map<String, String> errorsMap = new HashMap<String, String>();

            for (ObjectError error : allErrors) {
                errorsMap.put( error.getCode(), messageSource.getMessage( error, Locale.ENGLISH ) );
            }
            mav.addObject( "frmUserErr", errorsMap );

            mav.addObject( "frmUserJsOnlyOneNewAddress",
                    U.getMsg( "frmUser.js.onlyOneNewAddress", messageSource, null, request ) );

            frmUserCommon( request, mav );

            // Addresses
            List<Address> addressList = (List<Address>) person.getAddresses();
            mav.addObject( "addrList", addressList );

        } else {

            String loginedUserName = principal.getName();
            Person checkPerson = personService.getPersonByEmail( loginedUserName );

            Long userid = checkPerson != null ? checkPerson.getId() : null;

            if ( userid != null ) {

                // in case current user is selected, check whether email is changed  
                if ( userid == person.getId() ) {

                    String userNameUpdate = person.getEmail();

                    // replace current with new 
                    if ( !loginedUserName.equals( userNameUpdate ) ) {
                        request.getSession()
                                .setAttribute( DefaultConfig.SESSION_USER_NAME, person.getEmail() );
                    }
                }
                person = personService.updatePerson( person, request.getParameterMap() );
                LOG.debug( "update person : {}", person );
//                mav.setViewName( U.MVC_REDIRECT + PATH_ADMIN_SU + "/user" + DefaultConfig.WEB_PAGE_EXTENSTION );
                mav.setViewName( U.MVC_REDIRECT + PATH_ADMIN_SU + "/user" + DefaultConfig.WEB_PAGE_EXTENSTION
                        + "?userId=" + person.getId() );

                mav.addObject( "msgToUser",
                        U.getMsg( "AdminSuController.Update.User.Fine", messageSource, null, request ) );

            } else {
                mav.setViewName( U.MVC_REDIRECT + RootController.ROOT_LOGIN_HTM );
                try {
                    request.logout();

                } catch (ServletException e) {
                    LOG.error( "LOGOUT failed. ", e );
                }
            }
        }
        mav.addObject( "frmUser", person );

        return mav;
    }

    /**
     * @param request
     * @param mav
     */
    private void frmUserCommon( HttpServletRequest request, ModelAndView mav ) {

        mav.addObject( "personRoles", UserRole.values() );

        mav.addObject( "timezonesList", (TreeMap<Integer, String>) Utils.TimeZoneArray() );

        mav.addObject( "personCurId", request.getSession().getAttribute( DefaultConfig.SESSION_USER_ID ) );

        mav.addObject( "personRoleCur", request.getSession().getAttribute( DefaultConfig.SESSION_USER_ROLE ) );
    }

}
