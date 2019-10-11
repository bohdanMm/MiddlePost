package kindgeek.middlepost.entityes;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.List;

@Entity
public class Location extends  IdHolder {

    @OneToOne (mappedBy = "location")
    private Adress adress;

    @OneToMany (mappedBy = "location")
    private List<Worker> worker;

    public Adress getAdress() {
        return adress;
    }

    public void setAdress(Adress adress) {
        this.adress = adress;
    }

    public List<Worker> getWorker() {
        return worker;
    }

    public void setWorker(List<Worker> worker) {
        this.worker = worker;
    }
}
