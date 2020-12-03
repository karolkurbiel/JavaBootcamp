package itacademy._15.bankaccounts;

import itacademy._15.bankaccounts.restricted.Account;
import itacademy._15.bankaccounts.restricted.Bank;
import itacademy._15.bankaccounts.restricted.CreditAccount;

import java.math.BigDecimal;

public class MainBankApplication {

    private static CentralBank centralBank;

    static {
        initBanking();
    }

    public static void main(String[] args) {
        System.out.println("Bank test: ");

        BigDecimal value = BigDecimal.valueOf(69.00);
        String bankName = "QUICKcash";
        String accountName = "Bozena";
        System.out.println("\tWithdraw: bank: " + bankName + "; account: " + accountName + "; operation value: " + value + ":"
                + "\n\t\tAccount balance before: " + centralBank.getBank(bankName).getAccountList().get(accountName).getBalance()
                + "\n\t\tOperation status: " + centralBank.getBank(bankName).getAccountList().get(accountName).withdraw(value)
                + "\n\t\tAccount balance after: " + centralBank.getBank(bankName).getAccountList().get(accountName).getBalance()
        );
        System.out.println("---");

        value = BigDecimal.valueOf(100.00);
        bankName = "National Bank of Losers";
        accountName = "Roman";
        System.out.println("\tTop up: bank: " + bankName + "; account: " + accountName + "; operation value: " + value + ":"
                + "\n\t\tAccount balance before: " + centralBank.getBank(bankName).getAccountList().get(accountName).getBalance()
                + "\n\t\tOperation status: " + centralBank.getBank(bankName).getAccountList().get(accountName).topUp(value)
                + "\n\t\tAccount balance after: " + centralBank.getBank(bankName).getAccountList().get(accountName).getBalance()
        );
        System.out.println("---");

        value = BigDecimal.valueOf(100.00);
        bankName = "National Bank of Losers";
        accountName = "Roman";
        System.out.println("\tTop up: bank: " + bankName + "; account: " + accountName + "; operation value: " + value + ":"
                + "\n\t\tAccount balance before: " + centralBank.getBank(bankName).getAccountList().get(accountName).getBalance()
                + "\n\t\tOperation status: " + centralBank.getBank(bankName).getAccountList().get(accountName).topUp(value)
                + "\n\t\tAccount balance after: " + centralBank.getBank(bankName).getAccountList().get(accountName).getBalance()
        );
        System.out.println("---");

        value = BigDecimal.valueOf(200_000.00);
        bankName = "GetBackLOL";
        accountName = "Matousz";
        CreditAccount creditAccount = (CreditAccount) centralBank.getBank(bankName).getAccountList().get(accountName);
        creditAccount.setDebtLimit(BigDecimal.valueOf(500_000.50));
        System.out.println("\tWithdraw: bank: " + bankName + "; account: " + accountName + "; operation value: " + value + ":"
                + "\n\t\tAccount balance before: " + centralBank.getBank(bankName).getAccountList().get(accountName).getBalance()
                + "\n\t\tOperation status: " + centralBank.getBank(bankName).getAccountList().get(accountName).withdraw(value)
                + "\n\t\tAccount balance after: " + centralBank.getBank(bankName).getAccountList().get(accountName).getBalance()
        );
        System.out.println("---");

        bankName = "GetBackLOL";
        String bankName2 = "National Bank of Losers";
        System.out.println("\tRecalculate percentage: bank: " + bankName + ", " + bankName2 + ":"
                + "\n\t\tBank1 balance before: " + centralBank.getBank(bankName).getAccountList()
                + "\n\t\tBank2 balance before: " + centralBank.getBank(bankName2).getAccountList()
                + "\n\t\tOperation1 status:");

        centralBank.getBank(bankName).recalculatePercents();
        System.out.print("\n\t\tOperation2 status:\n");
        centralBank.getBank(bankName2).recalculatePercents();

        System.out.print("\n\t\tBank1 balance after: " +centralBank.getBank(bankName).getAccountList()
                + "\n\t\tBank2 balance after: " + centralBank.getBank(bankName2).getAccountList()
        );
        System.out.println("\n---");

        value = BigDecimal.valueOf(100.00);
        bankName = "Intense Life";
        accountName = "Oskar";
        String accountName2 = "Julka";
        Account oskarsAccount = centralBank.getBank(bankName).getAccountList().get(accountName);
        Account julkasAccount = centralBank.getBank(bankName).getAccountList().get(accountName2);
        System.out.println("\tInternal transfer: bank: " + bankName + "; account: " + accountName + ", " + accountName2 + "; operation value: " + value + ":"
                        + "\n\t\tAccount balance before: " + centralBank.getBank(bankName).getAccountList().get(accountName).getBalance()
                        + "\n\t\tAccount2 balance before: " + centralBank.getBank(bankName).getAccountList().get(accountName2).getBalance()
                        + "\n\t\tOperation status: " + centralBank.getBank(bankName).makeInternalTransfer(oskarsAccount, value, julkasAccount)
                        + "\n\t\tAccount balance after: " + centralBank.getBank(bankName).getAccountList().get(accountName).getBalance()
                        + "\n\t\tAccount2 balance after: " + centralBank.getBank(bankName).getAccountList().get(accountName2).getBalance()
        );
        System.out.println("---");

        value = BigDecimal.valueOf(35_000.00);
        bankName2 = "Intense Life";
        bankName = "GetBackLOL";
        accountName = "Mieczyslaw";
        accountName2 = "Julka";
        Account mieczyslawAccount = centralBank.getBank(bankName).getAccountList().get(accountName);
        julkasAccount = centralBank.getBank(bankName2).getAccountList().get(accountName2);
        System.out.println("\tExternal transfer: bank: " + bankName + ", " + bankName2 + "; account: " + accountName + ", " + accountName2 + "; operation value: " + value + ":"
                + "\n\t\tAccount balance before: " + centralBank.getBank(bankName).getAccountList().get(accountName).getBalance()
                + "\n\t\tAccount2 balance before: " + centralBank.getBank(bankName2).getAccountList().get(accountName2).getBalance()
                + "\n\t\tOperation status: " + centralBank.makeCrossBankTransfer(mieczyslawAccount, value, julkasAccount)
                + "\n\t\tAccount balance after: " + centralBank.getBank(bankName).getAccountList().get(accountName).getBalance()
                + "\n\t\tAccount2 balance after: " + centralBank.getBank(bankName2).getAccountList().get(accountName2).getBalance()
        );
        System.out.println("---");

        value = BigDecimal.valueOf(35_000.00);
        bankName = "GetBackLOL";
        accountName = "Mieczyslaw";
        System.out.println("\tWithdraw: bank: " + bankName + "; account: " + accountName + "; operation value: " + value + ":"
                + "\n\t\tAccount balance before: " + centralBank.getBank(bankName).getAccountList().get(accountName).getBalance()
                + "\n\t\tOperation status: " + centralBank.getBank(bankName).getAccountList().get(accountName).withdraw(value)
                + "\n\t\tAccount balance after: " + centralBank.getBank(bankName).getAccountList().get(accountName).getBalance()
        );
        System.out.println("---");

        value = BigDecimal.valueOf(3_000.00);
        bankName = "GetBackLOL";
        accountName = "Mieczyslaw";
        mieczyslawAccount = centralBank.getBank(bankName).getAccountList().get(accountName);
        System.out.println("\tTop up with number: bank: " + bankName + "; account: " + accountName + "; operation value: " + value + ":"
                + "\n\t\tAccount balance before: " + centralBank.getBank(bankName).getAccountList().get(accountName).getBalance()
                + "\n\t\tOperation status: " + centralBank.getBank(bankName).topUpAccount(mieczyslawAccount.getAccountNumber(), value)
                + "\n\t\tAccount balance after: " + centralBank.getBank(bankName).getAccountList().get(accountName).getBalance()
        );
        System.out.println("---");

        value = BigDecimal.valueOf(35_000.00);
        bankName = "Intense Life";
        accountName = "Julka";
        julkasAccount = centralBank.getBank(bankName).getAccountList().get(accountName);
        System.out.println("\tWithdraw with number: bank: " + bankName + "; account: " + accountName + "; operation value: " + value + ":"
                + "\n\t\tAccount balance before: " + centralBank.getBank(bankName).getAccountList().get(accountName).getBalance()
                + "\n\t\tOperation status: " + centralBank.getBank(bankName).withdrawAccount(julkasAccount.getAccountNumber(), value)
                + "\n\t\tAccount balance after: " + centralBank.getBank(bankName).getAccountList().get(accountName).getBalance()
        );
        System.out.println("---");
    }

