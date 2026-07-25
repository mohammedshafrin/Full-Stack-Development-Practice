public class BankAccount {
    private String accountNumber;     
    private String accountHolderName; 
    private double balance;            

    public BankAccount(String accNum, String name, double bal) {
        this.accountNumber = accNum;
        this.accountHolderName = name;
        this.balance = bal;
    }

    public void withdraw(double amount) throws InsufficientBalanceException {

        if (amount > balance) {

            throw new InsufficientBalanceException("Transaction Failed: Amount " 
                  + amount + " exceeds balance of " + balance);
        } else {
            balance -= amount; 
            System.out.println("Withdrawal Successful! Amount: " + amount);
            System.out.println("Remaining Balance: " + balance); 
        }
    }
}