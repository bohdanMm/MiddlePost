package kindgeek.middlepost.dto.responce;

import kindgeek.middlepost.entityes.PasportData;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PasportDataResponce {

    private Long id;

    private String serialNumber;

    private String code;

    public PasportDataResponce(PasportData pasportData){
        this.id = pasportData.getId();
        this.serialNumber = pasportData.getSerialNumber();
        this.code = pasportData.getCode();
    }

}
