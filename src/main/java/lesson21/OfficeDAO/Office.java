package lesson21.OfficeDAO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name = "OFFICES", schema = "MA_STUDENT")
public class Office implements Serializable {
    private BigDecimal office;
    private String city;
    private String region;
    private BigDecimal mgr;
    private BigDecimal target;
    private BigDecimal sales;

    public Office() {
    }

    public Office(BigDecimal office) {
        this.office = office;
    }

    public Office(BigDecimal office, String city, String region, BigDecimal mgr, BigDecimal target, BigDecimal sales) {
        this.office = office;
        this.city = city;
        this.region = region;
        this.mgr = mgr;
        this.target = target;
        this.sales = sales;
    }

    @Id
    @Column(name = "OFFICE")
    public BigDecimal getOffice() {
        return office;
    }

    public void setOffice(BigDecimal office) {
        this.office = office;
    }

    @Column(name = "CITY")
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Column(name = "REGION")
    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    @Column(name = "MGR")
    public BigDecimal getMgr() {
        return mgr;
    }

    public void setMgr(BigDecimal mgr) {
        this.mgr = mgr;
    }

    @Column(name = "TARGET")
    public BigDecimal getTarget() {
        return target;
    }

    public void setTarget(BigDecimal target) {
        this.target = target;
    }

    @Column(name = "SALES")
    public BigDecimal getSales() {
        return sales;
    }

    public void setSales(BigDecimal sales) {
        this.sales = sales;
    }

    @Override
    public String toString() {
        return "Offices{" +
                "office=" + office +
                ", city='" + city + '\'' +
                ", region='" + region + '\'' +
                ", mgr=" + mgr +
                ", target=" + target +
                ", sales=" + sales +
                '}';
    }
}