package tdd;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.math.BigDecimal;

public class ProductTest {
    Product product = new Product("Harry Potter", BigDecimal.valueOf(14.49), false, true);

    @Test
    public void testGetName(){
        String actual = product.getName();
        String expected = "Harry Potter";
        assertEquals(expected, actual);
    }

    @Test
    public void testGetPrice(){
        BigDecimal expected = BigDecimal.valueOf(14.49);
        BigDecimal actual = product.getPrice();
        assertEquals(expected, actual);
    }

    @Test
    public void testGetTaxExempt(){
        boolean expected = true;
        boolean actual = product.isTaxExempt();
        assertEquals(expected, actual);
    }

    @Test
    public void testGetImported(){
        boolean expected = false;
        boolean actual = product.isImported();
        assertEquals(expected, actual);
    }
}
