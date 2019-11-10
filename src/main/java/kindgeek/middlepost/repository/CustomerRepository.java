package kindgeek.middlepost.repository;

import kindgeek.middlepost.entityes.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    public List<Customer> findAllByNameAndSurname(String name, String surname);

    public  Customer findByTelephoneNumber(String telephoneNumber);

    public Customer findByPasportData(String pasportData);

    public Customer findByEmailAndPassword(String email, String password);

}
