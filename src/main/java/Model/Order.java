package Model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Set;

@Entity
@Table(name = "Orders")
public class Order {
    @Id
    @GeneratedValue
    private int id;

    @OneToOne(cascade = CascadeType.ALL)
    private Address deliveryAddress;

    @OneToMany(fetch = FetchType.EAGER/*, mappedBy = "order"*/, cascade = CascadeType.ALL)
    private Set<OrderLine> lines;

    private Order(){}

    public Order(Address deliveryAddress, Set<OrderLine> lines) {
        this.deliveryAddress = deliveryAddress;
        this.lines = lines;
    }
}
