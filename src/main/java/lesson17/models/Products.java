package lesson17.models;

import java.io.Serializable;
import java.math.BigDecimal;

public class Products implements Serializable {

    private String mfr_id;
    private String product_id;
    private String description;
    private BigDecimal price;
    private BigDecimal qty_on_hand;

    public Products() {
    }

    public Products(String product_id) {
        this.product_id = product_id;
    }

    public Products(String mfr_id, String product_id, String description, BigDecimal price, BigDecimal qty_on_hand) {
        this.mfr_id = mfr_id;
        this.product_id = product_id;
        this.description = description;
        this.price = price;
        this.qty_on_hand = qty_on_hand;
    }

    public String getMfr_id() {
        return mfr_id;
    }

    public void setMfr_id(String mfr_id) {
        this.mfr_id = mfr_id;
    }

    public String getProduct_id() {
        return product_id;
    }

    public void setProduct_id(String product_id) {
        this.product_id = product_id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getQty_on_hand() {
        return qty_on_hand;
    }

    public void setQty_on_hand(BigDecimal qty_on_hand) {
        this.qty_on_hand = qty_on_hand;
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
