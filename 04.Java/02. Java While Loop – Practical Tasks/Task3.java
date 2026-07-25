import java.util.Scanner;

public class Task3{

    public static void main (String[]args){

        Scanner input = new Scanner(System.in);

        System.out.print("Enter the limit number (n): ");
        int maxNumber = input.nextInt();

        int sum = 0;
        int i = 1;

        while(i <= maxNumber) {

            if ( i % 2 == 0 ){
                sum = sum + i;
            }
            
            i++;
        }
        
        System.out.println("The sum of all even numbers from 1 to " + maxNumber + " is: " + sum);
    }
}