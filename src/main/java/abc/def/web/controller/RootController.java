/**
 * Project ..... UserAdmin<br>
 * <br>
 * Author ...... AnNik<br>
 * E-Mail ...... ABN.DEV@mail.ru<br>
 * Created ..... 16 февр. 2015 г.<br>
 * <br>
 */
package abc.def.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author annik
 *
 */
@Controller
public class RootController {

    @RequestMapping( value = "/index.htm" )
    @ResponseBody
    public String rootUrl() {

        return "hello";
    }

//    @RequestMapping( value = "/test.htm" )
//    public ModelAndView testUrl( HttpServletRequest request, HttpServletResponse response ) {
//
//        ModelAndView model = new ModelAndView( "test" );
//        model.addObject( "msg", "test" );
//
//        return model;
//    }

    @RequestMapping( value = "/login.htm" )
    public ModelAndView loginUrl( HttpServletRequest request, HttpServletResponse response ) {

        ModelAndView model = new ModelAndView( "login" );
        model.addObject( "msg", "login" );

        return model;
    }

    @RequestMapping( value = "/register.htm" )
    public ModelAndView userUrl( HttpServletRequest request, HttpServletResponse response ) {

        ModelAndView model = new ModelAndView( "register" );
        model.addObject( "msg", "user" );

        return model;
    }

//    @RequestMapping( value = "/users-list.htm" )
//    public ModelAndView usersListUrl( HttpServletRequest request, HttpServletResponse response ) {
//        
//        ModelAndView model = new ModelAndView( "users-list" );
//        model.addObject( "msg", "user" );
//        
//        return model;
//    }
//    
//    @RequestMapping( value = "/user-edit.htm" )
//    public ModelAndView userEditUrl( HttpServletRequest request, HttpServletResponse response ) {
//
//        ModelAndView model = new ModelAndView( "userEdit" );
//        model.addObject( "msg", "Edit" );
//
//        return model;
//    }
//
//    @RequestMapping( value = "/new-file.htm" )
//    public ModelAndView newUserUrl( HttpServletRequest request, HttpServletResponse response ) {
//
//        ModelAndView model = new ModelAndView( "NewFile" );
//        model.addObject( "msg", "NewFile" );
//
//        return model;
//    }

}