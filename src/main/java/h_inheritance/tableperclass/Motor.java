package h_inheritance.tableperclass;

import javax.persistence.Entity;

@Entity
public class Motor extends Vehicle {

    public String getFuel() {
        return fuel;
    }

    public void setFuel(String fuel) {
        this.fuel = fuel;
    }

    private String fuel;
}
