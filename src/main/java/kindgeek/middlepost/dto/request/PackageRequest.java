package kindgeek.middlepost.dto.request;

import kindgeek.middlepost.entityes.Customer;
import kindgeek.middlepost.entityes.Location;
import kindgeek.middlepost.entityes.Status;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class PackageRequest {

    private Double weight;

    private Date sandDate;

    private Date reciveDate;

    private Long locationFromId;

    private Long locationToId;

    private Long customerFromId;

    private Long customerToId;

    private Long statusId;
}
