package kindgeek.middlepost.dto.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
public class WorkerRequest {

    @NotBlank
    @Size(min = 2, max = 255)
    private String name;

    @NotBlank
    @Size(min = 2, max = 255)
    private String surname;

    @NotBlank
    private Integer salary;

    @NotBlank
    @Size(min = 3, max = 255)
    private String position;

    private Long locationId;
}
