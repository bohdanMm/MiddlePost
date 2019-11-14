package kindgeek.middlepost;

import kindgeek.middlepost.dto.responce.CustomerResponce;
import kindgeek.middlepost.entityes.Customer;
import kindgeek.middlepost.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;


@SpringBootApplication
public class MiddlepostApplication {

    @Autowired
    private CustomerRepository customerRepository;

    public static void main(String[] args) {
        SpringApplication.run(MiddlepostApplication.class, args);
    }

    @PostConstruct
    private void postConstruct() {
        Customer customer = customerRepository.findByEmailAndPassword("admin@admin", "adminadmin");
        if (customer == null){
            customer = new Customer();
            customer.setEmail("admin@admin");
            customer.setPassword("adminadmin");
            customer.setPasportData("admin");
            customer.setName("Admin");
            customer.setSurname("Admin");
            customer.setTelephoneNumber("AdminNumber");
            customerRepository.save(customer);
        }
    }

}
