package kindgeek.middlepost.repository;

import kindgeek.middlepost.entityes.*;
import kindgeek.middlepost.entityes.Package;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface PackageRepository extends JpaRepository<Package, Long>{

    Page<Package> findAllByCustomerFrom_IdOrCustomerTo_Id(Long customerFrom, Long customerTo, Pageable pageable);

}
