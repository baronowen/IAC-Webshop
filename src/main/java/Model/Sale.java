package Model;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "Sale")
public class Sale {
    @Id
    @GeneratedValue
    @Column(unique = true, nullable = false)
    private int id;

    @Column(nullable = false)
    private Date fromDate;

    @Column(nullable = false)
    private Date toDate;

    @Column(nullable = false)
    private double salePrice;

    @Column
    private String description;

    @OneToOne
    private Product product;

    public Sale() {}

    public Sale(Date fromDate, Date toDate, double salePrice, String description, Product product) {
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.salePrice = salePrice;
        this.description = description;
        this.product = product;
    }

    //region getters/setters

    public int getId() {
        return id;
    }

    public Date getFromDate() {
        return fromDate;
    }

    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }

    public Date getToDate() {
        return toDate;
    }

    public void setToDate(Date toDate) {
        this.toDate = toDate;
    }

    public double getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(double salePrice) {
        this.salePrice = salePrice;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    //endregion

    @Override
    public String toString() {
        return "Sale{" +
                "id=" + id +
                ", fromDate=" + fromDate +
                ", toDate=" + toDate +
                ", salePrice=" + salePrice +
                ", description='" + description + '\'' +
                ", product=" + product +
                '}';
    }
}
