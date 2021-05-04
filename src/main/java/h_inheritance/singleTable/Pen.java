package h_inheritance.singleTable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("1")
public class Pen extends Product {
    private String color;

    public String getColor() {
        return color;
    }

    public void setColor(String author) {
        this.color = author;
    }
}