package kindgeek.middlepost.repository;

import kindgeek.middlepost.entityes.Status;
import kindgeek.middlepost.entityes.Statuses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatusRepository extends JpaRepository<Status, Long> {

    public Status findByStatusName(Statuses statuses);

}
