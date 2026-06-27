import java.util.Scanner;

public class Task05 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter a string: ");
        String text = input.nextLine();
        
        char[] charArray = text.toCharArray();
        System.out.println("Duplicate characters and their counts:");
        
        for (int i = 0; i < charArray.length; i++) {
            int count = 1;
            
            if (charArray[i] == ' ' || charArray[i] == '0') {
                continue;
            }
            
            for (int j = i + 1; j < charArray.length; j++) {
                if (charArray[i] == charArray[j]) {
                    count++;
                    charArray[j] = '0';
                }
            }
            
            if (count > 1) {
                System.out.println(charArray[i] + " : " + count + " times");
            }
        }
        input.close();
    }
}