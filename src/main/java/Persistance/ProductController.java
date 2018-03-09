package Persistance;

import Model.Product;
import Persistance.Generic.GenericController;
import Persistance.Generic.GenericDao;

public class ProductController extends GenericDao<Product> implements GenericController<Product> {

    public ProductController(){
        super();
    }

}