package Persistance.Dao;

import Model.Account;
import Persistance.Generic.GenericController;
import Persistance.Generic.GenericDao;

public class AccountDao extends GenericDao<Account> {

    public AccountDao(){
        super();
    }

    //TODO Add functionality
    public boolean isLoginCorrect(String username, String password){

        return true;

    }

}