package Model;

import javax.persistence.*;
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

    @Column(nullable = false)
    private Address address;
}
