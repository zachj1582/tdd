package tdd;

import java.math.BigDecimal;
import java.util.ArrayList;

public class CashRegister {

    private ArrayList<Product> transaction = new ArrayList<>();
    private static CashRegister cashRegister = new CashRegister();
    TransactionCalculator calculator = TransactionCalculator.getCalculatorInstance();
    Receipt receipt = Receipt.getReceiptInstance();

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

    private void clearTransaction(){
        this.transaction.clear();
    }

    public void processTransaction(){
        BigDecimal totalTaxes = calculator.addTaxes(transaction);
        BigDecimal transactionTotal = calculator.getTransactionTotal(transaction);
        receipt.printReceipt(transaction, totalTaxes, transactionTotal);
        clearTransaction();
    }

}
