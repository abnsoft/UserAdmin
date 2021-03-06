/**
 * Project ..... UserAdmin<br>
 * <br>
 * Author ...... AnNik<br>
 * E-Mail ...... ABN.DEV@mail.ru<br>
 * Created ..... 17 ����. 2015 �.<br>
 * <br>
 */
package abc.def.data.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import abc.def.data.model.Person;

/**
 * @author annik
 *
 */
public interface PersonRepository extends JpaRepository<Person, Long> {

    /**
     * Find {@link Person} by given {@code email}.
     * 
     * @param email
     * @return {@link Person}
     */
    Person findByEmail( String email );

    /**
     * Find {@link Person} by given {@code userId}.
     * 
     * @param userId
     * @return {@link Person}
     */
    Person findById( long userId );
    
    

}
