package Persistance;

import Model.Order;
import Persistance.Dao.OrderDao;
import Persistance.Generic.GenericController;

import java.util.ArrayList;

public class OrderController implements GenericController<Order> {
    private static OrderController instance = null;
    private OrderDao orderDao;

    //region instance
    public static OrderController getInstance() {
        if(instance == null) {
            instance = new OrderController();
        }
        return instance;
    }

    private OrderController(){
        orderDao = new OrderDao();
    }
    //endregion

    public void update(Order newOrder){
        orderDao.update(newOrder);
    }

    public void delete(Order delOrder){
        orderDao.delete(delOrder);
    }

    public void insert(Order newOrder){
        orderDao.insert(newOrder);
    }

    public Order findById(int id){
        return orderDao.findById(id);
    }

    public ArrayList<Order> findAll(){
        return orderDao.findAll();
    }
}
