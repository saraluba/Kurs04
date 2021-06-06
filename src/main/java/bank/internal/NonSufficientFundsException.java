package bank.internal;

public class NonSufficientFundsException extends RuntimeException{
    private String message;

    public NonSufficientFundsException(String message){
        this.message = message;
    }


}
