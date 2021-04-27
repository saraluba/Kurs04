package bank.internal;

import java.math.BigDecimal;

public class CreditAccount extends Account{
    private final BigDecimal creditLimit;

    public CreditAccount(String accountNumber, BigDecimal creditLimit) {
        super(accountNumber);
        this.creditLimit = creditLimit;
    }

    @Override
    void recalculatePercents() {

    }
}
