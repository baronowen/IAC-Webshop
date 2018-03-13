package Persistance;

import Model.Account;
import Model.Address;
import Persistance.Dao.AddressDao;
import Persistance.Generic.GenericController;

import java.util.ArrayList;

public class AddressController implements GenericController<Address> {
    private static AddressController instance = null;
    private AddressDao addressDao;

    //region instance
    public static AddressController getInstance() {
        if(instance == null) {
            instance = new AddressController();
        }
        return instance;
    }

    private AddressController(){
        addressDao = new AddressDao();
    }
    //endregion

    public void update(Address newAddress){
        addressDao.update(newAddress);
    }

    public void delete(Address delAddress){
        addressDao.delete(delAddress);
    }

    public void insert(Address newAddress){
        addressDao.insert(newAddress);
    }

    public Address findById(int id){
        return addressDao.findById(id);
    }

    public ArrayList<Address> findAll(){
        return addressDao.findAll();
    }
}
