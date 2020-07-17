package tdd;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import static org.junit.jupiter.api.Assertions.*;

public class ProductTest {

    public void getPriceHelper(IProduct product, BigDecimal price){
        assertEquals(price, product.getPrice());
    }

    public void getNameHelper(IProduct product, String name){
        assertEquals(name, product.getName());
    }

    public void getExemptHelper(IProduct product, boolean exempt){
        assertEquals(exempt, product.isExempt());
    }

    public void getImportedHelper(IProduct product, boolean imported){
        assertEquals(imported, product.isImported());
    }
}
