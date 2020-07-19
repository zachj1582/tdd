package tdd;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;

public class TransactionCalculator {
    private static TransactionCalculator calculator = new TransactionCalculator();

    private TransactionCalculator(){
    }

    public static TransactionCalculator getCalculatorInstance(){
        return calculator;
    }

    public BigDecimal addTaxes(ArrayList<Product> transaction){
        BigDecimal temp;
        BigDecimal totalTaxes = BigDecimal.valueOf(0);
        for(Product product : transaction){
            if(product.isImported() && product.isTaxExempt()){
                temp = product.getPrice().multiply(Constants.TAX_RATE_IMPORT).setScale(2, RoundingMode.HALF_EVEN);
                totalTaxes =
                        totalTaxes.add(product.getPrice().multiply(Constants.TAX_RATE_IMPORT.subtract(BigDecimal.valueOf(1)))).setScale(2,
                        RoundingMode.HALF_EVEN);
                product.setPrice(temp);
            }
            if(product.isImported() && !product.isTaxExempt()){
                temp =
                        product.getPrice().multiply(Constants.TAX_RATE_IMPORT.add(Constants.TAX_RATE_LOCAL.subtract(BigDecimal.valueOf(1)))).setScale(2,
                        RoundingMode.HALF_EVEN);
                totalTaxes =
                        totalTaxes.add(product.getPrice().multiply(Constants.TAX_RATE_IMPORT.add(Constants.TAX_RATE_LOCAL).subtract(BigDecimal.valueOf(2)))).setScale(2,
                                RoundingMode.HALF_EVEN);
                product.setPrice(temp);
            }
            if(!product.isImported() && !product.isTaxExempt()){
                temp = product.getPrice().multiply(Constants.TAX_RATE_LOCAL).setScale(2, RoundingMode.HALF_EVEN);
                totalTaxes =
                        totalTaxes.add(product.getPrice().multiply(Constants.TAX_RATE_LOCAL.subtract(BigDecimal.valueOf(1)))).setScale(2,
                                RoundingMode.HALF_EVEN);
                product.setPrice(temp);
            }

        }
        return totalTaxes;
    }

    public BigDecimal getTransactionTotal(ArrayList<Product> transaction){
        return transaction.stream().map(Product::getPrice).reduce(BigDecimal.ZERO, BigDecimal::add);
    }

}
