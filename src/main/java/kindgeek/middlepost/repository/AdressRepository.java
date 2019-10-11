package kindgeek.middlepost.repository;

import kindgeek.middlepost.entityes.Adress;
import kindgeek.middlepost.entityes.Locality;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdressRepository extends JpaRepository<Adress, Long> {

    public List<Adress> findAllByStreet(String street);

    public  Adress findByBuildingNumberAndStreetAndLocality(Integer buildingNumber, String street, Locality locality);

    public List<Adress> findAllByBuildingNumberAndStreet(Integer buildingNumber, String street);



}
