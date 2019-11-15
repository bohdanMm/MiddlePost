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

    private String status;

    private Long id;

    public CustomerLogedInResponce(Customer customer) {
        this.id = customer.getId();
        this.name = customer.getName();
        this.surname = customer.getSurname();
        this.email = customer.getEmail();
        String[] getStatus =  email.split("@");
        String extantion = getStatus[getStatus.length -1];
        if(extantion.equals("admin")){
            status = "admin";
        } else if(extantion.equals("worker")) {
            status = "worker";
        } else {
            status = "customer";
        }
    }
}
