package kindgeek.middlepost.dto.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
public class LocalityRequest {
    @NotBlank
    @Size(min = 1, max = 255)
    private String localityName;

    @NotBlank
    private String districtName;

    @NotBlank
    private String regionName;
}
