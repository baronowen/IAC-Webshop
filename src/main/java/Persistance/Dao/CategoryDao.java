package Persistance.Dao;

import Model.Category;
import Persistance.Generic.GenericController;
import Persistance.Generic.GenericDao;

public class CategoryDao extends GenericDao<Category> implements GenericController<Category> {

    public CategoryDao(){
        super();
    }

}