package kindgeek.middlepost.service;

import kindgeek.middlepost.dto.request.CustomerRequest;
import kindgeek.middlepost.dto.request.PasportDataReqest;
import kindgeek.middlepost.dto.responce.CustomerResponce;
import kindgeek.middlepost.dto.responce.DataResponce;
import kindgeek.middlepost.dto.responce.PasportDataResponce;
import kindgeek.middlepost.entityes.Customer;
import kindgeek.middlepost.entityes.PasportData;
import kindgeek.middlepost.exeptions.WrongInputDataExeption;
import kindgeek.middlepost.repository.CustomerRepository;
import kindgeek.middlepost.repository.PasportDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    public PasportDataRepository pasportDataRepository;

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

    public void save(CustomerRequest customerRequest){
        Customer customer = new Customer();
        customer.setName(customerRequest.getName());
        customer.setSurname(customerRequest.getSurname());
        customer.setTelephoneNumber(customerRequest.getTelephoneNumber());
        customerRepository.save(customer);
    }

    public void update(Long id, CustomerRequest customerRequest){
        Customer customer = getCustomerEntityById(id);
        customer.setName(customerRequest.getName());
        customer.setSurname(customerRequest.getSurname());
        customer.setTelephoneNumber(customerRequest.getTelephoneNumber());
        customer.setPasportData(pasportDataRepository.findById(customerRequest.getPasportDataId())
                .orElseThrow(()-> new WrongInputDataExeption("There are not pasport data with id: "
                        + customerRequest.getPasportDataId())));
        customerRepository.save(customer);
    }

    public void delete(Long id){
        Customer customer = getCustomerEntityById(id);
        if (customer.getPasportData() != null){
            pasportDataRepository.delete(customer.getPasportData());
            customerRepository.delete(customer);
        } else {
            customerRepository.delete(customer);
        }
    }

}
