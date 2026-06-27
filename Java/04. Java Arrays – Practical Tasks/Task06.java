// Search for a specific element in an array.


import java.util.Scanner;

public class Task06 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] numbers = {12, 45, 67, 89, 23};
        
        System.out.print("Enter the number to search: ");
        int target = input.nextInt();
        
        boolean isFound = false;

        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == target) {
                isFound = true;
                break;
            }
        }

        if (isFound) {
            System.out.println(target + " is found in the array.");
        } else {
            System.out.println(target + " is NOT found in the array.");
        }
        input.close();
    }
}