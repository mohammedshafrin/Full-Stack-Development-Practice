// Check whether a number is Armstrong (use while loop).

import java.util.Scanner;

public class Task11{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter a number to check Armstrong: ");
        int number = input.nextInt();
        
        int originalNumber = number;
        int temp = number;
        int digitsCount = 0;
        int sum = 0;

        while (temp > 0) {
            digitsCount++;
            temp = temp / 10;
        }
        
        temp = number;
        
        while (temp > 0) {
            int lastDigit = temp % 10;
            
            sum = sum + (int) Math.pow(lastDigit, digitsCount);
            
            temp = temp / 10;
        }
        
        if (sum == originalNumber) {
            System.out.println(originalNumber + " is an Armstrong number.");
        } else {
            System.out.println(originalNumber + " is NOT an Armstrong number.");
        }
        
        input.close();
    }
}