package kindgeek.middlepost.dto.responce;

import kindgeek.middlepost.entityes.Customer;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerResponce {

    private Long id;

    private String name;

    private String surname;

    private  String telephoneNumber;

    public CustomerResponce(Customer customer)
    {
        this.id = customer.getId();
        this.name = customer.getName();
        this.surname = customer.getSurname();
        this.telephoneNumber = customer.getTelephoneNumber();
    }

}
