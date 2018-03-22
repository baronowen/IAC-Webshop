import Model.*;
import Persistance.*;
import Webservices.Authentication.AuthenticationResource;
import Webservices.Authentication.Encryption;
import Webservices.Resource;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {

        OrderController oc = OrderController.getInstance();
        CategoryController categoryController = CategoryController.getInstance();
        SaleController saleController = SaleController.getInstance();
        AccountController ac = AccountController.getInstance();
        CustomerController cc = CustomerController.getInstance();

        Set<Product> products = new HashSet<Product>();

        Address address = new Address("straat", 25, "stad", "potcode");

        Product apple  = new Product.ProductBuilder()
                .name("appel")
                .price(12.50)
                .description("Dikke vette appel")
                .build();

        Product peanut = new Product.ProductBuilder()
                .name("peanut")
                .price(19.50)
                .description("Pinda voor days")
                .build();

        Product peer = new Product.ProductBuilder()
                .name("peer")
                .price(89.50)
                .description("Wat een toffe peer")
                .build();


        //Create category
        products.add(apple);
        products.add(peanut);
        products.add(peer);

        Category category = new Category("voedsel", "Eigenlijk is het fruit", products);
        categoryController.insert(category);


        //Create order
        OrderLine olApple  = new OrderLine(5, apple);
        OrderLine olPeanut = new OrderLine(5, peanut);


        //create sale
        Date dateFrom = Date.valueOf("2018-03-13");
        Date dateTo   = Date.valueOf("2018-03-19");
        Sale sale = new Sale(dateFrom, dateTo, 89.00, "DIKKE TOFFE PEER VOOR VEEL MINDER. WOOOOOOOOOW, ITS AMAZING!", peer);

        saleController.insert(sale);

        Address address2 = new Address("Daltonlaan", 200, "Utrecht", "3577DC");
        Customer customer = new Customer("Nick", "Windt", 643206739, "25-05-1998", address2);
        Account account = new Account(new Date(20), address2, customer, true, "nickwindt@hotmail.nl", Encryption.encrypt("wachtwoord"), AccountRole.customer);

        cc.insert(customer);
        ac.insert(account);

        Set<OrderLine> lines = new HashSet<OrderLine>();
        lines.add(olApple);
        lines.add(olPeanut);

        Order order = new Order(account, lines);
        oc.insert(order);

    }
}
