package itacademy._15.bankaccounts.exceptions;

public class BankAlreadyExistsException extends RuntimeException{
    public BankAlreadyExistsException() {
        super("Bank already exists.");
    }
}
