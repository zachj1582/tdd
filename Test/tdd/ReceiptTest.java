package tdd;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ReceiptTest {

    @Test
    public void willDisplay(){
        Receipt receipt = new Receipt();
        assertTrue(receipt.display());
    }

}
