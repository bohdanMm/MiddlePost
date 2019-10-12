package kindgeek.middlepost.entityes;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Getter
@Setter
@Entity
public class Status extends IdHolder{

    private String statusName;

    @OneToMany (mappedBy = "status")
    private List<Package> packageList;
}
