package kindgeek.middlepost.dto.responce;

import kindgeek.middlepost.entityes.Adress;
import kindgeek.middlepost.entityes.Locality;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
public class LocalityResponce {

    private Long id;

    private String localityName;

    public LocalityResponce(Locality locality)
    {
        this.id = locality.getId();
        this.localityName = locality.getLocalityName();
    }

}
