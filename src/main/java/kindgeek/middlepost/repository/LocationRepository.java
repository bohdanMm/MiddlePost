package kindgeek.middlepost.repository;

import kindgeek.middlepost.entityes.Adress;
import kindgeek.middlepost.entityes.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationRepository extends JpaRepository<Location, Long> {

    public Location findByAdress(Adress adress);

}
