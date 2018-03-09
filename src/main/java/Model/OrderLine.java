package Model;

import javax.persistence.*;

@Entity
@Table(name = "OrderLine")
public class OrderLine {
    @Id
    @GeneratedValue
    @Column(nullable = false)
    private int id;

    @Column(nullable = false)
    private int amount;

    @JoinColumn(nullable = false)
    @OneToOne(cascade = CascadeType.ALL)
    private Product product;

    private OrderLine(){}

    public OrderLine(int amount, Product product) {
        this.amount = amount;
        this.product = product;
    }

    //region getters/setters

    public int getId() {
        return id;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    //endregion

    @Override
    public String toString() {
        return "OrderLine{" +
                "id=" + id +
                ", amount=" + amount +
                ", product=" + product +
                '}';
    }
}
