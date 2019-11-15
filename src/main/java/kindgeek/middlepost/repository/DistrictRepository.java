package kindgeek.middlepost.repository;

import kindgeek.middlepost.entityes.District;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DistrictRepository extends JpaRepository<District, Long> {

    District findByDistrictName(String districtName);

    @Override
    Page<District> findAll(Pageable pageable);

    Page<District> findAllByDistrictNameLike(String name, Pageable pageable);


}
