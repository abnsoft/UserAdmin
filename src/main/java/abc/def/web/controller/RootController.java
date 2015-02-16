/**
 * Copyright 2015. ABN Software. All Rights reserved.<br>
 * <br>
 * Homepage .... http://www.ABNsoft.info<br>
 * <br>
 * Project ..... UserAdmin<br>
 * <br>
 * Author ...... AnNik<br>
 * E-Mail ...... ABN.DEV@mail.ru<br>
 * Created ..... 16 февр. 2015 г.<br>
 * <br>
 */
package abc.def.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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

}
