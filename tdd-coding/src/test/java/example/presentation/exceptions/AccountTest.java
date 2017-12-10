package example.presentation.exceptions;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.hamcrest.core.StringStartsWith.startsWith;
import static org.junit.Assert.*;

public class AccountTest {
    @Test(expected = NotEnoughMoneyException.class)
    public void shouldThrowsNotEnoughMoneyException() throws Exception {
        // given
        final Account account = new Account("Rafal");
        account.deposit(100);
        // when
        account.withdraw(200);
    }

    @Test
    public void shouldThrowNotEnoughMoneyException() throws Exception {
        // given
        final Account account = new Account("Rafos");
        account.deposit(100);

        try {
            // when
            account.withdraw(200);
            fail("attempt to withdraw too much money should throw an exception");
        } catch (NotEnoughMoneyException e) {
            // then
        }
    }

    @Test
    public void shouldThrowNotEnoughMoneyExceptionWithMessage() throws Exception {
        // given
        final Account account = new Account("Rafos");
        account.deposit(100);

        try {
            // when
            account.withdraw(200);
            fail("attempt to withdraw too much money should throw an exception");
        } catch (NotEnoughMoneyException e) {
            // then
            assertEquals(100, account.getBalance());
            assertTrue(e.getMessage().contains("cannot withdraw"));
        }
    }

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void shouldThrowsNotEnoughMoneyExceptionWithRule() throws Exception {
        // given
        thrown.expect(NotEnoughMoneyException.class);
        thrown.expectMessage("cannot withdraw 200");
        thrown.expectMessage(startsWith("Account{name='Rafos'"));
        final Account account = new Account("Rafos");
        account.deposit(100);

        // when
        account.withdraw(200);

        // then
        fail("attempt to withdraw too much money should throw an exception"); // optional
    }
}