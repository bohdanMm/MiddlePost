package kindgeek.middlepost.dto.responce;

import kindgeek.middlepost.entityes.Region;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegionResponce {

    private String regionName;

    private String districtName;

    public RegionResponce(Region region){
        this.regionName = region.getRegionName();
        this.districtName = region.getDistrict().getDistrictName();
    }
}
