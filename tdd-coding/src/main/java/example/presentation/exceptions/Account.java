package example.presentation.exceptions;

public class Account {
    private final String name;
    private int balance = 0;

    public Account(final String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getBalance() {
        return balance;
    }

    public int deposit(final int amount) {
        return balance += amount;
    }

    public int withdraw(final int amount) throws NotEnoughMoneyException {
        if (amount > balance) {
            throw new NotEnoughMoneyException(this, amount);
        }
        return balance -= amount;
    }

    @Override
    public String toString() {
        return "Account{" +
                "name='" + name + "'" +
                ", balance=" + balance +
                "}";
    }
}
