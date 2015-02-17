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

    @RequestMapping( value = "/test.htm" )
    @ResponseBody
    public ModelAndView testUrl( HttpServletRequest request, HttpServletResponse response ) {

        ModelAndView model = new ModelAndView( "test" );
        model.addObject( "msg", "Controller Interface Example!" );
        
        return model;
    }
}
