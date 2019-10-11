package kindgeek.middlepost.entityes;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class Worker extends IdHolder {

    private String name;
    private String surname;
    private Integer salary;
    private Positions position;

    @ManyToOne
    private Location location;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Positions getPosition() {
        return position;
    }

    public void setPosition(Positions position) {
        this.position = position;
    }
}
