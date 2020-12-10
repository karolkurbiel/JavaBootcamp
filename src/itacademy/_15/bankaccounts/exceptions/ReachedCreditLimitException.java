package itacademy._15.bankaccounts.exceptions;

public class ReachedCreditLimitException extends RuntimeException {
    public ReachedCreditLimitException(String message) {
        super(message);
    }
}
