import java.util.Scanner;

public class Task11 {
    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter a character: ");
        char ch = input.next().charAt(0);
        
        if ((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z')) {
            
            switch (ch) {

                case 'a': case 'e': case 'i': case 'o': case 'u':
                case 'A': case 'E': case 'I': case 'O': case 'A' + 20:
                    System.out.println(ch + " is a Vowel.");
                    break;
                    

                default:
                    System.out.println(ch + " is a Consonant.");
                    break;
            }
            
        } else {

            System.out.println("Error: Input is not a valid English alphabet.");
        }
        
        input.close(); 
    }
}