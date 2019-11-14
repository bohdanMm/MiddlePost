package kindgeek.middlepost.dto.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class LocationRequest {

    @NotBlank
    private Long adressId;

    @NotBlank
    private Integer number;
}
