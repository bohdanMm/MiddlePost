package kindgeek.middlepost.entityes;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import java.util.Date;

@Entity
public class Package extends IdHolder {

    private Integer weight;

    private Date sandDate;

    private Date reciveDate;

    @OneToOne
    private Location locationFrom;

    @OneToOne
    private Location locationTo;

    @OneToOne
    private Customer customerFrom;

    @OneToOne
    private Customer customerTo;

    @ManyToOne
    private Status status;

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public Date getSandDate() {
        return sandDate;
    }

    public void setSandDate(Date sandDate) {
        this.sandDate = sandDate;
    }

    public Date getReciveDate() {
        return reciveDate;
    }

    public void setReciveDate(Date reciveDate) {
        this.reciveDate = reciveDate;
    }

    public Location getLocationFrom() {
        return locationFrom;
    }

    public void setLocationFrom(Location locationFrom) {
        this.locationFrom = locationFrom;
    }

    public Location getLocationTo() {
        return locationTo;
    }

    public void setLocationTo(Location locationTo) {
        this.locationTo = locationTo;
    }

    public Customer getCustomerFrom() {
        return customerFrom;
    }

    public void setCustomerFrom(Customer customerFrom) {
        this.customerFrom = customerFrom;
    }

    public Customer getCustomerTo() {
        return customerTo;
    }

    public void setCustomerTo(Customer customerTo) {
        this.customerTo = customerTo;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
