package Persistance.Dao;

import Model.Account;
import Model.Sale;
import Persistance.Generic.GenericController;
import Persistance.Generic.GenericDao;
import org.hibernate.Session;

import javax.persistence.Query;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class SaleDao extends GenericDao<Sale> implements GenericController<Sale> {

    public SaleDao(){
        super();
    }

    public ArrayList<Sale> findByThisWeek(){

        // Get current week and year
        Calendar cal = Calendar.getInstance();
        int week = (cal.get(Calendar.WEEK_OF_YEAR));
        int year = cal.get(Calendar.YEAR);

        ArrayList<Sale> saleList = new ArrayList<>();
        Session session = super.getSession();

        try {
            Query query = session.createQuery("from " + Sale.class.getName() + " where (WEEK)fromDate = :week AND (YEAR)fromDate = :year ");
            query.setParameter("week", week);
            query.setParameter("year", year);

            saleList = (ArrayList) query.getResultList();
        } catch (Exception e) {
            //e.printStackTrace();
        } finally {
            session.close();
        }

        // return the found sales of this week
        return saleList;



    }

}