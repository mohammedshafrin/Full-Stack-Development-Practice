import java.util.Arrays;
import java.util.Scanner;

public class Task06 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter first string: ");
        String str1 = input.nextLine();
        System.out.print("Enter second string: ");
        String str2 = input.nextLine();
        
        str1 = str1.replaceAll("\\s", "").toLowerCase();
        str2 = str2.replaceAll("\\s", "").toLowerCase();
        
        boolean isAnagram = true;
        
        if (str1.length() != str2.length()) {
            isAnagram = false;
        } else {

            char[] array1 = str1.toCharArray();
            char[] array2 = str2.toCharArray();
            
            Arrays.sort(array1);
            Arrays.sort(array2);
            

            isAnagram = Arrays.equals(array1, array2);
        }
        
        if (isAnagram) {
            System.out.println("The given strings are Anagrams.");
        } else {
            System.out.println("The given strings are NOT Anagrams.");
        }
        input.close();
    }
}