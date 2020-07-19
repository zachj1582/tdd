package tdd;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;

import static java.math.BigDecimal.*;

public class TransactionCalculator {
    CashRegister cashRegister = CashRegister.getCashRegisterInstance();
    public TransactionCalculator(){
    }

    public BigDecimal addTaxes(){
        BigDecimal temp = null;
        BigDecimal totalTaxes = BigDecimal.valueOf(0);
        for(Product product:cashRegister.getTransactions()){
            temp = product.getPrice().multiply(BigDecimal.valueOf(1.10)).setScale(2, RoundingMode.HALF_EVEN);
            totalTaxes = totalTaxes.add(product.getPrice().multiply(BigDecimal.valueOf(0.1))).setScale(2, RoundingMode.HALF_EVEN);
            product.setPrice(temp);
        }
        return totalTaxes;
    }
}
