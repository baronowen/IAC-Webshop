package Persistance;

import Model.Account;
import Model.Address;
import Persistance.Generic.GenericController;
import Persistance.Generic.GenericDao;

public class AddressDao extends GenericDao<Address> implements GenericController<Address> {

    public AddressDao(){
        super();
    }

}