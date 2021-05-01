package bank.internal;

import java.math.BigDecimal;

public class DepositAccount extends Account{

    DepositAccount(String accountNumber, BigDecimal balance, double percents) {
        super(accountNumber, balance, percents);

    }

    @Override
    void settingPercents(double per) {
        super.settingPercents(per);
    }

    @Override
    void withDraw(BigDecimal amount) {
        if(super.getBalance().compareTo(amount) == -1){
            throw new NonSufficientFundsException(String.format("No sufficient funds. Current balance: %s", balance));
        } else{
            super.withDraw(amount);
        }
    }

    @Override
    void recalculatePercents() {
        balance =  balance.add(balance.multiply(BigDecimal.valueOf(percents/100)));
    }
}
