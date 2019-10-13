package kindgeek.middlepost.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LocalityRequest {
    private String localityName;

    private Long districtId;

    private Long regionId;
}
