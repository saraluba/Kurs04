package bank.internal;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;

public class DepositAccount extends Account{
    protected HashMap<String, String> transactionHistory;
    Integer i;

    public DepositAccount(String accountNumber, BigDecimal balance, double percents) {
        super(accountNumber, balance, percents);
        this.transactionHistory = new HashMap<>();
        this.i = 1;
    }

    @Override
    public void settingPercents(double per) {
        super.settingPercents(per);
    }

    @Override
    public void topUp(BigDecimal amount) {
        super.topUp(amount);
        transactionHistory.put(i.toString() +". "+ LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss")), "top up: +" + amount +". Balance after:"+ balance);
        i++;
    }

    @Override
    public void withDraw(BigDecimal amount) {
        if(super.getBalance().compareTo(amount) == -1){
            throw new NonSufficientFundsException(String.format("No sufficient funds. Current balance: %s", balance));
        } else{
            super.withDraw(amount);
            transactionHistory.put(i.toString() + ". " + LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss")), "withdraw: -" + amount +". Balance after:"+ balance);
            i++;
        }
    }

    @Override
    public void recalculatePercents() {
        balance =  balance.add(balance.multiply(BigDecimal.valueOf(percents/100)));
        transactionHistory.put(LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss")), "Apply percents");
    }

    public void getTransactionHistory(){
        for(String key: transactionHistory.keySet()){
            System.out.println(key + ": " + transactionHistory.get(key));
        }
    }
}
