package Persistance;

import Model.Category;
import Persistance.Dao.CategoryDao;
import Persistance.Generic.GenericController;

import java.util.ArrayList;

public class CategoryController implements GenericController<Category> {
    private static CategoryController instance = null;
    private CategoryDao categoryDao;

    //region instance
    public static CategoryController getInstance() {
        if(instance == null) {
            instance = new CategoryController();
        }
        return instance;
    }

    private CategoryController(){
        categoryDao = new CategoryDao();
    }
    //endregion

    public void update(Category newCategory){
        categoryDao.update(newCategory);
    }

    public void delete(Category delCategory){
        categoryDao.delete(delCategory);
    }

    public void insert(Category newCategory){
        categoryDao.insert(newCategory);
    }

    public Category findById(int id){
        return categoryDao.findById(id);
    }

    public ArrayList<Category> findAll(){
        return categoryDao.findAll();
    }
}
