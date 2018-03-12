package Controller;

import Model.Account;
import Persistance.AccountDao;

import java.util.ArrayList;

public class AccountController {
    private static AccountController instance = null;
    private AccountDao accountDao;

    //region instance
    public static AccountController getInstance() {
        if(instance == null) {
            instance = new AccountController();
        }
        return instance;
    }

    private AccountController(){
        accountDao = new AccountDao();
    }
    //endregion

    public void update(Account newAccount){
        accountDao.update(newAccount);
    }

    public void delete(Account delAccount){
        accountDao.delete(delAccount);
    }

    public void insert(Account newAccount){
        accountDao.insert(newAccount);
    }

    public Account findById(int id){
        return accountDao.findById(id);
    }

    public ArrayList<Account> findAll(){
        return accountDao.findAll();
    }
}
