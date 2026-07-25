import java.util.Scanner;

public class Task08 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter a string: ");
        String text = input.nextLine();
        
        String result = "";
        
        for (int i = 0; i < text.length(); i++) {
            char current = text.charAt(i);
            
            if (result.indexOf(current) == -1) {
                result = result + current;
            }
        }
        
        System.out.println("String after removing duplicates: " + result);
        input.close();
    }
}