import java.util.Scanner;

public class Task4 {
    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter the number for the multiplication table: ");
        int tableNumber = input.nextInt();
        
        int multiplier = 1;
        
        System.out.println("--- Multiplication Table of " + tableNumber + " ---");
        
        while (multiplier <= 12) {
            
            int product = tableNumber * multiplier;
            
            System.out.println(tableNumber + " x " + multiplier + " = " + product);
            
            multiplier++;
        }
        
        input.close();
    }
}