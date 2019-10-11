package kindgeek.middlepost.entityes;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Status extends IdHolder{

    private Statuses statusName;

    @OneToMany (mappedBy = "status")
    private List<Package> aPackage;

    public Statuses getStatusName() {
        return statusName;
    }

    public void setStatusName(Statuses statusName) {
        this.statusName = statusName;
    }

    public List<Package> getaPackage() {
        return aPackage;
    }

    public void setaPackage(List<Package> aPackage) {
        this.aPackage = aPackage;
    }
}
