package Tests;

import Model.Account;
import Persistance.AccountController;
import Webservices.AccountResource;
import io.jsonwebtoken.lang.Assert;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class AccountResourceTest {

    @Test
    void getAllAccounts() {
        AccountResource aTest = new AccountResource();
        Assert.notNull(aTest.getAllAccounts());
    }

    @Test
    void getAccountById() {
        AccountResource aTest = new AccountResource();
        AccountController aC = AccountController.getInstance();
        ArrayList<Account> accounts = aC.findAll();
        Assert.notNull(aTest.getAccountById(accounts.get(1).getId()));
    }
}