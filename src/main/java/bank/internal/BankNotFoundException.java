package bank.internal;


public class BankNotFoundException extends Exception{
    public BankNotFoundException(String errorMessage){
        super(errorMessage);
    }
}
