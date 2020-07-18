package tdd;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;

import static java.math.BigDecimal.*;

public class TransactionCalculator {
//    private ArrayList<Product> list = CashRegister.getCashRegisterInstance().getTransactions();
    CashRegister cashRegister = CashRegister.getCashRegisterInstance();
    public TransactionCalculator(){
    }

    public BigDecimal addTaxes(){
        BigDecimal temp = null;
        for(Product product:cashRegister.getTransactions()){
            temp = product.getPrice().multiply(BigDecimal.valueOf(1.10)).setScale(2, RoundingMode.HALF_EVEN);
            product.setPrice(temp);
        }
        return temp;
    }
}
