package bank;

import bank.internal.Bank;
import bank.internal.BankNotFoundException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class NationalBank {
    private static final NationalBank NATIONAL_BANK_INSTANCE = new NationalBank();

    private final List<Bank> banks;

    protected NationalBank() {
        banks = new ArrayList<>();
    }

    public static NationalBank getInstance() {
        return NATIONAL_BANK_INSTANCE;
    }

    public void registerBank(Bank bank) {
        banks.add(bank);
    }

    //TODO: implement the method
    public Optional<Bank> getByName(String name){
        Optional<Bank> bank = Optional.empty();
        for (int i = 0; i < banks.size(); i++) {
            if (banks.get(i).getName().equals(name)) {
                bank = Optional.of(banks.get(i));
            }
        }
        return bank;
    }
}
