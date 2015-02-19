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

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author annik
 *
 */
@Controller
@RequestMapping( value = "/admin/su" )
public class AdminSuController {

    /**
     * Show users list.
     * 
     * @param request
     * @param response
     * @return
     */
    @RequestMapping( value = "/edit-user.htm" )
    @ResponseBody
    public ModelAndView usersListUrl( HttpServletRequest request, HttpServletResponse response ) {

        ModelAndView model = new ModelAndView( "edit-user" );
        model.addObject( "msg", "edit user" );

        return model;
    }

}
