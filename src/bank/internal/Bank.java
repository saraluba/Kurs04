package bank.internal;

import java.math.BigDecimal;
import java.util.ArrayList;

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

    public void recalculate(){
        for (DepositAccount account: depositAccounts) {
            account.recalculatePercents();
        }
        for(CreditAccount account: creditAccounts){
            account.recalculatePercents();
        }
    }

    public DepositAccount getDepositAccount(String accountNumber1) throws AccountNotFoundException {
        DepositAccount account1 = null;
        for(DepositAccount account: depositAccounts){
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

    public CreditAccount getCreditAccount(String accountNumber1) throws AccountNotFoundException {
        for(CreditAccount account: creditAccounts){
            if(account.getAccountNumber().equals(accountNumber1)){
                return account;
            } else{
                throw new AccountNotFoundException("That credit account doesn't exist!");
            }
        }
        return null;
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




}
