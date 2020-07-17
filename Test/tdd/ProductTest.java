package tdd;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.math.BigDecimal;

public class ProductTest {
    Book book = new Book("Harry Potter", BigDecimal.valueOf(14.49), false, true);

    @Test
    public void testGetName(){
        String actual = book.getName();
        String expected = "Harry Potter";
        assertEquals(expected, actual);
    }

    @Test
    public void testGetPrice(){
        BigDecimal expected = BigDecimal.valueOf(14.49);
        BigDecimal actual = book.getPrice();
        assertEquals(expected, actual);
    }

    @Test
    public void testGetTaxExempt(){
        boolean expected = true;
        boolean actual = book.isTaxExempt();
        assertEquals(expected, actual);
    }

    @Test
    public void testGetImported(){
        boolean expected = false;
        boolean actual = book.isImported();
        assertEquals(expected, actual);
    }
}
