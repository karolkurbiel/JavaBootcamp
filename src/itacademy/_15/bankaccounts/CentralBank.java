package itacademy._15.bankaccounts;

import itacademy._15.bankaccounts.restricted.Account;
import itacademy._15.bankaccounts.restricted.Bank;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class CentralBank {
    private final Map<String, Bank> bankList;

    public CentralBank() {
        this.bankList = new HashMap<>();
    }

    public boolean createNewBak(Bank bank) {
        if(bankList.containsKey(bank.getName())) {
            return false;
        }
        bankList.put(bank.getName(), bank);
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

    public boolean makeCrossBankTransfer(Account sender, BigDecimal amount, Account recipient) {
        Bank sendersBank = null;
        Bank recipientsBank = null;
        for(Map.Entry<String, Bank> bankEntry : bankList.entrySet()) {
            if(bankEntry.getValue().getAccountList().containsValue(sender)) {
                sendersBank = bankEntry.getValue();
            }
            if(bankEntry.getValue().getAccountList().containsValue(recipient)) {
                recipientsBank = bankEntry.getValue();
            }
        }
        if(sendersBank == null || recipientsBank == null) {
            return false;
        }

        return recipientsBank.makeExternalTransfer(sender, amount, recipient);
    }

    public Bank getBank(String name) {
        return bankList.getOrDefault(name, null);
    }
}
