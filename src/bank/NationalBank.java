package bank;

import bank.internal.Bank;

import java.util.ArrayList;
import java.util.List;

public class NationalBank {
    private static final NationalBank NATIONAL_BANK_INSTANCE = new NationalBank();

    private final List<Bank> banks;

    private NationalBank() {
        banks = new ArrayList<>();
    }

    public static NationalBank getInstance() {
        return NATIONAL_BANK_INSTANCE;
    }

    public void registerBank(Bank bank) {
        banks.add(bank);
    }

    //TODO: implement the method
    public Bank getByName(String name) {
        int j = 0;
        for (int i = 0; i < banks.size(); i++) {
            if(banks.get(i).getName().equals(name)){
                j = i;
            }
        }
        return banks.get(j);
    }
}
