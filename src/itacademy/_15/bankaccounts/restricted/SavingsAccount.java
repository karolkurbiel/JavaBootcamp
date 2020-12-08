package itacademy._15.bankaccounts.restricted;

import java.math.BigDecimal;

class SavingsAccount extends Account {
    public SavingsAccount(String accountNumber, String accountOwner, BigDecimal balance, BigDecimal percentage) {
        super(accountNumber, accountOwner, balance, percentage);
    }
}
