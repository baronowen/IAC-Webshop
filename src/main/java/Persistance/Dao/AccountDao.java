package Persistance.Dao;

import Model.Account;
import Persistance.Generic.GenericController;
import Persistance.Generic.GenericDao;
import org.hibernate.Session;

import javax.persistence.Query;

public class AccountDao extends GenericDao<Account> {

    public AccountDao(){
        super();
    }

    //TODO Add functionality
    public boolean isLoginCorrect(String username, String password) {

        Session session = super.getSession();
        try {
            Query query = session.createQuery("from " + Account.class.getName() + " where email = :email AND password = :password ");
            query.setParameter("email", username);
            query.setParameter("password", password);

            // if there is no account, it throws an error
            Account account = (Account) query.getResultList().get(0);
        } catch (Exception e) {
            //e.printStackTrace();
            return false;
        } finally {
            session.close();
        }

        // if an account was found, return true
        return true;
    }

}