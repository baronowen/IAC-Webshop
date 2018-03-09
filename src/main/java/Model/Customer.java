package Model;

import javax.persistence.*;

@Entity
@Table(name = "Customer")
public class Customer {
    @Id
    @GeneratedValue
    @Column(unique = true, nullable = false)
    private int id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String surName;

    @Column(nullable = false)
    private int telephoneNumber;

    @Column(nullable = false)
    private String birthDate;

    @OneToOne(cascade = CascadeType.ALL)
    private Address address;

    private Customer(){}
}
