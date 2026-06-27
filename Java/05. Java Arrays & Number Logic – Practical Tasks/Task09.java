// Check whether a number is Prime

import java.util.Scanner;

public class Task09{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter a number to check Prime: ");
        int number = input.nextInt();
        
        boolean isPrime = true;

        if (number <= 1) {
            isPrime = false;
        } else {

            for (int i = 2; i <= number / 2; i++) {
                if (number % i == 0) {
                    isPrime = false;
                    break;
                }
            }
        }
        
        if (isPrime) {
            System.out.println(number + " is a Prime number.");
        } else {
            System.out.println(number + " is NOT a Prime number.");
        }
        
        input.close();
    }
}