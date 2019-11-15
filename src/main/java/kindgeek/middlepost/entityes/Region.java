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
public class Region extends IdHolder {

    private String regionName;

    @ManyToOne
    private District district;

    @OneToMany(mappedBy = "region")
    private List<Locality> localities;

}
