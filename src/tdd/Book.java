package tdd;

import java.math.BigDecimal;

public class Book implements IProduct {

    private String name;
    private BigDecimal price;
    private boolean imported;
    private boolean taxExempt;

    public Book(String name, BigDecimal price, boolean imported, boolean taxExempt){
        this.name = name;
        this.price = price;
        this.imported = imported;
        this.taxExempt = taxExempt;
    }


    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setName() {
        this.name = name;
    }

    @Override
    public BigDecimal getPrice() {
        return this.price;
    }

    @Override
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public boolean isTaxExempt() {
        return this.taxExempt;
    }

    @Override
    public boolean isImported() {
        return this.imported;
    }
}
