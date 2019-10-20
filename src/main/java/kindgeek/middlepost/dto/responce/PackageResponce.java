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

    private Double weight;

    private Date sandDate;

    private Date reciveDate;

    private String statusName;

    public PackageResponce(Package pac){
        this.id = pac.getId();
        this.weight = pac.getWeight();
        this.sandDate = pac.getSandDate();
        this.reciveDate = pac.getReciveDate();
        this.statusName = pac.getStatus().getStatusName();
    }

}
