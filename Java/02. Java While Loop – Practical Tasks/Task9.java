import java.util.Scanner;

public class Task9 {
    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter the number of terms for Fibonacci series: ");
        int terms = input.nextInt();
        
        int firstTerm = 0;
        int secondTerm = 1;
        
        int count = 1;
        
        System.out.println("--- Fibonacci Series up to " + terms + " terms ---");
        
        while (count <= terms) {
            
            System.out.print(firstTerm + " ");
            
            int nextTerm = firstTerm + secondTerm;
            
            firstTerm = secondTerm;
            secondTerm = nextTerm;
            
            count++;
        }
        
        System.out.println(); 
        input.close();
    }
}