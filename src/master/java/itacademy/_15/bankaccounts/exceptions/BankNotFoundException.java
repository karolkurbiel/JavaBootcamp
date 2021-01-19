package itacademy._15.bankaccounts.exceptions;

public class BankNotFoundException extends RuntimeException{
    public BankNotFoundException() {
        super("Not found.");
    }
}
