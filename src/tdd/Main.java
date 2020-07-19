package tdd;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args){

        CashRegister cashRegister = CashRegister.getCashRegisterInstance();

        cashRegister.addProductToTransaction("Book", BigDecimal.valueOf(12.49), false, true);
        cashRegister.addProductToTransaction("Music CD", BigDecimal.valueOf(14.99), false, false);
        cashRegister.addProductToTransaction("Chocolate Bar", BigDecimal.valueOf(0.85), false, true);
        cashRegister.processTransaction();

        cashRegister.addProductToTransaction("Imported Box of Chocolates", BigDecimal.valueOf(10.00), true, true);
        cashRegister.addProductToTransaction("Imported Bottle of Perfume", BigDecimal.valueOf(47.50), true, false);
        cashRegister.processTransaction();

        cashRegister.addProductToTransaction("Imported Bottle of Perfume", BigDecimal.valueOf(27.99), true, false);
        cashRegister.addProductToTransaction("Bottle of Perfume", BigDecimal.valueOf(18.99), false, false);
        cashRegister.addProductToTransaction("Packet of Headache pills", BigDecimal.valueOf(9.75), false, true);
        cashRegister.addProductToTransaction("Imported Box of Chocolates", BigDecimal.valueOf(11.25), true, true);
        cashRegister.processTransaction();

    }
}
