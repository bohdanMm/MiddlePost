package kindgeek.middlepost.repository;

import kindgeek.middlepost.dto.responce.RegionResponce;
import kindgeek.middlepost.entityes.Region;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RegionRepository extends JpaRepository<Region, Long> {

    Page<Region> findAllByRegionNameLike(String regionNameLike, PageRequest pageRequest);

    Region findByRegionName(String name);

}
