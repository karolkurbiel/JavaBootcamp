package itacademy._15.bankaccounts.restricted;

import java.math.BigDecimal;

public class CreditAccount extends Account {
    private BigDecimal debtLimit;

    public CreditAccount(String accountNumber, String accountOwner, BigDecimal balance, BigDecimal percentage, BigDecimal debtLimit) {
        super(accountNumber, accountOwner, balance, percentage);
        this.debtLimit = debtLimit.multiply(BigDecimal.valueOf(-1));
    }

    public void setDebtLimit(BigDecimal debtLimit) {
        this.debtLimit = debtLimit.multiply(BigDecimal.valueOf(-1));
    }

    public BigDecimal getDebtLimit() {
        return debtLimit;
    }

    @Override
    public boolean withdraw(BigDecimal amount) {
        if(debtLimit.compareTo(super.getBalance().subtract(amount)) <= 0) {
            super.setBalance(super.getBalance().subtract(amount));
            return true;
        }
        return false;
    }

    @Override
    public boolean applyPercentage() {
        if(super.getBalance().compareTo(BigDecimal.ZERO) < 0) {
            super.setBalance(getBalance().add(getBalance().multiply(getPercentage())));
            return true;
        }
        System.out.println("\t\t\t" + super.getAccountOwner() + ": No debt, no fee.");
        return false;
    }
}
