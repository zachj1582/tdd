package tdd;

import org.junit.jupiter.api.Test;


import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

public class ReceiptTest {
    CashRegister register = CashRegister.getCashRegisterInstance();
    Receipt receipt = Receipt.getReceiptInstance();

    @Test
    public void test_willPrintItems(){
        register.addProductToTransaction("Book", BigDecimal.valueOf(12.49), false, true);
        String expected =
                register.getTransactions().get(0).getName() + ":" + "   $" + register.getTransactions().get(0).getPrice();
        String actual = receipt.printItems(register.getTransactions());
        assertEquals(expected, actual);
    }





}
