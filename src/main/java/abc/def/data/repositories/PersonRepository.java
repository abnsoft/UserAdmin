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

import abc.def.data.model.Person;

/**
 * @author annik
 *
 */
public interface PersonRepository extends JpaRepository<Person, Long> {

}
