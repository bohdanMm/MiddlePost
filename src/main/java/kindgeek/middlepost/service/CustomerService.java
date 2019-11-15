package kindgeek.middlepost.service;

import kindgeek.middlepost.dto.request.CustomerLogInRequest;
import kindgeek.middlepost.dto.request.CustomerRequest;
import kindgeek.middlepost.dto.responce.CustomerLogedInResponce;
import kindgeek.middlepost.dto.responce.CustomerResponce;
import kindgeek.middlepost.dto.responce.DataResponce;
import kindgeek.middlepost.entityes.Customer;

import kindgeek.middlepost.exeptions.WrongInputDataExeption;
import kindgeek.middlepost.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public Customer getCustomerEntityById(Long id){
        return customerRepository.findById(id)
                .orElseThrow(()->new WrongInputDataExeption("There are not customer with id: " + id));
    }

    public DataResponce<CustomerResponce> getAll(Integer page, Integer size,
                                                 String sortBy, Sort.Direction direction){
        Sort sort = Sort.by(direction, sortBy);
        PageRequest pageRequest = PageRequest.of(page, size, sort);
        Page<Customer> pageBrand = customerRepository.findAll(pageRequest);
        return new DataResponce<CustomerResponce>(pageBrand.getContent()
                .stream()
                .map(CustomerResponce::new)
                .collect(Collectors.toList())
                , pageBrand);
    }

    public CustomerResponce getById(Long id){
        return new CustomerResponce(getCustomerEntityById(id));
    }

    public CustomerLogedInResponce save(CustomerRequest customerRequest){
        Customer customer = new Customer();
        customer.setName(customerRequest.getName());
        customer.setSurname(customerRequest.getSurname());
        customer.setTelephoneNumber(customerRequest.getTelephoneNumber());
        customer.setPasportData(customerRequest.getPasportData());
        customer.setPassword(customerRequest.getPassword());
        customer.setEmail(customerRequest.getEmail());
        customerRepository.save(customer);
        return new CustomerLogedInResponce(customer);
    }

    public CustomerResponce update(Long id, CustomerRequest customerRequest){
        Customer customer = getCustomerEntityById(id);
        customer.setName(customerRequest.getName());
        customer.setSurname(customerRequest.getSurname());
        customer.setTelephoneNumber(customerRequest.getTelephoneNumber());
        customer.setPasportData(customerRequest.getPasportData());
        customer.setPassword(customerRequest.getPassword());
        customer.setEmail(customerRequest.getEmail());
        customerRepository.save(customer);
        return new CustomerResponce(customer);
    }

    public Boolean delete(Long id){
        Customer customer = getCustomerEntityById(id);
        customerRepository.delete(customer);
        return true;
    }

    public CustomerLogedInResponce logIn(CustomerLogInRequest request){
        Customer customer = customerRepository.findByEmailAndPassword(request.getEmail(), request.getPassword());
        if (customer != null){
            return new CustomerLogedInResponce(customer);
        }
        else {
            throw new WrongInputDataExeption("Ther are not registred customer with email: " +
                    request.getEmail() + " and so password.");
        }
    }

}
