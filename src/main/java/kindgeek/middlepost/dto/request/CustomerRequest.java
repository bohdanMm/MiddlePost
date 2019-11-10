package kindgeek.middlepost.dto.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
public class CustomerRequest {

    @NotBlank
    @Size(min = 1, max = 255)
    private String name;

    @NotBlank
    @Size(max = 255)
    private String surname;

    @NotBlank
    private String email;

    @NotBlank
    @Size(min = 9, max = 20)
    private String telephoneNumber;

    @NotBlank
    @Size(min = 4, max = 40)
    private String pasportData;

    @NotBlank
    private String password;

}
