package kindgeek.middlepost.dto.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class CustomerLogInRequest {

    @NotBlank
    private String email;

    @NotBlank
    private String password;
}
