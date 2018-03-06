package Model;

import javax.persistence.*;

@Entity
@Table(name = "Address")
public class Address {
    @Id
    @GeneratedValue
    @Column(name = "id", unique = true, nullable = false)
    private int id;

    @Column(name = "street", nullable = false)
    private String street;

    @Column(name = "number", nullable = false)
    private int number;

    @Column(name = "city")
    private String city;

    @Column(name = "zipcode")
    private String zipcode;
}
