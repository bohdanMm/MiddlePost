package kindgeek.middlepost.entityes;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.List;

@Getter
@Setter
@Entity
public class Location extends  IdHolder {

    @OneToOne (mappedBy = "location")
    private Adress adress;

    @OneToMany (mappedBy = "location")
    private List<Worker> worker;

}
