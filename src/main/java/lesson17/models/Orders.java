package lesson17.models;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;

public class Orders implements Serializable {
    private BigDecimal orderNum;
    private Date date;
    private BigDecimal cust;
    private BigDecimal rep;
    private String mfr;
    private Products product;
    private BigDecimal qty;
    private BigDecimal amount;

    public Orders() {
    }

    public Orders(BigDecimal orderNum) {
        this.orderNum = orderNum;
    }

    public Orders(BigDecimal orderNum, Date date, BigDecimal cust, BigDecimal rep, String mfr, BigDecimal qty, BigDecimal amount,  Products product) {
        this.orderNum = orderNum;
        this.date = date;
        this.cust = cust;
        this.rep = rep;
        this.mfr = mfr;
        this.product = product;
        this.qty = qty;
        this.amount = amount;
    }

    public BigDecimal getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(BigDecimal orderNum) {
        this.orderNum = orderNum;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public BigDecimal getCust() {
        return cust;
    }

    public void setCust(BigDecimal cust) {
        this.cust = cust;
    }

    public BigDecimal getRep() {
        return rep;
    }

    public void setRep(BigDecimal rep) {
        this.rep = rep;
    }

    public String getMfr() {
        return mfr;
    }

    public void setMfr(String mfr) {
        this.mfr = mfr;
    }

    public Products getProduct() {
        return product;
    }

    public void setProduct(Products product) {
        this.product = product;
    }

    public BigDecimal getQty() {
        return qty;
    }

    public void setQty(BigDecimal qty) {
        this.qty = qty;
    }

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
