package kindgeek.middlepost.dto.request;

import kindgeek.middlepost.dto.responce.LocationResponce;
import kindgeek.middlepost.entityes.Adress;
import kindgeek.middlepost.entityes.Locality;
import kindgeek.middlepost.entityes.Location;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
public class AdressRequest {

    private String street;

    private Integer buildingNumber;

    private Long localityId;


}
