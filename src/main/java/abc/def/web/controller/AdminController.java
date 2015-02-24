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

import static abc.def.data.Utils.MVC_REDIRECT;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import abc.def.data.beans.FormUsersList;
import abc.def.data.model.Person;
import abc.def.data.service.PersonService;

/**
 * @author annik
 *
 */
@Controller
@RequestMapping( value = "/admin" )
public class AdminController {

    private final Logger LOG = LoggerFactory.getLogger( getClass() );

    @Autowired
    private PersonService personService;

    public static final String PATH_ADMIN = "/admin";

    /**
     * Method invoked after successful login.
     * 
     * @param request
     * @param response
     * @return
     */
    @RequestMapping( value = "/logined.htm" )
    public String
            usersListUrl( Principal principal, HttpServletRequest request, HttpServletResponse response ) {

        LOG.debug( "login to system : {}", principal.getName() );

        personService.updateSessionForPerson( request.getSession(), principal.getName() );

        String nextUrl = MVC_REDIRECT + PATH_ADMIN + "/users-list.htm";

        return nextUrl;
    }

    /**
     * Show users list.
     * 
     * @param request
     * @param response
     * @return
     */
    @RequestMapping( value = "/users-list.htm" )
    public ModelAndView usersListUrl( Principal principal, HttpServletRequest request ) {

        int pageNumber = 1;

        // read N records of users, using PAGING.
        List<Person> pagesOfPerson = personService.pagePersons( pageNumber );

        ModelAndView mav = new ModelAndView( PATH_ADMIN + "/users-list" );

        List<FormUsersList> frmUserList = new ArrayList<FormUsersList>();
        for (Person person : pagesOfPerson) {
            frmUserList.add( new FormUsersList( person ) );
        }
        // put users collection into model
        mav.addObject( "persons", frmUserList );

        return mav;
    }
}
