package kindgeek.middlepost.repository;

import kindgeek.middlepost.entityes.PasportData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PasportDataRepository extends JpaRepository<PasportData, Long> {

    public PasportData findByCode(String code);

    //public List<PasportData> findAllBySerialNumber(String serialNumber);

}
