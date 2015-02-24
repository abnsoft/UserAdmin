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
package abc.def.rest.controller;

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

import abc.def.data.beans.FormAddress;
import abc.def.data.beans.JsonResponse;
import abc.def.data.beans.JsonResponse.StatusResponse;
import abc.def.data.model.Address;
import abc.def.data.model.Person;
import abc.def.data.service.AddressService;
import abc.def.data.service.PersonService;

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
    @RequestMapping( value = PATH_ADMIN_REST + "/saveAddress" /* , method = RequestMethod.POST */)
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

            // if address exists in form data
            if ( frmAddr.getAddressList() != null
                    && frmAddr.getAddressList().size() >= frmAddr.getSelectedFrmId() ) {

                addr = frmAddr.getAddressList().get( frmAddr.getSelectedFrmId() );

                Address dbAddress = addressService.findAddressById( addr.getId() );

                if ( !addr.equals( dbAddress ) ) {

                    // delete address that changed from person 
                    selectedPerson.removeAddress( dbAddress );
                    personService.save( selectedPerson );

                    // create changed address as new, ID w/o persons set.
                    addr = addr.clone();

                    // add new address to user 
                    selectedPerson.addAddress( addr );

                    // get new update address 
                    selectedPerson = personService.save( selectedPerson );
                    for (Address tmpAddr : selectedPerson.getAddresses()) {
                        if ( tmpAddr.equals( addr ) ) {
                            addr = tmpAddr.clone();
                            break;
                        }
                    }

                    jsonResponse.setStatus( StatusResponse.OK );
                    jsonResponse.setMessage( messageSource.getMessage( "addressController.address.updated",
                            null, (Locale) request.getSession().getAttribute( "curLocale" ) ) );

                } else {
                    // address has not been changed, not error
                    jsonResponse.setStatus( StatusResponse.OK );
                    jsonResponse.setMessage( messageSource.getMessage( "addressController.unchaged.address",
                            null, (Locale) request.getSession().getAttribute( "curLocale" ) ) );
                }
                jsonResponse.setObject( addr );

            } else {
                jsonResponse.setMessage( messageSource.getMessage( "addressController.address.invalid.form",
                        null, (Locale) request.getSession().getAttribute( "curLocale" ) ) );
            }

        }

        return jsonResponse;
    }

    @RequestMapping( value = PATH_ADMIN_REST + "/testRest" /* , method = RequestMethod.POST */)
    @ResponseBody
    public JsonResponse<Address> testREST( @ModelAttribute FormAddress frmAddr,
            HttpServletRequest request, HttpServletResponse response, BindingResult result ) {

        JsonResponse<Address> jsonResponse = new JsonResponse<Address>();
        Address addr = new Address();
        addr.setId( 10 );
        addr.setCountry( "RU" );
        addr.setCity( "SPB" );
        addr.setStreet( "Oboynaya" );
        addr.setHouseNumber( 22 );

        jsonResponse.setMessage( "Message response" );
        jsonResponse.setObject( addr );

        return jsonResponse;
    }

}
