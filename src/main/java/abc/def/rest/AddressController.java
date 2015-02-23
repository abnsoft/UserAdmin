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
package abc.def.rest;

import java.util.Locale;
import java.util.Objects;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import abc.def.data.model.Address;
import abc.def.data.model.Person;
import abc.def.data.repositories.PersonRepository;
import abc.def.data.service.AddressService;
import abc.def.data.service.PersonService;
import abc.def.web.beans.FormAddress;
import abc.def.web.beans.JsonResponse;
import abc.def.web.beans.JsonResponse.StatusResponse;

/**
 * This controller is invoked under URL : {context}/admin/rest/*
 * 
 * @author annik
 *
 */
@Controller
public class AddressController {

    public static final String PATH_ADMIN_REST = "";

    private static final Logger LOG = LoggerFactory.getLogger( AddressController.class );

    @Autowired
    private PersonService personService;

    @Autowired
    private AddressService addressService;

    @Autowired
    private ResourceBundleMessageSource messageSource;

    @Autowired
    @Qualifier( "frmAddressValidator" )
    private Validator validator;

    @InitBinder
    private void initBinder( WebDataBinder binder ) {

        binder.setValidator( validator );
    }

    /**
     * Receives JSON and update address.
     * 
     * @param frmUser
     * @param result
     * @param request
     * @return
     */
    @RequestMapping( value = PATH_ADMIN_REST + "/saveAddress", method = RequestMethod.POST )
    @ResponseBody
    public JsonResponse<Address> saveAddress( @ModelAttribute FormAddress frmAddr,
            HttpServletRequest request, HttpServletResponse response, BindingResult result ) {

        LOG.debug( "JSON POST address update is invoked." );

        JsonResponse<Address> jsonResponse = new JsonResponse<Address>();

        Address addr = new Address();

        if ( result.hasErrors() ) {
            LOG.debug( "Invalid data in form : Address update {}", frmAddr.toString() );

        } else {
            // form is valid, we can update or create new address 

            // find Person
            Person selectedPerson = personService.getPersonById( frmAddr.getPersonId() );
            Objects.requireNonNull( selectedPerson );

            if ( frmAddr.getAddressList().size() == 1 ) {
                addr = frmAddr.getAddressList().get( 0 );
                Address dbAddress = addressService.findAddressById( addr.getId() );

                if ( !addr.equals( dbAddress ) ) {
                    // delete old address from user, store . 
                    selectedPerson.removeAddress( dbAddress );
                    personService.save( selectedPerson );

                    // create changed address as new 
                    addr.setId( 0 );

                    // add new address to user 
                    selectedPerson.addAddress( addr );

                    // store with new address
                    personService.save( selectedPerson );
                } else {
                    // address has not been changed, not error
                    jsonResponse.setStatus( StatusResponse.OK );
                    jsonResponse.setMessage( messageSource.getMessage( "addressController.unchaged.address",
                            null, (Locale) request.getSession().getAttribute( "curLocale" ) ) );
                    jsonResponse.setObject( addr );
                }

            } else {
                LOG.error( "Address should be ONE, but it is [{" + frmAddr.getAddressList().size() + "}] " );
            }
        }

        return jsonResponse;
    }

    @RequestMapping( value = PATH_ADMIN_REST + "/saveAddress", method = RequestMethod.GET )
    @ResponseBody
    public String saveAddressGet( @ModelAttribute FormAddress frmAddr, HttpServletRequest request ) {

        LOG.debug( "JSON GET address update is invoked." );

        return "0";
    }

}
