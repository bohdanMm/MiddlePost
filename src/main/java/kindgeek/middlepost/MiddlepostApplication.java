package kindgeek.middlepost;

import kindgeek.middlepost.entityes.Customer;
import kindgeek.middlepost.entityes.PasportData;
import kindgeek.middlepost.repository.CustomerRepository;
import kindgeek.middlepost.repository.PasportDataRepository;
import kindgeek.middlepost.repository.StatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class MiddlepostApplication {

    public static void main(String[] args) {
        SpringApplication.run(MiddlepostApplication.class, args);
    }

}
