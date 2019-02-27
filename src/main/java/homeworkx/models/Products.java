package homeworkx.models;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "products", schema = "MA_STUDENT")
public class Products implements Serializable {

    private String mfr_id;
    private String product_id;
    private String description;
    private BigDecimal price;
    private BigDecimal qty_on_hand;
    private Set<Order> orders = new HashSet<>();

    public Products() {
    }

    public Products(String product_id) {
        this.product_id = product_id;
    }

    public void setAll(Products p) {
        this.mfr_id = p.mfr_id;
        this.product_id = p.product_id;
        this.description = p.description;
        this.price = p.price;
        this.qty_on_hand = p.qty_on_hand;
        this.orders = p.orders;
    }


    @Column(name = "mfr_id")
    public String getMfr_id() {
        return mfr_id;
    }

    public void setMfr_id(String mfr_id) {
        this.mfr_id = mfr_id;
    }

    @Id
    @Column(name = "product_id")
    public String getProduct_id() {
        return product_id;
    }

    public void setProduct_id(String product_id) {
        this.product_id = product_id;
    }

    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Column(name = "price")
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Column(name = "qty_on_hand")
    public BigDecimal getQty_on_hand() {
        return qty_on_hand;
    }

    public void setQty_on_hand(BigDecimal qty_on_hand) {
        this.qty_on_hand = qty_on_hand;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "product")
    public Set<Order> getOrders() {
        return orders;
    }

    public void setOrders(Set<Order> orders) {
        this.orders = orders;
    }



    @Override
    public String toString() {
        return "Products{" +
                "mfr_id='" + mfr_id + '\'' +
                ", product_id='" + product_id + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", qty_on_hand=" + qty_on_hand +
                '}';
    }
}