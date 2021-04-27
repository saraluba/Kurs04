package bank.internal;

import java.math.BigDecimal;

abstract class Account {
    private final String accountNumber;
    private BigDecimal balance;
    private double percents;

    Account(String accountNumber) {
        this.accountNumber = accountNumber;
        balance = BigDecimal.ZERO;
        percents = 0.0;
    }

    abstract void recalculatePercents();

    void settingPercents(double per){
        percents = per;
    }

    void topUp(BigDecimal amount) {
        balance = balance.add(amount);
    }

    void withDraw(BigDecimal amount) {
            balance = balance.subtract(amount);
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public String getAccountNumber(){
        return accountNumber;
    }
}
