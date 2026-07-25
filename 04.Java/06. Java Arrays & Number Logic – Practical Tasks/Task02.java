import java.util.Scanner;

public class Task02 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter a string to check Palindrome: ");
        String text = input.nextLine();
        
        // கேஸ் சென்சிட்டிவ் சிக்கலைத் தவிர்க்க முழுவதையும் சிறிய எழுத்தாக மாற்றுகிறோம்
        String cleanText = text.toLowerCase();
        
        int start = 0;
        int end = cleanText.length() - 1;
        boolean isPalindrome = true;
        
        while (start < end) {
            if (cleanText.charAt(start) != cleanText.charAt(end)) {
                isPalindrome = false;
                break;
            }
            start++;
            end--;
        }
        
        if (isPalindrome) {
            System.out.println("'" + text + "' is a Palindrome string.");
        } else {
            System.out.println("'" + text + "' is NOT a Palindrome string.");
        }
        input.close();
    }
}