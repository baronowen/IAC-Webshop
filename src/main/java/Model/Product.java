package Model;

import javax.persistence.*;

@Entity
@Table(name = "Product")
public class Product {
    @Id
    @GeneratedValue
    @Column(unique = true, nullable = false)
    private int id;

    @Column()
    private String name;

    @Column()
    private double price;

    @Column()
    private String description;

    private Product(){}

    public Product(String name, double price, String description) {
        this.name = name;
        this.price = price;
        this.description = description;
    }
}
