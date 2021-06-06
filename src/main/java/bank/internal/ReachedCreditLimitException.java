package bank.internal;

public class ReachedCreditLimitException extends RuntimeException{
    public ReachedCreditLimitException(String message){
        super(message);
    }
}
