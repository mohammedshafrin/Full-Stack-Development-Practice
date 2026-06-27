import java.util.Scanner;

public class Task10 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter a sentence: ");
        String sentence = input.nextLine();
        
        String[] words = sentence.split(" ");
        String longestWord = "";
        
        for (int i = 0; i < words.length; i++) {

            if (words[i].length() > longestWord.length()) {
                longestWord = words[i];
            }
        }
        
        System.out.println("The longest word in the sentence is: " + longestWord);
        System.out.println("Length of the word: " + longestWord.length());
        input.close();
    }
}