package bank;


import bank.internal.AccountNotFoundException;
import bank.internal.Bank;
import bank.internal.CreditAccount;
import bank.internal.DepositAccount;

import java.math.BigDecimal;
import java.util.ArrayList;

public class BankApplication {
    //TODO: create banks, create accounts in banks, register banks in NB

    public static void main(String[] args) throws AccountNotFoundException {
        //TODO: Get a bank from NB, and play around with money on it's accounts.
        Bank pko = new Bank("PKO");
        pko.createDepositAccount("12345",BigDecimal.valueOf(1000),0.5);
        pko.createCreditAccount("13456", BigDecimal.valueOf(1000), 2, BigDecimal.valueOf(1500));
        System.out.println(pko.getAccount("12345"));
    }
}
