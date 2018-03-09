package Model;

import javax.persistence.*;

@Entity
@Table(name = "OrderLine")
public class OrderLine {
    @Id
    @GeneratedValue
    @Column
    private int id;

//    @ManyToOne
//    @JoinColumn(name="order_id", nullable=false)
//    private Order order;

    @Column()
    private int amount;

    @Column()
    private double price;

    @OneToOne(cascade = CascadeType.ALL)
    private Product product;

    private OrderLine(){}

    public OrderLine(int amount, double price, Product product) {
        this.amount = amount;
        this.price = price;
        this.product = product;
    }
}
