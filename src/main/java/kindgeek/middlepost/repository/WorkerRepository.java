package kindgeek.middlepost.repository;

import kindgeek.middlepost.entityes.Location;
import kindgeek.middlepost.entityes.Worker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WorkerRepository extends JpaRepository<Worker, Long>, JpaSpecificationExecutor<Worker> {

    public Worker findByNameAndSurname(String  name, String surname);

    public List<Worker> findAllBySalaryAfter(Integer salaryAfter);

    public List<Worker> findAllBySalaryBefore(Integer salaryBefor);

    public List<Worker> findAllByPosition(String position);

    public List<Worker> findAllByLocation(Location location);

}
