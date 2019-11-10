package kindgeek.middlepost.dto.request;

import kindgeek.middlepost.dto.responce.LocationResponce;
import kindgeek.middlepost.entityes.Adress;
import kindgeek.middlepost.entityes.Locality;
import kindgeek.middlepost.entityes.Location;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;


@Getter
@Setter
public class AdressRequest {

    @NotBlank
    @Size(min = 2, max = 100)
    private String street;

    @NotBlank
    private Integer buildingNumber;

    @NotBlank
    private Long localityId;


}
