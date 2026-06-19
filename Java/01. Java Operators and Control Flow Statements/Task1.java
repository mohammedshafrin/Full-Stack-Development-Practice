// Create a program to perform addition, subtraction, multiplication, and division of two numbers. //

import java.util.Scanner;

public class Task1 {

    public static void main(String[]args){
        
        Scanner input = new Scanner(System.in);

        System.out.println("Enter the first number :");
        int number1 = input.nextInt();

        System.out.println("Enter second number : ");
        int number2 = input.nextInt();

        int addition = number1 + number2;
        int subtraction = number1 - number2 ; 
        int multiplication = number1  * number2; 
        int division = number1 / number2;

        System.out.println("Addition : " + addition);
        System.out.println("Subtraction : " + subtraction);
        System.out.println("Multiplication : " + multiplication);
        System.out.println("Division : " + division);

        input.close();

    }

}