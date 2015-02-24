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

import abc.def.data.model.Address;

/**
 * @author annik
 *
 */
public interface AddressService {

    /**
     * Finde {@link Address} by addressId.
     * 
     * @param addressId
     * @return {@link Address}
     */
    Address findAddressById( Long addressId );

    /**
     * Check {@link Address} is it exist ?
     * 
     * @param address
     * @return {@link Address}
     */
    Address existAddress( Address address );

}
