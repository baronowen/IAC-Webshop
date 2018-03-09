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

    @Column
    @Type(type="date")
    private Date openDate;

    @OneToOne(cascade = CascadeType.ALL)
    private Address invoiceAddress;

    @OneToOne
    private Customer customer;

    @Column
    private boolean isActive;

    @Column
    private String password;

    private Account(){}
}
