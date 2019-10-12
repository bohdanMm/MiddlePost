package kindgeek.middlepost.dto.responce;

import kindgeek.middlepost.entityes.Status;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class StatusResponce {

    private Long id;

    private String statusName;

    public StatusResponce(Status status){
        this.id = status.getId();
        this.statusName = status.getStatusName();
    }

}
