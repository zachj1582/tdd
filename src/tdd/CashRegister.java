package tdd;

import java.util.ArrayList;

public class CashRegister {

    private ArrayList<IProduct> transaction;
    private static CashRegister cashRegister = new CashRegister();

    private CashRegister(){
    }


    public static CashRegister getCashRegister(){
        return cashRegister;
    }

    public void addToTransaction(){

    }

}
