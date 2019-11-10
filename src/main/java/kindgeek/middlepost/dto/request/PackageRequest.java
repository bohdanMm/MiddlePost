package kindgeek.middlepost.dto.request;

import kindgeek.middlepost.entityes.Customer;
import kindgeek.middlepost.entityes.Location;
import kindgeek.middlepost.entityes.Status;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.util.Date;

@Getter
@Setter
public class PackageRequest {

    @NotBlank
    private Double weight;

    @NotBlank
    private Date sandDate;

    private Date reciveDate;

    @NotBlank
    private Long locationFromId;

    @NotBlank
    private Long locationToId;

    @NotBlank
    private Long customerFromId;

    @NotBlank
    private Long customerToId;

    private Long statusId;
}
