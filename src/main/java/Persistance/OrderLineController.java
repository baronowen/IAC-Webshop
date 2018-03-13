package Persistance;

import Model.OrderLine;
import Persistance.Dao.OrderLineDao;
import Persistance.Generic.GenericController;

import java.util.ArrayList;

public class OrderLineController implements GenericController<OrderLine> {
    private static OrderLineController instance = null;
    private OrderLineDao orderLineDao;

    //region instance
    public static OrderLineController getInstance() {
        if(instance == null) {
            instance = new OrderLineController();
        }
        return instance;
    }

    private OrderLineController(){
        orderLineDao = new OrderLineDao();
    }
    //endregion

    public void update(OrderLine newOrderLine){
        orderLineDao.update(newOrderLine);
    }

    public void delete(OrderLine delOrderLine){
        orderLineDao.delete(delOrderLine);
    }

    public void insert(OrderLine newOrderLine){
        orderLineDao.insert(newOrderLine);
    }

    public OrderLine findById(int id){
        return orderLineDao.findById(id);
    }

    public ArrayList<OrderLine> findAll(){
        return orderLineDao.findAll();
    }
}
