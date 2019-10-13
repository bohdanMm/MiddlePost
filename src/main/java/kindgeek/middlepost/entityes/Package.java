package kindgeek.middlepost.entityes;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import java.util.Date;

@Getter
@Setter
@Entity
public class Package extends IdHolder {

    private Integer weight;

    private Date sandDate;

    private Date reciveDate;

    @OneToOne
    private Location locationFrom;

    @OneToOne
    private Location locationTo;

    @OneToOne
    private Customer customerFrom;

    @OneToOne
    private Customer customerTo;

    @ManyToOne
    private Status status;
}
