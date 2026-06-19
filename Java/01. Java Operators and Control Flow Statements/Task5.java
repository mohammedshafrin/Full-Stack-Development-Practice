// Create a program to check whether a number is positive, negative, or zero. //

import java.util.Scanner;

public class Task5 {

    public static void main(String[]args) {

        Scanner input = new Scanner(System.in);
        System.out.print("Enter anty number : ");

        int number = input.nextInt();

        if (number > 0) {
            System.out.println("Positive number");
        }

        else if (number < 0) {
            System.out.println("Negative number");
        }

        else {
            System.out.println("Zero");
        }

        input.close();
    }
}
                    