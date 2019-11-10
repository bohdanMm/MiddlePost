package kindgeek.middlepost.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FilterWorkerRequest {

    private Integer salaryFrom;

    private Integer salaryTo;

}
