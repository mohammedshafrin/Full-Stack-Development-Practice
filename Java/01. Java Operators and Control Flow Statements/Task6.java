// Create a program to check whether a student is pass or fail based on marks. //

import java.util.Scanner;

public class Task6 {

    public static void main(String[]args) {

        Scanner input = new Scanner(System.in);
        System.out.print("Enter your marks : ");

        int a = input.nextInt();

        if ( a > 50) {
            System.out.println("Your Pass");
        }

        else {
            System.out.println("Your Fail");
        }

        input.close();
    }
}