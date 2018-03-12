package Persistance;

import Model.Order;
import Persistance.Generic.GenericController;
import Persistance.Generic.GenericDao;

public class OrderDao extends GenericDao<Order> implements GenericController<Order> {

    public OrderDao(){
        super();
    }

}