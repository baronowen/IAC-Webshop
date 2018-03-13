package Persistance.Dao;

import Model.Customer;
import Persistance.Generic.GenericController;
import Persistance.Generic.GenericDao;

public class CustomerDao extends GenericDao<Customer> implements GenericController<Customer> {

    public CustomerDao(){
        super();
    }

}