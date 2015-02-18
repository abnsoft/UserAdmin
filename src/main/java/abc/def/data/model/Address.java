/**
 * Copyright 2015. ABN Software. All Rights reserved.<br>
 * <br>
 * Homepage .... http://www.ABNsoft.info<br>
 * <br>
 * Project ..... UserAdmin<br>
 * <br>
 * Author ...... AnNik<br>
 * E-Mail ...... ABN.DEV@mail.ru<br>
 * Created ..... 17 февр. 2015 г.<br>
 * <br>
 */
package abc.def.data.model;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * @author annik
 *
 */
@Entity
@Table( name = "ADDRESS" )
public class Address {

    @Id
    @GeneratedValue( strategy = GenerationType.AUTO )
    private long id;

    @Column( length = 128 )
    private String country;

    @Column( length = 64 )
    private String city;

    @Column( length = 64 )
    private String street;

    @Column( name = "housenum" )
    private Integer houseNumber;

    @ManyToMany( mappedBy = "addressCollection" )
    public Collection<Person> personCollection;

}
