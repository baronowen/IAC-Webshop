import Model.*;
import Persistance.Dao.AddressDao;
import Persistance.Dao.OrderDao;

import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        OrderDao oc = new OrderDao();

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
    }
}
