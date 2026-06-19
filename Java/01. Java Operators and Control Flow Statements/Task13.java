// Create a program to find the smallest among three numbers. //

import java.util.Scanner;

public class Task13 {

    public static void main(String []args) {

        Scanner input = new Scanner( System.in);

        System.out.print("Enter the number : ");
        int A = input.nextInt();

        System.out.print("Enter the number : ");
        int B = input.nextInt();

        System.out.print("Enter the number : ");
        int C = input.nextInt();


        if ( A < B && A < C ) {
            System.out.println( A + " is smallest");
        }

        else if ( B < C ) {
            System.out.println( B + " is smallest");
        }

        else {
            System.out.println( C + " is smallest");
        }

        input.close();
    }
}