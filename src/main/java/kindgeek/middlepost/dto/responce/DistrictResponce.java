package kindgeek.middlepost.dto.responce;

import kindgeek.middlepost.entityes.District;
import kindgeek.middlepost.entityes.Region;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
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
        if (district.getRegions() == null) {
            this.regions = new ArrayList<>();
        }
        else {
            this.regions = district.getRegions().stream().map(RegionResponce::new).collect(Collectors.toList());
        }
    }

}
