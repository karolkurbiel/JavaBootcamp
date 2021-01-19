package itacademy._15.bankaccounts.exceptions;

public class AccountNotFoundException extends RuntimeException {
    public AccountNotFoundException() {
        super("Not found.");
    }
}
