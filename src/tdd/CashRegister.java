package tdd;

import java.math.BigDecimal;
import java.util.ArrayList;

public class CashRegister {

    private ArrayList<Product> transaction = new ArrayList<>();
    private static CashRegister cashRegister = new CashRegister();

    private CashRegister() {
    }


    public static CashRegister getCashRegisterInstance() {
        return cashRegister;
    }

    public void addProductToTransaction(String name, BigDecimal price, boolean imported, boolean taxExempt) {
        Product product = new Product(name, price, imported, taxExempt);
        transaction.add(product);
    }

    public String transactionContains(String productName) {
        for (Product product : transaction) {
            if (product.getName().equals(productName)) {
                return product.getName();
            }
        }
        return "Item not found";
    }

    public ArrayList<Product> getTransactions(){
        return this.transaction;
    }

    public void clearTransaction(){
        this.transaction.clear();
    }

}
