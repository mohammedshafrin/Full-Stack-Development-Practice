import java.util.Scanner;

public class Task09 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter a sentence: ");
        String sentence = input.nextLine();

        String[] words = sentence.split(" ");
        String reversedSentence = "";

        for (int i = words.length - 1; i >= 0; i--) {
            reversedSentence = reversedSentence + words[i];
            if (i != 0) {
                reversedSentence = reversedSentence + " ";
            }
        }
        
        System.out.println("Reversed words sentence: " + reversedSentence);
        input.close();
    }
}