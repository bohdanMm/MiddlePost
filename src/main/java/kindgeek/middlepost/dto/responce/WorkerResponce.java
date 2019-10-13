package kindgeek.middlepost.dto.responce;

import kindgeek.middlepost.entityes.Worker;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class WorkerResponce {

    private Long id;

    private String name;

    private String surname;

    private Integer salary;

    private String position;

    private String locationName;

    public WorkerResponce(Worker worker)
    {
        this.id = worker.getId();
        this.name = worker.getName();
        this.name = worker.getSurname();
        this.salary = worker.getSalary();
        this.position = worker.getPosition();
    }

}
