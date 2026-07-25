import java.util.Scanner;

public class BankingSystem {
    public static void main(String[] args) {
        BankAccount account = new BankAccount("BK12345", "Mohamed Akmal", 5000.0); // [cite: 448, 449]
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter withdrawal amount: "); // [cite: 450]
        double amount = scanner.nextDouble();

        try {
            account.withdraw(amount); // [cite: 451]
        } catch (InsufficientBalanceException e) {
            // முறையான பிழைச் செய்தி [cite: 440, 452]
            System.out.println("Error: " + e.getMessage());
        } finally {
            scanner.close(); // [cite: 441]
        }
    }
}