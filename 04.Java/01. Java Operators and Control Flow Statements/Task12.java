// Create a program to check whether a number is divisible by both 3 and 5. // 

import java.util.Scanner;

public class Task12 { 

    public static void main(String[]args) {

        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter the number : ");
        int number = input.nextInt();

        if ( number % 3 == 0 && number % 5 == 0 ) {
            System.out.println(number + " Divisible by both");
        }

        else {
            System.out.println(number + " Not divisible by both");
        }

        input.close();
    }
}