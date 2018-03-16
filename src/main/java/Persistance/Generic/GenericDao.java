package Persistance.Generic;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;

public class GenericDao<T> implements GenericController<T> {
    private final SessionFactory sessionFactory;
    private final Class<T> type;

    public Session getSession() {
        return sessionFactory.openSession();
    }

    @SuppressWarnings("unchecked")
    protected GenericDao() {
        this.sessionFactory = HibernateUtil.getSessionFactory();

        Type t = getClass().getGenericSuperclass();
        ParameterizedType pt = (ParameterizedType) t;
        type = (Class<T>) pt.getActualTypeArguments()[0];
    }

    public void insert(T entity) {
        Session session = getSession();
        //Insert a object into the database.
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.save(entity);
            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public void update(T entity) {
        //Update a object into the database.
        Session session = getSession();
        Transaction tx = null;

        try {

            tx = session.beginTransaction();
            session.update(entity);
            tx.commit();

        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

//    public T findById(String id) {
//        Session session = sessionFactory.openSession();
//
//        T entity = session.find(type, id);
//
//        session.close();
//        return entity;
//    }

    public T findById(int id) {
        Session session = getSession();

        T entity = session.find(type, id);

        session.close();
        return entity;

    }

    public void delete(T entity) {
        Session session = getSession();
        Transaction tx = null;

        try {

            tx = session.beginTransaction();
            session.remove(entity);
            tx.commit();

        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    @SuppressWarnings("unchecked")
    public ArrayList<T> findAll() {
        Session session = getSession();

        ArrayList<T> entities = (ArrayList<T>) session.createQuery("from "+type.getName()).getResultList();

        session.close();
        return entities;
    }

}