package kindgeek.middlepost.dto.responce;

import kindgeek.middlepost.entityes.Customer;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerLogedInResponce {

    private String name;

    private String surname;

    private String email;

    public CustomerLogedInResponce(Customer customer) {
        this.name = customer.getName();
        this.surname = customer.getSurname();
        this.email = customer.getEmail();
    }
}
