package Persistance;


import Model.Product;
import Persistance.Dao.ProductDao;
import Persistance.Generic.GenericController;

import java.util.ArrayList;

public class ProductController implements GenericController<Product> {
    private static ProductController instance = null;
    private ProductDao productDao;

    //region instance
    public static ProductController getInstance() {
        if(instance == null) {
            instance = new ProductController();
        }
        return instance;
    }

    private ProductController(){
        productDao = new ProductDao();
    }
    //endregion

    public void update(Product newProduct){
        productDao.update(newProduct);
    }

    public void delete(Product delProduct){
        productDao.delete(delProduct);
    }

    public void insert(Product newProduct){
        productDao.insert(newProduct);
    }

    public Product findById(int id){
        return productDao.findById(id);
    }

    public ArrayList<Product> findAll(){
        return productDao.findAll();
    }
}
