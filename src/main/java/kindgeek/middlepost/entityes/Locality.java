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
public class Locality extends IdHolder {

    private String localityName;

    @OneToMany(mappedBy = "locality")
    private List<Adress> adress;

    @ManyToOne
    private Region region;

    @ManyToOne
    private District district;
}
