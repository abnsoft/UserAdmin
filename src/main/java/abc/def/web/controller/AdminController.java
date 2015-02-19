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

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import abc.def.data.model.Person;
import abc.def.data.repositories.PersonRepository;
import abc.def.data.service.PersonService;

/**
 * @author annik
 *
 */
@Controller
@RequestMapping( value = "/admin" )
public class AdminController {

    @Autowired
    private PersonService personService;

    public static final String PATH_ADMIN = "/admin";

    /**
     * Show users list.
     * 
     * @param request
     * @param response
     * @return
     */
    @RequestMapping( value = "/users-list.htm" )
    @ResponseBody
    public ModelAndView usersListUrl( HttpServletRequest request, HttpServletResponse response ) {

        int pageNumber = 1;

        // read N records of users, using PAGING.
        List<Person> pagesOfPerson = personService.pagePersons( pageNumber );

        ModelAndView mav = new ModelAndView( PATH_ADMIN + "/users-list" );

        // put users collection into model
        mav.addObject( "persons", pagesOfPerson );

        return mav;
    }
}
