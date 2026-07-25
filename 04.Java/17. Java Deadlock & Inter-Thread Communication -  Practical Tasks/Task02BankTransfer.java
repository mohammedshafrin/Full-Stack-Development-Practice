class BankAccount {

    private final int accountNumber;
    private double balance;

    public BankAccount(int accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public synchronized void deposit(double amount) {

        balance += amount;

        System.out.println(
            "Deposited $" + amount
            + " into Account "
            + accountNumber
        );

        notifyAll();
    }

    public synchronized void withdraw(double amount)
            throws InterruptedException {

        while (balance < amount) {

            System.out.println(
                "Account " + accountNumber
                + " has insufficient balance."
            );

            System.out.println(
                "Thread is waiting for a deposit..."
            );

            wait();
        }

        balance -= amount;

        System.out.println(
            "Withdrawn $" + amount
            + " from Account "
            + accountNumber
        );
    }

    public synchronized double getBalance() {
        return balance;
    }
}

public class Task02BankTransfer {

    public static void transfer(
            BankAccount from,
            BankAccount to,
            double amount)
            throws InterruptedException {

        BankAccount firstLock;
        BankAccount secondLock;

        if (from.getAccountNumber()
                < to.getAccountNumber()) {

            firstLock = from;
            secondLock = to;

        } else {

            firstLock = to;
            secondLock = from;
        }

        synchronized (firstLock) {

            System.out.println(
                Thread.currentThread().getName()
                + " locked Account "
                + firstLock.getAccountNumber()
            );

            synchronized (secondLock) {

                System.out.println(
                    Thread.currentThread().getName()
                    + " locked Account "
                    + secondLock.getAccountNumber()
                );

                from.withdraw(amount);
                to.deposit(amount);

                System.out.println(
                    Thread.currentThread().getName()
                    + " transferred $" + amount
                );
            }
        }
    }

    public static void main(String[] args) {

        BankAccount accountA =
            new BankAccount(1, 1000);

        BankAccount accountB =
            new BankAccount(2, 1000);

        Thread thread1 = new Thread(() -> {

            try {

                transfer(
                    accountA,
                    accountB,
                    700
                );

            } catch (InterruptedException e) {

                Thread.currentThread().interrupt();
            }

        }, "Thread 1");

        Thread thread2 = new Thread(() -> {

            try {

                transfer(
                    accountB,
                    accountA,
                    500
                );

            } catch (InterruptedException e) {

                Thread.currentThread().interrupt();
            }

        }, "Thread 2");

        thread1.start();
        thread2.start();

        try {

            thread1.join();
            thread2.join();

        } catch (InterruptedException e) {

            Thread.currentThread().interrupt();
        }

        System.out.println("\nFinal Balances:");

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