package kindgeek.middlepost.repository;

import kindgeek.middlepost.entityes.Locality;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocalityRepository extends JpaRepository<Locality, Long> {

    public Locality findByLocalityName(String localityName);

}
