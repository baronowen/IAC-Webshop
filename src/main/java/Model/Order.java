package Model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class Order {
    @Id
    @GeneratedValue
    @Column(nullable = true)
    private int id;

    private Address deliveryAddress;
}
