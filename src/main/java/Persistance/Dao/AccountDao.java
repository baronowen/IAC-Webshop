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
    public String isLoginCorrect(String username, String password) {

        Session session = super.getSession();
        Account account;
        try {
            Query query = session.createQuery("from " + Account.class.getName() + " where email = :email AND password = :password ");
            query.setParameter("email", username);
            query.setParameter("password", password);

            // if there is no account, it throws an error
            account = (Account) query.getResultList().get(0);
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Login unsuccesfull, password: " + password + " didn't match!");
            return null;
        } finally {
            session.close();
        }


        System.out.println("Login succes, role: " + account.getRole().toString());

        // if an account was found, return true
        return account.getRole().toString();
    }


    //TODO Add functionality
    public String getAccountByEmail(String email) {

        Account account;
        try (Session session = super.getSession()) {
            Query query = session.createQuery("from " + Account.class.getName() + " where email = :email");
            query.setParameter("email", email);

            // if there is no account, it throws an error
            account = (Account) query.getResultList().get(0);
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Couldn't find account");
            return null;
        }

        // if an account was found, return true
        return account.getRole().toString();
    }

}