package bank.internal;

import java.math.BigDecimal;
import java.util.List;

public class Bank{
    private final String name;
    private final List<Account> accounts;

    public Bank(String name) {
        this.name = name;
        accounts = null;
    }

    public String getName(){
        return name;
    }

    public void createDepositAccount(String accountNumber, BigDecimal balance, double percents){
        DepositAccount i = new DepositAccount(accountNumber, balance, percents);
        accounts.add(i);
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

    public void recalculate(){
        for (Account account: accounts) {
            account.recalculatePercents();
        }
    }

    public Account getAccount(String accountNumber1) throws AccountNotFoundException {
        Account account1 = null;
        for(Account account: accounts){
            if(account.getAccountNumber().equals(accountNumber1)){
                account1 = account;
            }
        }
        if(account1.equals(null)){
            throw new AccountNotFoundException("account doesn't exist!");
        } else{
            return account1;
        }
    }
}
