package kindgeek.middlepost.dto.responce;

import kindgeek.middlepost.entityes.Customer;
import kindgeek.middlepost.entityes.Location;
import kindgeek.middlepost.entityes.Package;
import lombok.Getter;
import lombok.Setter;

import java.text.SimpleDateFormat;
import java.util.Date;

@Getter
@Setter
public class PackageResponce {

    private Long id;

    private Double weight;

    private String sandDate;

    private String reciveDate;

    private Long customerFromId;

    private Long customerToId;

    private String statusName;

    private String locationFromStreet;
    private String locationToStreet;

    private Integer buildingFromNumber;
    private Integer buildingToNumber;

    private String localityFromName;
    private String localityToName;

    public PackageResponce(Package pac){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        this.id = pac.getId();
        this.weight = pac.getWeight();
        if(pac.getSandDate() != null){
            this.sandDate = format.format(pac.getSandDate());
        }
        if(pac.getReciveDate() != null) {
            this.reciveDate = format.format(pac.getReciveDate());
        }
        this.statusName = pac.getStatus().getStatusName();
        this.customerFromId = pac.getCustomerFrom().getId();
        this.customerToId = pac.getCustomerTo().getId();
        this.locationFromStreet = pac.getLocationFrom().getAdress().getStreet();
        this.locationToStreet = pac.getLocationTo().getAdress().getStreet();
        this.buildingFromNumber = pac.getLocationFrom().getAdress().getBuildingNumber();
        this.buildingToNumber = pac.getLocationTo().getAdress().getBuildingNumber();
        this.localityFromName = pac.getLocationFrom().getAdress().getLocality().getLocalityName();
        this.localityToName = pac.getLocationTo().getAdress().getLocality().getLocalityName();;
    }

}
