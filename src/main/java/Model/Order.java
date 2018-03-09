package Model;

import org.hibernate.annotations.JoinColumnOrFormula;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Set;

@Entity
@Table(name = "Orders")
public class Order {
    @Id
    @GeneratedValue
    private int id;

    @JoinColumn(nullable = false)
    @OneToOne(cascade = CascadeType.ALL)
    private Address deliveryAddress;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<OrderLine> lines;

    private Order(){}

    public Order(Address deliveryAddress, Set<OrderLine> lines) {
        this.deliveryAddress = deliveryAddress;
        this.lines = lines;
    }

    //region getters/setters

    public int getId() {
        return id;
    }


    public Address getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(Address deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public Set<OrderLine> getLines() {
        return lines;
    }

    public void setLines(Set<OrderLine> lines) {
        this.lines = lines;
    }

    //endregion


    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", deliveryAddress=" + deliveryAddress +
                ", lines=" + lines +
                '}';
    }
}
