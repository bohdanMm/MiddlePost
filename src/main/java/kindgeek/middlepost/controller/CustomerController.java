package kindgeek.middlepost.controller;

import kindgeek.middlepost.dto.request.CustomerLogInRequest;
import kindgeek.middlepost.dto.request.CustomerRequest;
import kindgeek.middlepost.dto.responce.CustomerLogedInResponce;
import kindgeek.middlepost.dto.responce.CustomerResponce;
import kindgeek.middlepost.dto.responce.DataResponce;
import kindgeek.middlepost.entityes.Customer;
import kindgeek.middlepost.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping
    public DataResponce<CustomerResponce> getAll(@RequestParam Integer page, @RequestParam Integer size,
                                                 @RequestParam String sortBy, @RequestParam Sort.Direction direction){
        return customerService.getAll(page, size, sortBy, direction);
    }

    @GetMapping("/{id}")
    public CustomerResponce getById(@PathVariable Long id){
        return customerService.getById(id);
    }

    @PostMapping
    public CustomerLogedInResponce save(@RequestBody CustomerRequest customerRequest){
        return customerService.save(customerRequest);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Long id, @RequestBody CustomerRequest customerRequest){
        customerService.update(id, customerRequest);
    }

    @DeleteMapping
    public void delete(@RequestParam Long id){
        customerService.delete(id);
    }

    @PostMapping("/logIn")
    public CustomerLogedInResponce logIn(@RequestBody CustomerLogInRequest customerLogInRequest){
        return customerService.logIn(customerLogInRequest);
    }
}
