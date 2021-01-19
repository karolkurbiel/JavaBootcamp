package _15.bankaccounts;

import itacademy._15.bankaccounts.CentralBank;
import itacademy._15.bankaccounts.exceptions.AccountNotFoundException;
import itacademy._15.bankaccounts.exceptions.BankAlreadyExistsException;
import itacademy._15.bankaccounts.exceptions.BankNotFoundException;
import itacademy._15.bankaccounts.restricted.Bank;
import org.junit.BeforeClass;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CentralBankTest {
    private CentralBank centralBank;
    private Map<String, String> accountNumbersListAid;

    @BeforeEach
    void setUp() {
        centralBank = CentralBank.getInstance();
        accountNumbersListAid = new HashMap<>();

        centralBank.createNewBank("McDuck Bank");
        centralBank.createNewBank("National Bank of Losers");

        Bank bank = centralBank.getBank("McDuck Bank");
        accountNumbersListAid.put("Janusz", bank.addAccount("Janusz", BigDecimal.valueOf(100.0), Bank.AccountType.CREDIT, BigDecimal.valueOf(0.01)));
        bank = centralBank.getBank("National Bank of Losers");
        accountNumbersListAid.put("Bozena", bank.addAccount("Bozena", BigDecimal.valueOf(100.0), Bank.AccountType.CREDIT, BigDecimal.valueOf(0.01)));
    }

    @AfterEach
    void setOut() {
        centralBank.reset();
    }

    @Test
    void createNewBank_addNewBank_bankAddedSuccessfully() {
        Bank bank = new Bank("What");
        centralBank.createNewBak(bank);

        assertThat(centralBank.getBank(bank.getBankName())).isEqualTo(bank);
    }

    @Test
    void createNewBank_addNewBank_throwBankAlreadyExistsException() {
        BankAlreadyExistsException exception = assertThrows(BankAlreadyExistsException.class,
                () -> centralBank.createNewBank("McDuck Bank"));
        assertThat(exception).hasMessage("Bank already exists.");
    }

    @Test
    void makeCrossBankTransfer_providedProperDataForTransfer_returnTrue() {
        assertTrue(centralBank.makeCrossBankTransfer(accountNumbersListAid.get("Janusz"), BigDecimal.valueOf(25.0), accountNumbersListAid.get("Bozena")));
    }

    @Test
    void makeCrossBankTransfer_providedWrongSenderAccountNumber_throwAccountNotFoundException() {
        AccountNotFoundException exception = assertThrows(AccountNotFoundException.class,
                () -> centralBank.makeCrossBankTransfer("1234", BigDecimal.TEN, accountNumbersListAid.get("Maria")));
        assertThat(exception).hasMessage("Not found.");
    }

    @Test
    void getBank_providedExistingBank_returnsBank() {
        Bank testBank = new Bank("MariuszBank");
        centralBank.createNewBak(testBank);

        assertThat(centralBank.getBank("MariuszBank")).isEqualTo(testBank);
    }

    @Test
    void getBank_providedNonExistingBank_throwBankNotFoundException() {
        BankNotFoundException exception = assertThrows(BankNotFoundException.class,
                () -> centralBank.getBank("MariuszBank"));
        assertThat(exception).hasMessage("Not found.");
    }
}