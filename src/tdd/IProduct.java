package tdd;

import java.math.BigDecimal;

public interface IProduct {

    public String getName();
    public void setName();

    public BigDecimal getPrice();
    public void setPrice(BigDecimal price);

    public boolean isTaxExempt();

    public boolean isImported();
}


