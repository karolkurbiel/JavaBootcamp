package itacademy._15.bankaccounts;

import itacademy._15.bankaccounts.restricted.Bank;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class MainBankApplication {

    private static CentralBank centralBank;
    private static final Map<String, String> accountNumbersListAid = new HashMap<>();

    static {
        initBanking();
    }

    public static void main(String[] args) {
        System.out.println("Bank test: ");

        BigDecimal value = BigDecimal.valueOf(69.00);
        String bankName = "QUICKcash";
        String accountName = "Bozena";
        String accountNumber = accountNumbersListAid.get(accountName);
        System.out.println("\tWithdraw: bank: " + bankName + "; account: " + accountNumber + "; operation value: " + value + ":"
                + "\n\t\tAccount balance before: " + centralBank.getBank(bankName).getAccountBalance(accountNumber)
                + "\n\t\tOperation status: " + centralBank.getBank(bankName).withdrawAccount(accountNumber, value)
                + "\n\t\tAccount balance after: " + centralBank.getBank(bankName).getAccountBalance(accountNumber)
        );
        System.out.println("---");

        value = BigDecimal.valueOf(100.00);
        bankName = "National Bank of Losers";
        accountName = "Roman";
        accountNumber = accountNumbersListAid.get(accountName);
        System.out.println("\tTop up: bank: " + bankName + "; account: " + accountNumber + "; operation value: " + value + ":"
                + "\n\t\tAccount balance before: " + centralBank.getBank(bankName).getAccountBalance(accountNumber)
                + "\n\t\tOperation status: " + centralBank.getBank(bankName).topUpAccount(accountNumber, value)
                + "\n\t\tAccount balance after: " + centralBank.getBank(bankName).getAccountBalance(accountNumber)
        );
        System.out.println("---");

        value = BigDecimal.valueOf(100.00);
        bankName = "National Bank of Losers";
        accountName = "Roman";
        accountNumber = accountNumbersListAid.get(accountName);
        System.out.println("\tTop up: bank: " + bankName + "; account: " + accountNumber + "; operation value: " + value + ":"
                + "\n\t\tAccount balance before: " + centralBank.getBank(bankName).getAccountBalance(accountNumber)
                + "\n\t\tOperation status: " + centralBank.getBank(bankName).topUpAccount(accountNumber, value)
                + "\n\t\tAccount balance after: " + centralBank.getBank(bankName).getAccountBalance(accountNumber)
        );
        System.out.println("---");

        value = BigDecimal.valueOf(200_000.00);
        bankName = "GetBackLOL";
        accountName = "Matousz";
        accountNumber = accountNumbersListAid.get(accountName);
        centralBank.getBank(bankName).setNewDebitLimit(accountNumber, BigDecimal.valueOf(500_000.50));
        System.out.println("\tWithdraw: bank: " + bankName + "; account: " + accountNumber + "; operation value: " + value + ":"
                + "\n\t\tAccount balance before: " + centralBank.getBank(bankName).getAccountBalance(accountNumber)
                + "\n\t\tOperation status: " + centralBank.getBank(bankName).withdrawAccount(accountNumber, value)
                + "\n\t\tAccount balance after: " + centralBank.getBank(bankName).getAccountBalance(accountNumber)
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
        accountNumber = accountNumbersListAid.get(accountName);
        String accountNumber2 = accountNumbersListAid.get(accountName2);
        System.out.println("\tInternal transfer: bank: " + bankName + "; account: " + accountNumber + ", " + accountNumber2 + "; operation value: " + value + ":"
                        + "\n\t\tAccount balance before: " + centralBank.getBank(bankName).getAccountBalance(accountNumber)
                        + "\n\t\tAccount2 balance before: " + centralBank.getBank(bankName).getAccountBalance(accountNumber2)
                        + "\n\t\tOperation status: " + centralBank.getBank(bankName).makeInternalTransfer(accountNumber, value, accountNumber2)
                        + "\n\t\tAccount balance after: " + centralBank.getBank(bankName).getAccountBalance(accountNumber)
                        + "\n\t\tAccount2 balance after: " + centralBank.getBank(bankName).getAccountBalance(accountNumber2)
        );
        System.out.println("---");

        value = BigDecimal.valueOf(35_000.00);
        bankName = "GetBackLOL";
        bankName2 = "Intense Life";
        accountName = "Mieczyslaw";
        accountName2 = "Julka";
        accountNumber = accountNumbersListAid.get(accountName);
        accountNumber2 = accountNumbersListAid.get(accountName2);
        System.out.println("\tExternal transfer: bank: " + bankName + ", " + bankName2 + "; account: " + accountNumber + ", " + accountNumber2 + "; operation value: " + value + ":"
                + "\n\t\tAccount balance before: " + centralBank.getBank(bankName).getAccountBalance(accountNumber)
                + "\n\t\tAccount2 balance before: " + centralBank.getBank(bankName2).getAccountBalance(accountNumber2)
                + "\n\t\tOperation status: " + centralBank.makeCrossBankTransfer(accountNumber, value, accountNumber2)
                + "\n\t\tAccount balance after: " + centralBank.getBank(bankName).getAccountBalance(accountNumber)
                + "\n\t\tAccount2 balance after: " + centralBank.getBank(bankName2).getAccountBalance(accountNumber2)
        );
        System.out.println("---");

        value = BigDecimal.valueOf(35_000.00);
        bankName = "GetBackLOL";
        accountName = "Mieczyslaw";
        accountNumber = accountNumbersListAid.get(accountName);
        System.out.println("\tWithdraw: bank: " + bankName + "; account: " + accountNumber + "; operation value: " + value + ":"
                + "\n\t\tAccount balance before: " + centralBank.getBank(bankName).getAccountBalance(accountNumber)
                + "\n\t\tOperation status: " + centralBank.getBank(bankName).withdrawAccount(accountNumber, value)
                + "\n\t\tAccount balance after: " + centralBank.getBank(bankName).getAccountBalance(accountNumber)
        );
        System.out.println("---");

        value = BigDecimal.valueOf(3_000.00);
        bankName = "GetBackLOL";
        accountName = "Mieczyslaw";
        accountNumber = accountNumbersListAid.get(accountName);
        System.out.println("\tTop up: bank: " + bankName + "; account: " + accountNumber + "; operation value: " + value + ":"
                + "\n\t\tAccount balance before: " + centralBank.getBank(bankName).getAccountBalance(accountNumber)
                + "\n\t\tOperation status: " + centralBank.getBank(bankName).topUpAccount(accountNumber, value)
                + "\n\t\tAccount balance after: " + centralBank.getBank(bankName).getAccountBalance(accountNumber)
        );
        System.out.println("---");

        value = BigDecimal.valueOf(35_000.00);
        bankName = "Intense Life";
        accountName = "Julka";
        accountNumber = accountNumbersListAid.get(accountName);
        System.out.println("\tWithdraw: bank: " + bankName + "; account: " + accountNumber + "; operation value: " + value + ":"
                + "\n\t\tAccount balance before: " + centralBank.getBank(bankName).getAccountBalance(accountNumber)
                + "\n\t\tOperation status: " + centralBank.getBank(bankName).topUpAccount(accountNumber, value)
                + "\n\t\tAccount balance after: " + centralBank.getBank(bankName).getAccountBalance(accountNumber)
        );
        System.out.println("---");
    }

    private static void initBanking() {
        centralBank = CentralBank.getInstance();

        centralBank.createNewBank("QUICKcash");
        centralBank.createNewBank("GetBackLOL");
        centralBank.createNewBank("McDuck Bank");
        centralBank.createNewBank("National Bank of Losers");
        Bank bank = new Bank("Outer Bank");
        centralBank.createNewBak(bank);
        bank = new Bank("Intense Life");
        centralBank.createNewBak(bank);

        bank = centralBank.getBank("QUICKcash");
        accountNumbersListAid.put("Janusz", bank.addAccount("Janusz", BigDecimal.valueOf(10.50), Bank.AccountType.CREDIT, BigDecimal.valueOf(0.0987)));
        accountNumbersListAid.put("Bozena", bank.addAccount("Bozena", BigDecimal.valueOf(1011.29), Bank.AccountType.CREDIT, BigDecimal.valueOf(0.0678)));

        bank = centralBank.getBank("GetBackLOL");
        accountNumbersListAid.put("Matousz", bank.addAccount("Matousz",BigDecimal.valueOf(100_000.96),Bank.AccountType.CREDIT, BigDecimal.valueOf(0.1499)));
        accountNumbersListAid.put("Mieczyslaw", bank.addAccount("Mieczyslaw",BigDecimal.valueOf(34_076.00),Bank.AccountType.CREDIT, BigDecimal.valueOf(0.1234)));

        bank = centralBank.getBank("McDuck Bank");
        accountNumbersListAid.put("Donald", bank.addAccount("Donald",BigDecimal.valueOf(1_000_000.00),Bank.AccountType.SAVINGS, BigDecimal.valueOf(0.01)));
        accountNumbersListAid.put("Quackmore", bank.addAccount("Quackmore",BigDecimal.valueOf(50_000.00),Bank.AccountType.SAVINGS, BigDecimal.valueOf(0.02)));

        bank = centralBank.getBank("National Bank of Losers");
        accountNumbersListAid.put("Roman", bank.addAccount("Roman",BigDecimal.valueOf(50.00),Bank.AccountType.CREDIT, BigDecimal.valueOf(0.0845)));
        accountNumbersListAid.put("Bartosz", bank.addAccount("Bartosz",BigDecimal.valueOf(50_000.00),Bank.AccountType.SAVINGS, BigDecimal.valueOf(0.01)));

        bank = centralBank.getBank("Outer Bank");
        accountNumbersListAid.put("Ryszard", bank.addAccount("Ryszard",BigDecimal.valueOf(14_000.00),Bank.AccountType.SAVINGS, BigDecimal.valueOf(0.03)));
        accountNumbersListAid.put("Tomasz", bank.addAccount("Tomasz",BigDecimal.valueOf(50_000.00),Bank.AccountType.CREDIT, BigDecimal.valueOf(0.1405)));

        bank = centralBank.getBank("Intense Life");
        accountNumbersListAid.put("Julka", bank.addAccount("Julka",BigDecimal.valueOf(100.00),Bank.AccountType.SAVINGS, BigDecimal.valueOf(0.09)));
        accountNumbersListAid.put("Oskar", bank.addAccount("Oskar",BigDecimal.valueOf(100.00),Bank.AccountType.CREDIT, BigDecimal.valueOf(0.0550)));
    }
}
