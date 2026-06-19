// Create a grade calculator using else-if conditions. //

import java.util.Scanner;

public class Task8 {

    public static void main(String[]args){

        Scanner input = new Scanner(System.in);

        System.out.print("What is your exam marks : ");

        int marks = input.nextInt();

        if (marks >= 75 && marks <= 100) {
            System.out.println("Grade: A");
        }

        else if (marks >= 65 && marks < 75) {
            System.out.println("Grade: B");
        }

        else if (marks >=50 && marks < 65) {
            System.out.println("Grade: C");
        }

        else if (marks >=35 && marks < 50) {
            System.out.println("Grade: S");
        }

        else if (marks >= 0 && marks < 35) {
            System.out.println("Grade: W");
        }

        else {
            System.out.println("Invalid Marks! Please enter between 0 and 100.");
        }

        input.close();
    }   
}