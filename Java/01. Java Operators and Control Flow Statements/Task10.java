import java.util.Scanner;

public class Task10 {
    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter first number: ");
        double firstNumber = input.nextDouble();
        
        System.out.print("Enter second number: ");
        double secondNumber = input.nextDouble();
        
        System.out.print("Enter an operator (+, -, *, /): ");
        char operator = input.next().charAt(0);
        
        double result;
        
        switch (operator) {
            case '+':
                result = firstNumber + secondNumber;
                System.out.println("Result: " + firstNumber + " + " + secondNumber + " = " + result);
                break;
                
            case '-':
                result = firstNumber - secondNumber;
                System.out.println("Result: " + firstNumber + " - " + secondNumber + " = " + result);
                break;
                
            case '*':
                result = firstNumber * secondNumber;
                System.out.println("Result: " + firstNumber + " * " + secondNumber + " = " + result);
                break;
                
            case '/':

                if (secondNumber == 0) {
                    System.out.println("Error: Division by zero is not allowed.");
                } else {
                    result = firstNumber / secondNumber;
                    System.out.println("Result: " + firstNumber + " / " + secondNumber + " = " + result);
                }
                break;
                
            default:
                System.out.println("Error: Invalid operator! Please use +, -, *, or /.");
                break;
        }
        
        input.close(); // ஸ்கேனரை மூடுதல்
    }
}