    private static void initBanking() {
        centralBank = new CentralBank();

        centralBank.createNewBank("QUICKcash");
        centralBank.createNewBank("GetBackLOL");
        centralBank.createNewBank("McDuck Bank");
        centralBank.createNewBank("National Bank of Losers");
        Bank bank = new Bank("Outer Bank");
        centralBank.createNewBak(bank);
        bank = new Bank("Intense Life");
        centralBank.createNewBak(bank);

        bank = centralBank.getBank("QUICKcash");
        bank.addAccount("Janusz", BigDecimal.valueOf(10.50), Bank.AccountType.CREDIT, BigDecimal.valueOf(0.0987));
        bank.addAccount("Bozena", BigDecimal.valueOf(1011.29), Bank.AccountType.CREDIT, BigDecimal.valueOf(0.0678));

        bank = centralBank.getBank("GetBackLOL");
        bank.addAccount("Matousz",BigDecimal.valueOf(100_000.96),Bank.AccountType.CREDIT, BigDecimal.valueOf(0.1499));
        bank.addAccount("Mieczyslaw",BigDecimal.valueOf(34_076.00),Bank.AccountType.CREDIT, BigDecimal.valueOf(0.1234));

        bank = centralBank.getBank("McDuck Bank");
        bank.addAccount("Donald",BigDecimal.valueOf(1_000_000.00),Bank.AccountType.SAVINGS, BigDecimal.valueOf(0.01));
        bank.addAccount("Quackmore",BigDecimal.valueOf(50_000.00),Bank.AccountType.SAVINGS, BigDecimal.valueOf(0.02));

        bank = centralBank.getBank("National Bank of Losers");
        bank.addAccount("Roman",BigDecimal.valueOf(50.00),Bank.AccountType.CREDIT, BigDecimal.valueOf(0.0845));
        bank.addAccount("Bartosz",BigDecimal.valueOf(50_000.00),Bank.AccountType.SAVINGS, BigDecimal.valueOf(0.01));

        bank = centralBank.getBank("Outer Bank");
        bank.addAccount("Ryszard",BigDecimal.valueOf(14_000.00),Bank.AccountType.SAVINGS, BigDecimal.valueOf(0.03));
        bank.addAccount("Tomasz",BigDecimal.valueOf(50_000.00),Bank.AccountType.CREDIT, BigDecimal.valueOf(0.1405));

        bank = centralBank.getBank("Intense Life");
        bank.addAccount("Julka",BigDecimal.valueOf(100.00),Bank.AccountType.SAVINGS, BigDecimal.valueOf(0.09));
        bank.addAccount("Oskar",BigDecimal.valueOf(100.00),Bank.AccountType.CREDIT, BigDecimal.valueOf(0.0550));
    }
}
