package itacademy._15.bankaccounts;

import itacademy._15.bankaccounts.exceptions.AccountNotFoundException;
import itacademy._15.bankaccounts.exceptions.BankAlreadyExistsException;
import itacademy._15.bankaccounts.exceptions.BankNotFoundException;
import itacademy._15.bankaccounts.restricted.Bank;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class CentralBank {
    private static final CentralBank instance = new CentralBank();
    private final Map<String, Bank> bankList;

    public static CentralBank getInstance() {
        return instance;
    }

    private CentralBank() {
        this.bankList = new HashMap<>();
    }

    public void createNewBak(Bank bank) {
        if(bankList.containsKey(bank.getBankName())) {
            throw new BankAlreadyExistsException();
        }
        bankList.put(bank.getBankName(), bank);
    }

    public void createNewBank(String name) {
        if(bankList.containsKey(name)) {
            throw new BankAlreadyExistsException();
        }
        bankList.put(name, new Bank(name));
    }

    public boolean makeCrossBankTransfer(String senderAccountNumber, BigDecimal amount, String recipientAccountNumber) {
        Bank sendersBank = null;
        Bank recipientsBank = null;
        for(Map.Entry<String, Bank> bankEntry : bankList.entrySet()) {
            try {
                if(bankEntry.getValue().getAccountList().containsKey(senderAccountNumber)) {
                    sendersBank = bankEntry.getValue();
                }
                if(bankEntry.getValue().getAccountList().containsKey(recipientAccountNumber)) {
                    recipientsBank = bankEntry.getValue();
                }
            } catch(NullPointerException e) {
                throw new AccountNotFoundException();
            }
        }
        if(sendersBank == null || recipientsBank == null) {
            throw new AccountNotFoundException();
        }

        if(sendersBank.withdrawAccount(senderAccountNumber, amount)) {
            return recipientsBank.makeExternalTransfer(amount, recipientAccountNumber);
        }
        return false;
    }

    public Bank getBank(String name) {
        if(bankList.containsKey(name)) {
            return bankList.get(name);
        }
        throw new BankNotFoundException();
    }

    public void reset() {
        bankList.clear();
    }
}
