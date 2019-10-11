package kindgeek.middlepost.repository;

import kindgeek.middlepost.entityes.Customer;
import kindgeek.middlepost.entityes.Location;
import kindgeek.middlepost.entityes.Package;
import kindgeek.middlepost.entityes.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface PackageRepository extends JpaRepository<Package, Long>{

    public List<Package> findAllByCustomerFrom(Customer customerFrom);

    public List<Package> findAllByCustomerTo(Customer customerTo);

    public List<Package> findAllByLocationFrom(Location locationFrom);

    public List<Package> findAllByLocationTo(Location locationTo);

    public  List<Package> findAllByReciveDate(Date reciveDate);

    public  List<Package> findAllBySandDate(Date sandDate);

    public  List<Package> findAllByStatus(Status status);
}
