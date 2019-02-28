package homeworkx.models;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "ORDERS", schema = "MA_STUDENT")
public class Order implements Serializable, ModelInterface {
    private BigDecimal orderNum;
    private Date date;
    private Customer cust;
    private Salesrep rep;
    private String mfr;
    private Products product;
    private BigDecimal qty;
    private BigDecimal amount;


    public Order() {
    }


    public Order(BigDecimal orderNum) {
        this.orderNum = orderNum;
    }

    public Order(BigDecimal orderNum, Date date, Customer cust, Salesrep rep, String mfr, BigDecimal qty, BigDecimal amount, Products product) {
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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cust")
    public Customer getCust() {
        return cust;
    }

    public void setCust(Customer cust) {
        this.cust = cust;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "rep")
    public Salesrep getRep() {
        return rep;
    }

    public void setRep(Salesrep rep) {
        this.rep = rep;
    }

    @Column(name = "MFR")
    public String getMfr() {
        return mfr;
    }

    public void setMfr(String mfr) {
        this.mfr = mfr;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Product")
    public Products getProduct() {
        return product;
    }

    public void setProduct(Products product) {
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
    public void setAll(ModelInterface mi) {
        Order o = (Order) mi;
        this.orderNum = o.orderNum;
        this.date = o.date;
        this.cust = o.cust;
        this.rep = o.rep;
        this.mfr = o.mfr;
        this.product = o.product;
        this.qty = o.qty;
        this.amount = o.amount;
    }

    @Override
    public String toString() {
        return "Order{" +
                "\n orderNum=" + orderNum +
                "\n date=" + date +
                "\n cust=" + cust.getCustNum() +
                "\n rep=" + rep.getEmplNum() +
                "\n mfr='" + mfr + '\'' +
                "\n product=" + product.getProduct_id() +
                "\n qty=" + qty +
                "\n amount=" + amount +
                "\n}";
    }
}
