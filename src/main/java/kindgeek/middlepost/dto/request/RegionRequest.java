package kindgeek.middlepost.dto.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
public class RegionRequest {

    @NotBlank
    @Size(min = 2, max = 255)
    private String regionName;

    @NotBlank
    private Long districtId;

}
