package bank.internal;

import java.math.BigDecimal;

abstract class Account {
    protected final String accountNumber;
    protected BigDecimal balance;
    protected double percents;

    Account(String accountNumber, BigDecimal balance, double percents) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.percents = percents;
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
