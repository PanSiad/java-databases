package h_inheritance.singleTable;

import javax.persistence.*;

@Entity(name="products")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="product_type", discriminatorType = DiscriminatorType.INTEGER)
//@DiscriminatorFormula("case when author is not null then 1 else 2 end")

public class Product {
    @Id
    private long productId;
    private String name;

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}