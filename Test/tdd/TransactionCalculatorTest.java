package tdd;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

public class TransactionCalculatorTest {
    CashRegister cashRegister = CashRegister.getCashRegisterInstance();
    TransactionCalculator calculator = new TransactionCalculator();

    @Test
    public void test_addTaxesGetsInformation(){
        cashRegister.addProductToTransaction("Harry Potter", BigDecimal.valueOf(14.49), false, true);
        BigDecimal actual = calculator.addTaxes();
        BigDecimal expected = BigDecimal.valueOf(14.49);
        assertEquals(expected, actual);
    }

}
