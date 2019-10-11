package kindgeek.middlepost.dto.responce;

import kindgeek.middlepost.entityes.Customer;
import kindgeek.middlepost.entityes.Location;
import kindgeek.middlepost.entityes.Package;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class PackageResponce {

    private Long id;

    private Integer weight;

    private Date sandDate;

    private Date reciveDate;

    private Location locationFrom;

    private Location locationTo;

    private Customer customerFrom;

    private Customer customerTo;

    private String statusName;

    public PackageResponce(Package pac){
        this.id = pac.getId();
        this.weight = pac.getWeight();
        this.sandDate = pac.getSandDate();
        this.reciveDate = pac.getReciveDate();
        this.locationFrom = pac.getLocationFrom();
        this.locationTo = pac.getLocationTo();
        this.customerFrom = pac.getCustomerFrom();
        this.customerTo = pac.getCustomerTo();
        this.statusName = pac.getStatus().getStatusName().name();
    }

}
