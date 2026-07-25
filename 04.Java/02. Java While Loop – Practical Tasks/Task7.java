import java.util.Scanner;

public class Task7 {
    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter a number to find its factorial: ");
        int number = input.nextInt();
        
        long factorial = 1; 
        
        int i = 1; 
        
        if (number < 0) {
            System.out.println("Factorial is not defined for negative numbers.");
        } else {
           
            while (i <= number) {
                factorial = factorial * i; 
                i++; 
            }
            
           
            System.out.println("The factorial of " + number + " is: " + factorial);
        }
        
        input.close(); 
    }
}
