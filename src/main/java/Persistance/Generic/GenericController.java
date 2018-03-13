package Persistance.Generic;

import java.util.ArrayList;

public interface GenericController<T> {
//    T findById(String id);
    T findById(int id);
    void update(T entity);
    void delete(T entity);
    ArrayList<T> findAll();
    void insert(T entity);
}