package Model;

import org.hibernate.annotations.JoinColumnOrFormula;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Set;

@Entity
@Table(name = "Orders")
public class Order {
    @Id
    @GeneratedValue
    private int id;

    @JoinColumn(nullable = false)
    @OneToOne(cascade = CascadeType.ALL)
    private Account account;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<OrderLine> lines;

    private Order(){}

    public Order(Account acoount, Set<OrderLine> lines) {
        this.account = acoount;
        this.lines = lines;
    }

    //region getters/setters

    public int getId() {
        return id;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Set<OrderLine> getLines() {
        return lines;
    }

    public void setLines(Set<OrderLine> lines) {
        this.lines = lines;
    }

    //endregion

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", account=" + account +
                ", lines=" + lines +
                '}';
    }
}
