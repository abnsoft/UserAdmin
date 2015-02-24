/**
 * Project ..... UserAdmin<br>
 * <br>
 * Author ...... AnNik<br>
 * E-Mail ...... ABN.DEV@mail.ru<br>
 * Created ..... 17 февр. 2015 г.<br>
 * <br>
 */
package abc.def.data.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import abc.def.data.model.Address;
import abc.def.data.model.Person;

/**
 * @author annik
 *
 */
public interface AddressRepository extends JpaRepository<Address, Long> {

    /**
     * Find {@link Address} by Country+City+Street+HouseNumber
     * 
     * @param address
     * @return {@link Address}
     */
    Address findByCountryAndCityAndStreetAndHouseNumber( String country, String city, String street,
            int houseNumber );

}
