package bank.internal;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Optional;

public class Bank{
    private final String name;
    private ArrayList<DepositAccount> depositAccounts;
    private ArrayList<CreditAccount> creditAccounts;

    public Bank(String name) {
        this.name = name;
        depositAccounts = new ArrayList<>();
        creditAccounts = new ArrayList<>();
    }

    public String getName(){
        return name;
    }

    public void createDepositAccount(DepositAccount newAccount){
        depositAccounts.add(newAccount);
    }


    public void createCreditAccount(CreditAccount newAccount){
        creditAccounts.add(newAccount);
    }

    public void topUpDepositAccount(String accountNumber, BigDecimal amount) {
        for (int i = 0; i < depositAccounts.size(); i++) {
            if(depositAccounts.get(i).getAccountNumber().equals(accountNumber)){
                depositAccounts.get(i).topUp(amount);
            }
        }
    }

    public void topUpCreditAccount(String accountNumber, BigDecimal amount){
        for (int i = 0; i < creditAccounts.size(); i++) {
            if(creditAccounts.get(i).getAccountNumber().equals(accountNumber)){
                creditAccounts.get(i).topUp(amount);
            }
        }
    }

    public void withdrawDepositAccount(String accountNumber, BigDecimal amount) {
        for (int i = 0; i < depositAccounts.size(); i++) {
            if(depositAccounts.get(i).getAccountNumber().equals(accountNumber)){
                depositAccounts.get(i).withDraw(amount);
            }
        }
    }

    public void withdrawCreditAccount(String accountNumber, BigDecimal amount) {
        for (int i = 0; i < creditAccounts.size(); i++) {
            if(creditAccounts.get(i).getAccountNumber().equals(accountNumber)){
                creditAccounts.get(i).withDraw(amount);
            }
        }
    }

    public void recalculate(){
        for (DepositAccount account: depositAccounts) {
            account.recalculatePercents();
        }
        for(CreditAccount account: creditAccounts){
            account.recalculatePercents();
        }
    }

    public Optional<DepositAccount> getDepositAccount(String accountNumber1) {
        Optional<DepositAccount> account1 = Optional.empty();
        for(DepositAccount account: depositAccounts){
            if(account.getAccountNumber().equals(accountNumber1)){
                account1 = Optional.of(account);
            }
        }
        return account1;
    }

    public Optional<CreditAccount> getCreditAccount(String accountNumber1) {
        Optional<CreditAccount> account1 = Optional.empty();
        for(CreditAccount account: creditAccounts){
            if(account.getAccountNumber().equals(accountNumber1)){
                account1 = Optional.of(account);
            }
        }
        return account1;
    }

    public void transactionHistoryDepositAccount(String accountNumber) {
        for (DepositAccount account : depositAccounts) {
            if (account.getAccountNumber().equals(accountNumber)) {
                account.getTransactionHistory();
            }
        }
    }


    public void transactionHistoryCreditAccount(String accountNumber) {
        for (CreditAccount account : creditAccounts) {
            if (account.getAccountNumber().equals(accountNumber)) {
                account.getTransactionHistory();
            }
        }
    }

    public void lastTransactionsDepositAccount(String accountNumber, Integer n){
        for(DepositAccount account: depositAccounts){
            if(account.getAccountNumber().equals(accountNumber)){
                account.getLastTransactions(n);
            }
        }
    }

    public void lastTransactionsCreditAccount(String accountNumber, Integer n){
        for(CreditAccount account: creditAccounts){
            if(account.getAccountNumber().equals(accountNumber)){
                account.getLastTransactions(n);
            }
        }
    }

}
