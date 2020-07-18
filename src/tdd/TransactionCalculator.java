package tdd;

import java.math.BigDecimal;
import java.util.ArrayList;

public class TransactionCalculator {
//    private ArrayList<Product> list = CashRegister.getCashRegisterInstance().getTransactions();
    CashRegister cashRegister = CashRegister.getCashRegisterInstance();
    public TransactionCalculator(){
    }

    public BigDecimal addTaxes(){
        BigDecimal temp = null;
        for(Product product:cashRegister.getTransactions()){
            temp = product.getPrice();
        }
        return temp;
    }
}
