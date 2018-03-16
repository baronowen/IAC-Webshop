import Model.*;
import Persistance.Dao.AccountDao;
import Persistance.Dao.AddressDao;
import Persistance.Dao.CustomerDao;
import Persistance.Dao.OrderDao;
import Webservices.Authentication.AuthenticationResource;
import Webservices.Authentication.Encryption;
import Webservices.Resource;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        OrderDao oc = new OrderDao();
        AccountDao ac = new AccountDao();
        CustomerDao cc = new CustomerDao();

        Address address = new Address("straat", 25, "stad", "potcode");

        Category category = new Category("voedsel", "Eigenlijk is het fruit");

        Product apple  = new Product( "appel", 12.50, "omschrijving", category);
        Product peanut = new Product("peanut", 19.50, "omschrijving", category);


        OrderLine olApple  = new OrderLine(5, apple);
        OrderLine olPeanut = new OrderLine(5, peanut);

        Set<OrderLine> lines = new HashSet<OrderLine>();
        lines.add(olApple);
        lines.add(olPeanut);

        Order order = new Order(address, lines);

        oc.insert(order);

        Address address2 = Resource.ADDRESS_CONTROLLER.findAll().get(0);


        Customer customer = new Customer("Nick", "Windt", 643206739, "25-05-1998", address);

        cc.insert(customer);


        Account account = new Account(new Date(20), address2, customer, true, "nickwindt@hotmail.nl", Encryption.encrypt("wachtwoord"), AccountRole.customer);

        ac.insert(account);

        AuthenticationResource ar = new AuthenticationResource();
        ar.authenticateUser("nickwindt@hotmail.nl", "wachtwoord");

    }
}
