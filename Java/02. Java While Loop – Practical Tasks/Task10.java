import java.util.Scanner;

public class Task10 {
    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);
        int choice = 0;
        
        while (choice != 5) {
            
            System.out.println("\n--- MENU-DRIVEN CALCULATOR ---");
            System.out.println("1. Addition (+)");
            System.out.println("2. Subtraction (-)");
            System.out.println("3. Multiplication (*)");
            System.out.println("4. Division (/)");
            System.out.println("5. Exit");
            System.out.print("Enter your choice (1-5): ");
            
            choice = input.nextInt();
            
            if (choice == 5) {
                System.out.println("Exiting the calculator. Thank you!");
                break;
            }
            
            if (choice < 1 || choice > 5) {
                System.out.println("Invalid choice! Please select a valid option between 1 and 5.");
                continue;
            }
            
            System.out.print("Enter first number: ");
            double number1 = input.nextDouble();
            System.out.print("Enter second number: ");
            double number2 = input.nextDouble();
            
            if (choice == 1) {
                double result = number1 + number2;
                System.out.println("Result: " + number1 + " + " + number2 + " = " + result);
            } 
            else if (choice == 2) {
                double result = number1 - number2;
                System.out.println("Result: " + number1 + " - " + number2 + " = " + result);
            } 
            else if (choice == 3) {
                double result = number1 * number2;
                System.out.println("Result: " + number1 + " * " + number2 + " = " + result);
            } 
            else if (choice == 4) {

                if (number2 == 0) {
                    System.out.println("Error: Division by zero is not allowed.");
                } else {
                    double result = number1 / number2;
                    System.out.println("Result: " + number1 + " / " + number2 + " = " + result);
                }
            }
        }
        
        input.close(); 
    }
}