package Persistance;

import Model.Sale;
import Persistance.Dao.SaleDao;
import Persistance.Generic.GenericController;

import java.util.ArrayList;

public class SaleController implements GenericController<Sale> {
    private static SaleController instance = null;
    private SaleDao saleDao;

    //region instance
    public static SaleController getInstance() {
        if(instance == null) {
            instance = new SaleController();
        }
        return instance;
    }

    private SaleController(){
        saleDao = new SaleDao();
    }
    //endregion

    public void update(Sale newSale){
        saleDao.update(newSale);
    }

    public void delete(Sale delSale){
        saleDao.delete(delSale);
    }

    public void insert(Sale newSale){
        saleDao.insert(newSale);
    }

    public Sale findById(int id){
        return saleDao.findById(id);
    }

    public ArrayList<Sale> findAll(){
        return saleDao.findAll();
    }

    public ArrayList<Sale> findByThisWeek(){
        return saleDao.findByThisWeek();
    }
}
