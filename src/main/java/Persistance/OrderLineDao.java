package Persistance;

import Model.OrderLine;
import Persistance.Generic.GenericController;
import Persistance.Generic.GenericDao;

public class OrderLineDao extends GenericDao<OrderLine> implements GenericController<OrderLine> {

    public OrderLineDao(){
        super();
    }

}