package kindgeek.middlepost.dto.responce;

import kindgeek.middlepost.entityes.Adress;
import kindgeek.middlepost.entityes.Location;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
public class LocationResponce {

    private Long id;

    private Adress adress;

    private Integer number;

    public  LocationResponce(Location location)
    {
        this.id = location.getId();
        this.adress = location.getAdress();
        this.number = location.getNumber();
    }

}
