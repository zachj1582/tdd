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

    public BigDecimal getTransactionTotal(){
        BigDecimal transactionTotal = cashRegister.getTransactions().stream().map(Product::getPrice).reduce(BigDecimal.ZERO,
                BigDecimal::add);
        return transactionTotal;
    }

}
