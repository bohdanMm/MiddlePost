package kindgeek.middlepost.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WorkerRequest {

    private String name;

    private String surname;

    private Integer salary;

    private String position;

    private Long locationId;
}
