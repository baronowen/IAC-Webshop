package Persistance;

import Model.OrderLine;
import Persistance.Generic.GenericController;
import Persistance.Generic.GenericDao;

public class OrderLineController extends GenericDao<OrderLine> implements GenericController<OrderLine> {

    public OrderLineController(){
        super();
    }

}