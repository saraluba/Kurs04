package bank;


import bank.internal.Bank;
import bank.internal.CreditAccount;
import bank.internal.DepositAccount;

import java.math.BigDecimal;
import java.util.ArrayList;

public class BankApplication {
    //TODO: create banks, create accounts in banks, register banks in NB
    Bank pko = new Bank("PKO", new ArrayList<>());


    public static void main(String[] args) {
        //TODO: Get a bank from NB, and play around with money on it's accounts.
        Bank pko = new Bank("PKO", new ArrayList<>());
        pko.createAccount(new DepositAccount("14324"));
        pko.createAccount(new CreditAccount("2875764", BigDecimal.valueOf(20000)));
        pko.createAccount(new DepositAccount("343231"));
        DepositAccount person1 = new DepositAccount("3");
        pko.withdrawAccount("14324",BigDecimal.valueOf(10));
    }
}
