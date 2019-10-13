package kindgeek.middlepost.entityes;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.List;

@Getter
@Setter
@Entity
public class District extends IdHolder {

    private String districtName;

    @OneToMany(mappedBy = "district")
    private List<Region> regions;

    @OneToMany(mappedBy = "district")
    private List<Locality> localities;

}
