package itacademy._15.bankaccounts;

import itacademy._15.bankaccounts.restricted.Bank;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class CentralBank {
    private static CentralBank instance = new CentralBank();
    private final Map<String, Bank> bankList;

    public static CentralBank getInstance() {
        return instance;
    }

    private CentralBank() {
        this.bankList = new HashMap<>();
    }

    public boolean createNewBak(Bank bank) {
        if(bankList.containsKey(bank.getBankName())) {
            return false;
        }
        bankList.put(bank.getBankName(), bank);
        return true;
    }

    public boolean createNewBank(String name) {
        if(bankList.containsKey(name)) {
            System.out.println("Bank called: " + name + " already exists in the list!");
            return false;
        }
        bankList.put(name, new Bank(name));
        return true;
    }

    public boolean makeCrossBankTransfer(String senderAccountNumber, BigDecimal amount, String recipientAccountNumber) {
        Bank sendersBank = null;
        Bank recipientsBank = null;
        for(Map.Entry<String, Bank> bankEntry : bankList.entrySet()) {
            if(bankEntry.getValue().getAccountList().containsKey(senderAccountNumber)) {
                sendersBank = bankEntry.getValue();
            }
            if(bankEntry.getValue().getAccountList().containsKey(recipientAccountNumber)) {
                recipientsBank = bankEntry.getValue();
            }
        }
        if(sendersBank == null || recipientsBank == null) {
            return false;
        }

        if(sendersBank.withdrawAccount(senderAccountNumber, amount)) {
            return recipientsBank.makeExternalTransfer(amount, recipientAccountNumber);
        }
        return false;
    }

    public Bank getBank(String name) {
        return bankList.getOrDefault(name, null);
    }
}
