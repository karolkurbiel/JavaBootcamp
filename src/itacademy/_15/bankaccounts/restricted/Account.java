package itacademy._15.bankaccounts.restricted;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

abstract class Account implements Comparable<Account> {
    private final String accountNumber;
    private final String accountOwner;
    private BigDecimal balance;
    private BigDecimal percentage;

    protected final Set<Log> accountHistory;

    public Account(String accountNumber, String accountOwner, BigDecimal balance, BigDecimal percentage) {
        this.accountNumber = accountNumber;
        this.accountOwner = accountOwner;
        this.balance = balance;
        this.percentage = percentage;

        this.accountHistory = new TreeSet<>();
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getAccountOwner() {
        return accountOwner;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public BigDecimal getPercentage() {
        return percentage;
    }

    public Set<Log> getAccountHistory() {
        return Collections.unmodifiableSet(accountHistory);
    }

    protected void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public void setPercentage(BigDecimal percentage) {
        this.percentage = percentage;
    }

    public boolean topUp(BigDecimal amount) {
        if(amount.compareTo(BigDecimal.ZERO) > 0) {
            accountHistory.add(new Log(OperationType.TOP_UP, balance, balance.add(amount)));
            balance = balance.add(amount);
            return true;
        }
        return false;
    }

    public boolean withdraw(BigDecimal amount) {
        if(amount.compareTo(balance) <= 0) {
            accountHistory.add(new Log(OperationType.WITHDRAW, balance, balance.subtract(amount)));
            balance = balance.subtract(amount);
            return true;
        }
        return false;
    }

    public boolean applyPercentage() {
        accountHistory.add(new Log(OperationType.APPLY_PERCENTAGE, balance, balance.add(balance.multiply(percentage))));
        balance = balance.add(balance.multiply(percentage));
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return Objects.equals(accountNumber, account.accountNumber) &&
                Objects.equals(accountOwner, account.accountOwner) &&
                Objects.equals(balance, account.balance) &&
                Objects.equals(percentage, account.percentage);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountNumber, accountOwner, balance, percentage);
    }

    @Override
    public int compareTo(Account o) {
        return this.getAccountOwner().compareTo(o.getAccountOwner());
    }

    @Override
    public String toString() {
        return "" + balance;
    }
}
