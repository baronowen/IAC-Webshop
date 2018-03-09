package Persistance;

import Model.Category;
import Persistance.Generic.GenericController;
import Persistance.Generic.GenericDao;

public class CategoryController extends GenericDao<Category> implements GenericController<Category> {

    public CategoryController(){
        super();
    }

}