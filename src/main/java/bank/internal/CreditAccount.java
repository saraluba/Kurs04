package bank.internal;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.TreeMap;

public class CreditAccount extends Account{
    protected final BigDecimal creditLimit;
    protected TreeMap<String, String> transactionHistory;
    Integer i;

    public CreditAccount(String accountNumber, BigDecimal balance, double percents, BigDecimal creditLimit) {
        super(accountNumber, balance, percents);
        this.creditLimit = creditLimit;
        this.transactionHistory = new TreeMap<>();
        this.i = 1;
    }

    @Override
    void topUp(BigDecimal amount) {
        super.topUp(amount);
        transactionHistory.put(i.toString() + ". " + LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss")), "top up: +" + amount +". Balance after:"+ balance);
        i++;
    }

    @Override
    void withDraw(BigDecimal amount) {
        if(super.getBalance().compareTo(creditLimit) == -1){
            throw new IllegalArgumentException("Balance can not be less than credit limit!");
        } else{
            super.withDraw(amount);
            transactionHistory.put(i.toString() + ". " + LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss")), "withdraw: -" + amount +". Balance after:"+ balance);
            i++;
        }
    }


    @Override
    void recalculatePercents() {
        if(balance.compareTo(BigDecimal.valueOf(0)) == -1){
            balance = balance.subtract(balance.multiply(BigDecimal.valueOf(percents/100)));
            transactionHistory.put(i.toString() + ". " + LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss")), "apply percents");
        }
    }

    public void getTransactionHistory(){
        for(String key: transactionHistory.keySet()){
            System.out.println(key + ": " + transactionHistory.get(key));
        }
    }

    public void getLastTransactions(Integer n){ //get last n transactions
        if(i>n) {
            Integer m = i - n;
            while(m<i) {
                for (String key : transactionHistory.keySet()) {
                    if (key.startsWith(m.toString())) {
                        System.out.println(key + ": "+ transactionHistory.get(key));
                        m++;
                    }
                }
            }
        }
    }
}
