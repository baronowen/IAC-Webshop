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

    @JoinColumn(nullable = false)
    @OneToOne(cascade = CascadeType.ALL)
    private Address address;

    private Customer(){}

    public Customer(String name, String surName, int telephoneNumber, String birthDate, Address address) {
        this.name = name;
        this.surName = surName;
        this.telephoneNumber = telephoneNumber;
        this.birthDate = birthDate;
        this.address = address;
    }

    //region getters/setters

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public int getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(int telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }


    //endregion

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surName='" + surName + '\'' +
                ", telephoneNumber=" + telephoneNumber +
                ", birthDate='" + birthDate + '\'' +
                ", address=" + address +
                '}';
    }
}
