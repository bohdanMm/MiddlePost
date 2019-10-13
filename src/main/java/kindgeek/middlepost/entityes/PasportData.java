package kindgeek.middlepost.entityes;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import java.util.Objects;

@Getter
@Setter
@Entity
public class PasportData extends IdHolder {

    private String serialNumber;

    private String code;

    @OneToOne (mappedBy = "pasportData")
    private Customer customer;

}
