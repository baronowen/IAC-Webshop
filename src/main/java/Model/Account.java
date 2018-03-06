package Model;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.sql.Date;

public class Account {
    @Id
    @GeneratedValue
    @Column(name = "id", unique = true, nullable = false)
    private int id;

    @Column()
    @Type(type="date")
    private Date openDate;

    @Column()
    private Address invoiceAddress;

    @Column()
    private Customer customer;

    @Column()
    private boolean isActive;

    @Column()
    private String password;
}
