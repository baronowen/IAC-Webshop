package Persistance;

import Model.Customer;
import Persistance.Generic.GenericController;
import Persistance.Generic.GenericDao;

public class CustomerController extends GenericDao<Customer> implements GenericController<Customer> {

    public CustomerController(){
        super();
    }

}