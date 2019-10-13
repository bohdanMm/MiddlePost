package kindgeek.middlepost.entityes;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Getter
@Setter
@Entity
public class Worker extends IdHolder {

    private String name;
    private String surname;
    private Integer salary;
    private String position;

    @ManyToOne
    private Location location;


}
