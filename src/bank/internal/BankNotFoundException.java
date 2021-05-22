package bank.internal;

import java.util.function.Supplier;

public class BankNotFoundException extends Exception{
    public BankNotFoundException(String errorMessage){
        super(errorMessage);
    }
}
