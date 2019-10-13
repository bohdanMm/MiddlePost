package kindgeek.middlepost.entityes;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Getter
@Setter
@Entity
public class Adress extends IdHolder {

    private String street;

    private int buildingNumber;

    @ManyToOne
    private Locality locality;

    @OneToOne
    private Location location;

}
