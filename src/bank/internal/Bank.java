package bank.internal;

import java.math.BigDecimal;
import java.util.List;

public class Bank{
    private final String name;
    private final List<Account> accounts;

    public Bank(String name, List<Account> accounts) {
        this.name = name;
        this.accounts = accounts;
    }

    public String getName(){
        return name;
    }

    public void createAccount(Account account){
        accounts.add(account);
    }

    public void topUpAccount(String accountNumber, BigDecimal amount) {
        for (int i = 0; i < accounts.size(); i++) {
            if(accounts.get(i).getAccountNumber().equals(accountNumber)){
                accounts.get(i).topUp(amount);
            }
        }
    }

    public void withdrawAccount(String accountNumber, BigDecimal amount) {
        for (int i = 0; i < accounts.size(); i++) {
            if(accounts.get(i).getAccountNumber().equals(accountNumber)){
                accounts.get(i).withDraw(amount);
            }
        }
    }

    public void recalculatePercents() {

    }
}
