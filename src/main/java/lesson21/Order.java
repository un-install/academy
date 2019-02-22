package lesson21;

import lesson17.models.Products;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "ORDERS", schema = "MA_STUDENT")
public class Order implements Serializable {
    private BigDecimal orderNum;
    private Date date;
    private BigDecimal cust;
    private BigDecimal rep;
    private String mfr;
    private String product;
    private BigDecimal qty;
    private BigDecimal amount;

    public Order() {
    }

    public Order(BigDecimal orderNum) {
        this.orderNum = orderNum;
    }

    public Order(BigDecimal orderNum, Date date, BigDecimal cust, BigDecimal rep, String mfr, BigDecimal qty, BigDecimal amount, String product) {
        this.orderNum = orderNum;
        this.date = date;
        this.cust = cust;
        this.rep = rep;
        this.mfr = mfr;
        this.product = product;
        this.qty = qty;
        this.amount = amount;
    }

    @Id
    @Column(name = "ORDER_NUM")
    public BigDecimal getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(BigDecimal orderNum) {
        this.orderNum = orderNum;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "ORDER_DATE")
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Column(name = "CUST")
    public BigDecimal getCust() {
        return cust;
    }

    public void setCust(BigDecimal cust) {
        this.cust = cust;
    }

    @Column(name = "REP")
    public BigDecimal getRep() {
        return rep;
    }

    public void setRep(BigDecimal rep) {
        this.rep = rep;
    }

    @Column(name = "MFR")
    public String getMfr() {
        return mfr;
    }

    public void setMfr(String mfr) {
        this.mfr = mfr;
    }

    @Transient
    @Column(name = "PRODUCT")
    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    @Column(name = "QTY", precision = 22)
    public BigDecimal getQty() {
        return qty;
    }

    public void setQty(BigDecimal qty) {
        this.qty = qty;
    }

    @Column(name = "AMOUNT")
    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderNum=" + orderNum +
                ", date=" + date +
                ", cust=" + cust +
                ", rep=" + rep +
                ", mfr='" + mfr + '\'' +
                ", product=" + product +
                ", qty=" + qty +
                ", amount=" + amount +
                '}';
    }
}
