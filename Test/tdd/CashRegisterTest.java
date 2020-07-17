package tdd;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CashRegisterTest {
    CashRegister cashRegister = CashRegister.getCashRegister();

    @Test
    public void test_NewCashRegister(){
        try{
            CashRegister register2 = CashRegister.getCashRegister();
            if(System.identityHashCode(cashRegister) != System.identityHashCode(register2)){
                fail("CashRegister is creating multiple instances");
            }
            assertTrue(true);
        } catch(final RuntimeException re){
            re.printStackTrace();
        }
    }
}
