import java.util.Scanner;

public class Task04ThrowThrows {
    public static void checkPositive(int number) throws Exception {
        if (number < 0) {
            throw new Exception("Number is negative!");
        } else {
            System.out.println("Number is positive: " + number);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int num = scanner.nextInt();
        
        try {
            checkPositive(num);
        } catch (Exception e) {
            System.out.println("Caught Exception: " + e.getMessage());
        }
        scanner.close();
    }
}