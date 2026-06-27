import java.util.Scanner;

public class Task04 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter a string: ");
        String text = input.nextLine();
        
        char result = ' ';
        boolean found = false;
        
        for (int i = 0; i < text.length(); i++) {
            char current = text.charAt(i);
            boolean isRepeated = false;

            for (int j = 0; j < text.length(); j++) {
                if (i != j && current == text.charAt(j)) {
                    isRepeated = true;
                    break;
                }
            }
            
            if (!isRepeated) {
                result = current;
                found = true;
                break;
            }
        }
        
        if (found) {
            System.out.println("The first non-repeated character is: " + result);
        } else {
            System.out.println("All characters are repeated or string is empty.");
        }
        input.close();
    }
}