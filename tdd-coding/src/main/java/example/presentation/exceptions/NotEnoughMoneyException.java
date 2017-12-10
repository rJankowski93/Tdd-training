package example.presentation.exceptions;

public class NotEnoughMoneyException extends Exception {
    public NotEnoughMoneyException(final Account account, final int amount) {
        super(account + " cannot withdraw " + amount);
    }
}
