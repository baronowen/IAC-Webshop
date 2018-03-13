package Persistance;

import Model.Customer;
import Persistance.Dao.CustomerDao;
import Persistance.Generic.GenericController;

import java.util.ArrayList;

public class CustomerController implements GenericController<Customer> {
    private static CustomerController instance = null;
    private CustomerDao customerDao;

    //region instance
    public static CustomerController getInstance() {
        if(instance == null) {
            instance = new CustomerController();
        }
        return instance;
    }

    private CustomerController(){
        customerDao = new CustomerDao();
    }
    //endregion

    public void update(Customer newCustomer){
        customerDao.update(newCustomer);
    }

    public void delete(Customer delCustomer){
        customerDao.delete(delCustomer);
    }

    public void insert(Customer newCustomer){
        customerDao.insert(newCustomer);
    }

    public Customer findById(int id){
        return customerDao.findById(id);
    }

    public ArrayList<Customer> findAll(){
        return customerDao.findAll();
    }
}
