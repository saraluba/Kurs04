package bank.internal;

import java.math.BigDecimal;

public class DepositAccount extends Account{

    public DepositAccount(String accountNumber) {
        super(accountNumber);
    }

    @Override
    void settingPercents(double per) {
        super.settingPercents(per);
    }

    @Override
    void withDraw(BigDecimal amount) {
        if(super.getBalance().compareTo(amount) == -1){
            throw new IllegalArgumentException("Balance can not be a negative number!");
        } else{
            super.withDraw(amount);
        }
    }

    @Override
    void topUp(BigDecimal amount) {
        super.topUp(amount);
    }

    @Override
    public BigDecimal getBalance() {
        return super.getBalance();
    }

    @Override
    public String getAccountNumber() {
        return super.getAccountNumber();
    }

    @Override
    void recalculatePercents() {

    }
}
