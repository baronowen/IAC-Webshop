package Persistance.Dao;

import Model.Sale;
import Persistance.Generic.GenericController;
import Persistance.Generic.GenericDao;
import org.hibernate.Session;

import javax.persistence.Query;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class SaleDao extends GenericDao<Sale> implements GenericController<Sale> {

    public SaleDao(){
        super();
    }

    public ArrayList<Sale> findByThisWeek(){

        // Get current week and year
        Calendar cal = Calendar.getInstance();
        Date date = cal.getTime();

        ArrayList<Sale> saleList = new ArrayList<>();
        Session session = super.getSession();

        try {
            Query query = session.createQuery("from " + Sale.class.getName() + " where :date BETWEEN fromDate AND toDate");
            query.setParameter("date", date);

            saleList = (ArrayList) query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }

        // return the found sales of this week
        return saleList;

    }

}