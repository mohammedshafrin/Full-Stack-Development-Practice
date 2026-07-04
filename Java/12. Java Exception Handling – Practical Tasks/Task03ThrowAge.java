import java.util.Scanner;

public class Task03ThrowAge {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your age: ");
        int age = scanner.nextInt();
        
        if (age < 18) {
            throw new ArithmeticException("Access Denied: Age must be 18 or above.");
        } else {
            System.out.println("Access Granted: Welcome!");
        }
        scanner.close();
    }
}