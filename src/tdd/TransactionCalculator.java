package tdd;

import java.math.BigDecimal;
import java.util.ArrayList;

public class TransactionCalculator {
    private ArrayList<Product> list = CashRegister.getCashRegisterInstance().getTransactions();

    public TransactionCalculator(){
    }

    public BigDecimal addTaxes(){

    }
}
