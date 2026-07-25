class Account {

    private final String accountName;
    private double balance;

    public Account(
            String accountName,
            double balance) {

        this.accountName = accountName;
        this.balance = balance;
    }

    public synchronized void deposit(
            double amount) {

        balance += amount;

        System.out.println(
            "Deposited $" + amount
            + " into " + accountName
        );
    }

    public synchronized void withdraw(
            double amount) {

        balance -= amount;

        System.out.println(
            "Withdrawn $" + amount
            + " from " + accountName
        );
    }

    public synchronized double getBalance() {
        return balance;
    }
}

public class Task03BankTransferSystem {

    public static void transfer(
            Account from,
            Account to,
            double amount) {

        /*
         * Consistent synchronization strategy:
         * All transfers lock Account A first,
         * then Account B.
         *
         * This prevents circular waiting.
         */
        synchronized (Task03BankTransferSystem.class) {

            from.withdraw(amount);
            to.deposit(amount);

            System.out.println(
                Thread.currentThread().getName()
                + " completed transfer of $"
                + amount
            );
        }
    }

    public static void main(String[] args) {

        Account accountA =
            new Account("Account A", 1000);

        Account accountB =
            new Account("Account B", 1000);

        Thread thread1 = new Thread(() -> {

            transfer(
                accountA,
                accountB,
                200
            );

        }, "Thread 1");

        Thread thread2 = new Thread(() -> {

            transfer(
                accountB,
                accountA,
                300
            );

        }, "Thread 2");

        thread1.start();
        thread2.start();

        try {

            thread1.join();
            thread2.join();

        } catch (InterruptedException e) {

            Thread.currentThread().interrupt();
        }

        System.out.println("\nFinal Account Balances:");

        System.out.println(
            "Account A: $"
            + accountA.getBalance()
        );

        System.out.println(
            "Account B: $"
            + accountB.getBalance()
        );
    }
}