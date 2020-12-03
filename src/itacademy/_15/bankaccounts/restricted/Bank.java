package itacademy._15.bankaccounts.restricted;

import java.math.BigDecimal;
import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;

public class Bank implements Comparable<Bank> {
    private final String name;
    private final Map<String,Account> accountList;

    public enum AccountType {
        CREDIT,
        SAVINGS
    }

    public Bank(String name) {
        this.name = name;
        this.accountList = new TreeMap<>();
    }

    public String getName() {
        return name;
    }

    public Map<String, Account> getAccountList() {
        return accountList;
    }

    public boolean makeExternalTransfer(Account sender, BigDecimal amount, Account recipient) {
        return makeTransfer(sender, amount, recipient);
    }

    public boolean makeInternalTransfer(Account sender, BigDecimal amount, Account recipient) {
        if(accountList.containsValue(sender)) {
            return makeTransfer(sender, amount, recipient);
        }
        return false;
    }

    private boolean makeTransfer(Account sender, BigDecimal amount, Account recipient) {
        if(((amount.compareTo(sender.getBalance()) <= 0) || (((CreditAccount) sender).getDebtLimit()).compareTo((sender.getBalance()).subtract(amount)) <= 0) && accountList.containsValue(recipient)) {
            return sender.withdraw(amount) && recipient.topUp(amount);
        }
        return false;
    }

    public boolean addAccount(String ownerName, BigDecimal initialBalance, AccountType ACCOUNT_TYPE, BigDecimal percentage) {
        if(accountList.containsKey(ownerName) || initialBalance.compareTo(BigDecimal.ZERO) < 0) {
            return false;
        }

        if(ACCOUNT_TYPE == AccountType.CREDIT) {
            String accountNumber = "PL21370000000" + (accountList.size()+1) + "C";
            accountList.put(ownerName, new CreditAccount(accountNumber, ownerName, initialBalance, percentage, BigDecimal.valueOf(5000)));
        } else {
            String accountNumber = "PL21370000000" + (accountList.size()+1) + "S";
            accountList.put(ownerName, new SavingsAccount(accountNumber, ownerName, initialBalance, percentage));
        }

        return true;
    }

    public boolean topUpAccount(String accountNumber, BigDecimal amount) {

        Account processedAccount = null;

        for(Map.Entry<String, Account> account : accountList.entrySet()) {
            if(account.getValue().getAccountNumber().equals(accountNumber)) {
                processedAccount = account.getValue();
                break;
            }
        }
        if(processedAccount != null) {
            return processedAccount.topUp(amount);
        }
        return false;
    }

    public boolean withdrawAccount(String accountNumber, BigDecimal amount) {
        Account processedAccount = null;

        for(Map.Entry<String, Account> account : accountList.entrySet()) {
            if(account.getValue().getAccountNumber().equals(accountNumber)) {
                processedAccount = account.getValue();
                break;
            }
        }
        if(processedAccount != null) {
            return processedAccount.withdraw(amount);
        }
        return false;
    }

    public void recalculatePercents() {
        for(Map.Entry<String, Account> account : accountList.entrySet()) {
            System.out.println("\t\t\tProcessed account: " + account.getKey() + "; status: " + account.getValue().applyPercentage());
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bank bank = (Bank) o;
        return Objects.equals(name, bank.name) &&
                Objects.equals(accountList, bank.accountList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, accountList);
    }

    @Override
    public int compareTo(Bank o) {
        return name.compareTo(o.getName());
    }
}
