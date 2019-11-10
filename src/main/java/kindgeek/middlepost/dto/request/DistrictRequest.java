package kindgeek.middlepost.dto.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
public class DistrictRequest {
    @NotBlank
    @Size(min = 1, max = 255)
    private String districtName;
}
