package tdd;

import java.math.BigDecimal;

public interface IProduct {
    public static String name = "";
    public static BigDecimal price = null;
    public static boolean exempt = false;
    public static boolean imported = false;

    public String getName();
    public String setName();

    public BigDecimal getPrice();
    public BigDecimal setPrice();

    public boolean isExempt();

    public boolean isImported();
}


