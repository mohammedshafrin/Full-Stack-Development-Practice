class BankAccount {

    private String accountNumber;     
    private String accountHolderName;  
    private double balance;            

    public String getAccountNumber() {
        return accountNumber;
    }
    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }


    public String getAccountHolderName() {
        return accountHolderName;
    }
    public void setAccountHolderName(String accountHolderName) {
        this.accountHolderName = accountHolderName;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            this.balance += amount;
            System.out.println("Successfully Deposited: LKR " + amount);
        } else {
            System.out.println("Error: Deposit amount must be positive!");
        }
    }

    public void withdraw(double amount) {

        if (amount > 0 && amount <= this.balance) {
            this.balance -= amount;
            System.out.println("Successfully Withdrawn: LKR " + amount);
        } else if (amount > this.balance) {
            System.out.println("Error: Insufficient funds! Available balance: LKR " + this.balance);
        } else {
            System.out.println("Error: Withdrawal amount must be positive!");
        }
    }

    public void displayAccountDetails() {
        System.out.println("====== Account Details ======");
        System.out.println("Account Number : " + this.accountNumber);
        System.out.println("Account Holder : " + this.accountHolderName);
        System.out.println("Current Balance: LKR " + this.balance);
        System.out.println("=============================");
    }
}

public class BankTask {
    public static void main(String[] args) {

        BankAccount myAccount = new BankAccount();

        myAccount.setAccountNumber("BK20269874");
        myAccount.setAccountHolderName("Mohamed Akmal");

        System.out.println("--- Initializing Account ---");
        myAccount.displayAccountDetails();
        System.out.println();

        myAccount.deposit(5000.0);
        System.out.println("Current Balance: LKR " + myAccount.getBalance() + "\n");

        myAccount.withdraw(2000.0);
        System.out.println("Current Balance: LKR " + myAccount.getBalance() + "\n");

        System.out.println("--- Final Updated Status ---");
        myAccount.displayAccountDetails();
    }
}