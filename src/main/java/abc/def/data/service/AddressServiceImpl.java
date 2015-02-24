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
package abc.def.data.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import abc.def.data.model.Address;
import abc.def.data.repositories.AddressRepository;

/**
 * @author annik
 *
 */
@Service( "addressService" )
@Transactional
public class AddressServiceImpl implements AddressService {

    @Autowired
    private AddressRepository addressRepository;

    /*
     * (non-Javadoc)
     * @see abc.def.data.service.AddressService#findAddressById(java.lang.Long)
     */
    @Override
    public Address findAddressById( Long addressId ) {

        return addressRepository.findOne( addressId );
    }

    @Override
    public Address existAddress( Address address ) {

        return addressRepository.findByCountryAndCityAndStreetAndHouseNumber( address.getCountry(),
                address.getCity(), address.getStreet(), address.getHouseNumber() );
    }

}
