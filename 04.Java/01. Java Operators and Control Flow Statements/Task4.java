// Create a program to check whether a person is eligible for voting. //

import java.util .Scanner;

public class Task4 {

    public static void main(String[]args){
        // sacnner create //
        Scanner input = new Scanner(System.in);

        System.out.print("What is your age :");

        int age = input.nextInt();

        if ( age>= 18 ){
            System.out.println("Eligible for voting");
        }

        else {
            System.out.println("Sorry not Eligible");
        }

        input.close();
    }
}