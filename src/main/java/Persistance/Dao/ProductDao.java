package Persistance.Dao;

import Model.Product;
import Persistance.Generic.GenericController;
import Persistance.Generic.GenericDao;

public class ProductDao extends GenericDao<Product> implements GenericController<Product> {

    public ProductDao(){
        super();
    }

}