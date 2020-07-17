package tdd;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.math.BigDecimal;

public class BookTest {
    Book book = new Book("Harry Potter", BigDecimal.valueOf(14.49), false, true);

    @Test
    public void testGetName(){
        String actual = book.getName();
        String expected = "Harry Potter";
        assertEquals(expected, actual);
    }


}
