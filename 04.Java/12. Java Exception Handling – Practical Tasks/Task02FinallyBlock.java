import java.util.Scanner;

public class Task02FinallyBlock {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Enter two numbers to divide: ");
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            System.out.println("Result: " + (a / b));
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        } finally {
            System.out.println("Program execution completed");
            scanner.close();
        }
    }
}