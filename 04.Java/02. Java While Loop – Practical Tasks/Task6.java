import java.util.Scanner;

public class Task6 {
    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter a number: ");
        int number = input.nextInt();
        
        int originalNumber = number; 
        int count = 0;

        if (number == 0) {
            count = 1;
        } else {

            while (number > 0) {

                number = number / 10;
                
                count++;
            }
        }
        
        System.out.println("The number of digits in " + originalNumber + " is: " + count);
        
        input.close();
    }
}