package kindgeek.middlepost.dto.request;


import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
public class StatusRequest {
    @NotBlank
    @Size(min = 5, max = 30)
    private String statusName;
}
