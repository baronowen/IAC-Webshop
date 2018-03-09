package Persistance;

import Model.Order;
import Persistance.Generic.GenericController;
import Persistance.Generic.GenericDao;

public class OrderController extends GenericDao<Order> implements GenericController<Order> {

    public OrderController(){
        super();
    }

}