package kindgeek.middlepost.repository;

import kindgeek.middlepost.entityes.Region;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RegionRepository extends JpaRepository<Region, Long> {

    List<Region> findAllByDistrict_DistrictName(String DistrictName);

}
