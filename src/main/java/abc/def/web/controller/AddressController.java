/**
 * Copyright 2015. ABN Software. All Rights reserved.<br>
 * <br>
 * Homepage .... http://www.ABNsoft.info<br>
 * <br>
 * Project ..... UserAdmin<br>
 * <br>
 * Author ...... AnNik<br>
 * E-Mail ...... ABN.DEV@mail.ru<br>
 * Created ..... 23 февр. 2015 г.<br>
 * <br>
 */
package abc.def.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import abc.def.data.repositories.PersonRepository;
import abc.def.data.service.PersonService;
import abc.def.web.beans.FormAddress;

/**
 * @author annik
 *
 */
@Controller
public class AddressController {

    private final Logger LOG = LoggerFactory.getLogger( getClass() );

    @Autowired
    private PersonService personService;

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private ResourceBundleMessageSource messageSource;

    /**
     * Receives JSON and update address.
     * 
     * @param frmUser
     * @param result
     * @param request
     * @return
     */
    @RequestMapping( value = AdminSuController.PATH_ADMIN_SU + "/saveAddress.htm",
            method = RequestMethod.POST )
    @ResponseBody
    public String saveAddress( @ModelAttribute FormAddress frmAddr, @RequestBody FormAddress frmAddr2,
            HttpServletRequest request, HttpServletResponse response ) {

        LOG.debug( "JSON POST address update is invoked." );

        return "0";
    }

    @RequestMapping( value = AdminSuController.PATH_ADMIN_SU + "/saveAddress.htm", method = RequestMethod.GET )
    @ResponseBody
    public
            String saveAddressGet( @ModelAttribute FormAddress frmAddr, HttpServletRequest request ) {

        LOG.debug( "JSON GET address update is invoked." );

        return "0";
    }

//    @RequestMapping( consumes = MediaType.APPLICATION_JSON_VALUE,
//            produces = MediaType.APPLICATION_JSON_VALUE, value = PATH_ADMIN_SU + "/saveAddress2.htm",
//            method = RequestMethod.POST )
//    @ResponseBody
//    public Address saveAddress2( @ModelAttribute FormAddress frmAddr, HttpServletRequest request ) {
//
//        LOG.debug( "JSON 2 address update is invoked." );
//
//        Address addr = new Address();
//
//        return addr;
//    }

}
