package kindgeek.middlepost.dto.responce;

import kindgeek.middlepost.entityes.Adress;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AdressResponce {

    private Long id;

    private String street;

    private Integer buildingNumber;

    private String localityName;

    private String regionName;

    private String districtName;

    public AdressResponce(Adress adress){
        this.id = adress.getId();
        this.street = adress.getStreet();
        this.buildingNumber = adress.getBuildingNumber();
        this.localityName = adress.getLocality().getLocalityName();
        this.regionName = adress.getLocality().getRegion().getRegionName();
        this.districtName = adress.getLocality().getDistrict().getDistrictName();
    }


}
