package Model;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "Account")
public class Account {
    @Id
    @GeneratedValue
    @Column
    private int id;

    @Column(nullable = false)
    @Type(type="date")
    private Date openDate;

    @OneToOne(cascade = CascadeType.ALL)
    private Address invoiceAddress;

    @JoinColumn()
    @OneToOne
    private Customer customer;

    @Column
    private boolean isActive;

    @Column(unique = true)
    private String email;

    @Column
    private String password;

    @Column
    private AccountRole role;

    private Account(){}

    public Account(Date openDate, Address invoiceAddress, Customer customer, boolean isActive, String email, String password, AccountRole role) {
        this.openDate = openDate;
        this.invoiceAddress = invoiceAddress;
        this.customer = customer;
        this.isActive = isActive;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    //region getters/setters

    public int getId() {
        return id;
    }

    public Date getOpenDate() {
        return openDate;
    }

    public void setOpenDate(Date openDate) {
        this.openDate = openDate;
    }

    public Address getInvoiceAddress() {
        return invoiceAddress;
    }

    public void setInvoiceAddress(Address invoiceAddress) {
        this.invoiceAddress = invoiceAddress;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public AccountRole getRole() {
        return role;
    }

    public void setRole(AccountRole role) {
        this.role = role;
    }

    //endregion

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", openDate=" + openDate +
                ", invoiceAddress=" + invoiceAddress +
                ", customer=" + customer +
                ", isActive=" + isActive +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
