package Model;

import javax.persistence.*;

@Entity
@Table(name = "Address")
public class Address {
    @Id
    @GeneratedValue
    private int id;

    @Column(name = "street", nullable = false)
    private String street;

    @Column(name = "number", nullable = false)
    private int number;

    @Column(name = "city")
    private String city;

    @Column(name = "zipcode")
    private String zipcode;

    private Address(){}

    public Address(String street, int number, String city, String zipcode) {
        this.street = street;
        this.number = number;
        this.city = city;
        this.zipcode = zipcode;
    }
}
