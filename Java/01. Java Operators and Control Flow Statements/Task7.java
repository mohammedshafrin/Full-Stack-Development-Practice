// Create a program to find the bigger number using if-else. //

import java.util.Scanner;

public class Task7 {

    public static void main (String[]args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter the first number : ");
        int number1 = input.nextInt();

        System.out.print("Enter the Second number : ");
        int number2 = input.nextInt();

        if ( number1 > number2 ) {
            System.out.println("Biggest number is : " + number1);
        }

        else {
            System.out.println("Biggest number is : " + number2);
        }
        
        input.close();
    }

}