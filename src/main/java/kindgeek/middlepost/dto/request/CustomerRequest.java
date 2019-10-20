package kindgeek.middlepost.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerRequest {

    private String name;

    private String surname;

    private String telephoneNumber;

    private Long pasportDataId;

}
