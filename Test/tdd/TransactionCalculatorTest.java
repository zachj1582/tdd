package tdd;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static org.junit.jupiter.api.Assertions.*;

public class TransactionCalculatorTest {
    CashRegister cashRegister = CashRegister.getCashRegisterInstance();
    TransactionCalculator calculator = new TransactionCalculator();

//    @Test
//    public void test_addTaxesGetsInformation(){
//        cashRegister.addProductToTransaction("Harry Potter", BigDecimal.valueOf(14.49), false, true);
//        BigDecimal actual = calculator.addTaxes();
//        BigDecimal expected = BigDecimal.valueOf(14.49);
//        assertEquals(expected, actual);
//    }

    @Test
    public void test_addTaxesToPrice(){
        cashRegister.addProductToTransaction("Harry Potter", BigDecimal.valueOf(14.49), false, true);
        BigDecimal actual = calculator.addTaxes();
        BigDecimal expected = BigDecimal.valueOf(14.49).multiply(BigDecimal.valueOf(1.10)).setScale(2,
                RoundingMode.HALF_EVEN);
        assertEquals(expected, actual);
    }

    @Test
    public void test_updatePriceInArray(){
        cashRegister.addProductToTransaction("Harry Potter", BigDecimal.valueOf(14.49), false, true);
        calculator.addTaxes();
        BigDecimal expected = BigDecimal.valueOf(14.49).multiply(BigDecimal.valueOf(1.10)).setScale(2,
                RoundingMode.HALF_EVEN);
        BigDecimal actual = cashRegister.getTransactions().get(0).getPrice();
        assertEquals(expected, actual);
    }
}
