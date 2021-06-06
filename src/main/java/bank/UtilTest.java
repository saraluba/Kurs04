package bank;

import bank.internal.Bank;
import bank.internal.CreditAccount;
import bank.internal.DepositAccount;
import org.junit.jupiter.api.*;
import java.math.BigDecimal;
import static org.assertj.core.api.Assertions.assertThat;

class UtilTest {

    Bank testBank = new Bank("test");
    DepositAccount depositAccountTest = new DepositAccount("1",BigDecimal.valueOf(12345), 0.6);
    CreditAccount creditAccountTest = new CreditAccount("2", BigDecimal.valueOf(0),0.5, BigDecimal.valueOf(2000));

    @BeforeEach
    public void setUp(){
        System.out.print("Test ");
    }

    @AfterEach
    public void tearDown(){
        System.out.println("passed");
    }

    @Test
    public void topUpDepositTest(){
        testBank.createDepositAccount(depositAccountTest);
        testBank.topUpDepositAccount("1", BigDecimal.valueOf(777));
        BigDecimal resultDeposit = depositAccountTest.getBalance();
        BigDecimal expectedResultDeposit = BigDecimal.valueOf(13122);
        assertThat(resultDeposit).isEqualTo(expectedResultDeposit);
    }

    @Test
    public void topUpCreditTest(){
        testBank.createCreditAccount(creditAccountTest);
        testBank.topUpCreditAccount("2", BigDecimal.valueOf(10000));
        BigDecimal resultCredit = creditAccountTest.getBalance();
        BigDecimal expectedResultCredit = BigDecimal.valueOf(10000);
        assertThat(resultCredit).isEqualTo(expectedResultCredit);
    }



}
