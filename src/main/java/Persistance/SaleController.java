package Persistance;

import Model.Sale;
import Persistance.Generic.GenericController;
import Persistance.Generic.GenericDao;

public class SaleController extends GenericDao<Sale> implements GenericController<Sale> {

    public SaleController(){
        super();
    }

}