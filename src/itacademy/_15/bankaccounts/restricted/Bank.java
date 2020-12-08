package itacademy._15.bankaccounts.restricted;

import java.math.BigDecimal;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;

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

//    public String getAccountNumber(String ownerName) {
//        for(Map.Entry<String, Account> account : accountList.entrySet()) {
//
//        }
//    }

    public BigDecimal getAccountBalance(String accountNumber) {
        if(accountList.containsKey(accountNumber)) {
            return accountList.get(accountNumber).getBalance();
        }
        return null;
    }

    public void setNewDebitLimit(String accountNumber, BigDecimal newDebtLimit) {
        if(accountList.containsKey(accountNumber)) {
            Account processedAccount = accountList.get(accountNumber);
            if(processedAccount instanceof CreditAccount) {
                ((CreditAccount) processedAccount).setDebtLimit(newDebtLimit);
            } else {
                throw new InputMismatchException();
            }
        } else {
            throw new NullPointerException();
        }
    }

    public boolean makeExternalTransfer(BigDecimal amount, String recipientAccountNumber) {
//        Account sender = accountList.get(senderAccountNumber);
        Account recipient = accountList.get(recipientAccountNumber);
        return recipient.topUp(amount);
    }

    public boolean makeInternalTransfer(String senderAccountNumber, BigDecimal amount, String recipientAccountNumber) {
        if(accountList.containsKey(senderAccountNumber) && accountList.containsKey(recipientAccountNumber)) {
            Account sender = accountList.get(senderAccountNumber);
            Account recipient = accountList.get(recipientAccountNumber);
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

    public String addAccount(String ownerName, BigDecimal initialBalance, AccountType ACCOUNT_TYPE, BigDecimal percentage) {
        if(accountList.containsKey(ownerName) || initialBalance.compareTo(BigDecimal.ZERO) < 0) {
            throw new NullPointerException();
        }

        String accountNumber;
        if(ACCOUNT_TYPE == AccountType.CREDIT) {
            accountNumber = "PL" + currentBankNumber + "0000000" + (accountList.size() + 1) + "C";
            accountList.put(accountNumber, new CreditAccount(accountNumber, ownerName, initialBalance, percentage, BigDecimal.valueOf(5000)));
        } else {
            accountNumber = "PL" + currentBankNumber + "0000000" + (accountList.size() + 1) + "S";
            accountList.put(accountNumber, new SavingsAccount(accountNumber, ownerName, initialBalance, percentage));
        }
        return accountNumber;
    }

    public boolean topUpAccount(String accountNumber, BigDecimal amount) {

//        Account processedAccount = null;
//
//        for(Map.Entry<String, Account> account : accountList.entrySet()) {
//            if(account.getValue().getAccountNumber().equals(accountNumber)) {
//                processedAccount = account.getValue();
//                break;
//            }
//        }
//        if(processedAccount != null) {
//            return processedAccount.topUp(amount);
//        }

        if(accountList.containsKey(accountNumber)) {
            return accountList.get(accountNumber).topUp(amount);
        }
        return false;
    }

    public boolean withdrawAccount(String accountNumber, BigDecimal amount) {
//        Account processedAccount = null;
//
//        for(Map.Entry<String, Account> account : accountList.entrySet()) {
//            if(account.getValue().getAccountNumber().equals(accountNumber)) {
//                processedAccount = account.getValue();
//                break;
//            }
//        }
//        if(processedAccount != null) {
//            return processedAccount.withdraw(amount);
//        }

        if(accountList.containsKey(accountNumber)) {
            return accountList.get(accountNumber).withdraw(amount);
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
