import Model.*;
import Persistance.CategoryController;
import Persistance.Dao.OrderDao;
import Persistance.OrderController;
import Persistance.SaleController;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        OrderController oc = OrderController.getInstance();
        CategoryController categoryController = CategoryController.getInstance();
        SaleController saleController = SaleController.getInstance();

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
        Set<Product> products = new HashSet<Product>();
        products.add(apple);
        products.add(peanut);
        products.add(peer);

        Category category = new Category("voedsel", "Eigenlijk is het fruit", products);
        categoryController.insert(category);


        //Create order
        OrderLine olApple  = new OrderLine(5, apple);
        OrderLine olPeanut = new OrderLine(5, peanut);

        Set<OrderLine> lines = new HashSet<OrderLine>();
        lines.add(olApple);
        lines.add(olPeanut);

        Order order = new Order(address, lines);
        oc.insert(order);

        //create sale
        Date dateFrom = Date.valueOf("2018-03-15");
        Date dateTo   = Date.valueOf("2018-03-21");
        Sale sale = new Sale(dateFrom, dateTo, 89.00, "DIKKE TOFFE PEER VOOR VEEL MINDER. WOOOOOOOOOW, ITS AMAZING!", peer);

        saleController.insert(sale);
    }
}
