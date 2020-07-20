package tdd;

import java.math.BigDecimal;
import java.util.ArrayList;

public class Receipt {
    private static Receipt receipt = new Receipt();
    public Receipt(){
    }

    public static Receipt getReceiptInstance(){
        return receipt;
    }

    public void printReceipt(ArrayList<Product> transactions, BigDecimal taxes, BigDecimal total){
        System.out.println("Receipt \n");
        System.out.println("*************************\n");
        printItems(transactions);
        System.out.println("Sales Taxes: $" + taxes + "\n");
        System.out.println("Total: $" + total + "\n");
        System.out.println("*************************\n");
        System.out.println("Thank you for shopping with us! Don't let the door hit you on the way out... Come back " +
                "soon!!");

    }

    private String printItems(ArrayList<Product> transactions) {
        String temp = "";
        for(Product product: transactions){
            System.out.println(product.getName() + ":" + "   $" + product.getPrice() + "\n");
            temp = product.getName() + ":" + "   $" + product.getPrice();
        }
        return temp;
    }

}
