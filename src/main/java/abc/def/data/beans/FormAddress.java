/**
 * Copyright 2015. ABN Software. All Rights reserved.<br>
 * <br>
 * Homepage .... http://www.ABNsoft.info<br>
 * <br>
 * Project ..... UserAdmin<br>
 * <br>
 * Author ...... AnNik<br>
 * E-Mail ...... ABN.DEV@mail.ru<br>
 * Created ..... 18 февр. 2015 г.<br>
 * <br>
 */
package abc.def.data.beans;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import abc.def.data.Utils.U;
import abc.def.data.model.Address;

/**
 * @author annik
 *
 */
public class FormAddress {

    private final Logger LOG = LoggerFactory.getLogger( getClass() );

    private List<Address> addressList = new ArrayList<Address>();

    private Map<String, String> errorsMap = new HashMap<String, String>();

    private Long personId;

    private int selectedFrmId;

    /**
     * Getter.
     * 
     * @return the errorsMap
     */
    public Map<String, String> getErrorsMap() {

        return errorsMap;
    }

    /**
     * Setter.
     * 
     * @param errorsMap
     *            the errorsMap to set
     */
    public void setErrorsMap( Map<String, String> errorsMap ) {

        this.errorsMap = errorsMap;
    }

    /**
     * Setter.
     * 
     * @param errorsMap
     *            the errorsMap to set
     */
    public void addErrorsInMap( String key, String errorMessage ) {

        this.errorsMap.put( key, errorMessage );
    }

    /**
     * Getter.
     * 
     * @return the addressList
     */
    public List<Address> getAddressList() {

        return addressList;
    }

    /**
     * Setter.
     * 
     * @param addressList
     *            the addressList to set
     */
    public void setAddressList( List<Address> addressList ) {

        this.addressList = addressList;
    }

    /**
     * Getter.
     * 
     * @return the personId
     */
    public Long getPersonId() {

        return personId;
    }

    /**
     * Setter.
     * 
     * @param personId
     *            the personId to set
     */
    public void setPersonId( Long personId ) {

        this.personId = personId;
    }

    /**
     * Getter.
     * 
     * @return the selectedFrmId
     */
    public int getSelectedFrmId() {

        return selectedFrmId;
    }

    /**
     * Setter.
     * 
     * @param selectedFrmId
     *            the selectedFrmId to set
     */
    public void setSelectedFrmId( int selectedFrmId ) {

        this.selectedFrmId = selectedFrmId;
    }

    /*
     * (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {

        return String.format(
                "FormAddress [LOG=%s, addressList=%s, errorsMap=%s, personId=%s, selectedFrmId=%s]", LOG,
                addressList, errorsMap, personId, selectedFrmId );
    }

}
