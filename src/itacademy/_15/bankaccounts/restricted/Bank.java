package itacademy._15.bankaccounts.restricted;

import itacademy._15.bankaccounts.exceptions.AccountNotFoundException;
import itacademy._15.bankaccounts.exceptions.InsufficientFoundsException;

import java.math.BigDecimal;
import java.util.*;

public class Bank implements Comparable<Bank> {
    private final String bankName;
    private final Map<String, Account> accountList;

    private static int createdBanksCount;
    private final int currentBankNumber;

    public enum AccountType {
        CREDIT,
        SAVINGS
    }

    public Bank(String bankName) {
        this.bankName = bankName;
        this.accountList = new TreeMap<>();

        createdBanksCount++;
        currentBankNumber = createdBanksCount;
    }

    public String getBankName() {
        return bankName;
    }

    public Map<String, Account> getAccountList() {
        return accountList;
    }

    public BigDecimal getAccountBalance(String accountNumber) {
        if(accountList.containsKey(accountNumber)) {
            return accountList.get(accountNumber).getBalance();
        }
        throw new AccountNotFoundException();
    }

    public Set<Log> getAccountHistory(String accountNumber) {
        if(accountList.containsKey(accountNumber)) {
            return  accountList.get(accountNumber).getAccountHistory();
        }
        throw new AccountNotFoundException();
    }

    public void setNewDebitLimit(String accountNumber, BigDecimal newDebtLimit) {
        if(accountList.containsKey(accountNumber)) {
            Account processedAccount = accountList.get(accountNumber);
            if(processedAccount instanceof CreditAccount) {
                ((CreditAccount) processedAccount).setDebtLimit(newDebtLimit);
            } else {
                String exceptionInfo = "Only CreditAccount is accepted here.";
                throw new InputMismatchException(exceptionInfo);
            }
        } else {
            throw new AccountNotFoundException();
        }
    }

    public void setNewPercentage(String accountNumber, BigDecimal newPercentage) {
        if(accountList.containsKey(accountNumber)) {
            Account processedAccount = accountList.get(accountNumber);
            processedAccount.setPercentage(newPercentage);
        } else {
            throw new AccountNotFoundException();
        }
    }

    public boolean makeExternalTransfer(BigDecimal amount, String recipientAccountNumber) {
        Account recipient = accountList.get(recipientAccountNumber);
        return recipient.topUp(amount);
    }

    public boolean makeInternalTransfer(String senderAccountNumber, BigDecimal amount, String recipientAccountNumber) {
        if(accountList.containsKey(senderAccountNumber) && accountList.containsKey(recipientAccountNumber)) {
            Account sender = accountList.get(senderAccountNumber);
            Account recipient = accountList.get(recipientAccountNumber);
            return makeTransfer(sender, amount, recipient);
        }
        throw new AccountNotFoundException();
    }

    private boolean makeTransfer(Account sender, BigDecimal amount, Account recipient) {
        if(((amount.compareTo(sender.getBalance()) <= 0) || (((CreditAccount) sender).getDebtLimit()).compareTo((sender.getBalance()).subtract(amount)) <= 0) && accountList.containsValue(recipient)) {
            return sender.withdraw(amount) && recipient.topUp(amount);
        }
        if(!accountList.containsValue(recipient)) {
            throw new AccountNotFoundException();
        }
        String exceptionInfo = "Account balance: $" + sender.getBalance() + ", is insufficient for withdrawal: $" + amount + ".";
        throw new InsufficientFoundsException(exceptionInfo);
    }

    public String addAccount(String ownerName, BigDecimal initialBalance, AccountType accountType, BigDecimal percentage) {
        if(initialBalance.compareTo(BigDecimal.ZERO) < 0) {
            String exceptionInfo = "Provided initial balance is negative.";
            throw new InputMismatchException(exceptionInfo);
        }

        String accountNumber;
        if(accountType == AccountType.CREDIT) {
            accountNumber = "PL" + currentBankNumber + "0000000" + (accountList.size() + 1) + "C";
            accountList.put(accountNumber, new CreditAccount(accountNumber, ownerName, initialBalance, percentage, BigDecimal.valueOf(5000)));
        } else {
            accountNumber = "PL" + currentBankNumber + "0000000" + (accountList.size() + 1) + "S";
            accountList.put(accountNumber, new SavingsAccount(accountNumber, ownerName, initialBalance, percentage));
        }
        return accountNumber;
    }

    public boolean topUpAccount(String accountNumber, BigDecimal amount) {
        if(accountList.containsKey(accountNumber)) {
            return accountList.get(accountNumber).topUp(amount);
        }
        throw new AccountNotFoundException();
    }

    public boolean withdrawAccount(String accountNumber, BigDecimal amount) {
        if(accountList.containsKey(accountNumber)) {
            return accountList.get(accountNumber).withdraw(amount);
        }
        throw new AccountNotFoundException();
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
        return Objects.equals(bankName, bank.bankName) &&
                Objects.equals(accountList, bank.accountList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bankName, accountList);
    }

    @Override
    public int compareTo(Bank o) {
        return bankName.compareTo(o.getBankName());
    }
}
