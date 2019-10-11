package kindgeek.middlepost.entityes;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
public class Customer extends IdHolder {

    private String name;

    private String surname;

    private  String telephoneNumber;

    @OneToOne
    private PasportData pasportData;

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", telephoneNumber='" + telephoneNumber + '\'' +
                '}';
    }

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

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public PasportData getPasportData() {
        return pasportData;
    }

    public void setPasportData(PasportData pasportData) {
        this.pasportData = pasportData;
    }
}
