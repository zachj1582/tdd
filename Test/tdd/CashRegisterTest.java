package tdd;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

public class CashRegisterTest {
    CashRegister cashRegister = CashRegister.getCashRegisterInstance();

    @Test
    public void test_NewCashRegister(){
        try{
            CashRegister register2 = CashRegister.getCashRegisterInstance();
            if(System.identityHashCode(cashRegister) != System.identityHashCode(register2)){
                fail("CashRegister is creating multiple instances");
            }
            assertTrue(true);
        } catch(final RuntimeException re){
            re.printStackTrace();
        }
    }

    @Test
    public void test_CanAddToTransaction(){
        cashRegister.addProductToTransaction("Harry Potter", BigDecimal.valueOf(14.49), false, true);
        String actual = cashRegister.transactionContains("Harry Potter");
        String expected = "Harry Potter";
        assertEquals(expected, actual);
        cashRegister.addProductToTransaction("Imported Chocolate Bar", BigDecimal.valueOf(5.00), true, true);
        String actual2 = cashRegister.transactionContains("Imported Chocolate Bar");
        String expected2 = "Imported Chocolate Bar";
        assertEquals(expected2, actual2);
    }
}
