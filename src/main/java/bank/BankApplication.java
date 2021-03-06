package bank;


import bank.internal.*;
import java.math.BigDecimal;

public class BankApplication {
    //TODO: create banks, create accounts in banks, register banks in NB

    public static void main(String[] args) throws AccountNotFoundException, BankNotFoundException {
        //TODO: Get a bank from NB, and play around with money on it's accounts.
        Bank pko = new Bank("PKO");
        pko.createDepositAccount(new DepositAccount("12345", BigDecimal.valueOf(1000),0.5));
        pko.createCreditAccount(new CreditAccount("13456", BigDecimal.valueOf(1000), 2, BigDecimal.valueOf(1500)));
        System.out.println(pko.getCreditAccount("13456").orElseThrow(()-> new AccountNotFoundException("Account does not exist")));
        System.out.println(pko.getDepositAccount("12345"));
        pko.withdrawDepositAccount("12345", BigDecimal.valueOf(100));
        pko.topUpDepositAccount("12345", BigDecimal.valueOf(2000));
        pko.topUpDepositAccount("12345", BigDecimal.valueOf(30));
        pko.topUpDepositAccount("12345", BigDecimal.valueOf(25));
        pko.transactionHistoryDepositAccount("12345");
        System.out.println("================");
        pko.lastTransactionsDepositAccount("12345", 2);
        System.out.println("================");
        pko.topUpCreditAccount("13456", BigDecimal.valueOf(1234));
        pko.withdrawCreditAccount("13456", BigDecimal.valueOf(100));
        pko.lastTransactionsCreditAccount("13456",2);
        System.out.println("================");
        NationalBank nb = new NationalBank();
        nb.registerBank(pko);
        System.out.println(pko.getCreditAccount("123456").orElseThrow(()-> new AccountNotFoundException("Account does not exist")));
        System.out.println(nb.getByName("ing").orElseThrow(() -> new BankNotFoundException("Bank not found")));
    }
}
