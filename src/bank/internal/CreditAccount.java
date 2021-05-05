package bank.internal;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;

public class CreditAccount extends Account{
    protected final BigDecimal creditLimit;
    protected HashMap<String, String> transactionHistory;

    public CreditAccount(String accountNumber, BigDecimal balance, double percents, BigDecimal creditLimit) {
        super(accountNumber, balance, percents);
        this.creditLimit = creditLimit;
        this.transactionHistory = new HashMap<>();
    }

    @Override
    void topUp(BigDecimal amount) {
        super.topUp(amount);
        LocalDateTime time = LocalDateTime.now();
        DateTimeFormatter date = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String formattedDate = time.format(date);
        transactionHistory.put(formattedDate, "top up: " + amount + ". Balance after: " + balance);
    }

    @Override
    void withDraw(BigDecimal amount) {
        if(super.getBalance().compareTo(creditLimit) == -1){
            throw new IllegalArgumentException("Balance can not be less than credit limit!");
        } else{
            super.withDraw(amount);
            LocalDateTime time = LocalDateTime.now();
            DateTimeFormatter date = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
            String formattedDate = time.format(date);
            transactionHistory.put(formattedDate, "withdraw: -" + amount +". Balance after:"+ balance);
        }
    }


    @Override
    void recalculatePercents() {
        if(balance.compareTo(BigDecimal.valueOf(0)) == -1){
            balance = balance.subtract(balance.multiply(BigDecimal.valueOf(percents/100)));
            LocalDateTime time = LocalDateTime.now();
            DateTimeFormatter date = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
            String formattedDate = time.format(date);
            transactionHistory.put(formattedDate, "Apply percents");
        }
    }

    public void getTransactionHistory(){
        for(String key: transactionHistory.keySet()){
            System.out.println(key + ": " + transactionHistory.get(key));
        }
    }
}
