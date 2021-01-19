package itacademy._15.bankaccounts.restricted;

import itacademy._15.bankaccounts.exceptions.ReachedCreditLimitException;

import java.math.BigDecimal;

class CreditAccount extends Account {
    private BigDecimal debtLimit;

    public CreditAccount(String accountNumber, String accountOwner, BigDecimal balance, BigDecimal percentage, BigDecimal debtLimit) {
        super(accountNumber, accountOwner, balance, percentage);
        this.debtLimit = debtLimit.multiply(BigDecimal.valueOf(-1));
    }

    public void setDebtLimit(BigDecimal debtLimit) {
        super.accountHistory.add(new Log(OperationType.SET_NEW_DEBT_LIMIT, super.getBalance(), super.getBalance(), this.debtLimit, (debtLimit.multiply(BigDecimal.valueOf(-1)))));
        this.debtLimit = debtLimit.multiply(BigDecimal.valueOf(-1));
    }

    public BigDecimal getDebtLimit() {
        return debtLimit;
    }

    @Override
    public boolean withdraw(BigDecimal amount) {
        if(debtLimit.compareTo(super.getBalance().subtract(amount)) <= 0) {
            accountHistory.add(new Log(OperationType.WITHDRAW, getBalance(), getBalance().subtract(amount)));
            super.setBalance(super.getBalance().subtract(amount));
            return true;
        }
        String exceptionInfo = "Account balance: $" + getBalance() + ", with debt limit: $" + debtLimit + " is insufficient for withdrawal: $" + amount + ".";
        throw new ReachedCreditLimitException(exceptionInfo);
    }

    @Override
    public boolean applyPercentage() {
        if(super.getBalance().compareTo(BigDecimal.ZERO) < 0) {
            accountHistory.add(new Log(OperationType.APPLY_PERCENTAGE, getBalance(), getBalance().add(getBalance().multiply(getPercentage()))));
            super.setBalance(getBalance().add(getBalance().multiply(getPercentage())));
            return true;
        }
        System.out.println("\t\t\t" + super.getAccountNumber() + ": No debt, no fee.");
        return false;
    }
}
