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
//        calculator.addTaxes();
        BigDecimal expected = BigDecimal.valueOf(14.49).multiply(BigDecimal.valueOf(1.10)).setScale(2,
                RoundingMode.HALF_EVEN);
        BigDecimal actual = cashRegister.getTransactions().get(0).getPrice();
        assertEquals(expected, actual);
    }

    @Test
    public void test_getTotalTaxes(){
        cashRegister.addProductToTransaction("Harry Potter", BigDecimal.valueOf(14.49), false, true);
        BigDecimal actual = calculator.addTaxes();
        BigDecimal expected = BigDecimal.valueOf(1.45);
        assertEquals(expected, actual);
    }

    @Test
    public void test_addTaxesAccountingForImportedAndExempt(){
        cashRegister.addProductToTransaction("Harry Potter", BigDecimal.valueOf(12.49), false, true);
        cashRegister.addProductToTransaction("Imported Box of Chocolates", BigDecimal.valueOf(10.00), true, true);
//        cashRegister.addProductToTransaction("Imported Bottle of Perfume", BigDecimal.valueOf(47.50), true, false);
//        cashRegister.addProductToTransaction("Music CD", BigDecimal.valueOf(14.99), false, false);
        BigDecimal actual = cashRegister.getTransactions().get(0).getPrice();
        BigDecimal expected = BigDecimal.valueOf(12.49).multiply(BigDecimal.valueOf(1.00)).setScale(2,
                RoundingMode.HALF_EVEN);
        assertEquals(expected, actual);
        BigDecimal actual2 = cashRegister.getTransactions().get(1).getPrice();
        BigDecimal expected2 = BigDecimal.valueOf(10.00).multiply(BigDecimal.valueOf(1.05)).setScale(2,
                RoundingMode.HALF_EVEN);
        assertEquals(expected2, actual2);
//        BigDecimal actual3 = cashRegister.getTransactions().get(0).getPrice();
//        BigDecimal expected3 = BigDecimal.valueOf(47.50).multiply(BigDecimal.valueOf(1.15)).setScale(2,
//                RoundingMode.HALF_EVEN);
//        assertEquals(expected3, actual3);
//        BigDecimal actual4 = cashRegister.getTransactions().get(0).getPrice();
//        BigDecimal expected4 = BigDecimal.valueOf(14.99).multiply(BigDecimal.valueOf(1.10)).setScale(2,
//                RoundingMode.HALF_EVEN);
//        assertEquals(expected4, actual4);
    }


}
