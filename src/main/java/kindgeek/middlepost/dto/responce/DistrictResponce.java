package kindgeek.middlepost.dto.responce;

import kindgeek.middlepost.entityes.District;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
public class DistrictResponce {

    private Long id;

    private String districtName;

    private List<RegionResponce> regions;

    public DistrictResponce(District district){
        this.id = district.getId();
        this.districtName = district.getDistrictName();
        this.regions = district.getRegions()
                .stream()
                .map(RegionResponce::new)
                .collect(Collectors.toList());
    }

}
