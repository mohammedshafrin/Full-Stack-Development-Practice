import java.util.Scanner;

public class Arithmetic {

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

        System.out.println("addition : " + addition);
        System.out.println("subtraction : " + subtraction);
        System.out.println("multiplication : " + multiplication);
        System.out.println("division : " + division);

        input.close();

    }

}