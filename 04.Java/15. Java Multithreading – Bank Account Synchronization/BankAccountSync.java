class BankAccount {
    private double balance = 1000.0;

    public synchronized void deposit(double amount) {
        balance += amount;
        System.out.println(Thread.currentThread().getName() + " deposited: " + amount + " | Balance: " + balance);
    }

    public synchronized void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println(Thread.currentThread().getName() + " withdrew: " + amount + " | Balance: " + balance);
        } else {
            System.out.println(Thread.currentThread().getName() + " failed: Insufficient balance!");
        }
    }

    public double getBalance() {
        return balance;
    }
}

class TransactionTask implements Runnable {
    private BankAccount account;
    private boolean isDeposit;

    public TransactionTask(BankAccount account, boolean isDeposit) {
        this.account = account;
        this.isDeposit = isDeposit;
    }

    @Override
    public void run() {
        if (isDeposit) {
            account.deposit(500.0);
        } else {
            account.withdraw(800.0);
        }
    }
}

public class BankAccountSync {
    public static void main(String[] args) {
        BankAccount myAccount = new BankAccount();

        Thread t1 = new Thread(new TransactionTask(myAccount, true), "User-1");
        Thread t2 = new Thread(new TransactionTask(myAccount, false), "User-2");
        Thread t3 = new Thread(new TransactionTask(myAccount, true), "User-3");
        Thread t4 = new Thread(new TransactionTask(myAccount, false), "User-4");

        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}