package h_inheritance.tableperclass;

import javax.persistence.Entity;

@Entity
public class Motorcycle extends Vehicle{

    private int numOfTires;

    public int getNumOfTires() {
        return numOfTires;
    }

    public void setNumOfTires(int numOfTires) {
        this.numOfTires = numOfTires;
    }
}
