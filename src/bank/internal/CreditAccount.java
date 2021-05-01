package bank.internal;

import java.math.BigDecimal;

public class CreditAccount extends Account{
    private final BigDecimal creditLimit;

    CreditAccount(String accountNumber, BigDecimal balance, double percents, BigDecimal creditLimit) {
        super(accountNumber, balance, percents);
        this.creditLimit = creditLimit;
    }


    @Override
    void withDraw(BigDecimal amount) {
        if(super.getBalance().compareTo(creditLimit) == -1){
            throw new IllegalArgumentException("Balance can not be less than credit limit!");
        } else{
            super.withDraw(amount);
        }
    }


    @Override
    void recalculatePercents() {
        if(balance.compareTo(BigDecimal.valueOf(0)) == -1){
            balance = balance.subtract(balance.multiply(BigDecimal.valueOf(percents/100)));
        }
    }
}
